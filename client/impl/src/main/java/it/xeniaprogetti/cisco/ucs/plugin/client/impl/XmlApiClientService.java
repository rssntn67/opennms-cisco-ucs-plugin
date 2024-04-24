package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;

import java.util.List;

public class XmlApiClientService implements ApiClientService {

    private final ApiClient client;
    private final ApiClientCredentials credentials;

    private ApiClient getClient(ApiClientCredentials credentials) {
        ApiClient apiClient = new ApiClient(credentials.url);
        if (credentials.ignoreSslCertificateValidation) {
            apiClient.setTrustAllCertsClient();
        }
        return apiClient;
    }

    public XmlApiClientService(ApiClientCredentials credentials) {
        this.client = getClient(credentials);
        this.credentials = credentials;
    }

    public boolean isValidToken() {
        return false;
    }

    @Override
    public List<String> getComputeItems() {
        return List.of();
    }

    @Override
    public Object resolveDn(String dn) {
        return null;
    }
}
