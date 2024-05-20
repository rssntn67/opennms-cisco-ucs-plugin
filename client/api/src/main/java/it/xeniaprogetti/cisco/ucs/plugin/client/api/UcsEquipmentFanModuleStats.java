package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentFanModuleStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int FanModuleI2CErrors;
    public final int FanModuleI2CErrorsAvg;
    public final int FanModuleI2CErrorsMax;
    public final int FanModuleI2CErrorsMin;
    public final double ambientTemp;
    public final double ambientTempAvg;
    public final double ambientTempMax;
    public final double ambientTempMin;

    private UcsEquipmentFanModuleStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentFanModuleStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        FanModuleI2CErrors = builder.FanModuleI2CErrors;
        FanModuleI2CErrorsAvg = builder.FanModuleI2CErrorsAvg;
        FanModuleI2CErrorsMax = builder.FanModuleI2CErrorsMax;
        FanModuleI2CErrorsMin = builder.FanModuleI2CErrorsMin;
        ambientTemp = builder.ambientTemp;
        ambientTempAvg = builder.ambientTempAvg;
        ambientTempMax = builder.ambientTempMax;
        ambientTempMin = builder.ambientTempMin;
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

        private int FanModuleI2CErrors;
        private int FanModuleI2CErrorsAvg;
        private int FanModuleI2CErrorsMax;
        private int FanModuleI2CErrorsMin;
        private double ambientTemp;
        private double ambientTempAvg;
        private double ambientTempMax;
        private double ambientTempMin;

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

        public Builder withFanModuleI2CErrors(int FanModuleI2CErrors){
            this.FanModuleI2CErrors = FanModuleI2CErrors;
            return this;
        }

        public Builder withFanModuleI2CErrorsAvg(int FanModuleI2CErrorsAvg){
            this.FanModuleI2CErrorsAvg = FanModuleI2CErrorsAvg;
            return this;
        }

        public Builder withFanModuleI2CErrorsMax(int FanModuleI2CErrorsMax){
            this.FanModuleI2CErrorsMax = FanModuleI2CErrorsMax;
            return this;
        }

        public Builder withFanModuleI2CErrorsMin(int FanModuleI2CErrorsMin){
            this.FanModuleI2CErrorsMin = FanModuleI2CErrorsMin;
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

        public UcsEquipmentFanModuleStats build() {
            return new UcsEquipmentFanModuleStats(this);
        }
    }
}
