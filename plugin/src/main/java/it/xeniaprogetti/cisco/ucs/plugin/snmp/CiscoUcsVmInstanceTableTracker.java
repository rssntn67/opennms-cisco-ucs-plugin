package it.xeniaprogetti.cisco.ucs.plugin.snmp;

import org.opennms.netmgt.snmp.SnmpInstId;
import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpRowResult;
import org.opennms.netmgt.snmp.TableTracker;

public class CiscoUcsVmInstanceTableTracker extends TableTracker {

    public static final String cucsVmNicDn = "cucsVmNicDn";
    public static final String cucsVmNicRn = "cucsVmNicRn";
    public static final String cucsVmNicDvsPortId = "cucsVmNicDvsPortId";
    public static final String cucsVmNicDvsSwitchId = "cucsVmNicDvsSwitchId";
    public static final String cucsVmNicHostIfDn = "cucsVmNicHostIfDn";
    public static final String cucsVmNicMacAddr = "cucsVmNicMacAddr";
    public static final String cucsVmNicName = "cucsVmNicName";
    public static final String cucsVmNicOwner = "cucsVmNicOwner";
    public static final String cucsVmNicPhSwitchId = "cucsVmNicPhSwitchId";
    public static final String cucsVmNicProfileId = "cucsVmNicProfileId";
    public static final String cucsVmNicProfileName = "cucsVmNicProfileName";
    public static final String cucsVmNicStatusChangeTs = "cucsVmNicStatusChangeTs";
    public static final String cucsVmNicSwitchId = "cucsVmNicSwitchId";
    public static final String cucsVmNicType = "cucsVmNicType";
    public static final String cucsVmNicUuid = "cucsVmNicUuid";
    public static final String cucsVmNicVStatus = "cucsVmNicVStatus";
    public static final String cucsVmNicVcDn = "cucsVmNicVcDn";
    public static final String cucsVmNicVifId = "cucsVmNicVifId";
    public static final String cucsVmNicVnicDn = "cucsVmNicVnicDn";
    public static final String cucsVmNicDvsGenPortId = "cucsVmNicDvsGenPortId";
    public static final String cucsVmNicVmndGuid = "cucsVmNicVmndGuid";
    public static final String cucsVmNicVmndName = "cucsVmNicVmndName";

    public static final SnmpObjId cucsVmNicDnObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.2");
    public static final SnmpObjId cucsVmNicRnObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.3");
    public static final SnmpObjId cucsVmNicDvsPortIdObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.4");
    public static final SnmpObjId cucsVmNicDvsSwitchIdObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.5");
    public static final SnmpObjId cucsVmNicHostIfDnObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.6");
    public static final SnmpObjId cucsVmNicMacAddrObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.7");
    public static final SnmpObjId cucsVmNicNameObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.8");
    public static final SnmpObjId cucsVmNicOwnerObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.9");
    public static final SnmpObjId cucsVmNicPhSwitchIdObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.10");
    public static final SnmpObjId cucsVmNicProfileIdObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.11");
    public static final SnmpObjId cucsVmNicProfileNameObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.12");
    public static final SnmpObjId cucsVmNicStatusChangeTsObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.13");
    public static final SnmpObjId cucsVmNicSwitchIdObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.14");
    public static final SnmpObjId cucsVmNicTypeObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.15");
    public static final SnmpObjId cucsVmNicUuidObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.16");
    public static final SnmpObjId cucsVmNicVStatusObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.17");
    public static final SnmpObjId cucsVmNicVcDnObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.18");
    public static final SnmpObjId cucsVmNicVifIdObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.19");
    public static final SnmpObjId cucsVmNicVnicDnObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.20");
    public static final SnmpObjId cucsVmNicDvsGenPortIdObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.21");
    public static final SnmpObjId cucsVmNicVmndGuidObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.23");
    public static final SnmpObjId cucsVmNicVmndNameObjId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.24");

    public static final SnmpObjId[] s_cucsVmInstanceTable_elemList = new SnmpObjId[]{
            cucsVmNicDnObjId,
            cucsVmNicRnObjId,
            cucsVmNicDvsPortIdObjId,
            cucsVmNicDvsSwitchIdObjId,
            cucsVmNicHostIfDnObjId,
            cucsVmNicMacAddrObjId,
            cucsVmNicNameObjId,
            cucsVmNicOwnerObjId,
            cucsVmNicPhSwitchIdObjId,
            cucsVmNicProfileIdObjId,
            cucsVmNicProfileNameObjId,
            cucsVmNicStatusChangeTsObjId,
            cucsVmNicSwitchIdObjId,
            cucsVmNicTypeObjId,
            cucsVmNicUuidObjId,
            cucsVmNicVStatusObjId,
            cucsVmNicVcDnObjId,
            cucsVmNicVifIdObjId,
            cucsVmNicVnicDnObjId,
            cucsVmNicDvsGenPortIdObjId,
            cucsVmNicVmndGuidObjId,
            cucsVmNicVmndNameObjId
    };

    public CiscoUcsVmInstanceTableTracker() {
        super(s_cucsVmInstanceTable_elemList);
    }

    @Override
    public SnmpRowResult createRowResult(final int columnCount, final SnmpInstId instance) {
        return new CiscoUcsVmInstanceTableRow(columnCount, instance);
    }

    @Override
    public void rowCompleted(final SnmpRowResult row) {
        processCiscoUcsVmInstanceTableRow((CiscoUcsVmInstanceTableRow)row);
    }

    private void processCiscoUcsVmInstanceTableRow(CiscoUcsVmInstanceTableRow row) {
        System.out.printf("\t\t%s (%s)= %s (%s)\n", cucsVmNicDnObjId + "." + row.getInstance().toString(), cucsVmNicDn, row.getCucsVmNicDn())  ;


    }

    public static class CiscoUcsVmInstanceTableRow extends SnmpRowResult {

        public CiscoUcsVmInstanceTableRow(int columnCount, SnmpInstId instance) {
            super(columnCount, instance);
        }

        public int getCucsVmInstanceInstanceId() {
            return getInstance().getLastSubId();
        }

        public String getCucsVmNicDn() {
            return getValue(cucsVmNicDnObjId).toString();
        }
    }
}