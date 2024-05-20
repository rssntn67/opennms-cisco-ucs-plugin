package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsComputePCIeFatalStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int acsViolationErrors;
    public final int acsViolationErrors15Min;
    public final int acsViolationErrors15MinH;
    public final int acsViolationErrors1Day;
    public final int acsViolationErrors1DayH;
    public final int acsViolationErrors1Hour;
    public final int acsViolationErrors1HourH;
    public final int acsViolationErrors1Week;
    public final int acsViolationErrors1WeekH;
    public final int acsViolationErrors2Weeks;
    public final int acsViolationErrors2WeeksH;
    public final int malformedTLPErrors;
    public final int malformedTLPErrors15Min;
    public final int malformedTLPErrors15MinH;
    public final int malformedTLPErrors1Day;
    public final int malformedTLPErrors1DayH;
    public final int malformedTLPErrors1Hour;
    public final int malformedTLPErrors1HourH;
    public final int malformedTLPErrors1Week;
    public final int malformedTLPErrors1WeekH;
    public final int malformedTLPErrors2Weeks;
    public final int malformedTLPErrors2WeeksH;
    public final int poisonedTLPErrors;
    public final int poisonedTLPErrors15Min;
    public final int poisonedTLPErrors15MinH;
    public final int poisonedTLPErrors1Day;
    public final int poisonedTLPErrors1DayH;
    public final int poisonedTLPErrors1Hour;
    public final int poisonedTLPErrors1HourH;
    public final int poisonedTLPErrors1Week;
    public final int poisonedTLPErrors1WeekH;
    public final int poisonedTLPErrors2Weeks;
    public final int poisonedTLPErrors2WeeksH;
    public final int surpriseLinkDownErrors;
    public final int surpriseLinkDownErrors15Min;
    public final int surpriseLinkDownErrors15MinH;
    public final int surpriseLinkDownErrors1Day;
    public final int surpriseLinkDownErrors1DayH;
    public final int surpriseLinkDownErrors1Hour;
    public final int surpriseLinkDownErrors1HourH;
    public final int surpriseLinkDownErrors1Week;
    public final int surpriseLinkDownErrors1WeekH;
    public final int surpriseLinkDownErrors2Weeks;
    public final int surpriseLinkDownErrors2WeeksH;

    private UcsComputePCIeFatalStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computePCIeFatalStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        acsViolationErrors = builder.acsViolationErrors;
        acsViolationErrors15Min = builder.acsViolationErrors15Min;
        acsViolationErrors15MinH = builder.acsViolationErrors15MinH;
        acsViolationErrors1Day = builder.acsViolationErrors1Day;
        acsViolationErrors1DayH = builder.acsViolationErrors1DayH;
        acsViolationErrors1Hour = builder.acsViolationErrors1Hour;
        acsViolationErrors1HourH = builder.acsViolationErrors1HourH;
        acsViolationErrors1Week = builder.acsViolationErrors1Week;
        acsViolationErrors1WeekH = builder.acsViolationErrors1WeekH;
        acsViolationErrors2Weeks = builder.acsViolationErrors2Weeks;
        acsViolationErrors2WeeksH = builder.acsViolationErrors2WeeksH;
        malformedTLPErrors = builder.malformedTLPErrors;
        malformedTLPErrors15Min = builder.malformedTLPErrors15Min;
        malformedTLPErrors15MinH = builder.malformedTLPErrors15MinH;
        malformedTLPErrors1Day = builder.malformedTLPErrors1Day;
        malformedTLPErrors1DayH = builder.malformedTLPErrors1DayH;
        malformedTLPErrors1Hour = builder.malformedTLPErrors1Hour;
        malformedTLPErrors1HourH = builder.malformedTLPErrors1HourH;
        malformedTLPErrors1Week = builder.malformedTLPErrors1Week;
        malformedTLPErrors1WeekH = builder.malformedTLPErrors1WeekH;
        malformedTLPErrors2Weeks = builder.malformedTLPErrors2Weeks;
        malformedTLPErrors2WeeksH = builder.malformedTLPErrors2WeeksH;
        poisonedTLPErrors = builder.poisonedTLPErrors;
        poisonedTLPErrors15Min = builder.poisonedTLPErrors15Min;
        poisonedTLPErrors15MinH = builder.poisonedTLPErrors15MinH;
        poisonedTLPErrors1Day = builder.poisonedTLPErrors1Day;
        poisonedTLPErrors1DayH = builder.poisonedTLPErrors1DayH;
        poisonedTLPErrors1Hour = builder.poisonedTLPErrors1Hour;
        poisonedTLPErrors1HourH = builder.poisonedTLPErrors1HourH;
        poisonedTLPErrors1Week = builder.poisonedTLPErrors1Week;
        poisonedTLPErrors1WeekH = builder.poisonedTLPErrors1WeekH;
        poisonedTLPErrors2Weeks = builder.poisonedTLPErrors2Weeks;
        poisonedTLPErrors2WeeksH = builder.poisonedTLPErrors2WeeksH;
        surpriseLinkDownErrors = builder.surpriseLinkDownErrors;
        surpriseLinkDownErrors15Min = builder.surpriseLinkDownErrors15Min;
        surpriseLinkDownErrors15MinH = builder.surpriseLinkDownErrors15MinH;
        surpriseLinkDownErrors1Day = builder.surpriseLinkDownErrors1Day;
        surpriseLinkDownErrors1DayH = builder.surpriseLinkDownErrors1DayH;
        surpriseLinkDownErrors1Hour = builder.surpriseLinkDownErrors1Hour;
        surpriseLinkDownErrors1HourH = builder.surpriseLinkDownErrors1HourH;
        surpriseLinkDownErrors1Week = builder.surpriseLinkDownErrors1Week;
        surpriseLinkDownErrors1WeekH = builder.surpriseLinkDownErrors1WeekH;
        surpriseLinkDownErrors2Weeks = builder.surpriseLinkDownErrors2Weeks;
        surpriseLinkDownErrors2WeeksH = builder.surpriseLinkDownErrors2WeeksH;
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

        private int acsViolationErrors;
        private int acsViolationErrors15Min;
        private int acsViolationErrors15MinH;
        private int acsViolationErrors1Day;
        private int acsViolationErrors1DayH;
        private int acsViolationErrors1Hour;
        private int acsViolationErrors1HourH;
        private int acsViolationErrors1Week;
        private int acsViolationErrors1WeekH;
        private int acsViolationErrors2Weeks;
        private int acsViolationErrors2WeeksH;
        private int malformedTLPErrors;
        private int malformedTLPErrors15Min;
        private int malformedTLPErrors15MinH;
        private int malformedTLPErrors1Day;
        private int malformedTLPErrors1DayH;
        private int malformedTLPErrors1Hour;
        private int malformedTLPErrors1HourH;
        private int malformedTLPErrors1Week;
        private int malformedTLPErrors1WeekH;
        private int malformedTLPErrors2Weeks;
        private int malformedTLPErrors2WeeksH;
        private int poisonedTLPErrors;
        private int poisonedTLPErrors15Min;
        private int poisonedTLPErrors15MinH;
        private int poisonedTLPErrors1Day;
        private int poisonedTLPErrors1DayH;
        private int poisonedTLPErrors1Hour;
        private int poisonedTLPErrors1HourH;
        private int poisonedTLPErrors1Week;
        private int poisonedTLPErrors1WeekH;
        private int poisonedTLPErrors2Weeks;
        private int poisonedTLPErrors2WeeksH;
        private int surpriseLinkDownErrors;
        private int surpriseLinkDownErrors15Min;
        private int surpriseLinkDownErrors15MinH;
        private int surpriseLinkDownErrors1Day;
        private int surpriseLinkDownErrors1DayH;
        private int surpriseLinkDownErrors1Hour;
        private int surpriseLinkDownErrors1HourH;
        private int surpriseLinkDownErrors1Week;
        private int surpriseLinkDownErrors1WeekH;
        private int surpriseLinkDownErrors2Weeks;
        private int surpriseLinkDownErrors2WeeksH;

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

        public Builder withacsViolationErrors(int acsViolationErrors){
            this.acsViolationErrors = acsViolationErrors;
            return this;
        }

        public Builder withacsViolationErrors15Min(int acsViolationErrors15Min){
            this.acsViolationErrors15Min = acsViolationErrors15Min;
            return this;
        }

        public Builder withacsViolationErrors15MinH(int acsViolationErrors15MinH){
            this.acsViolationErrors15MinH = acsViolationErrors15MinH;
            return this;
        }

        public Builder withacsViolationErrors1Day(int acsViolationErrors1Day){
            this.acsViolationErrors1Day = acsViolationErrors1Day;
            return this;
        }

        public Builder withacsViolationErrors1DayH(int acsViolationErrors1DayH){
            this.acsViolationErrors1DayH = acsViolationErrors1DayH;
            return this;
        }

        public Builder withacsViolationErrors1Hour(int acsViolationErrors1Hour){
            this.acsViolationErrors1Hour = acsViolationErrors1Hour;
            return this;
        }

        public Builder withacsViolationErrors1HourH(int acsViolationErrors1HourH){
            this.acsViolationErrors1HourH = acsViolationErrors1HourH;
            return this;
        }

        public Builder withacsViolationErrors1Week(int acsViolationErrors1Week){
            this.acsViolationErrors1Week = acsViolationErrors1Week;
            return this;
        }

        public Builder withacsViolationErrors1WeekH(int acsViolationErrors1WeekH){
            this.acsViolationErrors1WeekH = acsViolationErrors1WeekH;
            return this;
        }

        public Builder withacsViolationErrors2Weeks(int acsViolationErrors2Weeks){
            this.acsViolationErrors2Weeks = acsViolationErrors2Weeks;
            return this;
        }

        public Builder withacsViolationErrors2WeeksH(int acsViolationErrors2WeeksH){
            this.acsViolationErrors2WeeksH = acsViolationErrors2WeeksH;
            return this;
        }

        public Builder withmalformedTLPErrors(int malformedTLPErrors){
            this.malformedTLPErrors = malformedTLPErrors;
            return this;
        }

        public Builder withmalformedTLPErrors15Min(int malformedTLPErrors15Min){
            this.malformedTLPErrors15Min = malformedTLPErrors15Min;
            return this;
        }

        public Builder withmalformedTLPErrors15MinH(int malformedTLPErrors15MinH){
            this.malformedTLPErrors15MinH = malformedTLPErrors15MinH;
            return this;
        }

        public Builder withmalformedTLPErrors1Day(int malformedTLPErrors1Day){
            this.malformedTLPErrors1Day = malformedTLPErrors1Day;
            return this;
        }

        public Builder withmalformedTLPErrors1DayH(int malformedTLPErrors1DayH){
            this.malformedTLPErrors1DayH = malformedTLPErrors1DayH;
            return this;
        }

        public Builder withmalformedTLPErrors1Hour(int malformedTLPErrors1Hour){
            this.malformedTLPErrors1Hour = malformedTLPErrors1Hour;
            return this;
        }

        public Builder withmalformedTLPErrors1HourH(int malformedTLPErrors1HourH){
            this.malformedTLPErrors1HourH = malformedTLPErrors1HourH;
            return this;
        }

        public Builder withmalformedTLPErrors1Week(int malformedTLPErrors1Week){
            this.malformedTLPErrors1Week = malformedTLPErrors1Week;
            return this;
        }

        public Builder withmalformedTLPErrors1WeekH(int malformedTLPErrors1WeekH){
            this.malformedTLPErrors1WeekH = malformedTLPErrors1WeekH;
            return this;
        }

        public Builder withmalformedTLPErrors2Weeks(int malformedTLPErrors2Weeks){
            this.malformedTLPErrors2Weeks = malformedTLPErrors2Weeks;
            return this;
        }

        public Builder withmalformedTLPErrors2WeeksH(int malformedTLPErrors2WeeksH){
            this.malformedTLPErrors2WeeksH = malformedTLPErrors2WeeksH;
            return this;
        }

        public Builder withpoisonedTLPErrors(int poisonedTLPErrors){
            this.poisonedTLPErrors = poisonedTLPErrors;
            return this;
        }

        public Builder withpoisonedTLPErrors15Min(int poisonedTLPErrors15Min){
            this.poisonedTLPErrors15Min = poisonedTLPErrors15Min;
            return this;
        }

        public Builder withpoisonedTLPErrors15MinH(int poisonedTLPErrors15MinH){
            this.poisonedTLPErrors15MinH = poisonedTLPErrors15MinH;
            return this;
        }

        public Builder withpoisonedTLPErrors1Day(int poisonedTLPErrors1Day){
            this.poisonedTLPErrors1Day = poisonedTLPErrors1Day;
            return this;
        }

        public Builder withpoisonedTLPErrors1DayH(int poisonedTLPErrors1DayH){
            this.poisonedTLPErrors1DayH = poisonedTLPErrors1DayH;
            return this;
        }

        public Builder withpoisonedTLPErrors1Hour(int poisonedTLPErrors1Hour){
            this.poisonedTLPErrors1Hour = poisonedTLPErrors1Hour;
            return this;
        }

        public Builder withpoisonedTLPErrors1HourH(int poisonedTLPErrors1HourH){
            this.poisonedTLPErrors1HourH = poisonedTLPErrors1HourH;
            return this;
        }

        public Builder withpoisonedTLPErrors1Week(int poisonedTLPErrors1Week){
            this.poisonedTLPErrors1Week = poisonedTLPErrors1Week;
            return this;
        }

        public Builder withpoisonedTLPErrors1WeekH(int poisonedTLPErrors1WeekH){
            this.poisonedTLPErrors1WeekH = poisonedTLPErrors1WeekH;
            return this;
        }

        public Builder withpoisonedTLPErrors2Weeks(int poisonedTLPErrors2Weeks){
            this.poisonedTLPErrors2Weeks = poisonedTLPErrors2Weeks;
            return this;
        }

        public Builder withpoisonedTLPErrors2WeeksH(int poisonedTLPErrors2WeeksH){
            this.poisonedTLPErrors2WeeksH = poisonedTLPErrors2WeeksH;
            return this;
        }

        public Builder withsurpriseLinkDownErrors(int surpriseLinkDownErrors){
            this.surpriseLinkDownErrors = surpriseLinkDownErrors;
            return this;
        }

        public Builder withsurpriseLinkDownErrors15Min(int surpriseLinkDownErrors15Min){
            this.surpriseLinkDownErrors15Min = surpriseLinkDownErrors15Min;
            return this;
        }

        public Builder withsurpriseLinkDownErrors15MinH(int surpriseLinkDownErrors15MinH){
            this.surpriseLinkDownErrors15MinH = surpriseLinkDownErrors15MinH;
            return this;
        }

        public Builder withsurpriseLinkDownErrors1Day(int surpriseLinkDownErrors1Day){
            this.surpriseLinkDownErrors1Day = surpriseLinkDownErrors1Day;
            return this;
        }

        public Builder withsurpriseLinkDownErrors1DayH(int surpriseLinkDownErrors1DayH){
            this.surpriseLinkDownErrors1DayH = surpriseLinkDownErrors1DayH;
            return this;
        }

        public Builder withsurpriseLinkDownErrors1Hour(int surpriseLinkDownErrors1Hour){
            this.surpriseLinkDownErrors1Hour = surpriseLinkDownErrors1Hour;
            return this;
        }

        public Builder withsurpriseLinkDownErrors1HourH(int surpriseLinkDownErrors1HourH){
            this.surpriseLinkDownErrors1HourH = surpriseLinkDownErrors1HourH;
            return this;
        }

        public Builder withsurpriseLinkDownErrors1Week(int surpriseLinkDownErrors1Week){
            this.surpriseLinkDownErrors1Week = surpriseLinkDownErrors1Week;
            return this;
        }

        public Builder withsurpriseLinkDownErrors1WeekH(int surpriseLinkDownErrors1WeekH){
            this.surpriseLinkDownErrors1WeekH = surpriseLinkDownErrors1WeekH;
            return this;
        }

        public Builder withsurpriseLinkDownErrors2Weeks(int surpriseLinkDownErrors2Weeks){
            this.surpriseLinkDownErrors2Weeks = surpriseLinkDownErrors2Weeks;
            return this;
        }

        public Builder withsurpriseLinkDownErrors2WeeksH(int surpriseLinkDownErrors2WeeksH){
            this.surpriseLinkDownErrors2WeeksH = surpriseLinkDownErrors2WeeksH;
            return this;
        }

        public UcsComputePCIeFatalStats build() {
            return new UcsComputePCIeFatalStats(this);
        }
    }
}
