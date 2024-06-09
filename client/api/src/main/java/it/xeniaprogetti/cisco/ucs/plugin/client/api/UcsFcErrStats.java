package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsFcErrStats extends UcsStats implements UcsResourceType {

    public static Builder builder() {
       return new Builder();
    }

    public final long crcRx;
    public final long discardRx;
    public final long discardTx;
    public final long linkFailures;
    public final long rx;
    public final long signalLosses;
    public final long syncLosses;
    public final long tooLongRx;
    public final long tooShortRx;
    public final long tx;

    private UcsFcErrStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.fcErrStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        crcRx = builder.crcRx;
        discardRx = builder.discardRx;
        discardTx = builder.discardTx;
        linkFailures = builder.linkFailures;
        rx = builder.rx;
        signalLosses = builder.signalLosses;
        syncLosses = builder.syncLosses;
        tooLongRx = builder.tooLongRx;
        tooShortRx = builder.tooShortRx;
        tx = builder.tx;
    }

    @Override
    public String toString() {
        return "UcsFcErrStats{" +
                "crcRx=" + crcRx +
                ", discardRx=" + discardRx +
                ", discardTx=" + discardTx +
                ", linkFailures=" + linkFailures +
                ", rx=" + rx +
                ", signalLosses=" + signalLosses +
                ", syncLosses=" + syncLosses +
                ", tooLongRx=" + tooLongRx +
                ", tooShortRx=" + tooShortRx +
                ", tx=" + tx +
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

    @Override
    public UcsEnums.ResourceType getResourceType() {
        return UcsEnums.ResourceType.Fc;
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

        private long crcRx;
        private long discardRx;
        private long discardTx;
        private long linkFailures;
        private long rx;
        private long signalLosses;
        private long syncLosses;
        private long tooLongRx;
        private long tooShortRx;
        private long tx;

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

        public Builder withCrcRx(long crcRx){
            this.crcRx = crcRx;
            return this;
        }

        public Builder withDiscardRx(long discardRx){
            this.discardRx = discardRx;
            return this;
        }

        public Builder withDiscardTx(long discardTx){
            this.discardTx = discardTx;
            return this;
        }

        public Builder withLinkFailures(long linkFailures){
            this.linkFailures = linkFailures;
            return this;
        }

        public Builder withRx(long rx){
            this.rx = rx;
            return this;
        }

        public Builder withSignalLosses(long signalLosses){
            this.signalLosses = signalLosses;
            return this;
        }


        public Builder withSyncLosses(long syncLosses){
            this.syncLosses = syncLosses;
            return this;
        }

        public Builder withTooLongRx(long tooLongRx){
            this.tooLongRx = tooLongRx;
            return this;
        }

        public Builder withTooShortRx(long tooShortRx){
            this.tooShortRx = tooShortRx;
            return this;
        }

        public Builder withTx(long tx){
            this.tx = tx;
            return this;
        }

        public UcsFcErrStats build() {
            return new UcsFcErrStats(this);
        }
    }
}
