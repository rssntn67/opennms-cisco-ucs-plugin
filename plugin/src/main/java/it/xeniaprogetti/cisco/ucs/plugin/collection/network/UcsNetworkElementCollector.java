package it.xeniaprogetti.cisco.ucs.plugin.collection.network;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDataCollection;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
import it.xeniaprogetti.cisco.ucs.plugin.collection.AbstractUcsServiceCollector;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.collectors.CollectionRequest;
import org.opennms.integration.api.v1.collectors.CollectionSet;
import org.opennms.integration.api.v1.collectors.resource.GenericTypeResource;
import org.opennms.integration.api.v1.collectors.resource.NodeResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSet;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSetResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableGenericTypeResource;
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
        int milliseconds = Integer.parseInt((String) requireNonNull(attributes.get(SERVICE_INTERVAL), "Missing attribute: " + SERVICE_INTERVAL));

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
        ApiClientService service;
        try {
            service = getClientService(attributes);
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return  CompletableFuture.failedFuture(e);
        }

        final ImmutableNodeResource nodeResource = ImmutableNodeResource.newBuilder().setNodeId(request.getNodeId()).build();

        UcsDataCollection stats;
        try {
            stats = service.getUcsDataCollection(requestMap);
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return createFailedCollectionSet(nodeResource, Instant.now().toEpochMilli());
        } finally {
            service.release();
        }

        final ImmutableCollectionSetResource.Builder<NodeResource> networkElementAttrBuilder =
                ImmutableCollectionSetResource.newBuilder(NodeResource.class).setResource(nodeResource);

        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.dn", stats.ucsSwEnvStats.dn.value));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.thresholded", stats.ucsSwEnvStats.thresholded));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.suspect", stats.ucsSwEnvStats.suspect));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.timeCollected", stats.ucsSwEnvStats.timeCollected.toString()));
        addNumAttr(networkElementAttrBuilder,"ucsSwEnvStats", "MainBoardOutlet1", stats.ucsSwEnvStats.mainBoardOutlet1);
        addNumAttr(networkElementAttrBuilder,"ucsSwEnvStats", "MainBoardOutlet2", stats.ucsSwEnvStats.mainBoardOutlet2);

        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.dn", stats.ucsSwSystemStats.dn.value));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.thresholded", stats.ucsSwSystemStats.thresholded));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.suspect", stats.ucsSwSystemStats.suspect));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.timeCollected", stats.ucsSwSystemStats.timeCollected.toString()));

        addNumAttr(networkElementAttrBuilder,"ucsSwSystemStats", "Load", stats.ucsSwSystemStats.load);
        addNumAttr(networkElementAttrBuilder,"ucsSwSystemStats", "MemAvailable", stats.ucsSwSystemStats.memAvailable);
        addNumAttr(networkElementAttrBuilder,"ucsSwSystemStats", "MemCached", stats.ucsSwSystemStats.memCached);

        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.dn", stats.ucsSwCardEnvStats.dn.value));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.thresholded", stats.ucsSwCardEnvStats.thresholded));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.suspect", stats.ucsSwCardEnvStats.suspect));
        networkElementAttrBuilder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.timeCollected", stats.ucsSwCardEnvStats.timeCollected.toString()));


        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(networkElementAttrBuilder.build());

        stats.ucsEquipmentNetworkElementFanStatsList.forEach(stat -> {
            UcsDn fanDn = UcsDn.getParentDn(stat.dn);
            assert fanDn != null;
            String fanId = fanDn.value.replace("/","-");
            UcsDn fanModuleDn = UcsDn.getParentDn(fanDn);
            assert fanModuleDn != null;
            String fanName = fanDn.value.replace(fanModuleDn.value, "").replace("/","");
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                    ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                            .setType("NetworkElementFan")
                                            .setInstance(fanId)
                                            .build())
                            .addStringAttribute(createStringAttribute("equipmentNetworkElementFan", "dn", stat.dn.value))
                            .addStringAttribute(createStringAttribute("equipmentNetworkElementFan", "fanDn", fanDn.value))
                            .addStringAttribute(createStringAttribute("equipmentNetworkElementFan", "fanName", fanName))
                            .addStringAttribute(createStringAttribute("equipmentNetworkElementFan", "fanId", fanId))
                            .addStringAttribute(createStringAttribute("equipmentNetworkElementFan", "airFlowDirection", stat.airflowDirection));

            addNumAttr(appResourceBuilder, "equipmentNetworkElementFan", "Speed", stat.speed);
            addNumAttr(appResourceBuilder, "equipmentNetworkElementFan", "DrivePercentage", stat.drivePercentage);

            resultBuilder.addCollectionSetResource(appResourceBuilder.build());

        });

        stats.ucsFcStats.forEach(stat -> {
            UcsDn fcDn = UcsDn.getParentDn(stat.dn);
            assert fcDn != null;
            String fcId = fcDn.value.replace("/","-");
            UcsDn fcSwitchDn = UcsDn.getParentDn(fcDn);
            assert fcSwitchDn != null;
            String fcName = fcDn.value.replace(fcSwitchDn.value, "").replace("/","");
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                    ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                            .setType("Fc")
                                            .setInstance(fcId)
                                            .build())
                            .addStringAttribute(createStringAttribute("fcStat", "fcStat.dn", stat.dn.value))
                            .addStringAttribute(createStringAttribute("fcStat", "fcStat.fcDn", fcDn.value))
                            .addStringAttribute(createStringAttribute("fcStat", "fcStat.fcName", fcName))
                            .addStringAttribute(createStringAttribute("fcStat", "fcStat.fcId", fcId));

            addNumAttr(appResourceBuilder, "fcStat", "ByteRx", stat.bytesRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcStat", "ByteTx", stat.bytesTx, milliseconds);
            addNumAttr(appResourceBuilder, "fcStat", "PacketsRx", stat.packetsRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcStat", "PacketsTx", stat.packetsTx, milliseconds);

        });

        stats.ucsFcErrStats.forEach(stat -> {
            UcsDn fcDn = UcsDn.getParentDn(stat.dn);
            assert fcDn != null;
            String fcId = fcDn.value.replace("/","-");
            UcsDn fcSwitchDn = UcsDn.getParentDn(fcDn);
            assert fcSwitchDn != null;
            String fcName = fcDn.value.replace(fcSwitchDn.value, "").replace("/","");
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                    ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                            .setType("Fc")
                                            .setInstance(fcId)
                                            .build())
                            .addStringAttribute(createStringAttribute("fcErrStat", "fcErrStat.dn", stat.dn.value))
                            .addStringAttribute(createStringAttribute("fcErrStat", "fcErrStat.fcDn", fcDn.value))
                            .addStringAttribute(createStringAttribute("fcErrStat", "fcErrStat.fcName", fcName))
                            .addStringAttribute(createStringAttribute("fcErrStat", "fcErrStat.fcId", fcId));

            addNumAttr(appResourceBuilder, "fcErrStat", "LinkFailures", stat.linkFailures, milliseconds);
            addNumAttr(appResourceBuilder, "fcErrStat", "SignalLosses", stat.signalLosses, milliseconds);
            addNumAttr(appResourceBuilder, "fcErrStat", "SyncLosses", stat.syncLosses, milliseconds);
            addNumAttr(appResourceBuilder, "fcErrStat", "Rx", stat.rx, milliseconds);
            addNumAttr(appResourceBuilder, "fcErrStat", "CrcRx", stat.crcRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcErrStat", "DiscardRx", stat.discardRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcErrStat", "TooLongRx", stat.tooLongRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcErrStat", "TooShortRx", stat.tooShortRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcErrStat", "Tx", stat.tx, milliseconds);
            addNumAttr(appResourceBuilder, "fcErrStat", "DiscardTx", stat.discardTx, milliseconds);

        });

        return CompletableFuture.completedFuture(resultBuilder.setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(stats.ucsSwEnvStats.timeCollected.getTime()).build());

    }
}
