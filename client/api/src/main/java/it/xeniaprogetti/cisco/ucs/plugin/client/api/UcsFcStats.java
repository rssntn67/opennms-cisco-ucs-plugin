package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsFcStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long bytesRx;
    public final long bytesTx;
    public final long packetsRx;
    public final long packetsTx;

    private UcsFcStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.fcStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        bytesRx = builder.bytesRx;
        bytesTx = builder.bytesTx;
        packetsRx = builder.packetsRx;
        packetsTx = builder.packetsTx;
    }

    @Override
    public String toString() {
        return "UcsFcStats{" +
                "bytesRx=" + bytesRx +
                ", bytesTx=" + bytesTx +
                ", packetsRx=" + packetsRx +
                ", packetsTx=" + packetsTx +
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

        private long bytesRx;
        private long bytesTx;
        private long packetsRx;
        private long packetsTx;

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

        public Builder withBytesRx(long bytesRx){
            this.bytesRx = bytesRx;
            return this;
        }

        public Builder withBytesTx(long bytesTx){
            this.bytesTx = bytesTx;
            return this;
        }

        public Builder withPacketsRx(long packetsRx){
            this.packetsRx = packetsRx;
            return this;
        }

        public Builder withPacketsTx(long packetsTx){
            this.packetsTx = packetsTx;
            return this;
        }

        public UcsFcStats build() {
            return new UcsFcStats(this);
        }
    }
}
