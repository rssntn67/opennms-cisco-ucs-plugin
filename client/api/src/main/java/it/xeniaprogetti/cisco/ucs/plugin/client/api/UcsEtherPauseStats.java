package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherPauseStats extends UcsEtherResourceTypeStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long recvPause;
    public final long resets;
    public final long xmitPause;

    private UcsEtherPauseStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherPauseStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        recvPause = builder.recvPause;
        resets = builder.resets;
        xmitPause = builder.xmitPause;
    }

    @Override
    public String toString() {
        return "UcsEtherPauseStats{" +
                "recvPause=" + recvPause +
                ", resets=" + resets +
                ", xmitPause=" + xmitPause +
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

        private long recvPause;
        private long resets;
        private long xmitPause;

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

        public Builder withRecvPause(long recvPause){
            this.recvPause = recvPause;
            return this;
        }

        public Builder withResets(long resets){
            this.resets = resets;
            return this;
        }

        public Builder withXmitPause(long xmitPause){
            this.xmitPause = xmitPause;
            return this;
        }

        public UcsEtherPauseStats build() {
            return new UcsEtherPauseStats(this);
        }
    }
}
