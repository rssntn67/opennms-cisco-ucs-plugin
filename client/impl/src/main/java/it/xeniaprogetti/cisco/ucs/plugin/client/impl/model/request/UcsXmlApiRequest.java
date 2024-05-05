package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;

public class
UcsXmlApiRequest {


    public static String getLoginRequest(String inName, String inPassword) {
        return "<aaaLogin inName=\""+inName+ "\" inPassword=\""+inPassword+"\"/>";
    }
    public static String getLogoutRequest(String inCookie) {
        return "<aaaLogout inCookie=\""+inCookie+"\"/>";
    }
    public static String getRefreshRequest(String inName, String inPassword, String inCookie) {
        return "<aaaRefresh inName=\""+inName+"\" inPassword="+inPassword+"\" inCookie=\""+inCookie+"\"/>";
    }

    public static String getConfigResolveClassRequest(String cookie, UcsEnums.ClassId classId) {
        return "<configResolveClass\n" +
                "    cookie=\""+cookie+"\"\n" +
                "    classId=\""+classId.name()+"\"\n" +
                "    inHierarchical=\"false\">\n" +
                "    <inFilter>\n" +
                "    </inFilter>\n" +
                "</configResolveClass>";
    }

    public static String getConfigFindDnsByClassIdRequest(String cookie, UcsEnums.ClassItem classId) {
        return "<configFindDnsByClassId cookie=\""+cookie+"\" classId=\""+classId.name()+"\" />";
    }

    public static String getConfigResolveDnRequest(String cookie, String dn, boolean inHierarchical) {
        return "<configResolveDn dn=\""+dn+"\" cookie=\""+cookie+"\" inHierarchical=\""+inHierarchical+"\"/>";
    }

    public static String getEventSubscriptionRequest(String cookie) {
        return "<eventSubscribe cookie=\""+cookie+"\"/>";
    }

    public static String getEventUnsubscribeRequest(String cookie) {
        return "<eventUnsubscribe cookie=\""+cookie+"\"/>";
    }

    public static String getKeepAliveRequest(String cookie) {
        return "<aaaKeepAlive cookie=\""+cookie+"\"/>";
    }

}


