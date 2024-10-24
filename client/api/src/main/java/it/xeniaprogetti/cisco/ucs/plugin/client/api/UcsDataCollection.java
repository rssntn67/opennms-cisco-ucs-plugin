package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.List;
import java.util.Optional;

public class UcsDataCollection {
    private final UcsSwEnvStats ucsSwEnvStats;
    private final UcsSwCardEnvStats ucsSwCardEnvStats;
    private final UcsSwSystemStats ucsSwSystemStats;
    private final UcsComputeMbPowerStats ucsComputeMbPowerStats;
    private final UcsComputeMbTempStats ucsComputeMbTempStats;
    private final UcsEquipmentChassisStats ucsEquipmentChassisStats;
    public final List<UcsFcStats> ucsFcStats;
    public final List<UcsFcErrStats> ucsFcErrStats;
    public final List<UcsEquipmentNetworkElementFanStats> ucsEquipmentNetworkElementFanStats;
    public final List<UcsProcessorEnvStats> ucsProcessorEnvStats;
    public final List<UcsProcessorErrorStats> ucsProcessorErrorStats;
    public final List<UcsEtherRxStats> ucsEtherRxStats;
    public final List<UcsEtherTxStats> ucsEtherTxStats;
    public final List<UcsEquipmentPsuInputStats> ucsEquipmentPsuInputStats;
    public final List<UcsEquipmentPsuStats> ucsEquipmentPsuStats;
    public final List<UcsEquipmentIOCardStats> ucsEquipmentIOCardStats;
    public final List<UcsEtherErrStats> ucsEtherErrStats;
    public final List<UcsEtherLossStats> ucsEtherLossStats;
    public final List<UcsEtherPauseStats> ucsEtherPauseStats;
    public final List<UcsEtherNiErrStats> ucsEtherNiErrStats;
    public final List<UcsEquipmentFanModuleStats> ucsEquipmentFanModuleStats;
    public final List<UcsEquipmentFanStats> ucsEquipmentFanStats;
    public final List<UcsAdaptorEthPortErrStats> ucsAdaptorEthPortErrStats;
    public final List<UcsAdaptorEthPortMcastStats> ucsAdaptorEthPortMcastStats;
    public final List<UcsAdaptorEthPortStats> ucsAdaptorEthPortStats;
    public final List<UcsAdaptorVnicStats> ucsAdaptorVnicStats;
    public final List<UcsStorageDiskEnvStats> ucsStorageDiskEnvStats;
    public final List<UcsStorageSsdHealthStats> ucsStorageSsdHealthStats;
    private final UcsComputePCIeFatalCompletionStats ucsComputePCIeFatalCompletionStats;
    private final UcsComputePCIeFatalProtocolStats ucsComputePCIeFatalProtocolStats;
    private final UcsComputePCIeFatalReceiveStats ucsComputePCIeFatalReceiveStats;
    private final UcsComputePCIeFatalStats ucsComputePCIeFatalStats;
    public final List<UcsMemoryErrorStats> ucsMemoryErrorStats;
    public final List<UcsMemoryUnitEnvStats> ucsMemoryUnitEnvStats;

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "UcsDataCollection{" +
                "ucsSwEnvStats=" + ucsSwEnvStats +
                ", ucsSwCardEnvStats=" + ucsSwCardEnvStats +
                ", ucsSwSystemStats=" + ucsSwSystemStats +
                ", ucsComputeMbPowerStats=" + ucsComputeMbPowerStats +
                ", ucsComputeMbTempStats=" + ucsComputeMbTempStats +
                ", ucsEquipmentChassisStats=" + ucsEquipmentChassisStats +
                ", ucsFcStats=" + ucsFcStats +
                ", ucsFcErrStats=" + ucsFcErrStats +
                ", ucsEquipmentNetworkElementFanStats=" + ucsEquipmentNetworkElementFanStats +
                ", ucsProcessorEnvStats=" + ucsProcessorEnvStats +
                ", ucsProcessorErrorStats=" + ucsProcessorErrorStats +
                ", ucsEtherRxStats=" + ucsEtherRxStats +
                ", ucsEtherTxStats=" + ucsEtherTxStats +
                ", ucsEquipmentPsuInputStats=" + ucsEquipmentPsuInputStats +
                ", ucsEquipmentPsuStats=" + ucsEquipmentPsuStats +
                ", ucsEquipmentIOCardStats=" + ucsEquipmentIOCardStats +
                ", ucsEtherErrStats=" + ucsEtherErrStats +
                ", ucsEtherLossStats=" + ucsEtherLossStats +
                ", ucsEtherPauseStats=" + ucsEtherPauseStats +
                ", ucsEtherNiErrStats=" + ucsEtherNiErrStats +
                ", ucsEquipmentFanModuleStats=" + ucsEquipmentFanModuleStats +
                ", ucsEquipmentFanStats=" + ucsEquipmentFanStats +
                ", ucsAdaptorEthPortErrStats=" + ucsAdaptorEthPortErrStats +
                ", ucsAdaptorEthPortMcastStats=" + ucsAdaptorEthPortMcastStats +
                ", ucsAdaptorEthPortStats=" + ucsAdaptorEthPortStats +
                ", ucsAdaptorVnicStats=" + ucsAdaptorVnicStats +
                ", ucsStorageDiskEnvStats=" + ucsStorageDiskEnvStats +
                ", ucsStorageSsdHealthStats=" + ucsStorageSsdHealthStats +
                ", ucsComputePCIeFatalCompletionStats=" + ucsComputePCIeFatalCompletionStats +
                ", ucsComputePCIeFatalProtocolStats=" + ucsComputePCIeFatalProtocolStats +
                ", ucsComputePCIeFatalReceiveStats=" + ucsComputePCIeFatalReceiveStats +
                ", ucsComputePCIeFatalStats=" + ucsComputePCIeFatalStats +
                ", ucsMemoryErrorStats=" + ucsMemoryErrorStats +
                ", ucsMemoryUnitEnvStats=" + ucsMemoryUnitEnvStats +
                '}';
    }

    private UcsDataCollection(Builder builder) {
        this.ucsEquipmentNetworkElementFanStats = builder.ucsEquipmentNetworkElementFanStats;
        this.ucsSwEnvStats = builder.ucsSwEnvStats;
        this.ucsSwSystemStats = builder.ucsSwSystemStats;
        this.ucsSwCardEnvStats= builder.ucsSwCardEnvStats;
        this.ucsFcStats = builder.ucsFcStats;
        this.ucsFcErrStats = builder.ucsFcErrStats;
        this.ucsEquipmentChassisStats = builder.ucsEquipmentChassisStats;
        this.ucsProcessorEnvStats = builder.ucsProcessorEnvStats;
        this.ucsProcessorErrorStats = builder.ucsProcessorErrorStats;
        this.ucsComputeMbTempStats = builder.ucsComputeMbTempStats;
        this.ucsComputeMbPowerStats = builder.ucsComputeMbPowerStats;
        this.ucsEtherRxStats = builder.ucsEtherRxStats;
        this.ucsEtherTxStats = builder.ucsEtherTxStats;
        this.ucsEquipmentPsuInputStats = builder.ucsEquipmentPsuInputStats;
        this.ucsEquipmentPsuStats = builder.ucsEquipmentPsuStats;
        this.ucsEquipmentIOCardStats = builder.ucsEquipmentIOCardStats;
        this.ucsEtherErrStats = builder.ucsEtherErrStats;
        this.ucsEtherLossStats = builder.ucsEtherLossStats;
        this.ucsEtherPauseStats = builder.ucsEtherPauseStats;
        this.ucsEtherNiErrStats = builder.ucsEtherNiErrStats;
        this.ucsEquipmentFanModuleStats = builder.ucsEquipmentFanModuleStats;
        this.ucsEquipmentFanStats = builder.ucsEquipmentFanStats;
        this.ucsAdaptorEthPortErrStats = builder.ucsAdaptorEthPortErrStats;
        this.ucsAdaptorEthPortMcastStats = builder.ucsAdaptorEthPortMcastStats;
        this.ucsAdaptorEthPortStats = builder.ucsAdaptorEthPortStats;
        this.ucsAdaptorVnicStats = builder.ucsAdaptorVnicStats;
        this.ucsStorageDiskEnvStats = builder.ucsStorageDiskEnvStats;
        this.ucsStorageSsdHealthStats = builder.ucsStorageSsdHealthStats;
        this.ucsComputePCIeFatalCompletionStats = builder.ucsComputePCIeFatalCompletionStats;
        this.ucsComputePCIeFatalProtocolStats = builder.ucsComputePCIeFatalProtocolStats;
        this.ucsComputePCIeFatalReceiveStats = builder.ucsComputePCIeFatalReceiveStats;
        this.ucsComputePCIeFatalStats = builder.ucsComputePCIeFatalStats;
        this.ucsMemoryErrorStats = builder.ucsMemoryErrorStats;
        this.ucsMemoryUnitEnvStats = builder.ucsMemoryUnitEnvStats;
    }

    public Optional<UcsSwEnvStats> getUcsSwEnvStats() {
        return Optional.ofNullable(ucsSwEnvStats);
    }

    public Optional<UcsSwSystemStats> getUcsSwSystemStats() {
        return Optional.ofNullable(ucsSwSystemStats);
    }

    public Optional<UcsSwCardEnvStats> getUcsSwCardEnvStats() {
        return Optional.ofNullable(ucsSwCardEnvStats);
    }

    public Optional<UcsEquipmentChassisStats> getUcsEquipmentChassisStats() {
        return Optional.ofNullable(ucsEquipmentChassisStats);
    }

    public Optional<UcsComputeMbPowerStats> getUcsComputeMbPowerStats() {
        return Optional.ofNullable(ucsComputeMbPowerStats);
    }

    public Optional<UcsComputeMbTempStats> getUcsComputeMbTempStats() {
        return Optional.ofNullable(ucsComputeMbTempStats);
    }

    public Optional<UcsComputePCIeFatalCompletionStats> getUcsComputePCIeFatalCompletionStats() {
        return Optional.ofNullable(ucsComputePCIeFatalCompletionStats);
    }

    public Optional<UcsComputePCIeFatalProtocolStats> getUcsComputePCIeFatalProtocolStats() {
        return Optional.ofNullable(ucsComputePCIeFatalProtocolStats);
    }

    public Optional<UcsComputePCIeFatalReceiveStats> getUcsComputePCIeFatalReceiveStats() {
        return Optional.ofNullable(ucsComputePCIeFatalReceiveStats);
    }

    public Optional<UcsComputePCIeFatalStats> getUcsComputePCIeFatalStats() {
        return Optional.ofNullable(ucsComputePCIeFatalStats);
    }

    public static class Builder {
        private UcsSwEnvStats ucsSwEnvStats;
        private UcsSwSystemStats ucsSwSystemStats;
        private UcsSwCardEnvStats ucsSwCardEnvStats;
        private UcsEquipmentChassisStats ucsEquipmentChassisStats;
        private UcsComputeMbPowerStats ucsComputeMbPowerStats;
        private UcsComputeMbTempStats ucsComputeMbTempStats;
        private List<UcsEquipmentNetworkElementFanStats> ucsEquipmentNetworkElementFanStats;
        private List<UcsFcStats> ucsFcStats;
        private List<UcsFcErrStats> ucsFcErrStats;
        private List<UcsProcessorEnvStats> ucsProcessorEnvStats;
        private List<UcsProcessorErrorStats> ucsProcessorErrorStats;
        private List<UcsEtherRxStats> ucsEtherRxStats;
        private List<UcsEtherTxStats> ucsEtherTxStats;
        private List<UcsEquipmentPsuInputStats> ucsEquipmentPsuInputStats;
        private List<UcsEquipmentPsuStats> ucsEquipmentPsuStats;
        private List<UcsEquipmentIOCardStats> ucsEquipmentIOCardStats;
        private List<UcsEtherErrStats> ucsEtherErrStats;
        private List<UcsEtherLossStats> ucsEtherLossStats;
        private List<UcsEtherPauseStats> ucsEtherPauseStats;
        private List<UcsEtherNiErrStats> ucsEtherNiErrStats;
        private List<UcsEquipmentFanModuleStats> ucsEquipmentFanModuleStats;
        private List<UcsEquipmentFanStats> ucsEquipmentFanStats;
        private List<UcsAdaptorEthPortErrStats> ucsAdaptorEthPortErrStats;
        private List<UcsAdaptorEthPortMcastStats> ucsAdaptorEthPortMcastStats;
        private List<UcsAdaptorEthPortStats> ucsAdaptorEthPortStats;
        private List<UcsAdaptorVnicStats> ucsAdaptorVnicStats;
        private List<UcsStorageDiskEnvStats> ucsStorageDiskEnvStats;
        private List<UcsStorageSsdHealthStats> ucsStorageSsdHealthStats;
        private UcsComputePCIeFatalCompletionStats ucsComputePCIeFatalCompletionStats;
        private UcsComputePCIeFatalProtocolStats ucsComputePCIeFatalProtocolStats;
        private UcsComputePCIeFatalReceiveStats ucsComputePCIeFatalReceiveStats;
        private UcsComputePCIeFatalStats ucsComputePCIeFatalStats;
        private List<UcsMemoryErrorStats> ucsMemoryErrorStats;
        private List<UcsMemoryUnitEnvStats> ucsMemoryUnitEnvStats;

        private Builder () {

        }

        public Builder withUcsSwEnvStats(final UcsSwEnvStats ucsSwEnvStats) {
            this.ucsSwEnvStats = ucsSwEnvStats;
            return this;
        }

        public Builder withUcsSwSystemStats(final UcsSwSystemStats ucsSwSystemStats) {
            this.ucsSwSystemStats =ucsSwSystemStats;
            return this;
        }

        public Builder withUcsSwCardEnvStats(final UcsSwCardEnvStats ucsSwCardEnvStats) {
            this.ucsSwCardEnvStats = ucsSwCardEnvStats;
            return this;
        }


        public Builder withUcsEquipmentNetworkElementFanStatsList(final List<UcsEquipmentNetworkElementFanStats> ucsEquipmentNetworkElementFanStatsList) {
            this.ucsEquipmentNetworkElementFanStats = ucsEquipmentNetworkElementFanStatsList;
            return this;
        }

        public Builder withUcsFcStats(List<UcsFcStats> ucsFcStats) {
            this.ucsFcStats = ucsFcStats;
            return this;
        }

        public Builder withUcsFcErrStats(List<UcsFcErrStats> ucsFcErrStats) {
            this.ucsFcErrStats = ucsFcErrStats;
            return this;
        }

        public Builder withUcsEquipmentChassisStats(UcsEquipmentChassisStats ucsEquipmentChassisStats) {
            this.ucsEquipmentChassisStats = ucsEquipmentChassisStats;
            return this;
        }

        public Builder withUcsProcessorEnvStats(List<UcsProcessorEnvStats> ucsProcessorEnvStats) {
            this.ucsProcessorEnvStats=ucsProcessorEnvStats;
            return this;
        }
        public Builder withUcsProcessorErrorStats(List<UcsProcessorErrorStats> ucsProcessorErrorStats) {
            this.ucsProcessorErrorStats=ucsProcessorErrorStats;
            return this;
        }

        public Builder withUcsComputeMbPowerStats(UcsComputeMbPowerStats ucsComputeMbPowerStats) {
            this.ucsComputeMbPowerStats = ucsComputeMbPowerStats;
            return this;
        }

        public Builder withUcsComputeTempStats(UcsComputeMbTempStats ucsComputeMbTempStats) {
            this.ucsComputeMbTempStats = ucsComputeMbTempStats;
            return this;
        }

        public Builder withUcsEtherRxStats(List<UcsEtherRxStats> ucsEtherRxStats) {
            this.ucsEtherRxStats = ucsEtherRxStats;
            return this;
        }

        public Builder withUcsEtherTxStats(List<UcsEtherTxStats> ucsEtherTxStats) {
            this.ucsEtherTxStats = ucsEtherTxStats;
            return this;
        }

        public Builder withUcsEtherErrStats(List<UcsEtherErrStats> ucsEtherErrStats) {
            this.ucsEtherErrStats = ucsEtherErrStats;
            return this;
        }

        public Builder withUcsEtherLossStats(List<UcsEtherLossStats> ucsEtherLossStats) {
            this.ucsEtherLossStats = ucsEtherLossStats;
            return this;
        }

        public Builder withUcsEtherPauseStats(List<UcsEtherPauseStats> ucsEtherPauseStats) {
            this.ucsEtherPauseStats = ucsEtherPauseStats;
            return this;
        }

        public Builder withUcsEtherNiErrStats(List<UcsEtherNiErrStats> ucsEtherNiErrStats) {
            this.ucsEtherNiErrStats = ucsEtherNiErrStats;
            return this;
        }


        public Builder withUcsEquipmentPsuInputStats(List<UcsEquipmentPsuInputStats> ucsEquipmentPsuInputStats) {
            this.ucsEquipmentPsuInputStats =  ucsEquipmentPsuInputStats;
            return this;
        }

        public Builder withUcsEquipmentPsuStats(List<UcsEquipmentPsuStats> ucsEquipmentPsuStats) {
            this.ucsEquipmentPsuStats =  ucsEquipmentPsuStats;
            return this;
        }

        public Builder withUcsEquipmentIOCardStats(List<UcsEquipmentIOCardStats> ucsEquipmentIOCardStats) {
            this.ucsEquipmentIOCardStats =  ucsEquipmentIOCardStats;
            return this;
        }

        public Builder withUcsEquipmentFanModuleStats(List<UcsEquipmentFanModuleStats> ucsEquipmentFanModuleStats) {
            this.ucsEquipmentFanModuleStats =  ucsEquipmentFanModuleStats;
            return this;
        }

        public Builder withUcsEquipmentFanStats(List<UcsEquipmentFanStats> ucsEquipmentFanStats) {
            this.ucsEquipmentFanStats =  ucsEquipmentFanStats;
            return this;
        }

        public Builder withUcsAdaptorEthPortErrStats(List<UcsAdaptorEthPortErrStats> ucsAdaptorEthPortErrStats) {
            this.ucsAdaptorEthPortErrStats = ucsAdaptorEthPortErrStats;
            return this;
        }

        public Builder withUcsAdaptorEthPortMcastStats(List<UcsAdaptorEthPortMcastStats> ucsAdaptorEthPortMcastStats) {
            this.ucsAdaptorEthPortMcastStats = ucsAdaptorEthPortMcastStats;
            return this;
        }

        public Builder withUcsAdaptorEthPortStats(List<UcsAdaptorEthPortStats> ucsAdaptorEthPortStats) {
            this.ucsAdaptorEthPortStats = ucsAdaptorEthPortStats;
            return this;
        }

        public Builder withUcsAdaptorVNicStats(List<UcsAdaptorVnicStats> ucsAdaptorVnicStats) {
            this.ucsAdaptorVnicStats = ucsAdaptorVnicStats;
            return this;
        }

        public Builder withUcsStorageDiskEnvStats(List<UcsStorageDiskEnvStats> ucsStorageDiskEnvStats) {
            this.ucsStorageDiskEnvStats = ucsStorageDiskEnvStats;
            return this;
        }

        public Builder withUcsStorageSsdHealthStats(List<UcsStorageSsdHealthStats> ucsStorageSsdHealthStats) {
            this.ucsStorageSsdHealthStats = ucsStorageSsdHealthStats;
            return this;
        }

        public Builder withUcsComputePCIeFatalCompletionStats(UcsComputePCIeFatalCompletionStats ucsComputePCIeFatalCompletionStats) {
            this.ucsComputePCIeFatalCompletionStats = ucsComputePCIeFatalCompletionStats;
            return this;
        }

        public Builder withUcsComputePCIeFatalProtocolStats(UcsComputePCIeFatalProtocolStats ucsComputePCIeFatalProtocolStats) {
            this.ucsComputePCIeFatalProtocolStats = ucsComputePCIeFatalProtocolStats;
            return this;
        }

        public Builder withUcsComputePCIeFatalReceiveStats(UcsComputePCIeFatalReceiveStats ucsComputePCIeFatalReceiveStats) {
            this.ucsComputePCIeFatalReceiveStats = ucsComputePCIeFatalReceiveStats;
            return this;
        }

        public Builder withUcsComputePCIeFatalStats(UcsComputePCIeFatalStats ucsComputePCIeFatalStats) {
            this.ucsComputePCIeFatalStats = ucsComputePCIeFatalStats;
            return this;
        }

        public Builder withUcsUcsMemoryErrorStats(List<UcsMemoryErrorStats> ucsMemoryErrorStats) {
            this.ucsMemoryErrorStats = ucsMemoryErrorStats;
            return this;
        }

        public Builder withUcsUcsMemoryUnitEnvStats(List<UcsMemoryUnitEnvStats> ucsMemoryUnitEnvStats) {
            this.ucsMemoryUnitEnvStats = ucsMemoryUnitEnvStats;
            return this;
        }

        public UcsDataCollection build() {
            return new UcsDataCollection(this);
        }
    }




    }
