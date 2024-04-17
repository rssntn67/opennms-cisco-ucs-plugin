package it.xeniaprogetti.cisco.ucs.plugin.snmp;

import org.opennms.netmgt.snmp.SnmpInstId;
import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpRowResult;
import org.opennms.netmgt.snmp.TableTracker;

/*
1.3.6.1.4.1.9.9.719.1.9.35.1.2	cucsComputeRackUnitDn	0	0	Cisco UCS compute:RackUnit:dn managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.3	cucsComputeRackUnitRn	0	0	Cisco UCS compute:RackUnit:rn managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.4	cucsComputeRackUnitAdminPower	0	0	Cisco UCS compute:RackUnit:adminPower managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.5	cucsComputeRackUnitAdminState	0	0	Cisco UCS compute:RackUnit:adminState managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.6	cucsComputeRackUnitAssignedToDn	0	0	Cisco UCS compute:RackUnit:assignedToDn managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.7	cucsComputeRackUnitAssociation	0	0	Cisco UCS compute:RackUnit:association managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.8	cucsComputeRackUnitAvailability	0	0	Cisco UCS compute:RackUnit:availability managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.9	cucsComputeRackUnitAvailableMemory	0	0	Cisco UCS compute:RackUnit:availableMemory managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.10	cucsComputeRackUnitCheckPoint	0	0	Cisco UCS compute:RackUnit:checkPoint managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.11	cucsComputeRackUnitConnPath	0	0	Cisco UCS compute:RackUnit:connPath managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.12	cucsComputeRackUnitConnStatus	0	0	Cisco UCS compute:RackUnit:connStatus managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.13	cucsComputeRackUnitDescr	0	0	Cisco UCS compute:RackUnit:descr managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.14	cucsComputeRackUnitDiscovery	0	0	Cisco UCS compute:RackUnit:discovery managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.15	cucsComputeRackUnitFltAggr	0	0	Cisco UCS compute:RackUnit:fltAggr managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.16	cucsComputeRackUnitFsmDescr	0	0	Cisco UCS compute:RackUnit:fsmDescr managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.17	cucsComputeRackUnitFsmFlags	0	0	Cisco UCS compute:RackUnit:fsmFlags managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.18	cucsComputeRackUnitFsmPrev	0	0	Cisco UCS compute:RackUnit:fsmPrev managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.19	cucsComputeRackUnitFsmProgr	0	0	Cisco UCS compute:RackUnit:fsmProgr managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.20	cucsComputeRackUnitFsmRmtInvErrCode	0	0	Cisco UCS compute:RackUnit:fsmRmtInvErrCode managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.21	cucsComputeRackUnitFsmRmtInvErrDescr	0	0	Cisco UCS compute:RackUnit:fsmRmtInvErrDescr managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.22	cucsComputeRackUnitFsmRmtInvRslt	0	0	Cisco UCS compute:RackUnit:fsmRmtInvRslt managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.23	cucsComputeRackUnitFsmStageDescr	0	0	Cisco UCS compute:RackUnit:fsmStageDescr managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.24	cucsComputeRackUnitFsmStamp	0	0	Cisco UCS compute:RackUnit:fsmStamp managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.25	cucsComputeRackUnitFsmStatus	0	0	Cisco UCS compute:RackUnit:fsmStatus managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.26	cucsComputeRackUnitFsmTry	0	0	Cisco UCS compute:RackUnit:fsmTry managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.27	cucsComputeRackUnitId	0	0	Cisco UCS compute:RackUnit:id managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.28	cucsComputeRackUnitIntId	0	0	Cisco UCS compute:RackUnit:intId managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.29	cucsComputeRackUnitLc	0	0	Cisco UCS compute:RackUnit:lc managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.30	cucsComputeRackUnitLcTs	0	0	Cisco UCS compute:RackUnit:lcTs managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.31	cucsComputeRackUnitManagingInst	0	0	Cisco UCS compute:RackUnit:managingInst managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.32	cucsComputeRackUnitModel	0	0	Cisco UCS compute:RackUnit:model managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.33	cucsComputeRackUnitName	0	0	Cisco UCS compute:RackUnit:name managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.34	cucsComputeRackUnitNumOfAdaptors	0	0	Cisco UCS compute:RackUnit:numOfAdaptors managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.35	cucsComputeRackUnitNumOfCores	0	0	Cisco UCS compute:RackUnit:numOfCores managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.36	cucsComputeRackUnitNumOfCpus	0	0	Cisco UCS compute:RackUnit:numOfCpus managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.37	cucsComputeRackUnitNumOfEthHostIfs	0	0	Cisco UCS compute:RackUnit:numOfEthHostIfs managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.38	cucsComputeRackUnitNumOfFcHostIfs	0	0	Cisco UCS compute:RackUnit:numOfFcHostIfs managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.39	cucsComputeRackUnitNumOfThreads	0	0	cucsComputeRackUnitNumOfthreads
1.3.6.1.4.1.9.9.719.1.9.35.1.40	cucsComputeRackUnitOperPower	0	0	Cisco UCS compute:RackUnit:operPower managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.41	cucsComputeRackUnitOperQualifier	0	0	Cisco UCS compute:RackUnit:operQualifier managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.42	cucsComputeRackUnitOperState	0	0	Cisco UCS compute:RackUnit:operState managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.43	cucsComputeRackUnitOperability	0	0	Cisco UCS compute:RackUnit:operability managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.44	cucsComputeRackUnitOriginalUuid	0	0	Cisco UCS compute:RackUnit:originalUuid managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.45	cucsComputeRackUnitPresence	0	0	Cisco UCS compute:RackUnit:presence managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.46	cucsComputeRackUnitRevision	0	0	Cisco UCS compute:RackUnit:revision managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.47	cucsComputeRackUnitSerial	0	0	Cisco UCS compute:RackUnit:serial managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.48	cucsComputeRackUnitServerId	0	0	Cisco UCS compute:RackUnit:serverId managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.49	cucsComputeRackUnitTotalMemory	0	0	Cisco UCS compute:RackUnit:totalMemory managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.50	cucsComputeRackUnitUuid	0	0	Cisco UCS compute:RackUnit:uuid managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.51	cucsComputeRackUnitVendor	0	0	Cisco UCS compute:RackUnit:vendor managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.52	cucsComputeRackUnitVersionHolder	0	0	Cisco UCS compute:RackUnit:versionHolder managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.53	cucsComputeRackUnitNumOfCoresEnabled	0	0	Cisco UCS compute:RackUnit:numOfCoresEnabled managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.54	cucsComputeRackUnitLowVoltageMemory	0	0	Cisco UCS compute:RackUnit:lowVoltageMemory managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.55	cucsComputeRackUnitMemorySpeed	0	0	Cisco UCS compute:RackUnit:memorySpeed managed object property
1.3.6.1.4.1.9.9.719.1.9.35.1.56	cucsComputeRackUnitUsrLbl	0	0	Cisco UCS compute:RackUnit:usrLbl managed object property
*/
public class CiscoUcsComputeRackUnitTableTracker extends TableTracker {

    public static final String cucsComputeRackUnitDn = "cucsComputeRackUnitDn";
    public static final String cucsComputeRackUnitRn = "cucsComputeRackUnitRn";
    public static final String cucsComputeRackUnitAdminPower = "cucsComputeRackUnitAdminPower";
    public static final String cucsComputeRackUnitAdminState = "cucsComputeRackUnitAdminState";
    public static final String cucsComputeRackUnitAssignedToDn = "cucsComputeRackUnitAssignedToDn";
    public static final String cucsComputeRackUnitAssociation = "cucsComputeRackUnitAssociation";
    public static final String cucsComputeRackUnitAvailability = "cucsComputeRackUnitAvailability";
    public static final String cucsComputeRackUnitAvailableMemory = "cucsComputeRackUnitAvailableMemory";
    public static final String cucsComputeRackUnitCheckPoint = "cucsComputeRackUnitCheckPoint";
    public static final String cucsComputeRackUnitConnPath = "cucsComputeRackUnitConnPath";
    public static final String cucsComputeRackUnitConnStatus = "cucsComputeRackUnitConnStatus";
    public static final String cucsComputeRackUnitDescr = "cucsComputeRackUnitDescr";
    public static final String cucsComputeRackUnitDiscovery = "cucsComputeRackUnitDiscovery";
    public static final String cucsComputeRackUnitFltAggr = "cucsComputeRackUnitFltAggr";
    public static final String cucsComputeRackUnitFsmDescr = "cucsComputeRackUnitFsmDescr";
    public static final String cucsComputeRackUnitFsmFlags = "cucsComputeRackUnitFsmFlags";
    public static final String cucsComputeRackUnitFsmPrev = "cucsComputeRackUnitFsmPrev";
    public static final String cucsComputeRackUnitFsmProgr = "cucsComputeRackUnitFsmProgr";
    public static final String cucsComputeRackUnitFsmRmtInvErrCode = "cucsComputeRackUnitFsmRmtInvErrCode";
    public static final String cucsComputeRackUnitFsmRmtInvErrDescr = "cucsComputeRackUnitFsmRmtInvErrDescr";
    public static final String cucsComputeRackUnitFsmRmtInvRslt = "cucsComputeRackUnitFsmRmtInvRslt";
    public static final String cucsComputeRackUnitFsmStageDescr = "cucsComputeRackUnitFsmStageDescr";
    public static final String cucsComputeRackUnitFsmStamp = "cucsComputeRackUnitFsmStamp";
    public static final String cucsComputeRackUnitFsmStatus = "cucsComputeRackUnitFsmStatus";
    public static final String cucsComputeRackUnitFsmTry = "cucsComputeRackUnitFsmTry";
    public static final String cucsComputeRackUnitId = "cucsComputeRackUnitId";
    public static final String cucsComputeRackUnitIntId = "cucsComputeRackUnitIntId";
    public static final String cucsComputeRackUnitLc = "cucsComputeRackUnitLc";
    public static final String cucsComputeRackUnitLcTs = "cucsComputeRackUnitLcTs";
    public static final String cucsComputeRackUnitManagingInst = "cucsComputeRackUnitManagingInst";
    public static final String cucsComputeRackUnitModel = "cucsComputeRackUnitModel";
    public static final String cucsComputeRackUnitName = "cucsComputeRackUnitName";
    public static final String cucsComputeRackUnitNumOfAdaptors = "cucsComputeRackUnitNumOfAdaptors";
    public static final String cucsComputeRackUnitNumOfCores = "cucsComputeRackUnitNumOfCores";
    public static final String cucsComputeRackUnitNumOfCpus = "cucsComputeRackUnitNumOfCpus";
    public static final String cucsComputeRackUnitNumOfEthHostIfs = "cucsComputeRackUnitNumOfEthHostIfs";
    public static final String cucsComputeRackUnitNumOfFcHostIfs = "cucsComputeRackUnitNumOfFcHostIfs";
    public static final String cucsComputeRackUnitNumOfThreads = "cucsComputeRackUnitNumOfThreads";
    public static final String cucsComputeRackUnitOperPower = "cucsComputeRackUnitOperPower";
    public static final String cucsComputeRackUnitOperQualifier = "cucsComputeRackUnitOperQualifier";
    public static final String cucsComputeRackUnitOperState = "cucsComputeRackUnitOperState";
    public static final String cucsComputeRackUnitOperability = "cucsComputeRackUnitOperability";
    public static final String cucsComputeRackUnitOriginalUuid = "cucsComputeRackUnitOriginalUuid";
    public static final String cucsComputeRackUnitPresence = "cucsComputeRackUnitPresence";
    public static final String cucsComputeRackUnitRevision = "cucsComputeRackUnitRevision";
    public static final String cucsComputeRackUnitSerial = "cucsComputeRackUnitSerial";
    public static final String cucsComputeRackUnitServerId = "cucsComputeRackUnitServerId";
    public static final String cucsComputeRackUnitTotalMemory = "cucsComputeRackUnitTotalMemory";
    public static final String cucsComputeRackUnitUuid = "cucsComputeRackUnitUuid";
    public static final String cucsComputeRackUnitVendor = "cucsComputeRackUnitVendor";
    public static final String cucsComputeRackUnitVersionHolder = "cucsComputeRackUnitVersionHolder";
    public static final String cucsComputeRackUnitNumOfCoresEnabled = "cucsComputeRackUnitNumOfCoresEnabled";
    public static final String cucsComputeRackUnitLowVoltageMemory = "cucsComputeRackUnitLowVoltageMemory";
    public static final String cucsComputeRackUnitMemorySpeed = "cucsComputeRackUnitMemorySpeed";
    public static final String cucsComputeRackUnitUsrLbl = "cucsComputeRackUnitUsrLbl";

    public static final SnmpObjId cucsComputeRackUnitDnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.2");
    public static final SnmpObjId cucsComputeRackUnitRnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.3");
    public static final SnmpObjId cucsComputeRackUnitAdminPowerObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.4");
    public static final SnmpObjId cucsComputeRackUnitAdminStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.5");
    public static final SnmpObjId cucsComputeRackUnitAssignedToDnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.6");
    public static final SnmpObjId cucsComputeRackUnitAssociationObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.7");
    public static final SnmpObjId cucsComputeRackUnitAvailabilityObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.8");
    public static final SnmpObjId cucsComputeRackUnitAvailableMemoryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.9");
    public static final SnmpObjId cucsComputeRackUnitCheckPointObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.10");
    public static final SnmpObjId cucsComputeRackUnitConnPathObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.11");
    public static final SnmpObjId cucsComputeRackUnitConnStatusObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.12");
    public static final SnmpObjId cucsComputeRackUnitDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.13");
    public static final SnmpObjId cucsComputeRackUnitDiscoveryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.14");
    public static final SnmpObjId cucsComputeRackUnitFltAggrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.15");
    public static final SnmpObjId cucsComputeRackUnitFsmDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.16");
    public static final SnmpObjId cucsComputeRackUnitFsmFlagsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.17");
    public static final SnmpObjId cucsComputeRackUnitFsmPrevObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.18");
    public static final SnmpObjId cucsComputeRackUnitFsmProgrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.19");
    public static final SnmpObjId cucsComputeRackUnitFsmRmtInvErrCodeObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.20");
    public static final SnmpObjId cucsComputeRackUnitFsmRmtInvErrDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.21");
    public static final SnmpObjId cucsComputeRackUnitFsmRmtInvRsltObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.22");
    public static final SnmpObjId cucsComputeRackUnitFsmStageDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.23");
    public static final SnmpObjId cucsComputeRackUnitFsmStampObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.24");
    public static final SnmpObjId cucsComputeRackUnitFsmStatusObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.25");
    public static final SnmpObjId cucsComputeRackUnitFsmTryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.26");
    public static final SnmpObjId cucsComputeRackUnitIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.27");
    public static final SnmpObjId cucsComputeRackUnitIntIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.28");
    public static final SnmpObjId cucsComputeRackUnitLcObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.29");
    public static final SnmpObjId cucsComputeRackUnitLcTsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.30");
    public static final SnmpObjId cucsComputeRackUnitManagingInstObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.31");
    public static final SnmpObjId cucsComputeRackUnitModelObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.32");
    public static final SnmpObjId cucsComputeRackUnitNameObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.33");
    public static final SnmpObjId cucsComputeRackUnitNumOfAdaptorsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.34");
    public static final SnmpObjId cucsComputeRackUnitNumOfCoresObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.35");
    public static final SnmpObjId cucsComputeRackUnitNumOfCpusObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.36");
    public static final SnmpObjId cucsComputeRackUnitNumOfEthHostIfsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.37");
    public static final SnmpObjId cucsComputeRackUnitNumOfFcHostIfsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.38");
    public static final SnmpObjId cucsComputeRackUnitNumOfThreadsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.39");
    public static final SnmpObjId cucsComputeRackUnitOperPowerObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.40");
    public static final SnmpObjId cucsComputeRackUnitOperQualifierObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.41");
    public static final SnmpObjId cucsComputeRackUnitOperStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.42");
    public static final SnmpObjId cucsComputeRackUnitOperabilityObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.43");
    public static final SnmpObjId cucsComputeRackUnitOriginalUuidObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.44");
    public static final SnmpObjId cucsComputeRackUnitPresenceObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.45");
    public static final SnmpObjId cucsComputeRackUnitRevisionObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.46");
    public static final SnmpObjId cucsComputeRackUnitSerialObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.47");
    public static final SnmpObjId cucsComputeRackUnitServerIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.48");
    public static final SnmpObjId cucsComputeRackUnitTotalMemoryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.49");
    public static final SnmpObjId cucsComputeRackUnitUuidObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.50");
    public static final SnmpObjId cucsComputeRackUnitVendorObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.51");
    public static final SnmpObjId cucsComputeRackUnitVersionHolderObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.52");
    public static final SnmpObjId cucsComputeRackUnitNumOfCoresEnabledObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.53");
    public static final SnmpObjId cucsComputeRackUnitLowVoltageMemoryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.54");
    public static final SnmpObjId cucsComputeRackUnitMemorySpeedObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.55");
    public static final SnmpObjId cucsComputeRackUnitUsrLblObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.35.1.56");
    public static final SnmpObjId[] s_elemList = new SnmpObjId[]{
            cucsComputeRackUnitDnObjId,
            cucsComputeRackUnitRnObjId,
            cucsComputeRackUnitAdminPowerObjId,
            cucsComputeRackUnitAdminStateObjId,
            cucsComputeRackUnitAssignedToDnObjId,
            cucsComputeRackUnitAssociationObjId,
            cucsComputeRackUnitAvailabilityObjId,
            cucsComputeRackUnitAvailableMemoryObjId,
            cucsComputeRackUnitCheckPointObjId,
            cucsComputeRackUnitConnPathObjId,
            cucsComputeRackUnitConnStatusObjId,
            cucsComputeRackUnitDescrObjId,
            cucsComputeRackUnitDiscoveryObjId,
            cucsComputeRackUnitFltAggrObjId,
            cucsComputeRackUnitFsmDescrObjId,
            cucsComputeRackUnitFsmFlagsObjId,
            cucsComputeRackUnitFsmPrevObjId,
            cucsComputeRackUnitFsmProgrObjId,
            cucsComputeRackUnitFsmRmtInvErrCodeObjId,
            cucsComputeRackUnitFsmRmtInvErrDescrObjId,
            cucsComputeRackUnitFsmRmtInvRsltObjId,
            cucsComputeRackUnitFsmStageDescrObjId,
            cucsComputeRackUnitFsmStampObjId,
            cucsComputeRackUnitFsmStatusObjId,
            cucsComputeRackUnitFsmTryObjId,
            cucsComputeRackUnitIdObjId,
            cucsComputeRackUnitIntIdObjId,
            cucsComputeRackUnitLcObjId,
            cucsComputeRackUnitLcTsObjId,
            cucsComputeRackUnitManagingInstObjId,
            cucsComputeRackUnitModelObjId,
            cucsComputeRackUnitNameObjId,
            cucsComputeRackUnitNumOfAdaptorsObjId,
            cucsComputeRackUnitNumOfCoresObjId,
            cucsComputeRackUnitNumOfCpusObjId,
            cucsComputeRackUnitNumOfEthHostIfsObjId,
            cucsComputeRackUnitNumOfFcHostIfsObjId,
            cucsComputeRackUnitNumOfThreadsObjId,
            cucsComputeRackUnitOperPowerObjId,
            cucsComputeRackUnitOperQualifierObjId,
            cucsComputeRackUnitOperStateObjId,
            cucsComputeRackUnitOperabilityObjId,
            cucsComputeRackUnitOriginalUuidObjId,
            cucsComputeRackUnitPresenceObjId,
            cucsComputeRackUnitRevisionObjId,
            cucsComputeRackUnitSerialObjId,
            cucsComputeRackUnitServerIdObjId,
            cucsComputeRackUnitTotalMemoryObjId,
            cucsComputeRackUnitUuidObjId,
            cucsComputeRackUnitVendorObjId,
            cucsComputeRackUnitVersionHolderObjId,
            cucsComputeRackUnitNumOfCoresEnabledObjId,
            cucsComputeRackUnitLowVoltageMemoryObjId,
            cucsComputeRackUnitMemorySpeedObjId,
            cucsComputeRackUnitUsrLblObjId,
    };

    public CiscoUcsComputeRackUnitTableTracker() {
        super(s_elemList);
    }

    @Override
    public SnmpRowResult createRowResult(final int columnCount, final SnmpInstId instance) {
        return new CiscoUcsComputeRackUnitTableRow(columnCount, instance);
    }

    @Override
    public void rowCompleted(final SnmpRowResult row) {
        processCiscoUcsComputeRackUnitTableRow((CiscoUcsComputeRackUnitTableRow)row);
    }

    private void processCiscoUcsComputeRackUnitTableRow(CiscoUcsComputeRackUnitTableRow row) {
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitDnObjId + "." + row.getInstance().toString(), cucsComputeRackUnitDn, row.getCucsComputeRackUnitDn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitRnObjId + "." + row.getInstance().toString(), cucsComputeRackUnitRn, row.getCucsComputeRackUnitRn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitAdminPowerObjId + "." + row.getInstance().toString(), cucsComputeRackUnitAdminPower, row.getCucsComputeRackUnitAdminPower(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitAdminStateObjId + "." + row.getInstance().toString(), cucsComputeRackUnitAdminState, row.getCucsComputeRackUnitAdminState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitAssignedToDnObjId + "." + row.getInstance().toString(), cucsComputeRackUnitAssignedToDn, row.getCucsComputeRackUnitAssignedToDn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitAssociationObjId + "." + row.getInstance().toString(), cucsComputeRackUnitAssociation, row.getCucsComputeRackUnitAssociation(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitAvailabilityObjId + "." + row.getInstance().toString(), cucsComputeRackUnitAvailability, row.getCucsComputeRackUnitAvailability(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitAvailableMemoryObjId + "." + row.getInstance().toString(), cucsComputeRackUnitAvailableMemory, row.getCucsComputeRackUnitAvailableMemory(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitCheckPointObjId + "." + row.getInstance().toString(), cucsComputeRackUnitCheckPoint, row.getCucsComputeRackUnitCheckPoint(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitConnPathObjId + "." + row.getInstance().toString(), cucsComputeRackUnitConnPath, row.getCucsComputeRackUnitConnPath(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitConnStatusObjId + "." + row.getInstance().toString(), cucsComputeRackUnitConnStatus, row.getCucsComputeRackUnitConnStatus(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitDescrObjId + "." + row.getInstance().toString(), cucsComputeRackUnitDescr, row.getCucsComputeRackUnitDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitDiscoveryObjId + "." + row.getInstance().toString(), cucsComputeRackUnitDiscovery, row.getCucsComputeRackUnitDiscovery(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFltAggrObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFltAggr, row.getCucsComputeRackUnitFltAggr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmDescrObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmDescr, row.getCucsComputeRackUnitFsmDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmFlagsObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmFlags, row.getCucsComputeRackUnitFsmFlags(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmPrevObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmPrev, row.getCucsComputeRackUnitFsmPrev(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmProgrObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmProgr, row.getCucsComputeRackUnitFsmProgr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmRmtInvErrCodeObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmRmtInvErrCode, row.getCucsComputeRackUnitFsmRmtInvErrCode(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmRmtInvErrDescrObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmRmtInvErrDescr, row.getCucsComputeRackUnitFsmRmtInvErrDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmRmtInvRsltObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmRmtInvRslt, row.getCucsComputeRackUnitFsmRmtInvRslt(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmStageDescrObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmStageDescr, row.getCucsComputeRackUnitFsmStageDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmStampObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmStamp, row.getCucsComputeRackUnitFsmStamp(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmStatusObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmStatus, row.getCucsComputeRackUnitFsmStatus(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitFsmTryObjId + "." + row.getInstance().toString(), cucsComputeRackUnitFsmTry, row.getCucsComputeRackUnitFsmTry(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitIdObjId + "." + row.getInstance().toString(), cucsComputeRackUnitId, row.getCucsComputeRackUnitId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitIntIdObjId + "." + row.getInstance().toString(), cucsComputeRackUnitIntId, row.getCucsComputeRackUnitIntId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitLcObjId + "." + row.getInstance().toString(), cucsComputeRackUnitLc, row.getCucsComputeRackUnitLc(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitLcTsObjId + "." + row.getInstance().toString(), cucsComputeRackUnitLcTs, row.getCucsComputeRackUnitLcTs(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitManagingInstObjId + "." + row.getInstance().toString(), cucsComputeRackUnitManagingInst, row.getCucsComputeRackUnitManagingInst(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitModelObjId + "." + row.getInstance().toString(), cucsComputeRackUnitModel, row.getCucsComputeRackUnitModel(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitNameObjId + "." + row.getInstance().toString(), cucsComputeRackUnitName, row.getCucsComputeRackUnitName(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitNumOfAdaptorsObjId + "." + row.getInstance().toString(), cucsComputeRackUnitNumOfAdaptors, row.getCucsComputeRackUnitNumOfAdaptors(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitNumOfCoresObjId + "." + row.getInstance().toString(), cucsComputeRackUnitNumOfCores, row.getCucsComputeRackUnitNumOfCores(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitNumOfCpusObjId + "." + row.getInstance().toString(), cucsComputeRackUnitNumOfCpus, row.getCucsComputeRackUnitNumOfCpus(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitNumOfEthHostIfsObjId + "." + row.getInstance().toString(), cucsComputeRackUnitNumOfEthHostIfs, row.getCucsComputeRackUnitNumOfEthHostIfs(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitNumOfFcHostIfsObjId + "." + row.getInstance().toString(), cucsComputeRackUnitNumOfFcHostIfs, row.getCucsComputeRackUnitNumOfFcHostIfs(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitNumOfThreadsObjId + "." + row.getInstance().toString(), cucsComputeRackUnitNumOfThreads, row.getCucsComputeRackUnitNumOfThreads(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitOperPowerObjId + "." + row.getInstance().toString(), cucsComputeRackUnitOperPower, row.getCucsComputeRackUnitOperPower(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitOperQualifierObjId + "." + row.getInstance().toString(), cucsComputeRackUnitOperQualifier, row.getCucsComputeRackUnitOperQualifier(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitOperStateObjId + "." + row.getInstance().toString(), cucsComputeRackUnitOperState, row.getCucsComputeRackUnitOperState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitOperabilityObjId + "." + row.getInstance().toString(), cucsComputeRackUnitOperability, row.getCucsComputeRackUnitOperability(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitOriginalUuidObjId + "." + row.getInstance().toString(), cucsComputeRackUnitOriginalUuid, row.getCucsComputeRackUnitOriginalUuid(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitPresenceObjId + "." + row.getInstance().toString(), cucsComputeRackUnitPresence, row.getCucsComputeRackUnitPresence(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitRevisionObjId + "." + row.getInstance().toString(), cucsComputeRackUnitRevision, row.getCucsComputeRackUnitRevision(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitSerialObjId + "." + row.getInstance().toString(), cucsComputeRackUnitSerial, row.getCucsComputeRackUnitSerial(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitServerIdObjId + "." + row.getInstance().toString(), cucsComputeRackUnitServerId, row.getCucsComputeRackUnitServerId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitTotalMemoryObjId + "." + row.getInstance().toString(), cucsComputeRackUnitTotalMemory, row.getCucsComputeRackUnitTotalMemory(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitUuidObjId + "." + row.getInstance().toString(), cucsComputeRackUnitUuid, row.getCucsComputeRackUnitUuid(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitVendorObjId + "." + row.getInstance().toString(), cucsComputeRackUnitVendor, row.getCucsComputeRackUnitVendor(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitVersionHolderObjId + "." + row.getInstance().toString(), cucsComputeRackUnitVersionHolder, row.getCucsComputeRackUnitVersionHolder(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitNumOfCoresEnabledObjId + "." + row.getInstance().toString(), cucsComputeRackUnitNumOfCoresEnabled, row.getCucsComputeRackUnitNumOfCoresEnabled(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitLowVoltageMemoryObjId + "." + row.getInstance().toString(), cucsComputeRackUnitLowVoltageMemory, row.getCucsComputeRackUnitLowVoltageMemory(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitMemorySpeedObjId + "." + row.getInstance().toString(), cucsComputeRackUnitMemorySpeed, row.getCucsComputeRackUnitMemorySpeed(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeRackUnitUsrLblObjId + "." + row.getInstance().toString(), cucsComputeRackUnitUsrLbl, row.getCucsComputeRackUnitUsrLbl(), "STRING");
    }

    public static class CiscoUcsComputeRackUnitTableRow extends SnmpRowResult {

         public CiscoUcsComputeRackUnitTableRow(int columnCount, SnmpInstId instance) {
             super(columnCount, instance);
         }


        public String getCucsComputeRackUnitDn() {
            return getValue(cucsComputeRackUnitDnObjId).toString();
        }

        public String getCucsComputeRackUnitRn() {
            return getValue(cucsComputeRackUnitRnObjId).toString();
        }

        public String getCucsComputeRackUnitAdminPower() {
            return getValue(cucsComputeRackUnitAdminPowerObjId).toString();
        }

        public String getCucsComputeRackUnitAdminState() {
            return getValue(cucsComputeRackUnitAdminStateObjId).toString();
        }

        public String getCucsComputeRackUnitAssignedToDn() {
            return getValue(cucsComputeRackUnitAssignedToDnObjId).toString();
        }

        public String getCucsComputeRackUnitAssociation() {
            return getValue(cucsComputeRackUnitAssociationObjId).toString();
        }

        public String getCucsComputeRackUnitAvailability() {
            return getValue(cucsComputeRackUnitAvailabilityObjId).toString();
        }

        public String getCucsComputeRackUnitAvailableMemory() {
            return getValue(cucsComputeRackUnitAvailableMemoryObjId).toString();
        }

        public String getCucsComputeRackUnitCheckPoint() {
            return getValue(cucsComputeRackUnitCheckPointObjId).toString();
        }

        public String getCucsComputeRackUnitConnPath() {
            return getValue(cucsComputeRackUnitConnPathObjId).toString();
        }

        public String getCucsComputeRackUnitConnStatus() {
            return getValue(cucsComputeRackUnitConnStatusObjId).toString();
        }

        public String getCucsComputeRackUnitDescr() {
            return getValue(cucsComputeRackUnitDescrObjId).toString();
        }

        public String getCucsComputeRackUnitDiscovery() {
            return getValue(cucsComputeRackUnitDiscoveryObjId).toString();
        }

        public String getCucsComputeRackUnitFltAggr() {
            return getValue(cucsComputeRackUnitFltAggrObjId).toString();
        }

        public String getCucsComputeRackUnitFsmDescr() {
            return getValue(cucsComputeRackUnitFsmDescrObjId).toString();
        }

        public String getCucsComputeRackUnitFsmFlags() {
            return getValue(cucsComputeRackUnitFsmFlagsObjId).toString();
        }

        public String getCucsComputeRackUnitFsmPrev() {
            return getValue(cucsComputeRackUnitFsmPrevObjId).toString();
        }

        public String getCucsComputeRackUnitFsmProgr() {
            return getValue(cucsComputeRackUnitFsmProgrObjId).toString();
        }

        public String getCucsComputeRackUnitFsmRmtInvErrCode() {
            return getValue(cucsComputeRackUnitFsmRmtInvErrCodeObjId).toString();
        }

        public String getCucsComputeRackUnitFsmRmtInvErrDescr() {
            return getValue(cucsComputeRackUnitFsmRmtInvErrDescrObjId).toString();
        }

        public String getCucsComputeRackUnitFsmRmtInvRslt() {
            return getValue(cucsComputeRackUnitFsmRmtInvRsltObjId).toString();
        }

        public String getCucsComputeRackUnitFsmStageDescr() {
            return getValue(cucsComputeRackUnitFsmStageDescrObjId).toString();
        }

        public String getCucsComputeRackUnitFsmStamp() {
            return getValue(cucsComputeRackUnitFsmStampObjId).toString();
        }

        public String getCucsComputeRackUnitFsmStatus() {
            return getValue(cucsComputeRackUnitFsmStatusObjId).toString();
        }

        public String getCucsComputeRackUnitFsmTry() {
            return getValue(cucsComputeRackUnitFsmTryObjId).toString();
        }

        public String getCucsComputeRackUnitId() {
            return getValue(cucsComputeRackUnitIdObjId).toString();
        }

        public String getCucsComputeRackUnitIntId() {
            return getValue(cucsComputeRackUnitIntIdObjId).toString();
        }

        public String getCucsComputeRackUnitLc() {
            return getValue(cucsComputeRackUnitLcObjId).toString();
        }

        public String getCucsComputeRackUnitLcTs() {
            return getValue(cucsComputeRackUnitLcTsObjId).toString();
        }

        public String getCucsComputeRackUnitManagingInst() {
            return getValue(cucsComputeRackUnitManagingInstObjId).toString();
        }

        public String getCucsComputeRackUnitModel() {
            return getValue(cucsComputeRackUnitModelObjId).toString();
        }

        public String getCucsComputeRackUnitName() {
            return getValue(cucsComputeRackUnitNameObjId).toString();
        }

        public String getCucsComputeRackUnitNumOfAdaptors() {
            return getValue(cucsComputeRackUnitNumOfAdaptorsObjId).toString();
        }

        public String getCucsComputeRackUnitNumOfCores() {
            return getValue(cucsComputeRackUnitNumOfCoresObjId).toString();
        }

        public String getCucsComputeRackUnitNumOfCpus() {
            return getValue(cucsComputeRackUnitNumOfCpusObjId).toString();
        }

        public String getCucsComputeRackUnitNumOfEthHostIfs() {
            return getValue(cucsComputeRackUnitNumOfEthHostIfsObjId).toString();
        }

        public String getCucsComputeRackUnitNumOfFcHostIfs() {
            return getValue(cucsComputeRackUnitNumOfFcHostIfsObjId).toString();
        }

        public String getCucsComputeRackUnitNumOfThreads() {
            return getValue(cucsComputeRackUnitNumOfThreadsObjId).toString();
        }

        public String getCucsComputeRackUnitOperPower() {
            return getValue(cucsComputeRackUnitOperPowerObjId).toString();
        }

        public String getCucsComputeRackUnitOperQualifier() {
            return getValue(cucsComputeRackUnitOperQualifierObjId).toString();
        }

        public String getCucsComputeRackUnitOperState() {
            return getValue(cucsComputeRackUnitOperStateObjId).toString();
        }

        public String getCucsComputeRackUnitOperability() {
            return getValue(cucsComputeRackUnitOperabilityObjId).toString();
        }

        public String getCucsComputeRackUnitOriginalUuid() {
            return getValue(cucsComputeRackUnitOriginalUuidObjId).toString();
        }

        public String getCucsComputeRackUnitPresence() {
            return getValue(cucsComputeRackUnitPresenceObjId).toString();
        }

        public String getCucsComputeRackUnitRevision() {
            return getValue(cucsComputeRackUnitRevisionObjId).toString();
        }

        public String getCucsComputeRackUnitSerial() {
            return getValue(cucsComputeRackUnitSerialObjId).toString();
        }

        public String getCucsComputeRackUnitServerId() {
            return getValue(cucsComputeRackUnitServerIdObjId).toString();
        }

        public String getCucsComputeRackUnitTotalMemory() {
            return getValue(cucsComputeRackUnitTotalMemoryObjId).toString();
        }

        public String getCucsComputeRackUnitUuid() {
            return getValue(cucsComputeRackUnitUuidObjId).toString();
        }

        public String getCucsComputeRackUnitVendor() {
            return getValue(cucsComputeRackUnitVendorObjId).toString();
        }

        public String getCucsComputeRackUnitVersionHolder() {
            return getValue(cucsComputeRackUnitVersionHolderObjId).toString();
        }

        public String getCucsComputeRackUnitNumOfCoresEnabled() {
            return getValue(cucsComputeRackUnitNumOfCoresEnabledObjId).toString();
        }

        public String getCucsComputeRackUnitLowVoltageMemory() {
            return getValue(cucsComputeRackUnitLowVoltageMemoryObjId).toString();
        }

        public String getCucsComputeRackUnitMemorySpeed() {
            return getValue(cucsComputeRackUnitMemorySpeedObjId).toString();
        }

        public String getCucsComputeRackUnitUsrLbl() {
            return getValue(cucsComputeRackUnitUsrLblObjId).toString();
        }

    }
}
