package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherErrStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long align;
    public final long alignDelta;
    public final long alignDeltaAvg;
    public final long alignDeltaMax;
    public final long alignDeltaMin;
    public final long deferredTx;
    public final long deferredTxDelta;
    public final long deferredTxDeltaAvg;
    public final long deferredTxDeltaMax;
    public final long deferredTxDeltaMin;
    public final long fcs;
    public final long fcsDelta;
    public final long fcsDeltaAvg;
    public final long fcsDeltaMax;
    public final long fcsDeltaMin;
    public final long intMacRx;
    public final long intMacRxDelta;
    public final long intMacRxDeltaAvg;
    public final long intMacRxDeltaMax;
    public final long intMacRxDeltaMin;
    public final long intMacTx;
    public final long intMacTxDelta;
    public final long intMacTxDeltaAvg;
    public final long intMacTxDeltaMax;
    public final long intMacTxDeltaMin;
    public final long outDiscard;
    public final long outDiscardDelta;
    public final long outDiscardDeltaAvg;
    public final long outDiscardDeltaMax;
    public final long outDiscardDeltaMin;
    public final long rcv;
    public final long rcvDelta;
    public final long rcvDeltaAvg;
    public final long rcvDeltaMax;
    public final long rcvDeltaMin;
    public final long underSize;
    public final long underSizeDelta;
    public final long underSizeDeltaAvg;
    public final long underSizeDeltaMax;
    public final long underSizeDeltaMin;
    public final long xmit;
    public final long xmitDelta;
    public final long xmitDeltaAvg;
    public final long xmitDeltaMax;
    public final long xmitDeltaMin;

    private UcsEtherErrStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherErrStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        align = builder.align;
        alignDelta = builder.alignDelta;
        alignDeltaAvg = builder.alignDeltaAvg;
        alignDeltaMax = builder.alignDeltaMax;
        alignDeltaMin = builder.alignDeltaMin;
        deferredTx = builder.deferredTx;
        deferredTxDelta = builder.deferredTxDelta;
        deferredTxDeltaAvg = builder.deferredTxDeltaAvg;
        deferredTxDeltaMax = builder.deferredTxDeltaMax;
        deferredTxDeltaMin = builder.deferredTxDeltaMin;
        fcs = builder.fcs;
        fcsDelta = builder.fcsDelta;
        fcsDeltaAvg = builder.fcsDeltaAvg;
        fcsDeltaMax = builder.fcsDeltaMax;
        fcsDeltaMin = builder.fcsDeltaMin;
        intMacRx = builder.intMacRx;
        intMacRxDelta = builder.intMacRxDelta;
        intMacRxDeltaAvg = builder.intMacRxDeltaAvg;
        intMacRxDeltaMax = builder.intMacRxDeltaMax;
        intMacRxDeltaMin = builder.intMacRxDeltaMin;
        intMacTx = builder.intMacTx;
        intMacTxDelta = builder.intMacTxDelta;
        intMacTxDeltaAvg = builder.intMacTxDeltaAvg;
        intMacTxDeltaMax = builder.intMacTxDeltaMax;
        intMacTxDeltaMin = builder.intMacTxDeltaMin;
        outDiscard = builder.outDiscard;
        outDiscardDelta = builder.outDiscardDelta;
        outDiscardDeltaAvg = builder.outDiscardDeltaAvg;
        outDiscardDeltaMax = builder.outDiscardDeltaMax;
        outDiscardDeltaMin = builder.outDiscardDeltaMin;
        rcv = builder.rcv;
        rcvDelta = builder.rcvDelta;
        rcvDeltaAvg = builder.rcvDeltaAvg;
        rcvDeltaMax = builder.rcvDeltaMax;
        rcvDeltaMin = builder.rcvDeltaMin;
        underSize = builder.underSize;
        underSizeDelta = builder.underSizeDelta;
        underSizeDeltaAvg = builder.underSizeDeltaAvg;
        underSizeDeltaMax = builder.underSizeDeltaMax;
        underSizeDeltaMin = builder.underSizeDeltaMin;
        xmit = builder.xmit;
        xmitDelta = builder.xmitDelta;
        xmitDeltaAvg = builder.xmitDeltaAvg;
        xmitDeltaMax = builder.xmitDeltaMax;
        xmitDeltaMin = builder.xmitDeltaMin;
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

        private long align;
        private long alignDelta;
        private long alignDeltaAvg;
        private long alignDeltaMax;
        private long alignDeltaMin;
        private long deferredTx;
        private long deferredTxDelta;
        private long deferredTxDeltaAvg;
        private long deferredTxDeltaMax;
        private long deferredTxDeltaMin;
        private long fcs;
        private long fcsDelta;
        private long fcsDeltaAvg;
        private long fcsDeltaMax;
        private long fcsDeltaMin;
        private long intMacRx;
        private long intMacRxDelta;
        private long intMacRxDeltaAvg;
        private long intMacRxDeltaMax;
        private long intMacRxDeltaMin;
        private long intMacTx;
        private long intMacTxDelta;
        private long intMacTxDeltaAvg;
        private long intMacTxDeltaMax;
        private long intMacTxDeltaMin;
        private long outDiscard;
        private long outDiscardDelta;
        private long outDiscardDeltaAvg;
        private long outDiscardDeltaMax;
        private long outDiscardDeltaMin;
        private long rcv;
        private long rcvDelta;
        private long rcvDeltaAvg;
        private long rcvDeltaMax;
        private long rcvDeltaMin;
        private long underSize;
        private long underSizeDelta;
        private long underSizeDeltaAvg;
        private long underSizeDeltaMax;
        private long underSizeDeltaMin;
        private long xmit;
        private long xmitDelta;
        private long xmitDeltaAvg;
        private long xmitDeltaMax;
        private long xmitDeltaMin;

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

        public Builder withalign(long align){
            this.align = align;
            return this;
        }

        public Builder withalignDelta(long alignDelta){
            this.alignDelta = alignDelta;
            return this;
        }

        public Builder withalignDeltaAvg(long alignDeltaAvg){
            this.alignDeltaAvg = alignDeltaAvg;
            return this;
        }

        public Builder withalignDeltaMax(long alignDeltaMax){
            this.alignDeltaMax = alignDeltaMax;
            return this;
        }

        public Builder withalignDeltaMin(long alignDeltaMin){
            this.alignDeltaMin = alignDeltaMin;
            return this;
        }

        public Builder withdeferredTx(long deferredTx){
            this.deferredTx = deferredTx;
            return this;
        }

        public Builder withdeferredTxDelta(long deferredTxDelta){
            this.deferredTxDelta = deferredTxDelta;
            return this;
        }

        public Builder withdeferredTxDeltaAvg(long deferredTxDeltaAvg){
            this.deferredTxDeltaAvg = deferredTxDeltaAvg;
            return this;
        }

        public Builder withdeferredTxDeltaMax(long deferredTxDeltaMax){
            this.deferredTxDeltaMax = deferredTxDeltaMax;
            return this;
        }

        public Builder withdeferredTxDeltaMin(long deferredTxDeltaMin){
            this.deferredTxDeltaMin = deferredTxDeltaMin;
            return this;
        }

        public Builder withfcs(long fcs){
            this.fcs = fcs;
            return this;
        }

        public Builder withfcsDelta(long fcsDelta){
            this.fcsDelta = fcsDelta;
            return this;
        }

        public Builder withfcsDeltaAvg(long fcsDeltaAvg){
            this.fcsDeltaAvg = fcsDeltaAvg;
            return this;
        }

        public Builder withfcsDeltaMax(long fcsDeltaMax){
            this.fcsDeltaMax = fcsDeltaMax;
            return this;
        }

        public Builder withfcsDeltaMin(long fcsDeltaMin){
            this.fcsDeltaMin = fcsDeltaMin;
            return this;
        }

        public Builder withintMacRx(long intMacRx){
            this.intMacRx = intMacRx;
            return this;
        }

        public Builder withintMacRxDelta(long intMacRxDelta){
            this.intMacRxDelta = intMacRxDelta;
            return this;
        }

        public Builder withintMacRxDeltaAvg(long intMacRxDeltaAvg){
            this.intMacRxDeltaAvg = intMacRxDeltaAvg;
            return this;
        }

        public Builder withintMacRxDeltaMax(long intMacRxDeltaMax){
            this.intMacRxDeltaMax = intMacRxDeltaMax;
            return this;
        }

        public Builder withintMacRxDeltaMin(long intMacRxDeltaMin){
            this.intMacRxDeltaMin = intMacRxDeltaMin;
            return this;
        }

        public Builder withintMacTx(long intMacTx){
            this.intMacTx = intMacTx;
            return this;
        }

        public Builder withintMacTxDelta(long intMacTxDelta){
            this.intMacTxDelta = intMacTxDelta;
            return this;
        }

        public Builder withintMacTxDeltaAvg(long intMacTxDeltaAvg){
            this.intMacTxDeltaAvg = intMacTxDeltaAvg;
            return this;
        }

        public Builder withintMacTxDeltaMax(long intMacTxDeltaMax){
            this.intMacTxDeltaMax = intMacTxDeltaMax;
            return this;
        }

        public Builder withintMacTxDeltaMin(long intMacTxDeltaMin){
            this.intMacTxDeltaMin = intMacTxDeltaMin;
            return this;
        }

        public Builder withoutDiscard(long outDiscard){
            this.outDiscard = outDiscard;
            return this;
        }

        public Builder withoutDiscardDelta(long outDiscardDelta){
            this.outDiscardDelta = outDiscardDelta;
            return this;
        }

        public Builder withoutDiscardDeltaAvg(long outDiscardDeltaAvg){
            this.outDiscardDeltaAvg = outDiscardDeltaAvg;
            return this;
        }

        public Builder withoutDiscardDeltaMax(long outDiscardDeltaMax){
            this.outDiscardDeltaMax = outDiscardDeltaMax;
            return this;
        }

        public Builder withoutDiscardDeltaMin(long outDiscardDeltaMin){
            this.outDiscardDeltaMin = outDiscardDeltaMin;
            return this;
        }

        public Builder withrcv(long rcv){
            this.rcv = rcv;
            return this;
        }

        public Builder withrcvDelta(long rcvDelta){
            this.rcvDelta = rcvDelta;
            return this;
        }

        public Builder withrcvDeltaAvg(long rcvDeltaAvg){
            this.rcvDeltaAvg = rcvDeltaAvg;
            return this;
        }

        public Builder withrcvDeltaMax(long rcvDeltaMax){
            this.rcvDeltaMax = rcvDeltaMax;
            return this;
        }

        public Builder withrcvDeltaMin(long rcvDeltaMin){
            this.rcvDeltaMin = rcvDeltaMin;
            return this;
        }

        public Builder withunderSize(long underSize){
            this.underSize = underSize;
            return this;
        }

        public Builder withunderSizeDelta(long underSizeDelta){
            this.underSizeDelta = underSizeDelta;
            return this;
        }

        public Builder withunderSizeDeltaAvg(long underSizeDeltaAvg){
            this.underSizeDeltaAvg = underSizeDeltaAvg;
            return this;
        }

        public Builder withunderSizeDeltaMax(long underSizeDeltaMax){
            this.underSizeDeltaMax = underSizeDeltaMax;
            return this;
        }

        public Builder withunderSizeDeltaMin(long underSizeDeltaMin){
            this.underSizeDeltaMin = underSizeDeltaMin;
            return this;
        }

        public Builder withxmit(long xmit){
            this.xmit = xmit;
            return this;
        }

        public Builder withxmitDelta(long xmitDelta){
            this.xmitDelta = xmitDelta;
            return this;
        }

        public Builder withxmitDeltaAvg(long xmitDeltaAvg){
            this.xmitDeltaAvg = xmitDeltaAvg;
            return this;
        }

        public Builder withxmitDeltaMax(long xmitDeltaMax){
            this.xmitDeltaMax = xmitDeltaMax;
            return this;
        }

        public Builder withxmitDeltaMin(long xmitDeltaMin){
            this.xmitDeltaMin = xmitDeltaMin;
            return this;
        }

        public UcsEtherErrStats build() {
            return new UcsEtherErrStats(this);
        }
    }
}
