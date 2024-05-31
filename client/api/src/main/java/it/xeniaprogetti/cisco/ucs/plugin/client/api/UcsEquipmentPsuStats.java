package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentPsuStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int PsuI2CErrors;
    public final double ambientTemp;
    public final double input210v;
    public final double output12v;
    public final double output3v3;
    public final double outputCurrent;
    public final double outputPower;

    private UcsEquipmentPsuStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentPsuStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        PsuI2CErrors = builder.PsuI2CErrors;
        ambientTemp = builder.ambientTemp;
        input210v = builder.input210v;
        output12v = builder.output12v;
        output3v3 = builder.output3v3;
        outputCurrent = builder.outputCurrent;
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

        private int PsuI2CErrors;
        private double ambientTemp;
        private double input210v;
        private double output12v;
        private double output3v3;
        private double outputCurrent;
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

        public Builder withPsuI2CErrors(int PsuI2CErrors){
            this.PsuI2CErrors = PsuI2CErrors;
            return this;
        }


        public Builder withAmbientTemp(double ambientTemp){
            this.ambientTemp = ambientTemp;
            return this;
        }

        public Builder withInput210v(double input210v){
            this.input210v = input210v;
            return this;
        }

        public Builder withOutput12v(double output12v){
            this.output12v = output12v;
            return this;
        }

        public Builder withOutput3v3(double output3v3){
            this.output3v3 = output3v3;
            return this;
        }

        public Builder withOutputCurrent(double outputCurrent){
            this.outputCurrent = outputCurrent;
            return this;
        }

        public Builder withOutputPower(double outputPower){
            this.outputPower = outputPower;
            return this;
        }

        public UcsEquipmentPsuStats build() {
            return new UcsEquipmentPsuStats(this);
        }
    }
}
