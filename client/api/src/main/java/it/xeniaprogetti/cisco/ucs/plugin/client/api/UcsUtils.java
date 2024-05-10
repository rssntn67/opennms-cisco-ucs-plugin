package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import com.google.common.base.Strings;
import com.google.common.net.InetAddresses;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;

public class UcsUtils {
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

    public static InetAddress getIpAddressFromCredentials(ApiClientCredentials credentials) throws ApiException {
        try {
            return InetAddress.getByName(new URL(credentials.url).getHost());
        } catch (UnknownHostException | MalformedURLException e) {
            throw new ApiException(e.getMessage(),e);
        }
    }
}
