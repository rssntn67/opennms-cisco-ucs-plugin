package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherTxStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long broadcastPackets;
    public final long jumboPackets;
    public final long multicastPackets;
    public final long totalBytes;
    public final long totalPackets;
    public final long unicastPackets;

    private UcsEtherTxStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherTxStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        broadcastPackets = builder.broadcastPackets;
        jumboPackets = builder.jumboPackets;
        multicastPackets = builder.multicastPackets;
        totalBytes = builder.totalBytes;
        totalPackets = builder.totalPackets;
        unicastPackets = builder.unicastPackets;
    }

    @Override
    public String toString() {
        return "UcsEtherTxStats{" +
                "broadcastPackets=" + broadcastPackets +
                ", jumboPackets=" + jumboPackets +
                ", multicastPackets=" + multicastPackets +
                ", totalBytes=" + totalBytes +
                ", totalPackets=" + totalPackets +
                ", unicastPackets=" + unicastPackets +
                ", intervals=" + intervals +
                ", suspect='" + suspect + '\'' +
                ", thresholded='" + thresholded + '\'' +
                ", timeCollected=" + timeCollected +
                ", update=" + update +
                ", dn=" + dn +
                ", classId=" + classId +
                ", classItem=" + classItem +
                '}';
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
        private long jumboPackets;
        private long multicastPackets;
        private long totalBytes;
        private long totalPackets;
        private long unicastPackets;

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

        public Builder withBroadcastPackets(long broadcastPackets){
            this.broadcastPackets = broadcastPackets;
            return this;
        }

        public Builder withJumboPackets(long jumboPackets){
            this.jumboPackets = jumboPackets;
            return this;
        }

        public Builder withMulticastPackets(long multicastPackets){
            this.multicastPackets = multicastPackets;
            return this;
        }

        public Builder withTotalBytes(long totalBytes){
            this.totalBytes = totalBytes;
            return this;
        }

        public Builder withTotalPackets(long totalPackets){
            this.totalPackets = totalPackets;
            return this;
        }

        public Builder withUnicastPackets(long unicastPackets){
            this.unicastPackets = unicastPackets;
            return this;
        }

        public UcsEtherTxStats build() {
            return new UcsEtherTxStats(this);
        }
    }
}
