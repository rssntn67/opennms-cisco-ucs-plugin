package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import com.google.common.base.Strings;
import com.google.common.net.InetAddresses;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;

public class UcsUtils {

    public final static String UCS_MANAGER_DN = "org-root";
    public final static String UCS_DN_KEY = "dn";
    public final static String UCS_FABRIC_LAN_KEY = "fabric-lan-dn";
    public final static String UCS_FABRIC_SAN_KEY = "fabric-san-dn";
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

    public static String getLabelFromCredentials(ApiClientCredentials credentials) throws ApiException {
        try {
            return (new URL(credentials.url).getHost());
        } catch ( MalformedURLException e) {
            throw new ApiException(e.getMessage(),e);
        }
    }

    public static InetAddress getIpAddressFromCredentials(ApiClientCredentials credentials) throws ApiException {
        try {
            return InetAddress.getByName(new URL(credentials.url).getHost());
        } catch (UnknownHostException | MalformedURLException e) {
            throw new ApiException(e.getMessage(),e);
        }
    }
}
