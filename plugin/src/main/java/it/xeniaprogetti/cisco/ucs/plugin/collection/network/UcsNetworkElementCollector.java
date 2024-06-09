package it.xeniaprogetti.cisco.ucs.plugin.collection.network;

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
        stats.getUcsSwEnvStats().ifPresent( stat -> addUcsSwEnvStats(networkElementAttrBuilder, stat));
        stats.getUcsSwSystemStats().ifPresent( stat -> addUcsSwSystemStats(networkElementAttrBuilder,stat));
        stats.getUcsSwCardEnvStats().ifPresent(stat -> addUcsSwCardEnvStats(networkElementAttrBuilder, stat));

        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(networkElementAttrBuilder.build());
        addEquipmentNetworkElementFanStats(resultBuilder, stats, nodeResource);
        addUcsFcStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsFcErrStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsEtherRxStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsEtherTxStats(resultBuilder, stats, nodeResource, milliseconds);
        addUcsEtherErrStats(resultBuilder, stats, nodeResource,milliseconds);
        addUcsEtherLossStats(resultBuilder, stats, nodeResource,milliseconds);
        addUcsEtherPauseStats(resultBuilder, stats, nodeResource,milliseconds);
        addUcsEquipmentPsuInputStats(resultBuilder, stats, nodeResource);
        return CompletableFuture.completedFuture(resultBuilder.setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(System.currentTimeMillis()).build());

    }
}
