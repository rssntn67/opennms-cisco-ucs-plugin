package it.xeniaprogetti.cisco.ucs.plugin.pollers;


import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;

public class CiscoUcsComputePollerFactory extends CiscoUcsAbstractPoller.Factory<CiscoUcsComputePoller> {

    public CiscoUcsComputePollerFactory(final ConnectionManager connectionManager, final ClientManager clientManager) {
        super(connectionManager,clientManager, CiscoUcsComputePoller.class);
    }

    @Override
    protected CiscoUcsComputePoller createPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        return new CiscoUcsComputePoller(connectionManager, clientManager);
    }
}
