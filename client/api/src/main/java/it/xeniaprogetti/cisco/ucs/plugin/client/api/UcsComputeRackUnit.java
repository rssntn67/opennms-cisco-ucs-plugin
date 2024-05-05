package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public final class UcsComputeRackUnit extends UcsEntity {
    public final String adminPower;
    public final String adminState;
    public final String assetTag;
    public final String assignedToDn;
    public final String association;
    public final String availability;
    public final int availableMemory;
    public final String checkPoint;
    public final String connPath;
    public final String connStatus;
    public final String descr;
    public final String discovery;
    public final String discoveryStatus;
    public final int enclosureId;
    public final String fanSpeedConfigStatus;
    public final String fanSpeedPolicyFault;
    public final int fltAggr;
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
    public final int intId;
    public final String kmipFault;
    public final String kmipFaultDescription;
    public final String lc;
    public final Date lcTs;
    public final String localId;
    public final String lowVoltageMemory;
    public final String managingInst;
    public final String memorySpeed;
    public final String mfgTime;
    public final String model;
    public final String name;
    public final int numOf40GAdaptorsWithOldFw;
    public final int numOf40GAdaptorsWithUnknownFw;
    public final int numOfAdaptors;
    public final int numOfCores;
    public final int numOfCoresEnabled;
    public final int numOfCpus;
    public final int numOfEthHostIfs;
    public final int numOfFcHostIfs;
    public final int numOfThreads;
    public final String operPower;
    public final String operPwrTransSrc;
    public final String operQualifier;
    public final String operQualifierReason;
    public final String operState;
    public final String operability;
    public final String originalUuid;
    public final String partNumber;
    public final String physicalSecurity;
    public final int policyLevel;
    public final String policyOwner;
    public final String presence;
    public final int revision;
    public final String serial;
    public final int serverId;
    public final int slotId;
    public final String storageOperQualifier;
    public final int totalMemory;
    public final String usrLbl;
    public final String uuid;
    public final String vendor;
    public final String versionHolder;
    public final String vethStatus;
    public final int vid;

    public static UcsComputeRackUnit.Builder builder() {
        return  new UcsComputeRackUnit.Builder();
    }

    private UcsComputeRackUnit(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.computeRackUnit, UcsEnums.ClassItem.computeItem);
        this.adminPower = builder.adminPower;
        this.adminState = builder.adminState;
        this.assetTag = builder.assetTag;
        this.assignedToDn = builder.assignedToDn;
        this.association = builder.association;
        this.availability = builder.availability;
        this.availableMemory = builder.availableMemory;
        this.checkPoint = builder.checkPoint;
        this.connPath = builder.connPath;
        this.connStatus = builder.connStatus;
        this.descr = builder.descr;
        this.discovery = builder.discovery;
        this.discoveryStatus = builder.discoveryStatus;
        this.enclosureId = builder.enclosureId;
        this.fanSpeedConfigStatus = builder.fanSpeedConfigStatus;
        this.fanSpeedPolicyFault = builder.fanSpeedPolicyFault;
        this.fltAggr = builder.fltAggr;
        this.fsmDescr = builder.fsmDescr;
        this.fsmFlags = builder. fsmFlags;
        this.fsmPrev = builder. fsmPrev;
        this.fsmProgr = builder. fsmProgr;
        this.fsmRmtInvErrCode = builder. fsmRmtInvErrCode;
        this.fsmRmtInvErrDescr = builder. fsmRmtInvErrDescr;
        this.fsmRmtInvRslt = builder. fsmRmtInvRslt;
        this.fsmStageDescr = builder. fsmStageDescr;
        this.fsmStamp = builder. fsmStamp;
        this.fsmStatus = builder. fsmStatus;
        this.fsmTry = builder. fsmTry;
        this.id = builder. id;
        this.intId = builder. intId;
        this.kmipFault = builder. kmipFault;
        this.kmipFaultDescription = builder. kmipFaultDescription;
        this.lc = builder. lc;
        this.lcTs = builder. lcTs;
        this.localId = builder. localId;
        this.lowVoltageMemory = builder. lowVoltageMemory;
        this.managingInst = builder. managingInst;
        this.memorySpeed = builder. memorySpeed;
        this.mfgTime = builder. mfgTime;
        this.model = builder. model;
        this.name = builder. name;
        this.numOf40GAdaptorsWithOldFw = builder. numOf40GAdaptorsWithOldFw;
        this.numOf40GAdaptorsWithUnknownFw = builder. numOf40GAdaptorsWithUnknownFw;
        this.numOfAdaptors = builder. numOfAdaptors;
        this.numOfCores = builder. numOfCores;
        this.numOfCoresEnabled = builder. numOfCoresEnabled;
        this.numOfCpus = builder. numOfCpus;
        this.numOfEthHostIfs = builder. numOfEthHostIfs;
        this.numOfFcHostIfs = builder. numOfFcHostIfs;
        this.numOfThreads = builder. numOfThreads;
        this.operPower = builder. operPower;
        this.operPwrTransSrc = builder. operPwrTransSrc;
        this.operQualifier = builder. operQualifier;
        this.operQualifierReason = builder. operQualifierReason;
        this.operState = builder. operState;
        this.operability = builder. operability;
        this.originalUuid = builder. originalUuid;
        this.partNumber = builder. partNumber;
        this.physicalSecurity = builder. physicalSecurity;
        this.policyLevel = builder. policyLevel;
        this.policyOwner = builder. policyOwner;
        this.presence = builder. presence;
        this.revision = builder. revision;
        this.serial = builder. serial;
        this.serverId = builder. serverId;
        this.slotId = builder. slotId;
        this.storageOperQualifier = builder. storageOperQualifier;
        this.totalMemory = builder. totalMemory;
        this.usrLbl = builder. usrLbl;
        this.uuid = builder. uuid;
        this.vendor = builder. vendor;
        this.versionHolder = builder. versionHolder;
        this.vethStatus = builder. vethStatus;
        this.vid = builder. vid;
    }

    @Override
    public String toString() {
        return "ComputeRackUnit{" +
                "dn='" + dn.value + '\'' +
                ", classId=" + classId +
                ", classItem=" + classItem +
                ", adminPower='" + adminPower + '\'' +
                ", adminState='" + adminState + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", assignedToDn='" + assignedToDn + '\'' +
                ", association='" + association + '\'' +
                ", availability='" + availability + '\'' +
                ", availableMemory=" + availableMemory +
                ", checkPoint='" + checkPoint + '\'' +
                ", connPath='" + connPath + '\'' +
                ", connStatus='" + connStatus + '\'' +
                ", descr='" + descr + '\'' +
                ", discovery='" + discovery + '\'' +
                ", discoveryStatus='" + discoveryStatus + '\'' +
                ", enclosureId=" + enclosureId +
                ", fanSpeedConfigStatus='" + fanSpeedConfigStatus + '\'' +
                ", fanSpeedPolicyFault='" + fanSpeedPolicyFault + '\'' +
                ", fltAggr=" + fltAggr +
                ", fsmDescr='" + fsmDescr + '\'' +
                ", fsmFlags='" + fsmFlags + '\'' +
                ", fsmPrev='" + fsmPrev + '\'' +
                ", fsmProgr=" + fsmProgr +
                ", fsmRmtInvErrCode='" + fsmRmtInvErrCode + '\'' +
                ", fsmRmtInvErrDescr='" + fsmRmtInvErrDescr + '\'' +
                ", fsmRmtInvRslt='" + fsmRmtInvRslt + '\'' +
                ", fsmStageDescr='" + fsmStageDescr + '\'' +
                ", fsmStamp=" + fsmStamp +
                ", fsmStatus='" + fsmStatus + '\'' +
                ", fsmTry=" + fsmTry +
                ", id=" + id +
                ", intId=" + intId +
                ", kmipFault='" + kmipFault + '\'' +
                ", kmipFaultDescription='" + kmipFaultDescription + '\'' +
                ", lc='" + lc + '\'' +
                ", lcTs=" + lcTs +
                ", localId='" + localId + '\'' +
                ", lowVoltageMemory='" + lowVoltageMemory + '\'' +
                ", managingInst='" + managingInst + '\'' +
                ", memorySpeed='" + memorySpeed + '\'' +
                ", mfgTime='" + mfgTime + '\'' +
                ", model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", numOf40GAdaptorsWithOldFw=" + numOf40GAdaptorsWithOldFw +
                ", numOf40GAdaptorsWithUnknownFw=" + numOf40GAdaptorsWithUnknownFw +
                ", numOfAdaptors=" + numOfAdaptors +
                ", numOfCores=" + numOfCores +
                ", numOfCoresEnabled=" + numOfCoresEnabled +
                ", numOfCpus=" + numOfCpus +
                ", numOfEthHostIfs=" + numOfEthHostIfs +
                ", numOfFcHostIfs=" + numOfFcHostIfs +
                ", numOfThreads=" + numOfThreads +
                ", operPower='" + operPower + '\'' +
                ", operPwrTransSrc='" + operPwrTransSrc + '\'' +
                ", operQualifier='" + operQualifier + '\'' +
                ", operQualifierReason='" + operQualifierReason + '\'' +
                ", operState='" + operState + '\'' +
                ", operability='" + operability + '\'' +
                ", originalUuid='" + originalUuid + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", physicalSecurity='" + physicalSecurity + '\'' +
                ", policyLevel=" + policyLevel +
                ", policyOwner='" + policyOwner + '\'' +
                ", presence='" + presence + '\'' +
                ", revision=" + revision +
                ", serial='" + serial + '\'' +
                ", serverId=" + serverId +
                ", slotId=" + slotId +
                ", storageOperQualifier='" + storageOperQualifier + '\'' +
                ", totalMemory=" + totalMemory +
                ", usrLbl='" + usrLbl + '\'' +
                ", uuid='" + uuid + '\'' +
                ", vendor='" + vendor + '\'' +
                ", versionHolder='" + versionHolder + '\'' +
                ", vethStatus='" + vethStatus + '\'' +
                ", vid=" + vid +
                '}';
    }

    public static class Builder {
        private UcsDn dn;
        private String adminPower;
        private String adminState;
        private String assetTag;
        private String assignedToDn;
        private String association;
        private String availability;
        private int availableMemory;
        private String checkPoint;
        private String connPath;
        private String connStatus;
        private String descr;
        private String discovery;
        private String discoveryStatus;
        private int enclosureId;
        private String fanSpeedConfigStatus;
        private String fanSpeedPolicyFault;
        private int fltAggr;
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
        private int intId;
        private String kmipFault;
        private String kmipFaultDescription;
        private String lc;
        private Date lcTs;
        private String localId;
        private String lowVoltageMemory;
        private String managingInst;
        private String memorySpeed;
        private String mfgTime;
        private String model;
        private String name;
        private int numOf40GAdaptorsWithOldFw;
        private int numOf40GAdaptorsWithUnknownFw;
        private int numOfAdaptors;
        private int numOfCores;
        private int numOfCoresEnabled;
        private int numOfCpus;
        private int numOfEthHostIfs;
        private int numOfFcHostIfs;
        private int numOfThreads;
        private String operPower;
        private String operPwrTransSrc;
        private String operQualifier;
        private String operQualifierReason;
        private String operState;
        private String operability;
        private String originalUuid;
        private String partNumber;
        private String physicalSecurity;
        private int policyLevel;
        private String policyOwner;
        private String presence;
        private int revision;
        private String serial;
        private int serverId;
        private int slotId;
        private String storageOperQualifier;
        private int totalMemory;
        private String usrLbl;
        private String uuid;
        private String vendor;
        private String versionHolder;
        private String vethStatus;
        private int vid;

        private Builder() {

        }

        public Builder withDn(String dn) {
            this.dn = UcsDn.getDn(dn);
            return this;
        }

        public Builder withAdminPower(String adminPower) {
            this.adminPower = adminPower;
            return this;
        }

        public Builder withAdminState(String adminState) {
            this.adminState = adminState;
            return this;
        }

        public Builder withAssetTag(String assetTag) {
            this.assetTag = assetTag;
            return this;
        }

        public Builder withAssignedToDn(String assignedToDn) {
            this.assignedToDn = assignedToDn;
            return this;
        }

        public Builder withAssociation(String association) {
            this.association = association;
            return this;
        }

        public Builder withAvailability(String availability) {
            this.availability = availability;
            return this;
        }

        public Builder withAvailableMemory(int availableMemory) {
            this.availableMemory = availableMemory;
            return this;
        }

        public Builder withCheckPoint(String checkPoint) {
            this.checkPoint = checkPoint;
            return this;
        }

        public Builder withConnPath(String connPath) {
            this.connPath = connPath;
            return this;
        }

        public Builder withConnStatus(String connStatus) {
            this.connStatus = connStatus;
            return this;
        }

        public Builder withDescr(String descr) {
            this.descr = descr;
            return this;
        }

        public Builder withDiscovery(String discovery) {
            this.discovery = discovery;
            return this;
        }

        public Builder withDiscoveryStatus(String discoveryStatus) {
            this.discoveryStatus = discoveryStatus;
            return this;
        }

        public Builder withEnclosureId(int enclosureId) {
            this.enclosureId = enclosureId;
            return this;
        }

        public Builder withFanSpeedConfigStatus(String fanSpeedConfigStatus) {
            this.fanSpeedConfigStatus = fanSpeedConfigStatus;
            return this;
        }

        public Builder withFanSpeedPolicyFault(String fanSpeedPolicyFault) {
            this.fanSpeedPolicyFault = fanSpeedPolicyFault;
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

        public Builder withFsmFlags(String fsmFlags) {
            this.fsmFlags = fsmFlags;
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

        public Builder withFsmStamp(Date fsmStamp) {
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

        public Builder withIntId(int intId) {
            this.intId = intId;
            return this;
        }

        public Builder withKmipFault(String kmipFault) {
            this.kmipFault = kmipFault;
            return this;
        }

        public Builder withKmipFaultDescription(String kmipFaultDescription) {
            this.kmipFaultDescription = kmipFaultDescription;
            return this;
        }

        public Builder withLc(String lc) {
            this.lc = lc;
            return this;
        }

        public Builder withLcTs(Date lcTs) {
            this.lcTs = lcTs;
            return this;
        }

        public Builder withLocalId(String localId) {
            this.localId = localId;
            return this;
        }

        public Builder withLowVoltageMemory(String lowVoltageMemory) {
            this.lowVoltageMemory = lowVoltageMemory;
            return this;
        }

        public Builder withManagingInst(String managingInst) {
            this.managingInst = managingInst;
            return this;
        }

        public Builder withMemorySpeed(String memorySpeed) {
            this.memorySpeed = memorySpeed;
            return this;
        }

        public Builder withMfgTime(String mfgTime) {
            this.mfgTime = mfgTime;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withNumOf40GAdaptorsWithOldFw(int numOf40GAdaptorsWithOldFw) {
            this.numOf40GAdaptorsWithOldFw = numOf40GAdaptorsWithOldFw;
            return this;
        }

        public Builder withNumOf40GAdaptorsWithUnknownFw(int numOf40GAdaptorsWithUnknownFw) {
            this.numOf40GAdaptorsWithUnknownFw = numOf40GAdaptorsWithUnknownFw;
            return this;
        }

        public Builder withNumOfAdaptors(int numOfAdaptors) {
            this.numOfAdaptors = numOfAdaptors;
            return this;
        }

        public Builder withNumOfCores(int numOfCores) {
            this.numOfCores = numOfCores;
            return this;
        }

        public Builder withNumOfCoresEnabled(int numOfCoresEnabled) {
            this.numOfCoresEnabled = numOfCoresEnabled;
            return this;
        }

        public Builder withNumOfCpus(int numOfCpus) {
            this.numOfCpus = numOfCpus;
            return this;
        }

        public Builder withNumOfEthHostIfs(int numOfEthHostIfs) {
            this.numOfEthHostIfs = numOfEthHostIfs;
            return this;
        }

        public Builder withNumOfFcHostIfs(int numOfFcHostIfs) {
            this.numOfFcHostIfs = numOfFcHostIfs;
            return this;
        }

        public Builder withNumOfThreads(int numOfThreads) {
            this.numOfThreads = numOfThreads;
            return this;
        }

        public Builder withOperPower(String operPower) {
            this.operPower = operPower;
            return this;
        }

        public Builder withOperPwrTransSrc(String operPwrTransSrc) {
            this.operPwrTransSrc = operPwrTransSrc;
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

        public Builder withOriginalUuid(String originalUuid) {
            this.originalUuid = originalUuid;
            return this;
        }

        public Builder withPartNumber(String partNumber) {
            this.partNumber = partNumber;
            return this;
        }

        public Builder withPhysicalSecurity(String physicalSecurity) {
            this.physicalSecurity = physicalSecurity;
            return this;
        }

        public Builder withPolicyLevel(int policyLevel) {
            this.policyLevel = policyLevel;
            return this;
        }

        public Builder withPolicyOwner(String policyOwner) {
            this.policyOwner = policyOwner;
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

        public Builder withServerId(int serverId) {
            this.serverId = serverId;
            return this;
        }

        public Builder withSlotId(int slotId) {
            this.slotId = slotId;
            return this;
        }

        public Builder withStorageOperQualifier(String storageOperQualifier) {
            this.storageOperQualifier = storageOperQualifier;
            return this;
        }

        public Builder withTotalMemory(int totalMemory) {
            this.totalMemory = totalMemory;
            return this;
        }

        public Builder withUsrLbl(String usrLbl) {
            this.usrLbl = usrLbl;
            return this;
        }

        public Builder withUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder withVendor(String vendor) {
            this.vendor = vendor;
            return this;
        }

        public Builder withVersionHolder(String versionHolder) {
            this.versionHolder = versionHolder;
            return this;
        }

        public Builder withVethStatus(String vethStatus) {
            this.vethStatus = vethStatus;
            return this;
        }

        public Builder withVid(int vid) {
            this.vid = vid;
            return this;
        }

        public UcsComputeRackUnit build() {
            return new UcsComputeRackUnit(this);
        }
    }
}

