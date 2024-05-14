package it.xeniaprogetti.cisco.ucs.plugin.pollers;


import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;

public class CiscoUcsPollerFactory extends CiscoUcsAbstractPoller.Factory<CiscoUcsPoller> {

    public CiscoUcsPollerFactory(final ConnectionManager connectionManager, final ClientManager clientManager) {
        super(connectionManager,clientManager, CiscoUcsPoller.class);
    }

    @Override
    protected CiscoUcsPoller createPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        return new CiscoUcsPoller(connectionManager, clientManager);
    }
}
