package it.xeniaprogetti.cisco.ucs.plugin.client.api;

public abstract class UcsEntity {
    public final UcsDn dn;
    public final UcsEnums.ClassId classId;
    public final UcsEnums.ClassItem classItem;

    public UcsEntity(UcsDn dn, UcsEnums.ClassId classId, UcsEnums.ClassItem classItem) {
        this.dn = dn;
        this.classId = classId;
        this.classItem = classItem;
    }

}
