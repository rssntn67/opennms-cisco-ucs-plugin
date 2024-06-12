package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputePCIeFatalCompletionStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long AbortErrors;
    public final long TimeoutErrors;
    public final long unexpectedErrors;

    @Override
    public String toString() {
        return "UcsComputePCIeFatalCompletionStats{" +
                "AbortErrors=" + AbortErrors +
                ", TimeoutErrors=" + TimeoutErrors +
                ", unexpectedErrors=" + unexpectedErrors +
                '}';
    }

    private UcsComputePCIeFatalCompletionStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computePCIeFatalCompletionStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        AbortErrors = builder.AbortErrors;
        TimeoutErrors = builder.TimeoutErrors;
        unexpectedErrors = builder.unexpectedErrors;
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

        private long AbortErrors;
        private long TimeoutErrors;
        private long unexpectedErrors;

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

        public Builder withAbortErrors(long AbortErrors){
            this.AbortErrors = AbortErrors;
            return this;
        }

        public Builder withTimeoutErrors(long TimeoutErrors){
            this.TimeoutErrors = TimeoutErrors;
            return this;
        }

        public Builder withUnexpectedErrors(long unexpectedErrors){
            this.unexpectedErrors = unexpectedErrors;
            return this;
        }

        public UcsComputePCIeFatalCompletionStats build() {
            return new UcsComputePCIeFatalCompletionStats(this);
        }
    }
}
