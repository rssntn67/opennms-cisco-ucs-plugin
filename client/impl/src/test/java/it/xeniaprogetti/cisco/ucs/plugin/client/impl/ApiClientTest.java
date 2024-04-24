package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaLoginApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.AaaLoginRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.AaaLoginResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.AaaLogoutResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.AaaRefreshResponse;
import okhttp3.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ApiClientTest {

    /**
     * Verifies that the object is serialized to XML as expected.
     */
    @Test
    public void canSerializeAaaLoginToXml() throws JsonProcessingException {
        String xml = "<aaaLogin inName=\"pippo\" inPassword=\"pluto\"/>";
        XmlMapper mapper = new XmlMapper();
        AaaLoginRequest aaaLogin = new AaaLoginRequest("pippo","pluto");
        Assert.assertEquals(xml,mapper.writeValueAsString(aaaLogin));
    }

    @Test
    public void okHttpPostTestWithXmlMapper()  throws IOException {
        MediaType XML = MediaType.parse("text/xml");
        XmlMapper mapper = new XmlMapper();
        AaaLoginRequest aaaLogin = new AaaLoginRequest("pippo","pluto");

        RequestBody requestBody = RequestBody.create(XML,mapper.writeValueAsString(aaaLogin));

        Request request = new Request.Builder()
                .url("https://10.172.192.15/nuova")
                .addHeader("Accept", "*/*")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", ApiClient.class.getCanonicalName())
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        client = ApiClient.trustAllSslClient(client);
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            if (response.body() != null) {
                System.out.println(response.body().string());
            }
        }
    }

    @Test
    public void testApiClientLogin() throws JsonProcessingException, ApiException {
        XmlMapper mapper = new XmlMapper();
        AaaLoginRequest aaaLogin = new AaaLoginRequest("pippo","pluto");
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        String body = apiClient.doPost("https://10.172.192.15/nuova", mapper.writeValueAsString(aaaLogin));
        System.out.println(body);
        AaaLoginResponse aaaLoginResponse = mapper.readValue(body, AaaLoginResponse.class);

        System.out.println(aaaLoginResponse.outCookie);

    }

    @Test
    public void testAaaLoginApi() throws JsonProcessingException, ApiException {
        ApiClientCredentials credentials = ApiClientCredentials.builder()
                .withUrl("https://10.172.192.15/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .build();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaLoginApi loginApi = new AaaLoginApi(credentials,apiClient);
        AaaLoginResponse aaaLoginResponse = loginApi.login();
        System.out.println("login cookie: "+aaaLoginResponse.outCookie);
        AaaRefreshResponse aaaRefreshResponse = loginApi.refresh(aaaLoginResponse.outCookie);
        System.out.println("refresh cookie: " + aaaRefreshResponse.outCookie);
        AaaLogoutResponse aaaLogoutResponse = loginApi.logout(aaaRefreshResponse.outCookie);
        System.out.println("logout status: " + aaaLogoutResponse.outStatus);

    }

    @Test
    public void testAaaLoginError() throws JsonProcessingException, ApiException {

        XmlMapper mapper = new XmlMapper();
        AaaLoginRequest aaaLogin = new AaaLoginRequest("pippo","pippo");
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        String body = apiClient.doPost("https://10.172.192.15/nuova", mapper.writeValueAsString(aaaLogin));
        System.out.println(body);
        AaaLoginResponse aaaLoginResponse = mapper.readValue(body, AaaLoginResponse.class);
        System.out.println(aaaLoginResponse.outCookie);

    }


}
