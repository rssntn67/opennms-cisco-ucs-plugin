package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.Dn;

import java.util.Date;

public class ComputeBlade extends Dn {
    @JacksonXmlProperty(isAttribute = true)
    public String adminPower;
    @JacksonXmlProperty(isAttribute = true)
    public String adminState;
    @JacksonXmlProperty(isAttribute = true)
    public String assetTag;
    @JacksonXmlProperty(isAttribute = true)
    public String assignedToDn;
    @JacksonXmlProperty(isAttribute = true)
    public String association;
    @JacksonXmlProperty(isAttribute = true)
    public String availability;
    @JacksonXmlProperty(isAttribute = true)
    public int availableMemory;
    @JacksonXmlProperty(isAttribute = true)
    public int chassisId;
    @JacksonXmlProperty(isAttribute = true)
    public String checkPoint;
    @JacksonXmlProperty(isAttribute = true)
    public String connPath;
    @JacksonXmlProperty(isAttribute = true)
    public String connStatus;
    @JacksonXmlProperty(isAttribute = true)
    public String descr;
    @JacksonXmlProperty(isAttribute = true)
    public String discovery;
    @JacksonXmlProperty(isAttribute = true)
    public String discoveryStatus;
    @JacksonXmlProperty(isAttribute = true)
    public double fltAggr;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmDescr;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmFlags;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmPrev;
    @JacksonXmlProperty(isAttribute = true)
    public int fsmProgr;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmRmtInvErrCode;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmRmtInvErrDescr;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmRmtInvRslt;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmStageDescr;
    @JacksonXmlProperty(isAttribute = true)
    public Date fsmStamp;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmStatus;
    @JacksonXmlProperty(isAttribute = true)
    public int fsmTry;
    @JacksonXmlProperty(isAttribute = true)
    public String intId;
    @JacksonXmlProperty(isAttribute = true)
    public String kmipFault;
    @JacksonXmlProperty(isAttribute = true)
    public String kmipFaultDescription;
    @JacksonXmlProperty(isAttribute = true)
    public String lc;
    @JacksonXmlProperty(isAttribute = true)
    public Date lcTs;
    @JacksonXmlProperty(isAttribute = true)
    public String localId;
    @JacksonXmlProperty(isAttribute = true)
    public String lowVoltageMemory;
    @JacksonXmlProperty(isAttribute = true)
    public String managingInst;
    @JacksonXmlProperty(isAttribute = true)
    public String memorySpeed;
    @JacksonXmlProperty(isAttribute = true)
    public String mfgTime;
    @JacksonXmlProperty(isAttribute = true)
    public String model;
    @JacksonXmlProperty(isAttribute = true)
    public String name;
    @JacksonXmlProperty(isAttribute = true)
    public int numOf40GAdaptorsWithOldFw;
    @JacksonXmlProperty(isAttribute = true)
    public int numOf40GAdaptorsWithUnknownFw;
    @JacksonXmlProperty(isAttribute = true)
    public int numOfAdaptors;
    @JacksonXmlProperty(isAttribute = true)
    public int numOfCores;
    @JacksonXmlProperty(isAttribute = true)
    public int numOfCoresEnabled;
    @JacksonXmlProperty(isAttribute = true)
    public int numOfCpus;
    @JacksonXmlProperty(isAttribute = true)
    public int numOfEthHostIfs;
    @JacksonXmlProperty(isAttribute = true)
    public int numOfFcHostIfs;
    @JacksonXmlProperty(isAttribute = true)
    public int numOfThreads;
    @JacksonXmlProperty(isAttribute = true)
    public String operPower;
    @JacksonXmlProperty(isAttribute = true)
    public String operPwrTransSrc;
    @JacksonXmlProperty(isAttribute = true)
    public String operQualifier;
    @JacksonXmlProperty(isAttribute = true)
    public String operQualifierReason;
    @JacksonXmlProperty(isAttribute = true)
    public String operState;
    @JacksonXmlProperty(isAttribute = true)
    public String operability;
    @JacksonXmlProperty(isAttribute = true)
    public String originalUuid;
    @JacksonXmlProperty(isAttribute = true)
    public String partNumber;
    @JacksonXmlProperty(isAttribute = true)
    public int policyLevel;
    @JacksonXmlProperty(isAttribute = true)
    public String policyOwner;
    @JacksonXmlProperty(isAttribute = true)
    public String presence;
    @JacksonXmlProperty(isAttribute = true)
    public int revision;
    @JacksonXmlProperty(isAttribute = true)
    public String scaledMode;
    @JacksonXmlProperty(isAttribute = true)
    public String serial;
    @JacksonXmlProperty(isAttribute = true)
    public String serverId;
    @JacksonXmlProperty(isAttribute = true)
    public int slotId;
    @JacksonXmlProperty(isAttribute = true)
    public String storageOperQualifier;
    @JacksonXmlProperty(isAttribute = true)
    public int totalMemory;
    @JacksonXmlProperty(isAttribute = true)
    public String usrLbl;
    @JacksonXmlProperty(isAttribute = true)
    public String uuid;
    @JacksonXmlProperty(isAttribute = true)
    public String vendor;
    @JacksonXmlProperty(isAttribute = true)
    public String vid;

    @Override
    public String toString() {
        return "ComputeBlade{" +
                "adminPower='" + adminPower + '\'' +
                ", adminState='" + adminState + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", assignedToDn='" + assignedToDn + '\'' +
                ", association='" + association + '\'' +
                ", availability='" + availability + '\'' +
                ", availableMemory=" + availableMemory +
                ", chassisId=" + chassisId +
                ", checkPoint='" + checkPoint + '\'' +
                ", connPath='" + connPath + '\'' +
                ", connStatus='" + connStatus + '\'' +
                ", descr='" + descr + '\'' +
                ", discovery='" + discovery + '\'' +
                ", discoveryStatus='" + discoveryStatus + '\'' +
                ", dn='" + dn + '\'' +
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
                ", policyLevel=" + policyLevel +
                ", policyOwner='" + policyOwner + '\'' +
                ", presence='" + presence + '\'' +
                ", revision=" + revision +
                ", scaledMode='" + scaledMode + '\'' +
                ", serial='" + serial + '\'' +
                ", serverId='" + serverId + '\'' +
                ", slotId=" + slotId +
                ", storageOperQualifier='" + storageOperQualifier + '\'' +
                ", totalMemory=" + totalMemory +
                ", usrLbl='" + usrLbl + '\'' +
                ", uuid='" + uuid + '\'' +
                ", vendor='" + vendor + '\'' +
                ", vid='" + vid + '\'' +
                '}';
    }
}