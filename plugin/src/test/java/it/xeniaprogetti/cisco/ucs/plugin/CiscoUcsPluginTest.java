package it.xeniaprogetti.cisco.ucs.plugin;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.XmlApiClientProvider;
import it.xeniaprogetti.cisco.ucs.plugin.connection.Connection;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.junit.Assert;
import org.junit.Test;
import org.opennms.integration.api.v1.runtime.Container;
import org.opennms.integration.api.v1.runtime.RuntimeInfo;
import org.opennms.integration.api.v1.runtime.Version;
import org.opennms.integration.api.v1.scv.Credentials;
import org.opennms.integration.api.v1.scv.SecureCredentialsVault;

import java.util.Set;

public class CiscoUcsPluginTest {

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
}
