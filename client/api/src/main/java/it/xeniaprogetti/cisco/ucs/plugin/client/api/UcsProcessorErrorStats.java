package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsProcessorErrorStats extends UcsProcessorResourceTypeStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long CorrectableLinkCRCErrors;
    public final long UncorrectableLinkCRCErrors;
    public final long mirroringInterSockErrors;
    public final long mirroringIntraSockErrors;
    public final long smiLinkCorrErrors;
    public final long smiLinkUncorrErrors;
    public final long sparingErrors;

    private UcsProcessorErrorStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.processorErrorStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        CorrectableLinkCRCErrors = builder.CorrectableLinkCRCErrors;
        UncorrectableLinkCRCErrors = builder.UncorrectableLinkCRCErrors;
        mirroringInterSockErrors = builder.mirroringInterSockErrors;
        mirroringIntraSockErrors = builder.mirroringIntraSockErrors;
        smiLinkCorrErrors = builder.smiLinkCorrErrors;
        smiLinkUncorrErrors = builder.smiLinkUncorrErrors;
        sparingErrors = builder.sparingErrors;
    }

    @Override
    public String toString() {
        return "UcsProcessorErrorStats{" +
                "CorrectableLinkCRCErrors=" + CorrectableLinkCRCErrors +
                ", UncorrectableLinkCRCErrors=" + UncorrectableLinkCRCErrors +
                ", mirroringInterSockErrors=" + mirroringInterSockErrors +
                ", mirroringIntraSockErrors=" + mirroringIntraSockErrors +
                ", smiLinkCorrErrors=" + smiLinkCorrErrors +
                ", smiLinkUncorrErrors=" + smiLinkUncorrErrors +
                ", sparingErrors=" + sparingErrors +
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

        private long CorrectableLinkCRCErrors;
        private long UncorrectableLinkCRCErrors;
        private long mirroringInterSockErrors;
        private long mirroringIntraSockErrors;
        private long smiLinkCorrErrors;
        private long smiLinkUncorrErrors;
        private long sparingErrors;

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

        public Builder withCorrectableLinkCRCErrors(long CorrectableLinkCRCErrors){
            this.CorrectableLinkCRCErrors = CorrectableLinkCRCErrors;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors(long UncorrectableLinkCRCErrors){
            this.UncorrectableLinkCRCErrors = UncorrectableLinkCRCErrors;
            return this;
        }

        public Builder withMirroringInterSockErrors(long mirroringInterSockErrors){
            this.mirroringInterSockErrors = mirroringInterSockErrors;
            return this;
        }

        public Builder withMirroringIntraSockErrors(long mirroringIntraSockErrors){
            this.mirroringIntraSockErrors = mirroringIntraSockErrors;
            return this;
        }

        public Builder withSmiLinkCorrErrors(long smiLinkCorrErrors){
            this.smiLinkCorrErrors = smiLinkCorrErrors;
            return this;
        }

        public Builder withSmiLinkUncorrErrors(long smiLinkUncorrErrors){
            this.smiLinkUncorrErrors = smiLinkUncorrErrors;
            return this;
        }

        public Builder withSparingErrors(long sparingErrors){
            this.sparingErrors = sparingErrors;
            return this;
        }

        public UcsProcessorErrorStats build() {
            return new UcsProcessorErrorStats(this);
        }
    }
}
