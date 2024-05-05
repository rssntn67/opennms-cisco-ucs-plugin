package it.xeniaprogetti.cisco.ucs.plugin.shell;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
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

@Command(scope = "opennms-cucs", name = "list-ucs-compute-item-dn", description = "List Ucs Compute Item", detailedDescription = "List all DN Compute Item")
@Service
public class ListUcsDnsByClassIdCommand implements Action {

    @Reference
    private ConnectionManager connectionManager;

    @Reference
    private ClientManager clientManager;

    @Reference
    private Session session;

    @Argument(name = "alias", description = "Connection alias", required = true)
    @Completion(AliasCompleter.class)
    private String alias = null;

    @Argument(index = 1, name = "classId", description = "classId", required = true)
    @Completion(ClassIdCompleter.class)
    private String classId = null;

    @Override
    public Object execute() throws Exception {
        final var connection = this.connectionManager.getConnection(this.alias);
        if (connection.isEmpty()) {
            System.err.println("No connection with alias " + this.alias);
            return null;
        }

        final var table = new ShellTable()
                .size(session.getTerminal().getWidth() - 1)
                .column(new Col("Dn").maxSize(64).bold(true));

        var service = clientManager.getClient(connection.get());
        for (final var dn : service.findDnByClassItem(UcsEnums.NamingClassId.valueOf(classId))) {
            final var row = table.addRow();
            row.addContent(dn);
        }
        service.disconnect();
        table.print(System.out, true);

        return null;
    }
}
