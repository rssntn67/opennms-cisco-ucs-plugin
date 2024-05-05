package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;
public final class UcsEquipmentChassis extends UcsEntity {
    
    public final String ackProgressIndicator;
    
    public final String adminState;
    
    public final String assetTag;
    
    public final String assignedToDn;
    
    public final String association;
    
    public final String availability;
    
    public final String configState;
    
    public final String connPath;
    
    public final String connStatus;
    
    public final String discovery;
    
    public final String discoveryStatus;
    
    public final String fabricEpDn;
    
    public final String fanSpeedConfigState;
    
    public final double fltAggr;
    
    public final String fsmDescr;
    
    public final String fsmFlags;
    
    public final String fsmPrev;
    
    public final int fsmProgr;
    
    public final String fsmRmtInvErrCode;
    
    public final String fsmRmtInvErrDescr;
    
    public final String fsmRmtInvRslt;
    
    public final String fsmStageDescr;
    
    public final Date fsmStamp;
    
    public final String fsmStatus;
    
    public final int fsmTry;
    
    public final int id;
    
    public final Date lcTs;
    
    public final int licGP;
    
    public final String licState;
    
    public final String managingInst;
    
    public final String mfgTime;
    
    public final String model;
    
    public final String operQualifier;
    
    public final String operQualifierReason;
    
    public final String operState;
    
    public final String operability;
    
    public final String partNumber;
    
    public final String power;
    
    public final String presence;
    
    public final int revision;
    
    public final String seepromOperState;
    
    public final String serial;
    
    public final String serviceState;
    
    public final String thermal;
    
    public final String thermalStateQualifier;
    
    public final String usrLbl;
    
    public final String vendor;
    
    public final String versionHolder;
    
    public final String vid;

    public static UcsEquipmentChassis.Builder builder() {
        return new UcsEquipmentChassis.Builder();
    }

    private UcsEquipmentChassis(UcsEquipmentChassis.Builder builder) {
        super(builder.dn, UcsEnums.ClassId.equipmentChassis, UcsEnums.ClassItem.equipmentItem);
        this.ackProgressIndicator = builder.ackProgressIndicator;
        this.adminState = builder.adminState;
        this.assetTag = builder.assetTag;
        this.assignedToDn = builder.assignedToDn;
        this.association = builder.association;
        this.availability = builder.availability;
        this.configState = builder.configState;
        this.connPath = builder.connPath;
        this.connStatus = builder.connStatus;
        this.discovery = builder.discovery;
        this.discoveryStatus = builder.discoveryStatus;
        this.fabricEpDn = builder.fabricEpDn;
        this.fanSpeedConfigState = builder.fanSpeedConfigState;
        this.fltAggr = builder.fltAggr;
        this.fsmDescr = builder.fsmDescr;
        this.fsmFlags = builder.fsmFlags;
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
        this.lcTs = builder.lcTs;
        this.licGP = builder.licGP;
        this.licState = builder.licState;
        this.managingInst = builder.managingInst;
        this.mfgTime = builder.mfgTime;
        this.model = builder.model;
        this.operQualifier = builder.operQualifier;
        this.operQualifierReason = builder.operQualifierReason;
        this.operState = builder.operState;
        this.operability = builder.operability;
        this.partNumber = builder.partNumber;
        this.power = builder.power;
        this.presence = builder.presence;
        this.revision = builder.revision;
        this.seepromOperState = builder.seepromOperState;
        this.serial = builder.serial;
        this.serviceState = builder.serviceState;
        this.thermal = builder.thermal;
        this.thermalStateQualifier = builder.thermalStateQualifier;
        this.usrLbl = builder.usrLbl;
        this.vendor = builder.vendor;
        this.versionHolder = builder.versionHolder;
        this.vid = builder.vid;
    }

    @Override
    public String toString() {
        return "EquipmentChassis{" +
                "dn='" + dn.value + '\'' +
                ", classId=" + classId +
                ", classItem=" + classItem +
                ", ackProgressIndicator='" + ackProgressIndicator + '\'' +
                ", adminState='" + adminState + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", assignedToDn='" + assignedToDn + '\'' +
                ", association='" + association + '\'' +
                ", availability='" + availability + '\'' +
                ", configState='" + configState + '\'' +
                ", connPath='" + connPath + '\'' +
                ", connStatus='" + connStatus + '\'' +
                ", discovery='" + discovery + '\'' +
                ", discoveryStatus='" + discoveryStatus + '\'' +
                ", dn='" + dn + '\'' +
                ", fabricEpDn='" + fabricEpDn + '\'' +
                ", fanSpeedConfigState='" + fanSpeedConfigState + '\'' +
                ", fltAggr=" + fltAggr +
                ", fsmDescr='" + fsmDescr + '\'' +
                ", fsmFlags='" + fsmFlags + '\'' +
                ", fsmPrev='" + fsmPrev + '\'' +
                ", fsmProgr=" + fsmProgr +
                ", fsmRmtInvErrCode='" + fsmRmtInvErrCode + '\'' +
                ", fsmRmtInvErrDescr='" + fsmRmtInvErrDescr + '\'' +
                ", fsmRmtInvRslt='" + fsmRmtInvRslt + '\'' +
                ", fsmStageDescr=" + fsmStageDescr +
                ", fsmStamp=" + fsmStamp +
                ", fsmStatus='" + fsmStatus + '\'' +
                ", fsmTry=" + fsmTry +
                ", id=" + id +
                ", lcTs=" + lcTs +
                ", licGP=" + licGP +
                ", licState='" + licState + '\'' +
                ", managingInst='" + managingInst + '\'' +
                ", mfgTime='" + mfgTime + '\'' +
                ", model='" + model + '\'' +
                ", operQualifier='" + operQualifier + '\'' +
                ", operQualifierReason='" + operQualifierReason + '\'' +
                ", operState='" + operState + '\'' +
                ", operability='" + operability + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", power='" + power + '\'' +
                ", presence='" + presence + '\'' +
                ", revision=" + revision +
                ", seepromOperState='" + seepromOperState + '\'' +
                ", serial='" + serial + '\'' +
                ", serviceState='" + serviceState + '\'' +
                ", thermal='" + thermal + '\'' +
                ", thermalStateQualifier='" + thermalStateQualifier + '\'' +
                ", usrLbl='" + usrLbl + '\'' +
                ", vendor='" + vendor + '\'' +
                ", versionHolder='" + versionHolder + '\'' +
                ", vid='" + vid + '\'' +
                '}';
    }

    public static class Builder {
        private UcsDn dn;
        private String ackProgressIndicator;
        private String adminState;
        private String assetTag;
        private String assignedToDn;
        private String association;
        private String availability;
        private String configState;
        private String connPath;
        private String connStatus;
        private String discovery;
        private String discoveryStatus;
        private String fabricEpDn;
        private String fanSpeedConfigState;
        private double fltAggr;
        private String fsmDescr;
        private String fsmFlags;
        private String fsmPrev;
        private int fsmProgr;
        private String fsmRmtInvErrCode;
        private String fsmRmtInvErrDescr;
        private String fsmRmtInvRslt;
        private String fsmStageDescr;
        private Date fsmStamp;
        private String fsmStatus;
        private int fsmTry;
        private int id;
        private Date lcTs;
        private int licGP;
        private String licState;
        private String managingInst;
        private String mfgTime;
        private String model;
        private String operQualifier;
        private String operQualifierReason;
        private String operState;
        private String operability;
        private String partNumber;
        private String power;
        private String presence;
        private int revision;
        private String seepromOperState;
        private String serial;
        private String serviceState;
        private String thermal;
        private String thermalStateQualifier;
        private String usrLbl;
        private String vendor;
        private String versionHolder;
        private String vid;

        public UcsEquipmentChassis.Builder withDn(String dn) {
            this.dn = UcsDn.getDn(dn);
            return this;
        }

        public UcsEquipmentChassis.Builder withAckProgressIndicator(String ackProgressIndicator) {
            this.ackProgressIndicator = ackProgressIndicator;
            return this;
        }

        public UcsEquipmentChassis.Builder withAdminState(String adminState) {
            this.adminState = adminState;
            return this;
        }

        public UcsEquipmentChassis.Builder withAssetTag(String assetTag) {
            this.assetTag = assetTag;
            return this;
        }

        public UcsEquipmentChassis.Builder withAssignedToDn(String assignedToDn) {
            this.assignedToDn = assignedToDn;
            return this;
        }

        public UcsEquipmentChassis.Builder withAssociation(String association) {
            this.association = association;
            return this;
        }

        public UcsEquipmentChassis.Builder withAvailability(String availability) {
            this.availability = availability;
            return this;
        }

        public UcsEquipmentChassis.Builder withConfigState(String configState) {
            this.configState = configState;
            return this;
        }

        public UcsEquipmentChassis.Builder withConnPath(String connPath) {
            this.connPath = connPath;
            return this;
        }

        public UcsEquipmentChassis.Builder withConnStatus(String connStatus) {
            this.connStatus = connStatus;
            return this;
        }

        public UcsEquipmentChassis.Builder withDiscovery(String discovery) {
            this.discovery = discovery;
            return this;
        }

        public UcsEquipmentChassis.Builder withDiscoveryStatus(String discoveryStatus) {
            this.discoveryStatus = discoveryStatus;
            return this;
        }

        public UcsEquipmentChassis.Builder withFabricEpDn(String fabricEpDn) {
            this.fabricEpDn = fabricEpDn;
            return this;
        }

        public UcsEquipmentChassis.Builder withFanSpeedConfigState(String fanSpeedConfigState) {
            this.fanSpeedConfigState = fanSpeedConfigState;
            return this;
        }

        public UcsEquipmentChassis.Builder withFltAggr(double fltAggr) {
            this.fltAggr = fltAggr;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmDescr(String fsmDescr) {
            this.fsmDescr = fsmDescr;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmFlags(String fsmFlags) {
            this.fsmFlags = fsmFlags;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmPrev(String fsmPrev) {
            this.fsmPrev = fsmPrev;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmProgr(int fsmProgr) {
            this.fsmProgr = fsmProgr;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmRmtInvErrCode(String fsmRmtInvErrCode) {
            this.fsmRmtInvErrCode = fsmRmtInvErrCode;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmRmtInvErrDescr(String fsmRmtInvErrDescr) {
            this.fsmRmtInvErrDescr = fsmRmtInvErrDescr;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmRmtInvRslt(String fsmRmtInvRslt) {
            this.fsmRmtInvRslt = fsmRmtInvRslt;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmStageDescr(String fsmStageDescr) {
            this.fsmStageDescr = fsmStageDescr;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmStamp(Date fsmStamp) {
            this.fsmStamp = fsmStamp;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmStatus(String fsmStatus) {
            this.fsmStatus = fsmStatus;
            return this;
        }

        public UcsEquipmentChassis.Builder withFsmTry(int fsmTry) {
            this.fsmTry = fsmTry;
            return this;
        }

        public UcsEquipmentChassis.Builder withId(int id) {
            this.id = id;
            return this;
        }

        public UcsEquipmentChassis.Builder withLcTs(Date lcTs) {
            this.lcTs = lcTs;
            return this;
        }

        public UcsEquipmentChassis.Builder withLicGP(int licGP) {
            this.licGP = licGP;
            return this;
        }

        public UcsEquipmentChassis.Builder withLicState(String licState) {
            this.licState = licState;
            return this;
        }

        public UcsEquipmentChassis.Builder withManagingInst(String managingInst) {
            this.managingInst = managingInst;
            return this;
        }

        public UcsEquipmentChassis.Builder withMfgTime(String mfgTime) {
            this.mfgTime = mfgTime;
            return this;
        }

        public UcsEquipmentChassis.Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public UcsEquipmentChassis.Builder withOperQualifier(String operQualifier) {
            this.operQualifier = operQualifier;
            return this;
        }

        public UcsEquipmentChassis.Builder withOperQualifierReason(String operQualifierReason) {
            this.operQualifierReason = operQualifierReason;
            return this;
        }

        public UcsEquipmentChassis.Builder withOperState(String operState) {
            this.operState = operState;
            return this;
        }

        public UcsEquipmentChassis.Builder withOperability(String operability) {
            this.operability = operability;
            return this;
        }

        public UcsEquipmentChassis.Builder withPartNumber(String partNumber) {
            this.partNumber = partNumber;
            return this;
        }

        public UcsEquipmentChassis.Builder withPower(String power) {
            this.power = power;
            return this;
        }

        public UcsEquipmentChassis.Builder withPresence(String presence) {
            this.presence = presence;
            return this;
        }

        public UcsEquipmentChassis.Builder withRevision(int revision) {
            this.revision = revision;
            return this;
        }

        public UcsEquipmentChassis.Builder withSeepromOperState(String seepromOperState) {
            this.seepromOperState = seepromOperState;
            return this;
        }

        public UcsEquipmentChassis.Builder withSerial(String serial) {
            this.serial = serial;
            return this;
        }

        public UcsEquipmentChassis.Builder withServiceState(String serviceState) {
            this.serviceState = serviceState;
            return this;
        }

        public UcsEquipmentChassis.Builder withThermal(String thermal) {
            this.thermal = thermal;
            return this;
        }

        public UcsEquipmentChassis.Builder withThermalStateQualifier(String thermalStateQualifier) {
            this.thermalStateQualifier = thermalStateQualifier;
            return this;
        }

        public UcsEquipmentChassis.Builder withUsrLbl(String usrLbl) {
            this.usrLbl = usrLbl;
            return this;
        }

        public UcsEquipmentChassis.Builder withVendor(String vendor) {
            this.vendor = vendor;
            return this;
        }

        public UcsEquipmentChassis.Builder withVersionHolder(String versionHolder) {
            this.versionHolder = versionHolder;
            return this;
        }

        public UcsEquipmentChassis.Builder withVid(String vid) {
            this.vid = vid;
            return this;
        }

        public UcsEquipmentChassis build() {
            return new UcsEquipmentChassis(this);
        }
    }
}