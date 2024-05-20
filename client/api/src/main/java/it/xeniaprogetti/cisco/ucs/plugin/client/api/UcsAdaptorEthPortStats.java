package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsAdaptorEthPortStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long goodPackets;
    public final long goodPacketsDelta;
    public final long goodPacketsDeltaAvg;
    public final long goodPacketsDeltaMax;
    public final long goodPacketsDeltaMin;
    public final long pausePackets;
    public final long pausePacketsDelta;
    public final long pausePacketsDeltaAvg;
    public final long pausePacketsDeltaMax;
    public final long pausePacketsDeltaMin;
    public final long perPriorityPausePackets;
    public final long perPriorityPausePacketsDelta;
    public final long perPriorityPausePacketsDeltaAvg;
    public final long perPriorityPausePacketsDeltaMax;
    public final long perPriorityPausePacketsDeltaMin;
    public final long pppPackets;
    public final long pppPacketsDelta;
    public final long pppPacketsDeltaAvg;
    public final long pppPacketsDeltaMax;
    public final long pppPacketsDeltaMin;
    public final long totalPackets;
    public final long totalPacketsDelta;
    public final long totalPacketsDeltaAvg;
    public final long totalPacketsDeltaMax;
    public final long totalPacketsDeltaMin;
    public final String trafficDirection;
    public final long vlanPackets;
    public final long vlanPacketsDelta;
    public final long vlanPacketsDeltaAvg;
    public final long vlanPacketsDeltaMax;
    public final long vlanPacketsDeltaMin;

    private UcsAdaptorEthPortStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.adaptorEthPortStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        goodPackets = builder.goodPackets;
        goodPacketsDelta = builder.goodPacketsDelta;
        goodPacketsDeltaAvg = builder.goodPacketsDeltaAvg;
        goodPacketsDeltaMax = builder.goodPacketsDeltaMax;
        goodPacketsDeltaMin = builder.goodPacketsDeltaMin;
        pausePackets = builder.pausePackets;
        pausePacketsDelta = builder.pausePacketsDelta;
        pausePacketsDeltaAvg = builder.pausePacketsDeltaAvg;
        pausePacketsDeltaMax = builder.pausePacketsDeltaMax;
        pausePacketsDeltaMin = builder.pausePacketsDeltaMin;
        perPriorityPausePackets = builder.perPriorityPausePackets;
        perPriorityPausePacketsDelta = builder.perPriorityPausePacketsDelta;
        perPriorityPausePacketsDeltaAvg = builder.perPriorityPausePacketsDeltaAvg;
        perPriorityPausePacketsDeltaMax = builder.perPriorityPausePacketsDeltaMax;
        perPriorityPausePacketsDeltaMin = builder.perPriorityPausePacketsDeltaMin;
        pppPackets = builder.pppPackets;
        pppPacketsDelta = builder.pppPacketsDelta;
        pppPacketsDeltaAvg = builder.pppPacketsDeltaAvg;
        pppPacketsDeltaMax = builder.pppPacketsDeltaMax;
        pppPacketsDeltaMin = builder.pppPacketsDeltaMin;
        totalPackets = builder.totalPackets;
        totalPacketsDelta = builder.totalPacketsDelta;
        totalPacketsDeltaAvg = builder.totalPacketsDeltaAvg;
        totalPacketsDeltaMax = builder.totalPacketsDeltaMax;
        totalPacketsDeltaMin = builder.totalPacketsDeltaMin;
        trafficDirection = builder.trafficDirection;
        vlanPackets = builder.vlanPackets;
        vlanPacketsDelta = builder.vlanPacketsDelta;
        vlanPacketsDeltaAvg = builder.vlanPacketsDeltaAvg;
        vlanPacketsDeltaMax = builder.vlanPacketsDeltaMax;
        vlanPacketsDeltaMin = builder.vlanPacketsDeltaMin;
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

        private long goodPackets;
        private long goodPacketsDelta;
        private long goodPacketsDeltaAvg;
        private long goodPacketsDeltaMax;
        private long goodPacketsDeltaMin;
        private long pausePackets;
        private long pausePacketsDelta;
        private long pausePacketsDeltaAvg;
        private long pausePacketsDeltaMax;
        private long pausePacketsDeltaMin;
        private long perPriorityPausePackets;
        private long perPriorityPausePacketsDelta;
        private long perPriorityPausePacketsDeltaAvg;
        private long perPriorityPausePacketsDeltaMax;
        private long perPriorityPausePacketsDeltaMin;
        private long pppPackets;
        private long pppPacketsDelta;
        private long pppPacketsDeltaAvg;
        private long pppPacketsDeltaMax;
        private long pppPacketsDeltaMin;
        private long totalPackets;
        private long totalPacketsDelta;
        private long totalPacketsDeltaAvg;
        private long totalPacketsDeltaMax;
        private long totalPacketsDeltaMin;
        private String trafficDirection;
        private long vlanPackets;
        private long vlanPacketsDelta;
        private long vlanPacketsDeltaAvg;
        private long vlanPacketsDeltaMax;
        private long vlanPacketsDeltaMin;

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

        public Builder withgoodPackets(long goodPackets){
            this.goodPackets = goodPackets;
            return this;
        }

        public Builder withgoodPacketsDelta(long goodPacketsDelta){
            this.goodPacketsDelta = goodPacketsDelta;
            return this;
        }

        public Builder withgoodPacketsDeltaAvg(long goodPacketsDeltaAvg){
            this.goodPacketsDeltaAvg = goodPacketsDeltaAvg;
            return this;
        }

        public Builder withgoodPacketsDeltaMax(long goodPacketsDeltaMax){
            this.goodPacketsDeltaMax = goodPacketsDeltaMax;
            return this;
        }

        public Builder withgoodPacketsDeltaMin(long goodPacketsDeltaMin){
            this.goodPacketsDeltaMin = goodPacketsDeltaMin;
            return this;
        }

        public Builder withpausePackets(long pausePackets){
            this.pausePackets = pausePackets;
            return this;
        }

        public Builder withpausePacketsDelta(long pausePacketsDelta){
            this.pausePacketsDelta = pausePacketsDelta;
            return this;
        }

        public Builder withpausePacketsDeltaAvg(long pausePacketsDeltaAvg){
            this.pausePacketsDeltaAvg = pausePacketsDeltaAvg;
            return this;
        }

        public Builder withpausePacketsDeltaMax(long pausePacketsDeltaMax){
            this.pausePacketsDeltaMax = pausePacketsDeltaMax;
            return this;
        }

        public Builder withpausePacketsDeltaMin(long pausePacketsDeltaMin){
            this.pausePacketsDeltaMin = pausePacketsDeltaMin;
            return this;
        }

        public Builder withperPriorityPausePackets(long perPriorityPausePackets){
            this.perPriorityPausePackets = perPriorityPausePackets;
            return this;
        }

        public Builder withperPriorityPausePacketsDelta(long perPriorityPausePacketsDelta){
            this.perPriorityPausePacketsDelta = perPriorityPausePacketsDelta;
            return this;
        }

        public Builder withperPriorityPausePacketsDeltaAvg(long perPriorityPausePacketsDeltaAvg){
            this.perPriorityPausePacketsDeltaAvg = perPriorityPausePacketsDeltaAvg;
            return this;
        }

        public Builder withperPriorityPausePacketsDeltaMax(long perPriorityPausePacketsDeltaMax){
            this.perPriorityPausePacketsDeltaMax = perPriorityPausePacketsDeltaMax;
            return this;
        }

        public Builder withperPriorityPausePacketsDeltaMin(long perPriorityPausePacketsDeltaMin){
            this.perPriorityPausePacketsDeltaMin = perPriorityPausePacketsDeltaMin;
            return this;
        }

        public Builder withpppPackets(long pppPackets){
            this.pppPackets = pppPackets;
            return this;
        }

        public Builder withpppPacketsDelta(long pppPacketsDelta){
            this.pppPacketsDelta = pppPacketsDelta;
            return this;
        }

        public Builder withpppPacketsDeltaAvg(long pppPacketsDeltaAvg){
            this.pppPacketsDeltaAvg = pppPacketsDeltaAvg;
            return this;
        }

        public Builder withpppPacketsDeltaMax(long pppPacketsDeltaMax){
            this.pppPacketsDeltaMax = pppPacketsDeltaMax;
            return this;
        }

        public Builder withpppPacketsDeltaMin(long pppPacketsDeltaMin){
            this.pppPacketsDeltaMin = pppPacketsDeltaMin;
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

        public Builder withtrafficDirection(String trafficDirection){
            this.trafficDirection = trafficDirection;
            return this;
        }

        public Builder withvlanPackets(long vlanPackets){
            this.vlanPackets = vlanPackets;
            return this;
        }

        public Builder withvlanPacketsDelta(long vlanPacketsDelta){
            this.vlanPacketsDelta = vlanPacketsDelta;
            return this;
        }

        public Builder withvlanPacketsDeltaAvg(long vlanPacketsDeltaAvg){
            this.vlanPacketsDeltaAvg = vlanPacketsDeltaAvg;
            return this;
        }

        public Builder withvlanPacketsDeltaMax(long vlanPacketsDeltaMax){
            this.vlanPacketsDeltaMax = vlanPacketsDeltaMax;
            return this;
        }

        public Builder withvlanPacketsDeltaMin(long vlanPacketsDeltaMin){
            this.vlanPacketsDeltaMin = vlanPacketsDeltaMin;
            return this;
        }

        public UcsAdaptorEthPortStats build() {
            return new UcsAdaptorEthPortStats(this);
        }
    }
}
