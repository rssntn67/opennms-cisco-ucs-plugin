package it.xeniaprogetti.cisco.ucs.plugin.shell.connection;

import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Command(scope = "opennms-cisco-ucs", name = "connection-add", description = "Add a connection", detailedDescription = "Add a connection to a nutanix prism")
@Service
public class AddConnectionCommand implements Action {

    @Reference
    private ConnectionManager connectionManager;

    @Option(name="-f", aliases="--force", description="Skip validation and save the connection as-is")
    public boolean skipValidation = false;

    @Option(name = "-t", aliases = "--test", description = "Dry run mode, test the credentials but do not save them")
    boolean dryRun = false;

    @Argument(name = "alias", description = "Alias", required = true)
    public String alias = null;

    @Argument(index = 1, name = "address", description = "Cisco UCS address", required = true)
    public String address = null;

    @Argument(index = 2, name = "username", description = "Cisco UCS Snmp Agent Security Name", required = true)
    public String username = null;

    @Argument(index = 3, name = "password", description = "Cisco UCS Snmp Agent Auth Passphrase", required = true, censor = true)
    public String password = null;

    @Argument(index = 4, name = "location", description = "OpenNMS Location")
    public String location = "Default";

    @Override
    public Object execute() throws UnknownHostException {
        if (this.connectionManager.getConnection(this.alias).isPresent()) {
            System.err.println("Connection with alias already exists: " + this.alias);
            return null;
        }

        final var connection =
                this.connectionManager.newConnection(
                                this.alias,
                        InetAddress.getByName(this.address),
                                this.username,
                                this.password,
                        this.location
        );
        System.err.println("saving: " + connection);

        if (!this.skipValidation) {
            final var error = this.connectionManager.validate(connection);
            if (error.isPresent()) {
                System.err.println("Failed to validate credentials: " + error.get().message);
                return null;
            }
        }

        if (this.dryRun) {
            System.out.println("Connection valid");
            return null;
        }

        connection.save();
        System.out.println("Connection created");

        return null;
    }
}
