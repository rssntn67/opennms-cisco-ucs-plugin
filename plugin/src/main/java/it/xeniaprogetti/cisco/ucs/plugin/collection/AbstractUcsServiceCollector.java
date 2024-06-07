package it.xeniaprogetti.cisco.ucs.plugin.collection;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.Aggregate;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeMbPowerStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeMbTempStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDataCollection;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassisStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsSwCardEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsSwEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsSwSystemStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.collectors.CollectionSet;
import org.opennms.integration.api.v1.collectors.immutables.ImmutableNumericAttribute;
import org.opennms.integration.api.v1.collectors.immutables.ImmutableStringAttribute;
import org.opennms.integration.api.v1.collectors.resource.GenericTypeResource;
import org.opennms.integration.api.v1.collectors.resource.NodeResource;
import org.opennms.integration.api.v1.collectors.resource.NumericAttribute;
import org.opennms.integration.api.v1.collectors.resource.Resource;
import org.opennms.integration.api.v1.collectors.resource.StringAttribute;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSet;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSetResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableGenericTypeResource;
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

    public static void addUcsSwCardEnvStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsSwCardEnvStats stats) {
        builder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.dn", stats.dn.value));
        builder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.thresholded", stats.thresholded));
        builder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.suspect", stats.suspect));
        builder.addStringAttribute(createStringAttribute("ucsSwCardEnvStats", "ucsSwCardEnvStats.timeCollected", stats.timeCollected.toString()));
    }

    public static void addUcsSwEnvStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsSwEnvStats stats) {
        builder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.dn", stats.dn.value));
        builder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.thresholded", stats.thresholded));
        builder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.suspect", stats.suspect));
        builder.addStringAttribute(createStringAttribute("ucsSwEnvStats", "ucsSwEnvStats.timeCollected", stats.timeCollected.toString()));
        addNumAttr(builder,"ucsSwEnvStats", "MainBoardOutlet1", stats.mainBoardOutlet1);
        addNumAttr(builder,"ucsSwEnvStats", "MainBoardOutlet2", stats.mainBoardOutlet2);
    }

    public static void addUcsSwSystemStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsSwSystemStats stats) {
        builder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.dn", stats.dn.value));
        builder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.thresholded", stats.thresholded));
        builder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.suspect", stats.suspect));
        builder.addStringAttribute(createStringAttribute("ucsSwSystemStats", "ucsSwSystemStats.timeCollected", stats.timeCollected.toString()));

        addNumAttr(builder,"ucsSwSystemStats", "Load", stats.load);
        addNumAttr(builder,"ucsSwSystemStats", "MemAvailable", stats.memAvailable);
        addNumAttr(builder,"ucsSwSystemStats", "MemCached", stats.memCached);
    }

    public static void addUcsComputeMbPowerStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputeMbPowerStats stats) {
        builder.addStringAttribute(createStringAttribute("ucsComputeMbPowerStats", "ucsComputeMbPowerStats.dn", stats.dn.value));
        addNumAttr(builder, "ucsComputeMbPowerStats", "ConsumedPower", stats.consumedPower);
        addNumAttr(builder, "ucsComputeMbPowerStats", "InputCurrent", stats.inputCurrent);
        addNumAttr(builder, "ucsComputeMbPowerStats", "InputVoltage", stats.inputVoltage);
    }

    public static void addUcsComputeMbTempStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputeMbTempStats stats) {
        builder.addStringAttribute(createStringAttribute("ucsComputeMbTempStats", "ucsComputeMbTempStats.dn", stats.dn.value));
        addNumAttr(builder, "ucsComputeMbTempStats", "FmTempSenIo", stats.fmTempSenIo);
        addNumAttr(builder, "ucsComputeMbTempStats", "FmTempSenRear", stats.fmTempSenRear);
    }

    public static void addUcsEquipmentChassisStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsEquipmentChassisStats stats) {
        builder.addStringAttribute(createStringAttribute("ucsEquipmentChassisStats", "ucsEquipmentChassisStats.dn", stats.dn.value));
        addNumAttr(builder, "ucsEquipmentChassisStats", "ChassisI2CErrors", stats.ChassisI2CErrors);
        addNumAttr(builder, "ucsEquipmentChassisStats", "InputPower", stats.inputPower);
        addNumAttr(builder, "ucsEquipmentChassisStats", "OutputPower", stats.outputPower);
    }

    public static void addEquipmentNetworkElementFanStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsEquipmentNetworkElementFanStats.forEach(stat -> {
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

            builder.addCollectionSetResource(appResourceBuilder.build());

        });
    }

    public static void addUcsFcStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
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
                            .addStringAttribute(createStringAttribute("fcStat", "fcDn", fcDn.value))
                            .addStringAttribute(createStringAttribute("fcStat", "fcName", fcName))
                            .addStringAttribute(createStringAttribute("fcStat", "fcStat.fcId", fcId));

            addNumAttr(appResourceBuilder, "fcStat", "ByteRx", stat.bytesRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcStat", "ByteTx", stat.bytesTx, milliseconds);
            addNumAttr(appResourceBuilder, "fcStat", "PacketsRx", stat.packetsRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcStat", "PacketsTx", stat.packetsTx, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());

        });
    }

    public static void addUcsFcErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
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
                            .addStringAttribute(createStringAttribute("fcErrStat", "fcDn", fcDn.value))
                            .addStringAttribute(createStringAttribute("fcErrStat", "fcName", fcName))
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
            builder.addCollectionSetResource(appResourceBuilder.build());

        });
    }

    public static void addUcsProcessorEnvStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
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

            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherRxStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsEtherRxStats.forEach(stat -> {
            UcsDn etherDn = UcsDn.getParentDn(stat.dn);
            assert etherDn != null;
            String etherId = etherDn.value.replace("/","-");
            UcsDn etherSwitchDn = UcsDn.getParentDn(etherDn);
            assert etherSwitchDn != null;
            String etherName = etherDn.value.replace(etherSwitchDn.value, "").replace("/","");
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                    ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                            .setType("Ether")
                                            .setInstance(etherId)
                                            .build())
                            .addStringAttribute(createStringAttribute("etherRxStats", "etherRxStats.dn", stat.dn.value))
                            .addStringAttribute(createStringAttribute("etherRxStats", "etherDn", etherDn.value))
                            .addStringAttribute(createStringAttribute("etherRxStats", "etherName", etherName))
                            .addStringAttribute(createStringAttribute("etherRxStats", "etherRxStats.etherId", etherId));

            addNumAttr(appResourceBuilder, "etherRxStats", "RxBroadcastPackets", stat.broadcastPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherRxStats", "RxJumboPackets", stat.jumboPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherRxStats", "RxMulticastPackets", stat.multicastPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherRxStats", "RxTotalBytes", stat.totalBytes, milliseconds);
            addNumAttr(appResourceBuilder, "etherRxStats", "RxTotalPackets", stat.totalPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherRxStats", "RxUnicastPackets", stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherTxStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsEtherTxStats.forEach(stat -> {
            UcsDn etherDn = UcsDn.getParentDn(stat.dn);
            assert etherDn != null;
            String etherId = etherDn.value.replace("/","-");
            UcsDn etherSwitchDn = UcsDn.getParentDn(etherDn);
            assert etherSwitchDn != null;
            String etherName = etherDn.value.replace(etherSwitchDn.value, "").replace("/","");
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                    ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                            .setType("Ether")
                                            .setInstance(etherId)
                                            .build())
                            .addStringAttribute(createStringAttribute("etherTxStats", "etherRxStats.dn", stat.dn.value))
                            .addStringAttribute(createStringAttribute("etherTxStats", "etherDn", etherDn.value))
                            .addStringAttribute(createStringAttribute("etherTxStats", "etherName", etherName))
                            .addStringAttribute(createStringAttribute("etherTxStats", "etherTxStats.etherId", etherId));

            addNumAttr(appResourceBuilder, "etherTxStats", "TxBroadcastPackets", stat.broadcastPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherTxStats", "TxJumboPackets", stat.jumboPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherTxStats", "TxMulticastPackets", stat.multicastPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherTxStats", "TxTotalBytes", stat.totalBytes, milliseconds);
            addNumAttr(appResourceBuilder, "etherTxStats", "TxTotalPackets", stat.totalPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherRxStats", "TxUnicastPackets", stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentPsuInputStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsEquipmentPsuInputStats.forEach(stat -> {
            UcsDn psuInputDn = UcsDn.getParentDn(stat.dn);
            assert psuInputDn != null;
            String psuInputId = psuInputDn.value.replace("/","-");
            UcsDn switchDn = UcsDn.getParentDn(psuInputDn);
            assert switchDn != null;
            String psuInputName = psuInputDn.value.replace(switchDn.value, "").replace("/","");
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                    ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                            .setType("EquipPsuInput")
                                            .setInstance(psuInputId)
                                            .build())
                            .addStringAttribute(createStringAttribute("equipmentPsuInput", "equipmentPsuInput.dn", stat.dn.value))
                            .addStringAttribute(createStringAttribute("equipmentPsuInput", "psuInputDn", psuInputDn.value))
                            .addStringAttribute(createStringAttribute("equipmentPsuInput", "psuInputName", psuInputName))
                            .addStringAttribute(createStringAttribute("equipmentPsuInput", "inputStatus", stat.inputStatus));

            addNumAttr(appResourceBuilder, "equipmentPsuInput", "Current", stat.current);
            addNumAttr(appResourceBuilder, "equipmentPsuInput", "Power", stat.power);
            addNumAttr(appResourceBuilder, "equipmentPsuInput", "Voltage", stat.voltage);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentPsuStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsEquipmentPsuStats.forEach(stat -> {
            UcsDn psuDn = UcsDn.getParentDn(stat.dn);
            assert psuDn != null;
            String psuId = psuDn.value.replace("/","-");
            UcsDn equipmentDn = UcsDn.getParentDn(psuDn);
            assert equipmentDn != null;
            String psuName = psuDn.value.replace(equipmentDn.value, "").replace("/","");
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                    ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                            .setType("EquipPsu")
                                            .setInstance(psuId)
                                            .build())
                            .addStringAttribute(createStringAttribute("equipmentPsu", "equipmentPsu.dn", stat.dn.value))
                            .addStringAttribute(createStringAttribute("equipmentPsu", "psuDn", psuDn.value))
                            .addStringAttribute(createStringAttribute("equipmentPsu", "psuName", psuName));

            addNumAttr(appResourceBuilder, "equipmentPsu", "AmbientTemp", stat.ambientTemp);
            addNumAttr(appResourceBuilder, "equipmentPsu", "Input210v", stat.input210v);
            addNumAttr(appResourceBuilder, "equipmentPsu", "Output12v", stat.output12v);
            addNumAttr(appResourceBuilder, "equipmentPsu", "Output3v3", stat.output3v3);
            addNumAttr(appResourceBuilder, "equipmentPsu", "OutputCurrent", stat.outputCurrent);
            addNumAttr(appResourceBuilder, "equipmentPsu", "OutputPower", stat.outputPower);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentIoCardStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsEquipmentIOCardStats.forEach(stat -> {
            UcsDn ioCardDn = UcsDn.getParentDn(stat.dn);
            assert ioCardDn != null;
            String ioCardId = ioCardDn.value.replace("/","-");
            UcsDn equipmentDn = UcsDn.getParentDn(ioCardDn);
            assert equipmentDn != null;
            String ioCardName = ioCardDn.value.replace(equipmentDn.value, "").replace("/","");
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                    ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                            .setType("EquipIOCard")
                                            .setInstance(ioCardId)
                                            .build())
                            .addStringAttribute(createStringAttribute("equipmentIOCard", "equipmentIOCard.dn", stat.dn.value))
                            .addStringAttribute(createStringAttribute("equipmentIOCard", "ioCardDn", ioCardDn.value))
                            .addStringAttribute(createStringAttribute("equipmentIOCard", "ioCardName", ioCardName));

            addNumAttr(appResourceBuilder, "equipmentIOCard", "AmbientTemp", stat.ambientTemp);
            addNumAttr(appResourceBuilder, "equipmentIOCard", "IomI2CErrors", stat.IomI2CErrors);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    protected ApiClientService getClientService(Map<String, Object> attributes) throws ApiException {
        String alias = Objects.requireNonNull(attributes.get(UcsUtils.UCS_ALIAS_KEY), "alias is missing").toString();
        var connection = connectionManager.getConnection(alias);
        if (connection.isEmpty()) {
            throw new ApiException("No connection for alias", new NullPointerException("No connection found for "+ alias));
        }
        return clientManager.getClientService(connection.get());
    }

    public static CompletableFuture<CollectionSet> createFailedCollectionSet(ImmutableNodeResource nodeResource, long timestamp) {
        return CompletableFuture.completedFuture(ImmutableCollectionSet.newBuilder()
                .addCollectionSetResource(ImmutableCollectionSetResource.newBuilder(NodeResource.class)
                        .setResource(nodeResource).build())
                .setTimestamp(timestamp).setStatus(CollectionSet.Status.FAILED).build());
    }

    public static CompletableFuture<CollectionSet> creatEmptyCollectionSet(ImmutableNodeResource nodeResource, long timestamp) {
        return CompletableFuture.completedFuture(ImmutableCollectionSet.newBuilder()
                .addCollectionSetResource(ImmutableCollectionSetResource.newBuilder(NodeResource.class)
                        .setResource(nodeResource).build())
                .setTimestamp(timestamp).setStatus(CollectionSet.Status.SUCCEEDED).build());
    }


}
