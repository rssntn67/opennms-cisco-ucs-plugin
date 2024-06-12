package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsMemoryErrorStats extends UcsMemoryResourceTypeStats {

    public static Builder builder() {
       return new Builder();
    }

    public final long DramWriteDataCorrectableCRCErrors;
    public final long DramWriteDataUnCorrectableCRCErrors;
    public final long addressParityErrors;
    public final long addressParityErrorsCorrectable;
    public final long addressParityErrorsUnCorrectable;
    public final long eccMultibitErrors;
    public final long eccSinglebitErrors;
    public final long mismatchErrors;

    private UcsMemoryErrorStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.memoryErrorStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        DramWriteDataCorrectableCRCErrors = builder.DramWriteDataCorrectableCRCErrors;
        DramWriteDataUnCorrectableCRCErrors = builder.DramWriteDataUnCorrectableCRCErrors;
        addressParityErrors = builder.addressParityErrors;
        addressParityErrorsCorrectable = builder.addressParityErrorsCorrectable;
        addressParityErrorsUnCorrectable = builder.addressParityErrorsUnCorrectable;
        eccMultibitErrors = builder.eccMultibitErrors;
        eccSinglebitErrors = builder.eccSinglebitErrors;
        mismatchErrors = builder.mismatchErrors;
    }

    @Override
    public String toString() {
        return "UcsMemoryErrorStats{" +
                "DramWriteDataCorrectableCRCErrors=" + DramWriteDataCorrectableCRCErrors +
                ", DramWriteDataUnCorrectableCRCErrors=" + DramWriteDataUnCorrectableCRCErrors +
                ", addressParityErrors=" + addressParityErrors +
                ", addressParityErrorsCorrectable=" + addressParityErrorsCorrectable +
                ", addressParityErrorsUnCorrectable=" + addressParityErrorsUnCorrectable +
                ", eccMultibitErrors=" + eccMultibitErrors +
                ", eccSinglebitErrors=" + eccSinglebitErrors +
                ", mismatchErrors=" + mismatchErrors +
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

        private long DramWriteDataCorrectableCRCErrors;
        private long DramWriteDataUnCorrectableCRCErrors;
        private long addressParityErrors;
        private long addressParityErrorsCorrectable;
        private long addressParityErrorsUnCorrectable;
        private long eccMultibitErrors;
        private long eccSinglebitErrors;
        private long mismatchErrors;

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

        public Builder withDramWriteDataCorrectableCRCErrors(long DramWriteDataCorrectableCRCErrors){
            this.DramWriteDataCorrectableCRCErrors = DramWriteDataCorrectableCRCErrors;
            return this;
        }

        public Builder withDramWriteDataUnCorrectableCRCErrors(long DramWriteDataUnCorrectableCRCErrors){
            this.DramWriteDataUnCorrectableCRCErrors = DramWriteDataUnCorrectableCRCErrors;
            return this;
        }

        public Builder withAddressParityErrors(long addressParityErrors){
            this.addressParityErrors = addressParityErrors;
            return this;
        }

        public Builder withAddressParityErrorsCorrectable(int addressParityErrorsCorrectable){
            this.addressParityErrorsCorrectable = addressParityErrorsCorrectable;
            return this;
        }

        public Builder withAddressParityErrorsUnCorrectable(int addressParityErrorsUnCorrectable){
            this.addressParityErrorsUnCorrectable = addressParityErrorsUnCorrectable;
            return this;
        }

        public Builder withEccMultibitErrors(long eccMultibitErrors){
            this.eccMultibitErrors = eccMultibitErrors;
            return this;
        }

        public Builder withEccSinglebitErrors(int eccSinglebitErrors){
            this.eccSinglebitErrors = eccSinglebitErrors;
            return this;
        }
        public Builder withMismatchErrors(int mismatchErrors){
            this.mismatchErrors = mismatchErrors;
            return this;
        }

        public UcsMemoryErrorStats build() {
            return new UcsMemoryErrorStats(this);
        }
    }
}
