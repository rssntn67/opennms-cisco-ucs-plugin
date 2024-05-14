package it.xeniaprogetti.cisco.ucs.plugin.shell;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Completion;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.api.console.Session;
import org.apache.karaf.shell.support.table.Col;
import org.apache.karaf.shell.support.table.ShellTable;

@Command(scope = "opennms-cucs", name = "get-ucs-entity", description = "Get Ucs Entity", detailedDescription = "Get Ucs Entity by Dn and ClassId")
@Service
public class GetUcsEntityByDnCommand implements Action {

    @Reference
    private ConnectionManager connectionManager;

    @Reference
    private ClientManager clientManager;

    @Reference
    private Session session;

    @Argument(name = "alias", description = "Connection alias", required = true)
    @Completion(AliasCompleter.class)
    private String alias = null;

    @Argument(index = 1, name = "dn", description = "DN of the entity", required = true)
    private String dn = null;

    @Override
    public Object execute() throws Exception {
        final var connection = this.connectionManager.getConnection(this.alias);
        if (connection.isEmpty()) {
            System.err.println("No connection with alias " + this.alias);
            return null;
        }

        final var table = new ShellTable()
                .size(session.getTerminal().getWidth() - 1)
                .column(new Col("Dn").maxSize(128).bold(true))
                .column(new Col("Response").maxSize(500));

        var service = clientManager.getClient(connection.get());
        String response = service.getUcsXmlFromDn(dn, false);
        final var row = table.addRow();
        row.addContent(dn);
        row.addContent(response.substring(response.indexOf("<outConfig>")+11, response.indexOf("</outConfig>")));
        table.print(System.out, true);
        service.disconnect();

        return null;

    }
}
