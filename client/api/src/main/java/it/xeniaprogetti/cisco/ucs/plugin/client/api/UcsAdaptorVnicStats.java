package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsAdaptorVnicStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long bytesRx;
    public final long bytesRxDelta;
    public final long bytesRxDeltaAvg;
    public final long bytesRxDeltaMax;
    public final long bytesRxDeltaMin;
    public final long bytesTx;
    public final long bytesTxDelta;
    public final long bytesTxDeltaAvg;
    public final long bytesTxDeltaMax;
    public final long bytesTxDeltaMin;
    public final int droppedRx;
    public final int droppedRxDelta;
    public final int droppedRxDeltaAvg;
    public final int droppedRxDeltaMax;
    public final int droppedRxDeltaMin;
    public final int droppedTx;
    public final int droppedTxDelta;
    public final int droppedTxDeltaAvg;
    public final int droppedTxDeltaMax;
    public final int droppedTxDeltaMin;
    public final int errorsRx;
    public final int errorsRxDelta;
    public final int errorsRxDeltaAvg;
    public final int errorsRxDeltaMax;
    public final int errorsRxDeltaMin;
    public final int errorsTx;
    public final int errorsTxDelta;
    public final int errorsTxDeltaAvg;
    public final int errorsTxDeltaMax;
    public final int errorsTxDeltaMin;
    public final int packetsRx;
    public final int packetsRxDelta;
    public final int packetsRxDeltaAvg;
    public final int packetsRxDeltaMax;
    public final int packetsRxDeltaMin;
    public final int packetsTx;
    public final int packetsTxDelta;
    public final int packetsTxDeltaAvg;
    public final int packetsTxDeltaMax;
    public final int packetsTxDeltaMin;

    private UcsAdaptorVnicStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.adaptorVnicStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        bytesRx = builder.bytesRx;
        bytesRxDelta = builder.bytesRxDelta;
        bytesRxDeltaAvg = builder.bytesRxDeltaAvg;
        bytesRxDeltaMax = builder.bytesRxDeltaMax;
        bytesRxDeltaMin = builder.bytesRxDeltaMin;
        bytesTx = builder.bytesTx;
        bytesTxDelta = builder.bytesTxDelta;
        bytesTxDeltaAvg = builder.bytesTxDeltaAvg;
        bytesTxDeltaMax = builder.bytesTxDeltaMax;
        bytesTxDeltaMin = builder.bytesTxDeltaMin;
        droppedRx = builder.droppedRx;
        droppedRxDelta = builder.droppedRxDelta;
        droppedRxDeltaAvg = builder.droppedRxDeltaAvg;
        droppedRxDeltaMax = builder.droppedRxDeltaMax;
        droppedRxDeltaMin = builder.droppedRxDeltaMin;
        droppedTx = builder.droppedTx;
        droppedTxDelta = builder.droppedTxDelta;
        droppedTxDeltaAvg = builder.droppedTxDeltaAvg;
        droppedTxDeltaMax = builder.droppedTxDeltaMax;
        droppedTxDeltaMin = builder.droppedTxDeltaMin;
        errorsRx = builder.errorsRx;
        errorsRxDelta = builder.errorsRxDelta;
        errorsRxDeltaAvg = builder.errorsRxDeltaAvg;
        errorsRxDeltaMax = builder.errorsRxDeltaMax;
        errorsRxDeltaMin = builder.errorsRxDeltaMin;
        errorsTx = builder.errorsTx;
        errorsTxDelta = builder.errorsTxDelta;
        errorsTxDeltaAvg = builder.errorsTxDeltaAvg;
        errorsTxDeltaMax = builder.errorsTxDeltaMax;
        errorsTxDeltaMin = builder.errorsTxDeltaMin;
        packetsRx = builder.packetsRx;
        packetsRxDelta = builder.packetsRxDelta;
        packetsRxDeltaAvg = builder.packetsRxDeltaAvg;
        packetsRxDeltaMax = builder.packetsRxDeltaMax;
        packetsRxDeltaMin = builder.packetsRxDeltaMin;
        packetsTx = builder.packetsTx;
        packetsTxDelta = builder.packetsTxDelta;
        packetsTxDeltaAvg = builder.packetsTxDeltaAvg;
        packetsTxDeltaMax = builder.packetsTxDeltaMax;
        packetsTxDeltaMin = builder.packetsTxDeltaMin;
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

        private long bytesRx;
        private long bytesRxDelta;
        private long bytesRxDeltaAvg;
        private long bytesRxDeltaMax;
        private long bytesRxDeltaMin;
        private long bytesTx;
        private long bytesTxDelta;
        private long bytesTxDeltaAvg;
        private long bytesTxDeltaMax;
        private long bytesTxDeltaMin;
        private int droppedRx;
        private int droppedRxDelta;
        private int droppedRxDeltaAvg;
        private int droppedRxDeltaMax;
        private int droppedRxDeltaMin;
        private int droppedTx;
        private int droppedTxDelta;
        private int droppedTxDeltaAvg;
        private int droppedTxDeltaMax;
        private int droppedTxDeltaMin;
        private int errorsRx;
        private int errorsRxDelta;
        private int errorsRxDeltaAvg;
        private int errorsRxDeltaMax;
        private int errorsRxDeltaMin;
        private int errorsTx;
        private int errorsTxDelta;
        private int errorsTxDeltaAvg;
        private int errorsTxDeltaMax;
        private int errorsTxDeltaMin;
        private int packetsRx;
        private int packetsRxDelta;
        private int packetsRxDeltaAvg;
        private int packetsRxDeltaMax;
        private int packetsRxDeltaMin;
        private int packetsTx;
        private int packetsTxDelta;
        private int packetsTxDeltaAvg;
        private int packetsTxDeltaMax;
        private int packetsTxDeltaMin;

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

        public Builder withbytesRx(long bytesRx){
            this.bytesRx = bytesRx;
            return this;
        }

        public Builder withbytesRxDelta(long bytesRxDelta){
            this.bytesRxDelta = bytesRxDelta;
            return this;
        }

        public Builder withbytesRxDeltaAvg(long bytesRxDeltaAvg){
            this.bytesRxDeltaAvg = bytesRxDeltaAvg;
            return this;
        }

        public Builder withbytesRxDeltaMax(long bytesRxDeltaMax){
            this.bytesRxDeltaMax = bytesRxDeltaMax;
            return this;
        }

        public Builder withbytesRxDeltaMin(long bytesRxDeltaMin){
            this.bytesRxDeltaMin = bytesRxDeltaMin;
            return this;
        }

        public Builder withbytesTx(long bytesTx){
            this.bytesTx = bytesTx;
            return this;
        }

        public Builder withbytesTxDelta(long bytesTxDelta){
            this.bytesTxDelta = bytesTxDelta;
            return this;
        }

        public Builder withbytesTxDeltaAvg(long bytesTxDeltaAvg){
            this.bytesTxDeltaAvg = bytesTxDeltaAvg;
            return this;
        }

        public Builder withbytesTxDeltaMax(long bytesTxDeltaMax){
            this.bytesTxDeltaMax = bytesTxDeltaMax;
            return this;
        }

        public Builder withbytesTxDeltaMin(long bytesTxDeltaMin){
            this.bytesTxDeltaMin = bytesTxDeltaMin;
            return this;
        }

        public Builder withdroppedRx(int droppedRx){
            this.droppedRx = droppedRx;
            return this;
        }

        public Builder withdroppedRxDelta(int droppedRxDelta){
            this.droppedRxDelta = droppedRxDelta;
            return this;
        }

        public Builder withdroppedRxDeltaAvg(int droppedRxDeltaAvg){
            this.droppedRxDeltaAvg = droppedRxDeltaAvg;
            return this;
        }

        public Builder withdroppedRxDeltaMax(int droppedRxDeltaMax){
            this.droppedRxDeltaMax = droppedRxDeltaMax;
            return this;
        }

        public Builder withdroppedRxDeltaMin(int droppedRxDeltaMin){
            this.droppedRxDeltaMin = droppedRxDeltaMin;
            return this;
        }

        public Builder withdroppedTx(int droppedTx){
            this.droppedTx = droppedTx;
            return this;
        }

        public Builder withdroppedTxDelta(int droppedTxDelta){
            this.droppedTxDelta = droppedTxDelta;
            return this;
        }

        public Builder withdroppedTxDeltaAvg(int droppedTxDeltaAvg){
            this.droppedTxDeltaAvg = droppedTxDeltaAvg;
            return this;
        }

        public Builder withdroppedTxDeltaMax(int droppedTxDeltaMax){
            this.droppedTxDeltaMax = droppedTxDeltaMax;
            return this;
        }

        public Builder withdroppedTxDeltaMin(int droppedTxDeltaMin){
            this.droppedTxDeltaMin = droppedTxDeltaMin;
            return this;
        }

        public Builder witherrorsRx(int errorsRx){
            this.errorsRx = errorsRx;
            return this;
        }

        public Builder witherrorsRxDelta(int errorsRxDelta){
            this.errorsRxDelta = errorsRxDelta;
            return this;
        }

        public Builder witherrorsRxDeltaAvg(int errorsRxDeltaAvg){
            this.errorsRxDeltaAvg = errorsRxDeltaAvg;
            return this;
        }

        public Builder witherrorsRxDeltaMax(int errorsRxDeltaMax){
            this.errorsRxDeltaMax = errorsRxDeltaMax;
            return this;
        }

        public Builder witherrorsRxDeltaMin(int errorsRxDeltaMin){
            this.errorsRxDeltaMin = errorsRxDeltaMin;
            return this;
        }

        public Builder witherrorsTx(int errorsTx){
            this.errorsTx = errorsTx;
            return this;
        }

        public Builder witherrorsTxDelta(int errorsTxDelta){
            this.errorsTxDelta = errorsTxDelta;
            return this;
        }

        public Builder witherrorsTxDeltaAvg(int errorsTxDeltaAvg){
            this.errorsTxDeltaAvg = errorsTxDeltaAvg;
            return this;
        }

        public Builder witherrorsTxDeltaMax(int errorsTxDeltaMax){
            this.errorsTxDeltaMax = errorsTxDeltaMax;
            return this;
        }

        public Builder witherrorsTxDeltaMin(int errorsTxDeltaMin){
            this.errorsTxDeltaMin = errorsTxDeltaMin;
            return this;
        }

        public Builder withpacketsRx(int packetsRx){
            this.packetsRx = packetsRx;
            return this;
        }

        public Builder withpacketsRxDelta(int packetsRxDelta){
            this.packetsRxDelta = packetsRxDelta;
            return this;
        }

        public Builder withpacketsRxDeltaAvg(int packetsRxDeltaAvg){
            this.packetsRxDeltaAvg = packetsRxDeltaAvg;
            return this;
        }

        public Builder withpacketsRxDeltaMax(int packetsRxDeltaMax){
            this.packetsRxDeltaMax = packetsRxDeltaMax;
            return this;
        }

        public Builder withpacketsRxDeltaMin(int packetsRxDeltaMin){
            this.packetsRxDeltaMin = packetsRxDeltaMin;
            return this;
        }

        public Builder withpacketsTx(int packetsTx){
            this.packetsTx = packetsTx;
            return this;
        }

        public Builder withpacketsTxDelta(int packetsTxDelta){
            this.packetsTxDelta = packetsTxDelta;
            return this;
        }

        public Builder withpacketsTxDeltaAvg(int packetsTxDeltaAvg){
            this.packetsTxDeltaAvg = packetsTxDeltaAvg;
            return this;
        }

        public Builder withpacketsTxDeltaMax(int packetsTxDeltaMax){
            this.packetsTxDeltaMax = packetsTxDeltaMax;
            return this;
        }

        public Builder withpacketsTxDeltaMin(int packetsTxDeltaMin){
            this.packetsTxDeltaMin = packetsTxDeltaMin;
            return this;
        }

        public UcsAdaptorVnicStats build() {
            return new UcsAdaptorVnicStats(this);
        }
    }
}
