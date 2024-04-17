package it.xeniaprogetti.cisco.ucs.plugin.snmp;

import org.opennms.netmgt.snmp.SnmpInstId;
import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpRowResult;
import org.opennms.netmgt.snmp.TableTracker;

/*
1.3.6.1.4.1.9.9.719.1.15.19.1.2	cucsEquipmentFexDn	0	0	Cisco UCS equipment:Fex:dn managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.3	cucsEquipmentFexRn	0	0	Cisco UCS equipment:Fex:rn managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.4	cucsEquipmentFexAdminPowerState	0	0	Cisco UCS equipment:Fex:adminPowerState managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.5	cucsEquipmentFexAdminState	0	0	Cisco UCS equipment:Fex:adminState managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.6	cucsEquipmentFexConfigState	0	0	Cisco UCS equipment:Fex:configState managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.7	cucsEquipmentFexFltAggr	0	0	Cisco UCS equipment:Fex:fltAggr managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.8	cucsEquipmentFexFsmDescr	0	0	Cisco UCS equipment:Fex:fsmDescr managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.9	cucsEquipmentFexFsmPrev	0	0	Cisco UCS equipment:Fex:fsmPrev managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.10	cucsEquipmentFexFsmProgr	0	0	Cisco UCS equipment:Fex:fsmProgr managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.11	cucsEquipmentFexFsmRmtInvErrCode	0	0	Cisco UCS equipment:Fex:fsmRmtInvErrCode managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.12	cucsEquipmentFexFsmRmtInvErrDescr	0	0	Cisco UCS equipment:Fex:fsmRmtInvErrDescr managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.13	cucsEquipmentFexFsmRmtInvRslt	0	0	Cisco UCS equipment:Fex:fsmRmtInvRslt managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.14	cucsEquipmentFexFsmStageDescr	0	0	Cisco UCS equipment:Fex:fsmStageDescr managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.15	cucsEquipmentFexFsmStamp	0	0	Cisco UCS equipment:Fex:fsmStamp managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.16	cucsEquipmentFexFsmStatus	0	0	Cisco UCS equipment:Fex:fsmStatus managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.17	cucsEquipmentFexFsmTry	0	0	Cisco UCS equipment:Fex:fsmTry managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.18	cucsEquipmentFexId	0	0	Cisco UCS equipment:Fex:id managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.19	cucsEquipmentFexModel	0	0	Cisco UCS equipment:Fex:model managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.20	cucsEquipmentFexOperQualifier	0	0	Cisco UCS equipment:Fex:operQualifier managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.21	cucsEquipmentFexOperState	0	0	Cisco UCS equipment:Fex:operState managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.22	cucsEquipmentFexOperability	0	0	Cisco UCS equipment:Fex:operability managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.23	cucsEquipmentFexPower	0	0	Cisco UCS equipment:Fex:power managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.24	cucsEquipmentFexPresence	0	0	Cisco UCS equipment:Fex:presence managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.25	cucsEquipmentFexRevision	0	0	Cisco UCS equipment:Fex:revision managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.26	cucsEquipmentFexSerial	0	0	Cisco UCS equipment:Fex:serial managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.27	cucsEquipmentFexThermal	0	0	Cisco UCS equipment:Fex:thermal managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.28	cucsEquipmentFexUsrLbl	0	0	Cisco UCS equipment:Fex:usrLbl managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.29	cucsEquipmentFexVendor	0	0	Cisco UCS equipment:Fex:vendor managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.30	cucsEquipmentFexVoltage	0	0	Cisco UCS equipment:Fex:voltage managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.31	cucsEquipmentFexSwitchId	0	0	Cisco UCS equipment:Fex:switchId managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.32	cucsEquipmentFexLicGP	0	0	Cisco UCS equipment:Fex:licGP managed object property
1.3.6.1.4.1.9.9.719.1.15.19.1.33	cucsEquipmentFexLicState	0	0	Cisco UCS equipment:Fex:licState managed object property
*/
public class CiscoUcsEquipmentFexTableTracker extends TableTracker {

    public static final String cucsEquipmentFexDn = "cucsEquipmentFexDn";
    public static final String cucsEquipmentFexRn = "cucsEquipmentFexRn";
    public static final String cucsEquipmentFexAdminPowerState = "cucsEquipmentFexAdminPowerState";
    public static final String cucsEquipmentFexAdminState = "cucsEquipmentFexAdminState";
    public static final String cucsEquipmentFexConfigState = "cucsEquipmentFexConfigState";
    public static final String cucsEquipmentFexFltAggr = "cucsEquipmentFexFltAggr";
    public static final String cucsEquipmentFexFsmDescr = "cucsEquipmentFexFsmDescr";
    public static final String cucsEquipmentFexFsmPrev = "cucsEquipmentFexFsmPrev";
    public static final String cucsEquipmentFexFsmProgr = "cucsEquipmentFexFsmProgr";
    public static final String cucsEquipmentFexFsmRmtInvErrCode = "cucsEquipmentFexFsmRmtInvErrCode";
    public static final String cucsEquipmentFexFsmRmtInvErrDescr = "cucsEquipmentFexFsmRmtInvErrDescr";
    public static final String cucsEquipmentFexFsmRmtInvRslt = "cucsEquipmentFexFsmRmtInvRslt";
    public static final String cucsEquipmentFexFsmStageDescr = "cucsEquipmentFexFsmStageDescr";
    public static final String cucsEquipmentFexFsmStamp = "cucsEquipmentFexFsmStamp";
    public static final String cucsEquipmentFexFsmStatus = "cucsEquipmentFexFsmStatus";
    public static final String cucsEquipmentFexFsmTry = "cucsEquipmentFexFsmTry";
    public static final String cucsEquipmentFexId = "cucsEquipmentFexId";
    public static final String cucsEquipmentFexModel = "cucsEquipmentFexModel";
    public static final String cucsEquipmentFexOperQualifier = "cucsEquipmentFexOperQualifier";
    public static final String cucsEquipmentFexOperState = "cucsEquipmentFexOperState";
    public static final String cucsEquipmentFexOperability = "cucsEquipmentFexOperability";
    public static final String cucsEquipmentFexPower = "cucsEquipmentFexPower";
    public static final String cucsEquipmentFexPresence = "cucsEquipmentFexPresence";
    public static final String cucsEquipmentFexRevision = "cucsEquipmentFexRevision";
    public static final String cucsEquipmentFexSerial = "cucsEquipmentFexSerial";
    public static final String cucsEquipmentFexThermal = "cucsEquipmentFexThermal";
    public static final String cucsEquipmentFexUsrLbl = "cucsEquipmentFexUsrLbl";
    public static final String cucsEquipmentFexVendor = "cucsEquipmentFexVendor";
    public static final String cucsEquipmentFexVoltage = "cucsEquipmentFexVoltage";
    public static final String cucsEquipmentFexSwitchId = "cucsEquipmentFexSwitchId";
    public static final String cucsEquipmentFexLicGP = "cucsEquipmentFexLicGP";
    public static final String cucsEquipmentFexLicState = "cucsEquipmentFexLicState";

    public static final SnmpObjId cucsEquipmentFexDnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.2");
    public static final SnmpObjId cucsEquipmentFexRnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.3");
    public static final SnmpObjId cucsEquipmentFexAdminPowerStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.4");
    public static final SnmpObjId cucsEquipmentFexAdminStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.5");
    public static final SnmpObjId cucsEquipmentFexConfigStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.6");
    public static final SnmpObjId cucsEquipmentFexFltAggrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.7");
    public static final SnmpObjId cucsEquipmentFexFsmDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.8");
    public static final SnmpObjId cucsEquipmentFexFsmPrevObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.9");
    public static final SnmpObjId cucsEquipmentFexFsmProgrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.10");
    public static final SnmpObjId cucsEquipmentFexFsmRmtInvErrCodeObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.11");
    public static final SnmpObjId cucsEquipmentFexFsmRmtInvErrDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.12");
    public static final SnmpObjId cucsEquipmentFexFsmRmtInvRsltObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.13");
    public static final SnmpObjId cucsEquipmentFexFsmStageDescrObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.14");
    public static final SnmpObjId cucsEquipmentFexFsmStampObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.15");
    public static final SnmpObjId cucsEquipmentFexFsmStatusObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.16");
    public static final SnmpObjId cucsEquipmentFexFsmTryObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.17");
    public static final SnmpObjId cucsEquipmentFexIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.18");
    public static final SnmpObjId cucsEquipmentFexModelObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.19");
    public static final SnmpObjId cucsEquipmentFexOperQualifierObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.20");
    public static final SnmpObjId cucsEquipmentFexOperStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.21");
    public static final SnmpObjId cucsEquipmentFexOperabilityObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.22");
    public static final SnmpObjId cucsEquipmentFexPowerObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.23");
    public static final SnmpObjId cucsEquipmentFexPresenceObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.24");
    public static final SnmpObjId cucsEquipmentFexRevisionObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.25");
    public static final SnmpObjId cucsEquipmentFexSerialObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.26");
    public static final SnmpObjId cucsEquipmentFexThermalObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.27");
    public static final SnmpObjId cucsEquipmentFexUsrLblObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.28");
    public static final SnmpObjId cucsEquipmentFexVendorObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.29");
    public static final SnmpObjId cucsEquipmentFexVoltageObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.30");
    public static final SnmpObjId cucsEquipmentFexSwitchIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.31");
    public static final SnmpObjId cucsEquipmentFexLicGPObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.32");
    public static final SnmpObjId cucsEquipmentFexLicStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.15.19.1.33");
    public static final SnmpObjId[] s_elemList = new SnmpObjId[]{
            cucsEquipmentFexDnObjId,
            cucsEquipmentFexRnObjId,
            cucsEquipmentFexAdminPowerStateObjId,
            cucsEquipmentFexAdminStateObjId,
            cucsEquipmentFexConfigStateObjId,
            cucsEquipmentFexFltAggrObjId,
            cucsEquipmentFexFsmDescrObjId,
            cucsEquipmentFexFsmPrevObjId,
            cucsEquipmentFexFsmProgrObjId,
            cucsEquipmentFexFsmRmtInvErrCodeObjId,
            cucsEquipmentFexFsmRmtInvErrDescrObjId,
            cucsEquipmentFexFsmRmtInvRsltObjId,
            cucsEquipmentFexFsmStageDescrObjId,
            cucsEquipmentFexFsmStampObjId,
            cucsEquipmentFexFsmStatusObjId,
            cucsEquipmentFexFsmTryObjId,
            cucsEquipmentFexIdObjId,
            cucsEquipmentFexModelObjId,
            cucsEquipmentFexOperQualifierObjId,
            cucsEquipmentFexOperStateObjId,
            cucsEquipmentFexOperabilityObjId,
            cucsEquipmentFexPowerObjId,
            cucsEquipmentFexPresenceObjId,
            cucsEquipmentFexRevisionObjId,
            cucsEquipmentFexSerialObjId,
            cucsEquipmentFexThermalObjId,
            cucsEquipmentFexUsrLblObjId,
            cucsEquipmentFexVendorObjId,
            cucsEquipmentFexVoltageObjId,
            cucsEquipmentFexSwitchIdObjId,
            cucsEquipmentFexLicGPObjId,
            cucsEquipmentFexLicStateObjId,
    };

    public CiscoUcsEquipmentFexTableTracker() {
        super(s_elemList);
    }

    @Override
    public SnmpRowResult createRowResult(final int columnCount, final SnmpInstId instance) {
        return new CiscoUcsEquipmentFexTableRow(columnCount, instance);
    }

    @Override
    public void rowCompleted(final SnmpRowResult row) {
        processCiscoUcsEquipmentFexTableRow((CiscoUcsEquipmentFexTableRow)row);
    }

    private void processCiscoUcsEquipmentFexTableRow(CiscoUcsEquipmentFexTableRow row) {
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexDnObjId + "." + row.getInstance().toString(), cucsEquipmentFexDn, row.getCucsEquipmentFexDn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexRnObjId + "." + row.getInstance().toString(), cucsEquipmentFexRn, row.getCucsEquipmentFexRn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexAdminPowerStateObjId + "." + row.getInstance().toString(), cucsEquipmentFexAdminPowerState, row.getCucsEquipmentFexAdminPowerState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexAdminStateObjId + "." + row.getInstance().toString(), cucsEquipmentFexAdminState, row.getCucsEquipmentFexAdminState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexConfigStateObjId + "." + row.getInstance().toString(), cucsEquipmentFexConfigState, row.getCucsEquipmentFexConfigState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFltAggrObjId + "." + row.getInstance().toString(), cucsEquipmentFexFltAggr, row.getCucsEquipmentFexFltAggr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmDescrObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmDescr, row.getCucsEquipmentFexFsmDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmPrevObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmPrev, row.getCucsEquipmentFexFsmPrev(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmProgrObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmProgr, row.getCucsEquipmentFexFsmProgr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmRmtInvErrCodeObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmRmtInvErrCode, row.getCucsEquipmentFexFsmRmtInvErrCode(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmRmtInvErrDescrObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmRmtInvErrDescr, row.getCucsEquipmentFexFsmRmtInvErrDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmRmtInvRsltObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmRmtInvRslt, row.getCucsEquipmentFexFsmRmtInvRslt(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmStageDescrObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmStageDescr, row.getCucsEquipmentFexFsmStageDescr(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmStampObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmStamp, row.getCucsEquipmentFexFsmStamp(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmStatusObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmStatus, row.getCucsEquipmentFexFsmStatus(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexFsmTryObjId + "." + row.getInstance().toString(), cucsEquipmentFexFsmTry, row.getCucsEquipmentFexFsmTry(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexIdObjId + "." + row.getInstance().toString(), cucsEquipmentFexId, row.getCucsEquipmentFexId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexModelObjId + "." + row.getInstance().toString(), cucsEquipmentFexModel, row.getCucsEquipmentFexModel(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexOperQualifierObjId + "." + row.getInstance().toString(), cucsEquipmentFexOperQualifier, row.getCucsEquipmentFexOperQualifier(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexOperStateObjId + "." + row.getInstance().toString(), cucsEquipmentFexOperState, row.getCucsEquipmentFexOperState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexOperabilityObjId + "." + row.getInstance().toString(), cucsEquipmentFexOperability, row.getCucsEquipmentFexOperability(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexPowerObjId + "." + row.getInstance().toString(), cucsEquipmentFexPower, row.getCucsEquipmentFexPower(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexPresenceObjId + "." + row.getInstance().toString(), cucsEquipmentFexPresence, row.getCucsEquipmentFexPresence(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexRevisionObjId + "." + row.getInstance().toString(), cucsEquipmentFexRevision, row.getCucsEquipmentFexRevision(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexSerialObjId + "." + row.getInstance().toString(), cucsEquipmentFexSerial, row.getCucsEquipmentFexSerial(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexThermalObjId + "." + row.getInstance().toString(), cucsEquipmentFexThermal, row.getCucsEquipmentFexThermal(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexUsrLblObjId + "." + row.getInstance().toString(), cucsEquipmentFexUsrLbl, row.getCucsEquipmentFexUsrLbl(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexVendorObjId + "." + row.getInstance().toString(), cucsEquipmentFexVendor, row.getCucsEquipmentFexVendor(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexVoltageObjId + "." + row.getInstance().toString(), cucsEquipmentFexVoltage, row.getCucsEquipmentFexVoltage(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexSwitchIdObjId + "." + row.getInstance().toString(), cucsEquipmentFexSwitchId, row.getCucsEquipmentFexSwitchId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexLicGPObjId + "." + row.getInstance().toString(), cucsEquipmentFexLicGP, row.getCucsEquipmentFexLicGP(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsEquipmentFexLicStateObjId + "." + row.getInstance().toString(), cucsEquipmentFexLicState, row.getCucsEquipmentFexLicState(), "STRING");
    }

    public static class CiscoUcsEquipmentFexTableRow extends SnmpRowResult {

         public CiscoUcsEquipmentFexTableRow(int columnCount, SnmpInstId instance) {
             super(columnCount, instance);
         }


        public String getCucsEquipmentFexDn() {
            return getValue(cucsEquipmentFexDnObjId).toString();
        }

        public String getCucsEquipmentFexRn() {
            return getValue(cucsEquipmentFexRnObjId).toString();
        }

        public String getCucsEquipmentFexAdminPowerState() {
            return getValue(cucsEquipmentFexAdminPowerStateObjId).toString();
        }

        public String getCucsEquipmentFexAdminState() {
            return getValue(cucsEquipmentFexAdminStateObjId).toString();
        }

        public String getCucsEquipmentFexConfigState() {
            return getValue(cucsEquipmentFexConfigStateObjId).toString();
        }

        public String getCucsEquipmentFexFltAggr() {
            return getValue(cucsEquipmentFexFltAggrObjId).toString();
        }

        public String getCucsEquipmentFexFsmDescr() {
            return getValue(cucsEquipmentFexFsmDescrObjId).toString();
        }

        public String getCucsEquipmentFexFsmPrev() {
            return getValue(cucsEquipmentFexFsmPrevObjId).toString();
        }

        public String getCucsEquipmentFexFsmProgr() {
            return getValue(cucsEquipmentFexFsmProgrObjId).toString();
        }

        public String getCucsEquipmentFexFsmRmtInvErrCode() {
            return getValue(cucsEquipmentFexFsmRmtInvErrCodeObjId).toString();
        }

        public String getCucsEquipmentFexFsmRmtInvErrDescr() {
            return getValue(cucsEquipmentFexFsmRmtInvErrDescrObjId).toString();
        }

        public String getCucsEquipmentFexFsmRmtInvRslt() {
            return getValue(cucsEquipmentFexFsmRmtInvRsltObjId).toString();
        }

        public String getCucsEquipmentFexFsmStageDescr() {
            return getValue(cucsEquipmentFexFsmStageDescrObjId).toString();
        }

        public String getCucsEquipmentFexFsmStamp() {
            return getValue(cucsEquipmentFexFsmStampObjId).toString();
        }

        public String getCucsEquipmentFexFsmStatus() {
            return getValue(cucsEquipmentFexFsmStatusObjId).toString();
        }

        public String getCucsEquipmentFexFsmTry() {
            return getValue(cucsEquipmentFexFsmTryObjId).toString();
        }

        public String getCucsEquipmentFexId() {
            return getValue(cucsEquipmentFexIdObjId).toString();
        }

        public String getCucsEquipmentFexModel() {
            return getValue(cucsEquipmentFexModelObjId).toString();
        }

        public String getCucsEquipmentFexOperQualifier() {
            return getValue(cucsEquipmentFexOperQualifierObjId).toString();
        }

        public String getCucsEquipmentFexOperState() {
            return getValue(cucsEquipmentFexOperStateObjId).toString();
        }

        public String getCucsEquipmentFexOperability() {
            return getValue(cucsEquipmentFexOperabilityObjId).toString();
        }

        public String getCucsEquipmentFexPower() {
            return getValue(cucsEquipmentFexPowerObjId).toString();
        }

        public String getCucsEquipmentFexPresence() {
            return getValue(cucsEquipmentFexPresenceObjId).toString();
        }

        public String getCucsEquipmentFexRevision() {
            return getValue(cucsEquipmentFexRevisionObjId).toString();
        }

        public String getCucsEquipmentFexSerial() {
            return getValue(cucsEquipmentFexSerialObjId).toString();
        }

        public String getCucsEquipmentFexThermal() {
            return getValue(cucsEquipmentFexThermalObjId).toString();
        }

        public String getCucsEquipmentFexUsrLbl() {
            return getValue(cucsEquipmentFexUsrLblObjId).toString();
        }

        public String getCucsEquipmentFexVendor() {
            return getValue(cucsEquipmentFexVendorObjId).toString();
        }

        public String getCucsEquipmentFexVoltage() {
            return getValue(cucsEquipmentFexVoltageObjId).toString();
        }

        public String getCucsEquipmentFexSwitchId() {
            return getValue(cucsEquipmentFexSwitchIdObjId).toString();
        }

        public String getCucsEquipmentFexLicGP() {
            return getValue(cucsEquipmentFexLicGPObjId).toString();
        }

        public String getCucsEquipmentFexLicState() {
            return getValue(cucsEquipmentFexLicStateObjId).toString();
        }

    }
}
