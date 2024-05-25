package it.xeniaprogetti.cisco.ucs.plugin.client.api;

public class UcsEquipmentStats {
    public final UcsEquipmentChassisStats ucsEquipmentChassisStats;

    public static Builder builder() {
        return new Builder();
    }

    private UcsEquipmentStats(Builder builder) {
        this.ucsEquipmentChassisStats = builder.ucsEquipmentChassisStats;
    }

    public static class Builder {

        private UcsEquipmentChassisStats ucsEquipmentChassisStats;

        private Builder() {

        }

        public Builder withUcsEquipmentChassisStats(UcsEquipmentChassisStats ucsEquipmentChassisStats) {
            this.ucsEquipmentChassisStats = ucsEquipmentChassisStats;
            return this;
        }

        public UcsEquipmentStats build() {
            return new UcsEquipmentStats(this);
        }

    }
}
