package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherLossStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long SQETest;
    public final long SQETestDelta;
    public final long SQETestDeltaAvg;
    public final long SQETestDeltaMax;
    public final long SQETestDeltaMin;
    public final long carrierSense;
    public final long carrierSenseDelta;
    public final long carrierSenseDeltaAvg;
    public final long carrierSenseDeltaMax;
    public final long carrierSenseDeltaMin;
    public final long excessCollision;
    public final long excessCollisionDelta;
    public final long excessCollisionDeltaAvg;
    public final long excessCollisionDeltaMax;
    public final long excessCollisionDeltaMin;
    public final long giants;
    public final long giantsDelta;
    public final long giantsDeltaAvg;
    public final long giantsDeltaMax;
    public final long giantsDeltaMin;
    public final long lateCollision;
    public final long lateCollisionDelta;
    public final long lateCollisionDeltaAvg;
    public final long lateCollisionDeltaMax;
    public final long lateCollisionDeltaMin;
    public final long multiCollision;
    public final long multiCollisionDelta;
    public final long multiCollisionDeltaAvg;
    public final long multiCollisionDeltaMax;
    public final long multiCollisionDeltaMin;
    public final long singleCollision;
    public final long singleCollisionDelta;
    public final long singleCollisionDeltaAvg;
    public final long singleCollisionDeltaMax;
    public final long singleCollisionDeltaMin;
    public final long symbol;
    public final long symbolDelta;
    public final long symbolDeltaAvg;
    public final long symbolDeltaMax;
    public final long symbolDeltaMin;

    private UcsEtherLossStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherLossStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        SQETest = builder.SQETest;
        SQETestDelta = builder.SQETestDelta;
        SQETestDeltaAvg = builder.SQETestDeltaAvg;
        SQETestDeltaMax = builder.SQETestDeltaMax;
        SQETestDeltaMin = builder.SQETestDeltaMin;
        carrierSense = builder.carrierSense;
        carrierSenseDelta = builder.carrierSenseDelta;
        carrierSenseDeltaAvg = builder.carrierSenseDeltaAvg;
        carrierSenseDeltaMax = builder.carrierSenseDeltaMax;
        carrierSenseDeltaMin = builder.carrierSenseDeltaMin;
        excessCollision = builder.excessCollision;
        excessCollisionDelta = builder.excessCollisionDelta;
        excessCollisionDeltaAvg = builder.excessCollisionDeltaAvg;
        excessCollisionDeltaMax = builder.excessCollisionDeltaMax;
        excessCollisionDeltaMin = builder.excessCollisionDeltaMin;
        giants = builder.giants;
        giantsDelta = builder.giantsDelta;
        giantsDeltaAvg = builder.giantsDeltaAvg;
        giantsDeltaMax = builder.giantsDeltaMax;
        giantsDeltaMin = builder.giantsDeltaMin;
        lateCollision = builder.lateCollision;
        lateCollisionDelta = builder.lateCollisionDelta;
        lateCollisionDeltaAvg = builder.lateCollisionDeltaAvg;
        lateCollisionDeltaMax = builder.lateCollisionDeltaMax;
        lateCollisionDeltaMin = builder.lateCollisionDeltaMin;
        multiCollision = builder.multiCollision;
        multiCollisionDelta = builder.multiCollisionDelta;
        multiCollisionDeltaAvg = builder.multiCollisionDeltaAvg;
        multiCollisionDeltaMax = builder.multiCollisionDeltaMax;
        multiCollisionDeltaMin = builder.multiCollisionDeltaMin;
        singleCollision = builder.singleCollision;
        singleCollisionDelta = builder.singleCollisionDelta;
        singleCollisionDeltaAvg = builder.singleCollisionDeltaAvg;
        singleCollisionDeltaMax = builder.singleCollisionDeltaMax;
        singleCollisionDeltaMin = builder.singleCollisionDeltaMin;
        symbol = builder.symbol;
        symbolDelta = builder.symbolDelta;
        symbolDeltaAvg = builder.symbolDeltaAvg;
        symbolDeltaMax = builder.symbolDeltaMax;
        symbolDeltaMin = builder.symbolDeltaMin;
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

        private long SQETest;
        private long SQETestDelta;
        private long SQETestDeltaAvg;
        private long SQETestDeltaMax;
        private long SQETestDeltaMin;
        private long carrierSense;
        private long carrierSenseDelta;
        private long carrierSenseDeltaAvg;
        private long carrierSenseDeltaMax;
        private long carrierSenseDeltaMin;
        private long excessCollision;
        private long excessCollisionDelta;
        private long excessCollisionDeltaAvg;
        private long excessCollisionDeltaMax;
        private long excessCollisionDeltaMin;
        private long giants;
        private long giantsDelta;
        private long giantsDeltaAvg;
        private long giantsDeltaMax;
        private long giantsDeltaMin;
        private long lateCollision;
        private long lateCollisionDelta;
        private long lateCollisionDeltaAvg;
        private long lateCollisionDeltaMax;
        private long lateCollisionDeltaMin;
        private long multiCollision;
        private long multiCollisionDelta;
        private long multiCollisionDeltaAvg;
        private long multiCollisionDeltaMax;
        private long multiCollisionDeltaMin;
        private long singleCollision;
        private long singleCollisionDelta;
        private long singleCollisionDeltaAvg;
        private long singleCollisionDeltaMax;
        private long singleCollisionDeltaMin;
        private long symbol;
        private long symbolDelta;
        private long symbolDeltaAvg;
        private long symbolDeltaMax;
        private long symbolDeltaMin;

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

        public Builder withSQETest(long SQETest){
            this.SQETest = SQETest;
            return this;
        }

        public Builder withSQETestDelta(long SQETestDelta){
            this.SQETestDelta = SQETestDelta;
            return this;
        }

        public Builder withSQETestDeltaAvg(long SQETestDeltaAvg){
            this.SQETestDeltaAvg = SQETestDeltaAvg;
            return this;
        }

        public Builder withSQETestDeltaMax(long SQETestDeltaMax){
            this.SQETestDeltaMax = SQETestDeltaMax;
            return this;
        }

        public Builder withSQETestDeltaMin(long SQETestDeltaMin){
            this.SQETestDeltaMin = SQETestDeltaMin;
            return this;
        }

        public Builder withcarrierSense(long carrierSense){
            this.carrierSense = carrierSense;
            return this;
        }

        public Builder withcarrierSenseDelta(long carrierSenseDelta){
            this.carrierSenseDelta = carrierSenseDelta;
            return this;
        }

        public Builder withcarrierSenseDeltaAvg(long carrierSenseDeltaAvg){
            this.carrierSenseDeltaAvg = carrierSenseDeltaAvg;
            return this;
        }

        public Builder withcarrierSenseDeltaMax(long carrierSenseDeltaMax){
            this.carrierSenseDeltaMax = carrierSenseDeltaMax;
            return this;
        }

        public Builder withcarrierSenseDeltaMin(long carrierSenseDeltaMin){
            this.carrierSenseDeltaMin = carrierSenseDeltaMin;
            return this;
        }

        public Builder withexcessCollision(long excessCollision){
            this.excessCollision = excessCollision;
            return this;
        }

        public Builder withexcessCollisionDelta(long excessCollisionDelta){
            this.excessCollisionDelta = excessCollisionDelta;
            return this;
        }

        public Builder withexcessCollisionDeltaAvg(long excessCollisionDeltaAvg){
            this.excessCollisionDeltaAvg = excessCollisionDeltaAvg;
            return this;
        }

        public Builder withexcessCollisionDeltaMax(long excessCollisionDeltaMax){
            this.excessCollisionDeltaMax = excessCollisionDeltaMax;
            return this;
        }

        public Builder withexcessCollisionDeltaMin(long excessCollisionDeltaMin){
            this.excessCollisionDeltaMin = excessCollisionDeltaMin;
            return this;
        }

        public Builder withgiants(long giants){
            this.giants = giants;
            return this;
        }

        public Builder withgiantsDelta(long giantsDelta){
            this.giantsDelta = giantsDelta;
            return this;
        }

        public Builder withgiantsDeltaAvg(long giantsDeltaAvg){
            this.giantsDeltaAvg = giantsDeltaAvg;
            return this;
        }

        public Builder withgiantsDeltaMax(long giantsDeltaMax){
            this.giantsDeltaMax = giantsDeltaMax;
            return this;
        }

        public Builder withgiantsDeltaMin(long giantsDeltaMin){
            this.giantsDeltaMin = giantsDeltaMin;
            return this;
        }

        public Builder withlateCollision(long lateCollision){
            this.lateCollision = lateCollision;
            return this;
        }

        public Builder withlateCollisionDelta(long lateCollisionDelta){
            this.lateCollisionDelta = lateCollisionDelta;
            return this;
        }

        public Builder withlateCollisionDeltaAvg(long lateCollisionDeltaAvg){
            this.lateCollisionDeltaAvg = lateCollisionDeltaAvg;
            return this;
        }

        public Builder withlateCollisionDeltaMax(long lateCollisionDeltaMax){
            this.lateCollisionDeltaMax = lateCollisionDeltaMax;
            return this;
        }

        public Builder withlateCollisionDeltaMin(long lateCollisionDeltaMin){
            this.lateCollisionDeltaMin = lateCollisionDeltaMin;
            return this;
        }

        public Builder withmultiCollision(long multiCollision){
            this.multiCollision = multiCollision;
            return this;
        }

        public Builder withmultiCollisionDelta(long multiCollisionDelta){
            this.multiCollisionDelta = multiCollisionDelta;
            return this;
        }

        public Builder withmultiCollisionDeltaAvg(long multiCollisionDeltaAvg){
            this.multiCollisionDeltaAvg = multiCollisionDeltaAvg;
            return this;
        }

        public Builder withmultiCollisionDeltaMax(long multiCollisionDeltaMax){
            this.multiCollisionDeltaMax = multiCollisionDeltaMax;
            return this;
        }

        public Builder withmultiCollisionDeltaMin(long multiCollisionDeltaMin){
            this.multiCollisionDeltaMin = multiCollisionDeltaMin;
            return this;
        }

        public Builder withsingleCollision(long singleCollision){
            this.singleCollision = singleCollision;
            return this;
        }

        public Builder withsingleCollisionDelta(long singleCollisionDelta){
            this.singleCollisionDelta = singleCollisionDelta;
            return this;
        }

        public Builder withsingleCollisionDeltaAvg(long singleCollisionDeltaAvg){
            this.singleCollisionDeltaAvg = singleCollisionDeltaAvg;
            return this;
        }

        public Builder withsingleCollisionDeltaMax(long singleCollisionDeltaMax){
            this.singleCollisionDeltaMax = singleCollisionDeltaMax;
            return this;
        }

        public Builder withsingleCollisionDeltaMin(long singleCollisionDeltaMin){
            this.singleCollisionDeltaMin = singleCollisionDeltaMin;
            return this;
        }

        public Builder withsymbol(long symbol){
            this.symbol = symbol;
            return this;
        }

        public Builder withsymbolDelta(long symbolDelta){
            this.symbolDelta = symbolDelta;
            return this;
        }

        public Builder withsymbolDeltaAvg(long symbolDeltaAvg){
            this.symbolDeltaAvg = symbolDeltaAvg;
            return this;
        }

        public Builder withsymbolDeltaMax(long symbolDeltaMax){
            this.symbolDeltaMax = symbolDeltaMax;
            return this;
        }

        public Builder withsymbolDeltaMin(long symbolDeltaMin){
            this.symbolDeltaMin = symbolDeltaMin;
            return this;
        }

        public UcsEtherLossStats build() {
            return new UcsEtherLossStats(this);
        }
    }
}
