package it.xeniaprogetti.cisco.ucs.plugin.collection.network;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsNetworkElementStats;
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

public class UcsNetworkElementCollector extends AbstractUcsServiceCollector {
    private final Map<UcsEnums.ClassId, Map<String,Set<UcsEnums.NamingClassId>>> collectionItemMap = new HashMap<>();
    private final static Logger LOG = LoggerFactory.getLogger(UcsNetworkElementCollector.class);

    public UcsNetworkElementCollector(ClientManager clientManager, ConnectionManager connectionManager) {
        super(clientManager, connectionManager);
    }

    @Override
    public void initialize() {
        collectionItemMap.put(UcsEnums.ClassId.networkElement, new HashMap<>());

        collectionItemMap.get(UcsEnums.ClassId.networkElement).put(UcsUtils.UCS_FABRIC_LAN_KEY,new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherErrStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherLossStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherPauseStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherRxStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherTxStats);

        collectionItemMap.get(UcsEnums.ClassId.networkElement).put(UcsUtils.UCS_FABRIC_SAN_KEY,new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_SAN_KEY).add(UcsEnums.NamingClassId.fcErrStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_SAN_KEY).add(UcsEnums.NamingClassId.fcStats);

        collectionItemMap.get(UcsEnums.ClassId.networkElement).put(UcsUtils.UCS_DN_KEY, new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentNetworkElementFanStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentPsuInputStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherErrStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherLossStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherPauseStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherRxStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherTxStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.fcErrStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.fcStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.swCardEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.swEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.swSystemStats);

    }

    @Override
    public CompletableFuture<CollectionSet> collect(CollectionRequest request, Map<String, Object> attributes) {
        Map<String, Set<UcsEnums.NamingClassId>> requestMap = new HashMap<>();
        var dn = attributes.get(UcsUtils.UCS_DN_KEY).toString();
        requestMap.put(
                dn,
                collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY)
        );
        if (attributes.containsKey(UcsUtils.UCS_FABRIC_LAN_KEY))
            requestMap.put(
                    attributes.get(UcsUtils.UCS_FABRIC_LAN_KEY).toString(),
                    collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY)
            );
        if (attributes.containsKey(UcsUtils.UCS_FABRIC_SAN_KEY))
            requestMap.put(
                    attributes.get(UcsUtils.UCS_FABRIC_SAN_KEY).toString(),
                    collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_SAN_KEY)
            );
        ApiClientService client;
        try {
            client = getClient(attributes);
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return  CompletableFuture.failedFuture(e);
        }

        final ImmutableNodeResource nodeResource = ImmutableNodeResource.newBuilder().setNodeId(request.getNodeId()).build();

        UcsNetworkElementStats stats;
        try {
            stats = client.getNetworkElementStats(requestMap);
            client.disconnect();
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return createFailedCollectionSet(nodeResource, Instant.now().toEpochMilli());
        }

        final ImmutableCollectionSetResource.Builder<NodeResource> networkElementAttrBuilder =
                ImmutableCollectionSetResource.newBuilder(NodeResource.class).setResource(nodeResource);

        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.dn", stats.ucsSwEnvStats.dn.value));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.thresholded", stats.ucsSwEnvStats.thresholded));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.suspect", stats.ucsSwEnvStats.suspect));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.timeCollected", stats.ucsSwEnvStats.timeCollected.toString()));
        addAggregate(networkElementAttrBuilder, "ucsSwEnvStats","MainBoardOutlet1", stats.ucsSwEnvStats.mainBoardOutlet1Agg);
        addAggregate(networkElementAttrBuilder, "ucsSwEnvStats","MainBoardOutlet2", stats.ucsSwEnvStats.mainBoardOutlet2Agg);
        addNumAttr(networkElementAttrBuilder,"ucsSwEnvStats", "MainBoardOutlet1", stats.ucsSwEnvStats.mainBoardOutlet1);
        addNumAttr(networkElementAttrBuilder,"ucsSwEnvStats", "MainBoardOutlet2", stats.ucsSwEnvStats.mainBoardOutlet2);

        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.dn", stats.ucsSwSystemStats.dn.value));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.thresholded", stats.ucsSwSystemStats.thresholded));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.suspect", stats.ucsSwSystemStats.suspect));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.timeCollected", stats.ucsSwSystemStats.timeCollected.toString()));
        addAggregate(networkElementAttrBuilder, "ucsSwSystemStats","Load", stats.ucsSwSystemStats.loadAgg);
        addAggregate(networkElementAttrBuilder, "ucsSwSystemStats","MemAvailable", stats.ucsSwSystemStats.memAvailableAgg);
        addAggregate(networkElementAttrBuilder, "ucsSwSystemStats","MemCached", stats.ucsSwSystemStats.memCachedAgg);
        addNumAttr(networkElementAttrBuilder,"ucsSwSystemStats", "Load", stats.ucsSwSystemStats.load);
        addNumAttr(networkElementAttrBuilder,"ucsSwSystemStats", "MemAvailable", stats.ucsSwSystemStats.memAvailable);
        addNumAttr(networkElementAttrBuilder,"ucsSwSystemStats", "MemCached", stats.ucsSwSystemStats.memCached);

        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.dn", stats.ucsSwCardEnvStats.dn.value));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.thresholded", stats.ucsSwCardEnvStats.thresholded));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.suspect", stats.ucsSwCardEnvStats.suspect));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.timeCollected", stats.ucsSwCardEnvStats.timeCollected.toString()));


        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(networkElementAttrBuilder.build());

        return CompletableFuture.completedFuture(resultBuilder.setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(stats.ucsSwEnvStats.timeCollected.getTime()).build());

    }
}
