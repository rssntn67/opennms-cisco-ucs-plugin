package it.xeniaprogetti.cisco.ucs.plugin.client.api;

public abstract class UcsEntity {
    public final String dn;
    public final ClassId classId;
    public final ClassItem classItem;

    public UcsEntity(String dn, ClassId classId, ClassItem classItem) {
        this.dn = dn;
        this.classId = classId;
        this.classItem = classItem;
    }

    public enum ClassItem {
        equipmentItem,
        computeItem,
        otherItem
    }

    public enum ClassId {
        faultInst("CiscoUcsEntity"),
        equipmentChassis("CiscoUcsEquipment"),
        equipmentFex("CiscoUcsEquipment"),
        equipmentRackEnclosure("CiscoUcsEquipment"),
        networkElement("CiscoUcsFabricInterconnect"),
        computeBlade("CiscoUcsCompute"),
        computeRackUnit("CiscoUcsCompute");

        private final String serviceName;

        ClassId(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getServiceName() {
            return this.serviceName;
        }
    }
}
