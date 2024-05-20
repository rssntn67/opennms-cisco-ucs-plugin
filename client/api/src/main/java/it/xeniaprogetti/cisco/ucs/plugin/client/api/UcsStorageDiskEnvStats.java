package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsStorageDiskEnvStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double temperature;
    public final double temperatureAvg;
    public final double temperatureMax;
    public final double temperatureMin;
    public final int wearPercentage;
    public final int wearPercentageAvg;
    public final int wearPercentageMax;
    public final int wearPercentageMin;

    private UcsStorageDiskEnvStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.storageDiskEnvStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        temperature = builder.temperature;
        temperatureAvg = builder.temperatureAvg;
        temperatureMax = builder.temperatureMax;
        temperatureMin = builder.temperatureMin;
        wearPercentage = builder.wearPercentage;
        wearPercentageAvg = builder.wearPercentageAvg;
        wearPercentageMax = builder.wearPercentageMax;
        wearPercentageMin = builder.wearPercentageMin;
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

        private double temperature;
        private double temperatureAvg;
        private double temperatureMax;
        private double temperatureMin;
        private int wearPercentage;
        private int wearPercentageAvg;
        private int wearPercentageMax;
        private int wearPercentageMin;

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

        public Builder withtemperature(double temperature){
            this.temperature = temperature;
            return this;
        }

        public Builder withtemperatureAvg(double temperatureAvg){
            this.temperatureAvg = temperatureAvg;
            return this;
        }

        public Builder withtemperatureMax(double temperatureMax){
            this.temperatureMax = temperatureMax;
            return this;
        }

        public Builder withtemperatureMin(double temperatureMin){
            this.temperatureMin = temperatureMin;
            return this;
        }

        public Builder withwearPercentage(int wearPercentage){
            this.wearPercentage = wearPercentage;
            return this;
        }

        public Builder withwearPercentageAvg(int wearPercentageAvg){
            this.wearPercentageAvg = wearPercentageAvg;
            return this;
        }

        public Builder withwearPercentageMax(int wearPercentageMax){
            this.wearPercentageMax = wearPercentageMax;
            return this;
        }

        public Builder withwearPercentageMin(int wearPercentageMin){
            this.wearPercentageMin = wearPercentageMin;
            return this;
        }

        public UcsStorageDiskEnvStats build() {
            return new UcsStorageDiskEnvStats(this);
        }
    }
}
