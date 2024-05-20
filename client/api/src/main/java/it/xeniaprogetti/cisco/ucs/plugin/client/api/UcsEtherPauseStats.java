package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherPauseStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long recvPause;
    public final long recvPauseDelta;
    public final long recvPauseDeltaAvg;
    public final long recvPauseDeltaMax;
    public final long recvPauseDeltaMin;
    public final long resets;
    public final long resetsDelta;
    public final long resetsDeltaAvg;
    public final long resetsDeltaMax;
    public final long resetsDeltaMin;
    public final long xmitPause;
    public final long xmitPauseDelta;
    public final long xmitPauseDeltaAvg;
    public final long xmitPauseDeltaMax;
    public final long xmitPauseDeltaMin;

    private UcsEtherPauseStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherPauseStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        recvPause = builder.recvPause;
        recvPauseDelta = builder.recvPauseDelta;
        recvPauseDeltaAvg = builder.recvPauseDeltaAvg;
        recvPauseDeltaMax = builder.recvPauseDeltaMax;
        recvPauseDeltaMin = builder.recvPauseDeltaMin;
        resets = builder.resets;
        resetsDelta = builder.resetsDelta;
        resetsDeltaAvg = builder.resetsDeltaAvg;
        resetsDeltaMax = builder.resetsDeltaMax;
        resetsDeltaMin = builder.resetsDeltaMin;
        xmitPause = builder.xmitPause;
        xmitPauseDelta = builder.xmitPauseDelta;
        xmitPauseDeltaAvg = builder.xmitPauseDeltaAvg;
        xmitPauseDeltaMax = builder.xmitPauseDeltaMax;
        xmitPauseDeltaMin = builder.xmitPauseDeltaMin;
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
        private long recvPauseDelta;
        private long recvPauseDeltaAvg;
        private long recvPauseDeltaMax;
        private long recvPauseDeltaMin;
        private long resets;
        private long resetsDelta;
        private long resetsDeltaAvg;
        private long resetsDeltaMax;
        private long resetsDeltaMin;
        private long xmitPause;
        private long xmitPauseDelta;
        private long xmitPauseDeltaAvg;
        private long xmitPauseDeltaMax;
        private long xmitPauseDeltaMin;

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

        public Builder withrecvPause(long recvPause){
            this.recvPause = recvPause;
            return this;
        }

        public Builder withrecvPauseDelta(long recvPauseDelta){
            this.recvPauseDelta = recvPauseDelta;
            return this;
        }

        public Builder withrecvPauseDeltaAvg(long recvPauseDeltaAvg){
            this.recvPauseDeltaAvg = recvPauseDeltaAvg;
            return this;
        }

        public Builder withrecvPauseDeltaMax(long recvPauseDeltaMax){
            this.recvPauseDeltaMax = recvPauseDeltaMax;
            return this;
        }

        public Builder withrecvPauseDeltaMin(long recvPauseDeltaMin){
            this.recvPauseDeltaMin = recvPauseDeltaMin;
            return this;
        }

        public Builder withresets(long resets){
            this.resets = resets;
            return this;
        }

        public Builder withresetsDelta(long resetsDelta){
            this.resetsDelta = resetsDelta;
            return this;
        }

        public Builder withresetsDeltaAvg(long resetsDeltaAvg){
            this.resetsDeltaAvg = resetsDeltaAvg;
            return this;
        }

        public Builder withresetsDeltaMax(long resetsDeltaMax){
            this.resetsDeltaMax = resetsDeltaMax;
            return this;
        }

        public Builder withresetsDeltaMin(long resetsDeltaMin){
            this.resetsDeltaMin = resetsDeltaMin;
            return this;
        }

        public Builder withxmitPause(long xmitPause){
            this.xmitPause = xmitPause;
            return this;
        }

        public Builder withxmitPauseDelta(long xmitPauseDelta){
            this.xmitPauseDelta = xmitPauseDelta;
            return this;
        }

        public Builder withxmitPauseDeltaAvg(long xmitPauseDeltaAvg){
            this.xmitPauseDeltaAvg = xmitPauseDeltaAvg;
            return this;
        }

        public Builder withxmitPauseDeltaMax(long xmitPauseDeltaMax){
            this.xmitPauseDeltaMax = xmitPauseDeltaMax;
            return this;
        }

        public Builder withxmitPauseDeltaMin(long xmitPauseDeltaMin){
            this.xmitPauseDeltaMin = xmitPauseDeltaMin;
            return this;
        }

        public UcsEtherPauseStats build() {
            return new UcsEtherPauseStats(this);
        }
    }
}
