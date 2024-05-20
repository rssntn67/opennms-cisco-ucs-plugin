package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentIOCardStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int IomI2CErrors;
    public final int IomI2CErrorsAvg;
    public final int IomI2CErrorsMax;
    public final int IomI2CErrorsMin;
    public final double ambientTemp;
    public final double ambientTempAvg;
    public final double ambientTempMax;
    public final double ambientTempMin;
    public final String dimmTemp;
    public final double dimmTempAvg;
    public final double dimmTempMax;
    public final double dimmTempMin;
    public final String procTemp;
    public final double procTempAvg;
    public final double procTempMax;
    public final double procTempMin;
    public final double temp;
    public final double tempAvg;
    public final double tempMax;
    public final double tempMin;

    private UcsEquipmentIOCardStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentIOCardStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        IomI2CErrors = builder.IomI2CErrors;
        IomI2CErrorsAvg = builder.IomI2CErrorsAvg;
        IomI2CErrorsMax = builder.IomI2CErrorsMax;
        IomI2CErrorsMin = builder.IomI2CErrorsMin;
        ambientTemp = builder.ambientTemp;
        ambientTempAvg = builder.ambientTempAvg;
        ambientTempMax = builder.ambientTempMax;
        ambientTempMin = builder.ambientTempMin;
        dimmTemp = builder.dimmTemp;
        dimmTempAvg = builder.dimmTempAvg;
        dimmTempMax = builder.dimmTempMax;
        dimmTempMin = builder.dimmTempMin;
        procTemp = builder.procTemp;
        procTempAvg = builder.procTempAvg;
        procTempMax = builder.procTempMax;
        procTempMin = builder.procTempMin;
        temp = builder.temp;
        tempAvg = builder.tempAvg;
        tempMax = builder.tempMax;
        tempMin = builder.tempMin;
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

        private int IomI2CErrors;
        private int IomI2CErrorsAvg;
        private int IomI2CErrorsMax;
        private int IomI2CErrorsMin;
        private double ambientTemp;
        private double ambientTempAvg;
        private double ambientTempMax;
        private double ambientTempMin;
        private String dimmTemp;
        private double dimmTempAvg;
        private double dimmTempMax;
        private double dimmTempMin;
        private String procTemp;
        private double procTempAvg;
        private double procTempMax;
        private double procTempMin;
        private double temp;
        private double tempAvg;
        private double tempMax;
        private double tempMin;

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

        public Builder withIomI2CErrors(int IomI2CErrors){
            this.IomI2CErrors = IomI2CErrors;
            return this;
        }

        public Builder withIomI2CErrorsAvg(int IomI2CErrorsAvg){
            this.IomI2CErrorsAvg = IomI2CErrorsAvg;
            return this;
        }

        public Builder withIomI2CErrorsMax(int IomI2CErrorsMax){
            this.IomI2CErrorsMax = IomI2CErrorsMax;
            return this;
        }

        public Builder withIomI2CErrorsMin(int IomI2CErrorsMin){
            this.IomI2CErrorsMin = IomI2CErrorsMin;
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

        public Builder withdimmTemp(String dimmTemp){
            this.dimmTemp = dimmTemp;
            return this;
        }

        public Builder withdimmTempAvg(double dimmTempAvg){
            this.dimmTempAvg = dimmTempAvg;
            return this;
        }

        public Builder withdimmTempMax(double dimmTempMax){
            this.dimmTempMax = dimmTempMax;
            return this;
        }

        public Builder withdimmTempMin(double dimmTempMin){
            this.dimmTempMin = dimmTempMin;
            return this;
        }

        public Builder withprocTemp(String procTemp){
            this.procTemp = procTemp;
            return this;
        }

        public Builder withprocTempAvg(double procTempAvg){
            this.procTempAvg = procTempAvg;
            return this;
        }

        public Builder withprocTempMax(double procTempMax){
            this.procTempMax = procTempMax;
            return this;
        }

        public Builder withprocTempMin(double procTempMin){
            this.procTempMin = procTempMin;
            return this;
        }

        public Builder withtemp(double temp){
            this.temp = temp;
            return this;
        }

        public Builder withtempAvg(double tempAvg){
            this.tempAvg = tempAvg;
            return this;
        }

        public Builder withtempMax(double tempMax){
            this.tempMax = tempMax;
            return this;
        }

        public Builder withtempMin(double tempMin){
            this.tempMin = tempMin;
            return this;
        }

        public UcsEquipmentIOCardStats build() {
            return new UcsEquipmentIOCardStats(this);
        }
    }
}
