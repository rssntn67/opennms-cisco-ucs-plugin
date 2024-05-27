package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.math.BigDecimal;
import java.util.Date;

public class UcsComputeMbPowerStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double consumedPower;
    public final Aggregate consumedPowerAgg;
    public final double inputCurrent;
    public final Aggregate inputCurrentAgg;
    public final double inputVoltage;
    public final Aggregate inputVoltageAgg;

    private UcsComputeMbPowerStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computeMbPowerStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        consumedPower = builder.consumedPower;
        inputCurrent = builder.inputCurrent;
        inputVoltage = builder.inputVoltage;
        consumedPowerAgg = Aggregate.builder()
                .withAverage(BigDecimal.valueOf(builder.consumedPowerAvg))
                .withMax(BigDecimal.valueOf(builder.consumedPowerMax))
                .withMin(BigDecimal.valueOf(builder.consumedPowerMin))
                .build();
        inputCurrentAgg = Aggregate.builder()
                .withAverage(BigDecimal.valueOf(builder.inputCurrentAvg))
                .withMax(BigDecimal.valueOf(builder.inputCurrentMax))
                .withMin(BigDecimal.valueOf(builder.inputCurrentMin))
                .build();
        inputVoltageAgg = Aggregate.builder()
                .withAverage(BigDecimal.valueOf(builder.inputVoltageAvg))
                .withMax(BigDecimal.valueOf(builder.inputVoltageMax))
                .withMin(BigDecimal.valueOf(builder.inputVoltageMin))
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

        private double consumedPower;
        private double consumedPowerAvg;
        private double consumedPowerMax;
        private double consumedPowerMin;
        private double inputCurrent;
        private double inputCurrentAvg;
        private double inputCurrentMax;
        private double inputCurrentMin;
        private double inputVoltage;
        private double inputVoltageAvg;
        private double inputVoltageMax;
        private double inputVoltageMin;

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

        public Builder withconsumedPower(double consumedPower){
            this.consumedPower = consumedPower;
            return this;
        }

        public Builder withconsumedPowerAvg(double consumedPowerAvg){
            this.consumedPowerAvg = consumedPowerAvg;
            return this;
        }

        public Builder withconsumedPowerMax(double consumedPowerMax){
            this.consumedPowerMax = consumedPowerMax;
            return this;
        }

        public Builder withconsumedPowerMin(double consumedPowerMin){
            this.consumedPowerMin = consumedPowerMin;
            return this;
        }

        public Builder withinputCurrent(double inputCurrent){
            this.inputCurrent = inputCurrent;
            return this;
        }

        public Builder withinputCurrentAvg(double inputCurrentAvg){
            this.inputCurrentAvg = inputCurrentAvg;
            return this;
        }

        public Builder withinputCurrentMax(double inputCurrentMax){
            this.inputCurrentMax = inputCurrentMax;
            return this;
        }

        public Builder withinputCurrentMin(double inputCurrentMin){
            this.inputCurrentMin = inputCurrentMin;
            return this;
        }

        public Builder withinputVoltage(double inputVoltage){
            this.inputVoltage = inputVoltage;
            return this;
        }

        public Builder withinputVoltageAvg(double inputVoltageAvg){
            this.inputVoltageAvg = inputVoltageAvg;
            return this;
        }

        public Builder withinputVoltageMax(double inputVoltageMax){
            this.inputVoltageMax = inputVoltageMax;
            return this;
        }

        public Builder withinputVoltageMin(double inputVoltageMin){
            this.inputVoltageMin = inputVoltageMin;
            return this;
        }

        public UcsComputeMbPowerStats build() {
            return new UcsComputeMbPowerStats(this);
        }
    }
}
