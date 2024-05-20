package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsFcStats extends UcsStats {

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
    public final long packetsRx;
    public final long packetsRxDelta;
    public final long packetsRxDeltaAvg;
    public final long packetsRxDeltaMax;
    public final long packetsRxDeltaMin;
    public final long packetsTx;
    public final long packetsTxDelta;
    public final long packetsTxDeltaAvg;
    public final long packetsTxDeltaMax;
    public final long packetsTxDeltaMin;

    private UcsFcStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.fcStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
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
        private long packetsRx;
        private long packetsRxDelta;
        private long packetsRxDeltaAvg;
        private long packetsRxDeltaMax;
        private long packetsRxDeltaMin;
        private long packetsTx;
        private long packetsTxDelta;
        private long packetsTxDeltaAvg;
        private long packetsTxDeltaMax;
        private long packetsTxDeltaMin;

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

        public Builder withpacketsRx(long packetsRx){
            this.packetsRx = packetsRx;
            return this;
        }

        public Builder withpacketsRxDelta(long packetsRxDelta){
            this.packetsRxDelta = packetsRxDelta;
            return this;
        }

        public Builder withpacketsRxDeltaAvg(long packetsRxDeltaAvg){
            this.packetsRxDeltaAvg = packetsRxDeltaAvg;
            return this;
        }

        public Builder withpacketsRxDeltaMax(long packetsRxDeltaMax){
            this.packetsRxDeltaMax = packetsRxDeltaMax;
            return this;
        }

        public Builder withpacketsRxDeltaMin(long packetsRxDeltaMin){
            this.packetsRxDeltaMin = packetsRxDeltaMin;
            return this;
        }

        public Builder withpacketsTx(long packetsTx){
            this.packetsTx = packetsTx;
            return this;
        }

        public Builder withpacketsTxDelta(long packetsTxDelta){
            this.packetsTxDelta = packetsTxDelta;
            return this;
        }

        public Builder withpacketsTxDeltaAvg(long packetsTxDeltaAvg){
            this.packetsTxDeltaAvg = packetsTxDeltaAvg;
            return this;
        }

        public Builder withpacketsTxDeltaMax(long packetsTxDeltaMax){
            this.packetsTxDeltaMax = packetsTxDeltaMax;
            return this;
        }

        public Builder withpacketsTxDeltaMin(long packetsTxDeltaMin){
            this.packetsTxDeltaMin = packetsTxDeltaMin;
            return this;
        }

        public UcsFcStats build() {
            return new UcsFcStats(this);
        }
    }
}
