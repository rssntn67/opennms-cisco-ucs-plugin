package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherTxStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long broadcastPackets;
    public final long broadcastPacketsDelta;
    public final long broadcastPacketsDeltaAvg;
    public final long broadcastPacketsDeltaMax;
    public final long broadcastPacketsDeltaMin;
    public final long jumboPackets;
    public final long jumboPacketsDelta;
    public final long jumboPacketsDeltaAvg;
    public final long jumboPacketsDeltaMax;
    public final long jumboPacketsDeltaMin;
    public final long multicastPackets;
    public final long multicastPacketsDelta;
    public final long multicastPacketsDeltaAvg;
    public final long multicastPacketsDeltaMax;
    public final long multicastPacketsDeltaMin;
    public final long totalBytes;
    public final long totalBytesDelta;
    public final long totalBytesDeltaAvg;
    public final long totalBytesDeltaMax;
    public final long totalBytesDeltaMin;
    public final long totalPackets;
    public final long totalPacketsDelta;
    public final long totalPacketsDeltaAvg;
    public final long totalPacketsDeltaMax;
    public final long totalPacketsDeltaMin;
    public final long unicastPackets;
    public final long unicastPacketsDelta;
    public final long unicastPacketsDeltaAvg;
    public final long unicastPacketsDeltaMax;
    public final long unicastPacketsDeltaMin;

    private UcsEtherTxStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherTxStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        broadcastPackets = builder.broadcastPackets;
        broadcastPacketsDelta = builder.broadcastPacketsDelta;
        broadcastPacketsDeltaAvg = builder.broadcastPacketsDeltaAvg;
        broadcastPacketsDeltaMax = builder.broadcastPacketsDeltaMax;
        broadcastPacketsDeltaMin = builder.broadcastPacketsDeltaMin;
        jumboPackets = builder.jumboPackets;
        jumboPacketsDelta = builder.jumboPacketsDelta;
        jumboPacketsDeltaAvg = builder.jumboPacketsDeltaAvg;
        jumboPacketsDeltaMax = builder.jumboPacketsDeltaMax;
        jumboPacketsDeltaMin = builder.jumboPacketsDeltaMin;
        multicastPackets = builder.multicastPackets;
        multicastPacketsDelta = builder.multicastPacketsDelta;
        multicastPacketsDeltaAvg = builder.multicastPacketsDeltaAvg;
        multicastPacketsDeltaMax = builder.multicastPacketsDeltaMax;
        multicastPacketsDeltaMin = builder.multicastPacketsDeltaMin;
        totalBytes = builder.totalBytes;
        totalBytesDelta = builder.totalBytesDelta;
        totalBytesDeltaAvg = builder.totalBytesDeltaAvg;
        totalBytesDeltaMax = builder.totalBytesDeltaMax;
        totalBytesDeltaMin = builder.totalBytesDeltaMin;
        totalPackets = builder.totalPackets;
        totalPacketsDelta = builder.totalPacketsDelta;
        totalPacketsDeltaAvg = builder.totalPacketsDeltaAvg;
        totalPacketsDeltaMax = builder.totalPacketsDeltaMax;
        totalPacketsDeltaMin = builder.totalPacketsDeltaMin;
        unicastPackets = builder.unicastPackets;
        unicastPacketsDelta = builder.unicastPacketsDelta;
        unicastPacketsDeltaAvg = builder.unicastPacketsDeltaAvg;
        unicastPacketsDeltaMax = builder.unicastPacketsDeltaMax;
        unicastPacketsDeltaMin = builder.unicastPacketsDeltaMin;
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

        private long broadcastPackets;
        private long broadcastPacketsDelta;
        private long broadcastPacketsDeltaAvg;
        private long broadcastPacketsDeltaMax;
        private long broadcastPacketsDeltaMin;
        private long jumboPackets;
        private long jumboPacketsDelta;
        private long jumboPacketsDeltaAvg;
        private long jumboPacketsDeltaMax;
        private long jumboPacketsDeltaMin;
        private long multicastPackets;
        private long multicastPacketsDelta;
        private long multicastPacketsDeltaAvg;
        private long multicastPacketsDeltaMax;
        private long multicastPacketsDeltaMin;
        private long totalBytes;
        private long totalBytesDelta;
        private long totalBytesDeltaAvg;
        private long totalBytesDeltaMax;
        private long totalBytesDeltaMin;
        private long totalPackets;
        private long totalPacketsDelta;
        private long totalPacketsDeltaAvg;
        private long totalPacketsDeltaMax;
        private long totalPacketsDeltaMin;
        private long unicastPackets;
        private long unicastPacketsDelta;
        private long unicastPacketsDeltaAvg;
        private long unicastPacketsDeltaMax;
        private long unicastPacketsDeltaMin;

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

        public Builder withbroadcastPackets(long broadcastPackets){
            this.broadcastPackets = broadcastPackets;
            return this;
        }

        public Builder withbroadcastPacketsDelta(long broadcastPacketsDelta){
            this.broadcastPacketsDelta = broadcastPacketsDelta;
            return this;
        }

        public Builder withbroadcastPacketsDeltaAvg(long broadcastPacketsDeltaAvg){
            this.broadcastPacketsDeltaAvg = broadcastPacketsDeltaAvg;
            return this;
        }

        public Builder withbroadcastPacketsDeltaMax(long broadcastPacketsDeltaMax){
            this.broadcastPacketsDeltaMax = broadcastPacketsDeltaMax;
            return this;
        }

        public Builder withbroadcastPacketsDeltaMin(long broadcastPacketsDeltaMin){
            this.broadcastPacketsDeltaMin = broadcastPacketsDeltaMin;
            return this;
        }

        public Builder withjumboPackets(long jumboPackets){
            this.jumboPackets = jumboPackets;
            return this;
        }

        public Builder withjumboPacketsDelta(long jumboPacketsDelta){
            this.jumboPacketsDelta = jumboPacketsDelta;
            return this;
        }

        public Builder withjumboPacketsDeltaAvg(long jumboPacketsDeltaAvg){
            this.jumboPacketsDeltaAvg = jumboPacketsDeltaAvg;
            return this;
        }

        public Builder withjumboPacketsDeltaMax(long jumboPacketsDeltaMax){
            this.jumboPacketsDeltaMax = jumboPacketsDeltaMax;
            return this;
        }

        public Builder withjumboPacketsDeltaMin(long jumboPacketsDeltaMin){
            this.jumboPacketsDeltaMin = jumboPacketsDeltaMin;
            return this;
        }

        public Builder withmulticastPackets(long multicastPackets){
            this.multicastPackets = multicastPackets;
            return this;
        }

        public Builder withmulticastPacketsDelta(long multicastPacketsDelta){
            this.multicastPacketsDelta = multicastPacketsDelta;
            return this;
        }

        public Builder withmulticastPacketsDeltaAvg(long multicastPacketsDeltaAvg){
            this.multicastPacketsDeltaAvg = multicastPacketsDeltaAvg;
            return this;
        }

        public Builder withmulticastPacketsDeltaMax(long multicastPacketsDeltaMax){
            this.multicastPacketsDeltaMax = multicastPacketsDeltaMax;
            return this;
        }

        public Builder withmulticastPacketsDeltaMin(long multicastPacketsDeltaMin){
            this.multicastPacketsDeltaMin = multicastPacketsDeltaMin;
            return this;
        }

        public Builder withtotalBytes(long totalBytes){
            this.totalBytes = totalBytes;
            return this;
        }

        public Builder withtotalBytesDelta(long totalBytesDelta){
            this.totalBytesDelta = totalBytesDelta;
            return this;
        }

        public Builder withtotalBytesDeltaAvg(long totalBytesDeltaAvg){
            this.totalBytesDeltaAvg = totalBytesDeltaAvg;
            return this;
        }

        public Builder withtotalBytesDeltaMax(long totalBytesDeltaMax){
            this.totalBytesDeltaMax = totalBytesDeltaMax;
            return this;
        }

        public Builder withtotalBytesDeltaMin(long totalBytesDeltaMin){
            this.totalBytesDeltaMin = totalBytesDeltaMin;
            return this;
        }

        public Builder withtotalPackets(long totalPackets){
            this.totalPackets = totalPackets;
            return this;
        }

        public Builder withtotalPacketsDelta(long totalPacketsDelta){
            this.totalPacketsDelta = totalPacketsDelta;
            return this;
        }

        public Builder withtotalPacketsDeltaAvg(long totalPacketsDeltaAvg){
            this.totalPacketsDeltaAvg = totalPacketsDeltaAvg;
            return this;
        }

        public Builder withtotalPacketsDeltaMax(long totalPacketsDeltaMax){
            this.totalPacketsDeltaMax = totalPacketsDeltaMax;
            return this;
        }

        public Builder withtotalPacketsDeltaMin(long totalPacketsDeltaMin){
            this.totalPacketsDeltaMin = totalPacketsDeltaMin;
            return this;
        }

        public Builder withunicastPackets(long unicastPackets){
            this.unicastPackets = unicastPackets;
            return this;
        }

        public Builder withunicastPacketsDelta(long unicastPacketsDelta){
            this.unicastPacketsDelta = unicastPacketsDelta;
            return this;
        }

        public Builder withunicastPacketsDeltaAvg(long unicastPacketsDeltaAvg){
            this.unicastPacketsDeltaAvg = unicastPacketsDeltaAvg;
            return this;
        }

        public Builder withunicastPacketsDeltaMax(long unicastPacketsDeltaMax){
            this.unicastPacketsDeltaMax = unicastPacketsDeltaMax;
            return this;
        }

        public Builder withunicastPacketsDeltaMin(long unicastPacketsDeltaMin){
            this.unicastPacketsDeltaMin = unicastPacketsDeltaMin;
            return this;
        }

        public UcsEtherTxStats build() {
            return new UcsEtherTxStats(this);
        }
    }
}
