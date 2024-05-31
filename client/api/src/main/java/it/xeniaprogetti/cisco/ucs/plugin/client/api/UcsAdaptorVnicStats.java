package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsAdaptorVnicStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long bytesRx;
    public final long bytesTx;
    public final int droppedRx;
    public final int droppedTx;
    public final int errorsRx;
    public final int errorsTx;
    public final int packetsRx;
    public final int packetsTx;

    private UcsAdaptorVnicStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.adaptorVnicStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        bytesRx = builder.bytesRx;
        bytesTx = builder.bytesTx;
        droppedRx = builder.droppedRx;
        droppedTx = builder.droppedTx;
        errorsRx = builder.errorsRx;
        errorsTx = builder.errorsTx;
        packetsRx = builder.packetsRx;
        packetsTx = builder.packetsTx;
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
        private int droppedRx;
        private int droppedTx;
        private int errorsRx;
        private int errorsTx;
        private int packetsRx;
        private int packetsTx;

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

        public Builder withDroppedRx(int droppedRx){
            this.droppedRx = droppedRx;
            return this;
        }

        public Builder withDroppedTx(int droppedTx){
            this.droppedTx = droppedTx;
            return this;
        }

        public Builder withErrorsRx(int errorsRx){
            this.errorsRx = errorsRx;
            return this;
        }

        public Builder withErrorsTx(int errorsTx){
            this.errorsTx = errorsTx;
            return this;
        }

        public Builder withPacketsRx(int packetsRx){
            this.packetsRx = packetsRx;
            return this;
        }

        public Builder withPacketsTx(int packetsTx){
            this.packetsTx = packetsTx;
            return this;
        }


        public UcsAdaptorVnicStats build() {
            return new UcsAdaptorVnicStats(this);
        }
    }
}
