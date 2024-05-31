package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentChassisStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int ChassisI2CErrors;
    public final double inputPower;
    public final double outputPower;

    private UcsEquipmentChassisStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentChassisStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        ChassisI2CErrors = builder.ChassisI2CErrors;
        inputPower = builder.inputPower;
        outputPower = builder.outputPower;
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
        private double inputPower;
        private double outputPower;

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

        public Builder withInputPower(double inputPower){
            this.inputPower = inputPower;
            return this;
        }

        public Builder withOutputPower(double outputPower){
            this.outputPower = outputPower;
            return this;
        }

        public UcsEquipmentChassisStats build() {
            return new UcsEquipmentChassisStats(this);
        }
    }
}
