package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.AaaLoginResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.AaaLogoutResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.AaaRefreshResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AaaApi {

    private final Logger LOG = LoggerFactory.getLogger(AaaApi.class);
    private final ApiClient client;
    private final String username;
    private final String password;

    public AaaApi(ApiClientCredentials credentials, ApiClient client) {
        Objects.requireNonNull(credentials);
        this.username = credentials.username;
        this.password = Objects.requireNonNull(credentials.password);
        this.client = Objects.requireNonNull(client);
    }

    public String login() throws ApiException {
        LOG.info("login: {} to {}", this.username, this.client.getUrl());
            return client.getUcsXmlApiResponse
                (UcsXmlApiRequest.getLoginRequest(this.username,this.password)
                    ,AaaLoginResponse.class
                ).outCookie;
    }

    public String refresh(String token) throws ApiException {
            LOG.info("refresh: {} to {}", this.username, this.client.getUrl());
            return client.getUcsXmlApiResponse
                    (UcsXmlApiRequest.getRefreshRequest(this.username,this.password, token)
                            , AaaRefreshResponse.class
                    ).outCookie;
    }

    public void logout(String token) throws ApiException {
        LOG.info("logout: {} from {}", this.username, this.client.getUrl());
        client.getUcsXmlApiResponse
                    (UcsXmlApiRequest.getLogoutRequest(token),
                    AaaLogoutResponse.class
                );
    }

}
