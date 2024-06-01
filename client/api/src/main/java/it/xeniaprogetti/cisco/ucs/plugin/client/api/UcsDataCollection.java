package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.List;

public class UcsDataCollection {
    public final List<UcsEquipmentNetworkElementFanStats> ucsEquipmentNetworkElementFanStatsList;
    public final UcsSwEnvStats ucsSwEnvStats;
    public final UcsSwCardEnvStats ucsSwCardEnvStats;
    public final UcsSwSystemStats ucsSwSystemStats;
    public final List<UcsFcStats> ucsFcStats;
    public final List<UcsFcErrStats> ucsFcErrStats;
    public final UcsEquipmentChassisStats ucsEquipmentChassisStats;
    public final List<UcsProcessorEnvStats> ucsProcessorEnvStats;
    public final UcsComputeMbPowerStats ucsComputeMbPowerStats;
    public final UcsComputeMbTempStats ucsComputeMbTempStats;

    public static Builder builder() {
        return new Builder();
    }

    private UcsDataCollection(Builder builder) {
        this.ucsEquipmentNetworkElementFanStatsList = builder.ucsEquipmentNetworkElementFanStatsList;
        this.ucsSwEnvStats = builder.ucsSwEnvStats;
        this.ucsSwSystemStats = builder.ucsSwSystemStats;
        this.ucsSwCardEnvStats= builder.ucsSwCardEnvStats;
        this.ucsFcStats = builder.ucsFcStats;
        this.ucsFcErrStats = builder.ucsFcErrStats;
        this.ucsEquipmentChassisStats = builder.ucsEquipmentChassisStats;
        this.ucsProcessorEnvStats = builder.ucsProcessorEnvStats;
        this.ucsComputeMbTempStats = builder.ucsComputeMbTempStats;
        this.ucsComputeMbPowerStats = builder.ucsComputeMbPowerStats;
    }


    public static class Builder {
        private UcsSwEnvStats ucsSwEnvStats;
        private UcsSwSystemStats ucsSwSystemStats;
        private UcsSwCardEnvStats ucsSwCardEnvStats;
        private List<UcsEquipmentNetworkElementFanStats> ucsEquipmentNetworkElementFanStatsList;
        private List<UcsFcStats> ucsFcStats;
        private List<UcsFcErrStats> ucsFcErrStats;
        private UcsEquipmentChassisStats ucsEquipmentChassisStats;
        private List<UcsProcessorEnvStats> ucsProcessorEnvStats;
        private UcsComputeMbPowerStats ucsComputeMbPowerStats;
        private UcsComputeMbTempStats ucsComputeMbTempStats;

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
            this.ucsEquipmentNetworkElementFanStatsList = ucsEquipmentNetworkElementFanStatsList;
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


        public UcsDataCollection build() {
            return new UcsDataCollection(this);
        }
    }




    }
