package it.xeniaprogetti.cisco.ucs.plugin.shell.connection;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "opennms-cucs", name = "connection-edit", description = "Edit a connection", detailedDescription = "Edit an existing connection for Cisco UCS Manger XML API")
@Service
public class EditConnectionCommand implements Action {

    @Reference
    private ConnectionManager connectionManager;

    @Reference
    private ClientManager clientManager;

    @Option(name="-f", aliases="--force", description="Skip validation and save the connection as-is")
    public boolean skipValidation = false;

    @Option(name = "-i", aliases = "--ignore-ssl-certificate-validation", description = "Ignore ssl certificate validation")
    boolean ignoreSslCertificateValidation = false;

    @Argument(name = "alias", description = "Alias", required = true)
    public String alias = null;

    @Argument(index = 1, name = "url", description = "Cisco Ucs Manager XML API Url", required = true)
    public String url = null;

    @Argument(index = 2, name = "username", description = "Cisco Ucs Manager XML API username", required = true)
    public String username = null;

    @Argument(index = 3, name = "password", description = "Cisco Ucs Manager XML API password", required = true, censor = true)
    public String password = null;

    @Argument(index = 4, name = "validity", description = "Cisco Ucs Manager XML API time in seconds to refresh connection")
    public int validity = 30;


    @Override
    public Object execute() throws Exception {
        final var connection = this.connectionManager.getConnection(this.alias);

        if (connection.isEmpty()) {
            System.err.println("No connection with the given alias exists: " + this.alias);
            return null;
        }


        connection.get().setUrl(url);
        connection.get().setUsername(username);
        connection.get().setPassword(password);
        connection.get().setIgnoreSslCertificateValidation(ignoreSslCertificateValidation);
        connection.get().setValidityTime(validity);
        System.err.println("updating: " + connection);


        if (!this.skipValidation) {
            final var error = clientManager.validate(connection.get());
            if (error.isPresent()) {
                System.err.println("Failed to validate credentials: " + error.get().message);
                return null;
            }
        }

        connection.get().save();
        System.out.println("Connection updated");

        return null;
    }
}
