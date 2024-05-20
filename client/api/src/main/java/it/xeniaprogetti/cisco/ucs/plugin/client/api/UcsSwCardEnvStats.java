package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsSwCardEnvStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final String SlotOutlet1;
    public final String SlotOutlet1Avg;
    public final String SlotOutlet1Max;
    public final String SlotOutlet1Min;
    public final String SlotOutlet2;
    public final String SlotOutlet2Avg;
    public final String SlotOutlet2Max;
    public final String SlotOutlet2Min;
    public final String SlotOutlet3;
    public final String SlotOutlet3Avg;
    public final String SlotOutlet3Max;
    public final String SlotOutlet3Min;

    private UcsSwCardEnvStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.swCardEnvStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        SlotOutlet1 = builder.SlotOutlet1;
        SlotOutlet1Avg = builder.SlotOutlet1Avg;
        SlotOutlet1Max = builder.SlotOutlet1Max;
        SlotOutlet1Min = builder.SlotOutlet1Min;
        SlotOutlet2 = builder.SlotOutlet2;
        SlotOutlet2Avg = builder.SlotOutlet2Avg;
        SlotOutlet2Max = builder.SlotOutlet2Max;
        SlotOutlet2Min = builder.SlotOutlet2Min;
        SlotOutlet3 = builder.SlotOutlet3;
        SlotOutlet3Avg = builder.SlotOutlet3Avg;
        SlotOutlet3Max = builder.SlotOutlet3Max;
        SlotOutlet3Min = builder.SlotOutlet3Min;
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

        private String SlotOutlet1;
        private String SlotOutlet1Avg;
        private String SlotOutlet1Max;
        private String SlotOutlet1Min;
        private String SlotOutlet2;
        private String SlotOutlet2Avg;
        private String SlotOutlet2Max;
        private String SlotOutlet2Min;
        private String SlotOutlet3;
        private String SlotOutlet3Avg;
        private String SlotOutlet3Max;
        private String SlotOutlet3Min;

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

        public Builder withSlotOutlet1(String SlotOutlet1){
            this.SlotOutlet1 = SlotOutlet1;
            return this;
        }

        public Builder withSlotOutlet1Avg(String SlotOutlet1Avg){
            this.SlotOutlet1Avg = SlotOutlet1Avg;
            return this;
        }

        public Builder withSlotOutlet1Max(String SlotOutlet1Max){
            this.SlotOutlet1Max = SlotOutlet1Max;
            return this;
        }

        public Builder withSlotOutlet1Min(String SlotOutlet1Min){
            this.SlotOutlet1Min = SlotOutlet1Min;
            return this;
        }

        public Builder withSlotOutlet2(String SlotOutlet2){
            this.SlotOutlet2 = SlotOutlet2;
            return this;
        }

        public Builder withSlotOutlet2Avg(String SlotOutlet2Avg){
            this.SlotOutlet2Avg = SlotOutlet2Avg;
            return this;
        }

        public Builder withSlotOutlet2Max(String SlotOutlet2Max){
            this.SlotOutlet2Max = SlotOutlet2Max;
            return this;
        }

        public Builder withSlotOutlet2Min(String SlotOutlet2Min){
            this.SlotOutlet2Min = SlotOutlet2Min;
            return this;
        }

        public Builder withSlotOutlet3(String SlotOutlet3){
            this.SlotOutlet3 = SlotOutlet3;
            return this;
        }

        public Builder withSlotOutlet3Avg(String SlotOutlet3Avg){
            this.SlotOutlet3Avg = SlotOutlet3Avg;
            return this;
        }

        public Builder withSlotOutlet3Max(String SlotOutlet3Max){
            this.SlotOutlet3Max = SlotOutlet3Max;
            return this;
        }

        public Builder withSlotOutlet3Min(String SlotOutlet3Min){
            this.SlotOutlet3Min = SlotOutlet3Min;
            return this;
        }

        public UcsSwCardEnvStats build() {
            return new UcsSwCardEnvStats(this);
        }
    }
}
