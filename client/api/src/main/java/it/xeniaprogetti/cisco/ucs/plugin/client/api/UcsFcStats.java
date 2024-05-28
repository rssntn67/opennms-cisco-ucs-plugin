package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsFcStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long bytesRx;
    public final long bytesTx;
    public final int packetsRx;
    public final int packetsTx;
    public final int bytesRxDelta;
    public final int bytesRxDeltaAvg;
    public final int bytesRxDeltaMax;
    public final int bytesRxDeltaMin;
    public final int bytesTxDelta;
    public final int bytesTxDeltaAvg;
    public final int bytesTxDeltaMax;
    public final int bytesTxDeltaMin;
    public final int packetsRxDelta;
    public final int packetsRxDeltaAvg;
    public final int packetsRxDeltaMax;
    public final int packetsRxDeltaMin;
    public final int packetsTxDelta;
    public final int packetsTxDeltaAvg;
    public final int packetsTxDeltaMax;
    public final int packetsTxDeltaMin;

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
        private int bytesRxDelta;
        private int bytesRxDeltaAvg;
        private int bytesRxDeltaMax;
        private int bytesRxDeltaMin;
        private long bytesTx;
        private int bytesTxDelta;
        private int bytesTxDeltaAvg;
        private int bytesTxDeltaMax;
        private int bytesTxDeltaMin;
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

        public Builder withBytesRx(long bytesRx){
            this.bytesRx = bytesRx;
            return this;
        }

        public Builder withBytesTx(long bytesTx){
            this.bytesTx = bytesTx;
            return this;
        }

        public Builder withBytesRxDelta(int bytesRxDelta){
            this.bytesRxDelta = bytesRxDelta;
            return this;
        }

        public Builder withBytesRxDeltaAvg(int bytesRxDeltaAvg){
            this.bytesRxDeltaAvg = bytesRxDeltaAvg;
            return this;
        }

        public Builder withBytesRxDeltaMax(int bytesRxDeltaMax){
            this.bytesRxDeltaMax = bytesRxDeltaMax;
            return this;
        }

        public Builder withBytesRxDeltaMin(int bytesRxDeltaMin){
            this.bytesRxDeltaMin = bytesRxDeltaMin;
            return this;
        }
        
        public Builder withBytesTxDelta(int bytesTxDelta){
            this.bytesTxDelta = bytesTxDelta;
            return this;
        }

        public Builder withBytesTxDeltaAvg(int bytesTxDeltaAvg){
            this.bytesTxDeltaAvg = bytesTxDeltaAvg;
            return this;
        }

        public Builder withBytesTxDeltaMax(int bytesTxDeltaMax){
            this.bytesTxDeltaMax = bytesTxDeltaMax;
            return this;
        }

        public Builder withBytesTxDeltaMin(int bytesTxDeltaMin){
            this.bytesTxDeltaMin = bytesTxDeltaMin;
            return this;
        }

        public Builder withPacketsRx(int packetsRx){
            this.packetsRx = packetsRx;
            return this;
        }

        public Builder withPacketsRxDelta(int packetsRxDelta){
            this.packetsRxDelta = packetsRxDelta;
            return this;
        }

        public Builder withPacketsRxDeltaAvg(int packetsRxDeltaAvg){
            this.packetsRxDeltaAvg = packetsRxDeltaAvg;
            return this;
        }

        public Builder withPacketsRxDeltaMax(int packetsRxDeltaMax){
            this.packetsRxDeltaMax = packetsRxDeltaMax;
            return this;
        }

        public Builder withPacketsRxDeltaMin(int packetsRxDeltaMin){
            this.packetsRxDeltaMin = packetsRxDeltaMin;
            return this;
        }

        public Builder withPacketsTx(int packetsTx){
            this.packetsTx = packetsTx;
            return this;
        }

        public Builder withPacketsTxDelta(int packetsTxDelta){
            this.packetsTxDelta = packetsTxDelta;
            return this;
        }

        public Builder withPacketsTxDeltaAvg(int packetsTxDeltaAvg){
            this.packetsTxDeltaAvg = packetsTxDeltaAvg;
            return this;
        }

        public Builder withPacketsTxDeltaMax(int packetsTxDeltaMax){
            this.packetsTxDeltaMax = packetsTxDeltaMax;
            return this;
        }

        public Builder withPacketsTxDeltaMin(int packetsTxDeltaMin){
            this.packetsTxDeltaMin = packetsTxDeltaMin;
            return this;
        }

        public UcsFcStats build() {
            return new UcsFcStats(this);
        }
    }
}
