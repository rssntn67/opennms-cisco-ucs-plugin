package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsSwSystemStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double load;
    public final int memAvailable;
    public final int memCached;

    private UcsSwSystemStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.swSystemStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        load = builder.load;
        memAvailable = builder.memAvailable;
        memCached = builder.memCached;
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

        private double load;
        private int memAvailable;
        private int memCached;

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

        public Builder withLoad(double load){
            this.load = load;
            return this;
        }

        public Builder withMemAvailable(int memAvailable){
            this.memAvailable = memAvailable;
            return this;
        }

        public Builder withMemCached(int memCached){
            this.memCached = memCached;
            return this;
        }

        public UcsSwSystemStats build() {
            return new UcsSwSystemStats(this);
        }
    }
}
