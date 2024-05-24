package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.List;

public class UcsNetworkElementStats {
    public final List<UcsEquipmentNetworkElementFanStats> ucsEquipmentNetworkElementFanStatsList;
    public final UcsSwEnvStats ucsSwEnvStats;
    public final UcsSwCardEnvStats ucsSwCardEnvStats;
    public final UcsSwSystemStats ucsSwSystemStats;

    public static Builder builder() {
        return new Builder();
    }

    private UcsNetworkElementStats(Builder builder) {
        this.ucsEquipmentNetworkElementFanStatsList = builder.ucsEquipmentNetworkElementFanStatsList;
        this.ucsSwEnvStats = builder.ucsSwEnvStats;
        this.ucsSwSystemStats = builder.ucsSwSystemStats;
        this.ucsSwCardEnvStats= builder.ucsSwCardEnvStats;
    }


    public static class Builder {
        private UcsSwEnvStats ucsSwEnvStats;
        private UcsSwSystemStats ucsSwSystemStats;
        private UcsSwCardEnvStats ucsSwCardEnvStats;
        private List<UcsEquipmentNetworkElementFanStats> ucsEquipmentNetworkElementFanStatsList;

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



        public UcsNetworkElementStats build() {
            return new UcsNetworkElementStats(this);
        }
    }




    }
