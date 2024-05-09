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

import java.time.LocalDateTime;
import java.util.Objects;

public class AaaApi {

    private final Logger LOG = LoggerFactory.getLogger(AaaApi.class);
    private final ApiClient client;
    private final String username;
    private final String password;
    private String token;
    private LocalDateTime validityTime = LocalDateTime.now();

    public AaaApi(ApiClientCredentials credentials, ApiClient client) {
        Objects.requireNonNull(credentials);
        this.username = credentials.username;
        this.password = Objects.requireNonNull(credentials.password);
        this.client = Objects.requireNonNull(client);
    }

    public void keepAlive() throws ApiException {
        LOG.info("keepAlive: {} to {}", this.username, this.client.getUrl());
        client.doPost(UcsXmlApiRequest.getKeepAliveRequest(this.token));
    }

    public void login() throws ApiException {
        LOG.info("login: {} to {}", this.username, this.client.getUrl());
        AaaLoginResponse response =
             client.getUcsXmlApiResponse
                (UcsXmlApiRequest.getLoginRequest(this.username,this.password)
                    ,AaaLoginResponse.class
                );
        this.token = response.outCookie;
        this.validityTime = LocalDateTime.now().plusSeconds(response.outRefreshPeriod);
        LOG.info("login: {} valid until {}", this.token, this.validityTime);
        LOG.debug("login: {}", response);
    }

    public void refresh() throws ApiException {
            LOG.info("refresh: {} to {}", this.username, this.client.getUrl());
            AaaRefreshResponse response =
                    client.getUcsXmlApiResponse
                    (UcsXmlApiRequest.getRefreshRequest(this.username,this.password, token)
                            , AaaRefreshResponse.class
                    );
            this.token = response.outCookie;
            this.validityTime = LocalDateTime.now().plusSeconds(response.outRefreshPeriod);
            LOG.debug("refresh: {}", response);
    }

    public void logout() throws ApiException {
        LOG.info("logout: {} from {}", this.username, this.client.getUrl());
        AaaLogoutResponse response = client.getUcsXmlApiResponse
                    (UcsXmlApiRequest.getLogoutRequest(token),
                    AaaLogoutResponse.class
                );
        this.token = null;
        LOG.debug("logout: {}", response);
    }

    public boolean isValid() {
        return validityTime.isAfter(LocalDateTime.now());
    }

    public boolean isValidTokenAtLeastFor(long secondsFromNow) {
        return validityTime.isAfter(LocalDateTime.now().plusSeconds(secondsFromNow));
    }

    public String getToken() {
        return this.token;
    }

    public LocalDateTime getValidityTime() {
        return this.validityTime;
    }
}
