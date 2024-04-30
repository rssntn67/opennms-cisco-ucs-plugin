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
        equipmentChassis,
        equipmentFex,
        equipmentRackEnclosure,
        networkElement,
        computeBlade,
        computeRackUnit
    }
}
