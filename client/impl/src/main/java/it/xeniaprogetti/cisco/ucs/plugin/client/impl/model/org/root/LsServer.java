package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.Dn;

import java.util.Date;

public class LsServer extends Dn {
    @JacksonXmlProperty(isAttribute = true)
    public String agentPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String assignState;
    @JacksonXmlProperty(isAttribute = true)
    public String assocState;
    @JacksonXmlProperty(isAttribute = true)
    public String biosProfileName;
    @JacksonXmlProperty(isAttribute = true)
    public String bootPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String configQualifier;
    @JacksonXmlProperty(isAttribute = true)
    public String configState;
    @JacksonXmlProperty(isAttribute = true)
    public String descr;
    @JacksonXmlProperty(isAttribute = true)
    public String dynamicConPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String extIPPoolName;
    @JacksonXmlProperty(isAttribute = true)
    public String extIPState;
    @JacksonXmlProperty(isAttribute = true)
    public long fltAggr;
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
    public String graphicsCardPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String hostFwPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String identPoolName;
    @JacksonXmlProperty(isAttribute = true)
    public int intId;
    @JacksonXmlProperty(isAttribute = true)
    public String kvmMgmtPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String localDiskPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String maintPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String mgmtAccessPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String mgmtFwPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String name;
    @JacksonXmlProperty(isAttribute = true)
    public String operBiosProfileName;
    @JacksonXmlProperty(isAttribute = true)
    public String operBootPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operDynamicConPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operExtIPPoolName;
    @JacksonXmlProperty(isAttribute = true)
    public String operGraphicsCardPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operHostFwPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operIdentPoolName;
    @JacksonXmlProperty(isAttribute = true)
    public String operKvmMgmtPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operLocalDiskPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operMaintPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operMgmtAccessPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operMgmtFwPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operPersistentMemoryPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operPowerPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operPowerSyncPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operScrubPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operSolPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operSpdmCertificatePolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operSrcTemplName;
    @JacksonXmlProperty(isAttribute = true)
    public String operState;
    @JacksonXmlProperty(isAttribute = true)
    public String operStatsPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String operVconProfileName;
    @JacksonXmlProperty(isAttribute = true)
    public String operVmediaPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String owner;
    @JacksonXmlProperty(isAttribute = true)
    public String persistentMemoryPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String pnDn;
    @JacksonXmlProperty(isAttribute = true)
    public int policyLevel;
    @JacksonXmlProperty(isAttribute = true)
    public String policyOwner;
    @JacksonXmlProperty(isAttribute = true)
    public String powerPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String powerSyncPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public int propAcl;
    @JacksonXmlProperty(isAttribute = true)
    public String resolveRemote;
    @JacksonXmlProperty(isAttribute = true)
    public String scrubPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String solPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String spdmCertificatePolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String srcTemplName;
    @JacksonXmlProperty(isAttribute = true)
    public String statsPolicyName;
    @JacksonXmlProperty(isAttribute = true)
    public String svnicConfig;
    @JacksonXmlProperty(isAttribute = true)
    public String type;
    @JacksonXmlProperty(isAttribute = true)
    public String usrLbl;
    @JacksonXmlProperty(isAttribute = true)
    public String uuid;
    @JacksonXmlProperty(isAttribute = true)
    public String uuidSuffix;
    @JacksonXmlProperty(isAttribute = true)
    public String vconProfileName;
    @JacksonXmlProperty(isAttribute = true)
    public String vmediaPolicyName;

    @Override
    public String toString() {
        return "LsServer{" +
                "agentPolicyName='" + agentPolicyName + '\'' +
                ", assignState='" + assignState + '\'' +
                ", assocState='" + assocState + '\'' +
                ", biosProfileName='" + biosProfileName + '\'' +
                ", bootPolicyName='" + bootPolicyName + '\'' +
                ", configQualifier='" + configQualifier + '\'' +
                ", configState='" + configState + '\'' +
                ", descr='" + descr + '\'' +
                ", dynamicConPolicyName='" + dynamicConPolicyName + '\'' +
                ", extIPPoolName='" + extIPPoolName + '\'' +
                ", extIPState='" + extIPState + '\'' +
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
                ", graphicsCardPolicyName='" + graphicsCardPolicyName + '\'' +
                ", hostFwPolicyName='" + hostFwPolicyName + '\'' +
                ", identPoolName='" + identPoolName + '\'' +
                ", intId=" + intId +
                ", kvmMgmtPolicyName='" + kvmMgmtPolicyName + '\'' +
                ", localDiskPolicyName='" + localDiskPolicyName + '\'' +
                ", maintPolicyName='" + maintPolicyName + '\'' +
                ", mgmtAccessPolicyName='" + mgmtAccessPolicyName + '\'' +
                ", mgmtFwPolicyName='" + mgmtFwPolicyName + '\'' +
                ", name='" + name + '\'' +
                ", operBiosProfileName='" + operBiosProfileName + '\'' +
                ", operBootPolicyName='" + operBootPolicyName + '\'' +
                ", operDynamicConPolicyName='" + operDynamicConPolicyName + '\'' +
                ", operExtIPPoolName='" + operExtIPPoolName + '\'' +
                ", operGraphicsCardPolicyName='" + operGraphicsCardPolicyName + '\'' +
                ", operHostFwPolicyName='" + operHostFwPolicyName + '\'' +
                ", operIdentPoolName='" + operIdentPoolName + '\'' +
                ", operKvmMgmtPolicyName='" + operKvmMgmtPolicyName + '\'' +
                ", operLocalDiskPolicyName='" + operLocalDiskPolicyName + '\'' +
                ", operMaintPolicyName='" + operMaintPolicyName + '\'' +
                ", operMgmtAccessPolicyName='" + operMgmtAccessPolicyName + '\'' +
                ", operMgmtFwPolicyName='" + operMgmtFwPolicyName + '\'' +
                ", operPersistentMemoryPolicyName='" + operPersistentMemoryPolicyName + '\'' +
                ", operPowerPolicyName='" + operPowerPolicyName + '\'' +
                ", operPowerSyncPolicyName='" + operPowerSyncPolicyName + '\'' +
                ", operScrubPolicyName='" + operScrubPolicyName + '\'' +
                ", operSolPolicyName='" + operSolPolicyName + '\'' +
                ", operSpdmCertificatePolicyName='" + operSpdmCertificatePolicyName + '\'' +
                ", operSrcTemplName='" + operSrcTemplName + '\'' +
                ", operState='" + operState + '\'' +
                ", operStatsPolicyName='" + operStatsPolicyName + '\'' +
                ", operVconProfileName='" + operVconProfileName + '\'' +
                ", operVmediaPolicyName='" + operVmediaPolicyName + '\'' +
                ", owner='" + owner + '\'' +
                ", persistentMemoryPolicyName='" + persistentMemoryPolicyName + '\'' +
                ", pnDn='" + pnDn + '\'' +
                ", policyLevel=" + policyLevel +
                ", policyOwner='" + policyOwner + '\'' +
                ", powerPolicyName='" + powerPolicyName + '\'' +
                ", powerSyncPolicyName='" + powerSyncPolicyName + '\'' +
                ", propAcl=" + propAcl +
                ", resolveRemote='" + resolveRemote + '\'' +
                ", scrubPolicyName='" + scrubPolicyName + '\'' +
                ", solPolicyName='" + solPolicyName + '\'' +
                ", spdmCertificatePolicyName='" + spdmCertificatePolicyName + '\'' +
                ", srcTemplName='" + srcTemplName + '\'' +
                ", statsPolicyName='" + statsPolicyName + '\'' +
                ", svnicConfig='" + svnicConfig + '\'' +
                ", type='" + type + '\'' +
                ", usrLbl='" + usrLbl + '\'' +
                ", uuid='" + uuid + '\'' +
                ", uuidSuffix='" + uuidSuffix + '\'' +
                ", vconProfileName='" + vconProfileName + '\'' +
                ", vmediaPolicyName='" + vmediaPolicyName + '\'' +
                '}';
    }
}
