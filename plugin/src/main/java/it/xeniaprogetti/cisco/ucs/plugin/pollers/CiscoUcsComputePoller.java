package it.xeniaprogetti.cisco.ucs.plugin.pollers;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEntity;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.pollers.PollerResult;
import org.opennms.integration.api.v1.pollers.Status;
import org.opennms.integration.api.v1.pollers.immutables.ImmutablePollerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class CiscoUcsComputePoller extends CiscoUcsComputeAbstractPoller {

    private static final Logger LOG = LoggerFactory.getLogger(CiscoUcsComputePoller.class);

    public CiscoUcsComputePoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        super(connectionManager,clientManager);
    }

    @Override
    protected PollerResult poll(final UcsComputeBlade compute) {
        if (!Objects.equals(compute.operState, "ok")) {
            LOG.info("poll: Ucs Compute Blade Status: {}", compute.operState);
            return ImmutablePollerResult.newBuilder()
                    .setStatus(Status.Down)
                    .setReason("Ucs Compute Blade Status: " + compute.operState)
                    .build();
        }
        return ImmutablePollerResult.newBuilder()
                                    .setStatus(Status.Up)
                                    .build();
    }

    @Override
    protected PollerResult poll(final UcsComputeRackUnit compute) {
        if (!Objects.equals(compute.operState, "ok")) {
            LOG.info("poll: Ucs Compute Rack Unit Status: {}", compute.operState);
            return ImmutablePollerResult.newBuilder()
                    .setStatus(Status.Down)
                    .setReason("Ucs Compute Rack Unit Status: " + compute.operState)
                    .build();
        }
        return ImmutablePollerResult.newBuilder()
                .setStatus(Status.Up)
                .build();
    }


}
