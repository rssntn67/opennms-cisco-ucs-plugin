package it.xeniaprogetti.cisco.ucs.plugin.snmp;

import org.opennms.netmgt.snmp.SnmpInstId;
import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpRowResult;
import org.opennms.netmgt.snmp.TableTracker;

/*
1.3.6.1.4.1.9.9.719.1.9.7.1.2	cucsComputeBoardControllerDn	0	0	Cisco UCS compute:BoardController:dn managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.3	cucsComputeBoardControllerRn	0	0	Cisco UCS compute:BoardController:rn managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.4	cucsComputeBoardControllerId	0	0	Cisco UCS compute:BoardController:id managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.5	cucsComputeBoardControllerModel	0	0	Cisco UCS compute:BoardController:model managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.6	cucsComputeBoardControllerOperState	0	0	Cisco UCS compute:BoardController:operState managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.7	cucsComputeBoardControllerOperability	0	0	Cisco UCS compute:BoardController:operability managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.8	cucsComputeBoardControllerPerf	0	0	Cisco UCS compute:BoardController:perf managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.9	cucsComputeBoardControllerPower	0	0	Cisco UCS compute:BoardController:power managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.10	cucsComputeBoardControllerPresence	0	0	Cisco UCS compute:BoardController:presence managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.11	cucsComputeBoardControllerRevision	0	0	Cisco UCS compute:BoardController:revision managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.12	cucsComputeBoardControllerSerial	0	0	Cisco UCS compute:BoardController:serial managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.13	cucsComputeBoardControllerThermal	0	0	Cisco UCS compute:BoardController:thermal managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.14	cucsComputeBoardControllerVendor	0	0	Cisco UCS compute:BoardController:vendor managed object property
1.3.6.1.4.1.9.9.719.1.9.7.1.15	cucsComputeBoardControllerVoltage	0	0	Cisco UCS compute:BoardController:voltage managed object property
*/
public class CiscoUcsComputeBoardControllerTableTracker extends TableTracker {

    public static final String cucsComputeBoardControllerDn = "cucsComputeBoardControllerDn";
    public static final String cucsComputeBoardControllerRn = "cucsComputeBoardControllerRn";
    public static final String cucsComputeBoardControllerId = "cucsComputeBoardControllerId";
    public static final String cucsComputeBoardControllerModel = "cucsComputeBoardControllerModel";
    public static final String cucsComputeBoardControllerOperState = "cucsComputeBoardControllerOperState";
    public static final String cucsComputeBoardControllerOperability = "cucsComputeBoardControllerOperability";
    public static final String cucsComputeBoardControllerPerf = "cucsComputeBoardControllerPerf";
    public static final String cucsComputeBoardControllerPower = "cucsComputeBoardControllerPower";
    public static final String cucsComputeBoardControllerPresence = "cucsComputeBoardControllerPresence";
    public static final String cucsComputeBoardControllerRevision = "cucsComputeBoardControllerRevision";
    public static final String cucsComputeBoardControllerSerial = "cucsComputeBoardControllerSerial";
    public static final String cucsComputeBoardControllerThermal = "cucsComputeBoardControllerThermal";
    public static final String cucsComputeBoardControllerVendor = "cucsComputeBoardControllerVendor";
    public static final String cucsComputeBoardControllerVoltage = "cucsComputeBoardControllerVoltage";

    public static final SnmpObjId cucsComputeBoardControllerDnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.2");
    public static final SnmpObjId cucsComputeBoardControllerRnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.3");
    public static final SnmpObjId cucsComputeBoardControllerIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.4");
    public static final SnmpObjId cucsComputeBoardControllerModelObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.5");
    public static final SnmpObjId cucsComputeBoardControllerOperStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.6");
    public static final SnmpObjId cucsComputeBoardControllerOperabilityObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.7");
    public static final SnmpObjId cucsComputeBoardControllerPerfObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.8");
    public static final SnmpObjId cucsComputeBoardControllerPowerObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.9");
    public static final SnmpObjId cucsComputeBoardControllerPresenceObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.10");
    public static final SnmpObjId cucsComputeBoardControllerRevisionObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.11");
    public static final SnmpObjId cucsComputeBoardControllerSerialObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.12");
    public static final SnmpObjId cucsComputeBoardControllerThermalObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.13");
    public static final SnmpObjId cucsComputeBoardControllerVendorObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.14");
    public static final SnmpObjId cucsComputeBoardControllerVoltageObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.7.1.15");
    public static final SnmpObjId[] s_elemList = new SnmpObjId[]{
            cucsComputeBoardControllerDnObjId,
            cucsComputeBoardControllerRnObjId,
            cucsComputeBoardControllerIdObjId,
            cucsComputeBoardControllerModelObjId,
            cucsComputeBoardControllerOperStateObjId,
            cucsComputeBoardControllerOperabilityObjId,
            cucsComputeBoardControllerPerfObjId,
            cucsComputeBoardControllerPowerObjId,
            cucsComputeBoardControllerPresenceObjId,
            cucsComputeBoardControllerRevisionObjId,
            cucsComputeBoardControllerSerialObjId,
            cucsComputeBoardControllerThermalObjId,
            cucsComputeBoardControllerVendorObjId,
            cucsComputeBoardControllerVoltageObjId,
    };

    public CiscoUcsComputeBoardControllerTableTracker() {
        super(s_elemList);
    }

    @Override
    public SnmpRowResult createRowResult(final int columnCount, final SnmpInstId instance) {
        return new CiscoUcsComputeBoardControllerTableRow(columnCount, instance);
    }

    @Override
    public void rowCompleted(final SnmpRowResult row) {
        processCiscoUcsComputeBoardControllerTableRow((CiscoUcsComputeBoardControllerTableRow)row);
    }

    private void processCiscoUcsComputeBoardControllerTableRow(CiscoUcsComputeBoardControllerTableRow row) {
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerDnObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerDn, row.getCucsComputeBoardControllerDn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerRnObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerRn, row.getCucsComputeBoardControllerRn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerIdObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerId, row.getCucsComputeBoardControllerId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerModelObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerModel, row.getCucsComputeBoardControllerModel(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerOperStateObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerOperState, row.getCucsComputeBoardControllerOperState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerOperabilityObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerOperability, row.getCucsComputeBoardControllerOperability(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerPerfObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerPerf, row.getCucsComputeBoardControllerPerf(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerPowerObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerPower, row.getCucsComputeBoardControllerPower(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerPresenceObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerPresence, row.getCucsComputeBoardControllerPresence(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerRevisionObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerRevision, row.getCucsComputeBoardControllerRevision(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerSerialObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerSerial, row.getCucsComputeBoardControllerSerial(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerThermalObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerThermal, row.getCucsComputeBoardControllerThermal(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerVendorObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerVendor, row.getCucsComputeBoardControllerVendor(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardControllerVoltageObjId + "." + row.getInstance().toString(), cucsComputeBoardControllerVoltage, row.getCucsComputeBoardControllerVoltage(), "STRING");
    }

    public static class CiscoUcsComputeBoardControllerTableRow extends SnmpRowResult {

         public CiscoUcsComputeBoardControllerTableRow(int columnCount, SnmpInstId instance) {
             super(columnCount, instance);
         }


        public String getCucsComputeBoardControllerDn() {
            return getValue(cucsComputeBoardControllerDnObjId).toString();
        }

        public String getCucsComputeBoardControllerRn() {
            return getValue(cucsComputeBoardControllerRnObjId).toString();
        }

        public String getCucsComputeBoardControllerId() {
            return getValue(cucsComputeBoardControllerIdObjId).toString();
        }

        public String getCucsComputeBoardControllerModel() {
            return getValue(cucsComputeBoardControllerModelObjId).toString();
        }

        public String getCucsComputeBoardControllerOperState() {
            return getValue(cucsComputeBoardControllerOperStateObjId).toString();
        }

        public String getCucsComputeBoardControllerOperability() {
            return getValue(cucsComputeBoardControllerOperabilityObjId).toString();
        }

        public String getCucsComputeBoardControllerPerf() {
            return getValue(cucsComputeBoardControllerPerfObjId).toString();
        }

        public String getCucsComputeBoardControllerPower() {
            return getValue(cucsComputeBoardControllerPowerObjId).toString();
        }

        public String getCucsComputeBoardControllerPresence() {
            return getValue(cucsComputeBoardControllerPresenceObjId).toString();
        }

        public String getCucsComputeBoardControllerRevision() {
            return getValue(cucsComputeBoardControllerRevisionObjId).toString();
        }

        public String getCucsComputeBoardControllerSerial() {
            return getValue(cucsComputeBoardControllerSerialObjId).toString();
        }

        public String getCucsComputeBoardControllerThermal() {
            return getValue(cucsComputeBoardControllerThermalObjId).toString();
        }

        public String getCucsComputeBoardControllerVendor() {
            return getValue(cucsComputeBoardControllerVendorObjId).toString();
        }

        public String getCucsComputeBoardControllerVoltage() {
            return getValue(cucsComputeBoardControllerVoltageObjId).toString();
        }

    }
}
