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

    public static void addGaugeNumAttr(ImmutableCollectionSetResource.Builder<? extends Resource> builder, String groupId,
                                       String name, Number value) {
        if(value != null) {
            builder.addNumericAttribute(createGaugeNumAttr(groupId, name, value.doubleValue()));
        }

    }

    public static void addCounterNumAttr(ImmutableCollectionSetResource.Builder<? extends Resource> builder, String groupId,
                                         String name, Number value, long milliseconds) {
        if(value != null) {
            builder.addNumericAttribute(createCounterNumAttr(groupId, name, value.doubleValue() * 1000 / milliseconds));
        }
    }

    public static StringAttribute createStringAttribute(String groupId, String name, String value) {
        return ImmutableStringAttribute.newBuilder().setGroup(groupId).setName(name).setValue(value).build();
    }

    public static NumericAttribute createGaugeNumAttr(String groupId, String name, double value) {
        return ImmutableNumericAttribute.newBuilder()
                .setGroup(groupId)
                .setName(name).setValue(value)
                .setType(NumericAttribute.Type.GAUGE)
                .build();
    }

    public static NumericAttribute createCounterNumAttr(String groupId, String name, double value) {
        return ImmutableNumericAttribute.newBuilder()
                .setGroup(groupId)
                .setName(name).setValue(value)
                .setType(NumericAttribute.Type.COUNTER)
                .build();
    }

    public static void addAggregate(ImmutableCollectionSetResource.Builder<? extends Resource> builder, String groupId,
                              String prefix, Aggregate aggregate) {
        if(aggregate != null) {
            addGaugeNumAttr(builder, groupId, prefix + "Min", aggregate.getMin());
            addGaugeNumAttr(builder, groupId, prefix + "Max", aggregate.getMax());
            addGaugeNumAttr(builder, groupId, prefix + "Avg", aggregate.getAverage());
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
        addGaugeNumAttr(builder,group, "MainBoardOutlet1", stats.mainBoardOutlet1);
        addGaugeNumAttr(builder,group, "MainBoardOutlet2", stats.mainBoardOutlet2);
    }

    public static void addUcsSwSystemStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsSwSystemStats stats) {
        final String group = "ucsSwSystemStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addGaugeNumAttr(builder,group, "Load", stats.load);
        addGaugeNumAttr(builder,group, "MemAvailable", stats.memAvailable);
        addGaugeNumAttr(builder,group, "MemCached", stats.memCached);
    }

    public static void addUcsComputeMbPowerStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputeMbPowerStats stats) {
        final String group = "ucsComputeMbPowerStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addGaugeNumAttr(builder, group, "ConsumedPower", stats.consumedPower);
        addGaugeNumAttr(builder, group, "InputCurrent", stats.inputCurrent);
        addGaugeNumAttr(builder, group, "InputVoltage", stats.inputVoltage);
    }

    public static void addUcsComputeMbTempStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputeMbTempStats stats) {
        final String group = "ucsComputeMbTempStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addGaugeNumAttr(builder, group, "FmTempSenIo", stats.fmTempSenIo);
        addGaugeNumAttr(builder, group, "FmTempSenRear", stats.fmTempSenRear);
    }

    public static void addUcsComputePCIeFatalCompletionStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalCompletionStats stats, int milliseconds) {
        final String group = "ucsComputePCIeFatalCompletionStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addCounterNumAttr(builder, group, "AbortErrors", stats.AbortErrors, milliseconds);
        addCounterNumAttr(builder, group, "TimeoutErrors", stats.TimeoutErrors, milliseconds);
        addCounterNumAttr(builder, group, "UnexpectedErrors", stats.unexpectedErrors, milliseconds);
    }

    public static void addUcsComputePCIeFatalProtocolStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalProtocolStats stats, int milliseconds) {
        final String group = "ucsComputePCIeFatalProtocolStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addCounterNumAttr(builder, group, "DllpErrors", stats.dllpErrors, milliseconds);
        addCounterNumAttr(builder, group, "FlowControlErrors", stats.flowControlErrors, milliseconds);
    }

    public static void addUcsComputePCIeFatalReceiveStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalReceiveStats stats, int milliseconds) {
        final String group = "ucsComputePCIeFatalReceiveStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addCounterNumAttr(builder, group, "BufferOverflowErrors", stats.bufferOverflowErrors, milliseconds);
        addCounterNumAttr(builder, group, "ErrFatalErrors", stats.errFatalErrors, milliseconds);
        addCounterNumAttr(builder, group, "ErrNonFatalErrors", stats.errNonFatalErrors, milliseconds);
        addCounterNumAttr(builder, group, "UnsupportedRequestErrors", stats.unsupportedRequestErrors, milliseconds);
    }

    public static void addUcsComputePCIeFatalStat(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsComputePCIeFatalStats stats, int milliseconds) {
        final String group = "ucsComputePCIeFatalStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addCounterNumAttr(builder, group, "AcsViolationErrors", stats.acsViolationErrors, milliseconds);
        addCounterNumAttr(builder, group, "MalformedTLPErrors", stats.malformedTLPErrors, milliseconds);
        addCounterNumAttr(builder, group, "PoisonedTLPErrors", stats.poisonedTLPErrors, milliseconds);
        addCounterNumAttr(builder, group, "SurpriseLinkDownErrors", stats.surpriseLinkDownErrors, milliseconds);
    }

    public static void addUcsEquipmentChassisStats(ImmutableCollectionSetResource.Builder<? extends Resource> builder, UcsEquipmentChassisStats stats) {
        final String group = "ucsEquipmentChassisStats";
        builder.addStringAttribute(createStringAttribute(group, group+".dn", stats.dn.value));
        addGaugeNumAttr(builder, group, "ChassisI2CErrors", stats.ChassisI2CErrors);
        addGaugeNumAttr(builder, group, "InputPower", stats.inputPower);
        addGaugeNumAttr(builder, group, "OutputPower", stats.outputPower);
    }

    public static void addEquipmentNetworkElementFanStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group ="ucsEquipmentNetworkElementFanStats";
        stats.ucsEquipmentNetworkElementFanStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            appResourceBuilder.addStringAttribute(createStringAttribute(group, "airFlowDirection", stat.airflowDirection));

            addGaugeNumAttr(appResourceBuilder, group, "Speed", stat.speed);
            addGaugeNumAttr(appResourceBuilder, group, "DrivePercentage", stat.drivePercentage);

            builder.addCollectionSetResource(appResourceBuilder.build());

        });
    }

    public static void addUcsFcStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsFcStats";
        stats.ucsFcStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder = getBuilderForResource(stat,nodeResource,group);

            addCounterNumAttr(appResourceBuilder, group, "ByteRx", stat.bytesRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "ByteTx", stat.bytesTx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "PacketsRx", stat.packetsRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "PacketsTx", stat.packetsTx, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());

        });
    }

    public static void addUcsFcErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsFcErrStats";
        stats.ucsFcErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder = getBuilderForResource(stat,nodeResource,group);

            addCounterNumAttr(appResourceBuilder, group, "LinkFailures", stat.linkFailures, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "SignalLosses", stat.signalLosses, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "SyncLosses", stat.syncLosses, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "Rx", stat.rx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "CrcRx", stat.crcRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "DiscardRx", stat.discardRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TooLongRx", stat.tooLongRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TooShortRx", stat.tooShortRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "Tx", stat.tx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "DiscardTx", stat.discardTx, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsProcessorEnvStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsProcessorEnvStats";
        stats.ucsProcessorEnvStats.forEach( stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addGaugeNumAttr(appResourceBuilder, group, "Temperature", stat.temperature);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsProcessorErrorStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsProcessorErrorStats";
        stats.ucsProcessorErrorStats.forEach( stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addCounterNumAttr(appResourceBuilder, group, "SparingErrors", stat.sparingErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "CorrectableLinkCRCErrors", stat.CorrectableLinkCRCErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "UncorrectableLinkCRCErrors", stat.UncorrectableLinkCRCErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "MirroringInterSockErrors", stat.mirroringInterSockErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "MirroringIntraSockErrors", stat.mirroringIntraSockErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "MmiLinkCorrErrors", stat.smiLinkCorrErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "MmiLinkUncorrErrors", stat.smiLinkUncorrErrors, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherRxStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherRxStats";
        stats.ucsEtherRxStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addCounterNumAttr(appResourceBuilder, group, "RxBroadcastPackets", stat.broadcastPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "RxJumboPackets", stat.jumboPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "RxMulticastPackets", stat.multicastPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "RxTotalBytes", stat.totalBytes, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "RxTotalPackets", stat.totalPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "RxUnicastPackets", stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherTxStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherTxStats";
        stats.ucsEtherTxStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addCounterNumAttr(appResourceBuilder, group, "TxBroadcastPackets", stat.broadcastPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TxJumboPackets", stat.jumboPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TxMulticastPackets", stat.multicastPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TxTotalBytes", stat.totalBytes, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TxTotalPackets", stat.totalPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TxUnicastPackets", stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherErrStats";
        stats.ucsEtherErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addCounterNumAttr(appResourceBuilder, group, "Align", stat.align, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "DeferredTx", stat.deferredTx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "Fcs", stat.fcs, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "IntMacRx", stat.intMacRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "IntMacTx", stat.intMacTx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "OutDiscard", stat.outDiscard, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "Rcv", stat.rcv, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "UnderSize", stat.underSize, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "Xmit", stat.xmit, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherLossStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherLossStats";
        stats.ucsEtherLossStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addCounterNumAttr(appResourceBuilder, group, "CarrierSense", stat.carrierSense, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "ExcessCollision", stat.excessCollision, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "Giants", stat.giants, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "LateCollision", stat.lateCollision, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "MultiCollision", stat.multiCollision, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "SingleCollision", stat.singleCollision, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "SQETest", stat.SQETest, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "Symbol", stat.symbol, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherNiErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherNiErrStats";
        stats.ucsEtherNiErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addCounterNumAttr(appResourceBuilder, group, "Crc", stat.crc, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "FrameTx", stat.frameTx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "InRange", stat.inRange, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TooLong", stat.tooLong, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TooShort", stat.tooShort, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEtherPauseStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsEtherPauseStats";
        stats.ucsEtherPauseStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addCounterNumAttr(appResourceBuilder, group, "RecvPause", stat.recvPause, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "XmitPause", stat.xmitPause, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "Resets", stat.resets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorEthPortErrStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsAdaptorEthPortErrStats";
        stats.ucsAdaptorEthPortErrStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addCounterNumAttr(appResourceBuilder, group, "BadCrcPackets"+stat.trafficDirection, stat.badCrcPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "BadLengthPackets"+stat.trafficDirection, stat.badLengthPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "MacDiscardedPackets"+stat.trafficDirection, stat.macDiscardedPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorEthPortMcastStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsAdaptorEthPortMcastStats";
        stats.ucsAdaptorEthPortMcastStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addCounterNumAttr(appResourceBuilder, group, "BroadcastPackets"+stat.trafficDirection, stat.broadcastPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "MulticastPackets"+stat.trafficDirection, stat.multicastPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "UnicastPackets"+stat.trafficDirection, stat.unicastPackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorEthPortStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsAdaptorEthPortStats";
        stats.ucsAdaptorEthPortStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addCounterNumAttr(appResourceBuilder, group, "GoodPackets"+stat.trafficDirection, stat.goodPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "PausePackets"+stat.trafficDirection, stat.pausePackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "TotalPackets"+stat.trafficDirection, stat.totalPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "VlanPackets"+stat.trafficDirection, stat.vlanPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "PppPackets"+stat.trafficDirection, stat.pppPackets, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "PerPriorityPausePackets"+stat.trafficDirection, stat.perPriorityPausePackets, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsAdaptorVnicStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsAdaptorVnicStats";
        stats.ucsAdaptorVnicStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addCounterNumAttr(appResourceBuilder, group, "bytesRx", stat.bytesRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "bytesTx", stat.bytesTx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "packetsRx", stat.packetsRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "packetsTx", stat.packetsTx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "droppedRx", stat.droppedRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "droppedTx", stat.droppedTx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "errorsRx", stat.errorsRx, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "errorsTx", stat.errorsTx, milliseconds);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentPsuInputStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsEquipmentPsuInputStats";
        stats.ucsEquipmentPsuInputStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            appResourceBuilder.addStringAttribute(createStringAttribute(group, "inputStatus", stat.inputStatus));
            addGaugeNumAttr(appResourceBuilder, group, "Current", stat.current);
            addGaugeNumAttr(appResourceBuilder, group, "Power", stat.power);
            addGaugeNumAttr(appResourceBuilder, group, "Voltage", stat.voltage);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentPsuStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsEquipmentPsuStats";
        stats.ucsEquipmentPsuStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);
            addGaugeNumAttr(appResourceBuilder, group, "AmbientTemp", stat.ambientTemp);
            addGaugeNumAttr(appResourceBuilder, group, "Input210v", stat.input210v);
            addGaugeNumAttr(appResourceBuilder, group, "Output12v", stat.output12v);
            addGaugeNumAttr(appResourceBuilder, group, "Output3v3", stat.output3v3);
            addGaugeNumAttr(appResourceBuilder, group, "OutputCurrent", stat.outputCurrent);
            addGaugeNumAttr(appResourceBuilder, group, "OutputPower", stat.outputPower);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentIoCardStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsEquipmentIOCardStats";
        stats.ucsEquipmentIOCardStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addGaugeNumAttr(appResourceBuilder, group, "AmbientTemp", stat.ambientTemp);
            addGaugeNumAttr(appResourceBuilder, group, "IomI2CErrors", stat.IomI2CErrors);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentFanModuleStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsEquipmentFanModuleStats";
        stats.ucsEquipmentFanModuleStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addGaugeNumAttr(appResourceBuilder, group, "AmbientTemp", stat.ambientTemp);
            addGaugeNumAttr(appResourceBuilder, group, "FanModuleI2CErrors", stat.FanModuleI2CErrors);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsEquipmentFanStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsEquipmentFanStats";
        stats.ucsEquipmentFanStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addGaugeNumAttr(appResourceBuilder, group, "Speed", stat.speed);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsStorageDiskEnvStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsStorageDiskEnvStats";
        stats.ucsStorageDiskEnvStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addGaugeNumAttr(appResourceBuilder, group, "Temperature", stat.temperature);
            addGaugeNumAttr(appResourceBuilder, group, "WearPercentage", stat.wearPercentage);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsStorageSsdHealthStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsStorageSsdHealthStats";
        stats.ucsStorageSsdHealthStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            appResourceBuilder.addStringAttribute(createStringAttribute(group, "Id", stat.id));
            addGaugeNumAttr(appResourceBuilder, group, "PercentageLifeLeft", stat.percentageLifeLeft);
            addGaugeNumAttr(appResourceBuilder, group, "PowerCycleCount", stat.powerCycleCount);
            addGaugeNumAttr(appResourceBuilder, group, "PowerOnHours", stat.powerOnHours);
            addGaugeNumAttr(appResourceBuilder, group, "WearStatusInDays", stat.wearStatusInDays);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsMemoryUnitEnvStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource) {
        final String group = "ucsMemoryUnitEnvStats";
        stats.ucsMemoryUnitEnvStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addGaugeNumAttr(appResourceBuilder, group, "Temperature", stat.temperature);
            builder.addCollectionSetResource(appResourceBuilder.build());
        });
    }

    public static void addUcsMemoryErrorStats(ImmutableCollectionSet.Builder builder, UcsDataCollection stats, ImmutableNodeResource nodeResource, int milliseconds) {
        final String group = "ucsMemoryErrorStats";
        stats.ucsMemoryErrorStats.forEach(stat -> {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(stat, nodeResource, group);

            addCounterNumAttr(appResourceBuilder, group, "AddressParityErrors", stat.addressParityErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "AddressParityErrorsCorrectable", stat.addressParityErrorsCorrectable, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "AddressParityErrorsUnCorrectable", stat.addressParityErrorsUnCorrectable, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "DramWriteDataCorrectableCRCErrors", stat.DramWriteDataCorrectableCRCErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "DramWriteDataUnCorrectableCRCErrors", stat.DramWriteDataUnCorrectableCRCErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "MismatchErrors", stat.mismatchErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "EccMultibitErrors", stat.eccMultibitErrors, milliseconds);
            addCounterNumAttr(appResourceBuilder, group, "EccSinglebitErrors", stat.eccSinglebitErrors, milliseconds);
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
