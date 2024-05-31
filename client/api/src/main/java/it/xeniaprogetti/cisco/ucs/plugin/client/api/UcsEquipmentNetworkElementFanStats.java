package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentNetworkElementFanStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final String airflowDirection;
    public final int drivePercentage;
    public final int speed;

    private UcsEquipmentNetworkElementFanStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentNetworkElementFanStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        airflowDirection = builder.airflowDirection;
        drivePercentage = builder.drivePercentage;
        speed = builder.speed;
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

        private String airflowDirection;
        private int drivePercentage;
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

        public Builder withairflowDirection(String airflowDirection){
            this.airflowDirection = airflowDirection;
            return this;
        }

        public Builder withDrivePercentage(int drivePercentage){
            this.drivePercentage = drivePercentage;
            return this;
        }

        public Builder withSpeed(int speed){
            this.speed = speed;
            return this;
        }


        public UcsEquipmentNetworkElementFanStats build() {
            return new UcsEquipmentNetworkElementFanStats(this);
        }
    }
}
