package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.UcsElement;

import java.util.Date;
public class EquipmentChassis extends UcsElement {
    @JacksonXmlProperty(isAttribute = true)
    public String ackProgressIndicator;
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
    public String configState;
    @JacksonXmlProperty(isAttribute = true)
    public String connPath;
    @JacksonXmlProperty(isAttribute = true)
    public String connStatus;
    @JacksonXmlProperty(isAttribute = true)
    public String discovery;
    @JacksonXmlProperty(isAttribute = true)
    public String discoveryStatus;
    @JacksonXmlProperty(isAttribute = true)
    public String fabricEpDn;
    @JacksonXmlProperty(isAttribute = true)
    public String fanSpeedConfigState;
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
    public int id;
    @JacksonXmlProperty(isAttribute = true)
    public Date lcTs;
    @JacksonXmlProperty(isAttribute = true)
    public int licGP;
    @JacksonXmlProperty(isAttribute = true)
    public String licState;
    @JacksonXmlProperty(isAttribute = true)
    public String managingInst;
    @JacksonXmlProperty(isAttribute = true)
    public String mfgTime;
    @JacksonXmlProperty(isAttribute = true)
    public String model;
    @JacksonXmlProperty(isAttribute = true)
    public String operQualifier;
    @JacksonXmlProperty(isAttribute = true)
    public String operQualifierReason;
    @JacksonXmlProperty(isAttribute = true)
    public String operState;
    @JacksonXmlProperty(isAttribute = true)
    public String operability;
    @JacksonXmlProperty(isAttribute = true)
    public String partNumber;
    @JacksonXmlProperty(isAttribute = true)
    public String power;
    @JacksonXmlProperty(isAttribute = true)
    public String presence;
    @JacksonXmlProperty(isAttribute = true)
    public int revision;
    @JacksonXmlProperty(isAttribute = true)
    public String seepromOperState;
    @JacksonXmlProperty(isAttribute = true)
    public String serial;
    @JacksonXmlProperty(isAttribute = true)
    public String serviceState;
    @JacksonXmlProperty(isAttribute = true)
    public String thermal;
    @JacksonXmlProperty(isAttribute = true)
    public String thermalStateQualifier;
    @JacksonXmlProperty(isAttribute = true)
    public String usrLbl;
    @JacksonXmlProperty(isAttribute = true)
    public String vendor;
    @JacksonXmlProperty(isAttribute = true)
    public String versionHolder;
    @JacksonXmlProperty(isAttribute = true)
    public String vid;

    @Override
    public String toString() {
        return "EquipmentChassis{" +
                "ackProgressIndicator='" + ackProgressIndicator + '\'' +
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
}