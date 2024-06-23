package it.xeniaprogetti.cisco.ucs.plugin.collection.compute;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDataCollection;
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

import static java.util.Objects.requireNonNull;

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
        int milliseconds = Integer.parseInt((String) requireNonNull(attributes.get(SERVICE_INTERVAL), "Missing attribute: " + SERVICE_INTERVAL));
        Map<String, Set<UcsEnums.NamingClassId>> requestMap = new HashMap<>();
        LOG.debug("collect: nodeid:{} ipaddr:{}, attributes:{}", request.getNodeId(), request.getAddress(), attributes);
        var dn = attributes.get(UcsUtils.UCS_DN_KEY).toString();
        var type = UcsEnums.ClassId.valueOf(attributes.get(UcsUtils.UCS_TYPE_KEY).toString());
        LOG.debug("collect: nodeid:{} ipaddr:{}, dn:{} type:{}",
                request.getNodeId(), request.getAddress(), dn, type);
        final ImmutableNodeResource nodeResource = ImmutableNodeResource.newBuilder().setNodeId(request.getNodeId()).build();

        if (collectionItemMap.containsKey(type)) {
            requestMap.put(
                    dn,
                    collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY));
        } else {
            return creatEmptyCollectionSet(nodeResource, Instant.now().toEpochMilli());

        }
        ApiClientService service;
        try {
            service = getClientService(attributes);
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return  CompletableFuture.failedFuture(e);
        }

        UcsDataCollection stats;
        try {
            stats = service.getUcsDataCollection(requestMap);
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return createFailedCollectionSet(nodeResource, Instant.now().toEpochMilli());
        }
        final ImmutableCollectionSetResource.Builder<NodeResource> computeAttrBuilder =
                ImmutableCollectionSetResource.newBuilder(NodeResource.class).setResource(nodeResource);
        stats.getUcsComputeMbPowerStats().ifPresent(stat -> addUcsComputeMbPowerStats(computeAttrBuilder, stat));
        stats.getUcsComputeMbTempStats().ifPresent(stat -> addUcsComputeMbTempStats(computeAttrBuilder, stat));
        stats.getUcsComputePCIeFatalCompletionStats().ifPresent(stat -> addUcsComputePCIeFatalCompletionStat(computeAttrBuilder, stat,milliseconds));
        stats.getUcsComputePCIeFatalProtocolStats().ifPresent(stat -> addUcsComputePCIeFatalProtocolStat(computeAttrBuilder, stat,milliseconds));
        stats.getUcsComputePCIeFatalReceiveStats().ifPresent(stat -> addUcsComputePCIeFatalReceiveStat(computeAttrBuilder, stat,milliseconds));
        stats.getUcsComputePCIeFatalStats().ifPresent(stat -> addUcsComputePCIeFatalStat(computeAttrBuilder, stat,milliseconds));
        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(computeAttrBuilder.build());
        addUcsAdaptorEthPortStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsAdaptorEthPortErrStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsAdaptorEthPortMcastStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsAdaptorVnicStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsProcessorEnvStats(resultBuilder, stats, nodeResource);
        addUcsProcessorErrorStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsStorageDiskEnvStats(resultBuilder, stats, nodeResource);
        addUcsStorageSsdHealthStats(resultBuilder,stats,nodeResource);
        addUcsMemoryErrorStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsMemoryUnitEnvStats(resultBuilder, stats, nodeResource);
        return CompletableFuture.completedFuture(resultBuilder.setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(System.currentTimeMillis()).build());
    }
}
