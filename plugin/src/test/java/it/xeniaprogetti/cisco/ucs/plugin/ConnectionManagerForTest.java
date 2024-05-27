package it.xeniaprogetti.cisco.ucs.plugin;

import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.runtime.RuntimeInfo;
import org.opennms.integration.api.v1.scv.SecureCredentialsVault;

public class ConnectionManagerForTest extends ConnectionManager {
    public ConnectionManagerForTest(RuntimeInfo runtimeInfo, SecureCredentialsVault vault) {
        super(runtimeInfo, vault);
    }

    @Override
    public void ensureCore() {
    }
}
