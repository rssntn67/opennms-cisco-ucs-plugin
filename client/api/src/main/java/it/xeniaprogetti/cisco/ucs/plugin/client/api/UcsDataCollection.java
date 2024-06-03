package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.List;

public class UcsDataCollection {
    public final UcsSwEnvStats ucsSwEnvStats;
    public final UcsSwCardEnvStats ucsSwCardEnvStats;
    public final UcsSwSystemStats ucsSwSystemStats;
    public final UcsComputeMbPowerStats ucsComputeMbPowerStats;
    public final UcsComputeMbTempStats ucsComputeMbTempStats;
    public final UcsEquipmentChassisStats ucsEquipmentChassisStats;
    public final List<UcsFcStats> ucsFcStats;
    public final List<UcsFcErrStats> ucsFcErrStats;
    public final List<UcsEquipmentNetworkElementFanStats> ucsEquipmentNetworkElementFanStats;
    public final List<UcsProcessorEnvStats> ucsProcessorEnvStats;
    public final List<UcsEtherRxStats> ucsEtherRxStats;
    public final List<UcsEtherTxStats> ucsEtherTxStats;
    public final List<UcsEquipmentPsuInputStats> ucsEquipmentPsuInputStats;

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
    }


    public static class Builder {
        private UcsSwEnvStats ucsSwEnvStats;
        private UcsSwSystemStats ucsSwSystemStats;
        private UcsSwCardEnvStats ucsSwCardEnvStats;
        private List<UcsEquipmentNetworkElementFanStats> ucsEquipmentNetworkElementFanStats;
        private List<UcsFcStats> ucsFcStats;
        private List<UcsFcErrStats> ucsFcErrStats;
        private UcsEquipmentChassisStats ucsEquipmentChassisStats;
        private List<UcsProcessorEnvStats> ucsProcessorEnvStats;
        private UcsComputeMbPowerStats ucsComputeMbPowerStats;
        private UcsComputeMbTempStats ucsComputeMbTempStats;
        private List<UcsEtherRxStats> ucsEtherRxStats;
        private List<UcsEtherTxStats> ucsEtherTxStats;
        private List<UcsEquipmentPsuInputStats> ucsEquipmentPsuInputStats;

        private Builder () {

        }

        public Builder withUcsSwEnvStats(final UcsSwEnvStats ucsSwEnvStats) {
            this.ucsSwEnvStats = ucsSwEnvStats;
            return this;
        }

        public Builder withUcsSwSystemStats(final UcsSwSystemStats ucsSwSystemStats) {
            this.ucsSwSystemStats = ucsSwSystemStats;
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


        public UcsDataCollection build() {
            return new UcsDataCollection(this);
        }
    }




    }
