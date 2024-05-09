package it.xeniaprogetti.cisco.ucs.plugin.pollers;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsNetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.pollers.PollerResult;
import org.opennms.integration.api.v1.pollers.Status;
import org.opennms.integration.api.v1.pollers.immutables.ImmutablePollerResult;

import java.util.concurrent.CompletableFuture;

public abstract class CiscoUcsFabricInterconnectAbstractPoller extends CiscoUcsAbstractPoller {

    protected CiscoUcsFabricInterconnectAbstractPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        super(connectionManager,clientManager);
    }

    protected abstract PollerResult poll(final UcsNetworkElement networkElement) throws ApiException;


    @Override
    public CompletableFuture<PollerResult> poll(final Context context) throws ApiException {
        final var type = context.getUcsEntityClassId();
        if (type == UcsEnums.ClassId.networkElement) {
            return CompletableFuture
                .completedFuture(
                    this.poll(
                        context.client()
                            .resolveUcsNetworkElementByResponse(context.getResponse())
                    )
                );
        }
        return CompletableFuture.completedFuture(ImmutablePollerResult.newBuilder()
                        .setStatus(Status.Unknown)
                        .setReason("No UCS Equipment Entity: " + type)
                        .build());
    }
}
