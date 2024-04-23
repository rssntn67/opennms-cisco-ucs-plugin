package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.AaaLoginRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.AaaLoginResponse;

import java.util.Objects;

public class AaaLoginApi {

    private final ApiClient client = new ApiClient();
    private final AaaLoginRequest request;
    private final String url;
    private final XmlMapper mapper = new XmlMapper();

    public AaaLoginApi(ApiClientCredentials credentials) {
        Objects.requireNonNull(credentials);
        this.request = new AaaLoginRequest();
        this.request.setInName(Objects.requireNonNull(credentials.username));
        this.request.setInPassword( Objects.requireNonNull(credentials.password));
        this.url = Objects.requireNonNull(credentials.url);
        if (credentials.ignoreSslCertificateValidation) {
            client.setTrustAllCertsClient();
        }
    }

    public AaaLoginResponse getResponse() throws ApiException {
        try {
            return mapper.readValue(client.doPost(this.url, mapper.writeValueAsString(this.request)), AaaLoginResponse.class);
        } catch (JsonProcessingException e) {
            throw new ApiException("getResponse: " +e.getMessage(),e);
        }
    }

    public ApiClient getClient() {
        return this.client;
    }

    public XmlMapper getMapper() {
        return this.mapper;
    }
    
    public String getUrl() {
        return this.url;
    }


}
