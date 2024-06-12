package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputePCIeFatalReceiveStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long bufferOverflowErrors;
    public final long errFatalErrors;
    public final long errNonFatalErrors;
    public final long unsupportedRequestErrors;

    private UcsComputePCIeFatalReceiveStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computePCIeFatalReceiveStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        bufferOverflowErrors = builder.bufferOverflowErrors;
        errFatalErrors = builder.errFatalErrors;
        errNonFatalErrors = builder.errNonFatalErrors;
        unsupportedRequestErrors = builder.unsupportedRequestErrors;
    }

    @Override
    public String toString() {
        return "UcsComputePCIeFatalReceiveStats{" +
                "bufferOverflowErrors=" + bufferOverflowErrors +
                ", errFatalErrors=" + errFatalErrors +
                ", errNonFatalErrors=" + errNonFatalErrors +
                ", unsupportedRequestErrors=" + unsupportedRequestErrors +
                ", suspect='" + suspect + '\'' +
                ", intervals=" + intervals +
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

        private long bufferOverflowErrors;
        private long errFatalErrors;
        private long errNonFatalErrors;
        private long unsupportedRequestErrors;

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

        public Builder withBufferOverflowErrors(long bufferOverflowErrors){
            this.bufferOverflowErrors = bufferOverflowErrors;
            return this;
        }

        public Builder withErrFatalErrors(long errFatalErrors){
            this.errFatalErrors = errFatalErrors;
            return this;
        }

        public Builder withErrNonFatalErrors(long errNonFatalErrors){
            this.errNonFatalErrors = errNonFatalErrors;
            return this;
        }

        public Builder withUnsupportedRequestErrors(long unsupportedRequestErrors){
            this.unsupportedRequestErrors = unsupportedRequestErrors;
            return this;
        }

        public UcsComputePCIeFatalReceiveStats build() {
            return new UcsComputePCIeFatalReceiveStats(this);
        }
    }
}
