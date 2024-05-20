package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsAdaptorEthPortErrStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int badCrcPackets;
    public final int badCrcPacketsDelta;
    public final int badCrcPacketsDeltaAvg;
    public final int badCrcPacketsDeltaMax;
    public final int badCrcPacketsDeltaMin;
    public final int badLengthPackets;
    public final int badLengthPacketsDelta;
    public final int badLengthPacketsDeltaAvg;
    public final int badLengthPacketsDeltaMax;
    public final int badLengthPacketsDeltaMin;
    public final int macDiscardedPackets;
    public final int macDiscardedPacketsDelta;
    public final int macDiscardedPacketsDeltaAvg;
    public final int macDiscardedPacketsDeltaMax;
    public final int macDiscardedPacketsDeltaMin;
    public final String trafficDirection;

    private UcsAdaptorEthPortErrStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.adaptorEthPortErrStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        badCrcPackets = builder.badCrcPackets;
        badCrcPacketsDelta = builder.badCrcPacketsDelta;
        badCrcPacketsDeltaAvg = builder.badCrcPacketsDeltaAvg;
        badCrcPacketsDeltaMax = builder.badCrcPacketsDeltaMax;
        badCrcPacketsDeltaMin = builder.badCrcPacketsDeltaMin;
        badLengthPackets = builder.badLengthPackets;
        badLengthPacketsDelta = builder.badLengthPacketsDelta;
        badLengthPacketsDeltaAvg = builder.badLengthPacketsDeltaAvg;
        badLengthPacketsDeltaMax = builder.badLengthPacketsDeltaMax;
        badLengthPacketsDeltaMin = builder.badLengthPacketsDeltaMin;
        macDiscardedPackets = builder.macDiscardedPackets;
        macDiscardedPacketsDelta = builder.macDiscardedPacketsDelta;
        macDiscardedPacketsDeltaAvg = builder.macDiscardedPacketsDeltaAvg;
        macDiscardedPacketsDeltaMax = builder.macDiscardedPacketsDeltaMax;
        macDiscardedPacketsDeltaMin = builder.macDiscardedPacketsDeltaMin;
        trafficDirection = builder.trafficDirection;
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
        private int badCrcPacketsDelta;
        private int badCrcPacketsDeltaAvg;
        private int badCrcPacketsDeltaMax;
        private int badCrcPacketsDeltaMin;
        private int badLengthPackets;
        private int badLengthPacketsDelta;
        private int badLengthPacketsDeltaAvg;
        private int badLengthPacketsDeltaMax;
        private int badLengthPacketsDeltaMin;
        private int macDiscardedPackets;
        private int macDiscardedPacketsDelta;
        private int macDiscardedPacketsDeltaAvg;
        private int macDiscardedPacketsDeltaMax;
        private int macDiscardedPacketsDeltaMin;
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

        public Builder withbadCrcPackets(int badCrcPackets){
            this.badCrcPackets = badCrcPackets;
            return this;
        }

        public Builder withbadCrcPacketsDelta(int badCrcPacketsDelta){
            this.badCrcPacketsDelta = badCrcPacketsDelta;
            return this;
        }

        public Builder withbadCrcPacketsDeltaAvg(int badCrcPacketsDeltaAvg){
            this.badCrcPacketsDeltaAvg = badCrcPacketsDeltaAvg;
            return this;
        }

        public Builder withbadCrcPacketsDeltaMax(int badCrcPacketsDeltaMax){
            this.badCrcPacketsDeltaMax = badCrcPacketsDeltaMax;
            return this;
        }

        public Builder withbadCrcPacketsDeltaMin(int badCrcPacketsDeltaMin){
            this.badCrcPacketsDeltaMin = badCrcPacketsDeltaMin;
            return this;
        }

        public Builder withbadLengthPackets(int badLengthPackets){
            this.badLengthPackets = badLengthPackets;
            return this;
        }

        public Builder withbadLengthPacketsDelta(int badLengthPacketsDelta){
            this.badLengthPacketsDelta = badLengthPacketsDelta;
            return this;
        }

        public Builder withbadLengthPacketsDeltaAvg(int badLengthPacketsDeltaAvg){
            this.badLengthPacketsDeltaAvg = badLengthPacketsDeltaAvg;
            return this;
        }

        public Builder withbadLengthPacketsDeltaMax(int badLengthPacketsDeltaMax){
            this.badLengthPacketsDeltaMax = badLengthPacketsDeltaMax;
            return this;
        }

        public Builder withbadLengthPacketsDeltaMin(int badLengthPacketsDeltaMin){
            this.badLengthPacketsDeltaMin = badLengthPacketsDeltaMin;
            return this;
        }

        public Builder withmacDiscardedPackets(int macDiscardedPackets){
            this.macDiscardedPackets = macDiscardedPackets;
            return this;
        }

        public Builder withmacDiscardedPacketsDelta(int macDiscardedPacketsDelta){
            this.macDiscardedPacketsDelta = macDiscardedPacketsDelta;
            return this;
        }

        public Builder withmacDiscardedPacketsDeltaAvg(int macDiscardedPacketsDeltaAvg){
            this.macDiscardedPacketsDeltaAvg = macDiscardedPacketsDeltaAvg;
            return this;
        }

        public Builder withmacDiscardedPacketsDeltaMax(int macDiscardedPacketsDeltaMax){
            this.macDiscardedPacketsDeltaMax = macDiscardedPacketsDeltaMax;
            return this;
        }

        public Builder withmacDiscardedPacketsDeltaMin(int macDiscardedPacketsDeltaMin){
            this.macDiscardedPacketsDeltaMin = macDiscardedPacketsDeltaMin;
            return this;
        }

        public Builder withtrafficDirection(String trafficDirection){
            this.trafficDirection = trafficDirection;
            return this;
        }

        public UcsAdaptorEthPortErrStats build() {
            return new UcsAdaptorEthPortErrStats(this);
        }
    }
}
