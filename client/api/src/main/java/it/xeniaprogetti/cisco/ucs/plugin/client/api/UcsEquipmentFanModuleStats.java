package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentFanModuleStats extends UcsResourceTypeStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int FanModuleI2CErrors;
    public final double ambientTemp;

    private UcsEquipmentFanModuleStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentFanModuleStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        FanModuleI2CErrors = builder.FanModuleI2CErrors;
        ambientTemp = builder.ambientTemp;
    }

    @Override
    public String toString() {
        return "UcsEquipmentFanModuleStats{" +
                "FanModuleI2CErrors=" + FanModuleI2CErrors +
                ", ambientTemp=" + ambientTemp +
                ", intervals=" + intervals +
                ", suspect='" + suspect + '\'' +
                ", thresholded='" + thresholded + '\'' +
                ", timeCollected=" + timeCollected +
                ", update=" + update +
                ", dn=" + dn +
                ", classId=" + classId +
                ", classItem=" + classItem +
                '}';
    }

    @Override
    public UcsEnums.ResourceType getResourceType() {
        return UcsEnums.ResourceType.EquipFanModule;
    }

    public static class Builder {
        private Builder() {

        }

        private UcsDn dn;
        public long intervals;
        public String suspect;
        public String thresholded;
        public Date timeCollected;
        public long update;

        private int FanModuleI2CErrors;
        private double ambientTemp;

        public Builder withDn(String dn) {
            this.dn = UcsDn.getDn(dn);
            return this;
        }

        public Builder withIntervals(long intervals) {
            this.intervals = intervals;
            return this;
        }

        public Builder withSuspect(String suspect) {
            this.suspect = suspect;
            return this;
        }

        public Builder withThresholded(String thresholded) {
            this.thresholded = thresholded;
            return this;
        }

        public Builder withTimeCollected(Date timeCollected) {
            this.timeCollected = timeCollected;
            return this;
        }

        public Builder withUpdate(long update) {
            this.update = update;
            return this;
        }

        public Builder withFanModuleI2CErrors(int FanModuleI2CErrors){
            this.FanModuleI2CErrors = FanModuleI2CErrors;
            return this;
        }

        public Builder withAmbientTemp(double ambientTemp){
            this.ambientTemp = ambientTemp;
            return this;
        }

        public UcsEquipmentFanModuleStats build() {
            return new UcsEquipmentFanModuleStats(this);
        }
    }
}
