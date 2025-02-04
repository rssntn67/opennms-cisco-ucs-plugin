package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import com.google.common.base.Strings;
import com.google.common.net.InetAddresses;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.format.DateTimeFormatter;

public class UcsUtils {

    public final static String UCS_MANAGER_DN = "org-root";
    public final static String UCS_DN_KEY = "dn";
    public final static String UCS_FABRIC_LAN_KEY = "fabric-lan-dn";
    public final static String UCS_FABRIC_SAN_KEY = "fabric-san-dn";
    public final static String UCS_ALIAS_KEY = "alias";
    public final static String UCS_TYPE_KEY = "type";

    public final static String UCS_EVENT_TIME_PATTERN="yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static DateTimeFormatter UCS_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(UcsUtils.UCS_EVENT_TIME_PATTERN);

    public static InetAddress getValidInetAddress(final String ip) {
        if (Strings.isNullOrEmpty(ip)) {
            return null;
        }

        try {
            return InetAddresses.forString(ip);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    public static boolean validate(ApiClientCredentials credentials) {
        try {
            new URL(credentials.url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public static String getLabelFromUrl(String url) throws ApiException {
        try {
            return (new URL(url).getHost());
        } catch ( MalformedURLException e) {
            throw new ApiException(e.getMessage(),e);
        }
    }

    public static InetAddress getIpAddressFromUrl(String url) throws ApiException {
        try {
            return InetAddress.getByName(new URL(url).getHost());
        } catch (UnknownHostException | MalformedURLException e) {
            throw new ApiException(e.getMessage(),e);
        }
    }
}
