package it.xeniaprogetti.cisco.ucs.plugin.shell;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import it.xeniaprogetti.cisco.ucs.plugin.TopologyForwarder;
import it.xeniaprogetti.cisco.ucs.plugin.model.Topology;

@Command(scope = "opennms-cisco-ucs", name = "push-topology", description = "Push the topology")
@Service
public class TopologyCommand implements Action {

    @Reference
    private TopologyForwarder forwarder;

    @Override
    public Object execute() {
        System.out.println("Forwarding topologies...");
        final CompletableFuture<List<Topology>> future = forwarder.forwardTopologies();
        future.whenComplete((topologies,ex) -> {
            if (ex == null) {
                System.out.printf("Successfully forwarded %d topologies.", topologies.size());
            } else {
                System.out.println("Error occurred forwarding topologies: " + ex);
                ex.printStackTrace();
            }
        });
        try {
            future.get();
        } catch (Exception e) {
            // pass
        }
        return null;
    }
}
