package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputeMbPowerStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double consumedPower;
    public final double inputCurrent;
    public final double inputVoltage;

    private UcsComputeMbPowerStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computeMbPowerStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        consumedPower = builder.consumedPower;
        inputCurrent = builder.inputCurrent;
        inputVoltage = builder.inputVoltage;
    }

    @Override
    public String toString() {
        return "UcsComputeMbPowerStats{" +
                "consumedPower=" + consumedPower +
                ", inputCurrent=" + inputCurrent +
                ", inputVoltage=" + inputVoltage +
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

        private double consumedPower;
        private double inputCurrent;
        private double inputVoltage;

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

        public Builder withConsumedPower(double consumedPower){
            this.consumedPower = consumedPower;
            return this;
        }

        public Builder withInputCurrent(double inputCurrent){
            this.inputCurrent = inputCurrent;
            return this;
        }

        public Builder withInputVoltage(double inputVoltage){
            this.inputVoltage = inputVoltage;
            return this;
        }

        public UcsComputeMbPowerStats build() {
            return new UcsComputeMbPowerStats(this);
        }
    }
}
