package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsMemoryUnitEnvStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double temperature;
    public final double temperatureAvg;
    public final double temperatureMax;
    public final double temperatureMin;

    private UcsMemoryUnitEnvStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.memoryUnitEnvStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        temperature = builder.temperature;
        temperatureAvg = builder.temperatureAvg;
        temperatureMax = builder.temperatureMax;
        temperatureMin = builder.temperatureMin;
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

        public UcsMemoryUnitEnvStats build() {
            return new UcsMemoryUnitEnvStats(this);
        }
    }
}
