package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsFcErrStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int crcRx;
    public final int crcRxDelta;
    public final int crcRxDeltaAvg;
    public final int crcRxDeltaMax;
    public final int crcRxDeltaMin;
    public final int discardRx;
    public final int discardRxDelta;
    public final int discardRxDeltaAvg;
    public final int discardRxDeltaMax;
    public final int discardRxDeltaMin;
    public final int discardTx;
    public final int discardTxDelta;
    public final int discardTxDeltaAvg;
    public final int discardTxDeltaMax;
    public final int discardTxDeltaMin;
    public final int linkFailures;
    public final int linkFailuresDelta;
    public final int linkFailuresDeltaAvg;
    public final int linkFailuresDeltaMax;
    public final int linkFailuresDeltaMin;
    public final int rx;
    public final int rxDelta;
    public final int rxDeltaAvg;
    public final int rxDeltaMax;
    public final int rxDeltaMin;
    public final int signalLosses;
    public final int signalLossesDelta;
    public final int signalLossesDeltaAvg;
    public final int signalLossesDeltaMax;
    public final int signalLossesDeltaMin;
    public final int syncLosses;
    public final int syncLossesDelta;
    public final int syncLossesDeltaAvg;
    public final int syncLossesDeltaMax;
    public final int syncLossesDeltaMin;
    public final int tooLongRx;
    public final int tooLongRxDelta;
    public final int tooLongRxDeltaAvg;
    public final int tooLongRxDeltaMax;
    public final int tooLongRxDeltaMin;
    public final int tooShortRx;
    public final int tooShortRxDelta;
    public final int tooShortRxDeltaAvg;
    public final int tooShortRxDeltaMax;
    public final int tooShortRxDeltaMin;
    public final int tx;
    public final int txDelta;
    public final int txDeltaAvg;
    public final int txDeltaMax;
    public final int txDeltaMin;

    private UcsFcErrStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.fcErrStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        crcRx = builder.crcRx;
        crcRxDelta = builder.crcRxDelta;
        crcRxDeltaAvg = builder.crcRxDeltaAvg;
        crcRxDeltaMax = builder.crcRxDeltaMax;
        crcRxDeltaMin = builder.crcRxDeltaMin;
        discardRx = builder.discardRx;
        discardRxDelta = builder.discardRxDelta;
        discardRxDeltaAvg = builder.discardRxDeltaAvg;
        discardRxDeltaMax = builder.discardRxDeltaMax;
        discardRxDeltaMin = builder.discardRxDeltaMin;
        discardTx = builder.discardTx;
        discardTxDelta = builder.discardTxDelta;
        discardTxDeltaAvg = builder.discardTxDeltaAvg;
        discardTxDeltaMax = builder.discardTxDeltaMax;
        discardTxDeltaMin = builder.discardTxDeltaMin;
        linkFailures = builder.linkFailures;
        linkFailuresDelta = builder.linkFailuresDelta;
        linkFailuresDeltaAvg = builder.linkFailuresDeltaAvg;
        linkFailuresDeltaMax = builder.linkFailuresDeltaMax;
        linkFailuresDeltaMin = builder.linkFailuresDeltaMin;
        rx = builder.rx;
        rxDelta = builder.rxDelta;
        rxDeltaAvg = builder.rxDeltaAvg;
        rxDeltaMax = builder.rxDeltaMax;
        rxDeltaMin = builder.rxDeltaMin;
        signalLosses = builder.signalLosses;
        signalLossesDelta = builder.signalLossesDelta;
        signalLossesDeltaAvg = builder.signalLossesDeltaAvg;
        signalLossesDeltaMax = builder.signalLossesDeltaMax;
        signalLossesDeltaMin = builder.signalLossesDeltaMin;
        syncLosses = builder.syncLosses;
        syncLossesDelta = builder.syncLossesDelta;
        syncLossesDeltaAvg = builder.syncLossesDeltaAvg;
        syncLossesDeltaMax = builder.syncLossesDeltaMax;
        syncLossesDeltaMin = builder.syncLossesDeltaMin;
        tooLongRx = builder.tooLongRx;
        tooLongRxDelta = builder.tooLongRxDelta;
        tooLongRxDeltaAvg = builder.tooLongRxDeltaAvg;
        tooLongRxDeltaMax = builder.tooLongRxDeltaMax;
        tooLongRxDeltaMin = builder.tooLongRxDeltaMin;
        tooShortRx = builder.tooShortRx;
        tooShortRxDelta = builder.tooShortRxDelta;
        tooShortRxDeltaAvg = builder.tooShortRxDeltaAvg;
        tooShortRxDeltaMax = builder.tooShortRxDeltaMax;
        tooShortRxDeltaMin = builder.tooShortRxDeltaMin;
        tx = builder.tx;
        txDelta = builder.txDelta;
        txDeltaAvg = builder.txDeltaAvg;
        txDeltaMax = builder.txDeltaMax;
        txDeltaMin = builder.txDeltaMin;
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

        private int crcRx;
        private int crcRxDelta;
        private int crcRxDeltaAvg;
        private int crcRxDeltaMax;
        private int crcRxDeltaMin;
        private int discardRx;
        private int discardRxDelta;
        private int discardRxDeltaAvg;
        private int discardRxDeltaMax;
        private int discardRxDeltaMin;
        private int discardTx;
        private int discardTxDelta;
        private int discardTxDeltaAvg;
        private int discardTxDeltaMax;
        private int discardTxDeltaMin;
        private int linkFailures;
        private int linkFailuresDelta;
        private int linkFailuresDeltaAvg;
        private int linkFailuresDeltaMax;
        private int linkFailuresDeltaMin;
        private int rx;
        private int rxDelta;
        private int rxDeltaAvg;
        private int rxDeltaMax;
        private int rxDeltaMin;
        private int signalLosses;
        private int signalLossesDelta;
        private int signalLossesDeltaAvg;
        private int signalLossesDeltaMax;
        private int signalLossesDeltaMin;
        private int syncLosses;
        private int syncLossesDelta;
        private int syncLossesDeltaAvg;
        private int syncLossesDeltaMax;
        private int syncLossesDeltaMin;
        private int tooLongRx;
        private int tooLongRxDelta;
        private int tooLongRxDeltaAvg;
        private int tooLongRxDeltaMax;
        private int tooLongRxDeltaMin;
        private int tooShortRx;
        private int tooShortRxDelta;
        private int tooShortRxDeltaAvg;
        private int tooShortRxDeltaMax;
        private int tooShortRxDeltaMin;
        private int tx;
        private int txDelta;
        private int txDeltaAvg;
        private int txDeltaMax;
        private int txDeltaMin;

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

        public Builder withcrcRx(int crcRx){
            this.crcRx = crcRx;
            return this;
        }

        public Builder withcrcRxDelta(int crcRxDelta){
            this.crcRxDelta = crcRxDelta;
            return this;
        }

        public Builder withcrcRxDeltaAvg(int crcRxDeltaAvg){
            this.crcRxDeltaAvg = crcRxDeltaAvg;
            return this;
        }

        public Builder withcrcRxDeltaMax(int crcRxDeltaMax){
            this.crcRxDeltaMax = crcRxDeltaMax;
            return this;
        }

        public Builder withcrcRxDeltaMin(int crcRxDeltaMin){
            this.crcRxDeltaMin = crcRxDeltaMin;
            return this;
        }

        public Builder withdiscardRx(int discardRx){
            this.discardRx = discardRx;
            return this;
        }

        public Builder withdiscardRxDelta(int discardRxDelta){
            this.discardRxDelta = discardRxDelta;
            return this;
        }

        public Builder withdiscardRxDeltaAvg(int discardRxDeltaAvg){
            this.discardRxDeltaAvg = discardRxDeltaAvg;
            return this;
        }

        public Builder withdiscardRxDeltaMax(int discardRxDeltaMax){
            this.discardRxDeltaMax = discardRxDeltaMax;
            return this;
        }

        public Builder withdiscardRxDeltaMin(int discardRxDeltaMin){
            this.discardRxDeltaMin = discardRxDeltaMin;
            return this;
        }

        public Builder withdiscardTx(int discardTx){
            this.discardTx = discardTx;
            return this;
        }

        public Builder withdiscardTxDelta(int discardTxDelta){
            this.discardTxDelta = discardTxDelta;
            return this;
        }

        public Builder withdiscardTxDeltaAvg(int discardTxDeltaAvg){
            this.discardTxDeltaAvg = discardTxDeltaAvg;
            return this;
        }

        public Builder withdiscardTxDeltaMax(int discardTxDeltaMax){
            this.discardTxDeltaMax = discardTxDeltaMax;
            return this;
        }

        public Builder withdiscardTxDeltaMin(int discardTxDeltaMin){
            this.discardTxDeltaMin = discardTxDeltaMin;
            return this;
        }

        public Builder withlinkFailures(int linkFailures){
            this.linkFailures = linkFailures;
            return this;
        }

        public Builder withlinkFailuresDelta(int linkFailuresDelta){
            this.linkFailuresDelta = linkFailuresDelta;
            return this;
        }

        public Builder withlinkFailuresDeltaAvg(int linkFailuresDeltaAvg){
            this.linkFailuresDeltaAvg = linkFailuresDeltaAvg;
            return this;
        }

        public Builder withlinkFailuresDeltaMax(int linkFailuresDeltaMax){
            this.linkFailuresDeltaMax = linkFailuresDeltaMax;
            return this;
        }

        public Builder withlinkFailuresDeltaMin(int linkFailuresDeltaMin){
            this.linkFailuresDeltaMin = linkFailuresDeltaMin;
            return this;
        }

        public Builder withrx(int rx){
            this.rx = rx;
            return this;
        }

        public Builder withrxDelta(int rxDelta){
            this.rxDelta = rxDelta;
            return this;
        }

        public Builder withrxDeltaAvg(int rxDeltaAvg){
            this.rxDeltaAvg = rxDeltaAvg;
            return this;
        }

        public Builder withrxDeltaMax(int rxDeltaMax){
            this.rxDeltaMax = rxDeltaMax;
            return this;
        }

        public Builder withrxDeltaMin(int rxDeltaMin){
            this.rxDeltaMin = rxDeltaMin;
            return this;
        }

        public Builder withsignalLosses(int signalLosses){
            this.signalLosses = signalLosses;
            return this;
        }

        public Builder withsignalLossesDelta(int signalLossesDelta){
            this.signalLossesDelta = signalLossesDelta;
            return this;
        }

        public Builder withsignalLossesDeltaAvg(int signalLossesDeltaAvg){
            this.signalLossesDeltaAvg = signalLossesDeltaAvg;
            return this;
        }

        public Builder withsignalLossesDeltaMax(int signalLossesDeltaMax){
            this.signalLossesDeltaMax = signalLossesDeltaMax;
            return this;
        }

        public Builder withsignalLossesDeltaMin(int signalLossesDeltaMin){
            this.signalLossesDeltaMin = signalLossesDeltaMin;
            return this;
        }

        public Builder withsyncLosses(int syncLosses){
            this.syncLosses = syncLosses;
            return this;
        }

        public Builder withsyncLossesDelta(int syncLossesDelta){
            this.syncLossesDelta = syncLossesDelta;
            return this;
        }

        public Builder withsyncLossesDeltaAvg(int syncLossesDeltaAvg){
            this.syncLossesDeltaAvg = syncLossesDeltaAvg;
            return this;
        }

        public Builder withsyncLossesDeltaMax(int syncLossesDeltaMax){
            this.syncLossesDeltaMax = syncLossesDeltaMax;
            return this;
        }

        public Builder withsyncLossesDeltaMin(int syncLossesDeltaMin){
            this.syncLossesDeltaMin = syncLossesDeltaMin;
            return this;
        }

        public Builder withtooLongRx(int tooLongRx){
            this.tooLongRx = tooLongRx;
            return this;
        }

        public Builder withtooLongRxDelta(int tooLongRxDelta){
            this.tooLongRxDelta = tooLongRxDelta;
            return this;
        }

        public Builder withtooLongRxDeltaAvg(int tooLongRxDeltaAvg){
            this.tooLongRxDeltaAvg = tooLongRxDeltaAvg;
            return this;
        }

        public Builder withtooLongRxDeltaMax(int tooLongRxDeltaMax){
            this.tooLongRxDeltaMax = tooLongRxDeltaMax;
            return this;
        }

        public Builder withtooLongRxDeltaMin(int tooLongRxDeltaMin){
            this.tooLongRxDeltaMin = tooLongRxDeltaMin;
            return this;
        }

        public Builder withtooShortRx(int tooShortRx){
            this.tooShortRx = tooShortRx;
            return this;
        }

        public Builder withtooShortRxDelta(int tooShortRxDelta){
            this.tooShortRxDelta = tooShortRxDelta;
            return this;
        }

        public Builder withtooShortRxDeltaAvg(int tooShortRxDeltaAvg){
            this.tooShortRxDeltaAvg = tooShortRxDeltaAvg;
            return this;
        }

        public Builder withtooShortRxDeltaMax(int tooShortRxDeltaMax){
            this.tooShortRxDeltaMax = tooShortRxDeltaMax;
            return this;
        }

        public Builder withtooShortRxDeltaMin(int tooShortRxDeltaMin){
            this.tooShortRxDeltaMin = tooShortRxDeltaMin;
            return this;
        }

        public Builder withtx(int tx){
            this.tx = tx;
            return this;
        }

        public Builder withtxDelta(int txDelta){
            this.txDelta = txDelta;
            return this;
        }

        public Builder withtxDeltaAvg(int txDeltaAvg){
            this.txDeltaAvg = txDeltaAvg;
            return this;
        }

        public Builder withtxDeltaMax(int txDeltaMax){
            this.txDeltaMax = txDeltaMax;
            return this;
        }

        public Builder withtxDeltaMin(int txDeltaMin){
            this.txDeltaMin = txDeltaMin;
            return this;
        }

        public UcsFcErrStats build() {
            return new UcsFcErrStats(this);
        }
    }
}
