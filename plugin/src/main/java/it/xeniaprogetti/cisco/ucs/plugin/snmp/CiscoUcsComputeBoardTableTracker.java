package it.xeniaprogetti.cisco.ucs.plugin.snmp;

import org.opennms.netmgt.snmp.SnmpInstId;
import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpRowResult;
import org.opennms.netmgt.snmp.TableTracker;

/*
1.3.6.1.4.1.9.9.719.1.9.6.1.1	cucsComputeBoardInstanceId	0	0	Instance identifier of the managed object.
1.3.6.1.4.1.9.9.719.1.9.6.1.2	cucsComputeBoardDn	0	0	Cisco UCS compute:Board:dn managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.3	cucsComputeBoardRn	0	0	Cisco UCS compute:Board:rn managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.4	cucsComputeBoardCmosVoltage	0	0	Cisco UCS compute:Board:cmosVoltage managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.5	cucsComputeBoardId	0	0	Cisco UCS compute:Board:id managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.6	cucsComputeBoardModel	0	0	Cisco UCS compute:Board:model managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.7	cucsComputeBoardOperPower	0	0	Cisco UCS compute:Board:operPower managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.8	cucsComputeBoardOperState	0	0	Cisco UCS compute:Board:operState managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.9	cucsComputeBoardOperability	0	0	Cisco UCS compute:Board:operability managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.10	cucsComputeBoardPerf	0	0	Cisco UCS compute:Board:perf managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.11	cucsComputeBoardPower	0	0	Cisco UCS compute:Board:power managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.12	cucsComputeBoardPresence	0	0	Cisco UCS compute:Board:presence managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.13	cucsComputeBoardRevision	0	0	Cisco UCS compute:Board:revision managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.14	cucsComputeBoardSerial	0	0	Cisco UCS compute:Board:serial managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.15	cucsComputeBoardThermal	0	0	Cisco UCS compute:Board:thermal managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.16	cucsComputeBoardVendor	0	0	Cisco UCS compute:Board:vendor managed object property
1.3.6.1.4.1.9.9.719.1.9.6.1.17	cucsComputeBoardVoltage	0	0	Cisco UCS compute:Board:voltage managed object property
*/
public class CiscoUcsComputeBoardTableTracker extends TableTracker {

    public static final String cucsComputeBoardInstanceId = "cucsComputeBoardInstanceId";
    public static final String cucsComputeBoardDn = "cucsComputeBoardDn";
    public static final String cucsComputeBoardRn = "cucsComputeBoardRn";
    public static final String cucsComputeBoardCmosVoltage = "cucsComputeBoardCmosVoltage";
    public static final String cucsComputeBoardId = "cucsComputeBoardId";
    public static final String cucsComputeBoardModel = "cucsComputeBoardModel";
    public static final String cucsComputeBoardOperPower = "cucsComputeBoardOperPower";
    public static final String cucsComputeBoardOperState = "cucsComputeBoardOperState";
    public static final String cucsComputeBoardOperability = "cucsComputeBoardOperability";
    public static final String cucsComputeBoardPerf = "cucsComputeBoardPerf";
    public static final String cucsComputeBoardPower = "cucsComputeBoardPower";
    public static final String cucsComputeBoardPresence = "cucsComputeBoardPresence";
    public static final String cucsComputeBoardRevision = "cucsComputeBoardRevision";
    public static final String cucsComputeBoardSerial = "cucsComputeBoardSerial";
    public static final String cucsComputeBoardThermal = "cucsComputeBoardThermal";
    public static final String cucsComputeBoardVendor = "cucsComputeBoardVendor";
    public static final String cucsComputeBoardVoltage = "cucsComputeBoardVoltage";

    public static final SnmpObjId cucsComputeBoardInstanceIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.1");
    public static final SnmpObjId cucsComputeBoardDnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.2");
    public static final SnmpObjId cucsComputeBoardRnObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.3");
    public static final SnmpObjId cucsComputeBoardCmosVoltageObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.4");
    public static final SnmpObjId cucsComputeBoardIdObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.5");
    public static final SnmpObjId cucsComputeBoardModelObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.6");
    public static final SnmpObjId cucsComputeBoardOperPowerObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.7");
    public static final SnmpObjId cucsComputeBoardOperStateObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.8");
    public static final SnmpObjId cucsComputeBoardOperabilityObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.9");
    public static final SnmpObjId cucsComputeBoardPerfObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.10");
    public static final SnmpObjId cucsComputeBoardPowerObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.11");
    public static final SnmpObjId cucsComputeBoardPresenceObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.12");
    public static final SnmpObjId cucsComputeBoardRevisionObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.13");
    public static final SnmpObjId cucsComputeBoardSerialObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.14");
    public static final SnmpObjId cucsComputeBoardThermalObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.15");
    public static final SnmpObjId cucsComputeBoardVendorObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.16");
    public static final SnmpObjId cucsComputeBoardVoltageObjId = SnmpObjId.get("1.3.6.1.4.1.9.9.719.1.9.6.1.17");
    public static final SnmpObjId[] s_elemList = new SnmpObjId[]{
            cucsComputeBoardInstanceIdObjId,
            cucsComputeBoardDnObjId,
            cucsComputeBoardRnObjId,
            cucsComputeBoardCmosVoltageObjId,
            cucsComputeBoardIdObjId,
            cucsComputeBoardModelObjId,
            cucsComputeBoardOperPowerObjId,
            cucsComputeBoardOperStateObjId,
            cucsComputeBoardOperabilityObjId,
            cucsComputeBoardPerfObjId,
            cucsComputeBoardPowerObjId,
            cucsComputeBoardPresenceObjId,
            cucsComputeBoardRevisionObjId,
            cucsComputeBoardSerialObjId,
            cucsComputeBoardThermalObjId,
            cucsComputeBoardVendorObjId,
            cucsComputeBoardVoltageObjId,
    };

    public CiscoUcsComputeBoardTableTracker() {
        super(s_elemList);
    }

    @Override
    public SnmpRowResult createRowResult(final int columnCount, final SnmpInstId instance) {
        return new CiscoUcsComputeBoardTableRow(columnCount, instance);
    }

    @Override
    public void rowCompleted(final SnmpRowResult row) {
        processCiscoUcsComputeBoardTableRow((CiscoUcsComputeBoardTableRow)row);
    }

    private void processCiscoUcsComputeBoardTableRow(CiscoUcsComputeBoardTableRow row) {
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardInstanceIdObjId + "." + row.getInstance().toString(), cucsComputeBoardInstanceId, row.getCucsComputeBoardInstanceId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardDnObjId + "." + row.getInstance().toString(), cucsComputeBoardDn, row.getCucsComputeBoardDn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardRnObjId + "." + row.getInstance().toString(), cucsComputeBoardRn, row.getCucsComputeBoardRn(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardCmosVoltageObjId + "." + row.getInstance().toString(), cucsComputeBoardCmosVoltage, row.getCucsComputeBoardCmosVoltage(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardIdObjId + "." + row.getInstance().toString(), cucsComputeBoardId, row.getCucsComputeBoardId(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardModelObjId + "." + row.getInstance().toString(), cucsComputeBoardModel, row.getCucsComputeBoardModel(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardOperPowerObjId + "." + row.getInstance().toString(), cucsComputeBoardOperPower, row.getCucsComputeBoardOperPower(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardOperStateObjId + "." + row.getInstance().toString(), cucsComputeBoardOperState, row.getCucsComputeBoardOperState(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardOperabilityObjId + "." + row.getInstance().toString(), cucsComputeBoardOperability, row.getCucsComputeBoardOperability(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardPerfObjId + "." + row.getInstance().toString(), cucsComputeBoardPerf, row.getCucsComputeBoardPerf(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardPowerObjId + "." + row.getInstance().toString(), cucsComputeBoardPower, row.getCucsComputeBoardPower(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardPresenceObjId + "." + row.getInstance().toString(), cucsComputeBoardPresence, row.getCucsComputeBoardPresence(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardRevisionObjId + "." + row.getInstance().toString(), cucsComputeBoardRevision, row.getCucsComputeBoardRevision(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardSerialObjId + "." + row.getInstance().toString(), cucsComputeBoardSerial, row.getCucsComputeBoardSerial(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardThermalObjId + "." + row.getInstance().toString(), cucsComputeBoardThermal, row.getCucsComputeBoardThermal(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardVendorObjId + "." + row.getInstance().toString(), cucsComputeBoardVendor, row.getCucsComputeBoardVendor(), "STRING");
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsComputeBoardVoltageObjId + "." + row.getInstance().toString(), cucsComputeBoardVoltage, row.getCucsComputeBoardVoltage(), "STRING");
    }

    public static class CiscoUcsComputeBoardTableRow extends SnmpRowResult {

         public CiscoUcsComputeBoardTableRow(int columnCount, SnmpInstId instance) {
             super(columnCount, instance);
         }

        public int getInstanceId() {
            return getInstance().getLastSubId();
        }

        public String getCucsComputeBoardInstanceId() {
            return getValue(cucsComputeBoardInstanceIdObjId).toString();
        }

        public String getCucsComputeBoardDn() {
            return getValue(cucsComputeBoardDnObjId).toString();
        }

        public String getCucsComputeBoardRn() {
            return getValue(cucsComputeBoardRnObjId).toString();
        }

        public String getCucsComputeBoardCmosVoltage() {
            return getValue(cucsComputeBoardCmosVoltageObjId).toString();
        }

        public String getCucsComputeBoardId() {
            return getValue(cucsComputeBoardIdObjId).toString();
        }

        public String getCucsComputeBoardModel() {
            return getValue(cucsComputeBoardModelObjId).toString();
        }

        public String getCucsComputeBoardOperPower() {
            return getValue(cucsComputeBoardOperPowerObjId).toString();
        }

        public String getCucsComputeBoardOperState() {
            return getValue(cucsComputeBoardOperStateObjId).toString();
        }

        public String getCucsComputeBoardOperability() {
            return getValue(cucsComputeBoardOperabilityObjId).toString();
        }

        public String getCucsComputeBoardPerf() {
            return getValue(cucsComputeBoardPerfObjId).toString();
        }

        public String getCucsComputeBoardPower() {
            return getValue(cucsComputeBoardPowerObjId).toString();
        }

        public String getCucsComputeBoardPresence() {
            return getValue(cucsComputeBoardPresenceObjId).toString();
        }

        public String getCucsComputeBoardRevision() {
            return getValue(cucsComputeBoardRevisionObjId).toString();
        }

        public String getCucsComputeBoardSerial() {
            return getValue(cucsComputeBoardSerialObjId).toString();
        }

        public String getCucsComputeBoardThermal() {
            return getValue(cucsComputeBoardThermalObjId).toString();
        }

        public String getCucsComputeBoardVendor() {
            return getValue(cucsComputeBoardVendorObjId).toString();
        }

        public String getCucsComputeBoardVoltage() {
            return getValue(cucsComputeBoardVoltageObjId).toString();
        }

    }
}
