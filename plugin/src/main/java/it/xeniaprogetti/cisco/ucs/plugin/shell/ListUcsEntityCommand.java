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

@Command(scope = "opennms-cucs", name = "list-ucs-entity", description = "List Ucs Entity", detailedDescription = "List all Supported Ucs Entity")
@Service
public class ListUcsEntityCommand implements Action {

    @Reference
    private ConnectionManager connectionManager;

    @Reference
    private ClientManager clientManager;

    @Reference
    private Session session;

    @Argument(name = "alias", description = "Connection alias", required = true)
    @Completion(AliasCompleter.class)
    private String alias = null;

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
                .column(new Col("ClassId").maxSize(12))
                .column(new Col("ClassItem").maxSize(12));

        var service = clientManager.getClientService(connection.get());
        for (final var ne : service.getUcsNetworkElementList()) {
            final var row = table.addRow();
            row.addContent(ne.dn.value);
            row.addContent(ne.classId);
            row.addContent(ne.classItem);
        }
        for (final var cb : service.getUcsComputeBladeList()) {
            final var row = table.addRow();
            row.addContent(cb.dn.value);
            row.addContent(cb.classId);
            row.addContent(cb.classItem);
        }
        for (final var cru : service.getUcsComputeRackUnitList()) {
            final var row = table.addRow();
            row.addContent(cru.dn.value);
            row.addContent(cru.classId);
            row.addContent(cru.classItem);
        }
        for (final var e : service.getUcsEquipmentChassisList()) {
            final var row = table.addRow();
            row.addContent(e.dn.value);
            row.addContent(e.classId);
            row.addContent(e.classItem);
        }
        for (final var e : service.getUcsEquipmentFexList()) {
            final var row = table.addRow();
            row.addContent(e.dn.value);
            row.addContent(e.classId);
            row.addContent(e.classItem);
        }
        for (final var e : service.getUcsEquipmentRackEnclosureList()) {
            final var row = table.addRow();
            row.addContent(e.dn.value);
            row.addContent(e.classId);
            row.addContent(e.classItem);
        }
        table.print(System.out, true);

        return null;
    }
}
