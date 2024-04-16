package it.xeniaprogetti.cisco.ucs.plugin.shell.connection;

import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "opennms-nutanix", name = "connection-validate", description = "Validate a connection", detailedDescription = "Validate an existing connection to a nutanix prism")
@Service
public class ValidateConnectionCommand implements Action {

    @Reference
    private ConnectionManager connectionManager;


    @Argument(name = "alias", description = "Alias", required = true)
    public String alias = null;

    @Override
    public Object execute() throws Exception {
        final var connection = this.connectionManager.getConnection(this.alias);
        if (connection.isEmpty()) {
            System.err.println("No connection with the given alias exists: " + this.alias);
            return null;
        }

        final var error = connectionManager.validate(connection.get());
        if (error.isPresent()) {
            System.err.println("Connection invalid: " + error.get().message);
        } else {
            System.out.println("Connection is valid");
        }

        return null;
    }
}
