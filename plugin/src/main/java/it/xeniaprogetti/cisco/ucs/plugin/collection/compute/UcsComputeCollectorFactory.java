package it.xeniaprogetti.cisco.ucs.plugin.collection.compute;


import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.collection.AbstractUcsCollectorFactory;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;

public class UcsComputeCollectorFactory extends AbstractUcsCollectorFactory<UcsComputeCollector> {

    public UcsComputeCollectorFactory(ClientManager clientManager, ConnectionManager connectionManager) {
        super(clientManager, connectionManager);
    }

    @Override
    public UcsComputeCollector createCollector() {
        return new UcsComputeCollector(clientManager, connectionManager);
    }

    @Override
    public String getCollectorClassName() {
        return UcsComputeCollector.class.getCanonicalName();
    }

}
