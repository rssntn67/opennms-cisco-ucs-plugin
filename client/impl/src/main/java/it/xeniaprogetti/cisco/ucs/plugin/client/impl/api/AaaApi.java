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
    private final String url;
    private String token;
    private final int validity;
    private LocalDateTime validityTime = LocalDateTime.now();

    public AaaApi(ApiClientCredentials credentials, ApiClient client) {
        Objects.requireNonNull(credentials);
        this.url = Objects.requireNonNull(credentials.url);
        this.username = credentials.username;
        this.password = Objects.requireNonNull(credentials.password);
        this.validity = credentials.validity;
        this.client = Objects.requireNonNull(client);
    }

    public void checkSession() throws ApiException {
        if (this.toString() == null) {
            login();
            LOG.debug("checkSession: pool[{}] login!", 0);
        } else if (isValid() && !isValidTokenAtLeastFor(this.validity)) {
            refresh();
            LOG.debug("checkSession: pool[{}] refreshed token: previous token was valid for less then {} seconds", 0, this.validity);
        } else if (!isValid()) {
            LOG.debug("checkSession: pool[{}] logout! token is no more valid", 0);
            try {
                logout();
            } catch (ApiException e) {
                LOG.warn("checkSession: pool[{}] logout error", 0);
            }
            login();
            LOG.debug("checkSession: pool[{}], login!", 0);
        }
        LOG.info("checkSession: pool[{}] token is valid for at least {} seconds", 0, this.validity);
    }

    public void keepAlive() throws ApiException {
        LOG.info("keepAlive: {} to {}", this.username, this.url);
        client.doPost(UcsXmlApiRequest.getKeepAliveRequest(this.token), this.url);
    }

    public void login() throws ApiException {
        LOG.info("login: {} to {}", this.username, this.url);
        AaaLoginResponse response =
             client.getUcsXmlApiResponse
                (UcsXmlApiRequest.getLoginRequest(this.username,this.password),
                        this.url,
                        AaaLoginResponse.class
                );
        LOG.debug("login: {}", response);
        if (response.errorCode > 0) {
            LOG.error("login: {} failed", response);
            throw new ApiException("login: failed", new RuntimeException("AaaLogin failed"), response.errorCode, response.toString());
        }
        this.token = response.outCookie;
        this.validityTime = LocalDateTime.now().plusSeconds(response.outRefreshPeriod);
        LOG.info("login: valid until {}", this.validityTime);
    }

    public void refresh() throws ApiException {
        LOG.info("refresh: {} to {}", this.username, this.url);
        AaaRefreshResponse response =
                client.getUcsXmlApiResponse
                (UcsXmlApiRequest.getRefreshRequest(this.username,this.password, this.token),
                        this.url,
                        AaaRefreshResponse.class
                );
        LOG.debug("refresh: {}", response);
        if (response.errorCode > 0) {
            LOG.error("refresh: {} failed", response);
            throw new ApiException("refresh: failed", new RuntimeException("AaaRefresh failed"), response.errorCode, response.toString());
        }
        this.token = response.outCookie;
        this.validityTime = LocalDateTime.now().plusSeconds(response.outRefreshPeriod);
    }

    public void logout() throws ApiException {
        LOG.info("logout: {} from {}", this.username, this.url);
        AaaLogoutResponse response = client.getUcsXmlApiResponse
                (UcsXmlApiRequest.getLogoutRequest(token),
                    this.url,
                    AaaLogoutResponse.class
                );
        LOG.debug("logout: {}", response);
        if (response.errorCode > 0) {
            LOG.error("logout: {} failed", response);
            throw new ApiException("logout: failed", new RuntimeException("AaaLogout failed"), response.errorCode, response.toString());
        }
        this.token = null;
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

    public ApiClient getClient() {
        return this.client;
    }

    public String getUrl() {
        return this.url;
    }
}
