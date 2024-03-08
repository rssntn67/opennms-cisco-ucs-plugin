package it.xeniaprogetti.cisco.ucs.plugin.snmp;

import org.opennms.netmgt.snmp.SnmpInstId;
import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpRowResult;
import org.opennms.netmgt.snmp.TableTracker;

public class CiscoUcsVmInstanceTableTracker extends TableTracker {

    /*
    cucsVmNicInstanceId OBJECT-TYPE
    SYNTAX       CucsManagedObjectId
    MAX-ACCESS   not-accessible
    STATUS       current
    DESCRIPTION
        "Instance identifier of the managed object."
    ::= { cucsVmNicEntry 1 }
     */
//    public static final SnmpObjId CucsVmInstanceInstanceId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.1");
    public static final String cucsVmInstanceInstanceId = "cucsVmInstanceInstanceId";

    /*
    cucsVmNicDn OBJECT-TYPE
    SYNTAX       CucsManagedObjectDn
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:dn managed object property"
    ::= { cucsVmNicEntry 2 }
     */
    public static final SnmpObjId CucsVmNicDn = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.2");
    public static final String cucsVmNicDn = "cucsVmNicDn";

    /*
    cucsVmNicRn OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:rn managed object property"
    ::= { cucsVmNicEntry 3 }
     */
    public static final SnmpObjId CucsVmNicRn = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.3");
    public static final String cucsVmNicRn = "cucsVmNicRn";

    /*
    cucsVmNicDvsPortId OBJECT-TYPE
    SYNTAX       Gauge32
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:dvsPortId managed object property"
    ::= { cucsVmNicEntry 4 }
     */
    public static final SnmpObjId CucsVmNicDvsPortId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.4");
    public static final String cucsVmNicDvsPortId = "cucsVmNicDvsPortId";

    /*
    cucsVmNicDvsSwitchId OBJECT-TYPE
    SYNTAX       Gauge32
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:dvsSwitchId managed object property"
    ::= { cucsVmNicEntry 5 }
     */
    public static final SnmpObjId CucsVmNicDvsSwitchId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.5");
    public static final String cucsVmNicDvsSwitchId = "cucsVmNicDvsSwitchId";

    /*
    cucsVmNicHostIfDn OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:hostIfDn managed object property"
    ::= { cucsVmNicEntry 6 }
     */
    public static final SnmpObjId CucsVmNicHostIfDn = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.6");
    public static final String cucsVmNicHostIfDn = "cucsVmNicHostIfDn";

    /*
    cucsVmNicMacAddr OBJECT-TYPE
    SYNTAX       MacAddress
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:macAddr managed object property"
    ::= { cucsVmNicEntry 7 }

     */
    public static final SnmpObjId CucsVmNicMacAddr = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.7");
    public static final String cucsVmNicMacAddr = "cucsVmNicMacAddr";

    /*
    cucsVmNicName OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:name managed object property"
    ::= { cucsVmNicEntry 8 }
     */
    public static final SnmpObjId CucsVmNicName = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.8");
    public static final String cucsVmNicName = "cucsVmNicName";

    /*
    cucsVmNicOwner OBJECT-TYPE
    SYNTAX       CucsVmAdaptorOwner
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:owner managed object property"
    ::= { cucsVmNicEntry 9 }
     */
    public static final SnmpObjId CucsVmNicOwner = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.9");
    public static final String cucsVmNicOwner = "cucsVmNicOwner";

    /*
    cucsVmNicPhSwitchId OBJECT-TYPE
    SYNTAX       CucsNetworkSwitchId
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:phSwitchId managed object property"
    ::= { cucsVmNicEntry 10 }
     */
    public static final SnmpObjId CucsVmNicPhSwitchId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.10");
    public static final String cucsVmNicPhSwitchId = "cucsVmNicPhSwitchId";

    /*
    cucsVmNicProfileId OBJECT-TYPE
    SYNTAX       Gauge32
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:profileId managed object property"
    ::= { cucsVmNicEntry 11 }
     */
    public static final SnmpObjId CucsVmNicProfileId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.11");
    public static final String cucsVmNicProfileId = "cucsVmNicProfileId";

    /*
    cucsVmNicProfileName OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:profileName managed object property"
    ::= { cucsVmNicEntry 12 }
     */
    public static final SnmpObjId CucsVmNicProfileName = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.12");
    public static final String cucsVmNicProfileName = "cucsVmNicProfileName";

    /*
    cucsVmNicStatusChangeTs OBJECT-TYPE
    SYNTAX       DateAndTime
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:statusChangeTs managed object property"
    ::= { cucsVmNicEntry 13 }
     */
    public static final SnmpObjId CucsVmNicStatusChangeTs = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.13");
    public static final String cucsVmNicStatusChangeTs = "cucsVmNicStatusChangeTs";

    /*
    cucsVmNicSwitchId OBJECT-TYPE
    SYNTAX       CucsNetworkSwitchId
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:switchId managed object property"
    ::= { cucsVmNicEntry 14 }
     */
    public static final SnmpObjId CucsVmNicSwitchId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.14");
    public static final String cucsVmNicSwitchId = "cucsVmNicSwitchId";

    /*
    cucsVmNicType OBJECT-TYPE
    SYNTAX       CucsVmNicType
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:type managed object property"
    ::= { cucsVmNicEntry 15 }
     */
    public static final SnmpObjId CucsVmNicType = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.15");
    public static final String cucsVmNicType = "cucsVmNicType";

    /*
    cucsVmNicUuid OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:uuid managed object property"
    ::= { cucsVmNicEntry 16 }
     */
    public static final SnmpObjId CucsVmNicUuid = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.16");
    public static final String cucsVmNicUuid = "cucsVmNicUuid";

    /*
    cucsVmNicVStatus OBJECT-TYPE
    SYNTAX       CucsVmStatus
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:vStatus managed object property"
    ::= { cucsVmNicEntry 17 }
     */
    public static final SnmpObjId CucsVmNicVStatus = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.17");
    public static final String cucsVmNicVStatus = "cucsVmNicVStatus";
    /*
    cucsVmNicVcDn OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:vcDn managed object property"
    ::= { cucsVmNicEntry 18 }
     */
    public static final SnmpObjId CucsVmNicVcDn = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.18");
    public static final String cucsVmNicVcDn = "cucsVmNicVcDn";

    /*
    cucsVmNicVifId OBJECT-TYPE
    SYNTAX       Gauge32
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:vifId managed object property"
    ::= { cucsVmNicEntry 19 }
     */
    public static final SnmpObjId CucsVmNicVifId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.19");
    public static final String cucsVmNicVifId = "cucsVmNicVifId";

    /*
    cucsVmNicVnicDn OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:vnicDn managed object property"
    ::= { cucsVmNicEntry 20 }
     */
    public static final SnmpObjId CucsVmNicVnicDn = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.20");
    public static final String cucsVmNicVnicDn = "cucsVmNicVnicDn";

    /*
    cucsVmNicDvsGenPortId OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:dvsGenPortId managed object property"
    ::= { cucsVmNicEntry 21 }
     */
    public static final SnmpObjId CucsVmNicDvsGenPortId = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.21");
    public static final String cucsVmNicDvsGenPortId = "cucsVmNicDvsGenPortId";

    /*
    cucsVmNicVmndGuid OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:vmndGuid managed object property"
    ::= { cucsVmNicEntry 23 }
     */
    public static final SnmpObjId CucsVmNicVmndGuid = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.23");
    public static final String cucsVmNicVmndGuid = "cucsVmNicVmndGuid";

    /*
    cucsVmNicVmndName OBJECT-TYPE
    SYNTAX       SnmpAdminString
    MAX-ACCESS   read-only
    STATUS       current
    DESCRIPTION
        "Cisco UCS vm:Nic:vmndName managed object property"
    ::= { cucsVmNicEntry 24 }
     */
    public static final SnmpObjId CucsVmNicVmndName = SnmpObjId.get(".1.3.6.1.4.1.9.9.719.1.52.6.1.24");
    public static final String cucsVmNicVmndName = "cucsVmNicVmndName";


    public static final SnmpObjId[] s_cucsVmInstanceTable_elemList = new SnmpObjId[]{
            CucsVmNicDn,
            CucsVmNicRn,
            CucsVmNicDvsPortId,
            CucsVmNicDvsSwitchId,
            CucsVmNicHostIfDn,
            CucsVmNicMacAddr,
            CucsVmNicName,
            CucsVmNicOwner,
            CucsVmNicPhSwitchId,
            CucsVmNicProfileId,
            CucsVmNicProfileName,
            CucsVmNicStatusChangeTs,
            CucsVmNicSwitchId,
            CucsVmNicType,
            CucsVmNicUuid,
            CucsVmNicVStatus,
            CucsVmNicVcDn,
            CucsVmNicVifId,
            CucsVmNicVnicDn,
            CucsVmNicDvsGenPortId,
            CucsVmNicVmndGuid,
            CucsVmNicVmndName
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
        System.out.printf("\t\t%s (%s)= %s (%s)\n", CucsVmNicDn + "." + row.getInstance().toString(), cucsVmNicDn, row.getCucsVmNicDn())  ;


    }

    public static class CiscoUcsVmInstanceTableRow extends SnmpRowResult {

        public CiscoUcsVmInstanceTableRow(int columnCount, SnmpInstId instance) {
            super(columnCount, instance);
        }

        public int getCucsVmInstanceInstanceId() {
            return getInstance().getLastSubId();
        }

        public String getCucsVmNicDn() {
            return getValue(CucsVmNicDn).toString();
        }
    }
}