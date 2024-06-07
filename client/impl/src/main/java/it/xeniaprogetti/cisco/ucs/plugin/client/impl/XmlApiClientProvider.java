package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientProvider;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlApiClientProvider implements ApiClientProvider {

    private static final Logger LOG = LoggerFactory.getLogger(XmlApiClientProvider.class);
    private static final Map<ApiClientCredentials, List<XmlApiClientService>> serviceAvailableMap = new HashMap<>();
    private static final Map<ApiClientCredentials, List<XmlApiClientService>> serviceUsedMap = new HashMap<>();
    private final int clientPoolSize;
    private final Map<ApiClientCredentials, Integer> poolIdMap = new HashMap<>();

    public XmlApiClientProvider(int clientPoolSize) {
        this.clientPoolSize = clientPoolSize;
    }

    protected static ApiClient createApiClient(ApiClientCredentials apiClientCredentials) {
        ApiClient client = new ApiClient(apiClientCredentials.url);
        if (apiClientCredentials.ignoreSslCertificateValidation)
            client.setTrustAllCertsClient();
        return client;
    }

    public boolean release(XmlApiClientService service) {
        serviceAvailableMap.get(service.getCredentials()).add(service);
        boolean result = serviceUsedMap.get(service.getCredentials()).remove(service);
        int avail = serviceAvailableMap.get(service.getCredentials()).size();
        int used = serviceUsedMap.get(service.getCredentials()).size();
        int poolId = poolIdMap.get(service.getCredentials());
        int poolSize = poolId + 1;
        LOG.info("release: url/user {}/{}, poolSize/maxPoolSize {}/{} avail:{}, used:{}",
                service.getCredentials().url,
                service.getCredentials().username,
                poolSize,
                this.clientPoolSize,
                avail,
                used);
        return result;
    }


    @Override
    public XmlApiClientService client(ApiClientCredentials credentials) throws ApiException {
        if (!serviceAvailableMap.containsKey(credentials)) {
            LOG.debug("client: url/user {}/{} no client found! Initialize!",
                    credentials.url,
                    credentials.username);
            serviceAvailableMap.put(credentials, new ArrayList<>());
            serviceUsedMap.put(credentials, new ArrayList<>());
            poolIdMap.put(credentials, -1);
        }
        int poolId = poolIdMap.get(credentials);
        int poolSize = poolId + 1;
        if (serviceAvailableMap.get(credentials).isEmpty() && poolSize == clientPoolSize) {
            LOG.info("client: url/user {}/{} poolSize/maxPoolSize {}/{}, no room space left on clientPool",
                    credentials.url,
                    credentials.username,
                    poolSize,
                    this.clientPoolSize
            );
            throw new ApiException("no api client connection available", new RuntimeException(
                    "Maximum pool size reached, no available connections!"));
        }
        XmlApiClientService service;
        if (serviceAvailableMap.get(credentials).isEmpty()) {
            LOG.info("client: url/user {}/{}, adding a new client to clientPool!",
                    credentials.url,
                    credentials.username);
            poolId++;
            poolSize++;
            service = new XmlApiClientService(credentials, this, poolId);
            poolIdMap.put(credentials, poolId);
        } else {
            int size = serviceAvailableMap.get(credentials).size();
            service = serviceAvailableMap.get(credentials).remove(size-1);
        }
        serviceUsedMap.get(credentials).add(service);
        int avail = serviceAvailableMap.get(credentials).size();
        int used = serviceUsedMap.get(credentials).size();
        LOG.info("client: url/user {}/{}, poolSize/maxPoolSize {}/{} avail:{}, used:{}",
                credentials.url,
                credentials.username,
                poolSize,
                this.clientPoolSize,
                avail,
                used);
        return service;
    }

    @Override
    public boolean validate(ApiClientCredentials credentials) {
        LOG.debug("validate: {}", credentials );
        AaaApi api = new AaaApi(credentials,createApiClient(credentials));
        if (!UcsUtils.validate(credentials)) {
            return false;
        }
        boolean valid;
        try {
            api.login();
            valid = api.isValid();
            LOG.info("validate: {}, valid = {}", credentials, valid);
            api.logout();
        } catch (ApiException e) {
            return false;
        }
        return valid;
    }
}
