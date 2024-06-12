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
        final String group = "ucsSwCardEnvStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
    }

    public static void addUcsSwEnvStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsSwEnvStats stats) {
        final String group = "ucsSwEnvStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addNumAttr(builder,group, "MainBoardOutlet1", stats.mainBoardOutlet1);
        addNumAttr(builder,group, "MainBoardOutlet2", stats.mainBoardOutlet2);
    }

    public static void addUcsSwSystemStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsSwSystemStats stats) {
        final String group = "ucsSwSystemStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addNumAttr(builder,group, "Load", stats.load);
        addNumAttr(builder,group, "MemAvailable", stats.memAvailable);
        addNumAttr(builder,group, "MemCached", stats.memCached);
    }

    public static void addUcsComputeMbPowerStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputeMbPowerStats stats) {
        final String group = "ucsComputeMbPowerStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addNumAttr(builder, group, "ConsumedPower", stats.consumedPower);
        addNumAttr(builder, group, "InputCurrent", stats.inputCurrent);
        addNumAttr(builder, group, "InputVoltage", stats.inputVoltage);
    }

    public static void addUcsComputeMbTempStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputeMbTempStats stats) {
        final String group = "ucsComputeMbTempStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addNumAttr(builder, group, "FmTempSenIo", stats.fmTempSenIo);
        addNumAttr(builder, group, "FmTempSenRear", stats.fmTempSenRear);
    }

    public static void addUcsComputePCIeFatalCompletionStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalCompletionStats stats, int milliseconds) {
        final String group = "ucsComputePCIeFatalCompletionStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addNumAttr(builder, group, "AbortErrors", stats.AbortErrors, milliseconds);
        addNumAttr(builder, group, "TimeoutErrors", stats.TimeoutErrors, milliseconds);
        addNumAttr(builder, group, "UnexpectedErrors", stats.unexpectedErrors, milliseconds);
    }

    public static void addUcsComputePCIeFatalProtocolStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalProtocolStats stats, int milliseconds) {
        final String group = "ucsComputePCIeFatalProtocolStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addNumAttr(builder, group, "DllpErrors", stats.dllpErrors, milliseconds);
        addNumAttr(builder, group, "FlowControlErrors", stats.flowControlErrors, milliseconds);
    }

    public static void addUcsComputePCIeFatalReceiveStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalReceiveStats stats, int milliseconds) {
        final String group = "ucsComputePCIeFatalReceiveStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addNumAttr(builder, group, "BufferOverflowErrors", stats.bufferOverflowErrors, milliseconds);
        addNumAttr(builder, group, "ErrFatalErrors", stats.errFatalErrors, milliseconds);
        addNumAttr(builder, group, "ErrNonFatalErrors", stats.errNonFatalErrors, milliseconds);
        addNumAttr(builder, group, "UnsupportedRequestErrors", stats.unsupportedRequestErrors, milliseconds);
    }

    public static void addUcsComputePCIeFatalStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalStats stats, int milliseconds) {
        final String group = "ucsComputePCIeFatalStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addNumAttr(builder, group, "AcsViolationErrors", stats.acsViolationErrors, milliseconds);
        addNumAttr(builder, group, "MalformedTLPErrors", stats.malformedTLPErrors, milliseconds);
        addNumAttr(builder, group, "PoisonedTLPErrors", stats.poisonedTLPErrors, milliseconds);
        addNumAttr(builder, group, "SurpriseLinkDownErrors", stats.surpriseLinkDownErrors, milliseconds);
    }

    public static void addUcsEquipmentChassisStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsEquipmentChassisStats stats) {
        final String group = "ucsEquipmentChassisStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addNumAttr(builder, group, "ChassisI2CErrors", stats.ChassisI2CErrors);
        addNumAttr(builder, group, "InputPower", stats.inputPower);
        addNumAttr(builder, group, "OutputPower", stats.outputPower);
    }

    public static void addEquipmentNetworkElementFanStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group ="ucsEquipmentNetworkElementFanStats";
        stats.ucsEquipmentNetworkElementFanStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            appResourceBuilder.addStringAttribute(createStringAttribute(group, "airFlowDirection", stat.airflowDirection));

            addNumAttr(appResourceBuilder, group, "Speed", stat.speed);
            addNumAttr(appResourceBuilder, group, "DrivePercentage", stat.drivePercentage);

            builder.addCollectionSetResource(appResourceBuilder.build());

        });
    }

    public static void addUcsFcStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsFcStats";
        stats.ucsFcStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder = getBuilderForResource(stat,nodeResource,group);

            addNumAttr(appResourceBuilder, group, "ByteRx", stat.bytesRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "ByteTx", stat.bytesTx, milliseconds);
            addNumAttr(appResourceBuilder, group, "PacketsRx", stat.packetsRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "PacketsTx", stat.packetsTx, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());

        });
    }

    public static void addUcsFcErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsFcErrStats";
        stats.ucsFcErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder = getBuilderForResource(stat,nodeResource,group);

            addNumAttr(appResourceBuilder, group, "LinkFailures", stat.linkFailures, milliseconds);
            addNumAttr(appResourceBuilder, group, "SignalLosses", stat.signalLosses, milliseconds);
            addNumAttr(appResourceBuilder, group, "SyncLosses", stat.syncLosses, milliseconds);
            addNumAttr(appResourceBuilder, group, "Rx", stat.rx, milliseconds);
            addNumAttr(appResourceBuilder, group, "CrcRx", stat.crcRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "DiscardRx", stat.discardRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "TooLongRx", stat.tooLongRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "TooShortRx", stat.tooShortRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "Tx", stat.tx, milliseconds);
            addNumAttr(appResourceBuilder, group, "DiscardTx", stat.discardTx, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsProcessorEnvStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsProcessorEnvStats";
        stats.ucsProcessorEnvStats.forEach( stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addNumAttr(appResourceBuilder, group, "Temperature", stat.temperature);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsProcessorErrorStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsProcessorErrorStats";
        stats.ucsProcessorErrorStats.forEach( stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addNumAttr(appResourceBuilder, group, "SparingErrors", stat.sparingErrors, milliseconds);
            addNumAttr(appResourceBuilder, group, "CorrectableLinkCRCErrors", stat.CorrectableLinkCRCErrors, milliseconds);
            addNumAttr(appResourceBuilder, group, "UncorrectableLinkCRCErrors", stat.UncorrectableLinkCRCErrors, milliseconds);
            addNumAttr(appResourceBuilder, group, "MirroringInterSockErrors", stat.mirroringInterSockErrors, milliseconds);
            addNumAttr(appResourceBuilder, group, "MirroringIntraSockErrors", stat.mirroringIntraSockErrors, milliseconds);
            addNumAttr(appResourceBuilder, group, "MmiLinkCorrErrors", stat.smiLinkCorrErrors, milliseconds);
            addNumAttr(appResourceBuilder, group, "MmiLinkUncorrErrors", stat.smiLinkUncorrErrors, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherRxStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherRxStats";
        stats.ucsEtherRxStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "RxBroadcastPackets", stat.broadcastPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "RxJumboPackets", stat.jumboPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "RxMulticastPackets", stat.multicastPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "RxTotalBytes", stat.totalBytes, milliseconds);
            addNumAttr(appResourceBuilder, group, "RxTotalPackets", stat.totalPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "RxUnicastPackets", stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherTxStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherTxStats";
        stats.ucsEtherTxStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "TxBroadcastPackets", stat.broadcastPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "TxJumboPackets", stat.jumboPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "TxMulticastPackets", stat.multicastPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "TxTotalBytes", stat.totalBytes, milliseconds);
            addNumAttr(appResourceBuilder, group, "TxTotalPackets", stat.totalPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "TxUnicastPackets", stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherErrStats";
        stats.ucsEtherErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "Align", stat.align, milliseconds);
            addNumAttr(appResourceBuilder, group, "DeferredTx", stat.deferredTx, milliseconds);
            addNumAttr(appResourceBuilder, group, "Fcs", stat.fcs, milliseconds);
            addNumAttr(appResourceBuilder, group, "IntMacRx", stat.intMacRx, milliseconds);
            addNumAttr(appResourceBuilder, group, "IntMacTx", stat.intMacTx, milliseconds);
            addNumAttr(appResourceBuilder, group, "OutDiscard", stat.outDiscard, milliseconds);
            addNumAttr(appResourceBuilder, group, "Rcv", stat.rcv, milliseconds);
            addNumAttr(appResourceBuilder, group, "UnderSize", stat.underSize, milliseconds);
            addNumAttr(appResourceBuilder, group, "Xmit", stat.xmit, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherLossStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherLossStats";
        stats.ucsEtherLossStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "CarrierSense", stat.carrierSense, milliseconds);
            addNumAttr(appResourceBuilder, group, "ExcessCollision", stat.excessCollision, milliseconds);
            addNumAttr(appResourceBuilder, group, "Giants", stat.giants, milliseconds);
            addNumAttr(appResourceBuilder, group, "LateCollision", stat.lateCollision, milliseconds);
            addNumAttr(appResourceBuilder, group, "MultiCollision", stat.multiCollision, milliseconds);
            addNumAttr(appResourceBuilder, group, "SingleCollision", stat.singleCollision, milliseconds);
            addNumAttr(appResourceBuilder, group, "SQETest", stat.SQETest, milliseconds);
            addNumAttr(appResourceBuilder, group, "Symbol", stat.symbol, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherNiErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherNiErrStats";
        stats.ucsEtherNiErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "Crc", stat.crc, milliseconds);
            addNumAttr(appResourceBuilder, group, "FrameTx", stat.frameTx, milliseconds);
            addNumAttr(appResourceBuilder, group, "InRange", stat.inRange, milliseconds);
            addNumAttr(appResourceBuilder, group, "TooLong", stat.tooLong, milliseconds);
            addNumAttr(appResourceBuilder, group, "TooShort", stat.tooShort, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherPauseStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherPauseStats";
        stats.ucsEtherPauseStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "RecvPause", stat.recvPause, milliseconds);
            addNumAttr(appResourceBuilder, group, "XmitPause", stat.xmitPause, milliseconds);
            addNumAttr(appResourceBuilder, group, "Resets", stat.resets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorEthPortErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsAdaptorEthPortErrStats";
        stats.ucsAdaptorEthPortErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addNumAttr(appResourceBuilder, group, "BadCrcPackets"+stat.trafficDirection, stat.badCrcPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "BadLengthPackets"+stat.trafficDirection, stat.badLengthPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "MacDiscardedPackets"+stat.trafficDirection, stat.macDiscardedPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorEthPortMcastStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsAdaptorEthPortMcastStats";
        stats.ucsAdaptorEthPortMcastStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addNumAttr(appResourceBuilder, group, "BroadcastPackets"+stat.trafficDirection, stat.broadcastPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "MulticastPackets"+stat.trafficDirection, stat.multicastPackets, milliseconds);
            addNumAttr(appResourceBuilder, group, "UnicastPackets"+stat.trafficDirection, stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorEthPortStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsAdaptorEthPortStats";
        stats.ucsAdaptorEthPortStats.forEach(stat -> {
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
        final String group = "ucsAdaptorVnicStats";
        stats.ucsAdaptorVnicStats.forEach(stat -> {
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
        final String group = "ucsEquipmentPsuInputStats";
        stats.ucsEquipmentPsuInputStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            appResourceBuilder.addStringAttribute(createStringAttribute(group, "inputStatus", stat.inputStatus));
            addNumAttr(appResourceBuilder, group, "Current", stat.current);
            addNumAttr(appResourceBuilder, group, "Power", stat.power);
            addNumAttr(appResourceBuilder, group, "Voltage", stat.voltage);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentPsuStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsEquipmentPsuStats";
        stats.ucsEquipmentPsuStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addNumAttr(appResourceBuilder, group, "AmbientTemp", stat.ambientTemp);
            addNumAttr(appResourceBuilder, group, "Input210v", stat.input210v);
            addNumAttr(appResourceBuilder, group, "Output12v", stat.output12v);
            addNumAttr(appResourceBuilder, group, "Output3v3", stat.output3v3);
            addNumAttr(appResourceBuilder, group, "OutputCurrent", stat.outputCurrent);
            addNumAttr(appResourceBuilder, group, "OutputPower", stat.outputPower);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentIoCardStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsEquipmentIOCardStats";
        stats.ucsEquipmentIOCardStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "AmbientTemp", stat.ambientTemp);
            addNumAttr(appResourceBuilder, group, "IomI2CErrors", stat.IomI2CErrors);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentFanModuleStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsEquipmentFanModuleStats";
        stats.ucsEquipmentFanModuleStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "AmbientTemp", stat.ambientTemp);
            addNumAttr(appResourceBuilder, group, "FanModuleI2CErrors", stat.FanModuleI2CErrors);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentFanStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsEquipmentFanStats";
        stats.ucsEquipmentFanStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "Speed", stat.speed);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsStorageDiskEnvStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsStorageDiskEnvStats";
        stats.ucsStorageDiskEnvStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "Temperature", stat.temperature);
            addNumAttr(appResourceBuilder, group, "WearPercentage", stat.wearPercentage);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsStorageSsdHealthStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsStorageSsdHealthStats";
        stats.ucsStorageSsdHealthStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            appResourceBuilder.addStringAttribute(createStringAttribute(group, "Id", stat.id));
            addNumAttr(appResourceBuilder, group, "PercentageLifeLeft", stat.percentageLifeLeft);
            addNumAttr(appResourceBuilder, group, "PowerCycleCount", stat.powerCycleCount);
            addNumAttr(appResourceBuilder, group, "PowerOnHours", stat.powerOnHours);
            addNumAttr(appResourceBuilder, group, "WearStatusInDays", stat.wearStatusInDays);
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
