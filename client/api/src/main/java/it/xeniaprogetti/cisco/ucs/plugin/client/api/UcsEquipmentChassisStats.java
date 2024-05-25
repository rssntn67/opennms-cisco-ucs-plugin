package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.math.BigDecimal;
import java.util.Date;

public class UcsEquipmentChassisStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int ChassisI2CErrors;
    public final Aggregate ChassisI2CErrorsAgg;
    public final double inputPower;
    public final Aggregate inputPowerAgg;
    public final double outputPower;
    public final Aggregate outputPowerAgg;

    private UcsEquipmentChassisStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentChassisStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        ChassisI2CErrors = builder.ChassisI2CErrors;
        ChassisI2CErrorsAgg = Aggregate.builder()
                .withAverage(BigDecimal.valueOf(builder.ChassisI2CErrorsAvg))
                .withMax(BigDecimal.valueOf(builder.ChassisI2CErrorsMax))
                .withMin(BigDecimal.valueOf(builder.ChassisI2CErrorsMin))
                .build();
        inputPower = builder.inputPower;
        inputPowerAgg = Aggregate.builder()
                .withAverage(BigDecimal.valueOf(builder.inputPowerAvg))
                .withMax(BigDecimal.valueOf(builder.inputPowerMax))
                .withMin(BigDecimal.valueOf(builder.inputPowerMin))
                .build();
        outputPower = builder.outputPower;
        outputPowerAgg = Aggregate.builder()
                .withAverage(BigDecimal.valueOf(builder.outputPowerAvg))
                .withMax(BigDecimal.valueOf(builder.outputPowerMax))
                .withMin(BigDecimal.valueOf(builder.outputPowerMin))
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

        private int ChassisI2CErrors;
        private int ChassisI2CErrorsAvg;
        private int ChassisI2CErrorsMax;
        private int ChassisI2CErrorsMin;
        private double inputPower;
        private double inputPowerAvg;
        private double inputPowerMax;
        private double inputPowerMin;
        private double outputPower;
        private double outputPowerAvg;
        private double outputPowerMax;
        private double outputPowerMin;

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

        public Builder withChassisI2CErrors(int ChassisI2CErrors){
            this.ChassisI2CErrors = ChassisI2CErrors;
            return this;
        }

        public Builder withChassisI2CErrorsAvg(int ChassisI2CErrorsAvg){
            this.ChassisI2CErrorsAvg = ChassisI2CErrorsAvg;
            return this;
        }

        public Builder withChassisI2CErrorsMax(int ChassisI2CErrorsMax){
            this.ChassisI2CErrorsMax = ChassisI2CErrorsMax;
            return this;
        }

        public Builder withChassisI2CErrorsMin(int ChassisI2CErrorsMin){
            this.ChassisI2CErrorsMin = ChassisI2CErrorsMin;
            return this;
        }

        public Builder withinputPower(double inputPower){
            this.inputPower = inputPower;
            return this;
        }

        public Builder withinputPowerAvg(double inputPowerAvg){
            this.inputPowerAvg = inputPowerAvg;
            return this;
        }

        public Builder withinputPowerMax(double inputPowerMax){
            this.inputPowerMax = inputPowerMax;
            return this;
        }

        public Builder withinputPowerMin(double inputPowerMin){
            this.inputPowerMin = inputPowerMin;
            return this;
        }

        public Builder withoutputPower(double outputPower){
            this.outputPower = outputPower;
            return this;
        }

        public Builder withoutputPowerAvg(double outputPowerAvg){
            this.outputPowerAvg = outputPowerAvg;
            return this;
        }

        public Builder withoutputPowerMax(double outputPowerMax){
            this.outputPowerMax = outputPowerMax;
            return this;
        }

        public Builder withoutputPowerMin(double outputPowerMin){
            this.outputPowerMin = outputPowerMin;
            return this;
        }

        public UcsEquipmentChassisStats build() {
            return new UcsEquipmentChassisStats(this);
        }
    }
}
