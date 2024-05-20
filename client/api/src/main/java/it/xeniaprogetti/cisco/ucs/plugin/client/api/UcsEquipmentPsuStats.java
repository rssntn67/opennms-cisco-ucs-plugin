package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentPsuStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int PsuI2CErrors;
    public final int PsuI2CErrorsAvg;
    public final int PsuI2CErrorsMax;
    public final int PsuI2CErrorsMin;
    public final double ambientTemp;
    public final double ambientTempAvg;
    public final double ambientTempMax;
    public final double ambientTempMin;
    public final double input210v;
    public final double input210vAvg;
    public final double input210vMax;
    public final double input210vMin;
    public final String inputPower;
    public final double inputPowerAvg;
    public final double inputPowerMax;
    public final double inputPowerMin;
    public final double output12v;
    public final double output12vAvg;
    public final double output12vMax;
    public final double output12vMin;
    public final double output3v3;
    public final double output3v3Avg;
    public final double output3v3Max;
    public final double output3v3Min;
    public final double outputCurrent;
    public final double outputCurrentAvg;
    public final double outputCurrentMax;
    public final double outputCurrentMin;
    public final double outputPower;
    public final double outputPowerAvg;
    public final double outputPowerMax;
    public final double outputPowerMin;
    public final String psuTemp1;
    public final String psuTemp2;

    private UcsEquipmentPsuStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentPsuStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        PsuI2CErrors = builder.PsuI2CErrors;
        PsuI2CErrorsAvg = builder.PsuI2CErrorsAvg;
        PsuI2CErrorsMax = builder.PsuI2CErrorsMax;
        PsuI2CErrorsMin = builder.PsuI2CErrorsMin;
        ambientTemp = builder.ambientTemp;
        ambientTempAvg = builder.ambientTempAvg;
        ambientTempMax = builder.ambientTempMax;
        ambientTempMin = builder.ambientTempMin;
        input210v = builder.input210v;
        input210vAvg = builder.input210vAvg;
        input210vMax = builder.input210vMax;
        input210vMin = builder.input210vMin;
        inputPower = builder.inputPower;
        inputPowerAvg = builder.inputPowerAvg;
        inputPowerMax = builder.inputPowerMax;
        inputPowerMin = builder.inputPowerMin;
        output12v = builder.output12v;
        output12vAvg = builder.output12vAvg;
        output12vMax = builder.output12vMax;
        output12vMin = builder.output12vMin;
        output3v3 = builder.output3v3;
        output3v3Avg = builder.output3v3Avg;
        output3v3Max = builder.output3v3Max;
        output3v3Min = builder.output3v3Min;
        outputCurrent = builder.outputCurrent;
        outputCurrentAvg = builder.outputCurrentAvg;
        outputCurrentMax = builder.outputCurrentMax;
        outputCurrentMin = builder.outputCurrentMin;
        outputPower = builder.outputPower;
        outputPowerAvg = builder.outputPowerAvg;
        outputPowerMax = builder.outputPowerMax;
        outputPowerMin = builder.outputPowerMin;
        psuTemp1 = builder.psuTemp1;
        psuTemp2 = builder.psuTemp2;
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
        private int PsuI2CErrorsAvg;
        private int PsuI2CErrorsMax;
        private int PsuI2CErrorsMin;
        private double ambientTemp;
        private double ambientTempAvg;
        private double ambientTempMax;
        private double ambientTempMin;
        private double input210v;
        private double input210vAvg;
        private double input210vMax;
        private double input210vMin;
        private String inputPower;
        private double inputPowerAvg;
        private double inputPowerMax;
        private double inputPowerMin;
        private double output12v;
        private double output12vAvg;
        private double output12vMax;
        private double output12vMin;
        private double output3v3;
        private double output3v3Avg;
        private double output3v3Max;
        private double output3v3Min;
        private double outputCurrent;
        private double outputCurrentAvg;
        private double outputCurrentMax;
        private double outputCurrentMin;
        private double outputPower;
        private double outputPowerAvg;
        private double outputPowerMax;
        private double outputPowerMin;
        private String psuTemp1;
        private String psuTemp2;

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

        public Builder withPsuI2CErrorsAvg(int PsuI2CErrorsAvg){
            this.PsuI2CErrorsAvg = PsuI2CErrorsAvg;
            return this;
        }

        public Builder withPsuI2CErrorsMax(int PsuI2CErrorsMax){
            this.PsuI2CErrorsMax = PsuI2CErrorsMax;
            return this;
        }

        public Builder withPsuI2CErrorsMin(int PsuI2CErrorsMin){
            this.PsuI2CErrorsMin = PsuI2CErrorsMin;
            return this;
        }

        public Builder withambientTemp(double ambientTemp){
            this.ambientTemp = ambientTemp;
            return this;
        }

        public Builder withambientTempAvg(double ambientTempAvg){
            this.ambientTempAvg = ambientTempAvg;
            return this;
        }

        public Builder withambientTempMax(double ambientTempMax){
            this.ambientTempMax = ambientTempMax;
            return this;
        }

        public Builder withambientTempMin(double ambientTempMin){
            this.ambientTempMin = ambientTempMin;
            return this;
        }

        public Builder withinput210v(double input210v){
            this.input210v = input210v;
            return this;
        }

        public Builder withinput210vAvg(double input210vAvg){
            this.input210vAvg = input210vAvg;
            return this;
        }

        public Builder withinput210vMax(double input210vMax){
            this.input210vMax = input210vMax;
            return this;
        }

        public Builder withinput210vMin(double input210vMin){
            this.input210vMin = input210vMin;
            return this;
        }

        public Builder withinputPower(String inputPower){
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

        public Builder withoutput12v(double output12v){
            this.output12v = output12v;
            return this;
        }

        public Builder withoutput12vAvg(double output12vAvg){
            this.output12vAvg = output12vAvg;
            return this;
        }

        public Builder withoutput12vMax(double output12vMax){
            this.output12vMax = output12vMax;
            return this;
        }

        public Builder withoutput12vMin(double output12vMin){
            this.output12vMin = output12vMin;
            return this;
        }

        public Builder withoutput3v3(double output3v3){
            this.output3v3 = output3v3;
            return this;
        }

        public Builder withoutput3v3Avg(double output3v3Avg){
            this.output3v3Avg = output3v3Avg;
            return this;
        }

        public Builder withoutput3v3Max(double output3v3Max){
            this.output3v3Max = output3v3Max;
            return this;
        }

        public Builder withoutput3v3Min(double output3v3Min){
            this.output3v3Min = output3v3Min;
            return this;
        }

        public Builder withoutputCurrent(double outputCurrent){
            this.outputCurrent = outputCurrent;
            return this;
        }

        public Builder withoutputCurrentAvg(double outputCurrentAvg){
            this.outputCurrentAvg = outputCurrentAvg;
            return this;
        }

        public Builder withoutputCurrentMax(double outputCurrentMax){
            this.outputCurrentMax = outputCurrentMax;
            return this;
        }

        public Builder withoutputCurrentMin(double outputCurrentMin){
            this.outputCurrentMin = outputCurrentMin;
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

        public Builder withpsuTemp1(String psuTemp1){
            this.psuTemp1 = psuTemp1;
            return this;
        }

        public Builder withpsuTemp2(String psuTemp2){
            this.psuTemp2 = psuTemp2;
            return this;
        }

        public UcsEquipmentPsuStats build() {
            return new UcsEquipmentPsuStats(this);
        }
    }
}
