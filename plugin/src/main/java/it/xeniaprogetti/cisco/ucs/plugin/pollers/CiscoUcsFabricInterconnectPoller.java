package it.xeniaprogetti.cisco.ucs.plugin.pollers;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsNetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.pollers.PollerResult;
import org.opennms.integration.api.v1.pollers.Status;
import org.opennms.integration.api.v1.pollers.immutables.ImmutablePollerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class CiscoUcsFabricInterconnectPoller extends CiscoUcsFabricInterconnectAbstractPoller {

    private static final Logger LOG = LoggerFactory.getLogger(CiscoUcsFabricInterconnectPoller.class);

    public CiscoUcsFabricInterconnectPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        super(connectionManager,clientManager);
    }

    @Override
    protected PollerResult poll(final UcsNetworkElement equipment) {
        if (!Objects.equals(equipment.operability, "operable")) {
            LOG.info("poll: Ucs Network Element Status: {}", equipment.operability);
            return ImmutablePollerResult.newBuilder()
                    .setStatus(Status.Down)
                    .setReason("Ucs Network Element Status: " + equipment.operability)
                    .build();
        }
        return ImmutablePollerResult.newBuilder()
                .setStatus(Status.Up)
                .build();
    }



}
