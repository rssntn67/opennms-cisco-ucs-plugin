package it.xeniaprogetti.cisco.ucs.plugin.collection;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.Aggregate;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import it.xeniaprogetti.cisco.ucs.plugin.pollers.CiscoUcsAbstractPoller;
import org.opennms.integration.api.v1.collectors.CollectionSet;
import org.opennms.integration.api.v1.collectors.immutables.ImmutableNumericAttribute;
import org.opennms.integration.api.v1.collectors.immutables.ImmutableStringAttribute;
import org.opennms.integration.api.v1.collectors.resource.NodeResource;
import org.opennms.integration.api.v1.collectors.resource.NumericAttribute;
import org.opennms.integration.api.v1.collectors.resource.Resource;
import org.opennms.integration.api.v1.collectors.resource.StringAttribute;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSet;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSetResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableNodeResource;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public abstract class AbstractUcsServiceCollector implements UcsServiceCollector {

    public static final String SERVICE_INTERVAL = "SERVICE_INTERVAL";

    protected final ClientManager clientManager;
    protected final ConnectionManager connectionManager;

    public AbstractUcsServiceCollector(ClientManager clientManager, ConnectionManager connectionManager) {
        this.clientManager = clientManager;
        this.connectionManager = connectionManager;
    }

    public static void addNumAttr(ImmutableCollectionSetResource.Builder<? extends Resource> builder, String groupId,
                                  String name, Number value) {
        if(value != null) {
            builder.addNumericAttribute(createNumAttr(groupId, name, value.doubleValue()));
        }

    }

    public static void addNumAttr(ImmutableCollectionSetResource.Builder<? extends Resource> builder, String groupId,
                            String name, Number value, long milliseconds) {
        if(value != null) {
            builder.addNumericAttribute(createNumAttr(groupId, name, value.doubleValue() * 1000 / milliseconds));
        }
    }

    public static StringAttribute createStringAttribute(String groupId, String name, String value) {
        return ImmutableStringAttribute.newBuilder().setGroup(groupId).setName(name).setValue(value).build();
    }

    public static NumericAttribute createNumAttr(String groupId, String name, double value) {
        return ImmutableNumericAttribute.newBuilder().setGroup(groupId).setName(name).setValue(value)
                .setType(NumericAttribute.Type.GAUGE).build();
    }

    public static void addAggregate(ImmutableCollectionSetResource.Builder<? extends Resource> builder, String groupId,
                              String prefix, Aggregate aggregate) {
        if(aggregate != null) {
            addNumAttr(builder, groupId, prefix + "Min", aggregate.getMin());
            addNumAttr(builder, groupId, prefix + "Max", aggregate.getMax());
            addNumAttr(builder, groupId, prefix + "Avg", aggregate.getAverage());
        }
    }

    protected ApiClientService getClient(Map<String, Object> attributes) throws ApiException {
        String alias = Objects.requireNonNull(attributes.get(CiscoUcsAbstractPoller.ALIAS_KEY), "alias is missing").toString();
        var connection = connectionManager.getConnection(alias);
        if (connection.isEmpty()) {
            throw new ApiException("No connection for alias", new NullPointerException("No connection found for "+ alias));
        }
        return clientManager.getClient(connection.get());
    }

    public static CompletableFuture<CollectionSet> createFailedCollectionSet(ImmutableNodeResource nodeResource, long timestamp) {
        return CompletableFuture.completedFuture(ImmutableCollectionSet.newBuilder()
                .addCollectionSetResource(ImmutableCollectionSetResource.newBuilder(NodeResource.class)
                        .setResource(nodeResource).build())
                .setTimestamp(timestamp).setStatus(CollectionSet.Status.FAILED).build());
    }

}
