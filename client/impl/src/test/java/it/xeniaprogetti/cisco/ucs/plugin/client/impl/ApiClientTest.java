package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaLoginApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.AaaLoginRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ConfigFindDnsByClassIdResponse;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiClientTest {

    private final Logger LOG = LoggerFactory.getLogger(ApiClientTest.class);
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
    public void canSerializeConfigFindDnsByClassIdToXml() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String xml="<configFindDnsByClassId cookie=\"1713476816/da9ab72a-49e4-49ed-9a5a-c0e951d00b2f\" response=\"yes\" classId=\"computeItem\"> <outDns> <dn value=\"sys/chassis-3/blade-3\"/> <dn value=\"sys/chassis-4/blade-2\"/> <dn value=\"sys/chassis-3/blade-2\"/> <dn value=\"sys/chassis-4/blade-1\"/> <dn value=\"sys/chassis-3/blade-1\"/> <dn value=\"sys/rack-unit-9\"/> <dn value=\"sys/rack-unit-8\"/> <dn value=\"sys/rack-unit-7\"/> <dn value=\"sys/rack-unit-6\"/> <dn value=\"sys/rack-unit-5\"/> <dn value=\"sys/rack-unit-4\"/> <dn value=\"sys/rack-unit-3\"/> <dn value=\"sys/rack-unit-2\"/> <dn value=\"sys/rack-unit-1\"/> </outDns> </configFindDnsByClassId>";
        LOG.debug(xml);
        ConfigFindDnsByClassIdResponse response = mapper.readValue(xml, ConfigFindDnsByClassIdResponse.class);
        Assert.assertNotNull(response.outDns);
        LOG.debug(response.toString());
        Assert.assertEquals(14, response.outDns.size());
    }

    @Test
    public void testAaaLoginApi() {
        ApiClientCredentials credentials = ApiClientCredentials.builder()
                .withUrl("https://10.172.192.15/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .build();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaLoginApi loginApi = new AaaLoginApi(credentials,apiClient);
        String aaaLoginResponse = null;
        try {
            aaaLoginResponse = loginApi.login();
        } catch (ApiException e) {
            Assert.fail();
        }
        LOG.info("login cookie: {}" ,aaaLoginResponse);
        String aaaRefreshResponse = null;
        try {
            aaaRefreshResponse = loginApi.refresh(aaaLoginResponse);
        } catch (ApiException e) {
            Assert.fail();
        }
        LOG.info("refresh cookie: {}",  aaaRefreshResponse);
        try {
            loginApi.logout(aaaRefreshResponse);
        } catch (ApiException e) {
            Assert.fail();
        }

    }

    @Test
    public void testAaaLoginApiFail() {
        ApiClientCredentials credentials = ApiClientCredentials.builder()
                .withUrl("https://10.172.192.155/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .build();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaLoginApi loginApi = new AaaLoginApi(credentials,apiClient);
        try {
            loginApi.login();
            Assert.fail();
        } catch (ApiException e) {
            LOG.debug("code: {}", e.getCode());
            LOG.debug("errCode: {}", e.getErrCode());
            LOG.debug("message: {}", e.getMessage());
            Assert.assertEquals(0,e.getErrCode());
            Assert.assertEquals(0,e.getCode());
        }
    }

    @Test
    public void testApiClientLoginApiWithErrorCode()  {

        ApiClientCredentials credentials = ApiClientCredentials.builder()
                .withUrl("https://10.172.192.15/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .build();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaLoginApi loginApi = new AaaLoginApi(credentials,apiClient);
        String token = null;
        try {
            token = loginApi.login();
            Assert.assertNotNull(token);
            Assert.assertEquals(47,token.length());
        } catch (ApiException e) {
            Assert.fail();
        }
        String wrongToken = token.replace("0","1");
        Assert.assertNotEquals(token,wrongToken);
        try {
            loginApi.refresh(wrongToken);
            Assert.fail();
        } catch (ApiException e) {
            Assert.assertEquals(200, e.getCode());
            Assert.assertEquals(552, e.getErrCode());
        }

        try {
            loginApi.logout(wrongToken);
            Assert.fail();
        } catch (ApiException e) {
            Assert.assertEquals(200, e.getCode());
            Assert.assertEquals(555, e.getErrCode());
        }
        try {
            loginApi.logout(token);
        } catch (ApiException e) {
            Assert.fail();
        }

    }


}
