package it.xeniaprogetti.cisco.ucs.plugin.pollers;


import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;

public class CiscoUcsEquipmentPollerFactory extends CiscoUcsAbstractPoller.Factory<CiscoUcsEquipmentPoller> {

    public CiscoUcsEquipmentPollerFactory(final ConnectionManager connectionManager, final ClientManager clientManager) {
        super(connectionManager,clientManager, CiscoUcsEquipmentPoller.class);
    }

    @Override
    protected CiscoUcsEquipmentPoller createPoller(final ConnectionManager connectionManager, final ClientManager clientManager) {
        return new CiscoUcsEquipmentPoller(connectionManager, clientManager);
    }
}
