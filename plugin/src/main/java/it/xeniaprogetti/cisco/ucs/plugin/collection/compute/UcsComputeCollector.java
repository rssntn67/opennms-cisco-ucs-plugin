package it.xeniaprogetti.cisco.ucs.plugin.collection.compute;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
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
        ApiClientService service;
        try {
            service = getClientService(attributes);
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return  CompletableFuture.failedFuture(e);
        }

        final ImmutableNodeResource nodeResource = ImmutableNodeResource.newBuilder().setNodeId(request.getNodeId()).build();
        UcsComputeStats stats;
        try {
            stats = service.getUcsComputeStats(requestMap);
        } catch (ApiException e) {
            LOG.error("collect: {}", requestMap, e );
            return createFailedCollectionSet(nodeResource, Instant.now().toEpochMilli());
        } finally {
            service.release();
        }
        final ImmutableCollectionSetResource.Builder<NodeResource> computeAttrBuilder =
                ImmutableCollectionSetResource.newBuilder(NodeResource.class).setResource(nodeResource);

        computeAttrBuilder.addStringAttribute(createStringAttribute("ucsComputeMbPowerStats", "ucsComputeMbPowerStats.dn", stats.ucsComputeMbPowerStats.dn.value));
        addNumAttr(computeAttrBuilder, "ucsComputeMbPowerStats", "ConsumedPower", stats.ucsComputeMbPowerStats.consumedPower);
        addAggregate(computeAttrBuilder, "ucsComputeMbPowerStats", "ConsumedPower", stats.ucsComputeMbPowerStats.consumedPowerAgg);
        addNumAttr(computeAttrBuilder, "ucsComputeMbPowerStats", "InputCurrent", stats.ucsComputeMbPowerStats.inputCurrent);
        addAggregate(computeAttrBuilder, "ucsComputeMbPowerStats", "InputCurrent", stats.ucsComputeMbPowerStats.inputCurrentAgg);
        addNumAttr(computeAttrBuilder, "ucsComputeMbPowerStats", "InputVoltage", stats.ucsComputeMbPowerStats.inputVoltage);
        addAggregate(computeAttrBuilder, "ucsComputeMbPowerStats", "InputVoltage", stats.ucsComputeMbPowerStats.inputVoltageAgg);


        computeAttrBuilder.addStringAttribute(createStringAttribute("ucsComputeMbTempStats", "ucsComputeMbTempStats.dn", stats.ucsComputeMbTempStats.dn.value));
        addNumAttr(computeAttrBuilder, "ucsComputeMbTempStats", "FmTempSenIo", stats.ucsComputeMbTempStats.fmTempSenIo);
        addAggregate(computeAttrBuilder, "ucsComputeMbTempStats", "FmTempSenIo", stats.ucsComputeMbTempStats.fmTempSenIoAgg);
        addNumAttr(computeAttrBuilder, "ucsComputeMbTempStats", "FmTempSenRear", stats.ucsComputeMbTempStats.fmTempSenRear);
        addAggregate(computeAttrBuilder, "ucsComputeMbTempStats", "FmTempSenRear", stats.ucsComputeMbTempStats.fmTempSenRearAgg);

        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(computeAttrBuilder.build());

        stats.ucsProcessorEnvStats.forEach( stat -> {
            UcsDn processorDn = UcsDn.getParentDn(stat.dn);
            assert processorDn != null;
            String processorId = processorDn.value.replace("/","-");
            UcsDn boardDn = UcsDn.getParentDn(processorDn);
            assert boardDn != null;
            String processorName = processorDn.value.replace(boardDn.value, "").replace("/","");
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                    ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                            .setType("CiscoUcsProcessor")
                                            .setInstance(processorId)
                                            .build())
                            .addStringAttribute(createStringAttribute("processor", "processorEnvStatsDn", stat.dn.value))
                            .addStringAttribute(createStringAttribute("processor", "processorDn", processorDn.value))
                            .addStringAttribute(createStringAttribute("processor", "processorName", processorName))
                            .addStringAttribute(createStringAttribute("processor", "processorId", processorId));
            addNumAttr(appResourceBuilder, "processor", "Temperature", stat.temperature);
            addAggregate(appResourceBuilder, "processor", "Temperature", stat.temperatureAgg);

            resultBuilder.addCollectionSetResource(appResourceBuilder.build());
        });


        return CompletableFuture.completedFuture(resultBuilder.setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(System.currentTimeMillis()).build());
    }
}
