package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientProvider;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
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
    private static final Map<ApiClientCredentials, List<ApiClient>> serviceAvailableMap = new HashMap<>();
    private static final Map<ApiClientCredentials, List<ApiClient>> serviceUsedMap = new HashMap<>();
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

    public boolean release(ApiClient apiClient, ApiClientCredentials credentials){
        serviceAvailableMap.get(credentials).add(apiClient);
        return serviceUsedMap.get(credentials).remove(apiClient);
    }

    public ApiClient getApiClient(ApiClientCredentials credentials) throws ApiException {
        if (!serviceAvailableMap.containsKey(credentials)) {
            LOG.debug("getApiClient: no client found for {}", credentials);
            serviceAvailableMap.put(credentials, new ArrayList<>());
            serviceUsedMap.put(credentials, new ArrayList<>());
        }
        if (serviceAvailableMap.get(credentials).isEmpty() && serviceUsedMap.get(credentials).size() < clientPoolSize) {
            LOG.debug("getApiClient: creating client for {}", credentials);
            LOG.debug("getApiClient: {} api client connection used for {}",serviceUsedMap.get(credentials).size(), credentials);
            ApiClient client = createApiClient(credentials);
            serviceUsedMap.get(credentials).add(client);
            return client;
        }
        if (serviceAvailableMap.isEmpty()) {
            LOG.error("getApiClient: no api client connection available");
            LOG.debug("getApiClient: {} api client connection used for {}",serviceUsedMap.get(credentials).size(), credentials);
            throw new ApiException("no api client connection available", new RuntimeException(
                    "Maximum pool size reached, no available connections!"));
        }
        int size = serviceAvailableMap.get(credentials).size();
        LOG.debug("getApiClient: {} api client connection available for {}", size, credentials);
        LOG.debug("getApiClient: {} api client connection used for {}",serviceUsedMap.get(credentials).size(), credentials);
        ApiClient client = serviceAvailableMap.get(credentials).remove(size-1);
        serviceUsedMap.get(credentials).add(client);
        return client;
    }


    @Override
    public ApiClientService client(ApiClientCredentials credentials) throws ApiException {
        return new XmlApiClientService(credentials, this);
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
