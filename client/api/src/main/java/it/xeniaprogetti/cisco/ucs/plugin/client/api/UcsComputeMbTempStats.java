package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputeMbTempStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double fmTempSenIo;
    public final double fmTempSenIoAvg;
    public final double fmTempSenIoMax;
    public final double fmTempSenIoMin;
    public final double fmTempSenRear;
    public final double fmTempSenRearAvg;
    public final String fmTempSenRearL;
    public final String fmTempSenRearLAvg;
    public final String fmTempSenRearLMax;
    public final String fmTempSenRearLMin;
    public final double fmTempSenRearMax;
    public final double fmTempSenRearMin;
    public final String fmTempSenRearR;
    public final String fmTempSenRearRAvg;
    public final String fmTempSenRearRMax;
    public final String fmTempSenRearRMin;

    private UcsComputeMbTempStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computeMbTempStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        fmTempSenIo = builder.fmTempSenIo;
        fmTempSenIoAvg = builder.fmTempSenIoAvg;
        fmTempSenIoMax = builder.fmTempSenIoMax;
        fmTempSenIoMin = builder.fmTempSenIoMin;
        fmTempSenRear = builder.fmTempSenRear;
        fmTempSenRearAvg = builder.fmTempSenRearAvg;
        fmTempSenRearL = builder.fmTempSenRearL;
        fmTempSenRearLAvg = builder.fmTempSenRearLAvg;
        fmTempSenRearLMax = builder.fmTempSenRearLMax;
        fmTempSenRearLMin = builder.fmTempSenRearLMin;
        fmTempSenRearMax = builder.fmTempSenRearMax;
        fmTempSenRearMin = builder.fmTempSenRearMin;
        fmTempSenRearR = builder.fmTempSenRearR;
        fmTempSenRearRAvg = builder.fmTempSenRearRAvg;
        fmTempSenRearRMax = builder.fmTempSenRearRMax;
        fmTempSenRearRMin = builder.fmTempSenRearRMin;
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

        private double fmTempSenIo;
        private double fmTempSenIoAvg;
        private double fmTempSenIoMax;
        private double fmTempSenIoMin;
        private double fmTempSenRear;
        private double fmTempSenRearAvg;
        private String fmTempSenRearL;
        private String fmTempSenRearLAvg;
        private String fmTempSenRearLMax;
        private String fmTempSenRearLMin;
        private double fmTempSenRearMax;
        private double fmTempSenRearMin;
        private String fmTempSenRearR;
        private String fmTempSenRearRAvg;
        private String fmTempSenRearRMax;
        private String fmTempSenRearRMin;

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

        public Builder withfmTempSenIo(double fmTempSenIo){
            this.fmTempSenIo = fmTempSenIo;
            return this;
        }

        public Builder withfmTempSenIoAvg(double fmTempSenIoAvg){
            this.fmTempSenIoAvg = fmTempSenIoAvg;
            return this;
        }

        public Builder withfmTempSenIoMax(double fmTempSenIoMax){
            this.fmTempSenIoMax = fmTempSenIoMax;
            return this;
        }

        public Builder withfmTempSenIoMin(double fmTempSenIoMin){
            this.fmTempSenIoMin = fmTempSenIoMin;
            return this;
        }

        public Builder withfmTempSenRear(double fmTempSenRear){
            this.fmTempSenRear = fmTempSenRear;
            return this;
        }

        public Builder withfmTempSenRearAvg(double fmTempSenRearAvg){
            this.fmTempSenRearAvg = fmTempSenRearAvg;
            return this;
        }

        public Builder withfmTempSenRearL(String fmTempSenRearL){
            this.fmTempSenRearL = fmTempSenRearL;
            return this;
        }

        public Builder withfmTempSenRearLAvg(String fmTempSenRearLAvg){
            this.fmTempSenRearLAvg = fmTempSenRearLAvg;
            return this;
        }

        public Builder withfmTempSenRearLMax(String fmTempSenRearLMax){
            this.fmTempSenRearLMax = fmTempSenRearLMax;
            return this;
        }

        public Builder withfmTempSenRearLMin(String fmTempSenRearLMin){
            this.fmTempSenRearLMin = fmTempSenRearLMin;
            return this;
        }

        public Builder withfmTempSenRearMax(double fmTempSenRearMax){
            this.fmTempSenRearMax = fmTempSenRearMax;
            return this;
        }

        public Builder withfmTempSenRearMin(double fmTempSenRearMin){
            this.fmTempSenRearMin = fmTempSenRearMin;
            return this;
        }

        public Builder withfmTempSenRearR(String fmTempSenRearR){
            this.fmTempSenRearR = fmTempSenRearR;
            return this;
        }

        public Builder withfmTempSenRearRAvg(String fmTempSenRearRAvg){
            this.fmTempSenRearRAvg = fmTempSenRearRAvg;
            return this;
        }

        public Builder withfmTempSenRearRMax(String fmTempSenRearRMax){
            this.fmTempSenRearRMax = fmTempSenRearRMax;
            return this;
        }

        public Builder withfmTempSenRearRMin(String fmTempSenRearRMin){
            this.fmTempSenRearRMin = fmTempSenRearRMin;
            return this;
        }

        public UcsComputeMbTempStats build() {
            return new UcsComputeMbTempStats(this);
        }
    }
}
