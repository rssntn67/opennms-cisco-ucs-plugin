package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsStorageSsdHealthStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int id;
    public final int percentageLifeLeft;
    public final int powerCycleCount;
    public final int powerOnHours;
    public final int wearStatusInDays;

    private UcsStorageSsdHealthStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.storageSsdHealthStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        id = builder.id;
        percentageLifeLeft = builder.percentageLifeLeft;
        powerCycleCount = builder.powerCycleCount;
        powerOnHours = builder.powerOnHours;
        wearStatusInDays = builder.wearStatusInDays;
    }

    @Override
    public String toString() {
        return "UcsStorageSsdHealthStats{" +
                "id=" + id +
                ", percentageLifeLeft=" + percentageLifeLeft +
                ", powerCycleCount=" + powerCycleCount +
                ", powerOnHours=" + powerOnHours +
                ", wearStatusInDays=" + wearStatusInDays +
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

    public static class Builder {
        private Builder() {

        }

        private UcsDn dn;
        public long intervals;
        public String suspect;
        public String thresholded;
        public Date timeCollected;
        public long update;

        private int id;
        private int percentageLifeLeft;
        private int powerCycleCount;
        private int powerOnHours;
        private int wearStatusInDays;

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

        public Builder withId(int id){
            this.id = id;
            return this;
        }

        public Builder withPercentageLifeLeft(int percentageLifeLeft){
            this.percentageLifeLeft = percentageLifeLeft;
            return this;
        }

        public Builder withPowerCycleCount(int powerCycleCount){
            this.powerCycleCount = powerCycleCount;
            return this;
        }

        public Builder withPowerOnHours(int powerOnHours){
            this.powerOnHours = powerOnHours;
            return this;
        }

        public Builder withWearStatusInDays(int wearStatusInDays){
            this.wearStatusInDays = wearStatusInDays;
            return this;
        }

        public UcsStorageSsdHealthStats build() {
            return new UcsStorageSsdHealthStats(this);
        }
    }
}
