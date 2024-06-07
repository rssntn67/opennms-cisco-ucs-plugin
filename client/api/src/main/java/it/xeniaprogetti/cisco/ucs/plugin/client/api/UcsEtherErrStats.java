package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEtherErrStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long align;
    public final long deferredTx;
    public final long fcs;
    public final long intMacRx;
    public final long intMacTx;
    public final long outDiscard;
    public final long rcv;
    public final long underSize;
    public final long xmit;

    private UcsEtherErrStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.etherErrStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        align = builder.align;
        deferredTx = builder.deferredTx;
        fcs = builder.fcs;
        intMacRx = builder.intMacRx;
        intMacTx = builder.intMacTx;
        outDiscard = builder.outDiscard;
        rcv = builder.rcv;
        underSize = builder.underSize;
        xmit = builder.xmit;
    }

    @Override
    public String toString() {
        return "UcsEtherErrStats{" +
                "align=" + align +
                ", deferredTx=" + deferredTx +
                ", fcs=" + fcs +
                ", intMacRx=" + intMacRx +
                ", intMacTx=" + intMacTx +
                ", outDiscard=" + outDiscard +
                ", rcv=" + rcv +
                ", underSize=" + underSize +
                ", xmit=" + xmit +
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

        private long align;
        private long deferredTx;
        private long fcs;
        private long intMacRx;
        private long intMacTx;
        private long outDiscard;
        private long rcv;
        private long underSize;
        private long xmit;

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

        public Builder withAlign(long align){
            this.align = align;
            return this;
        }

        public Builder withDeferredTx(long deferredTx){
            this.deferredTx = deferredTx;
            return this;
        }

        public Builder withFcs(long fcs){
            this.fcs = fcs;
            return this;
        }

        public Builder withiIntMacRx(long intMacRx){
            this.intMacRx = intMacRx;
            return this;
        }

        public Builder withIntMacTx(long intMacTx){
            this.intMacTx = intMacTx;
            return this;
        }

        public Builder withOutDiscard(long outDiscard){
            this.outDiscard = outDiscard;
            return this;
        }

        public Builder withRcv(long rcv){
            this.rcv = rcv;
            return this;
        }

        public Builder withUnderSize(long underSize){
            this.underSize = underSize;
            return this;
        }

        public Builder withXmit(long xmit){
            this.xmit = xmit;
            return this;
        }

        public UcsEtherErrStats build() {
            return new UcsEtherErrStats(this);
        }
    }
}
