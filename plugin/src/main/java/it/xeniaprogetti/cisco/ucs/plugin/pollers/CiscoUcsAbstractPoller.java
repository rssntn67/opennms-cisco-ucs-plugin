
package it.xeniaprogetti.cisco.ucs.plugin.pollers;

import com.google.common.collect.ImmutableMap;
import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsNetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.pollers.PollerRequest;
import org.opennms.integration.api.v1.pollers.PollerResult;
import org.opennms.integration.api.v1.pollers.ServicePoller;
import org.opennms.integration.api.v1.pollers.ServicePollerFactory;
import org.opennms.integration.api.v1.pollers.Status;
import org.opennms.integration.api.v1.pollers.immutables.ImmutablePollerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public abstract class CiscoUcsAbstractPoller implements ServicePoller {
    private static final Logger LOG = LoggerFactory.getLogger(CiscoUcsAbstractPoller.class);
    private final ClientManager clientManager;
    private final ConnectionManager connectionManager;

    public final static String ALIAS_KEY = "alias";
    public final static String DN_KEY = "dn";
    public final static String TYPE_KEY = "type";

    protected CiscoUcsAbstractPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        this.connectionManager = Objects.requireNonNull(connectionManager);
        this.clientManager = Objects.requireNonNull(clientManager);
    }

    protected abstract PollerResult poll(final UcsComputeBlade computeBlade) throws ApiException;
    protected abstract PollerResult poll(final UcsComputeRackUnit computeRackUnit) throws ApiException;
    protected abstract PollerResult poll(final UcsEquipmentChassis equipmentChassis) throws ApiException;
    protected abstract PollerResult poll(final UcsEquipmentFex equipmentFex) throws ApiException;
    protected abstract PollerResult poll(final UcsEquipmentRackEnclosure equipmentRackEnclosure) throws ApiException;
    protected abstract PollerResult poll(final UcsNetworkElement networkElement) throws ApiException;

    public CompletableFuture<PollerResult> poll(final Context context) {
        final var type = context.getUcsEntityClassId();
        try {
            switch (type) {
                case computeBlade:
                    return CompletableFuture.completedFuture(this.poll(context.getUcsComputeBlade()));
                case computeRackUnit:
                    return CompletableFuture.completedFuture(this.poll(context.getUcsComputeRackUnit()));
                case equipmentChassis:
                    return CompletableFuture.completedFuture(this.poll(context.getUcsEquipmentChassis()));
                case equipmentFex:
                    return CompletableFuture.completedFuture(this.poll(context.getUcsEquipmentFex()));
                case equipmentRackEnclosure:
                    return CompletableFuture.completedFuture(this.poll(context.getUcsEquipmentRackEnclosure()));
                case networkElement:
                    return CompletableFuture.completedFuture(this.poll(context.getUcsNetworkElement()));
                default:
                    return CompletableFuture.completedFuture(ImmutablePollerResult.newBuilder()
                            .setStatus(Status.Unknown)
                            .setReason("No supported UCS Entity: " + type)
                            .build());
            }

        } catch (ApiException e) {
            LOG.warn("Cisco UCS manager failed", e);
            return CompletableFuture.completedFuture(ImmutablePollerResult.newBuilder()
                    .setStatus(Status.Unknown)
                    .setReason(e.getMessage())
                    .build());
        } finally {
            context.release();
        }
    }

    @Override
    public final CompletableFuture<PollerResult> poll(final PollerRequest pollerRequest) {
        Context context;
        try {
            LOG.debug("poll: {} {}", pollerRequest.getAddress().getHostAddress(), pollerRequest.getServiceName());
            context = new Context(pollerRequest);
        } catch (final ApiException e) {
            LOG.warn("Cisco UCS manager communication failed", e);
            return CompletableFuture.completedFuture(ImmutablePollerResult.newBuilder()
                                                                          .setStatus(Status.Unknown)
                                                                          .setReason(e.getMessage())
                                                                          .build());
        }
        return this.poll(context);
    }

    public static abstract class Factory<T extends CiscoUcsAbstractPoller> implements ServicePollerFactory<T> {

        private final ClientManager clientManager;
        private final ConnectionManager connectionManager;

        private final Class<T> clazz;

        protected Factory(final ConnectionManager connectionManager, final ClientManager clientManager,
                          final Class<T> clazz) {
            this.connectionManager = Objects.requireNonNull(connectionManager);
            this.clientManager = Objects.requireNonNull(clientManager);

            this.clazz = Objects.requireNonNull(clazz);
        }

        protected abstract T createPoller(ConnectionManager connectionManager, ClientManager clientManager);

        @Override
        public final T createPoller() {
            LOG.debug("Factory::createPoller -> class {}", getPollerClassName());
            return this.createPoller(this.connectionManager, this.clientManager);
        }

        @Override
        public final String getPollerClassName() {
            return this.clazz.getCanonicalName();
        }



        @Override
        public final Map<String, String> getRuntimeAttributes(final PollerRequest pollerRequest) {
            final var alias = Objects.requireNonNull(pollerRequest.getPollerAttributes().get(ALIAS_KEY), "Missing property: " + ALIAS_KEY);
            final var dn = Objects.requireNonNull(pollerRequest.getPollerAttributes().get(DN_KEY), "Missing property: " + DN_KEY);
            final var type = Objects.requireNonNull(pollerRequest.getPollerAttributes().get(TYPE_KEY), "Missing property: " + TYPE_KEY);
            final var attrs = ImmutableMap.<String,String>builder();
            attrs.put(ALIAS_KEY,alias);
            attrs.put(DN_KEY, dn);
            attrs.put(TYPE_KEY, type);

            return attrs.build();
        }
    }

    public class Context {
        public final PollerRequest request;

        public final String alias;
        public final String type;
        public final String dn;
        public final ApiClientService service;

        public Context(final PollerRequest request) throws ApiException {
            this.request = Objects.requireNonNull(request);
            this.alias = Objects.requireNonNull(this.request.getPollerAttributes().get(ALIAS_KEY),
                    "Missing attribute: " + ALIAS_KEY);
            this.dn = Objects.requireNonNull(this.request.getPollerAttributes().get(DN_KEY),
                    "Missing attribute: " + DN_KEY);
            this.type = Objects.requireNonNull(this.request.getPollerAttributes().get(TYPE_KEY),
                    "Missing attribute: " + TYPE_KEY);
            var connection =  CiscoUcsAbstractPoller.this.connectionManager.getConnection(alias);
            if (connection.isEmpty()) {
                throw new ApiException("No connection for alias", new NullPointerException("No connection found for "+ alias));
            }
            service = CiscoUcsAbstractPoller.this.clientManager.getClientService(connection.get());

        }

        public void release() {
            service.release();
        }

        public UcsNetworkElement getUcsNetworkElement() throws ApiException {
            return service.resolveUcsNetworkElementByResponse(service.getUcsXmlFromDn(dn,false));
        }

        public UcsComputeBlade getUcsComputeBlade() throws ApiException {
            return service.resolveUcsComputeBladeByResponse(service.getUcsXmlFromDn(dn,false));
        }

        public UcsComputeRackUnit getUcsComputeRackUnit() throws ApiException {
            return service.resolveUcsComputeRackUnitByResponse(service.getUcsXmlFromDn(dn,false));
        }

        public UcsEquipmentChassis getUcsEquipmentChassis() throws ApiException {
            return service.resolveUcsEquipmentChassisByResponse(service.getUcsXmlFromDn(dn,false));
        }

        public UcsEquipmentFex getUcsEquipmentFex() throws ApiException {
            return service.resolveUcsEquipmentFexByResponse(service.getUcsXmlFromDn(dn,false));
        }

        public UcsEquipmentRackEnclosure getUcsEquipmentRackEnclosure() throws ApiException {
            return service.resolveUcsEquipmentRackEnclosureByResponse(service.getUcsXmlFromDn(dn,false));
        }

        public UcsEnums.ClassId getUcsEntityClassId() {
            return UcsEnums.ClassId.valueOf(type);
        }
    }
}
