package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsMemoryUnitEnvStats extends UcsMemoryResourceTypeStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double temperature;

    private UcsMemoryUnitEnvStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.memoryUnitEnvStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        temperature = builder.temperature;
    }

    @Override
    public String toString() {
        return "UcsMemoryUnitEnvStats{" +
                "temperature=" + temperature +
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

        private double temperature;

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

        public UcsMemoryUnitEnvStats build() {
            return new UcsMemoryUnitEnvStats(this);
        }
    }
}
