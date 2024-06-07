package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsProcessorErrorStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long CorrectableLinkCRCErrors;
    public final long CorrectableLinkCRCErrors15Min;
    public final long CorrectableLinkCRCErrors15MinH;
    public final long CorrectableLinkCRCErrors1Day;
    public final long CorrectableLinkCRCErrors1DayH;
    public final long CorrectableLinkCRCErrors1Hour;
    public final long CorrectableLinkCRCErrors1HourH;
    public final long CorrectableLinkCRCErrors1Week;
    public final long CorrectableLinkCRCErrors1WeekH;
    public final long CorrectableLinkCRCErrors2Weeks;
    public final long CorrectableLinkCRCErrors2WeeksH;
    public final long UncorrectableLinkCRCErrors;
    public final long UncorrectableLinkCRCErrors15Min;
    public final long UncorrectableLinkCRCErrors15MinH;
    public final long UncorrectableLinkCRCErrors1Day;
    public final long UncorrectableLinkCRCErrors1DayH;
    public final long UncorrectableLinkCRCErrors1Hour;
    public final long UncorrectableLinkCRCErrors1HourH;
    public final long UncorrectableLinkCRCErrors1Week;
    public final long UncorrectableLinkCRCErrors1WeekH;
    public final long UncorrectableLinkCRCErrors2Weeks;
    public final long UncorrectableLinkCRCErrors2WeeksH;
    public final long mirroringInterSockErrors;
    public final long mirroringInterSockErrors15Min;
    public final long mirroringInterSockErrors15MinH;
    public final long mirroringInterSockErrors1Day;
    public final long mirroringInterSockErrors1DayH;
    public final long mirroringInterSockErrors1Hour;
    public final long mirroringInterSockErrors1HourH;
    public final long mirroringInterSockErrors1Week;
    public final long mirroringInterSockErrors1WeekH;
    public final long mirroringInterSockErrors2Weeks;
    public final long mirroringInterSockErrors2WeeksH;
    public final long mirroringIntraSockErrors;
    public final long mirroringIntraSockErrors15Min;
    public final long mirroringIntraSockErrors15MinH;
    public final long mirroringIntraSockErrors1Day;
    public final long mirroringIntraSockErrors1DayH;
    public final long mirroringIntraSockErrors1Hour;
    public final long mirroringIntraSockErrors1HourH;
    public final long mirroringIntraSockErrors1Week;
    public final long mirroringIntraSockErrors1WeekH;
    public final long mirroringIntraSockErrors2Weeks;
    public final long mirroringIntraSockErrors2WeeksH;
    public final long smiLinkCorrErrors;
    public final long smiLinkCorrErrors15Min;
    public final long smiLinkCorrErrors15MinH;
    public final long smiLinkCorrErrors1Day;
    public final long smiLinkCorrErrors1DayH;
    public final long smiLinkCorrErrors1Hour;
    public final long smiLinkCorrErrors1HourH;
    public final long smiLinkCorrErrors1Week;
    public final long smiLinkCorrErrors1WeekH;
    public final long smiLinkCorrErrors2Weeks;
    public final long smiLinkCorrErrors2WeeksH;
    public final long smiLinkUncorrErrors;
    public final long smiLinkUncorrErrors15Min;
    public final long smiLinkUncorrErrors15MinH;
    public final long smiLinkUncorrErrors1Day;
    public final long smiLinkUncorrErrors1DayH;
    public final long smiLinkUncorrErrors1Hour;
    public final long smiLinkUncorrErrors1HourH;
    public final long smiLinkUncorrErrors1Week;
    public final long smiLinkUncorrErrors1WeekH;
    public final long smiLinkUncorrErrors2Weeks;
    public final long smiLinkUncorrErrors2WeeksH;
    public final long sparingErrors;
    public final long sparingErrors15Min;
    public final long sparingErrors15MinH;
    public final long sparingErrors1Day;
    public final long sparingErrors1DayH;
    public final long sparingErrors1Hour;
    public final long sparingErrors1HourH;
    public final long sparingErrors1Week;
    public final long sparingErrors1WeekH;
    public final long sparingErrors2Weeks;
    public final long sparingErrors2WeeksH;

    private UcsProcessorErrorStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.processorErrorStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        CorrectableLinkCRCErrors = builder.CorrectableLinkCRCErrors;
        CorrectableLinkCRCErrors15Min = builder.CorrectableLinkCRCErrors15Min;
        CorrectableLinkCRCErrors15MinH = builder.CorrectableLinkCRCErrors15MinH;
        CorrectableLinkCRCErrors1Day = builder.CorrectableLinkCRCErrors1Day;
        CorrectableLinkCRCErrors1DayH = builder.CorrectableLinkCRCErrors1DayH;
        CorrectableLinkCRCErrors1Hour = builder.CorrectableLinkCRCErrors1Hour;
        CorrectableLinkCRCErrors1HourH = builder.CorrectableLinkCRCErrors1HourH;
        CorrectableLinkCRCErrors1Week = builder.CorrectableLinkCRCErrors1Week;
        CorrectableLinkCRCErrors1WeekH = builder.CorrectableLinkCRCErrors1WeekH;
        CorrectableLinkCRCErrors2Weeks = builder.CorrectableLinkCRCErrors2Weeks;
        CorrectableLinkCRCErrors2WeeksH = builder.CorrectableLinkCRCErrors2WeeksH;
        UncorrectableLinkCRCErrors = builder.UncorrectableLinkCRCErrors;
        UncorrectableLinkCRCErrors15Min = builder.UncorrectableLinkCRCErrors15Min;
        UncorrectableLinkCRCErrors15MinH = builder.UncorrectableLinkCRCErrors15MinH;
        UncorrectableLinkCRCErrors1Day = builder.UncorrectableLinkCRCErrors1Day;
        UncorrectableLinkCRCErrors1DayH = builder.UncorrectableLinkCRCErrors1DayH;
        UncorrectableLinkCRCErrors1Hour = builder.UncorrectableLinkCRCErrors1Hour;
        UncorrectableLinkCRCErrors1HourH = builder.UncorrectableLinkCRCErrors1HourH;
        UncorrectableLinkCRCErrors1Week = builder.UncorrectableLinkCRCErrors1Week;
        UncorrectableLinkCRCErrors1WeekH = builder.UncorrectableLinkCRCErrors1WeekH;
        UncorrectableLinkCRCErrors2Weeks = builder.UncorrectableLinkCRCErrors2Weeks;
        UncorrectableLinkCRCErrors2WeeksH = builder.UncorrectableLinkCRCErrors2WeeksH;
        mirroringInterSockErrors = builder.mirroringInterSockErrors;
        mirroringInterSockErrors15Min = builder.mirroringInterSockErrors15Min;
        mirroringInterSockErrors15MinH = builder.mirroringInterSockErrors15MinH;
        mirroringInterSockErrors1Day = builder.mirroringInterSockErrors1Day;
        mirroringInterSockErrors1DayH = builder.mirroringInterSockErrors1DayH;
        mirroringInterSockErrors1Hour = builder.mirroringInterSockErrors1Hour;
        mirroringInterSockErrors1HourH = builder.mirroringInterSockErrors1HourH;
        mirroringInterSockErrors1Week = builder.mirroringInterSockErrors1Week;
        mirroringInterSockErrors1WeekH = builder.mirroringInterSockErrors1WeekH;
        mirroringInterSockErrors2Weeks = builder.mirroringInterSockErrors2Weeks;
        mirroringInterSockErrors2WeeksH = builder.mirroringInterSockErrors2WeeksH;
        mirroringIntraSockErrors = builder.mirroringIntraSockErrors;
        mirroringIntraSockErrors15Min = builder.mirroringIntraSockErrors15Min;
        mirroringIntraSockErrors15MinH = builder.mirroringIntraSockErrors15MinH;
        mirroringIntraSockErrors1Day = builder.mirroringIntraSockErrors1Day;
        mirroringIntraSockErrors1DayH = builder.mirroringIntraSockErrors1DayH;
        mirroringIntraSockErrors1Hour = builder.mirroringIntraSockErrors1Hour;
        mirroringIntraSockErrors1HourH = builder.mirroringIntraSockErrors1HourH;
        mirroringIntraSockErrors1Week = builder.mirroringIntraSockErrors1Week;
        mirroringIntraSockErrors1WeekH = builder.mirroringIntraSockErrors1WeekH;
        mirroringIntraSockErrors2Weeks = builder.mirroringIntraSockErrors2Weeks;
        mirroringIntraSockErrors2WeeksH = builder.mirroringIntraSockErrors2WeeksH;
        smiLinkCorrErrors = builder.smiLinkCorrErrors;
        smiLinkCorrErrors15Min = builder.smiLinkCorrErrors15Min;
        smiLinkCorrErrors15MinH = builder.smiLinkCorrErrors15MinH;
        smiLinkCorrErrors1Day = builder.smiLinkCorrErrors1Day;
        smiLinkCorrErrors1DayH = builder.smiLinkCorrErrors1DayH;
        smiLinkCorrErrors1Hour = builder.smiLinkCorrErrors1Hour;
        smiLinkCorrErrors1HourH = builder.smiLinkCorrErrors1HourH;
        smiLinkCorrErrors1Week = builder.smiLinkCorrErrors1Week;
        smiLinkCorrErrors1WeekH = builder.smiLinkCorrErrors1WeekH;
        smiLinkCorrErrors2Weeks = builder.smiLinkCorrErrors2Weeks;
        smiLinkCorrErrors2WeeksH = builder.smiLinkCorrErrors2WeeksH;
        smiLinkUncorrErrors = builder.smiLinkUncorrErrors;
        smiLinkUncorrErrors15Min = builder.smiLinkUncorrErrors15Min;
        smiLinkUncorrErrors15MinH = builder.smiLinkUncorrErrors15MinH;
        smiLinkUncorrErrors1Day = builder.smiLinkUncorrErrors1Day;
        smiLinkUncorrErrors1DayH = builder.smiLinkUncorrErrors1DayH;
        smiLinkUncorrErrors1Hour = builder.smiLinkUncorrErrors1Hour;
        smiLinkUncorrErrors1HourH = builder.smiLinkUncorrErrors1HourH;
        smiLinkUncorrErrors1Week = builder.smiLinkUncorrErrors1Week;
        smiLinkUncorrErrors1WeekH = builder.smiLinkUncorrErrors1WeekH;
        smiLinkUncorrErrors2Weeks = builder.smiLinkUncorrErrors2Weeks;
        smiLinkUncorrErrors2WeeksH = builder.smiLinkUncorrErrors2WeeksH;
        sparingErrors = builder.sparingErrors;
        sparingErrors15Min = builder.sparingErrors15Min;
        sparingErrors15MinH = builder.sparingErrors15MinH;
        sparingErrors1Day = builder.sparingErrors1Day;
        sparingErrors1DayH = builder.sparingErrors1DayH;
        sparingErrors1Hour = builder.sparingErrors1Hour;
        sparingErrors1HourH = builder.sparingErrors1HourH;
        sparingErrors1Week = builder.sparingErrors1Week;
        sparingErrors1WeekH = builder.sparingErrors1WeekH;
        sparingErrors2Weeks = builder.sparingErrors2Weeks;
        sparingErrors2WeeksH = builder.sparingErrors2WeeksH;
    }

    @Override
    public String toString() {
        return "UcsProcessorErrorStats{" +
                "CorrectableLinkCRCErrors=" + CorrectableLinkCRCErrors +
                ", CorrectableLinkCRCErrors15Min=" + CorrectableLinkCRCErrors15Min +
                ", CorrectableLinkCRCErrors15MinH=" + CorrectableLinkCRCErrors15MinH +
                ", CorrectableLinkCRCErrors1Day=" + CorrectableLinkCRCErrors1Day +
                ", CorrectableLinkCRCErrors1DayH=" + CorrectableLinkCRCErrors1DayH +
                ", CorrectableLinkCRCErrors1Hour=" + CorrectableLinkCRCErrors1Hour +
                ", CorrectableLinkCRCErrors1HourH=" + CorrectableLinkCRCErrors1HourH +
                ", CorrectableLinkCRCErrors1Week=" + CorrectableLinkCRCErrors1Week +
                ", CorrectableLinkCRCErrors1WeekH=" + CorrectableLinkCRCErrors1WeekH +
                ", CorrectableLinkCRCErrors2Weeks=" + CorrectableLinkCRCErrors2Weeks +
                ", CorrectableLinkCRCErrors2WeeksH=" + CorrectableLinkCRCErrors2WeeksH +
                ", UncorrectableLinkCRCErrors=" + UncorrectableLinkCRCErrors +
                ", UncorrectableLinkCRCErrors15Min=" + UncorrectableLinkCRCErrors15Min +
                ", UncorrectableLinkCRCErrors15MinH=" + UncorrectableLinkCRCErrors15MinH +
                ", UncorrectableLinkCRCErrors1Day=" + UncorrectableLinkCRCErrors1Day +
                ", UncorrectableLinkCRCErrors1DayH=" + UncorrectableLinkCRCErrors1DayH +
                ", UncorrectableLinkCRCErrors1Hour=" + UncorrectableLinkCRCErrors1Hour +
                ", UncorrectableLinkCRCErrors1HourH=" + UncorrectableLinkCRCErrors1HourH +
                ", UncorrectableLinkCRCErrors1Week=" + UncorrectableLinkCRCErrors1Week +
                ", UncorrectableLinkCRCErrors1WeekH=" + UncorrectableLinkCRCErrors1WeekH +
                ", UncorrectableLinkCRCErrors2Weeks=" + UncorrectableLinkCRCErrors2Weeks +
                ", UncorrectableLinkCRCErrors2WeeksH=" + UncorrectableLinkCRCErrors2WeeksH +
                ", mirroringInterSockErrors=" + mirroringInterSockErrors +
                ", mirroringInterSockErrors15Min=" + mirroringInterSockErrors15Min +
                ", mirroringInterSockErrors15MinH=" + mirroringInterSockErrors15MinH +
                ", mirroringInterSockErrors1Day=" + mirroringInterSockErrors1Day +
                ", mirroringInterSockErrors1DayH=" + mirroringInterSockErrors1DayH +
                ", mirroringInterSockErrors1Hour=" + mirroringInterSockErrors1Hour +
                ", mirroringInterSockErrors1HourH=" + mirroringInterSockErrors1HourH +
                ", mirroringInterSockErrors1Week=" + mirroringInterSockErrors1Week +
                ", mirroringInterSockErrors1WeekH=" + mirroringInterSockErrors1WeekH +
                ", mirroringInterSockErrors2Weeks=" + mirroringInterSockErrors2Weeks +
                ", mirroringInterSockErrors2WeeksH=" + mirroringInterSockErrors2WeeksH +
                ", mirroringIntraSockErrors=" + mirroringIntraSockErrors +
                ", mirroringIntraSockErrors15Min=" + mirroringIntraSockErrors15Min +
                ", mirroringIntraSockErrors15MinH=" + mirroringIntraSockErrors15MinH +
                ", mirroringIntraSockErrors1Day=" + mirroringIntraSockErrors1Day +
                ", mirroringIntraSockErrors1DayH=" + mirroringIntraSockErrors1DayH +
                ", mirroringIntraSockErrors1Hour=" + mirroringIntraSockErrors1Hour +
                ", mirroringIntraSockErrors1HourH=" + mirroringIntraSockErrors1HourH +
                ", mirroringIntraSockErrors1Week=" + mirroringIntraSockErrors1Week +
                ", mirroringIntraSockErrors1WeekH=" + mirroringIntraSockErrors1WeekH +
                ", mirroringIntraSockErrors2Weeks=" + mirroringIntraSockErrors2Weeks +
                ", mirroringIntraSockErrors2WeeksH=" + mirroringIntraSockErrors2WeeksH +
                ", smiLinkCorrErrors=" + smiLinkCorrErrors +
                ", smiLinkCorrErrors15Min=" + smiLinkCorrErrors15Min +
                ", smiLinkCorrErrors15MinH=" + smiLinkCorrErrors15MinH +
                ", smiLinkCorrErrors1Day=" + smiLinkCorrErrors1Day +
                ", smiLinkCorrErrors1DayH=" + smiLinkCorrErrors1DayH +
                ", smiLinkCorrErrors1Hour=" + smiLinkCorrErrors1Hour +
                ", smiLinkCorrErrors1HourH=" + smiLinkCorrErrors1HourH +
                ", smiLinkCorrErrors1Week=" + smiLinkCorrErrors1Week +
                ", smiLinkCorrErrors1WeekH=" + smiLinkCorrErrors1WeekH +
                ", smiLinkCorrErrors2Weeks=" + smiLinkCorrErrors2Weeks +
                ", smiLinkCorrErrors2WeeksH=" + smiLinkCorrErrors2WeeksH +
                ", smiLinkUncorrErrors=" + smiLinkUncorrErrors +
                ", smiLinkUncorrErrors15Min=" + smiLinkUncorrErrors15Min +
                ", smiLinkUncorrErrors15MinH=" + smiLinkUncorrErrors15MinH +
                ", smiLinkUncorrErrors1Day=" + smiLinkUncorrErrors1Day +
                ", smiLinkUncorrErrors1DayH=" + smiLinkUncorrErrors1DayH +
                ", smiLinkUncorrErrors1Hour=" + smiLinkUncorrErrors1Hour +
                ", smiLinkUncorrErrors1HourH=" + smiLinkUncorrErrors1HourH +
                ", smiLinkUncorrErrors1Week=" + smiLinkUncorrErrors1Week +
                ", smiLinkUncorrErrors1WeekH=" + smiLinkUncorrErrors1WeekH +
                ", smiLinkUncorrErrors2Weeks=" + smiLinkUncorrErrors2Weeks +
                ", smiLinkUncorrErrors2WeeksH=" + smiLinkUncorrErrors2WeeksH +
                ", sparingErrors=" + sparingErrors +
                ", sparingErrors15Min=" + sparingErrors15Min +
                ", sparingErrors15MinH=" + sparingErrors15MinH +
                ", sparingErrors1Day=" + sparingErrors1Day +
                ", sparingErrors1DayH=" + sparingErrors1DayH +
                ", sparingErrors1Hour=" + sparingErrors1Hour +
                ", sparingErrors1HourH=" + sparingErrors1HourH +
                ", sparingErrors1Week=" + sparingErrors1Week +
                ", sparingErrors1WeekH=" + sparingErrors1WeekH +
                ", sparingErrors2Weeks=" + sparingErrors2Weeks +
                ", sparingErrors2WeeksH=" + sparingErrors2WeeksH +
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

        private long CorrectableLinkCRCErrors;
        private long CorrectableLinkCRCErrors15Min;
        private long CorrectableLinkCRCErrors15MinH;
        private long CorrectableLinkCRCErrors1Day;
        private long CorrectableLinkCRCErrors1DayH;
        private long CorrectableLinkCRCErrors1Hour;
        private long CorrectableLinkCRCErrors1HourH;
        private long CorrectableLinkCRCErrors1Week;
        private long CorrectableLinkCRCErrors1WeekH;
        private long CorrectableLinkCRCErrors2Weeks;
        private long CorrectableLinkCRCErrors2WeeksH;
        private long UncorrectableLinkCRCErrors;
        private long UncorrectableLinkCRCErrors15Min;
        private long UncorrectableLinkCRCErrors15MinH;
        private long UncorrectableLinkCRCErrors1Day;
        private long UncorrectableLinkCRCErrors1DayH;
        private long UncorrectableLinkCRCErrors1Hour;
        private long UncorrectableLinkCRCErrors1HourH;
        private long UncorrectableLinkCRCErrors1Week;
        private long UncorrectableLinkCRCErrors1WeekH;
        private long UncorrectableLinkCRCErrors2Weeks;
        private long UncorrectableLinkCRCErrors2WeeksH;
        private long mirroringInterSockErrors;
        private long mirroringInterSockErrors15Min;
        private long mirroringInterSockErrors15MinH;
        private long mirroringInterSockErrors1Day;
        private long mirroringInterSockErrors1DayH;
        private long mirroringInterSockErrors1Hour;
        private long mirroringInterSockErrors1HourH;
        private long mirroringInterSockErrors1Week;
        private long mirroringInterSockErrors1WeekH;
        private long mirroringInterSockErrors2Weeks;
        private long mirroringInterSockErrors2WeeksH;
        private long mirroringIntraSockErrors;
        private long mirroringIntraSockErrors15Min;
        private long mirroringIntraSockErrors15MinH;
        private long mirroringIntraSockErrors1Day;
        private long mirroringIntraSockErrors1DayH;
        private long mirroringIntraSockErrors1Hour;
        private long mirroringIntraSockErrors1HourH;
        private long mirroringIntraSockErrors1Week;
        private long mirroringIntraSockErrors1WeekH;
        private long mirroringIntraSockErrors2Weeks;
        private long mirroringIntraSockErrors2WeeksH;
        private long smiLinkCorrErrors;
        private long smiLinkCorrErrors15Min;
        private long smiLinkCorrErrors15MinH;
        private long smiLinkCorrErrors1Day;
        private long smiLinkCorrErrors1DayH;
        private long smiLinkCorrErrors1Hour;
        private long smiLinkCorrErrors1HourH;
        private long smiLinkCorrErrors1Week;
        private long smiLinkCorrErrors1WeekH;
        private long smiLinkCorrErrors2Weeks;
        private long smiLinkCorrErrors2WeeksH;
        private long smiLinkUncorrErrors;
        private long smiLinkUncorrErrors15Min;
        private long smiLinkUncorrErrors15MinH;
        private long smiLinkUncorrErrors1Day;
        private long smiLinkUncorrErrors1DayH;
        private long smiLinkUncorrErrors1Hour;
        private long smiLinkUncorrErrors1HourH;
        private long smiLinkUncorrErrors1Week;
        private long smiLinkUncorrErrors1WeekH;
        private long smiLinkUncorrErrors2Weeks;
        private long smiLinkUncorrErrors2WeeksH;
        private long sparingErrors;
        private long sparingErrors15Min;
        private long sparingErrors15MinH;
        private long sparingErrors1Day;
        private long sparingErrors1DayH;
        private long sparingErrors1Hour;
        private long sparingErrors1HourH;
        private long sparingErrors1Week;
        private long sparingErrors1WeekH;
        private long sparingErrors2Weeks;
        private long sparingErrors2WeeksH;

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

        public Builder withCorrectableLinkCRCErrors(long CorrectableLinkCRCErrors){
            this.CorrectableLinkCRCErrors = CorrectableLinkCRCErrors;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors15Min(long CorrectableLinkCRCErrors15Min){
            this.CorrectableLinkCRCErrors15Min = CorrectableLinkCRCErrors15Min;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors15MinH(long CorrectableLinkCRCErrors15MinH){
            this.CorrectableLinkCRCErrors15MinH = CorrectableLinkCRCErrors15MinH;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors1Day(long CorrectableLinkCRCErrors1Day){
            this.CorrectableLinkCRCErrors1Day = CorrectableLinkCRCErrors1Day;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors1DayH(long CorrectableLinkCRCErrors1DayH){
            this.CorrectableLinkCRCErrors1DayH = CorrectableLinkCRCErrors1DayH;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors1Hour(long CorrectableLinkCRCErrors1Hour){
            this.CorrectableLinkCRCErrors1Hour = CorrectableLinkCRCErrors1Hour;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors1HourH(long CorrectableLinkCRCErrors1HourH){
            this.CorrectableLinkCRCErrors1HourH = CorrectableLinkCRCErrors1HourH;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors1Week(long CorrectableLinkCRCErrors1Week){
            this.CorrectableLinkCRCErrors1Week = CorrectableLinkCRCErrors1Week;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors1WeekH(long CorrectableLinkCRCErrors1WeekH){
            this.CorrectableLinkCRCErrors1WeekH = CorrectableLinkCRCErrors1WeekH;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors2Weeks(long CorrectableLinkCRCErrors2Weeks){
            this.CorrectableLinkCRCErrors2Weeks = CorrectableLinkCRCErrors2Weeks;
            return this;
        }

        public Builder withCorrectableLinkCRCErrors2WeeksH(long CorrectableLinkCRCErrors2WeeksH){
            this.CorrectableLinkCRCErrors2WeeksH = CorrectableLinkCRCErrors2WeeksH;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors(long UncorrectableLinkCRCErrors){
            this.UncorrectableLinkCRCErrors = UncorrectableLinkCRCErrors;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors15Min(long UncorrectableLinkCRCErrors15Min){
            this.UncorrectableLinkCRCErrors15Min = UncorrectableLinkCRCErrors15Min;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors15MinH(long UncorrectableLinkCRCErrors15MinH){
            this.UncorrectableLinkCRCErrors15MinH = UncorrectableLinkCRCErrors15MinH;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors1Day(long UncorrectableLinkCRCErrors1Day){
            this.UncorrectableLinkCRCErrors1Day = UncorrectableLinkCRCErrors1Day;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors1DayH(long UncorrectableLinkCRCErrors1DayH){
            this.UncorrectableLinkCRCErrors1DayH = UncorrectableLinkCRCErrors1DayH;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors1Hour(long UncorrectableLinkCRCErrors1Hour){
            this.UncorrectableLinkCRCErrors1Hour = UncorrectableLinkCRCErrors1Hour;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors1HourH(long UncorrectableLinkCRCErrors1HourH){
            this.UncorrectableLinkCRCErrors1HourH = UncorrectableLinkCRCErrors1HourH;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors1Week(long UncorrectableLinkCRCErrors1Week){
            this.UncorrectableLinkCRCErrors1Week = UncorrectableLinkCRCErrors1Week;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors1WeekH(long UncorrectableLinkCRCErrors1WeekH){
            this.UncorrectableLinkCRCErrors1WeekH = UncorrectableLinkCRCErrors1WeekH;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors2Weeks(long UncorrectableLinkCRCErrors2Weeks){
            this.UncorrectableLinkCRCErrors2Weeks = UncorrectableLinkCRCErrors2Weeks;
            return this;
        }

        public Builder withUncorrectableLinkCRCErrors2WeeksH(long UncorrectableLinkCRCErrors2WeeksH){
            this.UncorrectableLinkCRCErrors2WeeksH = UncorrectableLinkCRCErrors2WeeksH;
            return this;
        }

        public Builder withmirroringInterSockErrors(long mirroringInterSockErrors){
            this.mirroringInterSockErrors = mirroringInterSockErrors;
            return this;
        }

        public Builder withmirroringInterSockErrors15Min(long mirroringInterSockErrors15Min){
            this.mirroringInterSockErrors15Min = mirroringInterSockErrors15Min;
            return this;
        }

        public Builder withmirroringInterSockErrors15MinH(long mirroringInterSockErrors15MinH){
            this.mirroringInterSockErrors15MinH = mirroringInterSockErrors15MinH;
            return this;
        }

        public Builder withmirroringInterSockErrors1Day(long mirroringInterSockErrors1Day){
            this.mirroringInterSockErrors1Day = mirroringInterSockErrors1Day;
            return this;
        }

        public Builder withmirroringInterSockErrors1DayH(long mirroringInterSockErrors1DayH){
            this.mirroringInterSockErrors1DayH = mirroringInterSockErrors1DayH;
            return this;
        }

        public Builder withmirroringInterSockErrors1Hour(long mirroringInterSockErrors1Hour){
            this.mirroringInterSockErrors1Hour = mirroringInterSockErrors1Hour;
            return this;
        }

        public Builder withmirroringInterSockErrors1HourH(long mirroringInterSockErrors1HourH){
            this.mirroringInterSockErrors1HourH = mirroringInterSockErrors1HourH;
            return this;
        }

        public Builder withmirroringInterSockErrors1Week(long mirroringInterSockErrors1Week){
            this.mirroringInterSockErrors1Week = mirroringInterSockErrors1Week;
            return this;
        }

        public Builder withmirroringInterSockErrors1WeekH(long mirroringInterSockErrors1WeekH){
            this.mirroringInterSockErrors1WeekH = mirroringInterSockErrors1WeekH;
            return this;
        }

        public Builder withmirroringInterSockErrors2Weeks(long mirroringInterSockErrors2Weeks){
            this.mirroringInterSockErrors2Weeks = mirroringInterSockErrors2Weeks;
            return this;
        }

        public Builder withmirroringInterSockErrors2WeeksH(long mirroringInterSockErrors2WeeksH){
            this.mirroringInterSockErrors2WeeksH = mirroringInterSockErrors2WeeksH;
            return this;
        }

        public Builder withmirroringIntraSockErrors(long mirroringIntraSockErrors){
            this.mirroringIntraSockErrors = mirroringIntraSockErrors;
            return this;
        }

        public Builder withmirroringIntraSockErrors15Min(long mirroringIntraSockErrors15Min){
            this.mirroringIntraSockErrors15Min = mirroringIntraSockErrors15Min;
            return this;
        }

        public Builder withmirroringIntraSockErrors15MinH(long mirroringIntraSockErrors15MinH){
            this.mirroringIntraSockErrors15MinH = mirroringIntraSockErrors15MinH;
            return this;
        }

        public Builder withmirroringIntraSockErrors1Day(long mirroringIntraSockErrors1Day){
            this.mirroringIntraSockErrors1Day = mirroringIntraSockErrors1Day;
            return this;
        }

        public Builder withmirroringIntraSockErrors1DayH(long mirroringIntraSockErrors1DayH){
            this.mirroringIntraSockErrors1DayH = mirroringIntraSockErrors1DayH;
            return this;
        }

        public Builder withmirroringIntraSockErrors1Hour(long mirroringIntraSockErrors1Hour){
            this.mirroringIntraSockErrors1Hour = mirroringIntraSockErrors1Hour;
            return this;
        }

        public Builder withmirroringIntraSockErrors1HourH(long mirroringIntraSockErrors1HourH){
            this.mirroringIntraSockErrors1HourH = mirroringIntraSockErrors1HourH;
            return this;
        }

        public Builder withmirroringIntraSockErrors1Week(long mirroringIntraSockErrors1Week){
            this.mirroringIntraSockErrors1Week = mirroringIntraSockErrors1Week;
            return this;
        }

        public Builder withmirroringIntraSockErrors1WeekH(long mirroringIntraSockErrors1WeekH){
            this.mirroringIntraSockErrors1WeekH = mirroringIntraSockErrors1WeekH;
            return this;
        }

        public Builder withmirroringIntraSockErrors2Weeks(long mirroringIntraSockErrors2Weeks){
            this.mirroringIntraSockErrors2Weeks = mirroringIntraSockErrors2Weeks;
            return this;
        }

        public Builder withmirroringIntraSockErrors2WeeksH(long mirroringIntraSockErrors2WeeksH){
            this.mirroringIntraSockErrors2WeeksH = mirroringIntraSockErrors2WeeksH;
            return this;
        }

        public Builder withsmiLinkCorrErrors(long smiLinkCorrErrors){
            this.smiLinkCorrErrors = smiLinkCorrErrors;
            return this;
        }

        public Builder withsmiLinkCorrErrors15Min(long smiLinkCorrErrors15Min){
            this.smiLinkCorrErrors15Min = smiLinkCorrErrors15Min;
            return this;
        }

        public Builder withsmiLinkCorrErrors15MinH(long smiLinkCorrErrors15MinH){
            this.smiLinkCorrErrors15MinH = smiLinkCorrErrors15MinH;
            return this;
        }

        public Builder withsmiLinkCorrErrors1Day(long smiLinkCorrErrors1Day){
            this.smiLinkCorrErrors1Day = smiLinkCorrErrors1Day;
            return this;
        }

        public Builder withsmiLinkCorrErrors1DayH(long smiLinkCorrErrors1DayH){
            this.smiLinkCorrErrors1DayH = smiLinkCorrErrors1DayH;
            return this;
        }

        public Builder withsmiLinkCorrErrors1Hour(long smiLinkCorrErrors1Hour){
            this.smiLinkCorrErrors1Hour = smiLinkCorrErrors1Hour;
            return this;
        }

        public Builder withsmiLinkCorrErrors1HourH(long smiLinkCorrErrors1HourH){
            this.smiLinkCorrErrors1HourH = smiLinkCorrErrors1HourH;
            return this;
        }

        public Builder withsmiLinkCorrErrors1Week(long smiLinkCorrErrors1Week){
            this.smiLinkCorrErrors1Week = smiLinkCorrErrors1Week;
            return this;
        }

        public Builder withsmiLinkCorrErrors1WeekH(long smiLinkCorrErrors1WeekH){
            this.smiLinkCorrErrors1WeekH = smiLinkCorrErrors1WeekH;
            return this;
        }

        public Builder withsmiLinkCorrErrors2Weeks(long smiLinkCorrErrors2Weeks){
            this.smiLinkCorrErrors2Weeks = smiLinkCorrErrors2Weeks;
            return this;
        }

        public Builder withsmiLinkCorrErrors2WeeksH(long smiLinkCorrErrors2WeeksH){
            this.smiLinkCorrErrors2WeeksH = smiLinkCorrErrors2WeeksH;
            return this;
        }

        public Builder withsmiLinkUncorrErrors(long smiLinkUncorrErrors){
            this.smiLinkUncorrErrors = smiLinkUncorrErrors;
            return this;
        }

        public Builder withsmiLinkUncorrErrors15Min(long smiLinkUncorrErrors15Min){
            this.smiLinkUncorrErrors15Min = smiLinkUncorrErrors15Min;
            return this;
        }

        public Builder withsmiLinkUncorrErrors15MinH(long smiLinkUncorrErrors15MinH){
            this.smiLinkUncorrErrors15MinH = smiLinkUncorrErrors15MinH;
            return this;
        }

        public Builder withsmiLinkUncorrErrors1Day(long smiLinkUncorrErrors1Day){
            this.smiLinkUncorrErrors1Day = smiLinkUncorrErrors1Day;
            return this;
        }

        public Builder withsmiLinkUncorrErrors1DayH(long smiLinkUncorrErrors1DayH){
            this.smiLinkUncorrErrors1DayH = smiLinkUncorrErrors1DayH;
            return this;
        }

        public Builder withsmiLinkUncorrErrors1Hour(long smiLinkUncorrErrors1Hour){
            this.smiLinkUncorrErrors1Hour = smiLinkUncorrErrors1Hour;
            return this;
        }

        public Builder withsmiLinkUncorrErrors1HourH(long smiLinkUncorrErrors1HourH){
            this.smiLinkUncorrErrors1HourH = smiLinkUncorrErrors1HourH;
            return this;
        }

        public Builder withsmiLinkUncorrErrors1Week(long smiLinkUncorrErrors1Week){
            this.smiLinkUncorrErrors1Week = smiLinkUncorrErrors1Week;
            return this;
        }

        public Builder withsmiLinkUncorrErrors1WeekH(long smiLinkUncorrErrors1WeekH){
            this.smiLinkUncorrErrors1WeekH = smiLinkUncorrErrors1WeekH;
            return this;
        }

        public Builder withsmiLinkUncorrErrors2Weeks(long smiLinkUncorrErrors2Weeks){
            this.smiLinkUncorrErrors2Weeks = smiLinkUncorrErrors2Weeks;
            return this;
        }

        public Builder withsmiLinkUncorrErrors2WeeksH(long smiLinkUncorrErrors2WeeksH){
            this.smiLinkUncorrErrors2WeeksH = smiLinkUncorrErrors2WeeksH;
            return this;
        }

        public Builder withsparingErrors(long sparingErrors){
            this.sparingErrors = sparingErrors;
            return this;
        }

        public Builder withsparingErrors15Min(long sparingErrors15Min){
            this.sparingErrors15Min = sparingErrors15Min;
            return this;
        }

        public Builder withsparingErrors15MinH(long sparingErrors15MinH){
            this.sparingErrors15MinH = sparingErrors15MinH;
            return this;
        }

        public Builder withsparingErrors1Day(long sparingErrors1Day){
            this.sparingErrors1Day = sparingErrors1Day;
            return this;
        }

        public Builder withsparingErrors1DayH(long sparingErrors1DayH){
            this.sparingErrors1DayH = sparingErrors1DayH;
            return this;
        }

        public Builder withsparingErrors1Hour(long sparingErrors1Hour){
            this.sparingErrors1Hour = sparingErrors1Hour;
            return this;
        }

        public Builder withsparingErrors1HourH(long sparingErrors1HourH){
            this.sparingErrors1HourH = sparingErrors1HourH;
            return this;
        }

        public Builder withsparingErrors1Week(long sparingErrors1Week){
            this.sparingErrors1Week = sparingErrors1Week;
            return this;
        }

        public Builder withsparingErrors1WeekH(long sparingErrors1WeekH){
            this.sparingErrors1WeekH = sparingErrors1WeekH;
            return this;
        }

        public Builder withsparingErrors2Weeks(long sparingErrors2Weeks){
            this.sparingErrors2Weeks = sparingErrors2Weeks;
            return this;
        }

        public Builder withsparingErrors2WeeksH(long sparingErrors2WeeksH){
            this.sparingErrors2WeeksH = sparingErrors2WeeksH;
            return this;
        }

        public UcsProcessorErrorStats build() {
            return new UcsProcessorErrorStats(this);
        }
    }
}
