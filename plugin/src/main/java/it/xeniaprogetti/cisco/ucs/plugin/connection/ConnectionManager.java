package it.xeniaprogetti.cisco.ucs.plugin.connection;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import org.opennms.integration.api.v1.runtime.Container;
import org.opennms.integration.api.v1.runtime.RuntimeInfo;
import org.opennms.integration.api.v1.scv.Credentials;
import org.opennms.integration.api.v1.scv.SecureCredentialsVault;
import org.opennms.integration.api.v1.scv.immutables.ImmutableCredentials;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import java.util.stream.Collectors;

public class ConnectionManager {

    private static final String PREFIX = "cucs_connection_";
    public static final String CUCS_URL_KEY = "cucsUrl";
    public static final String CUCS_VALIDITY_KEY = "cucsValidity";
    public static final String IGNORE_SSL_CERTIFICATE_VALIDATION_KEY = "ignoreSslCertificateValidation";

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
    public Optional<Connection> getConnection(final String alias) {
        this.ensureCore();

        final var credentials = this.vault.getCredentials(PREFIX + alias.toLowerCase());
        if (credentials == null) {
            return Optional.empty();
        }
        ConnectionImpl conn = new ConnectionImpl(alias, fromStore(credentials));
        return Optional.of(conn);
    }

    /**
     * Creates a basic authentication connection under the given alias.
     *
     * @param alias           the alias of the connection to add
     * @param url        the URL of the prism server
     * @param username          the username to authenticate the connection
     * @param password          the password to authenticate the connection
     * @param ignoreSslCerticateValidation          ignore Ssl Certificate Validation
     * @param validity          time in seconds before cucs session need to be refreshed
     */
    public Connection newConnection(final String alias, final String url, final String username, final String password, final boolean ignoreSslCerticateValidation, final int validity) {
        this.ensureCore();

        return new ConnectionImpl(alias, ApiClientCredentials.builder()
                .withUrl(url)
                .withUsername(username)
                .withPassword(password)
                .withIgnoreSslCertificateValidation(ignoreSslCerticateValidation)
                .withValidity(validity)
                .build());
    }

    /**
     * Deletes a connection under the given alias.
     *
     * @param alias the alias of the connection to delete
     * @return <b>true</b> if an existing connection with given alias was found and deleted and <b>false</b> if no
     * connection with given alias was not found
     */
    public boolean deleteConnection(final String alias) {
        this.ensureCore();

        final var connection = this.getConnection(alias);
        if (connection.isEmpty()) {
            return false;
        }
        connection.get().delete();
        return true;
    }

    private static ApiClientCredentials fromStore(final Credentials credentials) {


        if (Strings.isNullOrEmpty(credentials.getPassword())) {
            throw new IllegalStateException("API password is missing");
        }
        if (Strings.isNullOrEmpty(credentials.getUsername())) {
            throw new IllegalStateException("API username is missing");
        }

        if (Strings.isNullOrEmpty(credentials.getAttribute(CUCS_URL_KEY))) {
            throw new IllegalStateException("Cisco Ucs Manager URL is missing");
        }

        if (Strings.isNullOrEmpty(credentials.getAttribute(CUCS_VALIDITY_KEY))) {
            throw new IllegalStateException("Cisco Ucs Manager validity is missing");
        }

        if (Strings.isNullOrEmpty(credentials.getAttribute(IGNORE_SSL_CERTIFICATE_VALIDATION_KEY))) {
            throw new IllegalStateException("Ignore  SSL CERTIFICATION Validation is missing");
        }


        final var cUrl = credentials.getAttribute(CUCS_URL_KEY);

        final var username = credentials.getUsername();
        final var password = credentials.getPassword();
        final var ignoreSslCertificateValidation = Boolean.parseBoolean(credentials.getAttribute(IGNORE_SSL_CERTIFICATE_VALIDATION_KEY));
        final var validity = Integer.parseInt(credentials.getAttribute(CUCS_VALIDITY_KEY));
        return ApiClientCredentials.builder()
                .withUrl(cUrl)
                .withUsername(username)
                .withPassword(password)
                .withIgnoreSslCertificateValidation(ignoreSslCertificateValidation)
                .withValidity(validity)
                .build();
        }


    private class ConnectionImpl implements Connection {
        private final String alias;

        private ApiClientCredentials credentials;

        private ConnectionImpl(final String alias, final ApiClientCredentials credentials) {
            this.alias = Objects.requireNonNull(alias).toLowerCase();
            this.credentials = Objects.requireNonNull(credentials);
        }

        @Override
        public boolean isIgnoreSslCertificateValidation() {
            return this.credentials.ignoreSslCertificateValidation;
        }

        @Override
        public void setIgnoreSslCertificateValidation(boolean ignoreSslCertificateValidation) {
            this.credentials = ApiClientCredentials.builder(this.credentials)
                    .withIgnoreSslCertificateValidation(ignoreSslCertificateValidation)
                    .build();
        }

        @Override
        public String getAlias() {
            return this.alias;
        }

        @Override
        public String getUrl() {
            return this.credentials.url;
        }

        @Override
        public void setUrl(final String url) {
            this.credentials = ApiClientCredentials.builder()
                                                            .withUrl(url)
                                                            .build();
        }
        @Override
        public String getUsername() {
            return this.credentials.username;
        }

        @Override
        public void setUsername(final String username) {
            this.credentials = ApiClientCredentials.builder(this.credentials)
                    .withUsername(username)
                    .build();
        }

        @Override
        public String getPassword() {
            return this.credentials.password;
        }

        @Override
        public void setPassword(final String password) {
            this.credentials = ApiClientCredentials.builder(this.credentials)
                    .withPassword(password)
                    .build();
        }

        @Override
        public void setValidityTime(int validity) {
            this.credentials = ApiClientCredentials.builder(this.credentials)
                    .withValidity(validity)
                    .build();
        }

        @Override
        public int getValidityTime() {
            return this.credentials.validity;
        }


        @Override
        public void save() {
            // Purge cached client with old credentials
            ConnectionManager.this.vault.setCredentials(PREFIX + this.alias, this.asCredentials());
        }

        @Override
        public void delete() {
            ConnectionManager.this.vault.deleteCredentials(PREFIX + this.alias);
        }

        private Credentials asCredentials() {
            Map<String,String> credentialMap = new HashMap<>();
            credentialMap.put(CUCS_URL_KEY, this.credentials.url);
            credentialMap.put(IGNORE_SSL_CERTIFICATE_VALIDATION_KEY, String.valueOf(this.credentials.ignoreSslCertificateValidation));
            credentialMap.put(CUCS_VALIDITY_KEY, String.valueOf(this.credentials.validity));
            return new ImmutableCredentials(this.credentials.username, this.credentials.password, credentialMap);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                              .add("alias", this.alias)
                              .add(CUCS_URL_KEY, this.credentials.url)
                              .add("username", this.credentials.username)
                              .add("password", "******")
                              .add(IGNORE_SSL_CERTIFICATE_VALIDATION_KEY, this.credentials.ignoreSslCertificateValidation)
                              .add(CUCS_VALIDITY_KEY, this.credentials.validity)
                    .toString();
        }
    }

    public void ensureCore() {
        if (this.runtimeInfo.getContainer() != Container.OPENNMS) {
            throw new IllegalStateException("Operation only allowed on OpenNMS instance");
        }
    }
}
