package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.math.BigDecimal;
import java.util.Date;

public class UcsComputeMbTempStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double fmTempSenIo;
    public final Aggregate fmTempSenIoAgg;
    public final double fmTempSenRear;
    public final Aggregate fmTempSenRearAgg;

    private UcsComputeMbTempStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computeMbTempStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        fmTempSenIo = builder.fmTempSenIo;
        fmTempSenIoAgg = Aggregate.builder()
                .withAverage(BigDecimal.valueOf(builder.fmTempSenIoAvg))
                .withMax(BigDecimal.valueOf(builder.fmTempSenIoMax))
                .withMin(BigDecimal.valueOf(builder.fmTempSenIoMin))
                .build();
        fmTempSenRear = builder.fmTempSenRear;
        fmTempSenRearAgg = Aggregate.builder()
                .withAverage(BigDecimal.valueOf(builder.fmTempSenRearAvg))
                .withMax(BigDecimal.valueOf(builder.fmTempSenRearMax))
                .withMin(BigDecimal.valueOf(builder.fmTempSenRearMin))
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

        private double fmTempSenIo;
        private double fmTempSenIoAvg;
        private double fmTempSenIoMax;
        private double fmTempSenIoMin;
        private double fmTempSenRear;
        private double fmTempSenRearAvg;
        private double fmTempSenRearMax;
        private double fmTempSenRearMin;

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

        public Builder withFmTempSenIo(double fmTempSenIo){
            this.fmTempSenIo = fmTempSenIo;
            return this;
        }

        public Builder withFmTempSenIoAvg(double fmTempSenIoAvg){
            this.fmTempSenIoAvg = fmTempSenIoAvg;
            return this;
        }

        public Builder withFmTempSenIoMax(double fmTempSenIoMax){
            this.fmTempSenIoMax = fmTempSenIoMax;
            return this;
        }

        public Builder withFmTempSenIoMin(double fmTempSenIoMin){
            this.fmTempSenIoMin = fmTempSenIoMin;
            return this;
        }

        public Builder withFmTempSenRear(double fmTempSenRear){
            this.fmTempSenRear = fmTempSenRear;
            return this;
        }

        public Builder withfmTempSenRearAvg(double fmTempSenRearAvg){
            this.fmTempSenRearAvg = fmTempSenRearAvg;
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

        public UcsComputeMbTempStats build() {
            return new UcsComputeMbTempStats(this);
        }
    }
}
