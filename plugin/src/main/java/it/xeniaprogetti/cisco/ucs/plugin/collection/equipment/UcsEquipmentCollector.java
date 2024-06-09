package it.xeniaprogetti.cisco.ucs.plugin.collection.equipment;

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
        int milliseconds = Integer.parseInt((String) requireNonNull(attributes.get(SERVICE_INTERVAL), "Missing attribute: " + SERVICE_INTERVAL));
        LOG.debug("collect: nodeid:{} ipaddr:{}, attributes:{}", request.getNodeId(), request.getAddress(), attributes);
        Map<String, Set<UcsEnums.NamingClassId>> requestMap = new HashMap<>();
        var dn = attributes.get(UcsUtils.UCS_DN_KEY).toString();
        var type = UcsEnums.ClassId.valueOf(attributes.get(UcsUtils.UCS_TYPE_KEY).toString());
        LOG.debug("collect: nodeid:{} ipaddr:{}, dn:{} type:{}",
                request.getNodeId(), request.getAddress(), dn, type);
        final ImmutableNodeResource nodeResource = ImmutableNodeResource.newBuilder().setNodeId(request.getNodeId()).build();
        if (collectionItemMap.containsKey(type)) {
            requestMap.put(
                    dn,
                    collectionItemMap.get(type).get(UcsUtils.UCS_DN_KEY)
            );
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
        } finally {
            service.release();
        }

        final ImmutableCollectionSetResource.Builder<NodeResource> equipmentAttrBuilder =
                ImmutableCollectionSetResource.newBuilder(NodeResource.class).setResource(nodeResource);
        stats.getUcsEquipmentChassisStats().ifPresent(stat -> addUcsEquipmentChassisStats(equipmentAttrBuilder, stat));

        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(equipmentAttrBuilder.build());
        addUcsEtherRxStats(resultBuilder, stats, nodeResource,milliseconds);
        addUcsEtherTxStats(resultBuilder, stats, nodeResource,milliseconds);

        addUcsEquipmentPsuStats(resultBuilder, stats, nodeResource);
        addUcsEquipmentIoCardStats(resultBuilder, stats, nodeResource);

        return CompletableFuture.completedFuture(resultBuilder.setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(System.currentTimeMillis()).build());

    }
}
