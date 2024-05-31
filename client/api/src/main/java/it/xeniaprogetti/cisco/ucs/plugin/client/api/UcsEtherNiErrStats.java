package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherNiErrStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long crc;
    public final long frameTx;
    public final long inRange;
    public final long tooLong;
    public final long tooShort;

    private UcsEtherNiErrStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherNiErrStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        crc = builder.crc;
        frameTx = builder.frameTx;
        inRange = builder.inRange;
        tooLong = builder.tooLong;
        tooShort = builder.tooShort;
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

        private long crc;
        private long frameTx;
        private long inRange;
        private long tooLong;
        private long tooShort;

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

        public Builder withCrc(long crc){
            this.crc = crc;
            return this;
        }

        public Builder withFrameTx(long frameTx){
            this.frameTx = frameTx;
            return this;
        }

        public Builder withInRange(long inRange){
            this.inRange = inRange;
            return this;
        }

        public Builder withTooLong(long tooLong){
            this.tooLong = tooLong;
            return this;
        }

        public Builder withTooShort(long tooShort){
            this.tooShort = tooShort;
            return this;
        }
        
        public UcsEtherNiErrStats build() {
            return new UcsEtherNiErrStats(this);
        }
    }
}
