package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherNiErrStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int crc;
    public final int crcDelta;
    public final int crcDeltaAvg;
    public final int crcDeltaMax;
    public final int crcDeltaMin;
    public final int frameTx;
    public final int frameTxDelta;
    public final int frameTxDeltaAvg;
    public final int frameTxDeltaMax;
    public final int frameTxDeltaMin;
    public final int inRange;
    public final int inRangeDelta;
    public final int inRangeDeltaAvg;
    public final int inRangeDeltaMax;
    public final int inRangeDeltaMin;
    public final int tooLong;
    public final int tooLongDelta;
    public final int tooLongDeltaAvg;
    public final int tooLongDeltaMax;
    public final int tooLongDeltaMin;
    public final int tooShort;
    public final int tooShortDelta;
    public final int tooShortDeltaAvg;
    public final int tooShortDeltaMax;
    public final int tooShortDeltaMin;

    private UcsEtherNiErrStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherNiErrStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        crc = builder.crc;
        crcDelta = builder.crcDelta;
        crcDeltaAvg = builder.crcDeltaAvg;
        crcDeltaMax = builder.crcDeltaMax;
        crcDeltaMin = builder.crcDeltaMin;
        frameTx = builder.frameTx;
        frameTxDelta = builder.frameTxDelta;
        frameTxDeltaAvg = builder.frameTxDeltaAvg;
        frameTxDeltaMax = builder.frameTxDeltaMax;
        frameTxDeltaMin = builder.frameTxDeltaMin;
        inRange = builder.inRange;
        inRangeDelta = builder.inRangeDelta;
        inRangeDeltaAvg = builder.inRangeDeltaAvg;
        inRangeDeltaMax = builder.inRangeDeltaMax;
        inRangeDeltaMin = builder.inRangeDeltaMin;
        tooLong = builder.tooLong;
        tooLongDelta = builder.tooLongDelta;
        tooLongDeltaAvg = builder.tooLongDeltaAvg;
        tooLongDeltaMax = builder.tooLongDeltaMax;
        tooLongDeltaMin = builder.tooLongDeltaMin;
        tooShort = builder.tooShort;
        tooShortDelta = builder.tooShortDelta;
        tooShortDeltaAvg = builder.tooShortDeltaAvg;
        tooShortDeltaMax = builder.tooShortDeltaMax;
        tooShortDeltaMin = builder.tooShortDeltaMin;
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

        private int crc;
        private int crcDelta;
        private int crcDeltaAvg;
        private int crcDeltaMax;
        private int crcDeltaMin;
        private int frameTx;
        private int frameTxDelta;
        private int frameTxDeltaAvg;
        private int frameTxDeltaMax;
        private int frameTxDeltaMin;
        private int inRange;
        private int inRangeDelta;
        private int inRangeDeltaAvg;
        private int inRangeDeltaMax;
        private int inRangeDeltaMin;
        private int tooLong;
        private int tooLongDelta;
        private int tooLongDeltaAvg;
        private int tooLongDeltaMax;
        private int tooLongDeltaMin;
        private int tooShort;
        private int tooShortDelta;
        private int tooShortDeltaAvg;
        private int tooShortDeltaMax;
        private int tooShortDeltaMin;

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

        public Builder withcrc(int crc){
            this.crc = crc;
            return this;
        }

        public Builder withcrcDelta(int crcDelta){
            this.crcDelta = crcDelta;
            return this;
        }

        public Builder withcrcDeltaAvg(int crcDeltaAvg){
            this.crcDeltaAvg = crcDeltaAvg;
            return this;
        }

        public Builder withcrcDeltaMax(int crcDeltaMax){
            this.crcDeltaMax = crcDeltaMax;
            return this;
        }

        public Builder withcrcDeltaMin(int crcDeltaMin){
            this.crcDeltaMin = crcDeltaMin;
            return this;
        }

        public Builder withframeTx(int frameTx){
            this.frameTx = frameTx;
            return this;
        }

        public Builder withframeTxDelta(int frameTxDelta){
            this.frameTxDelta = frameTxDelta;
            return this;
        }

        public Builder withframeTxDeltaAvg(int frameTxDeltaAvg){
            this.frameTxDeltaAvg = frameTxDeltaAvg;
            return this;
        }

        public Builder withframeTxDeltaMax(int frameTxDeltaMax){
            this.frameTxDeltaMax = frameTxDeltaMax;
            return this;
        }

        public Builder withframeTxDeltaMin(int frameTxDeltaMin){
            this.frameTxDeltaMin = frameTxDeltaMin;
            return this;
        }

        public Builder withinRange(int inRange){
            this.inRange = inRange;
            return this;
        }

        public Builder withinRangeDelta(int inRangeDelta){
            this.inRangeDelta = inRangeDelta;
            return this;
        }

        public Builder withinRangeDeltaAvg(int inRangeDeltaAvg){
            this.inRangeDeltaAvg = inRangeDeltaAvg;
            return this;
        }

        public Builder withinRangeDeltaMax(int inRangeDeltaMax){
            this.inRangeDeltaMax = inRangeDeltaMax;
            return this;
        }

        public Builder withinRangeDeltaMin(int inRangeDeltaMin){
            this.inRangeDeltaMin = inRangeDeltaMin;
            return this;
        }

        public Builder withtooLong(int tooLong){
            this.tooLong = tooLong;
            return this;
        }

        public Builder withtooLongDelta(int tooLongDelta){
            this.tooLongDelta = tooLongDelta;
            return this;
        }

        public Builder withtooLongDeltaAvg(int tooLongDeltaAvg){
            this.tooLongDeltaAvg = tooLongDeltaAvg;
            return this;
        }

        public Builder withtooLongDeltaMax(int tooLongDeltaMax){
            this.tooLongDeltaMax = tooLongDeltaMax;
            return this;
        }

        public Builder withtooLongDeltaMin(int tooLongDeltaMin){
            this.tooLongDeltaMin = tooLongDeltaMin;
            return this;
        }

        public Builder withtooShort(int tooShort){
            this.tooShort = tooShort;
            return this;
        }

        public Builder withtooShortDelta(int tooShortDelta){
            this.tooShortDelta = tooShortDelta;
            return this;
        }

        public Builder withtooShortDeltaAvg(int tooShortDeltaAvg){
            this.tooShortDeltaAvg = tooShortDeltaAvg;
            return this;
        }

        public Builder withtooShortDeltaMax(int tooShortDeltaMax){
            this.tooShortDeltaMax = tooShortDeltaMax;
            return this;
        }

        public Builder withtooShortDeltaMin(int tooShortDeltaMin){
            this.tooShortDeltaMin = tooShortDeltaMin;
            return this;
        }

        public UcsEtherNiErrStats build() {
            return new UcsEtherNiErrStats(this);
        }
    }
}
