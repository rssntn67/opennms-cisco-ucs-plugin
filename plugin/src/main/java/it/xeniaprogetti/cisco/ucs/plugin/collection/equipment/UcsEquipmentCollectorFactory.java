package it.xeniaprogetti.cisco.ucs.plugin.collection.equipment;


import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.collection.AbstractUcsCollectorFactory;
import it.xeniaprogetti.cisco.ucs.plugin.collection.compute.UcsComputeCollector;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;

public class UcsEquipmentCollectorFactory extends AbstractUcsCollectorFactory<UcsEquipmentCollector> {

    public UcsEquipmentCollectorFactory(ClientManager clientManager, ConnectionManager connectionManager) {
        super(clientManager, connectionManager);
    }

    @Override
    public UcsEquipmentCollector createCollector() {
        return new UcsEquipmentCollector(clientManager, connectionManager);
    }

    @Override
    public String getCollectorClassName() {
        return UcsComputeCollector.class.getCanonicalName();
    }

}
