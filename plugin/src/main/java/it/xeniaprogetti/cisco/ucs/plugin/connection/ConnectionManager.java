package it.xeniaprogetti.cisco.ucs.plugin.connection;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import org.opennms.integration.api.v1.runtime.Container;
import org.opennms.integration.api.v1.runtime.RuntimeInfo;
import org.opennms.integration.api.v1.scv.Credentials;
import org.opennms.integration.api.v1.scv.SecureCredentialsVault;
import org.opennms.integration.api.v1.scv.immutables.ImmutableCredentials;
import org.opennms.netmgt.config.SnmpPeerFactory;
import org.opennms.netmgt.snmp.SnmpAgentConfig;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.stream.Collectors;

public class ConnectionManager {

    private static final String PREFIX = "cisco_ucs_connection_";
    public static final String ADDRESS_KEY = "address";
    public static final String LOCATION_KEY = "location";


    private final RuntimeInfo runtimeInfo;

    private final SecureCredentialsVault vault;

    public ConnectionManager(final RuntimeInfo runtimeInfo,
                             final SecureCredentialsVault vault) {
        this.runtimeInfo = Objects.requireNonNull(runtimeInfo);
        this.vault = Objects.requireNonNull(vault);
    }

    /**
     * Returns a set of all available connection aliases.
     *
     * @return the set of aliases
     */
    public Set<String> getAliases() {
        this.ensureCore();

        return this.vault.getAliases().stream()
                .filter(alias -> alias.startsWith(PREFIX))
                .map(alias -> alias.substring(PREFIX.length()))
                .collect(Collectors.toSet());
    }

    /**
     * Returns a connection config for the given alias.
     *
     * @param alias the alias of the connection config to retrieve
     * @return The connection config or {@code Optional#empty()} of no such alias exists
     */
    public Optional<Connection> getConnection(final String alias) throws UnknownHostException {
        this.ensureCore();

        final var credentials = this.vault.getCredentials(PREFIX + alias.toLowerCase());
        if (credentials == null) {
            return Optional.empty();
        }
        ConnectionImpl conn = new ConnectionImpl(alias, fromStore(credentials), credentials.getAttribute(LOCATION_KEY));
        return Optional.of(conn);
    }

    /**
     * Creates authentication connection under the given alias.
     *
     * @param alias           the alias of the connection to add
     * @param inetAddress        the inet address of the cisco ucs manager
     * @param username          the username to authenticate the connection
     * @param password          the password to authenticate the connection
     * @param location          the location
     *
     */
    public Connection newConnection(final String alias, final InetAddress inetAddress, final String username, final String password, final String location) {
        this.ensureCore();

        SnmpAgentConfig credentials = SnmpPeerFactory.getInstance().getAgentConfig(inetAddress,location);
        credentials.setSecurityName(username);
        credentials.setAuthPassPhrase(password);
        return new ConnectionImpl(alias, credentials,location);
    }

    /**
     * Deletes a connection under the given alias.
     *
     * @param alias the alias of the connection to delete
     * @return <b>true</b> if an existing connection with given alias was found and deleted and <b>false</b> if no
     * connection with given alias was not found
     */
    public boolean deleteConnection(final String alias) throws UnknownHostException {
        this.ensureCore();

        final var connection = this.getConnection(alias);
        if (connection.isEmpty()) {
            return false;
        }
        connection.get().delete();
        return true;
    }

    private static SnmpAgentConfig fromStore(final Credentials credentials) throws UnknownHostException {


        if (Strings.isNullOrEmpty(credentials.getPassword())) {
            throw new IllegalStateException("API password is missing");
        }
        if (Strings.isNullOrEmpty(credentials.getUsername())) {
            throw new IllegalStateException("API username is missing");
        }

        final var inetAddress = InetAddress.getByName(credentials.getAttribute(ADDRESS_KEY));

        final var username = credentials.getUsername();
        final var password = credentials.getPassword();
        final var location = credentials.getAttribute(LOCATION_KEY);

        SnmpAgentConfig agentConfig =  SnmpPeerFactory.getInstance().getAgentConfig(inetAddress, location);
        agentConfig.setSecurityName(username);
        agentConfig.setAuthPassPhrase(password);
        return agentConfig;
    }


    private class ConnectionImpl implements Connection {
        private final String alias;
        private final String location;

        private final SnmpAgentConfig agentConfig;

        private ConnectionImpl(final String alias, final SnmpAgentConfig agentConfig, String location) {
            this.alias = Objects.requireNonNull(alias).toLowerCase();
            this.agentConfig = Objects.requireNonNull(agentConfig);
            this.location = location;
        }

        @Override
        public String getAlias() {
            return this.alias;
        }

        @Override
        public InetAddress getCiscoUcsInetAddress() {
            return agentConfig.getAddress();
        }

        @Override
        public void setCiscoUcsInetAddress(InetAddress inetAddress) {
            agentConfig.setAddress(inetAddress);
        }

        @Override
        public String getUsername() {
            return this.agentConfig.getSecurityName();
        }

        @Override
        public void setUsername(final String username) {
            this.agentConfig.setSecurityName(username);
        }

        @Override
        public String getPassword() {
            return this.agentConfig.getAuthPassPhrase();
        }

        @Override
        public void setPassword(final String password) {
            this.agentConfig.setAuthPassPhrase(password);
        }

        @Override
        public String getLocation() {
            return this.location;
        }


        @Override
        public void save() {
            ConnectionManager.this.vault.setCredentials(PREFIX + this.alias, this.asCredentials());
        }

        @Override
        public void delete() {
            ConnectionManager.this.vault.deleteCredentials(PREFIX + this.alias);
        }


        private Credentials asCredentials() {
            Map<String,String> credentialMap = new HashMap<>();
            credentialMap.put(ADDRESS_KEY, this.agentConfig.getAddress().getHostAddress());
            credentialMap.put(LOCATION_KEY, this.location);
            return new ImmutableCredentials(this.agentConfig.getSecurityName(), this.agentConfig.getAuthPassPhrase(), credentialMap);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                              .add("alias", this.alias)
                              .add(ADDRESS_KEY, this.agentConfig.getAddress().getHostAddress())
                              .add("agentConfig", this.agentConfig)
                              .add(LOCATION_KEY, this.location)
                        .toString();
        }
    }

    private void ensureCore() {
        if (this.runtimeInfo.getContainer() != Container.OPENNMS) {
            throw new IllegalStateException("Operation only allowed on OpenNMS instance");
        }
    }
}
