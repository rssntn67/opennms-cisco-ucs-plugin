package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputePCIeFatalProtocolStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long dllpErrors;
    public final long flowControlErrors;

    private UcsComputePCIeFatalProtocolStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computePCIeFatalProtocolStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        dllpErrors = builder.dllpErrors;
        flowControlErrors = builder.flowControlErrors;
    }

    @Override
    public String toString() {
        return "UcsComputePCIeFatalProtocolStats{" +
                "dllpErrors=" + dllpErrors +
                ", flowControlErrors=" + flowControlErrors +
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

        private long dllpErrors;
        private long flowControlErrors;

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

        public Builder withDllpErrors(long dllpErrors){
            this.dllpErrors = dllpErrors;
            return this;
        }

        public Builder withFlowControlErrors(long flowControlErrors){
            this.flowControlErrors = flowControlErrors;
            return this;
        }

        public UcsComputePCIeFatalProtocolStats build() {
            return new UcsComputePCIeFatalProtocolStats(this);
        }
    }
}
