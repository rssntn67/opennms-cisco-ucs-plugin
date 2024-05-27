package it.xeniaprogetti.cisco.ucs.plugin.collection.compute;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
import it.xeniaprogetti.cisco.ucs.plugin.collection.AbstractUcsServiceCollector;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.collectors.CollectionRequest;
import org.opennms.integration.api.v1.collectors.CollectionSet;
import org.opennms.integration.api.v1.collectors.resource.NodeResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSet;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSetResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableNodeResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class UcsComputeCollector extends AbstractUcsServiceCollector {
    private final Map<UcsEnums.ClassId, Map<String,Set<UcsEnums.NamingClassId>>> collectionItemMap = new HashMap<>();

    private static final Logger LOG = LoggerFactory.getLogger(UcsComputeCollector.class);

    public UcsComputeCollector(ClientManager clientManager, ConnectionManager connectionManager) {
        super(clientManager, connectionManager);
    }

    @Override
    public void initialize() {
        collectionItemMap.put(UcsEnums.ClassId.computeBlade, new HashMap<>());
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).put(UcsUtils.UCS_DN_KEY, new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.adaptorEthPortErrStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.adaptorEthPortMcastStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.adaptorEthPortStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.adaptorVnicStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.memoryUnitEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.memoryErrorStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.processorEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.processorErrorStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computePCIeFatalCompletionStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computePCIeFatalProtocolStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computePCIeFatalReceiveStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computePCIeFatalStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computeMbPowerStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computeMbTempStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.storageDiskEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.storageSsdHealthStats);


    }

    @Override
    public CompletableFuture<CollectionSet> collect(CollectionRequest request, Map<String, Object> attributes) {
        Map<String, Set<UcsEnums.NamingClassId>> requestMap = new HashMap<>();
        var dn = attributes.get(UcsUtils.UCS_DN_KEY).toString();
        requestMap.put(
                dn,
                collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY)
        );
        ApiClientService client;
        try {
            client = getClient(attributes);
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return  CompletableFuture.failedFuture(e);
        }

        final ImmutableNodeResource nodeResource = ImmutableNodeResource.newBuilder().setNodeId(request.getNodeId()).build();
        UcsComputeStats stats;
        try {
            stats = client.getUcsComputeStats(requestMap);
            client.disconnect();
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return createFailedCollectionSet(nodeResource, Instant.now().toEpochMilli());
        }

        final ImmutableCollectionSetResource.Builder<NodeResource> networkElementAttrBuilder =
                ImmutableCollectionSetResource.newBuilder(NodeResource.class).setResource(nodeResource);
        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(networkElementAttrBuilder.build());

        return CompletableFuture.completedFuture(resultBuilder.setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(System.currentTimeMillis()).build());
    }
}
