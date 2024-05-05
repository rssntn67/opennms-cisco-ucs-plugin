package it.xeniaprogetti.cisco.ucs.plugin;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDnComparator;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.XmlApiClientProvider;
import it.xeniaprogetti.cisco.ucs.plugin.connection.Connection;
import org.junit.Assert;
import org.junit.Test;
import org.opennms.integration.api.v1.runtime.Container;
import org.opennms.integration.api.v1.runtime.RuntimeInfo;
import org.opennms.integration.api.v1.runtime.Version;
import org.opennms.integration.api.v1.scv.Credentials;
import org.opennms.integration.api.v1.scv.SecureCredentialsVault;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CiscoUcsPluginTest {

    @Test
    public void testUcsDnSorting() {

        UcsDn chassis3 = UcsDn.getDn("sys/chassis-3");
        UcsDn blade1 = UcsDn.getDn("sys/chassis-3/blade-1");
        UcsDn chassis4 = UcsDn.getDn("sys/chassis-4");
        UcsDn blade2 = UcsDn.getDn("sys/chassis-4/blade-2");

        List<UcsDn> ucsDnList = new ArrayList<>();
        ucsDnList.add(chassis4);
        ucsDnList.add(blade1);
        ucsDnList.add(blade2);
        ucsDnList.add(chassis3);

        System.out.println(ucsDnList);

        ucsDnList.sort(new UcsDnComparator());
        System.out.println(ucsDnList);
    }

    @Test
    public void testValidate() {
        ClientManager clientManager = new ClientManager(new XmlApiClientProvider());
        ConnectionManagerForTest connectionManager = new ConnectionManagerForTest(getRuntimeInfo(),getSecureCredentialVault());
        Connection connection = connectionManager
                .newConnection("test","https://10.172.192.15/nuova", "pippo", "pluto", true, 30);
        Assert.assertTrue(clientManager.validate(connection).isEmpty());
    }

    private static RuntimeInfo getRuntimeInfo() {
        return new RuntimeInfo() {
            @Override
            public Version getVersion() {
                return null;
            }

            @Override
            public boolean isMeridian() {
                return false;
            }

            @Override
            public Container getContainer() {
                return null;
            }

            @Override
            public String getSystemId() {
                return "";
            }

            @Override
            public String getSystemLocation() {
                return "";
            }
        };
    }

    private static SecureCredentialsVault getSecureCredentialVault() {
        return new SecureCredentialsVault() {
            @Override
            public Set<String> getAliases() {
                return Set.of();
            }

            @Override
            public Credentials getCredentials(String s) {
                return null;
            }

            @Override
            public void setCredentials(String s, Credentials credentials) {

            }

            @Override
            public void deleteCredentials(String s) {

            }
        };
    }

    @Test
    public void testSubString() {
        String alfa = "<configResolveDn dn=\"sys/fex-3\" cookie=\"1714500645/a4e3738f-2017-4170-b9ac-c52211aea725\" response=\"yes\"> <outConfig> </outConfig> </configResolveDn>";
        System.out.println(alfa.indexOf("<outConfig>")+11);
        System.out.println(alfa.indexOf("</outConfig>"));
        System.out.println(alfa.substring(alfa.indexOf("<outConfig>")+11, alfa.indexOf("</outConfig>")));
    }
}
