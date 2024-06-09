package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public class UcsEquipmentPsuInputStats extends UcsResourceTypeStats {

    public static Builder builder() {
       return new Builder();
    }

    public final double current;
    public final String inputStatus;
    public final double power;
    public final double voltage;

    private UcsEquipmentPsuInputStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentPsuInputStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        current = builder.current;
        inputStatus = builder.inputStatus;
        power = builder.power;
        voltage = builder.voltage;
    }

    @Override
    public String toString() {
        return "UcsEquipmentPsuInputStats{" +
                "current=" + current +
                ", inputStatus='" + inputStatus + '\'' +
                ", power=" + power +
                ", voltage=" + voltage +
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

    @Override
    public UcsEnums.ResourceType getResourceType() {
        return UcsEnums.ResourceType.EquipPsuInput;
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

        private double current;
        private String inputStatus;
        private double power;
        private double voltage;

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

        public Builder withCurrent(double current){
            this.current = current;
            return this;
        }

        public Builder withInputStatus(String inputStatus){
            this.inputStatus = inputStatus;
            return this;
        }

        public Builder withPower(double power){
            this.power = power;
            return this;
        }

        public Builder withVoltage(double voltage){
            this.voltage = voltage;
            return this;
        }

        public UcsEquipmentPsuInputStats build() {
            return new UcsEquipmentPsuInputStats(this);
        }
    }
}
