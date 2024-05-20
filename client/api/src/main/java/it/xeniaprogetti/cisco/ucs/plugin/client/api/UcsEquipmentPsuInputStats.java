package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentPsuInputStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double current;
    public final double currentAvg;
    public final double currentMax;
    public final double currentMin;
    public final String inputStatus;
    public final double power;
    public final double powerAvg;
    public final double powerMax;
    public final double powerMin;
    public final double voltage;
    public final double voltageAvg;
    public final double voltageMax;
    public final double voltageMin;

    private UcsEquipmentPsuInputStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentPsuInputStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        current = builder.current;
        currentAvg = builder.currentAvg;
        currentMax = builder.currentMax;
        currentMin = builder.currentMin;
        inputStatus = builder.inputStatus;
        power = builder.power;
        powerAvg = builder.powerAvg;
        powerMax = builder.powerMax;
        powerMin = builder.powerMin;
        voltage = builder.voltage;
        voltageAvg = builder.voltageAvg;
        voltageMax = builder.voltageMax;
        voltageMin = builder.voltageMin;
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

        private double current;
        private double currentAvg;
        private double currentMax;
        private double currentMin;
        private String inputStatus;
        private double power;
        private double powerAvg;
        private double powerMax;
        private double powerMin;
        private double voltage;
        private double voltageAvg;
        private double voltageMax;
        private double voltageMin;

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

        public Builder withcurrent(double current){
            this.current = current;
            return this;
        }

        public Builder withcurrentAvg(double currentAvg){
            this.currentAvg = currentAvg;
            return this;
        }

        public Builder withcurrentMax(double currentMax){
            this.currentMax = currentMax;
            return this;
        }

        public Builder withcurrentMin(double currentMin){
            this.currentMin = currentMin;
            return this;
        }

        public Builder withinputStatus(String inputStatus){
            this.inputStatus = inputStatus;
            return this;
        }

        public Builder withpower(double power){
            this.power = power;
            return this;
        }

        public Builder withpowerAvg(double powerAvg){
            this.powerAvg = powerAvg;
            return this;
        }

        public Builder withpowerMax(double powerMax){
            this.powerMax = powerMax;
            return this;
        }

        public Builder withpowerMin(double powerMin){
            this.powerMin = powerMin;
            return this;
        }

        public Builder withvoltage(double voltage){
            this.voltage = voltage;
            return this;
        }

        public Builder withvoltageAvg(double voltageAvg){
            this.voltageAvg = voltageAvg;
            return this;
        }

        public Builder withvoltageMax(double voltageMax){
            this.voltageMax = voltageMax;
            return this;
        }

        public Builder withvoltageMin(double voltageMin){
            this.voltageMin = voltageMin;
            return this;
        }

        public UcsEquipmentPsuInputStats build() {
            return new UcsEquipmentPsuInputStats(this);
        }
    }
}
