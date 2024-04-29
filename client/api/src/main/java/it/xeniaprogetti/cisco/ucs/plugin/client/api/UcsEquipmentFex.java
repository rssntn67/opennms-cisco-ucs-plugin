package it.xeniaprogetti.cisco.ucs.plugin.client.api;


public final class UcsEquipmentFex extends UcsEntity {
    
    public final String adminPowerState;
    
    public final String adminState;
    
    public final String configState;
    
    public final int fltAggr;
    
    public final String fsmDescr;
    
    public final String fsmPrev;
    
    public final int fsmProgr;
    
    public final String fsmRmtInvErrCode;
    
    public final String fsmRmtInvErrDescr;
    
    public final String fsmRmtInvRslt;
    
    public final String fsmStageDescr;
    
    public final String fsmStamp;
    
    public final String fsmStatus;
    
    public final int fsmTry;
    
    public final int id;
    
    public final int licGP;
    
    public final String licState;
    
    public final String model;
    
    public final String operQualifier;
    
    public final String operQualifierReason;
    
    public final String operState;
    
    public final String operability;
    
    public final String power;
    
    public final String presence;
    
    public final int revision;
    
    public final String serial;
    
    public final String switchId;
    
    public final String thermal;
    
    public final String usrLbl;
    
    public final String vendor;
    
    public final String voltage;

    public static UcsEquipmentFex.Builder builder() {
        return new UcsEquipmentFex.Builder();
    }

    private UcsEquipmentFex(UcsEquipmentFex.Builder builder) {
        super(builder.dn, ClassId.equipmentFex,ClassItem.equipmentItem);
        this.adminPowerState = builder.adminPowerState;
        this.adminState = builder.adminState;
        this.configState = builder.configState;
        this.fltAggr = builder.fltAggr;
        this.fsmDescr = builder.fsmDescr;
        this.fsmPrev = builder.fsmPrev;
        this.fsmProgr = builder.fsmProgr;
        this.fsmRmtInvErrCode = builder.fsmRmtInvErrCode;
        this.fsmRmtInvErrDescr = builder.fsmRmtInvErrDescr;
        this.fsmRmtInvRslt = builder.fsmRmtInvRslt;
        this.fsmStageDescr = builder.fsmStageDescr;
        this.fsmStamp = builder.fsmStamp;
        this.fsmStatus = builder.fsmStatus;
        this.fsmTry = builder.fsmTry;
        this.id = builder.id;
        this.licGP = builder.licGP;
        this.licState = builder.licState;
        this.model = builder.model;
        this.operQualifier = builder.operQualifier;
        this.operQualifierReason = builder.operQualifierReason;
        this.operState = builder.operState;
        this.operability = builder.operability;
        this.power = builder.power;
        this.presence = builder.presence;
        this.revision = builder.revision;
        this.serial = builder.serial;
        this.switchId = builder.switchId;
        this.thermal = builder.thermal;
        this.usrLbl = builder.usrLbl;
        this.vendor = builder.vendor;
        this.voltage = builder.voltage;
    }

    @Override
    public String toString() {
        return "EquipmentFex{" +
                "dn='" + dn + '\'' +
                ", classId=" + classId +
                ", classItem=" + classItem +
                ", adminPowerState='" + adminPowerState + '\'' +
                ", adminState='" + adminState + '\'' +
                ", configState='" + configState + '\'' +
                ", fltAggr=" + fltAggr +
                ", fsmDescr='" + fsmDescr + '\'' +
                ", fsmPrev='" + fsmPrev + '\'' +
                ", fsmProgr=" + fsmProgr +
                ", fsmRmtInvErrCode='" + fsmRmtInvErrCode + '\'' +
                ", fsmRmtInvErrDescr='" + fsmRmtInvErrDescr + '\'' +
                ", fsmRmtInvRslt='" + fsmRmtInvRslt + '\'' +
                ", fsmStageDescr='" + fsmStageDescr + '\'' +
                ", fsmStamp='" + fsmStamp + '\'' +
                ", fsmStatus='" + fsmStatus + '\'' +
                ", fsmTry=" + fsmTry +
                ", id=" + id +
                ", licGP=" + licGP +
                ", licState='" + licState + '\'' +
                ", model='" + model + '\'' +
                ", operQualifier='" + operQualifier + '\'' +
                ", operQualifierReason='" + operQualifierReason + '\'' +
                ", operState='" + operState + '\'' +
                ", operability='" + operability + '\'' +
                ", power='" + power + '\'' +
                ", presence='" + presence + '\'' +
                ", revision=" + revision +
                ", serial='" + serial + '\'' +
                ", switchId='" + switchId + '\'' +
                ", thermal='" + thermal + '\'' +
                ", usrLbl='" + usrLbl + '\'' +
                ", vendor='" + vendor + '\'' +
                ", voltage='" + voltage + '\'' +
                '}';
    }

    public static class Builder {
        private Builder() {

        }
        private String dn;
        private String adminPowerState;
        private String adminState;
        private String configState;
        private int fltAggr;
        private String fsmDescr;
        private String fsmPrev;
        private int fsmProgr;
        private String fsmRmtInvErrCode;
        private String fsmRmtInvErrDescr;
        private String fsmRmtInvRslt;
        private String fsmStageDescr;
        private String fsmStamp;
        private String fsmStatus;
        private int fsmTry;
        private int id;
        private int licGP;
        private String licState;
        private String model;
        private String operQualifier;
        private String operQualifierReason;
        private String operState;
        private String operability;
        private String power;
        private String presence;
        private int revision;
        private String serial;
        private String switchId;
        private String thermal;
        private String usrLbl;
        private String vendor;
        private String voltage;

        public Builder withDn(String dn) {
            this.dn = dn;
            return this;
        }

        public Builder withAdminPowerState(String adminPowerState) {
            this.adminPowerState = adminPowerState;
            return this;
        }

        public Builder withAdminState(String adminState) {
            this.adminState = adminState;
            return this;
        }

        public Builder withConfigState(String configState) {
            this.configState = configState;
            return this;
        }

        public Builder withFltAggr(int fltAggr) {
            this.fltAggr = fltAggr;
            return this;
        }

        public Builder withFsmDescr(String fsmDescr) {
            this.fsmDescr = fsmDescr;
            return this;
        }

        public Builder withFsmPrev(String fsmPrev) {
            this.fsmPrev = fsmPrev;
            return this;
        }

        public Builder withFsmProgr(int fsmProgr) {
            this.fsmProgr = fsmProgr;
            return this;
        }

        public Builder withFsmRmtInvErrCode(String fsmRmtInvErrCode) {
            this.fsmRmtInvErrCode = fsmRmtInvErrCode;
            return this;
        }

        public Builder withFsmRmtInvErrDescr(String fsmRmtInvErrDescr) {
            this.fsmRmtInvErrDescr = fsmRmtInvErrDescr;
            return this;
        }

        public Builder withFsmRmtInvRslt(String fsmRmtInvRslt) {
            this.fsmRmtInvRslt = fsmRmtInvRslt;
            return this;
        }

        public Builder withFsmStageDescr(String fsmStageDescr) {
            this.fsmStageDescr = fsmStageDescr;
            return this;
        }

        public Builder withFsmStamp(String fsmStamp) {
            this.fsmStamp = fsmStamp;
            return this;
        }

        public Builder withFsmStatus(String fsmStatus) {
            this.fsmStatus = fsmStatus;
            return this;
        }

        public Builder withFsmTry(int fsmTry) {
            this.fsmTry = fsmTry;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withLicGP(int licGP) {
            this.licGP = licGP;
            return this;
        }

        public Builder withLicState(String licState) {
            this.licState = licState;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public Builder withOperQualifier(String operQualifier) {
            this.operQualifier = operQualifier;
            return this;
        }

        public Builder withOperQualifierReason(String operQualifierReason) {
            this.operQualifierReason = operQualifierReason;
            return this;
        }

        public Builder withOperState(String operState) {
            this.operState = operState;
            return this;
        }

        public Builder withOperability(String operability) {
            this.operability = operability;
            return this;
        }

        public Builder withPower(String power) {
            this.power = power;
            return this;
        }

        public Builder withPresence(String presence) {
            this.presence = presence;
            return this;
        }

        public Builder withRevision(int revision) {
            this.revision = revision;
            return this;
        }

        public Builder withSerial(String serial) {
            this.serial = serial;
            return this;
        }

        public Builder withSwitchId(String switchId) {
            this.switchId = switchId;
            return this;
        }

        public Builder withThermal(String thermal) {
            this.thermal = thermal;
            return this;
        }

        public Builder withUsrLbl(String usrLbl) {
            this.usrLbl = usrLbl;
            return this;
        }

        public Builder withVendor(String vendor) {
            this.vendor = vendor;
            return this;
        }

        public Builder withVoltage(String voltage) {
            this.voltage = voltage;
            return this;
        }

        public UcsEquipmentFex build() {
            return new UcsEquipmentFex(this);
        }
    }
}


