package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsStorageDiskEnvStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double temperature;
    public final int wearPercentage;

    private UcsStorageDiskEnvStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.storageDiskEnvStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        temperature = builder.temperature;
        wearPercentage = builder.wearPercentage;
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

        private double temperature;
        private int wearPercentage;

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

        public Builder withTemperature(double temperature){
            this.temperature = temperature;
            return this;
        }

        public Builder withWearPercentage(int wearPercentage){
            this.wearPercentage = wearPercentage;
            return this;
        }

        public UcsStorageDiskEnvStats build() {
            return new UcsStorageDiskEnvStats(this);
        }
    }
}
