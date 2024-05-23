package it.xeniaprogetti.cisco.ucs.plugin.collection.network;


import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.collection.AbstractUcsCollectorFactory;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;

public class UcsNetworkElementCollectorFactory extends AbstractUcsCollectorFactory<UcsNetworkElementCollector> {

    public UcsNetworkElementCollectorFactory(ClientManager clientManager, ConnectionManager connectionManager) {
        super(clientManager, connectionManager);
    }

    @Override
    public UcsNetworkElementCollector createCollector() {
        return new UcsNetworkElementCollector(clientManager, connectionManager);
    }

    @Override
    public String getCollectorClassName() {
        return UcsNetworkElementCollector.class.getCanonicalName();
    }

}
