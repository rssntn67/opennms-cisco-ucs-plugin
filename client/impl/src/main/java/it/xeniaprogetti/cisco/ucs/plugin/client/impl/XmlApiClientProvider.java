package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientProvider;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlApiClientProvider implements ApiClientProvider {

    private static final Logger LOG = LoggerFactory.getLogger(XmlApiClientProvider.class);

    protected static ApiClient getApiClient(ApiClientCredentials apiClientCredentials) {
        ApiClient client = new ApiClient(apiClientCredentials.url);
        if (apiClientCredentials.ignoreSslCertificateValidation)
            client.setTrustAllCertsClient();
        return client;
    }

    @Override
    public ApiClientService client(ApiClientCredentials credentials) {
        return new XmlApiClientService(credentials);
    }

    @Override
    public boolean validate(ApiClientCredentials credentials) {
        AaaApi api = new AaaApi(credentials,getApiClient(credentials));
        try {
            api.login();
            LOG.info("validate: {}, {}", credentials, api.isValidTokenAtLeastFor(0));
            api.logout();
            return api.isValidTokenAtLeastFor(0);
        } catch (ApiException e) {
            return false;
        }
    }
}
