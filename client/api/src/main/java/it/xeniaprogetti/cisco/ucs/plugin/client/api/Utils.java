package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import com.google.common.base.Strings;
import com.google.common.net.InetAddresses;

import java.net.InetAddress;

public class Utils {
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
}
