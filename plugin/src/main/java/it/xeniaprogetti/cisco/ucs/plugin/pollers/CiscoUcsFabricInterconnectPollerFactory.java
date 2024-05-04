package it.xeniaprogetti.cisco.ucs.plugin.pollers;


import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;

public class CiscoUcsFabricInterconnectPollerFactory extends CiscoUcsAbstractPoller.Factory<CiscoUcsFabricInterconnectPoller> {

    public CiscoUcsFabricInterconnectPollerFactory(final ConnectionManager connectionManager, final ClientManager clientManager) {
        super(connectionManager,clientManager, CiscoUcsFabricInterconnectPoller.class);
    }

    @Override
    protected CiscoUcsFabricInterconnectPoller createPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        return new CiscoUcsFabricInterconnectPoller(connectionManager, clientManager);
    }
}
