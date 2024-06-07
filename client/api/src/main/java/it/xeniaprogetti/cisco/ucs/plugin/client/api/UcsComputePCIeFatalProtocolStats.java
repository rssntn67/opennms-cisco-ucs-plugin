package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputePCIeFatalProtocolStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long dllpErrors;
    public final long dllpErrors15Min;
    public final long dllpErrors15MinH;
    public final long dllpErrors1Day;
    public final long dllpErrors1DayH;
    public final long dllpErrors1Hour;
    public final long dllpErrors1HourH;
    public final long dllpErrors1Week;
    public final long dllpErrors1WeekH;
    public final long dllpErrors2Weeks;
    public final long dllpErrors2WeeksH;
    public final long flowControlErrors;
    public final long flowControlErrors15Min;
    public final long flowControlErrors15MinH;
    public final long flowControlErrors1Day;
    public final long flowControlErrors1DayH;
    public final long flowControlErrors1Hour;
    public final long flowControlErrors1HourH;
    public final long flowControlErrors1Week;
    public final long flowControlErrors1WeekH;
    public final long flowControlErrors2Weeks;
    public final long flowControlErrors2WeeksH;

    private UcsComputePCIeFatalProtocolStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computePCIeFatalProtocolStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        dllpErrors = builder.dllpErrors;
        dllpErrors15Min = builder.dllpErrors15Min;
        dllpErrors15MinH = builder.dllpErrors15MinH;
        dllpErrors1Day = builder.dllpErrors1Day;
        dllpErrors1DayH = builder.dllpErrors1DayH;
        dllpErrors1Hour = builder.dllpErrors1Hour;
        dllpErrors1HourH = builder.dllpErrors1HourH;
        dllpErrors1Week = builder.dllpErrors1Week;
        dllpErrors1WeekH = builder.dllpErrors1WeekH;
        dllpErrors2Weeks = builder.dllpErrors2Weeks;
        dllpErrors2WeeksH = builder.dllpErrors2WeeksH;
        flowControlErrors = builder.flowControlErrors;
        flowControlErrors15Min = builder.flowControlErrors15Min;
        flowControlErrors15MinH = builder.flowControlErrors15MinH;
        flowControlErrors1Day = builder.flowControlErrors1Day;
        flowControlErrors1DayH = builder.flowControlErrors1DayH;
        flowControlErrors1Hour = builder.flowControlErrors1Hour;
        flowControlErrors1HourH = builder.flowControlErrors1HourH;
        flowControlErrors1Week = builder.flowControlErrors1Week;
        flowControlErrors1WeekH = builder.flowControlErrors1WeekH;
        flowControlErrors2Weeks = builder.flowControlErrors2Weeks;
        flowControlErrors2WeeksH = builder.flowControlErrors2WeeksH;
    }

    @Override
    public String toString() {
        return "UcsComputePCIeFatalProtocolStats{" +
                "dllpErrors=" + dllpErrors +
                ", dllpErrors15Min=" + dllpErrors15Min +
                ", dllpErrors15MinH=" + dllpErrors15MinH +
                ", dllpErrors1Day=" + dllpErrors1Day +
                ", dllpErrors1DayH=" + dllpErrors1DayH +
                ", dllpErrors1Hour=" + dllpErrors1Hour +
                ", dllpErrors1HourH=" + dllpErrors1HourH +
                ", dllpErrors1Week=" + dllpErrors1Week +
                ", dllpErrors1WeekH=" + dllpErrors1WeekH +
                ", dllpErrors2Weeks=" + dllpErrors2Weeks +
                ", dllpErrors2WeeksH=" + dllpErrors2WeeksH +
                ", flowControlErrors=" + flowControlErrors +
                ", flowControlErrors15Min=" + flowControlErrors15Min +
                ", flowControlErrors15MinH=" + flowControlErrors15MinH +
                ", flowControlErrors1Day=" + flowControlErrors1Day +
                ", flowControlErrors1DayH=" + flowControlErrors1DayH +
                ", flowControlErrors1Hour=" + flowControlErrors1Hour +
                ", flowControlErrors1HourH=" + flowControlErrors1HourH +
                ", flowControlErrors1Week=" + flowControlErrors1Week +
                ", flowControlErrors1WeekH=" + flowControlErrors1WeekH +
                ", flowControlErrors2Weeks=" + flowControlErrors2Weeks +
                ", flowControlErrors2WeeksH=" + flowControlErrors2WeeksH +
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

        private long dllpErrors;
        private long dllpErrors15Min;
        private long dllpErrors15MinH;
        private long dllpErrors1Day;
        private long dllpErrors1DayH;
        private long dllpErrors1Hour;
        private long dllpErrors1HourH;
        private long dllpErrors1Week;
        private long dllpErrors1WeekH;
        private long dllpErrors2Weeks;
        private long dllpErrors2WeeksH;
        private long flowControlErrors;
        private long flowControlErrors15Min;
        private long flowControlErrors15MinH;
        private long flowControlErrors1Day;
        private long flowControlErrors1DayH;
        private long flowControlErrors1Hour;
        private long flowControlErrors1HourH;
        private long flowControlErrors1Week;
        private long flowControlErrors1WeekH;
        private long flowControlErrors2Weeks;
        private long flowControlErrors2WeeksH;

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

        public Builder withdllpErrors(long dllpErrors){
            this.dllpErrors = dllpErrors;
            return this;
        }

        public Builder withdllpErrors15Min(long dllpErrors15Min){
            this.dllpErrors15Min = dllpErrors15Min;
            return this;
        }

        public Builder withdllpErrors15MinH(long dllpErrors15MinH){
            this.dllpErrors15MinH = dllpErrors15MinH;
            return this;
        }

        public Builder withdllpErrors1Day(long dllpErrors1Day){
            this.dllpErrors1Day = dllpErrors1Day;
            return this;
        }

        public Builder withdllpErrors1DayH(long dllpErrors1DayH){
            this.dllpErrors1DayH = dllpErrors1DayH;
            return this;
        }

        public Builder withdllpErrors1Hour(long dllpErrors1Hour){
            this.dllpErrors1Hour = dllpErrors1Hour;
            return this;
        }

        public Builder withdllpErrors1HourH(long dllpErrors1HourH){
            this.dllpErrors1HourH = dllpErrors1HourH;
            return this;
        }

        public Builder withdllpErrors1Week(long dllpErrors1Week){
            this.dllpErrors1Week = dllpErrors1Week;
            return this;
        }

        public Builder withdllpErrors1WeekH(long dllpErrors1WeekH){
            this.dllpErrors1WeekH = dllpErrors1WeekH;
            return this;
        }

        public Builder withdllpErrors2Weeks(long dllpErrors2Weeks){
            this.dllpErrors2Weeks = dllpErrors2Weeks;
            return this;
        }

        public Builder withdllpErrors2WeeksH(long dllpErrors2WeeksH){
            this.dllpErrors2WeeksH = dllpErrors2WeeksH;
            return this;
        }

        public Builder withflowControlErrors(long flowControlErrors){
            this.flowControlErrors = flowControlErrors;
            return this;
        }

        public Builder withflowControlErrors15Min(long flowControlErrors15Min){
            this.flowControlErrors15Min = flowControlErrors15Min;
            return this;
        }

        public Builder withflowControlErrors15MinH(long flowControlErrors15MinH){
            this.flowControlErrors15MinH = flowControlErrors15MinH;
            return this;
        }

        public Builder withflowControlErrors1Day(long flowControlErrors1Day){
            this.flowControlErrors1Day = flowControlErrors1Day;
            return this;
        }

        public Builder withflowControlErrors1DayH(long flowControlErrors1DayH){
            this.flowControlErrors1DayH = flowControlErrors1DayH;
            return this;
        }

        public Builder withflowControlErrors1Hour(long flowControlErrors1Hour){
            this.flowControlErrors1Hour = flowControlErrors1Hour;
            return this;
        }

        public Builder withflowControlErrors1HourH(long flowControlErrors1HourH){
            this.flowControlErrors1HourH = flowControlErrors1HourH;
            return this;
        }

        public Builder withflowControlErrors1Week(long flowControlErrors1Week){
            this.flowControlErrors1Week = flowControlErrors1Week;
            return this;
        }

        public Builder withflowControlErrors1WeekH(long flowControlErrors1WeekH){
            this.flowControlErrors1WeekH = flowControlErrors1WeekH;
            return this;
        }

        public Builder withflowControlErrors2Weeks(long flowControlErrors2Weeks){
            this.flowControlErrors2Weeks = flowControlErrors2Weeks;
            return this;
        }

        public Builder withflowControlErrors2WeeksH(long flowControlErrors2WeeksH){
            this.flowControlErrors2WeeksH = flowControlErrors2WeeksH;
            return this;
        }

        public UcsComputePCIeFatalProtocolStats build() {
            return new UcsComputePCIeFatalProtocolStats(this);
        }
    }
}
