package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsAdaptorEthPortErrStats extends UcsAdaptorEthPortResourceTypeStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int badCrcPackets;
    public final int badLengthPackets;
    public final int macDiscardedPackets;
    public final String trafficDirection;

    private UcsAdaptorEthPortErrStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.adaptorEthPortErrStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        badCrcPackets = builder.badCrcPackets;
        badLengthPackets = builder.badLengthPackets;
        macDiscardedPackets = builder.macDiscardedPackets;
        trafficDirection = builder.trafficDirection;
    }

    @Override
    public String toString() {
        return "UcsAdaptorEthPortErrStats{" +
                "badCrcPackets=" + badCrcPackets +
                ", badLengthPackets=" + badLengthPackets +
                ", macDiscardedPackets=" + macDiscardedPackets +
                ", trafficDirection='" + trafficDirection + '\'' +
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

        private int badCrcPackets;
        private int badLengthPackets;
        private int macDiscardedPackets;
        private String trafficDirection;

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

        public Builder withBadCrcPackets(int badCrcPackets){
            this.badCrcPackets = badCrcPackets;
            return this;
        }

        public Builder withBadLengthPackets(int badLengthPackets){
            this.badLengthPackets = badLengthPackets;
            return this;
        }

        public Builder withMacDiscardedPackets(int macDiscardedPackets){
            this.macDiscardedPackets = macDiscardedPackets;
            return this;
        }

        public Builder withTrafficDirection(String trafficDirection){
            this.trafficDirection = trafficDirection;
            return this;
        }

        public UcsAdaptorEthPortErrStats build() {
            return new UcsAdaptorEthPortErrStats(this);
        }
    }
}
