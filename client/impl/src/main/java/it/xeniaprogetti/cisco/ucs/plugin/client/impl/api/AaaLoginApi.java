package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AaaLoginApi {

    private final Logger LOG = LoggerFactory.getLogger(AaaLoginApi.class);
    private final ApiClient client;
    private final String url;
    private final String username;
    private final String password;
    private final XmlMapper mapper = new XmlMapper();

    public AaaLoginApi(ApiClientCredentials credentials, ApiClient client) {
        Objects.requireNonNull(credentials);
        this.username = credentials.username;
        this.password = Objects.requireNonNull(credentials.password);
        this.url = Objects.requireNonNull(credentials.url);
        this.client = Objects.requireNonNull(client);
    }

    public AaaLoginResponse login() throws ApiException {
        try {
            return mapper.readValue(client.doPost(this.url, mapper.writeValueAsString(new AaaLoginRequest(this.username,this.password))), AaaLoginResponse.class);
        } catch (JsonProcessingException e) {
            LOG.error("login: error {}", e.getMessage(), e);
            throw new ApiException("login: " +e.getMessage(),e);
        }
    }

    public AaaRefreshResponse refresh(String token) throws ApiException {
        try {
            return mapper.readValue(client.doPost(this.url, mapper.writeValueAsString(new AaaRefreshRequest(this.username,this.password, token))), AaaRefreshResponse.class);
        } catch (JsonProcessingException e) {
            LOG.error("refresh: error {}", e.getMessage(),e);
            throw new ApiException("refresh: " +e.getMessage(),e);
        }
    }

    public AaaLogoutResponse logout(String token) throws ApiException {
        try {
            return mapper.readValue(client.doPost(this.url, mapper.writeValueAsString(new AaaLogoutRequest(token))), AaaLogoutResponse.class);
        } catch (JsonProcessingException e) {
            LOG.error("logout: error {}", e.getMessage(),e);
            throw new ApiException("logout: " +e.getMessage(),e);
        }
    }

}
