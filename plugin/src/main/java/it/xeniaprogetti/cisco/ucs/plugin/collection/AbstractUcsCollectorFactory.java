package it.xeniaprogetti.cisco.ucs.plugin.collection;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import it.xeniaprogetti.cisco.ucs.plugin.pollers.CiscoUcsAbstractPoller;
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
        final var alias = Objects.requireNonNull(parameters.get(CiscoUcsAbstractPoller.ALIAS_KEY), "Missing property: " + CiscoUcsAbstractPoller.ALIAS_KEY);
        final var connection = this.connectionManager.getConnection(Objects.toString(alias))
                .orElseThrow(() -> new NullPointerException("Connection not found for alias: " + alias));

        final var runtimeAttributes = new HashMap<>(parameters);

        runtimeAttributes.put(CiscoUcsAbstractPoller.DN_KEY, Objects.requireNonNull(parameters.get(CiscoUcsAbstractPoller.DN_KEY),""));

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
