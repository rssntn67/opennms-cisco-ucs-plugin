package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.math.BigDecimal;
import java.util.Date;

public class UcsProcessorEnvStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final String inputCurrent;
    public final String inputCurrentAvg;
    public final String inputCurrentMax;
    public final String inputCurrentMin;
    public final double temperature;
    public final Aggregate temperatureAgg;

    private UcsProcessorEnvStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.processorEnvStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        inputCurrent = builder.inputCurrent;
        inputCurrentAvg = builder.inputCurrentAvg;
        inputCurrentMax = builder.inputCurrentMax;
        inputCurrentMin = builder.inputCurrentMin;
        temperature = builder.temperature;
        temperatureAgg = Aggregate.builder()
                .withMin(BigDecimal.valueOf(builder.temperatureMin))
                .withMax(BigDecimal.valueOf(builder.temperatureMax))
                .withAverage(BigDecimal.valueOf(builder.temperatureAvg))
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

        private String inputCurrent;
        private String inputCurrentAvg;
        private String inputCurrentMax;
        private String inputCurrentMin;
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

        public Builder withinputCurrent(String inputCurrent){
            this.inputCurrent = inputCurrent;
            return this;
        }

        public Builder withinputCurrentAvg(String inputCurrentAvg){
            this.inputCurrentAvg = inputCurrentAvg;
            return this;
        }

        public Builder withinputCurrentMax(String inputCurrentMax){
            this.inputCurrentMax = inputCurrentMax;
            return this;
        }

        public Builder withinputCurrentMin(String inputCurrentMin){
            this.inputCurrentMin = inputCurrentMin;
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

        public UcsProcessorEnvStats build() {
            return new UcsProcessorEnvStats(this);
        }
    }
}
