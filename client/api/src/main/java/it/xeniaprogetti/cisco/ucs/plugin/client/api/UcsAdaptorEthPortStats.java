package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsAdaptorEthPortStats extends UcsAdaptorEthPortResourceTypeStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long goodPackets;
    public final long pausePackets;
    public final long perPriorityPausePackets;
    public final long pppPackets;
    public final long totalPackets;
    public final String trafficDirection;
    public final long vlanPackets;

    private UcsAdaptorEthPortStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.adaptorEthPortStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        goodPackets = builder.goodPackets;
        pausePackets = builder.pausePackets;
        perPriorityPausePackets = builder.perPriorityPausePackets;
        pppPackets = builder.pppPackets;
        totalPackets = builder.totalPackets;
        trafficDirection = builder.trafficDirection;
        vlanPackets = builder.vlanPackets;
    }

    @Override
    public String toString() {
        return "UcsAdaptorEthPortStats{" +
                "goodPackets=" + goodPackets +
                ", pausePackets=" + pausePackets +
                ", perPriorityPausePackets=" + perPriorityPausePackets +
                ", pppPackets=" + pppPackets +
                ", totalPackets=" + totalPackets +
                ", trafficDirection='" + trafficDirection + '\'' +
                ", vlanPackets=" + vlanPackets +
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

        private long goodPackets;
        private long pausePackets;
        private long perPriorityPausePackets;
        private long pppPackets;
        private long totalPackets;
        private String trafficDirection;
        private long vlanPackets;

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

        public Builder withGoodPackets(long goodPackets){
            this.goodPackets = goodPackets;
            return this;
        }

        public Builder withPausePackets(long pausePackets){
            this.pausePackets = pausePackets;
            return this;
        }

        public Builder withPerPriorityPausePackets(long perPriorityPausePackets){
            this.perPriorityPausePackets = perPriorityPausePackets;
            return this;
        }

        public Builder withPppPackets(long pppPackets){
            this.pppPackets = pppPackets;
            return this;
        }

        public Builder withTotalPackets(long totalPackets){
            this.totalPackets = totalPackets;
            return this;
        }

        public Builder withTrafficDirection(String trafficDirection){
            this.trafficDirection = trafficDirection;
            return this;
        }

        public Builder withVlanPackets(long vlanPackets){
            this.vlanPackets = vlanPackets;
            return this;
        }

        public UcsAdaptorEthPortStats build() {
            return new UcsAdaptorEthPortStats(this);
        }
    }
}
