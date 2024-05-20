package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputePCIeFatalCompletionStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int AbortErrors;
    public final int AbortErrors15Min;
    public final int AbortErrors15MinH;
    public final int AbortErrors1Day;
    public final int AbortErrors1DayH;
    public final int AbortErrors1Hour;
    public final int AbortErrors1HourH;
    public final int AbortErrors1Week;
    public final int AbortErrors1WeekH;
    public final int AbortErrors2Weeks;
    public final int AbortErrors2WeeksH;
    public final int TimeoutErrors;
    public final int TimeoutErrors15Min;
    public final int TimeoutErrors15MinH;
    public final int TimeoutErrors1Day;
    public final int TimeoutErrors1DayH;
    public final int TimeoutErrors1Hour;
    public final int TimeoutErrors1HourH;
    public final int TimeoutErrors1Week;
    public final int TimeoutErrors1WeekH;
    public final int TimeoutErrors2Weeks;
    public final int TimeoutErrors2WeeksH;
    public final int unexpectedErrors;
    public final int unexpectedErrors15Min;
    public final int unexpectedErrors15MinH;
    public final int unexpectedErrors1Day;
    public final int unexpectedErrors1DayH;
    public final int unexpectedErrors1Hour;
    public final int unexpectedErrors1HourH;
    public final int unexpectedErrors1Week;
    public final int unexpectedErrors1WeekH;
    public final int unexpectedErrors2Weeks;
    public final int unexpectedErrors2WeeksH;

    private UcsComputePCIeFatalCompletionStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computePCIeFatalCompletionStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        AbortErrors = builder.AbortErrors;
        AbortErrors15Min = builder.AbortErrors15Min;
        AbortErrors15MinH = builder.AbortErrors15MinH;
        AbortErrors1Day = builder.AbortErrors1Day;
        AbortErrors1DayH = builder.AbortErrors1DayH;
        AbortErrors1Hour = builder.AbortErrors1Hour;
        AbortErrors1HourH = builder.AbortErrors1HourH;
        AbortErrors1Week = builder.AbortErrors1Week;
        AbortErrors1WeekH = builder.AbortErrors1WeekH;
        AbortErrors2Weeks = builder.AbortErrors2Weeks;
        AbortErrors2WeeksH = builder.AbortErrors2WeeksH;
        TimeoutErrors = builder.TimeoutErrors;
        TimeoutErrors15Min = builder.TimeoutErrors15Min;
        TimeoutErrors15MinH = builder.TimeoutErrors15MinH;
        TimeoutErrors1Day = builder.TimeoutErrors1Day;
        TimeoutErrors1DayH = builder.TimeoutErrors1DayH;
        TimeoutErrors1Hour = builder.TimeoutErrors1Hour;
        TimeoutErrors1HourH = builder.TimeoutErrors1HourH;
        TimeoutErrors1Week = builder.TimeoutErrors1Week;
        TimeoutErrors1WeekH = builder.TimeoutErrors1WeekH;
        TimeoutErrors2Weeks = builder.TimeoutErrors2Weeks;
        TimeoutErrors2WeeksH = builder.TimeoutErrors2WeeksH;
        unexpectedErrors = builder.unexpectedErrors;
        unexpectedErrors15Min = builder.unexpectedErrors15Min;
        unexpectedErrors15MinH = builder.unexpectedErrors15MinH;
        unexpectedErrors1Day = builder.unexpectedErrors1Day;
        unexpectedErrors1DayH = builder.unexpectedErrors1DayH;
        unexpectedErrors1Hour = builder.unexpectedErrors1Hour;
        unexpectedErrors1HourH = builder.unexpectedErrors1HourH;
        unexpectedErrors1Week = builder.unexpectedErrors1Week;
        unexpectedErrors1WeekH = builder.unexpectedErrors1WeekH;
        unexpectedErrors2Weeks = builder.unexpectedErrors2Weeks;
        unexpectedErrors2WeeksH = builder.unexpectedErrors2WeeksH;
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

        private int AbortErrors;
        private int AbortErrors15Min;
        private int AbortErrors15MinH;
        private int AbortErrors1Day;
        private int AbortErrors1DayH;
        private int AbortErrors1Hour;
        private int AbortErrors1HourH;
        private int AbortErrors1Week;
        private int AbortErrors1WeekH;
        private int AbortErrors2Weeks;
        private int AbortErrors2WeeksH;
        private int TimeoutErrors;
        private int TimeoutErrors15Min;
        private int TimeoutErrors15MinH;
        private int TimeoutErrors1Day;
        private int TimeoutErrors1DayH;
        private int TimeoutErrors1Hour;
        private int TimeoutErrors1HourH;
        private int TimeoutErrors1Week;
        private int TimeoutErrors1WeekH;
        private int TimeoutErrors2Weeks;
        private int TimeoutErrors2WeeksH;
        private int unexpectedErrors;
        private int unexpectedErrors15Min;
        private int unexpectedErrors15MinH;
        private int unexpectedErrors1Day;
        private int unexpectedErrors1DayH;
        private int unexpectedErrors1Hour;
        private int unexpectedErrors1HourH;
        private int unexpectedErrors1Week;
        private int unexpectedErrors1WeekH;
        private int unexpectedErrors2Weeks;
        private int unexpectedErrors2WeeksH;

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

        public Builder withAbortErrors(int AbortErrors){
            this.AbortErrors = AbortErrors;
            return this;
        }

        public Builder withAbortErrors15Min(int AbortErrors15Min){
            this.AbortErrors15Min = AbortErrors15Min;
            return this;
        }

        public Builder withAbortErrors15MinH(int AbortErrors15MinH){
            this.AbortErrors15MinH = AbortErrors15MinH;
            return this;
        }

        public Builder withAbortErrors1Day(int AbortErrors1Day){
            this.AbortErrors1Day = AbortErrors1Day;
            return this;
        }

        public Builder withAbortErrors1DayH(int AbortErrors1DayH){
            this.AbortErrors1DayH = AbortErrors1DayH;
            return this;
        }

        public Builder withAbortErrors1Hour(int AbortErrors1Hour){
            this.AbortErrors1Hour = AbortErrors1Hour;
            return this;
        }

        public Builder withAbortErrors1HourH(int AbortErrors1HourH){
            this.AbortErrors1HourH = AbortErrors1HourH;
            return this;
        }

        public Builder withAbortErrors1Week(int AbortErrors1Week){
            this.AbortErrors1Week = AbortErrors1Week;
            return this;
        }

        public Builder withAbortErrors1WeekH(int AbortErrors1WeekH){
            this.AbortErrors1WeekH = AbortErrors1WeekH;
            return this;
        }

        public Builder withAbortErrors2Weeks(int AbortErrors2Weeks){
            this.AbortErrors2Weeks = AbortErrors2Weeks;
            return this;
        }

        public Builder withAbortErrors2WeeksH(int AbortErrors2WeeksH){
            this.AbortErrors2WeeksH = AbortErrors2WeeksH;
            return this;
        }

        public Builder withTimeoutErrors(int TimeoutErrors){
            this.TimeoutErrors = TimeoutErrors;
            return this;
        }

        public Builder withTimeoutErrors15Min(int TimeoutErrors15Min){
            this.TimeoutErrors15Min = TimeoutErrors15Min;
            return this;
        }

        public Builder withTimeoutErrors15MinH(int TimeoutErrors15MinH){
            this.TimeoutErrors15MinH = TimeoutErrors15MinH;
            return this;
        }

        public Builder withTimeoutErrors1Day(int TimeoutErrors1Day){
            this.TimeoutErrors1Day = TimeoutErrors1Day;
            return this;
        }

        public Builder withTimeoutErrors1DayH(int TimeoutErrors1DayH){
            this.TimeoutErrors1DayH = TimeoutErrors1DayH;
            return this;
        }

        public Builder withTimeoutErrors1Hour(int TimeoutErrors1Hour){
            this.TimeoutErrors1Hour = TimeoutErrors1Hour;
            return this;
        }

        public Builder withTimeoutErrors1HourH(int TimeoutErrors1HourH){
            this.TimeoutErrors1HourH = TimeoutErrors1HourH;
            return this;
        }

        public Builder withTimeoutErrors1Week(int TimeoutErrors1Week){
            this.TimeoutErrors1Week = TimeoutErrors1Week;
            return this;
        }

        public Builder withTimeoutErrors1WeekH(int TimeoutErrors1WeekH){
            this.TimeoutErrors1WeekH = TimeoutErrors1WeekH;
            return this;
        }

        public Builder withTimeoutErrors2Weeks(int TimeoutErrors2Weeks){
            this.TimeoutErrors2Weeks = TimeoutErrors2Weeks;
            return this;
        }

        public Builder withTimeoutErrors2WeeksH(int TimeoutErrors2WeeksH){
            this.TimeoutErrors2WeeksH = TimeoutErrors2WeeksH;
            return this;
        }

        public Builder withunexpectedErrors(int unexpectedErrors){
            this.unexpectedErrors = unexpectedErrors;
            return this;
        }

        public Builder withunexpectedErrors15Min(int unexpectedErrors15Min){
            this.unexpectedErrors15Min = unexpectedErrors15Min;
            return this;
        }

        public Builder withunexpectedErrors15MinH(int unexpectedErrors15MinH){
            this.unexpectedErrors15MinH = unexpectedErrors15MinH;
            return this;
        }

        public Builder withunexpectedErrors1Day(int unexpectedErrors1Day){
            this.unexpectedErrors1Day = unexpectedErrors1Day;
            return this;
        }

        public Builder withunexpectedErrors1DayH(int unexpectedErrors1DayH){
            this.unexpectedErrors1DayH = unexpectedErrors1DayH;
            return this;
        }

        public Builder withunexpectedErrors1Hour(int unexpectedErrors1Hour){
            this.unexpectedErrors1Hour = unexpectedErrors1Hour;
            return this;
        }

        public Builder withunexpectedErrors1HourH(int unexpectedErrors1HourH){
            this.unexpectedErrors1HourH = unexpectedErrors1HourH;
            return this;
        }

        public Builder withunexpectedErrors1Week(int unexpectedErrors1Week){
            this.unexpectedErrors1Week = unexpectedErrors1Week;
            return this;
        }

        public Builder withunexpectedErrors1WeekH(int unexpectedErrors1WeekH){
            this.unexpectedErrors1WeekH = unexpectedErrors1WeekH;
            return this;
        }

        public Builder withunexpectedErrors2Weeks(int unexpectedErrors2Weeks){
            this.unexpectedErrors2Weeks = unexpectedErrors2Weeks;
            return this;
        }

        public Builder withunexpectedErrors2WeeksH(int unexpectedErrors2WeeksH){
            this.unexpectedErrors2WeeksH = unexpectedErrors2WeeksH;
            return this;
        }

        public UcsComputePCIeFatalCompletionStats build() {
            return new UcsComputePCIeFatalCompletionStats(this);
        }
    }
}
