package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentIOCardStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final int IomI2CErrors;
    public final double ambientTemp;
    public final double temp;

    private UcsEquipmentIOCardStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentIOCardStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        IomI2CErrors = builder.IomI2CErrors;
        ambientTemp = builder.ambientTemp;
        temp = builder.temp;
    }

    @Override
    public String toString() {
        return "UcsEquipmentIOCardStats{" +
                "IomI2CErrors=" + IomI2CErrors +
                ", ambientTemp=" + ambientTemp +
                ", temp=" + temp +
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

        private int IomI2CErrors;
        private double ambientTemp;
        private double temp;

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

        public Builder withIomI2CErrors(int IomI2CErrors){
            this.IomI2CErrors = IomI2CErrors;
            return this;
        }

        public Builder withAmbientTemp(double ambientTemp){
            this.ambientTemp = ambientTemp;
            return this;
        }

        public Builder withTemp(double temp){
            this.temp = temp;
            return this;
        }

        public UcsEquipmentIOCardStats build() {
            return new UcsEquipmentIOCardStats(this);
        }
    }
}
