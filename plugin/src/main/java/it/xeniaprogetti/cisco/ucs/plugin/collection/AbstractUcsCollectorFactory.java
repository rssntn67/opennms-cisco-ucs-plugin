package it.xeniaprogetti.cisco.ucs.plugin.collection;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.collectors.CollectionRequest;
import org.opennms.integration.api.v1.collectors.ServiceCollectorFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


abstract public class AbstractUcsCollectorFactory<T extends AbstractUcsServiceCollector> implements ServiceCollectorFactory<T> {

    protected final ClientManager clientManager;
    protected final ConnectionManager connectionManager;

    public AbstractUcsCollectorFactory(final ClientManager clientManager, final ConnectionManager connectionManager) {
        this.clientManager = Objects.requireNonNull(clientManager);
        this.connectionManager = Objects.requireNonNull(connectionManager);
    }

    @Override
    public Map<String, Object> getRuntimeAttributes(CollectionRequest collectionRequest, Map<String, Object> parameters) {
        final var alias = Objects.requireNonNull(parameters.get(UcsUtils.UCS_ALIAS_KEY), "Missing property: " + UcsUtils.UCS_ALIAS_KEY);
        final var dn = Objects.requireNonNull(parameters.get(UcsUtils.UCS_DN_KEY), "Missing property: " + UcsUtils.UCS_DN_KEY);
        final var type = Objects.requireNonNull(parameters.get(UcsUtils.UCS_TYPE_KEY), "Missing property: " + UcsUtils.UCS_TYPE_KEY);
        final var fabricLanDn = parameters.get(UcsUtils.UCS_FABRIC_LAN_KEY);
        final var fabricSanDn = parameters.get(UcsUtils.UCS_FABRIC_SAN_KEY);
        final var runtimeAttributes = new HashMap<>(parameters);

        runtimeAttributes.put(UcsUtils.UCS_ALIAS_KEY, alias);
        runtimeAttributes.put(UcsUtils.UCS_DN_KEY, dn);
        runtimeAttributes.put(UcsUtils.UCS_TYPE_KEY, type);
        if (fabricLanDn != null)
            runtimeAttributes.put(UcsUtils.UCS_FABRIC_LAN_KEY,fabricLanDn);
        if (fabricSanDn != null)
            runtimeAttributes.put(UcsUtils.UCS_FABRIC_SAN_KEY,fabricSanDn);



        return runtimeAttributes;
    }

    @Override
    public Map<String, String> marshalParameters(Map<String, Object> parameters) {
        return parameters.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toString()));
    }

    @Override
    public Map<String, Object> unmarshalParameters(Map<String, String> parameters) {
        return parameters.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
