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
    private static final Map<ApiClientCredentials, List<XmlApiClientService>> serviceAvailableMap = new HashMap<>();
    private static final Map<ApiClientCredentials, List<XmlApiClientService>> serviceUsedMap = new HashMap<>();
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

    public boolean release(XmlApiClientService service) {
        serviceAvailableMap.get(service.getCredentials()).add(service);
        return serviceUsedMap.get(service.getCredentials()).remove(service);
    }


    @Override
    public ApiClientService client(ApiClientCredentials credentials) throws ApiException {
        if (!serviceAvailableMap.containsKey(credentials)) {
            LOG.debug("client: no client found for {}, clientPoolSize: {} ", credentials, this.clientPoolSize);
            serviceAvailableMap.put(credentials, new ArrayList<>());
            serviceUsedMap.put(credentials, new ArrayList<>());
        }
        if (serviceAvailableMap.get(credentials).isEmpty() && serviceUsedMap.get(credentials).size() < clientPoolSize) {
            LOG.debug("client: {}/{} api client connection used for {}, adding a new client to clientPool!", serviceUsedMap.get(credentials).size(), this.clientPoolSize, credentials);
            XmlApiClientService service = new XmlApiClientService(credentials, this);
            serviceUsedMap.get(credentials).add(service);
            return service;
        }
        if (serviceAvailableMap.isEmpty()) {
            LOG.debug("client: {}/{} api client connection used for {}, no room space left on clientPool",serviceUsedMap.get(credentials).size(), this.clientPoolSize, credentials);
            throw new ApiException("no api client connection available", new RuntimeException(
                    "Maximum pool size reached, no available connections!"));
        }
        int size = serviceAvailableMap.get(credentials).size();
        LOG.debug("client: {} available, {} used, over {} api client connection for {}", size, serviceUsedMap.get(credentials).size(), this.clientPoolSize,credentials);
        XmlApiClientService service = serviceAvailableMap.get(credentials).remove(size-1);
        serviceUsedMap.get(credentials).add(service);
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
