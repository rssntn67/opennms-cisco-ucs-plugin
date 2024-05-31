package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsSwCardEnvStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final String SlotOutlet1;
    public final String SlotOutlet2;
    public final String SlotOutlet3;

    private UcsSwCardEnvStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.swCardEnvStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        SlotOutlet1 = builder.SlotOutlet1;
        SlotOutlet2 = builder.SlotOutlet2;
        SlotOutlet3 = builder.SlotOutlet3;
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
        private String SlotOutlet2;
        private String SlotOutlet3;

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

        public Builder withSlotOutlet2(String SlotOutlet2){
            this.SlotOutlet2 = SlotOutlet2;
            return this;
        }

        public Builder withSlotOutlet3(String SlotOutlet3){
            this.SlotOutlet3 = SlotOutlet3;
            return this;
        }

        public UcsSwCardEnvStats build() {
            return new UcsSwCardEnvStats(this);
        }
    }
}
