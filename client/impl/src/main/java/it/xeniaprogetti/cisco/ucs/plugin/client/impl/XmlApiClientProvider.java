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
    private final Map<ApiClientCredentials, AaaApi> credentialLoginMap = new HashMap<>();

    public XmlApiClientProvider() {
    }

    protected static ApiClient createApiClient(ApiClientCredentials apiClientCredentials) {
        ApiClient client = new ApiClient();
        if (apiClientCredentials.ignoreSslCertificateValidation)
            client.setTrustAllCertsClient();
        return client;
    }

    @Override
    public synchronized XmlApiClientService client(ApiClientCredentials credentials) throws ApiException {
        if (!credentialLoginMap.containsKey(credentials)) {
            LOG.debug("client: url/user:{}/{}. Init Client!",
                    credentials.url,
                    credentials.username);
            credentialLoginMap.put(credentials, new AaaApi(credentials, createApiClient(credentials)));
        }
        return new XmlApiClientService(credentialLoginMap.get(credentials));
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
