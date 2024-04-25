package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

public class ConfigResolveClassRequest {
    public enum ClassId {
        equipmentChassis,
        equipmentFex,
        equipmentRackEnclosure,
        networkElement,
        computeBlade,
        computeRackUnit
    }

    private final ClassId classId;
    private final String token;

    public ConfigResolveClassRequest(ClassId classId, String token) {
        this.classId = classId;
        this.token = token;
    }


    public String getRequest() {
       return "<configResolveClass\n" +
                "    cookie=\""+token+"\"\n" +
                "    classId=\""+classId.name()+"\"\n" +
                "    inHierarchical=\"false\">\n" +
                "    <inFilter>\n" +
                "    </inFilter>\n" +
                "</configResolveClass>";
    }

}
