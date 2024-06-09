package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentFanStats extends UcsResourceTypeStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int speed;

    private UcsEquipmentFanStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentFanStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        speed = builder.speed;
    }

    @Override
    public String toString() {
        return "UcsEquipmentFanStats{" +
                "speed=" + speed +
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
        return UcsEnums.ResourceType.EquipFan;
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

        private int speed;

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

        public Builder withSpeed(int speed){
            this.speed = speed;
            return this;
        }

        public UcsEquipmentFanStats build() {
            return new UcsEquipmentFanStats(this);
        }
    }
}
