package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.math.BigDecimal;
import java.util.Date;

public class UcsEquipmentNetworkElementFanStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final String airflowDirection;
    public final int drivePercentage;
    public final Aggregate drivePercentageAgg;
    public final int speed;
    public final Aggregate speedAgg;

    private UcsEquipmentNetworkElementFanStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentNetworkElementFanStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        airflowDirection = builder.airflowDirection;
        drivePercentage = builder.drivePercentage;
        drivePercentageAgg = Aggregate.builder()
                .withAverage(BigDecimal.valueOf(builder.drivePercentageAvg))
                .withMax(BigDecimal.valueOf(builder.drivePercentageMax))
                .withMin(BigDecimal.valueOf(builder.drivePercentageMin))
                .build();
        speed = builder.speed;
        speedAgg = Aggregate.builder()
                .withMax(BigDecimal.valueOf(builder.speedMax))
                .withAverage(BigDecimal.valueOf(builder.speedAvg))
                .withMin(BigDecimal.valueOf(builder.speedMin))
                .build();
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
        private int drivePercentageAvg;
        private int drivePercentageMax;
        private int drivePercentageMin;
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

        public Builder withairflowDirection(String airflowDirection){
            this.airflowDirection = airflowDirection;
            return this;
        }

        public Builder withdrivePercentage(int drivePercentage){
            this.drivePercentage = drivePercentage;
            return this;
        }

        public Builder withdrivePercentageAvg(int drivePercentageAvg){
            this.drivePercentageAvg = drivePercentageAvg;
            return this;
        }

        public Builder withdrivePercentageMax(int drivePercentageMax){
            this.drivePercentageMax = drivePercentageMax;
            return this;
        }

        public Builder withdrivePercentageMin(int drivePercentageMin){
            this.drivePercentageMin = drivePercentageMin;
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

        public UcsEquipmentNetworkElementFanStats build() {
            return new UcsEquipmentNetworkElementFanStats(this);
        }
    }
}
