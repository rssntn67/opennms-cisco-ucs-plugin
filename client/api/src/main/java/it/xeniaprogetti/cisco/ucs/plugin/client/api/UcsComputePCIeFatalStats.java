package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputePCIeFatalStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long acsViolationErrors;
    public final long malformedTLPErrors;
    public final long poisonedTLPErrors;
    public final long surpriseLinkDownErrors;

    private UcsComputePCIeFatalStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computePCIeFatalStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        acsViolationErrors = builder.acsViolationErrors;
        malformedTLPErrors = builder.malformedTLPErrors;
        poisonedTLPErrors = builder.poisonedTLPErrors;
        surpriseLinkDownErrors = builder.surpriseLinkDownErrors;
    }

    @Override
    public String toString() {
        return "UcsComputePCIeFatalStats{" +
                "acsViolationErrors=" + acsViolationErrors +
                ", malformedTLPErrors=" + malformedTLPErrors +
                ", poisonedTLPErrors=" + poisonedTLPErrors +
                ", surpriseLinkDownErrors=" + surpriseLinkDownErrors +
                ", intervals=" + intervals +
                ", suspect='" + suspect + '\'' +
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

        private long acsViolationErrors;
        private long malformedTLPErrors;
        private long poisonedTLPErrors;
        private long surpriseLinkDownErrors;

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

        public Builder withAcsViolationErrors(long acsViolationErrors){
            this.acsViolationErrors = acsViolationErrors;
            return this;
        }

        public Builder withMalformedTLPErrors(long malformedTLPErrors){
            this.malformedTLPErrors = malformedTLPErrors;
            return this;
        }

        public Builder withPoisonedTLPErrors(long poisonedTLPErrors){
            this.poisonedTLPErrors = poisonedTLPErrors;
            return this;
        }

        public Builder withSurpriseLinkDownErrors(long surpriseLinkDownErrors){
            this.surpriseLinkDownErrors = surpriseLinkDownErrors;
            return this;
        }

        public UcsComputePCIeFatalStats build() {
            return new UcsComputePCIeFatalStats(this);
        }
    }
}
