package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsAdaptorEthPortMcastStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long broadcastPackets;
    public final long multicastPackets;
    public final String trafficDirection;
    public final long unicastPackets;

    private UcsAdaptorEthPortMcastStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.adaptorEthPortMcastStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        broadcastPackets = builder.broadcastPackets;
        multicastPackets = builder.multicastPackets;
        trafficDirection = builder.trafficDirection;
        unicastPackets = builder.unicastPackets;
    }

    @Override
    public String toString() {
        return "UcsAdaptorEthPortMcastStats{" +
                "broadcastPackets=" + broadcastPackets +
                ", multicastPackets=" + multicastPackets +
                ", trafficDirection='" + trafficDirection + '\'' +
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
        private long multicastPackets;
        private String trafficDirection;
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

        public Builder withMulticastPackets(long multicastPackets){
            this.multicastPackets = multicastPackets;
            return this;
        }

        public Builder withTrafficDirection(String trafficDirection){
            this.trafficDirection = trafficDirection;
            return this;
        }

        public Builder withUnicastPackets(long unicastPackets){
            this.unicastPackets = unicastPackets;
            return this;
        }

        public UcsAdaptorEthPortMcastStats build() {
            return new UcsAdaptorEthPortMcastStats(this);
        }
    }
}
