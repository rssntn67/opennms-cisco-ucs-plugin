package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientProvider;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class XmlApiClientProvider implements ApiClientProvider {

    private static final Logger LOG = LoggerFactory.getLogger(XmlApiClientProvider.class);
    private final Map<ApiClientCredentials, Map<Integer, XmlApiClientService>> serviceAvailableMap = new HashMap<>();
    private final Map<ApiClientCredentials, Map<Integer, XmlApiClientService>> serviceUsedMap = new HashMap<>();
    private final int clientPoolSize;

    public XmlApiClientProvider(int clientPoolSize) {
        this.clientPoolSize = clientPoolSize;
    }

    protected static ApiClient createApiClient(ApiClientCredentials apiClientCredentials) {
        ApiClient client = new ApiClient(apiClientCredentials.url);
        if (apiClientCredentials.ignoreSslCertificateValidation)
            client.setTrustAllCertsClient();
        return client;
    }

    public synchronized void release(XmlApiClientService service) {
        serviceUsedMap.get(service.getCredentials()).remove(service.getPool());
        serviceAvailableMap.get(service.getCredentials()).put(service.getPool(), service);
        int avail = serviceUsedMap.get(service.getCredentials()).size();
        int used = serviceAvailableMap.get(service.getCredentials()).size();
        int poolSize = avail+used;
        LOG.info("release:pool[{}], url/user {}/{}, poolSize/maxPoolSize {}/{} avail:{}, used:{}",
                    service.getPool(),
                    service.getCredentials().url,
                    service.getCredentials().username,
                    poolSize,
                    this.clientPoolSize,
                    serviceAvailableMap.get(service.getCredentials()).size(),
                    serviceUsedMap.get(service.getCredentials()).size());
    }

    @Override
    public synchronized XmlApiClientService client(ApiClientCredentials credentials) throws ApiException {
        if (!serviceAvailableMap.containsKey(credentials)) {
            LOG.debug("client: url/user:{}/{}. Init Client!",
                    credentials.url,
                    credentials.username);
            serviceAvailableMap.put(credentials, new HashMap<>());
            serviceUsedMap.put(credentials, new HashMap<>());
        }
        int avail = serviceAvailableMap.get(credentials).size();
        int used = serviceUsedMap.get(credentials).size();
        int poolSize = avail + used;
        if (serviceAvailableMap.get(credentials).isEmpty() && poolSize == clientPoolSize) {
            LOG.warn("client: pool[{}], url/user:{}/{} poolSize/maxPoolSize:{}/{}, avail:{}, used:{} -> skip: no space left on pool",
                    poolSize,
                    credentials.url,
                    credentials.username,
                    poolSize,
                    this.clientPoolSize,
                    avail,
                    used
            );
            throw new ApiException("no api client connection available", new RuntimeException(
                    "Maximum pool size reached, no available connections!"));
        }
        XmlApiClientService service;
        if (serviceAvailableMap.get(credentials).isEmpty()) {
            int poolId = poolSize;
            poolSize++;
            LOG.debug("client:pool[{}], url/user:{}/{}, creating a new client!",
                    poolId,
                    credentials.url,
                    credentials.username);
            service = new XmlApiClientService(credentials, this, poolId);
        } else {
            service = serviceAvailableMap.get(credentials).values().iterator().next();
            serviceAvailableMap.get(credentials).remove(service.getPool());
            avail--;
            LOG.debug("client:pool[{}] get from pool, url/user {}/{}",
                    service.getPool(),
                    credentials.url,
                    credentials.username);
        }
        serviceUsedMap.get(credentials).put(service.getPool(), service);
        used++;
        LOG.info("client:pool[{}], url/user {}/{}, poolSize/maxPoolSize {}/{} avail:{}, used:{}",
                service.getPool(),
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

    public int getAvail(ApiClientCredentials credentials) {
        return serviceAvailableMap.get(credentials).size();
    }

    public int getUsed(ApiClientCredentials credentials) {
        return serviceUsedMap.get(credentials).size();
    }

    public int getPoolSize(ApiClientCredentials credentials) {
        return getAvail(credentials)+getUsed(credentials);
    }

}
