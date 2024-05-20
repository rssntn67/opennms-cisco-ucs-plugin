package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentFanStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int speed;
    public final int speedAvg;
    public final int speedMax;
    public final int speedMin;

    private UcsEquipmentFanStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentFanStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        speed = builder.speed;
        speedAvg = builder.speedAvg;
        speedMax = builder.speedMax;
        speedMin = builder.speedMin;
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
        private int speedAvg;
        private int speedMax;
        private int speedMin;

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

        public Builder withspeed(int speed){
            this.speed = speed;
            return this;
        }

        public Builder withspeedAvg(int speedAvg){
            this.speedAvg = speedAvg;
            return this;
        }

        public Builder withspeedMax(int speedMax){
            this.speedMax = speedMax;
            return this;
        }

        public Builder withspeedMin(int speedMin){
            this.speedMin = speedMin;
            return this;
        }

        public UcsEquipmentFanStats build() {
            return new UcsEquipmentFanStats(this);
        }
    }
}
