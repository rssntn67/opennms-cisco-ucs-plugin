package it.xeniaprogetti.cisco.ucs.plugin.collection;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.Aggregate;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeMbPowerStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeMbTempStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputePCIeFatalCompletionStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputePCIeFatalProtocolStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputePCIeFatalReceiveStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputePCIeFatalStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDataCollection;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassisStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsResourceTypeStats;
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

    public static ImmutableCollectionSetResource.Builder<GenericTypeResource> getBuilderForResource(UcsResourceTypeStats stat, ImmutableNodeResource nodeResource, String group) {
        UcsDn resourceDn = UcsDn.getParentDn(stat.dn);
        assert resourceDn != null;
        String resourceId = resourceDn.value.replace("/","-");
        UcsDn resourceParentDn = UcsDn.getParentDn(resourceDn);
        assert resourceParentDn != null;
        String resourceName = resourceDn.value.replace(resourceParentDn.value, "").replace("/","");
        return
                ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                        .setType(stat.getResourceType().name())
                                        .setInstance(resourceId)
                                        .build())
                        .addStringAttribute(createStringAttribute(group, group+".dn", stat.dn.value))
                        .addStringAttribute(createStringAttribute(group, "resourceDn", resourceDn.value))
                        .addStringAttribute(createStringAttribute(group, "resourceName", resourceName))
                        .addStringAttribute(createStringAttribute(group, group+".id", resourceId));
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

    public static void addUcsComputePCIeFatalCompletionStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalCompletionStats stats, int milliseconds) {
        builder.addStringAttribute(createStringAttribute("ucsComputePCIeFatalCompletionStat", "ucsComputePCIeFatalCompletionStat.dn", stats.dn.value));
        addNumAttr(builder, "ucsComputePCIeFatalCompletionStat", "AbortErrors", stats.AbortErrors, milliseconds);
        addNumAttr(builder, "ucsComputePCIeFatalCompletionStat", "TimeoutErrors", stats.TimeoutErrors, milliseconds);
        addNumAttr(builder, "ucsComputePCIeFatalCompletionStat", "UnexpectedErrors", stats.unexpectedErrors, milliseconds);
    }

    public static void addUcsComputePCIeFatalProtocolStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalProtocolStats stats, int milliseconds) {
        builder.addStringAttribute(createStringAttribute("ucsComputePCIeFatalProtocolStat", "ucsComputePCIeFatalProtocolStat.dn", stats.dn.value));
        addNumAttr(builder, "ucsComputePCIeFatalProtocolStat", "DllpErrors", stats.dllpErrors, milliseconds);
        addNumAttr(builder, "ucsComputePCIeFatalProtocolStat", "FlowControlErrors", stats.flowControlErrors, milliseconds);
    }

    public static void addUcsComputePCIeFatalReceiveStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalReceiveStats stats, int milliseconds) {
        builder.addStringAttribute(createStringAttribute("ucsComputePCIeFatalReceiveStat", "ucsComputePCIeFatalReceiveStat.dn", stats.dn.value));
        addNumAttr(builder, "ucsComputePCIeFatalReceiveStat", "BufferOverflowErrors", stats.bufferOverflowErrors, milliseconds);
        addNumAttr(builder, "ucsComputePCIeFatalReceiveStat", "ErrFatalErrors", stats.errFatalErrors, milliseconds);
        addNumAttr(builder, "ucsComputePCIeFatalReceiveStat", "ErrNonFatalErrors", stats.errNonFatalErrors, milliseconds);
        addNumAttr(builder, "ucsComputePCIeFatalReceiveStat", "UnsupportedRequestErrors", stats.unsupportedRequestErrors, milliseconds);
    }

    public static void addUcsComputePCIeFatalStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalStats stats, int milliseconds) {
        builder.addStringAttribute(createStringAttribute("ucsComputePCIeFatalStat", "ucsComputePCIeFatalStat.dn", stats.dn.value));
        addNumAttr(builder, "ucsComputePCIeFatalStat", "AcsViolationErrors", stats.acsViolationErrors, milliseconds);
        addNumAttr(builder, "ucsComputePCIeFatalStat", "MalformedTLPErrors", stats.malformedTLPErrors, milliseconds);
        addNumAttr(builder, "ucsComputePCIeFatalStat", "PoisonedTLPErrors", stats.poisonedTLPErrors, milliseconds);
        addNumAttr(builder, "ucsComputePCIeFatalStat", "SurpriseLinkDownErrors", stats.surpriseLinkDownErrors, milliseconds);
    }

    public static void addUcsEquipmentChassisStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsEquipmentChassisStats stats) {
        builder.addStringAttribute(createStringAttribute("ucsEquipmentChassisStats", "ucsEquipmentChassisStats.dn", stats.dn.value));
        addNumAttr(builder, "ucsEquipmentChassisStats", "ChassisI2CErrors", stats.ChassisI2CErrors);
        addNumAttr(builder, "ucsEquipmentChassisStats", "InputPower", stats.inputPower);
        addNumAttr(builder, "ucsEquipmentChassisStats", "OutputPower", stats.outputPower);
    }

    public static void addEquipmentNetworkElementFanStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsEquipmentNetworkElementFanStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "equipmentNetworkElementFan");

            appResourceBuilder.addStringAttribute(createStringAttribute("equipmentNetworkElementFan", "airFlowDirection", stat.airflowDirection));

            addNumAttr(appResourceBuilder, "equipmentNetworkElementFan", "Speed", stat.speed);
            addNumAttr(appResourceBuilder, "equipmentNetworkElementFan", "DrivePercentage", stat.drivePercentage);

            builder.addCollectionSetResource(appResourceBuilder.build());

        });
    }

    public static void addUcsFcStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsFcStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder = getBuilderForResource(stat,nodeResource,"fcStat");

            addNumAttr(appResourceBuilder, "fcStat", "ByteRx", stat.bytesRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcStat", "ByteTx", stat.bytesTx, milliseconds);
            addNumAttr(appResourceBuilder, "fcStat", "PacketsRx", stat.packetsRx, milliseconds);
            addNumAttr(appResourceBuilder, "fcStat", "PacketsTx", stat.packetsTx, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());

        });
    }

    public static void addUcsFcErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsFcErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder = getBuilderForResource(stat,nodeResource,"fcErrStat");

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
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "processor");
            addNumAttr(appResourceBuilder, "processor", "Temperature", stat.temperature);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherRxStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsEtherRxStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "etherRxStats");

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
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "etherTxStats");

            addNumAttr(appResourceBuilder, "etherTxStats", "TxBroadcastPackets", stat.broadcastPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherTxStats", "TxJumboPackets", stat.jumboPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherTxStats", "TxMulticastPackets", stat.multicastPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherTxStats", "TxTotalBytes", stat.totalBytes, milliseconds);
            addNumAttr(appResourceBuilder, "etherTxStats", "TxTotalPackets", stat.totalPackets, milliseconds);
            addNumAttr(appResourceBuilder, "etherRxStats", "TxUnicastPackets", stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsEtherErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "etherErrStats");

            addNumAttr(appResourceBuilder, "etherErrStats", "Align", stat.align, milliseconds);
            addNumAttr(appResourceBuilder, "etherErrStats", "DeferredTx", stat.deferredTx, milliseconds);
            addNumAttr(appResourceBuilder, "etherErrStats", "Fcs", stat.fcs, milliseconds);
            addNumAttr(appResourceBuilder, "etherErrStats", "IntMacRx", stat.intMacRx, milliseconds);
            addNumAttr(appResourceBuilder, "etherErrStats", "IntMacTx", stat.intMacTx, milliseconds);
            addNumAttr(appResourceBuilder, "etherErrStats", "OutDiscard", stat.outDiscard, milliseconds);
            addNumAttr(appResourceBuilder, "etherErrStats", "Rcv", stat.rcv, milliseconds);
            addNumAttr(appResourceBuilder, "etherErrStats", "UnderSize", stat.underSize, milliseconds);
            addNumAttr(appResourceBuilder, "etherErrStats", "Xmit", stat.xmit, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherLossStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsEtherLossStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "etherLossStats");

            addNumAttr(appResourceBuilder, "etherLossStats", "CarrierSense", stat.carrierSense, milliseconds);
            addNumAttr(appResourceBuilder, "etherLossStats", "ExcessCollision", stat.excessCollision, milliseconds);
            addNumAttr(appResourceBuilder, "etherLossStats", "Giants", stat.giants, milliseconds);
            addNumAttr(appResourceBuilder, "etherLossStats", "LateCollision", stat.lateCollision, milliseconds);
            addNumAttr(appResourceBuilder, "etherLossStats", "MultiCollision", stat.multiCollision, milliseconds);
            addNumAttr(appResourceBuilder, "etherLossStats", "SingleCollision", stat.singleCollision, milliseconds);
            addNumAttr(appResourceBuilder, "etherLossStats", "SQETest", stat.SQETest, milliseconds);
            addNumAttr(appResourceBuilder, "etherLossStats", "Symbol", stat.symbol, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherNiErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsEtherNiErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "etherNiErrorStats");

            addNumAttr(appResourceBuilder, "etherNiErrorStats", "Crc", stat.crc, milliseconds);
            addNumAttr(appResourceBuilder, "etherNiErrorStats", "FrameTx", stat.frameTx, milliseconds);
            addNumAttr(appResourceBuilder, "etherNiErrorStats", "InRange", stat.inRange, milliseconds);
            addNumAttr(appResourceBuilder, "etherNiErrorStats", "TooLong", stat.tooLong, milliseconds);
            addNumAttr(appResourceBuilder, "etherNiErrorStats", "TooShort", stat.tooShort, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherPauseStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsEtherPauseStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "etherPauseStats");

            addNumAttr(appResourceBuilder, "etherPauseStats", "RecvPause", stat.recvPause, milliseconds);
            addNumAttr(appResourceBuilder, "etherPauseStats", "XmitPause", stat.xmitPause, milliseconds);
            addNumAttr(appResourceBuilder, "etherPauseStats", "Resets", stat.resets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorEthPortErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsAdaptorEthPortErrStats.forEach(stat -> {
            String group = "adaptorEthPortErrStats";
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addNumAttr(appResourceBuilder, group, "BadCrcPackets"+stat.trafficDirection, stat.badCrcPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "BadLengthPackets"+stat.trafficDirection, stat.badLengthPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "MacDiscardedPackets"+stat.trafficDirection, stat.macDiscardedPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorEthPortMcastStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsAdaptorEthPortMcastStats.forEach(stat -> {
            String group = "adaptorEthPortMcastStats";
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addNumAttr(appResourceBuilder, group, "BroadcastPackets"+stat.trafficDirection, stat.broadcastPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "MulticastPackets"+stat.trafficDirection, stat.multicastPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "UnicastPackets"+stat.trafficDirection, stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorEthPortStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsAdaptorEthPortStats.forEach(stat -> {
            String group = "adaptorEthPortStats";
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addNumAttr(appResourceBuilder, group, "GoodPackets"+stat.trafficDirection, stat.goodPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "PausePackets"+stat.trafficDirection, stat.pausePackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "TotalPackets"+stat.trafficDirection, stat.totalPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "VlanPackets"+stat.trafficDirection, stat.vlanPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "PppPackets"+stat.trafficDirection, stat.pppPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "PerPriorityPausePackets"+stat.trafficDirection, stat.perPriorityPausePackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorVnicStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        stats.ucsAdaptorVnicStats.forEach(stat -> {
            String group = "adaptorVnicStats";
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addNumAttr(appResourceBuilder, group, "bytesRx", stat.bytesRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "bytesTx", stat.bytesTx, milliseconds);
            addNumAttr(appResourceBuilder, group, "packetsRx", stat.packetsRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "packetsTx", stat.packetsTx, milliseconds);
            addNumAttr(appResourceBuilder, group, "droppedRx", stat.droppedRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "droppedTx", stat.droppedTx, milliseconds);
            addNumAttr(appResourceBuilder, group, "errorsRx", stat.errorsRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "errorsTx", stat.errorsTx, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentPsuInputStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsEquipmentPsuInputStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "equipmentPsuInput");
            appResourceBuilder.addStringAttribute(createStringAttribute("equipmentPsuInput", "inputStatus", stat.inputStatus));
            addNumAttr(appResourceBuilder, "equipmentPsuInput", "Current", stat.current);
            addNumAttr(appResourceBuilder, "equipmentPsuInput", "Power", stat.power);
            addNumAttr(appResourceBuilder, "equipmentPsuInput", "Voltage", stat.voltage);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentPsuStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsEquipmentPsuStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "equipmentPsu");
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
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "equipmentPsu");

            addNumAttr(appResourceBuilder, "equipmentIOCard", "AmbientTemp", stat.ambientTemp);
            addNumAttr(appResourceBuilder, "equipmentIOCard", "IomI2CErrors", stat.IomI2CErrors);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentFanModuleStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsEquipmentFanModuleStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "equipmentFanModule");

            addNumAttr(appResourceBuilder, "equipmentFanModule", "AmbientTemp", stat.ambientTemp);
            addNumAttr(appResourceBuilder, "equipmentFanModule", "FanModuleI2CErrors", stat.FanModuleI2CErrors);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentFanStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsEquipmentFanStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "equipmentFan");

            addNumAttr(appResourceBuilder, "equipmentFan", "Speed", stat.speed);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsStorageDiskEnvStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsStorageDiskEnvStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "storageDiskEnvStats");

            addNumAttr(appResourceBuilder, "storageDiskEnvStats", "Temperature", stat.temperature);
            addNumAttr(appResourceBuilder, "storageDiskEnvStats", "WearPercentage", stat.wearPercentage);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsStorageSsdHealthStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        stats.ucsStorageSsdHealthStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, "storageSsdHealthStats");

            appResourceBuilder.addStringAttribute(createStringAttribute("storageSsdHealthStats", "Id", stat.id));
            addNumAttr(appResourceBuilder, "storageSsdHealthStats", "PercentageLifeLeft", stat.percentageLifeLeft);
            addNumAttr(appResourceBuilder, "storageSsdHealthStats", "PowerCycleCount", stat.powerCycleCount);
            addNumAttr(appResourceBuilder, "storageSsdHealthStats", "PowerOnHours", stat.powerOnHours);
            addNumAttr(appResourceBuilder, "storageSsdHealthStats", "WearStatusInDays", stat.wearStatusInDays);
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
