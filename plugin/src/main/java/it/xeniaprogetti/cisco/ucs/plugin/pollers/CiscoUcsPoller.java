package it.xeniaprogetti.cisco.ucs.plugin.pollers;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeRackUnit;
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

public class CiscoUcsPoller extends CiscoUcsAbstractPoller {

    private static final Logger LOG = LoggerFactory.getLogger(CiscoUcsPoller.class);

    public CiscoUcsPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
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

    @Override
    protected PollerResult poll(final UcsEquipmentChassis equipment) {
        if (!Objects.equals(equipment.operState, "operable")) {
            LOG.info("poll: Ucs Equipment Chassis Status: {}", equipment.operState);
            return ImmutablePollerResult.newBuilder()
                    .setStatus(Status.Down)
                    .setReason("Ucs Equipment Chassis Status: " + equipment.operState)
                    .build();
        }
        return ImmutablePollerResult.newBuilder()
                .setStatus(Status.Up)
                .build();
    }

    @Override
    protected PollerResult poll(final UcsEquipmentFex equipment) {
        if (!Objects.equals(equipment.operState, "operable")) {
            LOG.info("poll: Ucs Equipment Fex Status: {}", equipment.operState);
            return ImmutablePollerResult.newBuilder()
                    .setStatus(Status.Down)
                    .setReason("Ucs Ucs Equipment Fex Operation Status: " + equipment.operState)
                    .build();
        }
        return ImmutablePollerResult.newBuilder()
                .setStatus(Status.Up)
                .build();
    }

    @Override
    protected PollerResult poll(final UcsEquipmentRackEnclosure equipment) {
        if (!Objects.equals(equipment.operability, "operable")) {
            LOG.info("poll: Ucs Equipment Rack Enclosure Status: {}", equipment.operability);
            return ImmutablePollerResult.newBuilder()
                    .setStatus(Status.Down)
                    .setReason("Ucs Equipment Rack Enclosure Status: " + equipment.operability)
                    .build();
        }
        return ImmutablePollerResult.newBuilder()
                .setStatus(Status.Up)
                .build();
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
