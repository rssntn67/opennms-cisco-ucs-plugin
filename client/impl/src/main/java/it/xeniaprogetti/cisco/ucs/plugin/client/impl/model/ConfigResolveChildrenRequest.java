package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

public class ConfigResolveChildrenRequest {

    private final ConfigResolveClassRequest.ClassId classId;
    private final String inDn;
    private final String token;

    public ConfigResolveChildrenRequest(ConfigResolveClassRequest.ClassId classId, String inDn, String token) {
        this.classId = classId;
        this.inDn = inDn;
        this.token = token;
    }


    public String getRequest() {
       return "<configResolveChildren\n" +
               "    cookie=\""+token+"\"\n" +
               "    classId=\""+classId.name()+"\"\n" +
               "    inDn=\""+inDn+"\"\n" +
               "    inHierarchical=\"false\">\n" +
               "    <inFilter>\n" +
               "    </inFilter>\n" +
               "</configResolveChildren>";
    }

}
