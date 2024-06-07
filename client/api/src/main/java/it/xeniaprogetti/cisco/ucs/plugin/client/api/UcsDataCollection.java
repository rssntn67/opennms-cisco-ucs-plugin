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
    public final List<UcsEtherRxStats> ucsEtherRxStats;
    public final List<UcsEtherTxStats> ucsEtherTxStats;
    public final List<UcsEquipmentPsuInputStats> ucsEquipmentPsuInputStats;
    public final List<UcsEquipmentPsuStats> ucsEquipmentPsuStats;
    public final List<UcsEquipmentIOCardStats> ucsEquipmentIOCardStats;

    public static Builder builder() {
        return new Builder();
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
        this.ucsComputeMbTempStats = builder.ucsComputeMbTempStats;
        this.ucsComputeMbPowerStats = builder.ucsComputeMbPowerStats;
        this.ucsEtherRxStats = builder.ucsEtherRxStats;
        this.ucsEtherTxStats = builder.ucsEtherTxStats;
        this.ucsEquipmentPsuInputStats = builder.ucsEquipmentPsuInputStats;
        this.ucsEquipmentPsuStats = builder.ucsEquipmentPsuStats;
        this.ucsEquipmentIOCardStats = builder.ucsEquipmentIOCardStats;
    }

    public Optional<UcsSwEnvStats> getUcsSwEnvStats() {
        return Optional.of(ucsSwEnvStats);
    }

    public Optional<UcsSwSystemStats> getUcsSwSystemStats() {
        return Optional.of(ucsSwSystemStats);
    }

    public Optional<UcsSwCardEnvStats> getUcsSwCardEnvStats() {
        return Optional.of(ucsSwCardEnvStats);
    }

    public Optional<UcsEquipmentChassisStats> getUcsEquipmentChassisStats() {
        return Optional.of(ucsEquipmentChassisStats);
    }

    public Optional<UcsComputeMbPowerStats> getUcsComputeMbPowerStats() {
        return Optional.of(ucsComputeMbPowerStats);
    }

    public Optional<UcsComputeMbTempStats> getUcsComputeMbTempStats() {
        return Optional.of(ucsComputeMbTempStats);
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
                ", ucsEtherRxStats=" + ucsEtherRxStats +
                ", ucsEtherTxStats=" + ucsEtherTxStats +
                ", ucsEquipmentPsuInputStats=" + ucsEquipmentPsuInputStats +
                ", ucsEquipmentPsuStats=" + ucsEquipmentPsuStats +
                ", ucsEquipmentIOCardStats=" + ucsEquipmentIOCardStats +
                '}';
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
        private List<UcsEtherRxStats> ucsEtherRxStats;
        private List<UcsEtherTxStats> ucsEtherTxStats;
        private List<UcsEquipmentPsuInputStats> ucsEquipmentPsuInputStats;
        private List<UcsEquipmentPsuStats> ucsEquipmentPsuStats;
        private List<UcsEquipmentIOCardStats> ucsEquipmentIOCardStats;

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

        public UcsDataCollection build() {
            return new UcsDataCollection(this);
        }
    }




    }
