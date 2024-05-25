package it.xeniaprogetti.cisco.ucs.plugin.collection.equipment;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentStats;
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

public class UcsEquipmentCollector extends AbstractUcsServiceCollector {
    private final Map<UcsEnums.ClassId, Map<String,Set<UcsEnums.NamingClassId>>> collectionItemMap = new HashMap<>();

    private static final Logger LOG = LoggerFactory.getLogger(UcsEquipmentCollector.class);

    public UcsEquipmentCollector(ClientManager clientManager, ConnectionManager connectionManager) {
        super(clientManager, connectionManager);
    }

    @Override
    public void initialize() {
        collectionItemMap.put(UcsEnums.ClassId.equipmentChassis, new HashMap<>());
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).put(UcsUtils.UCS_DN_KEY, new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentFanStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentFanModuleStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentPsuStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentIOCardStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentChassisStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherErrStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherLossStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherNiErrStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherPauseStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherRxStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherTxStats);

    }

    @Override
    public CompletableFuture<CollectionSet> collect(CollectionRequest request, Map<String, Object> attributes) {
        Map<String, Set<UcsEnums.NamingClassId>> requestMap = new HashMap<>();
        var dn = attributes.get(UcsUtils.UCS_DN_KEY).toString();
        requestMap.put(
                dn,
                collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY)
        );
        ApiClientService client;
        try {
            client = getClient(attributes);
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return  CompletableFuture.failedFuture(e);
        }

        final ImmutableNodeResource nodeResource = ImmutableNodeResource.newBuilder().setNodeId(request.getNodeId()).build();
        UcsEquipmentStats stats;
        try {
            stats = client.getUcsEquipmentStats(requestMap);
            client.disconnect();
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return createFailedCollectionSet(nodeResource, Instant.now().toEpochMilli());
        }

        final ImmutableCollectionSetResource.Builder<NodeResource> equipmentAttrBuilder =
                ImmutableCollectionSetResource.newBuilder(NodeResource.class).setResource(nodeResource);
        equipmentAttrBuilder.addStringAttribute(createStringAttribute("ucsEquipmentChassisStats", "ucsEquipmentChassisStats.dn", stats.ucsEquipmentChassisStats.dn.value));
        addNumAttr(equipmentAttrBuilder, "ucsEquipmentChassisStats", "ChassisI2CErrors", stats.ucsEquipmentChassisStats.ChassisI2CErrors);
        addNumAttr(equipmentAttrBuilder, "ucsEquipmentChassisStats", "inputPower", stats.ucsEquipmentChassisStats.inputPower);
        addNumAttr(equipmentAttrBuilder, "ucsEquipmentChassisStats", "outputPower", stats.ucsEquipmentChassisStats.outputPower);
        addAggregate(equipmentAttrBuilder, "ucsEquipmentChassisStats", "ChassisI2CErrors", stats.ucsEquipmentChassisStats.ChassisI2CErrorsAgg);
        addAggregate(equipmentAttrBuilder, "ucsEquipmentChassisStats", "inputPower", stats.ucsEquipmentChassisStats.inputPowerAgg);
        addAggregate(equipmentAttrBuilder, "ucsEquipmentChassisStats", "outputPower", stats.ucsEquipmentChassisStats.outputPowerAgg);

        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(equipmentAttrBuilder.build());

        return CompletableFuture.completedFuture(resultBuilder.setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(stats.ucsEquipmentChassisStats.timeCollected.getTime()).build());

    }
}
