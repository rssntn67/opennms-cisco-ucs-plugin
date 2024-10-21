package it.xeniaprogetti.cisco.ucs.plugin.events;

import com.google.common.collect.ImmutableMap;
import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDnComparator;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsFault;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    private final static Map<UcsFault.Severity, Severity> SEVERITY_MAP = ImmutableMap.<UcsFault.Severity, Severity>builder()
            .put(UcsFault.Severity.cleared, Severity.CLEARED)
            .put(UcsFault.Severity.condition, Severity.INDETERMINATE)
            .put(UcsFault.Severity.info, Severity.NORMAL)
            .put(UcsFault.Severity.warning, Severity.WARNING)
            .put(UcsFault.Severity.minor, Severity.MINOR)
            .put(UcsFault.Severity.major, Severity.MAJOR)
            .put(UcsFault.Severity.critical, Severity.CRITICAL)
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
        private final String foreignId;
        private final String dn;
        private String fabricLanDn;
        private String fabricSanDn;
        private final String alias;

        private final UcsEnums.ClassId type;

        public RequisitionIdentifier(final Node n) {
            final Map<String, String> map = n.getMetaData().stream()
                    .filter(metaData -> Objects.equals(metaData.getContext(), CiscoUcsRequisitionProvider.CISCO_UCS_METADATA_CONTEXT))
                    .collect(Collectors.toMap(MetaData::getKey, MetaData::getValue));
            foreignSource = Objects.requireNonNull(n.getForeignSource());
            foreignId = Objects.requireNonNull(n.getForeignId());
            dn = Objects.requireNonNull(map.get(UcsUtils.UCS_DN_KEY));
            alias = Objects.requireNonNull(map.get("alias"));
            type = Objects.requireNonNull(UcsEnums.ClassId.valueOf(map.get("type")));
            if (type == UcsEnums.ClassId.networkElement) {
                fabricLanDn = map.get(UcsUtils.UCS_FABRIC_LAN_KEY);
                fabricSanDn = map.get(UcsUtils.UCS_FABRIC_SAN_KEY);
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RequisitionIdentifier requisitionIdentifier = (RequisitionIdentifier) o;
            return Objects.equals(foreignSource, requisitionIdentifier.foreignSource)
                    && Objects.equals(foreignId, requisitionIdentifier.foreignId)
                    && Objects.equals(dn, requisitionIdentifier.dn)
                    && Objects.equals(type, requisitionIdentifier.type)
                    && Objects.equals(alias, requisitionIdentifier.alias);
        }

        @Override
        public int hashCode() {
            return Objects.hash(foreignSource, foreignId, dn, type, alias);
        }

        @Override
        public String toString() {
            return "RequisitionIdentifier{" +
                    "foreignSource='" + foreignSource + '\'' +
                    "foreignId='" + foreignId + '\'' +
                    ", dn='" + dn + '\'' +
                    ", fabricLanDn='" + fabricLanDn + '\'' +
                    ", fabricSanDn='" + fabricSanDn + '\'' +
                    ", alias='" + alias + '\'' +
                    ", type=" + type +
                    '}';
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

        LOG.debug("Cisco UCS Event Ingestor initializing (delay = {}ms).", delay);
        LOG.debug("Cisco UCS Event Ingestor initializing (retrieve_days = {}).", retrieve_days);
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
            LOG.error("client: No connection available for alias {}", alias);
            throw new ApiException("No connection for alias", new NullPointerException("No connection found for "+ alias));
        }
        return clientManager.getClientService(connection.get());
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

        Map<String, Map<UcsDn, RequisitionIdentifier>> dnMap = new HashMap<>();
        for (RequisitionIdentifier ri : requisitionIdentifiers) {
            LOG.debug("run: parsing {}", ri);
            if (!dnMap.containsKey(ri.alias)) {
                LOG.debug("run: creating map for {}", ri.alias);
                dnMap.put(ri.alias, new HashMap<>());
            }
            LOG.debug("run: adding dn for {} map for {}",ri.dn, ri.alias);
            dnMap.get(ri.alias).put(UcsDn.getDn(ri.dn),ri);
            if (ri.fabricSanDn != null) {
                LOG.debug("run: adding fabricSanDn {} map for {}",ri.dn, ri.alias);
                dnMap.get(ri.alias).put(UcsDn.getDn(ri.fabricSanDn),ri);
            }
            if (ri.fabricLanDn != null) {
                LOG.debug("run: adding fabricLanDn {} map for {}",ri.dn, ri.alias);
                dnMap.get(ri.alias).put(UcsDn.getDn(ri.fabricLanDn),ri);
            }
        }


        Map<String, AlarmType> ciscoUcsAlarmMap =
                alarmDao.getAlarms().stream()
                        .filter(a -> a.getReductionKey().startsWith(CISCO_UCS_ALARM_UEI+":"))
                        .collect(Collectors.toMap(a->a.getReductionKey().substring(a.getReductionKey().lastIndexOf(":")+1),
                                Alarm::getType));
        LOG.debug("run: alarmMap: {}", ciscoUcsAlarmMap);
        LOG.info("run: found {} Cisco UCS fault on opennms", ciscoUcsAlarmMap.size());
        for(final String alias : requisitionIdentifiers.stream().map(ri -> ri.alias).collect(Collectors.toSet())) {
            ApiClientService service;
            try {
                service = client(alias);
            } catch (ApiException e) {
                continue;
            }
            try {
                LOG.info("run: processing fault for alias: {}", alias);
                processAlerts(
                    service.findUcsFaultsFromDate(OffsetDateTime.now().minusDays(retrieve_days)),
                    dnMap.get(alias),
                    ciscoUcsAlarmMap
                );
            } catch (ApiException e) {
                LOG.error("Cannot process fault for alias='{}'. {}", alias, e.getMessage(),e);
            }
        }

        // interval start and end is inclusive
        lastPoll = now.plus(1, ChronoUnit.MILLIS);
        LOG.debug("run: events got");
    }

    private void processAlerts(final List<UcsFault> ucsFaults, final Map<UcsDn, RequisitionIdentifier> dnMap, Map<String,AlarmType> cucsAlarms) {
        int raised = 0;
        int resolved = 0;
        int ignored = 0;
        assert ucsFaults != null;
        LOG.debug("processAlerts: found {} Fault Instances", ucsFaults.size());

        for (final UcsFault ucsFault : ucsFaults) {
            LOG.debug("processAlerts: {}", ucsFault);
            if (ucsFault.severity == UcsFault.Severity.cleared && cucsAlarms.containsKey(String.valueOf(ucsFault.id)) && cucsAlarms.get(String.valueOf(ucsFault.id)).equals(AlarmType.PROBLEM)) {
                processAlert(ucsFault, CISCO_UCS_ALARM_RESOLVED_UEI, dnMap);
                resolved++;
            } else if (ucsFault.severity != UcsFault.Severity.cleared && !cucsAlarms.containsKey(String.valueOf(ucsFault.id))){
                processAlert(ucsFault, CISCO_UCS_ALARM_UEI, dnMap);
                raised++;
            } else if (ucsFault.severity != UcsFault.Severity.cleared && cucsAlarms.containsKey(String.valueOf(ucsFault.id)) && cucsAlarms.get(String.valueOf(ucsFault.id)).equals(AlarmType.RESOLUTION)){
                processAlert(ucsFault, CISCO_UCS_ALARM_UEI, dnMap);
                raised++;
            } else {
                ignored++;
            }
        }
        LOG.info("processAlerts: {} raised, {} resolved, {} ignored.", raised, resolved, ignored);

    }
    private void processAlert(final UcsFault ucsFault, final String uei, final Map<UcsDn, RequisitionIdentifier> dnMap) {
        List<UcsDn> list = new ArrayList<>(dnMap.keySet());
        list.sort(new UcsDnComparator());
        boolean parsed = false;
        LOG.debug("processAlert: faultDn:{}",ucsFault.dn.value);
        for (UcsDn ucsDn: list ) {
            LOG.debug("processAlert: parsing nodeDn:{}",ucsDn.value);
            if (ucsDn.isParent(ucsFault.dn)) {
                LOG.info("processAlert: nodeDN {} found for faultDn:{}", ucsDn.value, ucsFault.dn.value);
                RequisitionIdentifier ri = dnMap.get(ucsDn);
                LOG.debug("processAlert: found {} for faultDn:{}", ri, ucsFault.dn.value);
                processAlertEntity(ri, ucsFault, uei);
                parsed = true;
                break;
            }
        }
        if (!parsed) {
            LOG.info("no DN found for {}", ucsFault);
        }

    }
    private void processAlertEntity(final RequisitionIdentifier ri, final UcsFault ucsFault, final String uei) {
        final Node node = nodeDao.getNodeByForeignSourceAndForeignId(ri.foreignSource, ri.foreignId);

        if (node == null) {
            LOG.warn("processAlertEntity: Ignoring Ucs Fault event #{} since node {} cannot be found.", ucsFault.dn.value, ri.foreignSource + ":" + ri.foreignId);
            return;
        }
        LOG.debug("processAlertEntity: faultDn: {}, nodeDn:{} nodeId[{}] uei:{}", ucsFault.dn.value, ri.dn, node.getId(), uei);

        Severity severity = SEVERITY_MAP.get(ucsFault.severity);
        if (ucsFault.severity == UcsFault.Severity.cleared) {
            severity = Severity.NORMAL;
        }
        final ImmutableInMemoryEvent.Builder builder = ImmutableInMemoryEvent.newBuilder()
                .setUei(uei)
                .setSource(CiscoUcsEventIngestor.class.getCanonicalName())
                .setNodeId(node.getId())
                .setSeverity(severity)
                .setInterface(null);

        builder.addParameter(
                ImmutableEventParameter.newInstance("ack", ucsFault.ack));
        builder.addParameter(
                ImmutableEventParameter.newInstance("created", ucsFault.created));
        builder.addParameter(
                ImmutableEventParameter.newInstance("reductionKey", String.valueOf(ucsFault.id)));
        builder.addParameter(
                ImmutableEventParameter.newInstance("cause", ucsFault.cause));
        builder.addParameter(
                ImmutableEventParameter.newInstance("lc", ucsFault.lc));
        builder.addParameter(
                ImmutableEventParameter.newInstance("code", ucsFault.code));
        builder.addParameter(
                ImmutableEventParameter.newInstance("changeSet", ucsFault.changeSet));
        builder.addParameter(
                ImmutableEventParameter.newInstance("highestSeverity", ucsFault.highestSeverity.name()));
        builder.addParameter(
                ImmutableEventParameter.newInstance("origSeverity", ucsFault.origSeverity.name()));
        builder.addParameter(
                ImmutableEventParameter.newInstance("prevSeverity", ucsFault.prevSeverity.name()));
        builder.addParameter(
                ImmutableEventParameter.newInstance("descr", ucsFault.descr));
        builder.addParameter(
                ImmutableEventParameter.newInstance("rule", ucsFault.rule));
        builder.addParameter(
                ImmutableEventParameter.newInstance("tags", ucsFault.tags));
        builder.addParameter(
                ImmutableEventParameter.newInstance("type", ucsFault.type.name()));

        LOG.debug("processAlertEntity: lastTransition: {}",ucsFault.lastTransition);

        builder.setTime(Date.from(Instant.parse(ucsFault.lastTransition)));

        ImmutableInMemoryEvent event = builder.build();

        eventForwarder.sendSync(event);
        LOG.debug("processAlertEntity: forwarded: {}", event);
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
