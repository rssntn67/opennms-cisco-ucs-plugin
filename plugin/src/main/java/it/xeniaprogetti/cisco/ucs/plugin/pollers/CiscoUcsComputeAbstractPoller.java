package it.xeniaprogetti.cisco.ucs.plugin.pollers;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.pollers.PollerResult;
import org.opennms.integration.api.v1.pollers.Status;
import org.opennms.integration.api.v1.pollers.immutables.ImmutablePollerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public abstract class CiscoUcsComputeAbstractPoller extends CiscoUcsAbstractPoller {

    protected CiscoUcsComputeAbstractPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        super(connectionManager,clientManager);
    }

    protected abstract PollerResult poll(final UcsComputeBlade computeBlade) throws ApiException;
    protected abstract PollerResult poll(final UcsComputeRackUnit computeRackUnit) throws ApiException;


    @Override
    public CompletableFuture<PollerResult> poll(final Context context) throws ApiException {
        String response = context.getResponse();
        final var type = context.getUcsEntityClassId();
        switch (type) {
            case computeBlade:
                return CompletableFuture.completedFuture(this.poll(context.client().resolveUcsComputeBladeByResponse(response)));
            case computeRackUnit:
                return CompletableFuture.completedFuture(this.poll(context.client().resolveUcsComputeRackUnitByResponse(response)));
            default:
                return CompletableFuture.completedFuture(ImmutablePollerResult.newBuilder()
                        .setStatus(Status.Unknown)
                        .setReason("No Compute Entity: " + type)
                        .build());
        }
    }
}
