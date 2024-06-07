package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsSwEnvStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double mainBoardOutlet1;
    public final double mainBoardOutlet2;

    private UcsSwEnvStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.swEnvStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        mainBoardOutlet1 = builder.mainBoardOutlet1;
        mainBoardOutlet2 = builder.mainBoardOutlet2;
    }

    @Override
    public String toString() {
        return "UcsSwEnvStats{" +
                "mainBoardOutlet1=" + mainBoardOutlet1 +
                ", mainBoardOutlet2=" + mainBoardOutlet2 +
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

        private double mainBoardOutlet1;
        private double mainBoardOutlet2;

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

        public Builder withMainBoardOutlet1(double mainBoardOutlet1){
            this.mainBoardOutlet1 = mainBoardOutlet1;
            return this;
        }

        public Builder withMainBoardOutlet2(double mainBoardOutlet2){
            this.mainBoardOutlet2 = mainBoardOutlet2;
            return this;
        }

        public UcsSwEnvStats build() {
            return new UcsSwEnvStats(this);
        }
    }
}
