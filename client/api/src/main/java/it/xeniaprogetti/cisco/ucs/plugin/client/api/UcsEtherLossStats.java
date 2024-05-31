package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherLossStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long SQETest;
    public final long carrierSense;
    public final long excessCollision;
    public final long giants;
    public final long lateCollision;
    public final long multiCollision;
    public final long singleCollision;
    public final long symbol;

    private UcsEtherLossStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherLossStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        SQETest = builder.SQETest;
        carrierSense = builder.carrierSense;
        excessCollision = builder.excessCollision;
        giants = builder.giants;
        lateCollision = builder.lateCollision;
        multiCollision = builder.multiCollision;
        singleCollision = builder.singleCollision;
        symbol = builder.symbol;
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
        private long carrierSense;
        private long excessCollision;
        private long giants;
        private long lateCollision;
        private long multiCollision;
        private long singleCollision;
        private long symbol;

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

        public Builder withCarrierSense(long carrierSense){
            this.carrierSense = carrierSense;
            return this;
        }

        public Builder withExcessCollision(long excessCollision){
            this.excessCollision = excessCollision;
            return this;
        }

        public Builder withGiants(long giants){
            this.giants = giants;
            return this;
        }

        public Builder withLateCollision(long lateCollision){
            this.lateCollision = lateCollision;
            return this;
        }

        public Builder withMultiCollision(long multiCollision){
            this.multiCollision = multiCollision;
            return this;
        }


        public Builder withSingleCollision(long singleCollision){
            this.singleCollision = singleCollision;
            return this;
        }

        public Builder withSymbol(long symbol){
            this.symbol = symbol;
            return this;
        }

        public UcsEtherLossStats build() {
            return new UcsEtherLossStats(this);
        }
    }
}
