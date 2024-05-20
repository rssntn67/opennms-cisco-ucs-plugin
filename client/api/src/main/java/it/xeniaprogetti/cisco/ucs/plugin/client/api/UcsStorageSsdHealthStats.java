package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsStorageSsdHealthStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int id;
    public final int percentageLifeLeft;
    public final int percentageLifeLeftAvg;
    public final int percentageLifeLeftMax;
    public final int percentageLifeLeftMin;
    public final int powerCycleCount;
    public final int powerCycleCountAvg;
    public final int powerCycleCountMax;
    public final int powerCycleCountMin;
    public final int powerOnHours;
    public final int powerOnHoursAvg;
    public final int powerOnHoursMax;
    public final int powerOnHoursMin;
    public final int wearStatusInDays;
    public final int wearStatusInDaysAvg;
    public final int wearStatusInDaysMax;
    public final int wearStatusInDaysMin;

    private UcsStorageSsdHealthStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.storageSsdHealthStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        id = builder.id;
        percentageLifeLeft = builder.percentageLifeLeft;
        percentageLifeLeftAvg = builder.percentageLifeLeftAvg;
        percentageLifeLeftMax = builder.percentageLifeLeftMax;
        percentageLifeLeftMin = builder.percentageLifeLeftMin;
        powerCycleCount = builder.powerCycleCount;
        powerCycleCountAvg = builder.powerCycleCountAvg;
        powerCycleCountMax = builder.powerCycleCountMax;
        powerCycleCountMin = builder.powerCycleCountMin;
        powerOnHours = builder.powerOnHours;
        powerOnHoursAvg = builder.powerOnHoursAvg;
        powerOnHoursMax = builder.powerOnHoursMax;
        powerOnHoursMin = builder.powerOnHoursMin;
        wearStatusInDays = builder.wearStatusInDays;
        wearStatusInDaysAvg = builder.wearStatusInDaysAvg;
        wearStatusInDaysMax = builder.wearStatusInDaysMax;
        wearStatusInDaysMin = builder.wearStatusInDaysMin;
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

        private int id;
        private int percentageLifeLeft;
        private int percentageLifeLeftAvg;
        private int percentageLifeLeftMax;
        private int percentageLifeLeftMin;
        private int powerCycleCount;
        private int powerCycleCountAvg;
        private int powerCycleCountMax;
        private int powerCycleCountMin;
        private int powerOnHours;
        private int powerOnHoursAvg;
        private int powerOnHoursMax;
        private int powerOnHoursMin;
        private int wearStatusInDays;
        private int wearStatusInDaysAvg;
        private int wearStatusInDaysMax;
        private int wearStatusInDaysMin;

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

        public Builder withid(int id){
            this.id = id;
            return this;
        }

        public Builder withpercentageLifeLeft(int percentageLifeLeft){
            this.percentageLifeLeft = percentageLifeLeft;
            return this;
        }

        public Builder withpercentageLifeLeftAvg(int percentageLifeLeftAvg){
            this.percentageLifeLeftAvg = percentageLifeLeftAvg;
            return this;
        }

        public Builder withpercentageLifeLeftMax(int percentageLifeLeftMax){
            this.percentageLifeLeftMax = percentageLifeLeftMax;
            return this;
        }

        public Builder withpercentageLifeLeftMin(int percentageLifeLeftMin){
            this.percentageLifeLeftMin = percentageLifeLeftMin;
            return this;
        }

        public Builder withpowerCycleCount(int powerCycleCount){
            this.powerCycleCount = powerCycleCount;
            return this;
        }

        public Builder withpowerCycleCountAvg(int powerCycleCountAvg){
            this.powerCycleCountAvg = powerCycleCountAvg;
            return this;
        }

        public Builder withpowerCycleCountMax(int powerCycleCountMax){
            this.powerCycleCountMax = powerCycleCountMax;
            return this;
        }

        public Builder withpowerCycleCountMin(int powerCycleCountMin){
            this.powerCycleCountMin = powerCycleCountMin;
            return this;
        }

        public Builder withpowerOnHours(int powerOnHours){
            this.powerOnHours = powerOnHours;
            return this;
        }

        public Builder withpowerOnHoursAvg(int powerOnHoursAvg){
            this.powerOnHoursAvg = powerOnHoursAvg;
            return this;
        }

        public Builder withpowerOnHoursMax(int powerOnHoursMax){
            this.powerOnHoursMax = powerOnHoursMax;
            return this;
        }

        public Builder withpowerOnHoursMin(int powerOnHoursMin){
            this.powerOnHoursMin = powerOnHoursMin;
            return this;
        }

        public Builder withwearStatusInDays(int wearStatusInDays){
            this.wearStatusInDays = wearStatusInDays;
            return this;
        }

        public Builder withwearStatusInDaysAvg(int wearStatusInDaysAvg){
            this.wearStatusInDaysAvg = wearStatusInDaysAvg;
            return this;
        }

        public Builder withwearStatusInDaysMax(int wearStatusInDaysMax){
            this.wearStatusInDaysMax = wearStatusInDaysMax;
            return this;
        }

        public Builder withwearStatusInDaysMin(int wearStatusInDaysMin){
            this.wearStatusInDaysMin = wearStatusInDaysMin;
            return this;
        }

        public UcsStorageSsdHealthStats build() {
            return new UcsStorageSsdHealthStats(this);
        }
    }
}
