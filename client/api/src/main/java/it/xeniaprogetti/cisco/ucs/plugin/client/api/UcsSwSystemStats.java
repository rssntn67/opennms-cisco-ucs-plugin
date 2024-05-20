package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsSwSystemStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final String CorrectableParityError;
    public final String CorrectableParityErrorAvg;
    public final String CorrectableParityErrorMax;
    public final String CorrectableParityErrorMin;
    public final String kernelMemFree;
    public final String kernelMemFreeAvg;
    public final String kernelMemFreeMax;
    public final String kernelMemFreeMin;
    public final String kernelMemTotal;
    public final String kernelMemTotalAvg;
    public final String kernelMemTotalMax;
    public final String kernelMemTotalMin;
    public final double load;
    public final double loadAvg;
    public final double loadMax;
    public final double loadMin;
    public final int memAvailable;
    public final int memAvailableAvg;
    public final int memAvailableMax;
    public final int memAvailableMin;
    public final int memCached;
    public final int memCachedAvg;
    public final int memCachedMax;
    public final int memCachedMin;

    private UcsSwSystemStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.swSystemStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        CorrectableParityError = builder.CorrectableParityError;
        CorrectableParityErrorAvg = builder.CorrectableParityErrorAvg;
        CorrectableParityErrorMax = builder.CorrectableParityErrorMax;
        CorrectableParityErrorMin = builder.CorrectableParityErrorMin;
        kernelMemFree = builder.kernelMemFree;
        kernelMemFreeAvg = builder.kernelMemFreeAvg;
        kernelMemFreeMax = builder.kernelMemFreeMax;
        kernelMemFreeMin = builder.kernelMemFreeMin;
        kernelMemTotal = builder.kernelMemTotal;
        kernelMemTotalAvg = builder.kernelMemTotalAvg;
        kernelMemTotalMax = builder.kernelMemTotalMax;
        kernelMemTotalMin = builder.kernelMemTotalMin;
        load = builder.load;
        loadAvg = builder.loadAvg;
        loadMax = builder.loadMax;
        loadMin = builder.loadMin;
        memAvailable = builder.memAvailable;
        memAvailableAvg = builder.memAvailableAvg;
        memAvailableMax = builder.memAvailableMax;
        memAvailableMin = builder.memAvailableMin;
        memCached = builder.memCached;
        memCachedAvg = builder.memCachedAvg;
        memCachedMax = builder.memCachedMax;
        memCachedMin = builder.memCachedMin;
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

        private String CorrectableParityError;
        private String CorrectableParityErrorAvg;
        private String CorrectableParityErrorMax;
        private String CorrectableParityErrorMin;
        private String kernelMemFree;
        private String kernelMemFreeAvg;
        private String kernelMemFreeMax;
        private String kernelMemFreeMin;
        private String kernelMemTotal;
        private String kernelMemTotalAvg;
        private String kernelMemTotalMax;
        private String kernelMemTotalMin;
        private double load;
        private double loadAvg;
        private double loadMax;
        private double loadMin;
        private int memAvailable;
        private int memAvailableAvg;
        private int memAvailableMax;
        private int memAvailableMin;
        private int memCached;
        private int memCachedAvg;
        private int memCachedMax;
        private int memCachedMin;

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

        public Builder withCorrectableParityError(String CorrectableParityError){
            this.CorrectableParityError = CorrectableParityError;
            return this;
        }

        public Builder withCorrectableParityErrorAvg(String CorrectableParityErrorAvg){
            this.CorrectableParityErrorAvg = CorrectableParityErrorAvg;
            return this;
        }

        public Builder withCorrectableParityErrorMax(String CorrectableParityErrorMax){
            this.CorrectableParityErrorMax = CorrectableParityErrorMax;
            return this;
        }

        public Builder withCorrectableParityErrorMin(String CorrectableParityErrorMin){
            this.CorrectableParityErrorMin = CorrectableParityErrorMin;
            return this;
        }

        public Builder withkernelMemFree(String kernelMemFree){
            this.kernelMemFree = kernelMemFree;
            return this;
        }

        public Builder withkernelMemFreeAvg(String kernelMemFreeAvg){
            this.kernelMemFreeAvg = kernelMemFreeAvg;
            return this;
        }

        public Builder withkernelMemFreeMax(String kernelMemFreeMax){
            this.kernelMemFreeMax = kernelMemFreeMax;
            return this;
        }

        public Builder withkernelMemFreeMin(String kernelMemFreeMin){
            this.kernelMemFreeMin = kernelMemFreeMin;
            return this;
        }

        public Builder withkernelMemTotal(String kernelMemTotal){
            this.kernelMemTotal = kernelMemTotal;
            return this;
        }

        public Builder withkernelMemTotalAvg(String kernelMemTotalAvg){
            this.kernelMemTotalAvg = kernelMemTotalAvg;
            return this;
        }

        public Builder withkernelMemTotalMax(String kernelMemTotalMax){
            this.kernelMemTotalMax = kernelMemTotalMax;
            return this;
        }

        public Builder withkernelMemTotalMin(String kernelMemTotalMin){
            this.kernelMemTotalMin = kernelMemTotalMin;
            return this;
        }

        public Builder withload(double load){
            this.load = load;
            return this;
        }

        public Builder withloadAvg(double loadAvg){
            this.loadAvg = loadAvg;
            return this;
        }

        public Builder withloadMax(double loadMax){
            this.loadMax = loadMax;
            return this;
        }

        public Builder withloadMin(double loadMin){
            this.loadMin = loadMin;
            return this;
        }

        public Builder withmemAvailable(int memAvailable){
            this.memAvailable = memAvailable;
            return this;
        }

        public Builder withmemAvailableAvg(int memAvailableAvg){
            this.memAvailableAvg = memAvailableAvg;
            return this;
        }

        public Builder withmemAvailableMax(int memAvailableMax){
            this.memAvailableMax = memAvailableMax;
            return this;
        }

        public Builder withmemAvailableMin(int memAvailableMin){
            this.memAvailableMin = memAvailableMin;
            return this;
        }

        public Builder withmemCached(int memCached){
            this.memCached = memCached;
            return this;
        }

        public Builder withmemCachedAvg(int memCachedAvg){
            this.memCachedAvg = memCachedAvg;
            return this;
        }

        public Builder withmemCachedMax(int memCachedMax){
            this.memCachedMax = memCachedMax;
            return this;
        }

        public Builder withmemCachedMin(int memCachedMin){
            this.memCachedMin = memCachedMin;
            return this;
        }

        public UcsSwSystemStats build() {
            return new UcsSwSystemStats(this);
        }
    }
}
