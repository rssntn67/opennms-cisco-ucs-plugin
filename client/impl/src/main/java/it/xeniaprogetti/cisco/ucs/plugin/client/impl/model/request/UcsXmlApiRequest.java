package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;

public class
UcsXmlApiRequest {

    public static class InFilter {
        public final String xml;

        private InFilter(String xml) {
            this.xml = xml;
        }
    }

    public static String getLoginRequest(String inName, String inPassword) {
        return "<aaaLogin inName=\""+inName+ "\" inPassword=\""+inPassword+"\"/>";
    }
    public static String getLogoutRequest(String inCookie) {
        return "<aaaLogout inCookie=\""+inCookie+"\"/>";
    }
    public static String getRefreshRequest(String inName, String inPassword, String inCookie) {
        return "<aaaRefresh inName=\""+inName+"\" inPassword=\""+inPassword+"\" inCookie=\""+inCookie+"\"/>";
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

    public static InFilter getEqFilter(UcsEnums.NamingClassId classId, String property, String value) {
        return new InFilter("<eq class=\"" + classId.name() +"\" property=\""+property+"\" value=\"" + value + "\" />");
    }

    public static InFilter getNeFilter(UcsEnums.NamingClassId classId, String property, String value) {
        return new InFilter("<ne class=\"" + classId.name() +"\" property=\""+property+"\" value=\"" + value + "\" />");
    }

    public static InFilter getGtFilter(UcsEnums.NamingClassId classId, String property, int value) {
        return new InFilter("<gt class=\"" + classId.name() +"\" property=\""+property+"\" value=\"" + value + "\" />");
    }

    public static InFilter getGeFilter(UcsEnums.NamingClassId classId, String property, int value) {
        return new InFilter("<ge class=\"" + classId.name() +"\" property=\""+property+"\" value=\"" + value + "\" />");
    }

    public static InFilter getLtFilter(UcsEnums.NamingClassId classId, String property, int value) {
        return new InFilter("<lt class=\"" + classId.name() +"\" property=\""+property+"\" value=\"" + value + "\" />");
    }

    public static InFilter getLeFilter(UcsEnums.NamingClassId classId, String property, int value) {
        return new InFilter("<le class=\"" + classId.name() +"\" property=\""+property+"\" value=\"" + value + "\" />");
    }

    public static InFilter getWCardFilter(UcsEnums.NamingClassId classId, String property, String value) {
        return new InFilter("<wcard class=\"" + classId.name() +"\" property=\""+property+"\" value=\"" + value + "\" />");
    }

    public static InFilter getAnyBitFilter(UcsEnums.NamingClassId classId, String property, String value) {
        return new InFilter("<anybit class=\"" + classId.name() +"\" property=\""+property+"\" value=\"" + value + "\" />");
    }

    public static InFilter getAllBitFilter(UcsEnums.NamingClassId classId, String property, String value) {
        return new InFilter("<allbit class=\"" + classId.name() +"\" property=\""+property+"\" value=\"" + value + "\" />");
    }

    public static InFilter getBetweenFilter(UcsEnums.NamingClassId classId, String property, int firstValue, int secondValue) {
        return new InFilter("<bw class=\"" + classId.name() +"\" property=\""+property+"\" firstValue=\"" +
                firstValue + "\" secondValue=\""+secondValue+"\" />");
    }

    public static InFilter getNotFilter(InFilter filter) {
        return new InFilter("<not>\n"+filter.xml +"\n</not>");
    }

    public static InFilter getAndFilter(InFilter[] filters) {
        StringBuilder xml = new StringBuilder("<and>\n");
        for (InFilter filter: filters) {
            xml.append(filter.xml).append("\n");
        }
        xml.append("</and>");
        return new InFilter(xml.toString());
    }

    public static InFilter getOrFilter(InFilter[] filters) {
        StringBuilder xml = new StringBuilder("<or>\n");
        for (InFilter filter: filters) {
            xml.append(filter.xml).append("\n");
        }
        xml.append("</or>");
        return new InFilter(xml.toString());
    }

    public static String getConfigResolveClassRequest(String cookie, InFilter filter, UcsEnums.NamingClassId classId) {
        return "<configResolveClass\n" +
                "    cookie=\""+cookie+"\"\n" +
                "    classId=\""+classId.name()+"\"\n" +
                "    inHierarchical=\"false\">\n" +
                "    <inFilter>\n" + filter.xml+
                "    </inFilter>\n" +
                "</configResolveClass>";
    }

    public static String getConfigFindDnsByClassIdRequest(String cookie, UcsEnums.NamingClassId classId) {
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


