package it.xeniaprogetti.cisco.ucs.plugin.collection;

import org.opennms.integration.api.v1.collectors.CollectionRequest;
import org.opennms.integration.api.v1.collectors.CollectionSet;
import org.opennms.integration.api.v1.collectors.ServiceCollector;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class UcsCollector implements ServiceCollector {
    @Override
    public void initialize() {

    }

    @Override
    public CompletableFuture<CollectionSet> collect(CollectionRequest collectionRequest, Map<String, Object> map) {
        return null;
    }
}
