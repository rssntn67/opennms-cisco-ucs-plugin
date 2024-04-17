package it.xeniaprogetti.cisco.ucs.plugin.snmp;

import org.opennms.netmgt.snmp.SnmpInstId;
import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpRowResult;
import org.opennms.netmgt.snmp.TableTracker;

/*
1.3.6.1.4.1.9.9.719.1.15.7.1.2	cucsEquipmentChassisDn	0	0	Cisco UCS equipment:Chassis:dn managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.3	cucsEquipmentChassisRn	0	0	Cisco UCS equipment:Chassis:rn managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.4	cucsEquipmentChassisAdminState	0	0	Cisco UCS equipment:Chassis:adminState managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.5	cucsEquipmentChassisConfigState	0	0	Cisco UCS equipment:Chassis:configState managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.6	cucsEquipmentChassisConnPath	0	0	Cisco UCS equipment:Chassis:connPath managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.7	cucsEquipmentChassisConnStatus	0	0	Cisco UCS equipment:Chassis:connStatus managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.8	cucsEquipmentChassisFabricEpDn	0	0	Cisco UCS equipment:Chassis:fabricEpDn managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.9	cucsEquipmentChassisFltAggr	0	0	Cisco UCS equipment:Chassis:fltAggr managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.10	cucsEquipmentChassisFsmDescr	0	0	Cisco UCS equipment:Chassis:fsmDescr managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.11	cucsEquipmentChassisFsmPrev	0	0	Cisco UCS equipment:Chassis:fsmPrev managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.12	cucsEquipmentChassisFsmProgr	0	0	Cisco UCS equipment:Chassis:fsmProgr managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.13	cucsEquipmentChassisFsmRmtInvErrCode	0	0	Cisco UCS equipment:Chassis:fsmRmtInvErrCode managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.14	cucsEquipmentChassisFsmRmtInvErrDescr	0	0	Cisco UCS equipment:Chassis:fsmRmtInvErrDescr managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.15	cucsEquipmentChassisFsmRmtInvRslt	0	0	Cisco UCS equipment:Chassis:fsmRmtInvRslt managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.16	cucsEquipmentChassisFsmStageDescr	0	0	Cisco UCS equipment:Chassis:fsmStageDescr managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.17	cucsEquipmentChassisFsmStamp	0	0	Cisco UCS equipment:Chassis:fsmStamp managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.18	cucsEquipmentChassisFsmStatus	0	0	Cisco UCS equipment:Chassis:fsmStatus managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.19	cucsEquipmentChassisFsmTry	0	0	Cisco UCS equipment:Chassis:fsmTry managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.20	cucsEquipmentChassisId	0	0	Cisco UCS equipment:Chassis:id managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.21	cucsEquipmentChassisLcTs	0	0	Cisco UCS equipment:Chassis:lcTs managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.22	cucsEquipmentChassisLicGP	0	0	Cisco UCS equipment:Chassis:licGP managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.23	cucsEquipmentChassisLicState	0	0	Cisco UCS equipment:Chassis:licState managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.24	cucsEquipmentChassisManagingInst	0	0	Cisco UCS equipment:Chassis:managingInst managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.25	cucsEquipmentChassisModel	0	0	Cisco UCS equipment:Chassis:model managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.26	cucsEquipmentChassisOperQualifier	0	0	Cisco UCS equipment:Chassis:operQualifier managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.27	cucsEquipmentChassisOperState	0	0	Cisco UCS equipment:Chassis:operState managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.28	cucsEquipmentChassisOperability	0	0	Cisco UCS equipment:Chassis:operability managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.29	cucsEquipmentChassisPower	0	0	Cisco UCS equipment:Chassis:power managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.30	cucsEquipmentChassisPresence	0	0	Cisco UCS equipment:Chassis:presence managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.31	cucsEquipmentChassisRevision	0	0	Cisco UCS equipment:Chassis:revision managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.32	cucsEquipmentChassisSerial	0	0	Cisco UCS equipment:Chassis:serial managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.33	cucsEquipmentChassisThermal	0	0	Cisco UCS equipment:Chassis:thermal managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.34	cucsEquipmentChassisUsrLbl	0	0	Cisco UCS equipment:Chassis:usrLbl managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.35	cucsEquipmentChassisVendor	0	0	Cisco UCS equipment:Chassis:vendor managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.36	cucsEquipmentChassisVersionHolder	0	0	Cisco UCS equipment:Chassis:versionHolder managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.37	cucsEquipmentChassisAckProgressIndicator	0	0	Cisco UCS equipment:Chassis:ackProgressIndicator managed object property
1.3.6.1.4.1.9.9.719.1.15.7.1.38	cucsEquipmentChassisSeepromOperState	0	0	Cisco UCS equipment:Chassis:seepromOperState managed object property
*/
public class CiscoUcsEquipmentChassisTableTracker extends TableTracker {

    public static final String cucsEquipmentChassisDn = "cucsEquipmentChassisDn";
    public static final String cucsEquipmentChassisRn = "cucsEquipmentChassisRn";
    public static final String cucsEquipmentChassisAdminState = "cucsEquipmentChassisAdminState";
    public static final String cucsEquipmentChassisConfigState = "cucsEquipmentChassisConfigState";
    public static final String cucsEquipmentChassisConnPath = "cucsEquipmentChassisConnPath";
    public static final String cucsEquipmentChassisConnStatus = "cucsEquipmentChassisConnStatus";
    public static final String cucsEquipmentChassisFabricEpDn = "cucsEquipmentChassisFabricEpDn";
    public static final String cucsEquipmentChassisFltAggr = "cucsEquipmentChassisFltAggr";
    public static final String cucsEquipmentChassisFsmDescr = "cucsEquipmentChassisFsmDescr";
    public static final String cucsEquipmentChassisFsmPrev = "cucsEquipmentChassisFsmPrev";
    public static final String cucsEquipmentChassisFsmProgr = "cucsEquipmentChassisFsmProgr";
    public static final String cucsEquipmentChassisFsmRmtInvErrCode = "cucsEquipmentChassisFsmRmtInvErrCode";
    public static final String cucsEquipmentChassisFsmRmtInvErrDescr = "cucsEquipmentChassisFsmRmtInvErrDescr";
    public static final String cucsEquipmentChassisFsmRmtInvRslt = "cucsEquipmentChassisFsmRmtInvRslt";
    public static final String cucsEquipmentChassisFsmStageDescr = "cucsEquipmentChassisFsmStageDescr";
    public static final String cucsEquipmentChassisFsmStamp = "cucsEquipmentChassisFsmStamp";
    public static final String cucsEquipmentChassisFsmStatus = "cucsEquipmentChassisFsmStatus";
    public static final String cucsEquipmentChassisFsmTry = "cucsEquipmentChassisFsmTry";
    public static final String cucsEquipmentChassisId = "cucsEquipmentChassisId";
    public static final String cucsEquipmentChassisLcTs = "cucsEquipmentChassisLcTs";
    public static final String cucsEquipmentChassisLicGP = "cucsEquipmentChassisLicGP";
    public static final String cucsEquipmentChassisLicState = "cucsEquipmentChassisLicState";
    public static final String cucsEquipmentChassisManagingInst = "cucsEquipmentChassisManagingInst";
    public static final String cucsEquipmentChassisModel = "cucsEquipmentChassisModel";
    public static final String cucsEquipmentChassisOperQualifier = "cucsEquipmentChassisOperQualifier";
    public static final String cucsEquipmentChassisOperState = "cucsEquipmentChassisOperState";
    public static final String cucsEquipmentChassisOperability = "cucsEquipmentChassisOperability";
    public static final String cucsEquipmentChassisPower = "cucsEquipmentChassisPower";
    public static final String cucsEquipmentChassisPresence = "cucsEquipmentChassisPresence";
    public static final String cucsEquipmentChassisRevision = "cucsEquipmentChassisRevision";
    public static final String cucsEquipmentChassisSerial = "cucsEquipmentChassisSerial";
    public static final String cucsEquipmentChassisThermal = "cucsEquipmentChassisThermal";
    public static final String cucsEquipmentChassisUsrLbl = "cucsEquipmentChassisUsrLbl";
    public static final String cucsEquipmentChassisVendor = "cucsEquipmentChassisVendor";
    public static final String cucsEquipmentChassisVersionHolder = "cucsEquipmentChassisVersionHolder";
    public static final String cucsEquipmentChassisAckProgressIndicator = "cucsEquipmentChassisAckProgressIndicator";
    public static final String cucsEquipmentChassisSeepromOperState = "cucsEquipmentChassisSeepromOperState";

    public static final SnmpObjId cucsEquipmentChassisDnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.2");
    public static final SnmpObjId cucsEquipmentChassisRnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.3");
    public static final SnmpObjId cucsEquipmentChassisAdminStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.4");
    public static final SnmpObjId cucsEquipmentChassisConfigStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.5");
    public static final SnmpObjId cucsEquipmentChassisConnPathObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.6");
    public static final SnmpObjId cucsEquipmentChassisConnStatusObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.7");
    public static final SnmpObjId cucsEquipmentChassisFabricEpDnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.8");
    public static final SnmpObjId cucsEquipmentChassisFltAggrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.9");
    public static final SnmpObjId cucsEquipmentChassisFsmDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.10");
    public static final SnmpObjId cucsEquipmentChassisFsmPrevObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.11");
    public static final SnmpObjId cucsEquipmentChassisFsmProgrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.12");
    public static final SnmpObjId cucsEquipmentChassisFsmRmtInvErrCodeObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.13");
    public static final SnmpObjId cucsEquipmentChassisFsmRmtInvErrDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.14");
    public static final SnmpObjId cucsEquipmentChassisFsmRmtInvRsltObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.15");
    public static final SnmpObjId cucsEquipmentChassisFsmStageDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.16");
    public static final SnmpObjId cucsEquipmentChassisFsmStampObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.17");
    public static final SnmpObjId cucsEquipmentChassisFsmStatusObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.18");
    public static final SnmpObjId cucsEquipmentChassisFsmTryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.19");
    public static final SnmpObjId cucsEquipmentChassisIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.20");
    public static final SnmpObjId cucsEquipmentChassisLcTsObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.21");
    public static final SnmpObjId cucsEquipmentChassisLicGPObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.22");
    public static final SnmpObjId cucsEquipmentChassisLicStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.23");
    public static final SnmpObjId cucsEquipmentChassisManagingInstObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.24");
    public static final SnmpObjId cucsEquipmentChassisModelObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.25");
    public static final SnmpObjId cucsEquipmentChassisOperQualifierObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.26");
    public static final SnmpObjId cucsEquipmentChassisOperStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.27");
    public static final SnmpObjId cucsEquipmentChassisOperabilityObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.28");
    public static final SnmpObjId cucsEquipmentChassisPowerObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.29");
    public static final SnmpObjId cucsEquipmentChassisPresenceObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.30");
    public static final SnmpObjId cucsEquipmentChassisRevisionObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.31");
    public static final SnmpObjId cucsEquipmentChassisSerialObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.32");
    public static final SnmpObjId cucsEquipmentChassisThermalObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.33");
    public static final SnmpObjId cucsEquipmentChassisUsrLblObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.34");
    public static final SnmpObjId cucsEquipmentChassisVendorObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.35");
    public static final SnmpObjId cucsEquipmentChassisVersionHolderObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.36");
    public static final SnmpObjId cucsEquipmentChassisAckProgressIndicatorObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.37");
    public static final SnmpObjId cucsEquipmentChassisSeepromOperStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.7.1.38");
    public static final SnmpObjId[] s_elemList = new SnmpObjId[]{
            cucsEquipmentChassisDnObjId,
            cucsEquipmentChassisRnObjId,
            cucsEquipmentChassisAdminStateObjId,
            cucsEquipmentChassisConfigStateObjId,
            cucsEquipmentChassisConnPathObjId,
            cucsEquipmentChassisConnStatusObjId,
            cucsEquipmentChassisFabricEpDnObjId,
            cucsEquipmentChassisFltAggrObjId,
            cucsEquipmentChassisFsmDescrObjId,
            cucsEquipmentChassisFsmPrevObjId,
            cucsEquipmentChassisFsmProgrObjId,
            cucsEquipmentChassisFsmRmtInvErrCodeObjId,
            cucsEquipmentChassisFsmRmtInvErrDescrObjId,
            cucsEquipmentChassisFsmRmtInvRsltObjId,
            cucsEquipmentChassisFsmStageDescrObjId,
            cucsEquipmentChassisFsmStampObjId,
            cucsEquipmentChassisFsmStatusObjId,
            cucsEquipmentChassisFsmTryObjId,
            cucsEquipmentChassisIdObjId,
            cucsEquipmentChassisLcTsObjId,
            cucsEquipmentChassisLicGPObjId,
            cucsEquipmentChassisLicStateObjId,
            cucsEquipmentChassisManagingInstObjId,
            cucsEquipmentChassisModelObjId,
            cucsEquipmentChassisOperQualifierObjId,
            cucsEquipmentChassisOperStateObjId,
            cucsEquipmentChassisOperabilityObjId,
            cucsEquipmentChassisPowerObjId,
            cucsEquipmentChassisPresenceObjId,
            cucsEquipmentChassisRevisionObjId,
            cucsEquipmentChassisSerialObjId,
            cucsEquipmentChassisThermalObjId,
            cucsEquipmentChassisUsrLblObjId,
            cucsEquipmentChassisVendorObjId,
            cucsEquipmentChassisVersionHolderObjId,
            cucsEquipmentChassisAckProgressIndicatorObjId,
            cucsEquipmentChassisSeepromOperStateObjId,
    };

    public CiscoUcsEquipmentChassisTableTracker() {
        super(s_elemList);
    }

    @Override
    public SnmpRowResult createRowResult(final int columnCount, final SnmpInstId instance) {
        return new CiscoUcsEquipmentChassisTableRow(columnCount, instance);
    }

    @Override
    public void rowCompleted(final SnmpRowResult row) {
        processCiscoUcsEquipmentChassisTableRow((CiscoUcsEquipmentChassisTableRow)row);
    }

    private void processCiscoUcsEquipmentChassisTableRow(CiscoUcsEquipmentChassisTableRow row) {
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisDnObjId + "." + row.getInstance().toString(), cucsEquipmentChassisDn, row.getCucsEquipmentChassisDn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisRnObjId + "." + row.getInstance().toString(), cucsEquipmentChassisRn, row.getCucsEquipmentChassisRn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisAdminStateObjId + "." + row.getInstance().toString(), cucsEquipmentChassisAdminState, row.getCucsEquipmentChassisAdminState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisConfigStateObjId + "." + row.getInstance().toString(), cucsEquipmentChassisConfigState, row.getCucsEquipmentChassisConfigState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisConnPathObjId + "." + row.getInstance().toString(), cucsEquipmentChassisConnPath, row.getCucsEquipmentChassisConnPath(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisConnStatusObjId + "." + row.getInstance().toString(), cucsEquipmentChassisConnStatus, row.getCucsEquipmentChassisConnStatus(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFabricEpDnObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFabricEpDn, row.getCucsEquipmentChassisFabricEpDn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFltAggrObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFltAggr, row.getCucsEquipmentChassisFltAggr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmDescrObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmDescr, row.getCucsEquipmentChassisFsmDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmPrevObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmPrev, row.getCucsEquipmentChassisFsmPrev(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmProgrObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmProgr, row.getCucsEquipmentChassisFsmProgr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmRmtInvErrCodeObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmRmtInvErrCode, row.getCucsEquipmentChassisFsmRmtInvErrCode(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmRmtInvErrDescrObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmRmtInvErrDescr, row.getCucsEquipmentChassisFsmRmtInvErrDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmRmtInvRsltObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmRmtInvRslt, row.getCucsEquipmentChassisFsmRmtInvRslt(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmStageDescrObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmStageDescr, row.getCucsEquipmentChassisFsmStageDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmStampObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmStamp, row.getCucsEquipmentChassisFsmStamp(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmStatusObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmStatus, row.getCucsEquipmentChassisFsmStatus(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisFsmTryObjId + "." + row.getInstance().toString(), cucsEquipmentChassisFsmTry, row.getCucsEquipmentChassisFsmTry(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisIdObjId + "." + row.getInstance().toString(), cucsEquipmentChassisId, row.getCucsEquipmentChassisId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisLcTsObjId + "." + row.getInstance().toString(), cucsEquipmentChassisLcTs, row.getCucsEquipmentChassisLcTs(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisLicGPObjId + "." + row.getInstance().toString(), cucsEquipmentChassisLicGP, row.getCucsEquipmentChassisLicGP(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisLicStateObjId + "." + row.getInstance().toString(), cucsEquipmentChassisLicState, row.getCucsEquipmentChassisLicState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisManagingInstObjId + "." + row.getInstance().toString(), cucsEquipmentChassisManagingInst, row.getCucsEquipmentChassisManagingInst(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisModelObjId + "." + row.getInstance().toString(), cucsEquipmentChassisModel, row.getCucsEquipmentChassisModel(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisOperQualifierObjId + "." + row.getInstance().toString(), cucsEquipmentChassisOperQualifier, row.getCucsEquipmentChassisOperQualifier(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisOperStateObjId + "." + row.getInstance().toString(), cucsEquipmentChassisOperState, row.getCucsEquipmentChassisOperState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisOperabilityObjId + "." + row.getInstance().toString(), cucsEquipmentChassisOperability, row.getCucsEquipmentChassisOperability(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisPowerObjId + "." + row.getInstance().toString(), cucsEquipmentChassisPower, row.getCucsEquipmentChassisPower(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisPresenceObjId + "." + row.getInstance().toString(), cucsEquipmentChassisPresence, row.getCucsEquipmentChassisPresence(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisRevisionObjId + "." + row.getInstance().toString(), cucsEquipmentChassisRevision, row.getCucsEquipmentChassisRevision(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisSerialObjId + "." + row.getInstance().toString(), cucsEquipmentChassisSerial, row.getCucsEquipmentChassisSerial(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisThermalObjId + "." + row.getInstance().toString(), cucsEquipmentChassisThermal, row.getCucsEquipmentChassisThermal(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisUsrLblObjId + "." + row.getInstance().toString(), cucsEquipmentChassisUsrLbl, row.getCucsEquipmentChassisUsrLbl(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisVendorObjId + "." + row.getInstance().toString(), cucsEquipmentChassisVendor, row.getCucsEquipmentChassisVendor(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisVersionHolderObjId + "." + row.getInstance().toString(), cucsEquipmentChassisVersionHolder, row.getCucsEquipmentChassisVersionHolder(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisAckProgressIndicatorObjId + "." + row.getInstance().toString(), cucsEquipmentChassisAckProgressIndicator, row.getCucsEquipmentChassisAckProgressIndicator(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentChassisSeepromOperStateObjId + "." + row.getInstance().toString(), cucsEquipmentChassisSeepromOperState, row.getCucsEquipmentChassisSeepromOperState(), "STRING");
    }

    public static class CiscoUcsEquipmentChassisTableRow extends SnmpRowResult {

         public CiscoUcsEquipmentChassisTableRow(int columnCount, SnmpInstId instance) {
             super(columnCount, instance);
         }


        public String getCucsEquipmentChassisDn() {
            return getValue(cucsEquipmentChassisDnObjId).toString();
        }

        public String getCucsEquipmentChassisRn() {
            return getValue(cucsEquipmentChassisRnObjId).toString();
        }

        public String getCucsEquipmentChassisAdminState() {
            return getValue(cucsEquipmentChassisAdminStateObjId).toString();
        }

        public String getCucsEquipmentChassisConfigState() {
            return getValue(cucsEquipmentChassisConfigStateObjId).toString();
        }

        public String getCucsEquipmentChassisConnPath() {
            return getValue(cucsEquipmentChassisConnPathObjId).toString();
        }

        public String getCucsEquipmentChassisConnStatus() {
            return getValue(cucsEquipmentChassisConnStatusObjId).toString();
        }

        public String getCucsEquipmentChassisFabricEpDn() {
            return getValue(cucsEquipmentChassisFabricEpDnObjId).toString();
        }

        public String getCucsEquipmentChassisFltAggr() {
            return getValue(cucsEquipmentChassisFltAggrObjId).toString();
        }

        public String getCucsEquipmentChassisFsmDescr() {
            return getValue(cucsEquipmentChassisFsmDescrObjId).toString();
        }

        public String getCucsEquipmentChassisFsmPrev() {
            return getValue(cucsEquipmentChassisFsmPrevObjId).toString();
        }

        public String getCucsEquipmentChassisFsmProgr() {
            return getValue(cucsEquipmentChassisFsmProgrObjId).toString();
        }

        public String getCucsEquipmentChassisFsmRmtInvErrCode() {
            return getValue(cucsEquipmentChassisFsmRmtInvErrCodeObjId).toString();
        }

        public String getCucsEquipmentChassisFsmRmtInvErrDescr() {
            return getValue(cucsEquipmentChassisFsmRmtInvErrDescrObjId).toString();
        }

        public String getCucsEquipmentChassisFsmRmtInvRslt() {
            return getValue(cucsEquipmentChassisFsmRmtInvRsltObjId).toString();
        }

        public String getCucsEquipmentChassisFsmStageDescr() {
            return getValue(cucsEquipmentChassisFsmStageDescrObjId).toString();
        }

        public String getCucsEquipmentChassisFsmStamp() {
            return getValue(cucsEquipmentChassisFsmStampObjId).toString();
        }

        public String getCucsEquipmentChassisFsmStatus() {
            return getValue(cucsEquipmentChassisFsmStatusObjId).toString();
        }

        public String getCucsEquipmentChassisFsmTry() {
            return getValue(cucsEquipmentChassisFsmTryObjId).toString();
        }

        public String getCucsEquipmentChassisId() {
            return getValue(cucsEquipmentChassisIdObjId).toString();
        }

        public String getCucsEquipmentChassisLcTs() {
            return getValue(cucsEquipmentChassisLcTsObjId).toString();
        }

        public String getCucsEquipmentChassisLicGP() {
            return getValue(cucsEquipmentChassisLicGPObjId).toString();
        }

        public String getCucsEquipmentChassisLicState() {
            return getValue(cucsEquipmentChassisLicStateObjId).toString();
        }

        public String getCucsEquipmentChassisManagingInst() {
            return getValue(cucsEquipmentChassisManagingInstObjId).toString();
        }

        public String getCucsEquipmentChassisModel() {
            return getValue(cucsEquipmentChassisModelObjId).toString();
        }

        public String getCucsEquipmentChassisOperQualifier() {
            return getValue(cucsEquipmentChassisOperQualifierObjId).toString();
        }

        public String getCucsEquipmentChassisOperState() {
            return getValue(cucsEquipmentChassisOperStateObjId).toString();
        }

        public String getCucsEquipmentChassisOperability() {
            return getValue(cucsEquipmentChassisOperabilityObjId).toString();
        }

        public String getCucsEquipmentChassisPower() {
            return getValue(cucsEquipmentChassisPowerObjId).toString();
        }

        public String getCucsEquipmentChassisPresence() {
            return getValue(cucsEquipmentChassisPresenceObjId).toString();
        }

        public String getCucsEquipmentChassisRevision() {
            return getValue(cucsEquipmentChassisRevisionObjId).toString();
        }

        public String getCucsEquipmentChassisSerial() {
            return getValue(cucsEquipmentChassisSerialObjId).toString();
        }

        public String getCucsEquipmentChassisThermal() {
            return getValue(cucsEquipmentChassisThermalObjId).toString();
        }

        public String getCucsEquipmentChassisUsrLbl() {
            return getValue(cucsEquipmentChassisUsrLblObjId).toString();
        }

        public String getCucsEquipmentChassisVendor() {
            return getValue(cucsEquipmentChassisVendorObjId).toString();
        }

        public String getCucsEquipmentChassisVersionHolder() {
            return getValue(cucsEquipmentChassisVersionHolderObjId).toString();
        }

        public String getCucsEquipmentChassisAckProgressIndicator() {
            return getValue(cucsEquipmentChassisAckProgressIndicatorObjId).toString();
        }

        public String getCucsEquipmentChassisSeepromOperState() {
            return getValue(cucsEquipmentChassisSeepromOperStateObjId).toString();
        }

    }
}
