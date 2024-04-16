
package it.xeniaprogetti.cisco.ucs.plugin.shell;

import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.api.console.CommandLine;
import org.apache.karaf.shell.api.console.Completer;
import org.apache.karaf.shell.api.console.Session;
import org.apache.karaf.shell.support.completers.StringsCompleter;

import java.util.List;


@Service
public class AliasCompleter implements Completer {

    @Reference
    public ConnectionManager connectionManager;

    @Override
    public int complete(Session session, CommandLine commandLine, List<String> candidates) {
        final var delegate = new StringsCompleter(connectionManager.getAliases(), true);
        return delegate.complete(session, commandLine, candidates);
    }


}
