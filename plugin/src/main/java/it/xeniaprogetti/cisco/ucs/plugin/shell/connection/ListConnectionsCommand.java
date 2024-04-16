package it.xeniaprogetti.cisco.ucs.plugin.shell.connection;

import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.api.console.Session;
import org.apache.karaf.shell.support.table.Col;
import org.apache.karaf.shell.support.table.ShellTable;

import java.net.UnknownHostException;

@Command(scope = "opennms-nutanix", name = "connection-list", description = "List existing connections", detailedDescription = "List all existing connections to Nutanix Prism")
@Service
public class ListConnectionsCommand implements Action {

    @Reference
    private Session session;

    @Reference
    private ConnectionManager connectionManager;

    @Override
    public Object execute() {
        final var table = new ShellTable()
                .size(session.getTerminal().getWidth() - 1)
                .column(new Col("alias").maxSize(36))
                .column(new Col("address").maxSize(48))
                .column(new Col("securityName").maxSize(36))
                .column(new Col("authPassPhrase").maxSize(36))
                .column(new Col("location").maxSize(12))
                ;

        this.connectionManager.getAliases().stream()
                                      .map(alias -> {
                                          try {
                                              return this.connectionManager.getConnection(alias).orElseThrow();
                                          } catch (UnknownHostException e) {
                                              throw new RuntimeException(e);
                                          }
                                      })
                                      .forEach(connection -> {
                                          final var row = table.addRow();
                                          row.addContent(connection.getAlias());
                                          row.addContent(connection.getCiscoUcsInetAddress());
                                          row.addContent(connection.getUsername());
                                          row.addContent("*****");
                                          row.addContent(connection.getLocation());
                                      });

        table.print(System.out, true);

        return null;
    }
}
