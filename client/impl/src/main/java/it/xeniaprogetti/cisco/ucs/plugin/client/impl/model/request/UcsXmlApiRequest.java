package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request;

public class UcsXmlApiRequest {


    public static String getLoginRequest(String inName, String inPassword) {
        return "<aaaLogin inName=\""+inName+ "\" inPassword=\""+inPassword+"\"/>";
    }
    public static String getLogoutRequest(String inCookie) {
        return "<aaaLogout inCookie=\""+inCookie+"\"/>";
    }
    public static String getRefreshRequest(String inName, String inPassword, String inCookie) {
        return "<aaaRefresh inName=\""+inName+"\" inPassword="+inPassword+"\" inCookie=\""+inCookie+"\"/>";
    }

    public static String getConfigResolveClassRequest(String cookie, String classId) {
        return "<configResolveClass\n" +
                "    cookie=\""+cookie+"\"\n" +
                "    classId=\""+classId+"\"\n" +
                "    inHierarchical=\"false\">\n" +
                "    <inFilter>\n" +
                "    </inFilter>\n" +
                "</configResolveClass>";
    }

    public static String getConfigFindDnsByClassIdRequest(String cookie, String classId) {
        return "<configFindDnsByClassId cookie=\""+cookie+"\" classId=\""+classId+"\"</>";
    }

    public static String getConfigResolveDnRequest(String cookie, String dn, boolean inHierarchical) {
        return "<configResolveDn dn=\""+dn+" cookie=\""+cookie+" inHierarchical=\""+inHierarchical+"\"/>";
    }

}


