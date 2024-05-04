package it.xeniaprogetti.cisco.ucs.plugin.pollers;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.pollers.PollerResult;
import org.opennms.integration.api.v1.pollers.Status;
import org.opennms.integration.api.v1.pollers.immutables.ImmutablePollerResult;

import java.util.concurrent.CompletableFuture;

public abstract class CiscoUcsEquipmentAbstractPoller extends CiscoUcsAbstractPoller {

    protected CiscoUcsEquipmentAbstractPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        super(connectionManager,clientManager);
    }

    protected abstract PollerResult poll(final UcsEquipmentChassis equipmentChassis) throws ApiException;
    protected abstract PollerResult poll(final UcsEquipmentFex equipmentFex) throws ApiException;
    protected abstract PollerResult poll(final UcsEquipmentRackEnclosure equipmentRackEnclosure) throws ApiException;


    @Override
    public CompletableFuture<PollerResult> poll(final Context context) throws ApiException {
        String response = context.getResponse();
        final var type = context.getUcsEntityClassId();
        switch (type) {
            case equipmentChassis:
                return CompletableFuture.completedFuture(this.poll(context.client().resolveUcsEquipmentChassisByResponse(response)));
            case equipmentFex:
                return CompletableFuture.completedFuture(this.poll(context.client().resolveUcsEquipmentFexByResponse(response)));
            case equipmentRackEnclosure:
                return CompletableFuture.completedFuture(this.poll(context.client().resolveUcsEquipmentRackEnclosureByResponse(response)));
            default:
                return CompletableFuture.completedFuture(ImmutablePollerResult.newBuilder()
                        .setStatus(Status.Unknown)
                        .setReason("No UCS Equipment Entity: " + type)
                        .build());
        }
    }
}
