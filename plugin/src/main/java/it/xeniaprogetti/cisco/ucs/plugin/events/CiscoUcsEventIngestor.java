package it.xeniaprogetti.cisco.ucs.plugin.events;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEntity;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsFault;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import it.xeniaprogetti.cisco.ucs.plugin.requisition.CiscoUcsRequisitionProvider;
import org.opennms.integration.api.v1.config.events.AlarmType;
import org.opennms.integration.api.v1.dao.AlarmDao;
import org.opennms.integration.api.v1.dao.NodeDao;
import org.opennms.integration.api.v1.events.EventForwarder;
import org.opennms.integration.api.v1.health.Context;
import org.opennms.integration.api.v1.health.HealthCheck;
import org.opennms.integration.api.v1.health.Response;
import org.opennms.integration.api.v1.health.Status;
import org.opennms.integration.api.v1.health.immutables.ImmutableResponse;
import org.opennms.integration.api.v1.model.Alarm;
import org.opennms.integration.api.v1.model.MetaData;
import org.opennms.integration.api.v1.model.Node;
import org.opennms.integration.api.v1.model.Severity;
import org.opennms.integration.api.v1.model.immutables.ImmutableEventParameter;
import org.opennms.integration.api.v1.model.immutables.ImmutableInMemoryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CiscoUcsEventIngestor implements Runnable, HealthCheck {
    private static final Logger LOG = LoggerFactory.getLogger(CiscoUcsEventIngestor.class);

    public static final String CISCO_UCS_ALARM_UEI = "uei.opennms.org/plugin/cisco/ucs/fault";
    public static final String CISCO_UCS_ALARM_RESOLVED_UEI = "uei.opennms.org/plugin/cisco/ucs/faultResolved";

    private final static Map<String, Severity> SEVERITY_MAP = ImmutableMap.<String, Severity>builder()
            .put("critical", Severity.MAJOR)
            .put("warning", Severity.MINOR)
            .put("informational", Severity.WARNING)
            .put("audit", Severity.NORMAL)
            .build();

    private final ConnectionManager connectionManager;
    private final ClientManager clientManager;

    private final NodeDao nodeDao;
    private final AlarmDao alarmDao;

    private final EventForwarder eventForwarder;

    private Instant lastPoll = null;

    private ScheduledFuture<?> scheduledFuture;

    private final long delay;

    private final int retrieve_days;

    private static class RequisitionIdentifier {
        private final String foreignSource;
        private final String dn;
        private final String alias;

        private final UcsEntity.ClassId type;

        public RequisitionIdentifier(final Node n) {
            final Map<String, String> map = n.getMetaData().stream()
                    .filter(metaData -> Objects.equals(metaData.getContext(), CiscoUcsRequisitionProvider.CISCO_UCS_METADATA_CONTEXT))
                    .collect(Collectors.toMap(MetaData::getKey, MetaData::getValue));
            foreignSource = Objects.requireNonNull(n.getForeignSource());
            dn = Objects.requireNonNull(map.get("dn"));
            alias = Objects.requireNonNull(map.get("alias"));
            type = Objects.requireNonNull(UcsEntity.ClassId.valueOf(map.get("type")));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RequisitionIdentifier requisitionIdentifier = (RequisitionIdentifier) o;
            return Objects.equals(foreignSource, requisitionIdentifier.foreignSource)
                    && Objects.equals(dn, requisitionIdentifier.dn)
                    && Objects.equals(type, requisitionIdentifier.type)
                    && Objects.equals(alias, requisitionIdentifier.alias);
        }

        @Override
        public int hashCode() {
            return Objects.hash(foreignSource, dn, type, alias);
        }
    }

    public CiscoUcsEventIngestor(final ConnectionManager connectionManager,
                                 final ClientManager clientManager,
                                 final NodeDao nodeDao,
                                 final AlarmDao alarmDao,
                                 final EventForwarder eventForwarder,
                                 final long delay,
                                 final int retrieve_days) {
        this.connectionManager = Objects.requireNonNull(connectionManager);
        this.clientManager = Objects.requireNonNull(clientManager);
        this.nodeDao = Objects.requireNonNull(nodeDao);
        this.alarmDao = Objects.requireNonNull(alarmDao);
        this.eventForwarder = Objects.requireNonNull(eventForwarder);
        this.delay = delay;
        this.retrieve_days = retrieve_days;

        LOG.debug("Cisco UCS Event Ingestor is initializing (delay = {}ms).", delay);
        LOG.debug("Cisco UCS Event Ingestor is initializing (days = {}).", retrieve_days);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, this.delay, this.delay, TimeUnit.MILLISECONDS);
    }

    public void destroy() {
        LOG.debug("Cisco UCS Event Ingestor is shutting down.");
        scheduledFuture.cancel(false);
        scheduledFuture = null;
    }

    private ApiClientService client(String alias) throws ApiException {
        var connection =  connectionManager.getConnection(alias);
        if (connection.isEmpty()) {
            throw new ApiException("No connection for alias", new NullPointerException("No connection found for "+ alias));
        }
        return clientManager.getClient(connection.get());
    }

    @Override
    public void run() {
        LOG.debug("run: getting events...");

        final Instant now = Instant.now();

        if (lastPoll == null) {
            lastPoll = now.minus(delay, ChronoUnit.MILLIS);
        }

        final Set<RequisitionIdentifier> requisitionIdentifiers = nodeDao.getNodes().stream()
                .filter(node -> node.getMetaData().stream()
                    .anyMatch(metaData -> Objects.equals(CiscoUcsRequisitionProvider.CISCO_UCS_METADATA_CONTEXT, metaData.getContext())))
                .map(RequisitionIdentifier::new)
                .collect(Collectors.toSet());

        Map<String, Set<RequisitionIdentifier>> uuidMap = new HashMap<>();
        for (RequisitionIdentifier ri : requisitionIdentifiers) {
            if (!uuidMap.containsKey(ri.dn)) {
                uuidMap.put(ri.dn, new HashSet<>());
            }
            uuidMap.get(ri.dn).add(ri);
        }

        Map<String, AlarmType> ntxAlarms =
                alarmDao.getAlarms().stream()
                        .filter(a -> a.getReductionKey().startsWith(CISCO_UCS_ALARM_UEI+":"))
                        .collect(Collectors.toMap(a->a.getReductionKey().substring(a.getReductionKey().lastIndexOf(":")+1),
                                Alarm::getType));
        LOG.info("run: found {} Cisco UCS alarm on opennms", ntxAlarms.size());
        for(final String alias : requisitionIdentifiers.stream().map(ri -> ri.alias).collect(Collectors.toSet())) {
            try {
                LOG.info("run: process alert for alias: {}", alias);
                processAlerts(client(alias).getFaults(), uuidMap, ntxAlarms);
            } catch (ApiException e) {
                LOG.error("Cannot process alarms for alias='{}'. {}", alias, e.getMessage(),e);
            }
        }

        // interval start and end is inclusive
        lastPoll = now.plus(1, ChronoUnit.MILLIS);
        LOG.debug("run: events got");
    }

    private void processAlerts(final List<UcsFault> alerts, final Map<String, Set<RequisitionIdentifier>> uuidMap, Map<String,AlarmType> ntxAlarms) {
        int processed = 0;
        int resolved = 0;
        int ignored = 0;
        assert alerts != null;
        OffsetDateTime before = OffsetDateTime.now().minusDays(retrieve_days);

        for (final UcsFault alert : alerts) {
            if (alert.created.isBefore(before)) {
                continue;
            }
            if (alert.isResolved && ntxAlarms.containsKey(alert.uuid) && ntxAlarms.get(alert.uuid).equals(AlarmType.PROBLEM)) {
                processAlert(alert, Cisco UCS_ALARM_RESOLVED_UEI, uuidMap);
                resolved++;
            } else if (!alert.isResolved && !ntxAlarms.containsKey(alert.uuid)){
                processAlert(alert, Cisco UCS_ALARM_UEI, uuidMap);
                processed++;
            } else if (!alert.isResolved && ntxAlarms.containsKey(alert.uuid) && ntxAlarms.get(alert.uuid).equals(AlarmType.RESOLUTION)){
                processAlert(alert, Cisco UCS_ALARM_UEI, uuidMap);
                processed++;
            } else {
                ignored++;
            }
        }
        LOG.info("{} event raised, {} event resolved, {} events ignored.", processed, resolved, ignored);

    }
    private void processAlert(final Alert alert, final String uei, final Map<String, Set<RequisitionIdentifier>> uuidMap) {
        alert.affectedEntities.forEach( entity -> {
            if (uuidMap.containsKey(entity.uuid)) {
                uuidMap.get(entity.uuid).forEach(ri -> processAlertEntity(ri, alert,entity, uei));
            }
        });

    }
    private void processAlertEntity(final RequisitionIdentifier ri, final Alert alert, final Entity entity, final String uei) {
        final Node node = nodeDao.getNodeByCriteria(ri.foreignSource + ":" + ri.dn);

        if (node == null) {
            LOG.warn("Ignoring proxy event #{} since node {} cannot be found.", alert.getClass(), ri.foreignSource + ":" + ri.dn);
            return;
        }

        Severity severity = SEVERITY_MAP.get(alert.severity);
        if (alert.isResolved) {
            severity = Severity.NORMAL;
        }
        final ImmutableInMemoryEvent.Builder builder = ImmutableInMemoryEvent.newBuilder()
                .setUei(uei)
                .setSource(Cisco UCSEventIngestor.class.getCanonicalName())
                .setNodeId(node.getId())
                .setSeverity(severity)
                .setInterface(null);

        builder.addParameter(ImmutableEventParameter.newInstance("msg", alert.message));
        builder.addParameter(ImmutableEventParameter.newInstance("reductionKey", alert.uuid));
        builder.addParameter(ImmutableEventParameter.newInstance("descr", alert.descr));
        builder.addParameter(ImmutableEventParameter.newInstance("severity", alert.severity));
        builder.addParameter(ImmutableEventParameter.newInstance("alertType", alert.alertType));
        builder.addParameter(ImmutableEventParameter.newInstance("alertUuid", alert.uuid));
        builder.addParameter(ImmutableEventParameter.newInstance("entityType", String.valueOf(entity.type)));
        builder.addParameter(ImmutableEventParameter.newInstance("entityUuid", entity.uuid));
        builder.addParameter(ImmutableEventParameter.newInstance("entityName", entity.name));
        builder.setTime(Date.from(alert.creationTime.toInstant()));

        eventForwarder.sendSync(builder.build());
    }
    @Override
    public String getDescription() {
        return "Cisco UCS Event Ingestor";
    }

    @Override
    public Response perform(Context context) {
        return ImmutableResponse.newBuilder()
                .setStatus(scheduledFuture.isDone() ? Status.Failure : Status.Success)
                .setMessage(scheduledFuture.isDone() ? "Not running" : "Running")
                .build();
    }
}
