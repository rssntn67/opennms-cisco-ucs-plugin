package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.math.BigDecimal;
import java.util.Date;

public class UcsComputeMbTempStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double fmTempSenIo;
    public final double fmTempSenRear;

    private UcsComputeMbTempStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computeMbTempStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        fmTempSenIo = builder.fmTempSenIo;
        fmTempSenRear = builder.fmTempSenRear;
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
        private double fmTempSenRear;

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

        public Builder withFmTempSenRear(double fmTempSenRear){
            this.fmTempSenRear = fmTempSenRear;
            return this;
        }


        public UcsComputeMbTempStats build() {
            return new UcsComputeMbTempStats(this);
        }
    }
}
