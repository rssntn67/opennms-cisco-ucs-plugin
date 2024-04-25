package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaLoginApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.ConfigFindDnsByClassIdApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.ConfigResolveDnApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ApiClientTest {

    private final Logger LOG = LoggerFactory.getLogger(ApiClientTest.class);

    private ApiClientCredentials getCredentials() {
        return ApiClientCredentials.builder()
                .withUrl("https://10.172.192.15/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .build();
    }
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
        String xml="<configFindDnsByClassId cookie=\"1713476816/da9ab72a-49e4-49ed-9a5a-c0e951d00b2f\" " +
                "response=\"yes\" classId=\"computeItem\"> " +
                "<outDns> " +
                "<dn value=\"sys/chassis-3/blade-3\"/>" +
                " <dn value=\"sys/chassis-4/blade-2\"/> " +
                "<dn value=\"sys/chassis-3/blade-2\"/> " +
                "<dn value=\"sys/chassis-4/blade-1\"/> " +
                "<dn value=\"sys/chassis-3/blade-1\"/> " +
                "<dn value=\"sys/rack-unit-9\"/> " +
                "<dn value=\"sys/rack-unit-8\"/> " +
                "<dn value=\"sys/rack-unit-7\"/>" +
                " <dn value=\"sys/rack-unit-6\"/> " +
                "<dn value=\"sys/rack-unit-5\"/> " +
                "<dn value=\"sys/rack-unit-4\"/> " +
                "<dn value=\"sys/rack-unit-3\"/> " +
                "<dn value=\"sys/rack-unit-2\"/> " +
                "<dn value=\"sys/rack-unit-1\"/> " +
                "</outDns> " +
                "</configFindDnsByClassId>";
        ConfigFindDnsByClassIdResponse response = mapper.readValue(xml, ConfigFindDnsByClassIdResponse.class);
        Assert.assertNotNull(response.outDns);
        LOG.debug(response.toString());
        Assert.assertEquals(14, response.outDns.size());
        LOG.debug(xml);
        LOG.debug(mapper.writeValueAsString(response));
    }

    @Test
    public void canSerializeConfigResolveDnToXml() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String xml="<configResolveDn dn=\"sys/chassis-3\" cookie=\"1713476816/da9ab72a-49e4-49ed-9a5a-c0e951d00b2f\" response=\"yes\"> " +
                "<outConfig> " +
                "<equipmentChassis ackProgressIndicator=\"ack-not-in-progress\" adminState=\"acknowledged\" assetTag=\"\" assignedToDn=\"\" " +
                "association=\"none\" availability=\"unavailable\" configState=\"ok\" connPath=\"A,B\" connStatus=\"A,B\" discovery=\"undiscovered\" " +
                "discoveryStatus=\"\" dn=\"sys/chassis-3\" fabricEpDn=\"fabric/server/chassis-3\" fanSpeedConfigState=\"Balanced\" " +
                "fltAggr=\"1407379178520579\" fsmDescr=\"\" fsmFlags=\"\" fsmPrev=\"PowerCapSuccess\" fsmProgr=\"100\" " +
                "fsmRmtInvErrCode=\"none\" fsmRmtInvErrDescr=\"\" fsmRmtInvRslt=\"\" fsmStageDescr=\"\" fsmStamp=\"2024-04-19T00:26:16.095\" " +
                "fsmStatus=\"nop\" fsmTry=\"0\" id=\"3\" lcTs=\"1970-01-01T01:00:00.000\" licGP=\"0\" licState=\"license-ok\" " +
                "managingInst=\"A\" mfgTime=\"not-applicable\" model=\"UCSB-5108-AC2\" operQualifier=\"\" operQualifierReason=\"N/A\" " +
                "operState=\"operable\" operability=\"operable\" partNumber=\"68-5091-02\" power=\"ok\" presence=\"unknown\" " +
                "revision=\"0\" seepromOperState=\"operable\" serial=\"CH42\" serviceState=\"in-service\" thermal=\"ok\" " +
                "thermalStateQualifier=\"\" usrLbl=\"\" vendor=\"Cisco Systems Inc\" versionHolder=\"yes\" vid=\"\"/> " +
                "</outConfig> " +
                "</configResolveDn>";
        ConfigResolveDnResponse response = mapper.readValue(xml, ConfigResolveDnResponse.class);
        Assert.assertNotNull(response.outConfig.equipmentChassis.model);
        Assert.assertEquals(response.dn, response.outConfig.equipmentChassis.dn);
        Assert.assertNull(response.outConfig.computeBlade);

         xml =" <configResolveDn dn=\"sys/chassis-3/blade-3\" cookie=\"1713990581/4161b9d8-463e-4f7e-8810-141c75521867\" response=\"yes\"> " +
                "<outConfig> " +
                "<computeBlade adminPower=\"policy\" adminState=\"in-service\" assetTag=\"\" assignedToDn=\"\" " +
                "association=\"none\" availability=\"unavailable\" availableMemory=\"49152\" chassisId=\"3\"" +
                " checkPoint=\"deep-checkpoint\" connPath=\"A,B\" connStatus=\"A,B\" descr=\"\" discovery=\"failed\" " +
                "discoveryStatus=\"\" dn=\"sys/chassis-3/blade-3\" fltAggr=\"281479271677953\" " +
                "fsmDescr=\"blade discovery 3/3(FSM:sam:dme:ComputeBladeDiscover)\" fsmFlags=\"\" fsmPrev=\"DiscoverFail\" " +
                "fsmProgr=\"13\" fsmRmtInvErrCode=\"none\" fsmRmtInvErrDescr=\"FSM Retries Exhausted\" " +
                "fsmRmtInvRslt=\"end-point-unavailable\" " +
                "fsmStageDescr=\"Waiting for power allocation to server 3/3(FSM-STAGE:sam:dme:ComputeBladeDiscover:PowerDeployWait)\" " +
                "fsmStamp=\"2024-04-24T22:24:45.775\" fsmStatus=\"DiscoverFail\" fsmTry=\"20\" intId=\"73584\" " +
                "kmipFault=\"no\" kmipFaultDescription=\"\" lc=\"undiscovered\" " +
                "lcTs=\"1970-01-01T01:00:00.000\" localId=\"\" lowVoltageMemory=\"not-applicable\" managingInst=\"A\" " +
                "memorySpeed=\"not-applicable\" mfgTime=\"not-applicable\" model=\"UCSB-B480-M5\" name=\"\" " +
                "numOf40GAdaptorsWithOldFw=\"0\" numOf40GAdaptorsWithUnknownFw=\"0\" numOfAdaptors=\"2\" numOfCores=\"0\" " +
                "numOfCoresEnabled=\"0\" numOfCpus=\"4\" numOfEthHostIfs=\"0\" numOfFcHostIfs=\"0\" numOfThreads=\"0\" " +
                "operPower=\"off\" operPwrTransSrc=\"unknown\" operQualifier=\"\" operQualifierReason=\"N/A\" " +
                "operState=\"discovery-failed\" operability=\"operable\" originalUuid=\"00000000-0000-0000-0000-000000000000\" " +
                "partNumber=\"\" policyLevel=\"0\" policyOwner=\"local\" presence=\"equipped\" revision=\"0\" " +
                "scaledMode=\"none\" serial=\"SRV125\" serverId=\"3/3\" slotId=\"3\" storageOperQualifier=\"unknown\" " +
                "totalMemory=\"49152\" usrLbl=\"\" uuid=\"00000000-0000-0000-0000-000000000000\" " +
                "vendor=\"Cisco Systems Inc\" vid=\"\"/> " +
                "</outConfig> " +
                "</configResolveDn>";

        response = mapper.readValue(xml, ConfigResolveDnResponse.class);
        Assert.assertNotNull(response.outConfig.computeBlade.serial);
        Assert.assertEquals(response.dn, response.outConfig.computeBlade.dn);
        Assert.assertNull(response.outConfig.equipmentChassis);

    }

    @Test
    public void testAaaLoginApi() {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
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
        ApiClient apiClient = new ApiClient(credentials.url);
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

        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
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

    @Test
    public void testApiClientConfigResolveClass() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaLoginApi loginApi = new AaaLoginApi(credentials,client);
        String token = loginApi.login();
        ConfigResolveClassRequest request = new ConfigResolveClassRequest(ConfigResolveClassRequest.ClassId.networkElement,token);
        System.out.println(client.doPost(request.getRequest()));
        loginApi.logout(token);
    }

    @Test
    public void testApiClientConfigResolveChildren() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaLoginApi loginApi = new AaaLoginApi(credentials,client);
        String token = loginApi.login();
        ConfigResolveChildrenRequest request =
                new ConfigResolveChildrenRequest(ConfigResolveClassRequest.ClassId.equipmentChassis,"sys",token);
        System.out.println(client.doPost(request.getRequest()));
        loginApi.logout(token);
    }

    @Test
    public void testApiClientApiEquipment() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaLoginApi loginApi = new AaaLoginApi(credentials,apiClient);
        String token = loginApi.login();
        ConfigFindDnsByClassIdApi api = new ConfigFindDnsByClassIdApi(apiClient);
        List<String> equipments = api.getDnByClassId(token, ConfigFindDnsByClassIdApi.Item.equipmentItem);
        final ConfigResolveDnApi dnApi = new ConfigResolveDnApi(apiClient);
        for (String dn : equipments) {
            LOG.info("equipment: {}: {}",dn, dnApi.getByDn(token, dn, false));
        }
        loginApi.logout(token);
    }

    @Test
    public void testApiClientCompute() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaLoginApi loginApi = new AaaLoginApi(credentials,apiClient);
        String token = loginApi.login();
        ConfigFindDnsByClassIdApi api = new ConfigFindDnsByClassIdApi(apiClient);
        List<String> computes = api.getDnByClassId(token, ConfigFindDnsByClassIdApi.Item.computeItem);
        final ConfigResolveDnApi dnApi = new ConfigResolveDnApi(apiClient);
        for (String dn : computes) {
            LOG.info("compute: {}: {}",dn, dnApi.getByDn(token, dn, false));
        }
        loginApi.logout(token);
    }

}