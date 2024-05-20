package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsMemoryErrorStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int DramWriteDataCorrectableCRCErrors;
    public final int DramWriteDataCorrectableCRCErrors15Min;
    public final int DramWriteDataCorrectableCRCErrors15MinH;
    public final int DramWriteDataCorrectableCRCErrors1Day;
    public final int DramWriteDataCorrectableCRCErrors1DayH;
    public final int DramWriteDataCorrectableCRCErrors1Hour;
    public final int DramWriteDataCorrectableCRCErrors1HourH;
    public final int DramWriteDataCorrectableCRCErrors1Week;
    public final int DramWriteDataCorrectableCRCErrors1WeekH;
    public final int DramWriteDataCorrectableCRCErrors2Weeks;
    public final int DramWriteDataCorrectableCRCErrors2WeeksH;
    public final int DramWriteDataUnCorrectableCRCErrors;
    public final int DramWriteDataUnCorrectableCRCErrors15Min;
    public final int DramWriteDataUnCorrectableCRCErrors15MinH;
    public final int DramWriteDataUnCorrectableCRCErrors1Day;
    public final int DramWriteDataUnCorrectableCRCErrors1DayH;
    public final int DramWriteDataUnCorrectableCRCErrors1Hour;
    public final int DramWriteDataUnCorrectableCRCErrors1HourH;
    public final int DramWriteDataUnCorrectableCRCErrors1Week;
    public final int DramWriteDataUnCorrectableCRCErrors1WeekH;
    public final int DramWriteDataUnCorrectableCRCErrors2Weeks;
    public final int DramWriteDataUnCorrectableCRCErrors2WeeksH;
    public final int addressParityErrors;
    public final int addressParityErrors15Min;
    public final int addressParityErrors15MinH;
    public final int addressParityErrors1Day;
    public final int addressParityErrors1DayH;
    public final int addressParityErrors1Hour;
    public final int addressParityErrors1HourH;
    public final int addressParityErrors1Week;
    public final int addressParityErrors1WeekH;
    public final int addressParityErrors2Weeks;
    public final int addressParityErrors2WeeksH;
    public final int addressParityErrorsCorrectable;
    public final int addressParityErrorsCorrectable15Min;
    public final int addressParityErrorsCorrectable15MinH;
    public final int addressParityErrorsCorrectable1Day;
    public final int addressParityErrorsCorrectable1DayH;
    public final int addressParityErrorsCorrectable1Hour;
    public final int addressParityErrorsCorrectable1HourH;
    public final int addressParityErrorsCorrectable1Week;
    public final int addressParityErrorsCorrectable1WeekH;
    public final int addressParityErrorsCorrectable2Weeks;
    public final int addressParityErrorsCorrectable2WeeksH;
    public final int addressParityErrorsUnCorrectable;
    public final int addressParityErrorsUnCorrectable15Min;
    public final int addressParityErrorsUnCorrectable15MinH;
    public final int addressParityErrorsUnCorrectable1Day;
    public final int addressParityErrorsUnCorrectable1DayH;
    public final int addressParityErrorsUnCorrectable1Hour;
    public final int addressParityErrorsUnCorrectable1HourH;
    public final int addressParityErrorsUnCorrectable1Week;
    public final int addressParityErrorsUnCorrectable1WeekH;
    public final int addressParityErrorsUnCorrectable2Weeks;
    public final int addressParityErrorsUnCorrectable2WeeksH;
    public final int eccMultibitErrors;
    public final int eccMultibitErrors15Min;
    public final int eccMultibitErrors15MinH;
    public final int eccMultibitErrors1Day;
    public final int eccMultibitErrors1DayH;
    public final int eccMultibitErrors1Hour;
    public final int eccMultibitErrors1HourH;
    public final int eccMultibitErrors1Week;
    public final int eccMultibitErrors1WeekH;
    public final int eccMultibitErrors2Weeks;
    public final int eccMultibitErrors2WeeksH;
    public final int eccSinglebitErrors;
    public final int eccSinglebitErrors15Min;
    public final int eccSinglebitErrors15MinH;
    public final int eccSinglebitErrors1Day;
    public final int eccSinglebitErrors1DayH;
    public final int eccSinglebitErrors1Hour;
    public final int eccSinglebitErrors1HourH;
    public final int eccSinglebitErrors1Week;
    public final int eccSinglebitErrors1WeekH;
    public final int eccSinglebitErrors2Weeks;
    public final int eccSinglebitErrors2WeeksH;
    public final int mismatchErrors;
    public final int mismatchErrors15Min;
    public final int mismatchErrors15MinH;
    public final int mismatchErrors1Day;
    public final int mismatchErrors1DayH;
    public final int mismatchErrors1Hour;
    public final int mismatchErrors1HourH;
    public final int mismatchErrors1Week;
    public final int mismatchErrors1WeekH;
    public final int mismatchErrors2Weeks;
    public final int mismatchErrors2WeeksH;

    private UcsMemoryErrorStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.memoryErrorStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        DramWriteDataCorrectableCRCErrors = builder.DramWriteDataCorrectableCRCErrors;
        DramWriteDataCorrectableCRCErrors15Min = builder.DramWriteDataCorrectableCRCErrors15Min;
        DramWriteDataCorrectableCRCErrors15MinH = builder.DramWriteDataCorrectableCRCErrors15MinH;
        DramWriteDataCorrectableCRCErrors1Day = builder.DramWriteDataCorrectableCRCErrors1Day;
        DramWriteDataCorrectableCRCErrors1DayH = builder.DramWriteDataCorrectableCRCErrors1DayH;
        DramWriteDataCorrectableCRCErrors1Hour = builder.DramWriteDataCorrectableCRCErrors1Hour;
        DramWriteDataCorrectableCRCErrors1HourH = builder.DramWriteDataCorrectableCRCErrors1HourH;
        DramWriteDataCorrectableCRCErrors1Week = builder.DramWriteDataCorrectableCRCErrors1Week;
        DramWriteDataCorrectableCRCErrors1WeekH = builder.DramWriteDataCorrectableCRCErrors1WeekH;
        DramWriteDataCorrectableCRCErrors2Weeks = builder.DramWriteDataCorrectableCRCErrors2Weeks;
        DramWriteDataCorrectableCRCErrors2WeeksH = builder.DramWriteDataCorrectableCRCErrors2WeeksH;
        DramWriteDataUnCorrectableCRCErrors = builder.DramWriteDataUnCorrectableCRCErrors;
        DramWriteDataUnCorrectableCRCErrors15Min = builder.DramWriteDataUnCorrectableCRCErrors15Min;
        DramWriteDataUnCorrectableCRCErrors15MinH = builder.DramWriteDataUnCorrectableCRCErrors15MinH;
        DramWriteDataUnCorrectableCRCErrors1Day = builder.DramWriteDataUnCorrectableCRCErrors1Day;
        DramWriteDataUnCorrectableCRCErrors1DayH = builder.DramWriteDataUnCorrectableCRCErrors1DayH;
        DramWriteDataUnCorrectableCRCErrors1Hour = builder.DramWriteDataUnCorrectableCRCErrors1Hour;
        DramWriteDataUnCorrectableCRCErrors1HourH = builder.DramWriteDataUnCorrectableCRCErrors1HourH;
        DramWriteDataUnCorrectableCRCErrors1Week = builder.DramWriteDataUnCorrectableCRCErrors1Week;
        DramWriteDataUnCorrectableCRCErrors1WeekH = builder.DramWriteDataUnCorrectableCRCErrors1WeekH;
        DramWriteDataUnCorrectableCRCErrors2Weeks = builder.DramWriteDataUnCorrectableCRCErrors2Weeks;
        DramWriteDataUnCorrectableCRCErrors2WeeksH = builder.DramWriteDataUnCorrectableCRCErrors2WeeksH;
        addressParityErrors = builder.addressParityErrors;
        addressParityErrors15Min = builder.addressParityErrors15Min;
        addressParityErrors15MinH = builder.addressParityErrors15MinH;
        addressParityErrors1Day = builder.addressParityErrors1Day;
        addressParityErrors1DayH = builder.addressParityErrors1DayH;
        addressParityErrors1Hour = builder.addressParityErrors1Hour;
        addressParityErrors1HourH = builder.addressParityErrors1HourH;
        addressParityErrors1Week = builder.addressParityErrors1Week;
        addressParityErrors1WeekH = builder.addressParityErrors1WeekH;
        addressParityErrors2Weeks = builder.addressParityErrors2Weeks;
        addressParityErrors2WeeksH = builder.addressParityErrors2WeeksH;
        addressParityErrorsCorrectable = builder.addressParityErrorsCorrectable;
        addressParityErrorsCorrectable15Min = builder.addressParityErrorsCorrectable15Min;
        addressParityErrorsCorrectable15MinH = builder.addressParityErrorsCorrectable15MinH;
        addressParityErrorsCorrectable1Day = builder.addressParityErrorsCorrectable1Day;
        addressParityErrorsCorrectable1DayH = builder.addressParityErrorsCorrectable1DayH;
        addressParityErrorsCorrectable1Hour = builder.addressParityErrorsCorrectable1Hour;
        addressParityErrorsCorrectable1HourH = builder.addressParityErrorsCorrectable1HourH;
        addressParityErrorsCorrectable1Week = builder.addressParityErrorsCorrectable1Week;
        addressParityErrorsCorrectable1WeekH = builder.addressParityErrorsCorrectable1WeekH;
        addressParityErrorsCorrectable2Weeks = builder.addressParityErrorsCorrectable2Weeks;
        addressParityErrorsCorrectable2WeeksH = builder.addressParityErrorsCorrectable2WeeksH;
        addressParityErrorsUnCorrectable = builder.addressParityErrorsUnCorrectable;
        addressParityErrorsUnCorrectable15Min = builder.addressParityErrorsUnCorrectable15Min;
        addressParityErrorsUnCorrectable15MinH = builder.addressParityErrorsUnCorrectable15MinH;
        addressParityErrorsUnCorrectable1Day = builder.addressParityErrorsUnCorrectable1Day;
        addressParityErrorsUnCorrectable1DayH = builder.addressParityErrorsUnCorrectable1DayH;
        addressParityErrorsUnCorrectable1Hour = builder.addressParityErrorsUnCorrectable1Hour;
        addressParityErrorsUnCorrectable1HourH = builder.addressParityErrorsUnCorrectable1HourH;
        addressParityErrorsUnCorrectable1Week = builder.addressParityErrorsUnCorrectable1Week;
        addressParityErrorsUnCorrectable1WeekH = builder.addressParityErrorsUnCorrectable1WeekH;
        addressParityErrorsUnCorrectable2Weeks = builder.addressParityErrorsUnCorrectable2Weeks;
        addressParityErrorsUnCorrectable2WeeksH = builder.addressParityErrorsUnCorrectable2WeeksH;
        eccMultibitErrors = builder.eccMultibitErrors;
        eccMultibitErrors15Min = builder.eccMultibitErrors15Min;
        eccMultibitErrors15MinH = builder.eccMultibitErrors15MinH;
        eccMultibitErrors1Day = builder.eccMultibitErrors1Day;
        eccMultibitErrors1DayH = builder.eccMultibitErrors1DayH;
        eccMultibitErrors1Hour = builder.eccMultibitErrors1Hour;
        eccMultibitErrors1HourH = builder.eccMultibitErrors1HourH;
        eccMultibitErrors1Week = builder.eccMultibitErrors1Week;
        eccMultibitErrors1WeekH = builder.eccMultibitErrors1WeekH;
        eccMultibitErrors2Weeks = builder.eccMultibitErrors2Weeks;
        eccMultibitErrors2WeeksH = builder.eccMultibitErrors2WeeksH;
        eccSinglebitErrors = builder.eccSinglebitErrors;
        eccSinglebitErrors15Min = builder.eccSinglebitErrors15Min;
        eccSinglebitErrors15MinH = builder.eccSinglebitErrors15MinH;
        eccSinglebitErrors1Day = builder.eccSinglebitErrors1Day;
        eccSinglebitErrors1DayH = builder.eccSinglebitErrors1DayH;
        eccSinglebitErrors1Hour = builder.eccSinglebitErrors1Hour;
        eccSinglebitErrors1HourH = builder.eccSinglebitErrors1HourH;
        eccSinglebitErrors1Week = builder.eccSinglebitErrors1Week;
        eccSinglebitErrors1WeekH = builder.eccSinglebitErrors1WeekH;
        eccSinglebitErrors2Weeks = builder.eccSinglebitErrors2Weeks;
        eccSinglebitErrors2WeeksH = builder.eccSinglebitErrors2WeeksH;
        mismatchErrors = builder.mismatchErrors;
        mismatchErrors15Min = builder.mismatchErrors15Min;
        mismatchErrors15MinH = builder.mismatchErrors15MinH;
        mismatchErrors1Day = builder.mismatchErrors1Day;
        mismatchErrors1DayH = builder.mismatchErrors1DayH;
        mismatchErrors1Hour = builder.mismatchErrors1Hour;
        mismatchErrors1HourH = builder.mismatchErrors1HourH;
        mismatchErrors1Week = builder.mismatchErrors1Week;
        mismatchErrors1WeekH = builder.mismatchErrors1WeekH;
        mismatchErrors2Weeks = builder.mismatchErrors2Weeks;
        mismatchErrors2WeeksH = builder.mismatchErrors2WeeksH;
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

        private int DramWriteDataCorrectableCRCErrors;
        private int DramWriteDataCorrectableCRCErrors15Min;
        private int DramWriteDataCorrectableCRCErrors15MinH;
        private int DramWriteDataCorrectableCRCErrors1Day;
        private int DramWriteDataCorrectableCRCErrors1DayH;
        private int DramWriteDataCorrectableCRCErrors1Hour;
        private int DramWriteDataCorrectableCRCErrors1HourH;
        private int DramWriteDataCorrectableCRCErrors1Week;
        private int DramWriteDataCorrectableCRCErrors1WeekH;
        private int DramWriteDataCorrectableCRCErrors2Weeks;
        private int DramWriteDataCorrectableCRCErrors2WeeksH;
        private int DramWriteDataUnCorrectableCRCErrors;
        private int DramWriteDataUnCorrectableCRCErrors15Min;
        private int DramWriteDataUnCorrectableCRCErrors15MinH;
        private int DramWriteDataUnCorrectableCRCErrors1Day;
        private int DramWriteDataUnCorrectableCRCErrors1DayH;
        private int DramWriteDataUnCorrectableCRCErrors1Hour;
        private int DramWriteDataUnCorrectableCRCErrors1HourH;
        private int DramWriteDataUnCorrectableCRCErrors1Week;
        private int DramWriteDataUnCorrectableCRCErrors1WeekH;
        private int DramWriteDataUnCorrectableCRCErrors2Weeks;
        private int DramWriteDataUnCorrectableCRCErrors2WeeksH;
        private int addressParityErrors;
        private int addressParityErrors15Min;
        private int addressParityErrors15MinH;
        private int addressParityErrors1Day;
        private int addressParityErrors1DayH;
        private int addressParityErrors1Hour;
        private int addressParityErrors1HourH;
        private int addressParityErrors1Week;
        private int addressParityErrors1WeekH;
        private int addressParityErrors2Weeks;
        private int addressParityErrors2WeeksH;
        private int addressParityErrorsCorrectable;
        private int addressParityErrorsCorrectable15Min;
        private int addressParityErrorsCorrectable15MinH;
        private int addressParityErrorsCorrectable1Day;
        private int addressParityErrorsCorrectable1DayH;
        private int addressParityErrorsCorrectable1Hour;
        private int addressParityErrorsCorrectable1HourH;
        private int addressParityErrorsCorrectable1Week;
        private int addressParityErrorsCorrectable1WeekH;
        private int addressParityErrorsCorrectable2Weeks;
        private int addressParityErrorsCorrectable2WeeksH;
        private int addressParityErrorsUnCorrectable;
        private int addressParityErrorsUnCorrectable15Min;
        private int addressParityErrorsUnCorrectable15MinH;
        private int addressParityErrorsUnCorrectable1Day;
        private int addressParityErrorsUnCorrectable1DayH;
        private int addressParityErrorsUnCorrectable1Hour;
        private int addressParityErrorsUnCorrectable1HourH;
        private int addressParityErrorsUnCorrectable1Week;
        private int addressParityErrorsUnCorrectable1WeekH;
        private int addressParityErrorsUnCorrectable2Weeks;
        private int addressParityErrorsUnCorrectable2WeeksH;
        private int eccMultibitErrors;
        private int eccMultibitErrors15Min;
        private int eccMultibitErrors15MinH;
        private int eccMultibitErrors1Day;
        private int eccMultibitErrors1DayH;
        private int eccMultibitErrors1Hour;
        private int eccMultibitErrors1HourH;
        private int eccMultibitErrors1Week;
        private int eccMultibitErrors1WeekH;
        private int eccMultibitErrors2Weeks;
        private int eccMultibitErrors2WeeksH;
        private int eccSinglebitErrors;
        private int eccSinglebitErrors15Min;
        private int eccSinglebitErrors15MinH;
        private int eccSinglebitErrors1Day;
        private int eccSinglebitErrors1DayH;
        private int eccSinglebitErrors1Hour;
        private int eccSinglebitErrors1HourH;
        private int eccSinglebitErrors1Week;
        private int eccSinglebitErrors1WeekH;
        private int eccSinglebitErrors2Weeks;
        private int eccSinglebitErrors2WeeksH;
        private int mismatchErrors;
        private int mismatchErrors15Min;
        private int mismatchErrors15MinH;
        private int mismatchErrors1Day;
        private int mismatchErrors1DayH;
        private int mismatchErrors1Hour;
        private int mismatchErrors1HourH;
        private int mismatchErrors1Week;
        private int mismatchErrors1WeekH;
        private int mismatchErrors2Weeks;
        private int mismatchErrors2WeeksH;

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

        public Builder withDramWriteDataCorrectableCRCErrors(int DramWriteDataCorrectableCRCErrors){
            this.DramWriteDataCorrectableCRCErrors = DramWriteDataCorrectableCRCErrors;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors15Min(int DramWriteDataCorrectableCRCErrors15Min){
            this.DramWriteDataCorrectableCRCErrors15Min = DramWriteDataCorrectableCRCErrors15Min;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors15MinH(int DramWriteDataCorrectableCRCErrors15MinH){
            this.DramWriteDataCorrectableCRCErrors15MinH = DramWriteDataCorrectableCRCErrors15MinH;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors1Day(int DramWriteDataCorrectableCRCErrors1Day){
            this.DramWriteDataCorrectableCRCErrors1Day = DramWriteDataCorrectableCRCErrors1Day;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors1DayH(int DramWriteDataCorrectableCRCErrors1DayH){
            this.DramWriteDataCorrectableCRCErrors1DayH = DramWriteDataCorrectableCRCErrors1DayH;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors1Hour(int DramWriteDataCorrectableCRCErrors1Hour){
            this.DramWriteDataCorrectableCRCErrors1Hour = DramWriteDataCorrectableCRCErrors1Hour;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors1HourH(int DramWriteDataCorrectableCRCErrors1HourH){
            this.DramWriteDataCorrectableCRCErrors1HourH = DramWriteDataCorrectableCRCErrors1HourH;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors1Week(int DramWriteDataCorrectableCRCErrors1Week){
            this.DramWriteDataCorrectableCRCErrors1Week = DramWriteDataCorrectableCRCErrors1Week;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors1WeekH(int DramWriteDataCorrectableCRCErrors1WeekH){
            this.DramWriteDataCorrectableCRCErrors1WeekH = DramWriteDataCorrectableCRCErrors1WeekH;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors2Weeks(int DramWriteDataCorrectableCRCErrors2Weeks){
            this.DramWriteDataCorrectableCRCErrors2Weeks = DramWriteDataCorrectableCRCErrors2Weeks;
            return this;
        }

        public Builder withDramWriteDataCorrectableCRCErrors2WeeksH(int DramWriteDataCorrectableCRCErrors2WeeksH){
            this.DramWriteDataCorrectableCRCErrors2WeeksH = DramWriteDataCorrectableCRCErrors2WeeksH;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors(int DramWriteDataUnCorrectableCRCErrors){
            this.DramWriteDataUnCorrectableCRCErrors = DramWriteDataUnCorrectableCRCErrors;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors15Min(int DramWriteDataUnCorrectableCRCErrors15Min){
            this.DramWriteDataUnCorrectableCRCErrors15Min = DramWriteDataUnCorrectableCRCErrors15Min;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors15MinH(int DramWriteDataUnCorrectableCRCErrors15MinH){
            this.DramWriteDataUnCorrectableCRCErrors15MinH = DramWriteDataUnCorrectableCRCErrors15MinH;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors1Day(int DramWriteDataUnCorrectableCRCErrors1Day){
            this.DramWriteDataUnCorrectableCRCErrors1Day = DramWriteDataUnCorrectableCRCErrors1Day;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors1DayH(int DramWriteDataUnCorrectableCRCErrors1DayH){
            this.DramWriteDataUnCorrectableCRCErrors1DayH = DramWriteDataUnCorrectableCRCErrors1DayH;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors1Hour(int DramWriteDataUnCorrectableCRCErrors1Hour){
            this.DramWriteDataUnCorrectableCRCErrors1Hour = DramWriteDataUnCorrectableCRCErrors1Hour;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors1HourH(int DramWriteDataUnCorrectableCRCErrors1HourH){
            this.DramWriteDataUnCorrectableCRCErrors1HourH = DramWriteDataUnCorrectableCRCErrors1HourH;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors1Week(int DramWriteDataUnCorrectableCRCErrors1Week){
            this.DramWriteDataUnCorrectableCRCErrors1Week = DramWriteDataUnCorrectableCRCErrors1Week;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors1WeekH(int DramWriteDataUnCorrectableCRCErrors1WeekH){
            this.DramWriteDataUnCorrectableCRCErrors1WeekH = DramWriteDataUnCorrectableCRCErrors1WeekH;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors2Weeks(int DramWriteDataUnCorrectableCRCErrors2Weeks){
            this.DramWriteDataUnCorrectableCRCErrors2Weeks = DramWriteDataUnCorrectableCRCErrors2Weeks;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors2WeeksH(int DramWriteDataUnCorrectableCRCErrors2WeeksH){
            this.DramWriteDataUnCorrectableCRCErrors2WeeksH = DramWriteDataUnCorrectableCRCErrors2WeeksH;
            return this;
        }

        public Builder withaddressParityErrors(int addressParityErrors){
            this.addressParityErrors = addressParityErrors;
            return this;
        }

        public Builder withaddressParityErrors15Min(int addressParityErrors15Min){
            this.addressParityErrors15Min = addressParityErrors15Min;
            return this;
        }

        public Builder withaddressParityErrors15MinH(int addressParityErrors15MinH){
            this.addressParityErrors15MinH = addressParityErrors15MinH;
            return this;
        }

        public Builder withaddressParityErrors1Day(int addressParityErrors1Day){
            this.addressParityErrors1Day = addressParityErrors1Day;
            return this;
        }

        public Builder withaddressParityErrors1DayH(int addressParityErrors1DayH){
            this.addressParityErrors1DayH = addressParityErrors1DayH;
            return this;
        }

        public Builder withaddressParityErrors1Hour(int addressParityErrors1Hour){
            this.addressParityErrors1Hour = addressParityErrors1Hour;
            return this;
        }

        public Builder withaddressParityErrors1HourH(int addressParityErrors1HourH){
            this.addressParityErrors1HourH = addressParityErrors1HourH;
            return this;
        }

        public Builder withaddressParityErrors1Week(int addressParityErrors1Week){
            this.addressParityErrors1Week = addressParityErrors1Week;
            return this;
        }

        public Builder withaddressParityErrors1WeekH(int addressParityErrors1WeekH){
            this.addressParityErrors1WeekH = addressParityErrors1WeekH;
            return this;
        }

        public Builder withaddressParityErrors2Weeks(int addressParityErrors2Weeks){
            this.addressParityErrors2Weeks = addressParityErrors2Weeks;
            return this;
        }

        public Builder withaddressParityErrors2WeeksH(int addressParityErrors2WeeksH){
            this.addressParityErrors2WeeksH = addressParityErrors2WeeksH;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable(int addressParityErrorsCorrectable){
            this.addressParityErrorsCorrectable = addressParityErrorsCorrectable;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable15Min(int addressParityErrorsCorrectable15Min){
            this.addressParityErrorsCorrectable15Min = addressParityErrorsCorrectable15Min;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable15MinH(int addressParityErrorsCorrectable15MinH){
            this.addressParityErrorsCorrectable15MinH = addressParityErrorsCorrectable15MinH;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable1Day(int addressParityErrorsCorrectable1Day){
            this.addressParityErrorsCorrectable1Day = addressParityErrorsCorrectable1Day;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable1DayH(int addressParityErrorsCorrectable1DayH){
            this.addressParityErrorsCorrectable1DayH = addressParityErrorsCorrectable1DayH;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable1Hour(int addressParityErrorsCorrectable1Hour){
            this.addressParityErrorsCorrectable1Hour = addressParityErrorsCorrectable1Hour;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable1HourH(int addressParityErrorsCorrectable1HourH){
            this.addressParityErrorsCorrectable1HourH = addressParityErrorsCorrectable1HourH;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable1Week(int addressParityErrorsCorrectable1Week){
            this.addressParityErrorsCorrectable1Week = addressParityErrorsCorrectable1Week;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable1WeekH(int addressParityErrorsCorrectable1WeekH){
            this.addressParityErrorsCorrectable1WeekH = addressParityErrorsCorrectable1WeekH;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable2Weeks(int addressParityErrorsCorrectable2Weeks){
            this.addressParityErrorsCorrectable2Weeks = addressParityErrorsCorrectable2Weeks;
            return this;
        }

        public Builder withaddressParityErrorsCorrectable2WeeksH(int addressParityErrorsCorrectable2WeeksH){
            this.addressParityErrorsCorrectable2WeeksH = addressParityErrorsCorrectable2WeeksH;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable(int addressParityErrorsUnCorrectable){
            this.addressParityErrorsUnCorrectable = addressParityErrorsUnCorrectable;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable15Min(int addressParityErrorsUnCorrectable15Min){
            this.addressParityErrorsUnCorrectable15Min = addressParityErrorsUnCorrectable15Min;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable15MinH(int addressParityErrorsUnCorrectable15MinH){
            this.addressParityErrorsUnCorrectable15MinH = addressParityErrorsUnCorrectable15MinH;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable1Day(int addressParityErrorsUnCorrectable1Day){
            this.addressParityErrorsUnCorrectable1Day = addressParityErrorsUnCorrectable1Day;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable1DayH(int addressParityErrorsUnCorrectable1DayH){
            this.addressParityErrorsUnCorrectable1DayH = addressParityErrorsUnCorrectable1DayH;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable1Hour(int addressParityErrorsUnCorrectable1Hour){
            this.addressParityErrorsUnCorrectable1Hour = addressParityErrorsUnCorrectable1Hour;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable1HourH(int addressParityErrorsUnCorrectable1HourH){
            this.addressParityErrorsUnCorrectable1HourH = addressParityErrorsUnCorrectable1HourH;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable1Week(int addressParityErrorsUnCorrectable1Week){
            this.addressParityErrorsUnCorrectable1Week = addressParityErrorsUnCorrectable1Week;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable1WeekH(int addressParityErrorsUnCorrectable1WeekH){
            this.addressParityErrorsUnCorrectable1WeekH = addressParityErrorsUnCorrectable1WeekH;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable2Weeks(int addressParityErrorsUnCorrectable2Weeks){
            this.addressParityErrorsUnCorrectable2Weeks = addressParityErrorsUnCorrectable2Weeks;
            return this;
        }

        public Builder withaddressParityErrorsUnCorrectable2WeeksH(int addressParityErrorsUnCorrectable2WeeksH){
            this.addressParityErrorsUnCorrectable2WeeksH = addressParityErrorsUnCorrectable2WeeksH;
            return this;
        }

        public Builder witheccMultibitErrors(int eccMultibitErrors){
            this.eccMultibitErrors = eccMultibitErrors;
            return this;
        }

        public Builder witheccMultibitErrors15Min(int eccMultibitErrors15Min){
            this.eccMultibitErrors15Min = eccMultibitErrors15Min;
            return this;
        }

        public Builder witheccMultibitErrors15MinH(int eccMultibitErrors15MinH){
            this.eccMultibitErrors15MinH = eccMultibitErrors15MinH;
            return this;
        }

        public Builder witheccMultibitErrors1Day(int eccMultibitErrors1Day){
            this.eccMultibitErrors1Day = eccMultibitErrors1Day;
            return this;
        }

        public Builder witheccMultibitErrors1DayH(int eccMultibitErrors1DayH){
            this.eccMultibitErrors1DayH = eccMultibitErrors1DayH;
            return this;
        }

        public Builder witheccMultibitErrors1Hour(int eccMultibitErrors1Hour){
            this.eccMultibitErrors1Hour = eccMultibitErrors1Hour;
            return this;
        }

        public Builder witheccMultibitErrors1HourH(int eccMultibitErrors1HourH){
            this.eccMultibitErrors1HourH = eccMultibitErrors1HourH;
            return this;
        }

        public Builder witheccMultibitErrors1Week(int eccMultibitErrors1Week){
            this.eccMultibitErrors1Week = eccMultibitErrors1Week;
            return this;
        }

        public Builder witheccMultibitErrors1WeekH(int eccMultibitErrors1WeekH){
            this.eccMultibitErrors1WeekH = eccMultibitErrors1WeekH;
            return this;
        }

        public Builder witheccMultibitErrors2Weeks(int eccMultibitErrors2Weeks){
            this.eccMultibitErrors2Weeks = eccMultibitErrors2Weeks;
            return this;
        }

        public Builder witheccMultibitErrors2WeeksH(int eccMultibitErrors2WeeksH){
            this.eccMultibitErrors2WeeksH = eccMultibitErrors2WeeksH;
            return this;
        }

        public Builder witheccSinglebitErrors(int eccSinglebitErrors){
            this.eccSinglebitErrors = eccSinglebitErrors;
            return this;
        }

        public Builder witheccSinglebitErrors15Min(int eccSinglebitErrors15Min){
            this.eccSinglebitErrors15Min = eccSinglebitErrors15Min;
            return this;
        }

        public Builder witheccSinglebitErrors15MinH(int eccSinglebitErrors15MinH){
            this.eccSinglebitErrors15MinH = eccSinglebitErrors15MinH;
            return this;
        }

        public Builder witheccSinglebitErrors1Day(int eccSinglebitErrors1Day){
            this.eccSinglebitErrors1Day = eccSinglebitErrors1Day;
            return this;
        }

        public Builder witheccSinglebitErrors1DayH(int eccSinglebitErrors1DayH){
            this.eccSinglebitErrors1DayH = eccSinglebitErrors1DayH;
            return this;
        }

        public Builder witheccSinglebitErrors1Hour(int eccSinglebitErrors1Hour){
            this.eccSinglebitErrors1Hour = eccSinglebitErrors1Hour;
            return this;
        }

        public Builder witheccSinglebitErrors1HourH(int eccSinglebitErrors1HourH){
            this.eccSinglebitErrors1HourH = eccSinglebitErrors1HourH;
            return this;
        }

        public Builder witheccSinglebitErrors1Week(int eccSinglebitErrors1Week){
            this.eccSinglebitErrors1Week = eccSinglebitErrors1Week;
            return this;
        }

        public Builder witheccSinglebitErrors1WeekH(int eccSinglebitErrors1WeekH){
            this.eccSinglebitErrors1WeekH = eccSinglebitErrors1WeekH;
            return this;
        }

        public Builder witheccSinglebitErrors2Weeks(int eccSinglebitErrors2Weeks){
            this.eccSinglebitErrors2Weeks = eccSinglebitErrors2Weeks;
            return this;
        }

        public Builder witheccSinglebitErrors2WeeksH(int eccSinglebitErrors2WeeksH){
            this.eccSinglebitErrors2WeeksH = eccSinglebitErrors2WeeksH;
            return this;
        }

        public Builder withmismatchErrors(int mismatchErrors){
            this.mismatchErrors = mismatchErrors;
            return this;
        }

        public Builder withmismatchErrors15Min(int mismatchErrors15Min){
            this.mismatchErrors15Min = mismatchErrors15Min;
            return this;
        }

        public Builder withmismatchErrors15MinH(int mismatchErrors15MinH){
            this.mismatchErrors15MinH = mismatchErrors15MinH;
            return this;
        }

        public Builder withmismatchErrors1Day(int mismatchErrors1Day){
            this.mismatchErrors1Day = mismatchErrors1Day;
            return this;
        }

        public Builder withmismatchErrors1DayH(int mismatchErrors1DayH){
            this.mismatchErrors1DayH = mismatchErrors1DayH;
            return this;
        }

        public Builder withmismatchErrors1Hour(int mismatchErrors1Hour){
            this.mismatchErrors1Hour = mismatchErrors1Hour;
            return this;
        }

        public Builder withmismatchErrors1HourH(int mismatchErrors1HourH){
            this.mismatchErrors1HourH = mismatchErrors1HourH;
            return this;
        }

        public Builder withmismatchErrors1Week(int mismatchErrors1Week){
            this.mismatchErrors1Week = mismatchErrors1Week;
            return this;
        }

        public Builder withmismatchErrors1WeekH(int mismatchErrors1WeekH){
            this.mismatchErrors1WeekH = mismatchErrors1WeekH;
            return this;
        }

        public Builder withmismatchErrors2Weeks(int mismatchErrors2Weeks){
            this.mismatchErrors2Weeks = mismatchErrors2Weeks;
            return this;
        }

        public Builder withmismatchErrors2WeeksH(int mismatchErrors2WeeksH){
            this.mismatchErrors2WeeksH = mismatchErrors2WeeksH;
            return this;
        }

        public UcsMemoryErrorStats build() {
            return new UcsMemoryErrorStats(this);
        }
    }
}
