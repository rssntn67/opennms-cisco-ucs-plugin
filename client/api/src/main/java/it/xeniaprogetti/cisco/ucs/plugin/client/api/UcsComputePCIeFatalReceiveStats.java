package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputePCIeFatalReceiveStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int bufferOverflowErrors;
    public final int bufferOverflowErrors15Min;
    public final int bufferOverflowErrors15MinH;
    public final int bufferOverflowErrors1Day;
    public final int bufferOverflowErrors1DayH;
    public final int bufferOverflowErrors1Hour;
    public final int bufferOverflowErrors1HourH;
    public final int bufferOverflowErrors1Week;
    public final int bufferOverflowErrors1WeekH;
    public final int bufferOverflowErrors2Weeks;
    public final int bufferOverflowErrors2WeeksH;
    public final int errFatalErrors;
    public final int errFatalErrors15Min;
    public final int errFatalErrors15MinH;
    public final int errFatalErrors1Day;
    public final int errFatalErrors1DayH;
    public final int errFatalErrors1Hour;
    public final int errFatalErrors1HourH;
    public final int errFatalErrors1Week;
    public final int errFatalErrors1WeekH;
    public final int errFatalErrors2Weeks;
    public final int errFatalErrors2WeeksH;
    public final int errNonFatalErrors;
    public final int errNonFatalErrors15Min;
    public final int errNonFatalErrors15MinH;
    public final int errNonFatalErrors1Day;
    public final int errNonFatalErrors1DayH;
    public final int errNonFatalErrors1Hour;
    public final int errNonFatalErrors1HourH;
    public final int errNonFatalErrors1Week;
    public final int errNonFatalErrors1WeekH;
    public final int errNonFatalErrors2Weeks;
    public final int errNonFatalErrors2WeeksH;
    public final int unsupportedRequestErrors;
    public final int unsupportedRequestErrors15Min;
    public final int unsupportedRequestErrors15MinH;
    public final int unsupportedRequestErrors1Day;
    public final int unsupportedRequestErrors1DayH;
    public final int unsupportedRequestErrors1Hour;
    public final int unsupportedRequestErrors1HourH;
    public final int unsupportedRequestErrors1Week;
    public final int unsupportedRequestErrors1WeekH;
    public final int unsupportedRequestErrors2Weeks;
    public final int unsupportedRequestErrors2WeeksH;

    private UcsComputePCIeFatalReceiveStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computePCIeFatalReceiveStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        bufferOverflowErrors = builder.bufferOverflowErrors;
        bufferOverflowErrors15Min = builder.bufferOverflowErrors15Min;
        bufferOverflowErrors15MinH = builder.bufferOverflowErrors15MinH;
        bufferOverflowErrors1Day = builder.bufferOverflowErrors1Day;
        bufferOverflowErrors1DayH = builder.bufferOverflowErrors1DayH;
        bufferOverflowErrors1Hour = builder.bufferOverflowErrors1Hour;
        bufferOverflowErrors1HourH = builder.bufferOverflowErrors1HourH;
        bufferOverflowErrors1Week = builder.bufferOverflowErrors1Week;
        bufferOverflowErrors1WeekH = builder.bufferOverflowErrors1WeekH;
        bufferOverflowErrors2Weeks = builder.bufferOverflowErrors2Weeks;
        bufferOverflowErrors2WeeksH = builder.bufferOverflowErrors2WeeksH;
        errFatalErrors = builder.errFatalErrors;
        errFatalErrors15Min = builder.errFatalErrors15Min;
        errFatalErrors15MinH = builder.errFatalErrors15MinH;
        errFatalErrors1Day = builder.errFatalErrors1Day;
        errFatalErrors1DayH = builder.errFatalErrors1DayH;
        errFatalErrors1Hour = builder.errFatalErrors1Hour;
        errFatalErrors1HourH = builder.errFatalErrors1HourH;
        errFatalErrors1Week = builder.errFatalErrors1Week;
        errFatalErrors1WeekH = builder.errFatalErrors1WeekH;
        errFatalErrors2Weeks = builder.errFatalErrors2Weeks;
        errFatalErrors2WeeksH = builder.errFatalErrors2WeeksH;
        errNonFatalErrors = builder.errNonFatalErrors;
        errNonFatalErrors15Min = builder.errNonFatalErrors15Min;
        errNonFatalErrors15MinH = builder.errNonFatalErrors15MinH;
        errNonFatalErrors1Day = builder.errNonFatalErrors1Day;
        errNonFatalErrors1DayH = builder.errNonFatalErrors1DayH;
        errNonFatalErrors1Hour = builder.errNonFatalErrors1Hour;
        errNonFatalErrors1HourH = builder.errNonFatalErrors1HourH;
        errNonFatalErrors1Week = builder.errNonFatalErrors1Week;
        errNonFatalErrors1WeekH = builder.errNonFatalErrors1WeekH;
        errNonFatalErrors2Weeks = builder.errNonFatalErrors2Weeks;
        errNonFatalErrors2WeeksH = builder.errNonFatalErrors2WeeksH;
        unsupportedRequestErrors = builder.unsupportedRequestErrors;
        unsupportedRequestErrors15Min = builder.unsupportedRequestErrors15Min;
        unsupportedRequestErrors15MinH = builder.unsupportedRequestErrors15MinH;
        unsupportedRequestErrors1Day = builder.unsupportedRequestErrors1Day;
        unsupportedRequestErrors1DayH = builder.unsupportedRequestErrors1DayH;
        unsupportedRequestErrors1Hour = builder.unsupportedRequestErrors1Hour;
        unsupportedRequestErrors1HourH = builder.unsupportedRequestErrors1HourH;
        unsupportedRequestErrors1Week = builder.unsupportedRequestErrors1Week;
        unsupportedRequestErrors1WeekH = builder.unsupportedRequestErrors1WeekH;
        unsupportedRequestErrors2Weeks = builder.unsupportedRequestErrors2Weeks;
        unsupportedRequestErrors2WeeksH = builder.unsupportedRequestErrors2WeeksH;
    }

    @Override
    public String toString() {
        return "UcsComputePCIeFatalReceiveStats{" +
                "bufferOverflowErrors=" + bufferOverflowErrors +
                ", bufferOverflowErrors15Min=" + bufferOverflowErrors15Min +
                ", bufferOverflowErrors15MinH=" + bufferOverflowErrors15MinH +
                ", bufferOverflowErrors1Day=" + bufferOverflowErrors1Day +
                ", bufferOverflowErrors1DayH=" + bufferOverflowErrors1DayH +
                ", bufferOverflowErrors1Hour=" + bufferOverflowErrors1Hour +
                ", bufferOverflowErrors1HourH=" + bufferOverflowErrors1HourH +
                ", bufferOverflowErrors1Week=" + bufferOverflowErrors1Week +
                ", bufferOverflowErrors1WeekH=" + bufferOverflowErrors1WeekH +
                ", bufferOverflowErrors2Weeks=" + bufferOverflowErrors2Weeks +
                ", bufferOverflowErrors2WeeksH=" + bufferOverflowErrors2WeeksH +
                ", errFatalErrors=" + errFatalErrors +
                ", errFatalErrors15Min=" + errFatalErrors15Min +
                ", errFatalErrors15MinH=" + errFatalErrors15MinH +
                ", errFatalErrors1Day=" + errFatalErrors1Day +
                ", errFatalErrors1DayH=" + errFatalErrors1DayH +
                ", errFatalErrors1Hour=" + errFatalErrors1Hour +
                ", errFatalErrors1HourH=" + errFatalErrors1HourH +
                ", errFatalErrors1Week=" + errFatalErrors1Week +
                ", errFatalErrors1WeekH=" + errFatalErrors1WeekH +
                ", errFatalErrors2Weeks=" + errFatalErrors2Weeks +
                ", errFatalErrors2WeeksH=" + errFatalErrors2WeeksH +
                ", errNonFatalErrors=" + errNonFatalErrors +
                ", errNonFatalErrors15Min=" + errNonFatalErrors15Min +
                ", errNonFatalErrors15MinH=" + errNonFatalErrors15MinH +
                ", errNonFatalErrors1Day=" + errNonFatalErrors1Day +
                ", errNonFatalErrors1DayH=" + errNonFatalErrors1DayH +
                ", errNonFatalErrors1Hour=" + errNonFatalErrors1Hour +
                ", errNonFatalErrors1HourH=" + errNonFatalErrors1HourH +
                ", errNonFatalErrors1Week=" + errNonFatalErrors1Week +
                ", errNonFatalErrors1WeekH=" + errNonFatalErrors1WeekH +
                ", errNonFatalErrors2Weeks=" + errNonFatalErrors2Weeks +
                ", errNonFatalErrors2WeeksH=" + errNonFatalErrors2WeeksH +
                ", unsupportedRequestErrors=" + unsupportedRequestErrors +
                ", unsupportedRequestErrors15Min=" + unsupportedRequestErrors15Min +
                ", unsupportedRequestErrors15MinH=" + unsupportedRequestErrors15MinH +
                ", unsupportedRequestErrors1Day=" + unsupportedRequestErrors1Day +
                ", unsupportedRequestErrors1DayH=" + unsupportedRequestErrors1DayH +
                ", unsupportedRequestErrors1Hour=" + unsupportedRequestErrors1Hour +
                ", unsupportedRequestErrors1HourH=" + unsupportedRequestErrors1HourH +
                ", unsupportedRequestErrors1Week=" + unsupportedRequestErrors1Week +
                ", unsupportedRequestErrors1WeekH=" + unsupportedRequestErrors1WeekH +
                ", unsupportedRequestErrors2Weeks=" + unsupportedRequestErrors2Weeks +
                ", unsupportedRequestErrors2WeeksH=" + unsupportedRequestErrors2WeeksH +
                ", suspect='" + suspect + '\'' +
                ", intervals=" + intervals +
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

        private int bufferOverflowErrors;
        private int bufferOverflowErrors15Min;
        private int bufferOverflowErrors15MinH;
        private int bufferOverflowErrors1Day;
        private int bufferOverflowErrors1DayH;
        private int bufferOverflowErrors1Hour;
        private int bufferOverflowErrors1HourH;
        private int bufferOverflowErrors1Week;
        private int bufferOverflowErrors1WeekH;
        private int bufferOverflowErrors2Weeks;
        private int bufferOverflowErrors2WeeksH;
        private int errFatalErrors;
        private int errFatalErrors15Min;
        private int errFatalErrors15MinH;
        private int errFatalErrors1Day;
        private int errFatalErrors1DayH;
        private int errFatalErrors1Hour;
        private int errFatalErrors1HourH;
        private int errFatalErrors1Week;
        private int errFatalErrors1WeekH;
        private int errFatalErrors2Weeks;
        private int errFatalErrors2WeeksH;
        private int errNonFatalErrors;
        private int errNonFatalErrors15Min;
        private int errNonFatalErrors15MinH;
        private int errNonFatalErrors1Day;
        private int errNonFatalErrors1DayH;
        private int errNonFatalErrors1Hour;
        private int errNonFatalErrors1HourH;
        private int errNonFatalErrors1Week;
        private int errNonFatalErrors1WeekH;
        private int errNonFatalErrors2Weeks;
        private int errNonFatalErrors2WeeksH;
        private int unsupportedRequestErrors;
        private int unsupportedRequestErrors15Min;
        private int unsupportedRequestErrors15MinH;
        private int unsupportedRequestErrors1Day;
        private int unsupportedRequestErrors1DayH;
        private int unsupportedRequestErrors1Hour;
        private int unsupportedRequestErrors1HourH;
        private int unsupportedRequestErrors1Week;
        private int unsupportedRequestErrors1WeekH;
        private int unsupportedRequestErrors2Weeks;
        private int unsupportedRequestErrors2WeeksH;

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

        public Builder withbufferOverflowErrors(int bufferOverflowErrors){
            this.bufferOverflowErrors = bufferOverflowErrors;
            return this;
        }

        public Builder withbufferOverflowErrors15Min(int bufferOverflowErrors15Min){
            this.bufferOverflowErrors15Min = bufferOverflowErrors15Min;
            return this;
        }

        public Builder withbufferOverflowErrors15MinH(int bufferOverflowErrors15MinH){
            this.bufferOverflowErrors15MinH = bufferOverflowErrors15MinH;
            return this;
        }

        public Builder withbufferOverflowErrors1Day(int bufferOverflowErrors1Day){
            this.bufferOverflowErrors1Day = bufferOverflowErrors1Day;
            return this;
        }

        public Builder withbufferOverflowErrors1DayH(int bufferOverflowErrors1DayH){
            this.bufferOverflowErrors1DayH = bufferOverflowErrors1DayH;
            return this;
        }

        public Builder withbufferOverflowErrors1Hour(int bufferOverflowErrors1Hour){
            this.bufferOverflowErrors1Hour = bufferOverflowErrors1Hour;
            return this;
        }

        public Builder withbufferOverflowErrors1HourH(int bufferOverflowErrors1HourH){
            this.bufferOverflowErrors1HourH = bufferOverflowErrors1HourH;
            return this;
        }

        public Builder withbufferOverflowErrors1Week(int bufferOverflowErrors1Week){
            this.bufferOverflowErrors1Week = bufferOverflowErrors1Week;
            return this;
        }

        public Builder withbufferOverflowErrors1WeekH(int bufferOverflowErrors1WeekH){
            this.bufferOverflowErrors1WeekH = bufferOverflowErrors1WeekH;
            return this;
        }

        public Builder withbufferOverflowErrors2Weeks(int bufferOverflowErrors2Weeks){
            this.bufferOverflowErrors2Weeks = bufferOverflowErrors2Weeks;
            return this;
        }

        public Builder withbufferOverflowErrors2WeeksH(int bufferOverflowErrors2WeeksH){
            this.bufferOverflowErrors2WeeksH = bufferOverflowErrors2WeeksH;
            return this;
        }

        public Builder witherrFatalErrors(int errFatalErrors){
            this.errFatalErrors = errFatalErrors;
            return this;
        }

        public Builder witherrFatalErrors15Min(int errFatalErrors15Min){
            this.errFatalErrors15Min = errFatalErrors15Min;
            return this;
        }

        public Builder witherrFatalErrors15MinH(int errFatalErrors15MinH){
            this.errFatalErrors15MinH = errFatalErrors15MinH;
            return this;
        }

        public Builder witherrFatalErrors1Day(int errFatalErrors1Day){
            this.errFatalErrors1Day = errFatalErrors1Day;
            return this;
        }

        public Builder witherrFatalErrors1DayH(int errFatalErrors1DayH){
            this.errFatalErrors1DayH = errFatalErrors1DayH;
            return this;
        }

        public Builder witherrFatalErrors1Hour(int errFatalErrors1Hour){
            this.errFatalErrors1Hour = errFatalErrors1Hour;
            return this;
        }

        public Builder witherrFatalErrors1HourH(int errFatalErrors1HourH){
            this.errFatalErrors1HourH = errFatalErrors1HourH;
            return this;
        }

        public Builder witherrFatalErrors1Week(int errFatalErrors1Week){
            this.errFatalErrors1Week = errFatalErrors1Week;
            return this;
        }

        public Builder witherrFatalErrors1WeekH(int errFatalErrors1WeekH){
            this.errFatalErrors1WeekH = errFatalErrors1WeekH;
            return this;
        }

        public Builder witherrFatalErrors2Weeks(int errFatalErrors2Weeks){
            this.errFatalErrors2Weeks = errFatalErrors2Weeks;
            return this;
        }

        public Builder witherrFatalErrors2WeeksH(int errFatalErrors2WeeksH){
            this.errFatalErrors2WeeksH = errFatalErrors2WeeksH;
            return this;
        }

        public Builder witherrNonFatalErrors(int errNonFatalErrors){
            this.errNonFatalErrors = errNonFatalErrors;
            return this;
        }

        public Builder witherrNonFatalErrors15Min(int errNonFatalErrors15Min){
            this.errNonFatalErrors15Min = errNonFatalErrors15Min;
            return this;
        }

        public Builder witherrNonFatalErrors15MinH(int errNonFatalErrors15MinH){
            this.errNonFatalErrors15MinH = errNonFatalErrors15MinH;
            return this;
        }

        public Builder witherrNonFatalErrors1Day(int errNonFatalErrors1Day){
            this.errNonFatalErrors1Day = errNonFatalErrors1Day;
            return this;
        }

        public Builder witherrNonFatalErrors1DayH(int errNonFatalErrors1DayH){
            this.errNonFatalErrors1DayH = errNonFatalErrors1DayH;
            return this;
        }

        public Builder witherrNonFatalErrors1Hour(int errNonFatalErrors1Hour){
            this.errNonFatalErrors1Hour = errNonFatalErrors1Hour;
            return this;
        }

        public Builder witherrNonFatalErrors1HourH(int errNonFatalErrors1HourH){
            this.errNonFatalErrors1HourH = errNonFatalErrors1HourH;
            return this;
        }

        public Builder witherrNonFatalErrors1Week(int errNonFatalErrors1Week){
            this.errNonFatalErrors1Week = errNonFatalErrors1Week;
            return this;
        }

        public Builder witherrNonFatalErrors1WeekH(int errNonFatalErrors1WeekH){
            this.errNonFatalErrors1WeekH = errNonFatalErrors1WeekH;
            return this;
        }

        public Builder witherrNonFatalErrors2Weeks(int errNonFatalErrors2Weeks){
            this.errNonFatalErrors2Weeks = errNonFatalErrors2Weeks;
            return this;
        }

        public Builder witherrNonFatalErrors2WeeksH(int errNonFatalErrors2WeeksH){
            this.errNonFatalErrors2WeeksH = errNonFatalErrors2WeeksH;
            return this;
        }

        public Builder withunsupportedRequestErrors(int unsupportedRequestErrors){
            this.unsupportedRequestErrors = unsupportedRequestErrors;
            return this;
        }

        public Builder withunsupportedRequestErrors15Min(int unsupportedRequestErrors15Min){
            this.unsupportedRequestErrors15Min = unsupportedRequestErrors15Min;
            return this;
        }

        public Builder withunsupportedRequestErrors15MinH(int unsupportedRequestErrors15MinH){
            this.unsupportedRequestErrors15MinH = unsupportedRequestErrors15MinH;
            return this;
        }

        public Builder withunsupportedRequestErrors1Day(int unsupportedRequestErrors1Day){
            this.unsupportedRequestErrors1Day = unsupportedRequestErrors1Day;
            return this;
        }

        public Builder withunsupportedRequestErrors1DayH(int unsupportedRequestErrors1DayH){
            this.unsupportedRequestErrors1DayH = unsupportedRequestErrors1DayH;
            return this;
        }

        public Builder withunsupportedRequestErrors1Hour(int unsupportedRequestErrors1Hour){
            this.unsupportedRequestErrors1Hour = unsupportedRequestErrors1Hour;
            return this;
        }

        public Builder withunsupportedRequestErrors1HourH(int unsupportedRequestErrors1HourH){
            this.unsupportedRequestErrors1HourH = unsupportedRequestErrors1HourH;
            return this;
        }

        public Builder withunsupportedRequestErrors1Week(int unsupportedRequestErrors1Week){
            this.unsupportedRequestErrors1Week = unsupportedRequestErrors1Week;
            return this;
        }

        public Builder withunsupportedRequestErrors1WeekH(int unsupportedRequestErrors1WeekH){
            this.unsupportedRequestErrors1WeekH = unsupportedRequestErrors1WeekH;
            return this;
        }

        public Builder withunsupportedRequestErrors2Weeks(int unsupportedRequestErrors2Weeks){
            this.unsupportedRequestErrors2Weeks = unsupportedRequestErrors2Weeks;
            return this;
        }

        public Builder withunsupportedRequestErrors2WeeksH(int unsupportedRequestErrors2WeeksH){
            this.unsupportedRequestErrors2WeeksH = unsupportedRequestErrors2WeeksH;
            return this;
        }

        public UcsComputePCIeFatalReceiveStats build() {
            return new UcsComputePCIeFatalReceiveStats(this);
        }
    }
}
