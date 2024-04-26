package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
    private final XmlMapper mapper = new XmlMapper();

    public AaaApi(ApiClientCredentials credentials, ApiClient client) {
        Objects.requireNonNull(credentials);
        this.username = credentials.username;
        this.password = Objects.requireNonNull(credentials.password);
        this.client = Objects.requireNonNull(client);
    }

    public String login() throws ApiException {
        try {
            AaaLoginResponse response =
                mapper.readValue(
                        client.doPost(UcsXmlApiRequest.getLoginRequest(this.username,this.password))
                        , AaaLoginResponse.class
                );
            if (response.errorCode > 0) {
                LOG.error("login failed: with error code: {}, {}", response.errorCode, response);
                throw new ApiException(
                        "login: server responded with error: " + response.errorCode
                        ,new RuntimeException("login error code: " + response.errorCode)
                        , response.errorCode
                        , response.toString());
            }
            return response.outCookie;
        } catch (JsonProcessingException e) {
            LOG.error("login: {}", e.getMessage(), e);
            throw new ApiException("login: " +e.getMessage(),e);
        }
    }

    public String refresh(String token) throws ApiException {
        try {
            AaaRefreshResponse response =
                mapper.readValue
                        (
                            client.doPost(UcsXmlApiRequest.getRefreshRequest(this.username,this.password, token)),
                            AaaRefreshResponse.class
                        );
            if (response.errorCode > 0) {
                LOG.error("refresh failed: with error code: {}, {}", response.errorCode, response);
                throw new ApiException(
                        "refresh: server responded with error: {}" + response.errorCode
                        ,new RuntimeException("refresh error code: " + response.errorCode)
                        , response.errorCode
                        , response.toString());
            }
            return response.outCookie;
        } catch (JsonProcessingException e) {
            LOG.error("refresh: error {}", e.getMessage(),e);
            throw new ApiException("refresh: " +e.getMessage(),e);
        }
    }

    public void logout(String token) throws ApiException {
        try {
            AaaLogoutResponse response =
                mapper.readValue(
                    client.doPost(UcsXmlApiRequest.getLogoutRequest(token)),
                    AaaLogoutResponse.class
                );
            if (response.errorCode > 0) {
                LOG.error("logout failed: with error code: {}, {}", response.errorCode, response);
                throw new ApiException(
                        "logout: server responded with error: {}" + response.errorCode
                        ,new RuntimeException("login error code: " + response.errorCode)
                        ,200
                        , response.toString());
            }

        } catch (JsonProcessingException e) {
            LOG.error("logout: error {}", e.getMessage(),e);
            throw new ApiException("logout: " +e.getMessage(),e);
        }
    }

}
