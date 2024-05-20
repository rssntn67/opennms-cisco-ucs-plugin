package it.xeniaprogetti.cisco.ucs.plugin.collection;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import org.opennms.integration.api.v1.collectors.CollectionRequest;
import org.opennms.integration.api.v1.collectors.CollectionSet;
import org.opennms.integration.api.v1.collectors.ServiceCollector;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class UcsCollector implements ServiceCollector {
    private final Map<UcsDn, Set<UcsEnums.NamingClassId>> collectionItemMap = new HashMap<>();


    @Override
    public void initialize() {
        collectionItemMap.put(UcsDn.getDn("fabric/lan"), new HashSet<>());
        collectionItemMap.get(UcsDn.getDn("fabric/lan")).add(UcsEnums.NamingClassId.etherRxStats);
        collectionItemMap.get(UcsDn.getDn("fabric/lan")).add(UcsEnums.NamingClassId.etherTxStats);
        collectionItemMap.put(UcsDn.getDn("fabric/san"), new HashSet<>());
        collectionItemMap.get(UcsDn.getDn("fabric/san")).add(UcsEnums.NamingClassId.fcErrStats);
        collectionItemMap.get(UcsDn.getDn("fabric/san")).add(UcsEnums.NamingClassId.fcStats);
        collectionItemMap.put(UcsDn.getDn("sys/chassis-*/blade-*"), new HashSet<>());
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.adaptorEthPortErrStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.adaptorEthPortMcastStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.adaptorEthPortStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.adaptorVnicStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.processorEnvStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.processorErrorStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.memoryUnitEnvStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.memoryErrorStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.computePCIeFatalCompletionStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.computePCIeFatalProtocolStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.computePCIeFatalReceiveStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.computePCIeFatalStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.computeMbPowerStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.computeMbTempStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.storageDiskEnvStats);
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*/blade-*")).add(UcsEnums.NamingClassId.storageSsdHealthStats);
        collectionItemMap.put(UcsDn.getDn("sys/chassis-*"), new HashSet<>());
        collectionItemMap.get(UcsDn.getDn("sys/chassis-*")).add(UcsEnums.NamingClassId.equipmentFanStats);

    }

    @Override
    public CompletableFuture<CollectionSet> collect(CollectionRequest collectionRequest, Map<String, Object> map) {
        return null;
    }
}
