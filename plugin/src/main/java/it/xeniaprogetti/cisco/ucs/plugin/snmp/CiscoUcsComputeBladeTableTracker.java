package it.xeniaprogetti.cisco.ucs.plugin.snmp;

import org.opennms.netmgt.snmp.SnmpInstId;
import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpRowResult;
import org.opennms.netmgt.snmp.TableTracker;

/*
1.3.6.1.4.1.9.9.719.1.9.2.1.2	cucsComputeBladeDn	0	0	Cisco UCS compute:Blade:dn managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.3	cucsComputeBladeRn	0	0	Cisco UCS compute:Blade:rn managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.4	cucsComputeBladeAdminPower	0	0	Cisco UCS compute:Blade:adminPower managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.5	cucsComputeBladeAdminState	0	0	Cisco UCS compute:Blade:adminState managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.6	cucsComputeBladeAssignedToDn	0	0	Cisco UCS compute:Blade:assignedToDn managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.7	cucsComputeBladeAssociation	0	0	Cisco UCS compute:Blade:association managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.8	cucsComputeBladeAvailability	0	0	Cisco UCS compute:Blade:availability managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.9	cucsComputeBladeAvailableMemory	0	0	Cisco UCS compute:Blade:availableMemory managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.10	cucsComputeBladeChassisId	0	0	Cisco UCS compute:Blade:chassisId managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.11	cucsComputeBladeCheckPoint	0	0	Cisco UCS compute:Blade:checkPoint managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.12	cucsComputeBladeConnPath	0	0	Cisco UCS compute:Blade:connPath managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.13	cucsComputeBladeConnStatus	0	0	Cisco UCS compute:Blade:connStatus managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.14	cucsComputeBladeDescr	0	0	Cisco UCS compute:Blade:descr managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.15	cucsComputeBladeDiscovery	0	0	Cisco UCS compute:Blade:discovery managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.16	cucsComputeBladeFltAggr	0	0	Cisco UCS compute:Blade:fltAggr managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.17	cucsComputeBladeFsmDescr	0	0	Cisco UCS compute:Blade:fsmDescr managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.18	cucsComputeBladeFsmFlags	0	0	Cisco UCS compute:Blade:fsmFlags managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.19	cucsComputeBladeFsmPrev	0	0	Cisco UCS compute:Blade:fsmPrev managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.20	cucsComputeBladeFsmProgr	0	0	Cisco UCS compute:Blade:fsmProgr managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.21	cucsComputeBladeFsmRmtInvErrCode	0	0	Cisco UCS compute:Blade:fsmRmtInvErrCode managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.22	cucsComputeBladeFsmRmtInvErrDescr	0	0	Cisco UCS compute:Blade:fsmRmtInvErrDescr managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.23	cucsComputeBladeFsmRmtInvRslt	0	0	Cisco UCS compute:Blade:fsmRmtInvRslt managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.24	cucsComputeBladeFsmStageDescr	0	0	Cisco UCS compute:Blade:fsmStageDescr managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.25	cucsComputeBladeFsmStamp	0	0	Cisco UCS compute:Blade:fsmStamp managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.26	cucsComputeBladeFsmStatus	0	0	Cisco UCS compute:Blade:fsmStatus managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.27	cucsComputeBladeFsmTry	0	0	Cisco UCS compute:Blade:fsmTry managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.28	cucsComputeBladeIntId	0	0	Cisco UCS compute:Blade:intId managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.29	cucsComputeBladeLc	0	0	Cisco UCS compute:Blade:lc managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.30	cucsComputeBladeLcTs	0	0	Cisco UCS compute:Blade:lcTs managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.31	cucsComputeBladeManagingInst	0	0	Cisco UCS compute:Blade:managingInst managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.32	cucsComputeBladeModel	0	0	Cisco UCS compute:Blade:model managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.33	cucsComputeBladeName	0	0	Cisco UCS compute:Blade:name managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.34	cucsComputeBladeNumOfAdaptors	0	0	Cisco UCS compute:Blade:numOfAdaptors managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.35	cucsComputeBladeNumOfCores	0	0	Cisco UCS compute:Blade:numOfCores managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.36	cucsComputeBladeNumOfCpus	0	0	Cisco UCS compute:Blade:numOfCpus managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.37	cucsComputeBladeNumOfEthHostIfs	0	0	Cisco UCS compute:Blade:numOfEthHostIfs managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.38	cucsComputeBladeNumOfFcHostIfs	0	0	Cisco UCS compute:Blade:numOfFcHostIfs managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.39	cucsComputeBladeNumOfThreads	0	0	cucsComputeBladeNumOfthreads
1.3.6.1.4.1.9.9.719.1.9.2.1.40	cucsComputeBladeOperPower	0	0	Cisco UCS compute:Blade:operPower managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.41	cucsComputeBladeOperQualifier	0	0	Cisco UCS compute:Blade:operQualifier managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.42	cucsComputeBladeOperState	0	0	Cisco UCS compute:Blade:operState managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.43	cucsComputeBladeOperability	0	0	Cisco UCS compute:Blade:operability managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.44	cucsComputeBladeOriginalUuid	0	0	Cisco UCS compute:Blade:originalUuid managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.45	cucsComputeBladePresence	0	0	Cisco UCS compute:Blade:presence managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.46	cucsComputeBladeRevision	0	0	Cisco UCS compute:Blade:revision managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.47	cucsComputeBladeSerial	0	0	Cisco UCS compute:Blade:serial managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.48	cucsComputeBladeServerId	0	0	Cisco UCS compute:Blade:serverId managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.49	cucsComputeBladeSlotId	0	0	Cisco UCS compute:Blade:slotId managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.50	cucsComputeBladeTotalMemory	0	0	Cisco UCS compute:Blade:totalMemory managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.51	cucsComputeBladeUsrLbl	0	0	Cisco UCS compute:Blade:usrLbl managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.52	cucsComputeBladeUuid	0	0	Cisco UCS compute:Blade:uuid managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.53	cucsComputeBladeVendor	0	0	Cisco UCS compute:Blade:vendor managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.54	cucsComputeBladeNumOfCoresEnabled	0	0	Cisco UCS compute:Blade:numOfCoresEnabled managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.55	cucsComputeBladeLowVoltageMemory	0	0	Cisco UCS compute:Blade:lowVoltageMemory managed object property
1.3.6.1.4.1.9.9.719.1.9.2.1.56	cucsComputeBladeMemorySpeed	0	0	Cisco UCS compute:Blade:memorySpeed managed object property
*/
public class CiscoUcsComputeBladeTableTracker extends TableTracker {

    public static final String cucsComputeBladeDn = "cucsComputeBladeDn";
    public static final String cucsComputeBladeRn = "cucsComputeBladeRn";
    public static final String cucsComputeBladeAdminPower = "cucsComputeBladeAdminPower";
    public static final String cucsComputeBladeAdminState = "cucsComputeBladeAdminState";
    public static final String cucsComputeBladeAssignedToDn = "cucsComputeBladeAssignedToDn";
    public static final String cucsComputeBladeAssociation = "cucsComputeBladeAssociation";
    public static final String cucsComputeBladeAvailability = "cucsComputeBladeAvailability";
    public static final String cucsComputeBladeAvailableMemory = "cucsComputeBladeAvailableMemory";
    public static final String cucsComputeBladeChassisId = "cucsComputeBladeChassisId";
    public static final String cucsComputeBladeCheckPoint = "cucsComputeBladeCheckPoint";
    public static final String cucsComputeBladeConnPath = "cucsComputeBladeConnPath";
    public static final String cucsComputeBladeConnStatus = "cucsComputeBladeConnStatus";
    public static final String cucsComputeBladeDescr = "cucsComputeBladeDescr";
    public static final String cucsComputeBladeDiscovery = "cucsComputeBladeDiscovery";
    public static final String cucsComputeBladeFltAggr = "cucsComputeBladeFltAggr";
    public static final String cucsComputeBladeFsmDescr = "cucsComputeBladeFsmDescr";
    public static final String cucsComputeBladeFsmFlags = "cucsComputeBladeFsmFlags";
    public static final String cucsComputeBladeFsmPrev = "cucsComputeBladeFsmPrev";
    public static final String cucsComputeBladeFsmProgr = "cucsComputeBladeFsmProgr";
    public static final String cucsComputeBladeFsmRmtInvErrCode = "cucsComputeBladeFsmRmtInvErrCode";
    public static final String cucsComputeBladeFsmRmtInvErrDescr = "cucsComputeBladeFsmRmtInvErrDescr";
    public static final String cucsComputeBladeFsmRmtInvRslt = "cucsComputeBladeFsmRmtInvRslt";
    public static final String cucsComputeBladeFsmStageDescr = "cucsComputeBladeFsmStageDescr";
    public static final String cucsComputeBladeFsmStamp = "cucsComputeBladeFsmStamp";
    public static final String cucsComputeBladeFsmStatus = "cucsComputeBladeFsmStatus";
    public static final String cucsComputeBladeFsmTry = "cucsComputeBladeFsmTry";
    public static final String cucsComputeBladeIntId = "cucsComputeBladeIntId";
    public static final String cucsComputeBladeLc = "cucsComputeBladeLc";
    public static final String cucsComputeBladeLcTs = "cucsComputeBladeLcTs";
    public static final String cucsComputeBladeManagingInst = "cucsComputeBladeManagingInst";
    public static final String cucsComputeBladeModel = "cucsComputeBladeModel";
    public static final String cucsComputeBladeName = "cucsComputeBladeName";
    public static final String cucsComputeBladeNumOfAdaptors = "cucsComputeBladeNumOfAdaptors";
    public static final String cucsComputeBladeNumOfCores = "cucsComputeBladeNumOfCores";
    public static final String cucsComputeBladeNumOfCpus = "cucsComputeBladeNumOfCpus";
    public static final String cucsComputeBladeNumOfEthHostIfs = "cucsComputeBladeNumOfEthHostIfs";
    public static final String cucsComputeBladeNumOfFcHostIfs = "cucsComputeBladeNumOfFcHostIfs";
    public static final String cucsComputeBladeNumOfThreads = "cucsComputeBladeNumOfThreads";
    public static final String cucsComputeBladeOperPower = "cucsComputeBladeOperPower";
    public static final String cucsComputeBladeOperQualifier = "cucsComputeBladeOperQualifier";
    public static final String cucsComputeBladeOperState = "cucsComputeBladeOperState";
    public static final String cucsComputeBladeOperability = "cucsComputeBladeOperability";
    public static final String cucsComputeBladeOriginalUuid = "cucsComputeBladeOriginalUuid";
    public static final String cucsComputeBladePresence = "cucsComputeBladePresence";
    public static final String cucsComputeBladeRevision = "cucsComputeBladeRevision";
    public static final String cucsComputeBladeSerial = "cucsComputeBladeSerial";
    public static final String cucsComputeBladeServerId = "cucsComputeBladeServerId";
    public static final String cucsComputeBladeSlotId = "cucsComputeBladeSlotId";
    public static final String cucsComputeBladeTotalMemory = "cucsComputeBladeTotalMemory";
    public static final String cucsComputeBladeUsrLbl = "cucsComputeBladeUsrLbl";
    public static final String cucsComputeBladeUuid = "cucsComputeBladeUuid";
    public static final String cucsComputeBladeVendor = "cucsComputeBladeVendor";
    public static final String cucsComputeBladeNumOfCoresEnabled = "cucsComputeBladeNumOfCoresEnabled";
    public static final String cucsComputeBladeLowVoltageMemory = "cucsComputeBladeLowVoltageMemory";
    public static final String cucsComputeBladeMemorySpeed = "cucsComputeBladeMemorySpeed";

    public static final SnmpObjId cucsComputeBladeDnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.2");
    public static final SnmpObjId cucsComputeBladeRnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.3");
    public static final SnmpObjId cucsComputeBladeAdminPowerObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.4");
    public static final SnmpObjId cucsComputeBladeAdminStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.5");
    public static final SnmpObjId cucsComputeBladeAssignedToDnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.6");
    public static final SnmpObjId cucsComputeBladeAssociationObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.7");
    public static final SnmpObjId cucsComputeBladeAvailabilityObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.8");
    public static final SnmpObjId cucsComputeBladeAvailableMemoryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.9");
    public static final SnmpObjId cucsComputeBladeChassisIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.10");
    public static final SnmpObjId cucsComputeBladeCheckPointObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.11");
    public static final SnmpObjId cucsComputeBladeConnPathObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.12");
    public static final SnmpObjId cucsComputeBladeConnStatusObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.13");
    public static final SnmpObjId cucsComputeBladeDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.14");
    public static final SnmpObjId cucsComputeBladeDiscoveryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.15");
    public static final SnmpObjId cucsComputeBladeFltAggrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.16");
    public static final SnmpObjId cucsComputeBladeFsmDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.17");
    public static final SnmpObjId cucsComputeBladeFsmFlagsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.18");
    public static final SnmpObjId cucsComputeBladeFsmPrevObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.19");
    public static final SnmpObjId cucsComputeBladeFsmProgrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.20");
    public static final SnmpObjId cucsComputeBladeFsmRmtInvErrCodeObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.21");
    public static final SnmpObjId cucsComputeBladeFsmRmtInvErrDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.22");
    public static final SnmpObjId cucsComputeBladeFsmRmtInvRsltObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.23");
    public static final SnmpObjId cucsComputeBladeFsmStageDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.24");
    public static final SnmpObjId cucsComputeBladeFsmStampObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.25");
    public static final SnmpObjId cucsComputeBladeFsmStatusObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.26");
    public static final SnmpObjId cucsComputeBladeFsmTryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.27");
    public static final SnmpObjId cucsComputeBladeIntIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.28");
    public static final SnmpObjId cucsComputeBladeLcObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.29");
    public static final SnmpObjId cucsComputeBladeLcTsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.30");
    public static final SnmpObjId cucsComputeBladeManagingInstObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.31");
    public static final SnmpObjId cucsComputeBladeModelObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.32");
    public static final SnmpObjId cucsComputeBladeNameObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.33");
    public static final SnmpObjId cucsComputeBladeNumOfAdaptorsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.34");
    public static final SnmpObjId cucsComputeBladeNumOfCoresObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.35");
    public static final SnmpObjId cucsComputeBladeNumOfCpusObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.36");
    public static final SnmpObjId cucsComputeBladeNumOfEthHostIfsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.37");
    public static final SnmpObjId cucsComputeBladeNumOfFcHostIfsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.38");
    public static final SnmpObjId cucsComputeBladeNumOfThreadsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.39");
    public static final SnmpObjId cucsComputeBladeOperPowerObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.40");
    public static final SnmpObjId cucsComputeBladeOperQualifierObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.41");
    public static final SnmpObjId cucsComputeBladeOperStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.42");
    public static final SnmpObjId cucsComputeBladeOperabilityObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.43");
    public static final SnmpObjId cucsComputeBladeOriginalUuidObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.44");
    public static final SnmpObjId cucsComputeBladePresenceObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.45");
    public static final SnmpObjId cucsComputeBladeRevisionObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.46");
    public static final SnmpObjId cucsComputeBladeSerialObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.47");
    public static final SnmpObjId cucsComputeBladeServerIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.48");
    public static final SnmpObjId cucsComputeBladeSlotIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.49");
    public static final SnmpObjId cucsComputeBladeTotalMemoryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.50");
    public static final SnmpObjId cucsComputeBladeUsrLblObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.51");
    public static final SnmpObjId cucsComputeBladeUuidObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.52");
    public static final SnmpObjId cucsComputeBladeVendorObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.53");
    public static final SnmpObjId cucsComputeBladeNumOfCoresEnabledObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.54");
    public static final SnmpObjId cucsComputeBladeLowVoltageMemoryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.55");
    public static final SnmpObjId cucsComputeBladeMemorySpeedObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.2.1.56");
    public static final SnmpObjId[] s_elemList = new SnmpObjId[]{
            cucsComputeBladeDnObjId,
            cucsComputeBladeRnObjId,
            cucsComputeBladeAdminPowerObjId,
            cucsComputeBladeAdminStateObjId,
            cucsComputeBladeAssignedToDnObjId,
            cucsComputeBladeAssociationObjId,
            cucsComputeBladeAvailabilityObjId,
            cucsComputeBladeAvailableMemoryObjId,
            cucsComputeBladeChassisIdObjId,
            cucsComputeBladeCheckPointObjId,
            cucsComputeBladeConnPathObjId,
            cucsComputeBladeConnStatusObjId,
            cucsComputeBladeDescrObjId,
            cucsComputeBladeDiscoveryObjId,
            cucsComputeBladeFltAggrObjId,
            cucsComputeBladeFsmDescrObjId,
            cucsComputeBladeFsmFlagsObjId,
            cucsComputeBladeFsmPrevObjId,
            cucsComputeBladeFsmProgrObjId,
            cucsComputeBladeFsmRmtInvErrCodeObjId,
            cucsComputeBladeFsmRmtInvErrDescrObjId,
            cucsComputeBladeFsmRmtInvRsltObjId,
            cucsComputeBladeFsmStageDescrObjId,
            cucsComputeBladeFsmStampObjId,
            cucsComputeBladeFsmStatusObjId,
            cucsComputeBladeFsmTryObjId,
            cucsComputeBladeIntIdObjId,
            cucsComputeBladeLcObjId,
            cucsComputeBladeLcTsObjId,
            cucsComputeBladeManagingInstObjId,
            cucsComputeBladeModelObjId,
            cucsComputeBladeNameObjId,
            cucsComputeBladeNumOfAdaptorsObjId,
            cucsComputeBladeNumOfCoresObjId,
            cucsComputeBladeNumOfCpusObjId,
            cucsComputeBladeNumOfEthHostIfsObjId,
            cucsComputeBladeNumOfFcHostIfsObjId,
            cucsComputeBladeNumOfThreadsObjId,
            cucsComputeBladeOperPowerObjId,
            cucsComputeBladeOperQualifierObjId,
            cucsComputeBladeOperStateObjId,
            cucsComputeBladeOperabilityObjId,
            cucsComputeBladeOriginalUuidObjId,
            cucsComputeBladePresenceObjId,
            cucsComputeBladeRevisionObjId,
            cucsComputeBladeSerialObjId,
            cucsComputeBladeServerIdObjId,
            cucsComputeBladeSlotIdObjId,
            cucsComputeBladeTotalMemoryObjId,
            cucsComputeBladeUsrLblObjId,
            cucsComputeBladeUuidObjId,
            cucsComputeBladeVendorObjId,
            cucsComputeBladeNumOfCoresEnabledObjId,
            cucsComputeBladeLowVoltageMemoryObjId,
            cucsComputeBladeMemorySpeedObjId,
    };

    public CiscoUcsComputeBladeTableTracker() {
        super(s_elemList);
    }

    @Override
    public SnmpRowResult createRowResult(final int columnCount, final SnmpInstId instance) {
        return new CiscoUcsComputeBladeTableRow(columnCount, instance);
    }

    @Override
    public void rowCompleted(final SnmpRowResult row) {
        processCiscoUcsComputeBladeTableRow((CiscoUcsComputeBladeTableRow)row);
    }

    private void processCiscoUcsComputeBladeTableRow(CiscoUcsComputeBladeTableRow row) {
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeDnObjId + "." + row.getInstance().toString(), cucsComputeBladeDn, row.getCucsComputeBladeDn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeRnObjId + "." + row.getInstance().toString(), cucsComputeBladeRn, row.getCucsComputeBladeRn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeAdminPowerObjId + "." + row.getInstance().toString(), cucsComputeBladeAdminPower, row.getCucsComputeBladeAdminPower(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeAdminStateObjId + "." + row.getInstance().toString(), cucsComputeBladeAdminState, row.getCucsComputeBladeAdminState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeAssignedToDnObjId + "." + row.getInstance().toString(), cucsComputeBladeAssignedToDn, row.getCucsComputeBladeAssignedToDn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeAssociationObjId + "." + row.getInstance().toString(), cucsComputeBladeAssociation, row.getCucsComputeBladeAssociation(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeAvailabilityObjId + "." + row.getInstance().toString(), cucsComputeBladeAvailability, row.getCucsComputeBladeAvailability(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeAvailableMemoryObjId + "." + row.getInstance().toString(), cucsComputeBladeAvailableMemory, row.getCucsComputeBladeAvailableMemory(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeChassisIdObjId + "." + row.getInstance().toString(), cucsComputeBladeChassisId, row.getCucsComputeBladeChassisId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeCheckPointObjId + "." + row.getInstance().toString(), cucsComputeBladeCheckPoint, row.getCucsComputeBladeCheckPoint(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeConnPathObjId + "." + row.getInstance().toString(), cucsComputeBladeConnPath, row.getCucsComputeBladeConnPath(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeConnStatusObjId + "." + row.getInstance().toString(), cucsComputeBladeConnStatus, row.getCucsComputeBladeConnStatus(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeDescrObjId + "." + row.getInstance().toString(), cucsComputeBladeDescr, row.getCucsComputeBladeDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeDiscoveryObjId + "." + row.getInstance().toString(), cucsComputeBladeDiscovery, row.getCucsComputeBladeDiscovery(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFltAggrObjId + "." + row.getInstance().toString(), cucsComputeBladeFltAggr, row.getCucsComputeBladeFltAggr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmDescrObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmDescr, row.getCucsComputeBladeFsmDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmFlagsObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmFlags, row.getCucsComputeBladeFsmFlags(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmPrevObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmPrev, row.getCucsComputeBladeFsmPrev(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmProgrObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmProgr, row.getCucsComputeBladeFsmProgr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmRmtInvErrCodeObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmRmtInvErrCode, row.getCucsComputeBladeFsmRmtInvErrCode(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmRmtInvErrDescrObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmRmtInvErrDescr, row.getCucsComputeBladeFsmRmtInvErrDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmRmtInvRsltObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmRmtInvRslt, row.getCucsComputeBladeFsmRmtInvRslt(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmStageDescrObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmStageDescr, row.getCucsComputeBladeFsmStageDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmStampObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmStamp, row.getCucsComputeBladeFsmStamp(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmStatusObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmStatus, row.getCucsComputeBladeFsmStatus(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeFsmTryObjId + "." + row.getInstance().toString(), cucsComputeBladeFsmTry, row.getCucsComputeBladeFsmTry(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeIntIdObjId + "." + row.getInstance().toString(), cucsComputeBladeIntId, row.getCucsComputeBladeIntId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeLcObjId + "." + row.getInstance().toString(), cucsComputeBladeLc, row.getCucsComputeBladeLc(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeLcTsObjId + "." + row.getInstance().toString(), cucsComputeBladeLcTs, row.getCucsComputeBladeLcTs(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeManagingInstObjId + "." + row.getInstance().toString(), cucsComputeBladeManagingInst, row.getCucsComputeBladeManagingInst(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeModelObjId + "." + row.getInstance().toString(), cucsComputeBladeModel, row.getCucsComputeBladeModel(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeNameObjId + "." + row.getInstance().toString(), cucsComputeBladeName, row.getCucsComputeBladeName(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeNumOfAdaptorsObjId + "." + row.getInstance().toString(), cucsComputeBladeNumOfAdaptors, row.getCucsComputeBladeNumOfAdaptors(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeNumOfCoresObjId + "." + row.getInstance().toString(), cucsComputeBladeNumOfCores, row.getCucsComputeBladeNumOfCores(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeNumOfCpusObjId + "." + row.getInstance().toString(), cucsComputeBladeNumOfCpus, row.getCucsComputeBladeNumOfCpus(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeNumOfEthHostIfsObjId + "." + row.getInstance().toString(), cucsComputeBladeNumOfEthHostIfs, row.getCucsComputeBladeNumOfEthHostIfs(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeNumOfFcHostIfsObjId + "." + row.getInstance().toString(), cucsComputeBladeNumOfFcHostIfs, row.getCucsComputeBladeNumOfFcHostIfs(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeNumOfThreadsObjId + "." + row.getInstance().toString(), cucsComputeBladeNumOfThreads, row.getCucsComputeBladeNumOfThreads(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeOperPowerObjId + "." + row.getInstance().toString(), cucsComputeBladeOperPower, row.getCucsComputeBladeOperPower(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeOperQualifierObjId + "." + row.getInstance().toString(), cucsComputeBladeOperQualifier, row.getCucsComputeBladeOperQualifier(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeOperStateObjId + "." + row.getInstance().toString(), cucsComputeBladeOperState, row.getCucsComputeBladeOperState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeOperabilityObjId + "." + row.getInstance().toString(), cucsComputeBladeOperability, row.getCucsComputeBladeOperability(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeOriginalUuidObjId + "." + row.getInstance().toString(), cucsComputeBladeOriginalUuid, row.getCucsComputeBladeOriginalUuid(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladePresenceObjId + "." + row.getInstance().toString(), cucsComputeBladePresence, row.getCucsComputeBladePresence(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeRevisionObjId + "." + row.getInstance().toString(), cucsComputeBladeRevision, row.getCucsComputeBladeRevision(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeSerialObjId + "." + row.getInstance().toString(), cucsComputeBladeSerial, row.getCucsComputeBladeSerial(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeServerIdObjId + "." + row.getInstance().toString(), cucsComputeBladeServerId, row.getCucsComputeBladeServerId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeSlotIdObjId + "." + row.getInstance().toString(), cucsComputeBladeSlotId, row.getCucsComputeBladeSlotId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeTotalMemoryObjId + "." + row.getInstance().toString(), cucsComputeBladeTotalMemory, row.getCucsComputeBladeTotalMemory(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeUsrLblObjId + "." + row.getInstance().toString(), cucsComputeBladeUsrLbl, row.getCucsComputeBladeUsrLbl(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeUuidObjId + "." + row.getInstance().toString(), cucsComputeBladeUuid, row.getCucsComputeBladeUuid(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeVendorObjId + "." + row.getInstance().toString(), cucsComputeBladeVendor, row.getCucsComputeBladeVendor(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeNumOfCoresEnabledObjId + "." + row.getInstance().toString(), cucsComputeBladeNumOfCoresEnabled, row.getCucsComputeBladeNumOfCoresEnabled(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeLowVoltageMemoryObjId + "." + row.getInstance().toString(), cucsComputeBladeLowVoltageMemory, row.getCucsComputeBladeLowVoltageMemory(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBladeMemorySpeedObjId + "." + row.getInstance().toString(), cucsComputeBladeMemorySpeed, row.getCucsComputeBladeMemorySpeed(), "STRING");
    }

    public static class CiscoUcsComputeBladeTableRow extends SnmpRowResult {

         public CiscoUcsComputeBladeTableRow(int columnCount, SnmpInstId instance) {
             super(columnCount, instance);
         }


        public String getCucsComputeBladeDn() {
            return getValue(cucsComputeBladeDnObjId).toString();
        }

        public String getCucsComputeBladeRn() {
            return getValue(cucsComputeBladeRnObjId).toString();
        }

        public String getCucsComputeBladeAdminPower() {
            return getValue(cucsComputeBladeAdminPowerObjId).toString();
        }

        public String getCucsComputeBladeAdminState() {
            return getValue(cucsComputeBladeAdminStateObjId).toString();
        }

        public String getCucsComputeBladeAssignedToDn() {
            return getValue(cucsComputeBladeAssignedToDnObjId).toString();
        }

        public String getCucsComputeBladeAssociation() {
            return getValue(cucsComputeBladeAssociationObjId).toString();
        }

        public String getCucsComputeBladeAvailability() {
            return getValue(cucsComputeBladeAvailabilityObjId).toString();
        }

        public String getCucsComputeBladeAvailableMemory() {
            return getValue(cucsComputeBladeAvailableMemoryObjId).toString();
        }

        public String getCucsComputeBladeChassisId() {
            return getValue(cucsComputeBladeChassisIdObjId).toString();
        }

        public String getCucsComputeBladeCheckPoint() {
            return getValue(cucsComputeBladeCheckPointObjId).toString();
        }

        public String getCucsComputeBladeConnPath() {
            return getValue(cucsComputeBladeConnPathObjId).toString();
        }

        public String getCucsComputeBladeConnStatus() {
            return getValue(cucsComputeBladeConnStatusObjId).toString();
        }

        public String getCucsComputeBladeDescr() {
            return getValue(cucsComputeBladeDescrObjId).toString();
        }

        public String getCucsComputeBladeDiscovery() {
            return getValue(cucsComputeBladeDiscoveryObjId).toString();
        }

        public String getCucsComputeBladeFltAggr() {
            return getValue(cucsComputeBladeFltAggrObjId).toString();
        }

        public String getCucsComputeBladeFsmDescr() {
            return getValue(cucsComputeBladeFsmDescrObjId).toString();
        }

        public String getCucsComputeBladeFsmFlags() {
            return getValue(cucsComputeBladeFsmFlagsObjId).toString();
        }

        public String getCucsComputeBladeFsmPrev() {
            return getValue(cucsComputeBladeFsmPrevObjId).toString();
        }

        public String getCucsComputeBladeFsmProgr() {
            return getValue(cucsComputeBladeFsmProgrObjId).toString();
        }

        public String getCucsComputeBladeFsmRmtInvErrCode() {
            return getValue(cucsComputeBladeFsmRmtInvErrCodeObjId).toString();
        }

        public String getCucsComputeBladeFsmRmtInvErrDescr() {
            return getValue(cucsComputeBladeFsmRmtInvErrDescrObjId).toString();
        }

        public String getCucsComputeBladeFsmRmtInvRslt() {
            return getValue(cucsComputeBladeFsmRmtInvRsltObjId).toString();
        }

        public String getCucsComputeBladeFsmStageDescr() {
            return getValue(cucsComputeBladeFsmStageDescrObjId).toString();
        }

        public String getCucsComputeBladeFsmStamp() {
            return getValue(cucsComputeBladeFsmStampObjId).toString();
        }

        public String getCucsComputeBladeFsmStatus() {
            return getValue(cucsComputeBladeFsmStatusObjId).toString();
        }

        public String getCucsComputeBladeFsmTry() {
            return getValue(cucsComputeBladeFsmTryObjId).toString();
        }

        public String getCucsComputeBladeIntId() {
            return getValue(cucsComputeBladeIntIdObjId).toString();
        }

        public String getCucsComputeBladeLc() {
            return getValue(cucsComputeBladeLcObjId).toString();
        }

        public String getCucsComputeBladeLcTs() {
            return getValue(cucsComputeBladeLcTsObjId).toString();
        }

        public String getCucsComputeBladeManagingInst() {
            return getValue(cucsComputeBladeManagingInstObjId).toString();
        }

        public String getCucsComputeBladeModel() {
            return getValue(cucsComputeBladeModelObjId).toString();
        }

        public String getCucsComputeBladeName() {
            return getValue(cucsComputeBladeNameObjId).toString();
        }

        public String getCucsComputeBladeNumOfAdaptors() {
            return getValue(cucsComputeBladeNumOfAdaptorsObjId).toString();
        }

        public String getCucsComputeBladeNumOfCores() {
            return getValue(cucsComputeBladeNumOfCoresObjId).toString();
        }

        public String getCucsComputeBladeNumOfCpus() {
            return getValue(cucsComputeBladeNumOfCpusObjId).toString();
        }

        public String getCucsComputeBladeNumOfEthHostIfs() {
            return getValue(cucsComputeBladeNumOfEthHostIfsObjId).toString();
        }

        public String getCucsComputeBladeNumOfFcHostIfs() {
            return getValue(cucsComputeBladeNumOfFcHostIfsObjId).toString();
        }

        public String getCucsComputeBladeNumOfThreads() {
            return getValue(cucsComputeBladeNumOfThreadsObjId).toString();
        }

        public String getCucsComputeBladeOperPower() {
            return getValue(cucsComputeBladeOperPowerObjId).toString();
        }

        public String getCucsComputeBladeOperQualifier() {
            return getValue(cucsComputeBladeOperQualifierObjId).toString();
        }

        public String getCucsComputeBladeOperState() {
            return getValue(cucsComputeBladeOperStateObjId).toString();
        }

        public String getCucsComputeBladeOperability() {
            return getValue(cucsComputeBladeOperabilityObjId).toString();
        }

        public String getCucsComputeBladeOriginalUuid() {
            return getValue(cucsComputeBladeOriginalUuidObjId).toString();
        }

        public String getCucsComputeBladePresence() {
            return getValue(cucsComputeBladePresenceObjId).toString();
        }

        public String getCucsComputeBladeRevision() {
            return getValue(cucsComputeBladeRevisionObjId).toString();
        }

        public String getCucsComputeBladeSerial() {
            return getValue(cucsComputeBladeSerialObjId).toString();
        }

        public String getCucsComputeBladeServerId() {
            return getValue(cucsComputeBladeServerIdObjId).toString();
        }

        public String getCucsComputeBladeSlotId() {
            return getValue(cucsComputeBladeSlotIdObjId).toString();
        }

        public String getCucsComputeBladeTotalMemory() {
            return getValue(cucsComputeBladeTotalMemoryObjId).toString();
        }

        public String getCucsComputeBladeUsrLbl() {
            return getValue(cucsComputeBladeUsrLblObjId).toString();
        }

        public String getCucsComputeBladeUuid() {
            return getValue(cucsComputeBladeUuidObjId).toString();
        }

        public String getCucsComputeBladeVendor() {
            return getValue(cucsComputeBladeVendorObjId).toString();
        }

        public String getCucsComputeBladeNumOfCoresEnabled() {
            return getValue(cucsComputeBladeNumOfCoresEnabledObjId).toString();
        }

        public String getCucsComputeBladeLowVoltageMemory() {
            return getValue(cucsComputeBladeLowVoltageMemoryObjId).toString();
        }

        public String getCucsComputeBladeMemorySpeed() {
            return getValue(cucsComputeBladeMemorySpeedObjId).toString();
        }

    }
}
