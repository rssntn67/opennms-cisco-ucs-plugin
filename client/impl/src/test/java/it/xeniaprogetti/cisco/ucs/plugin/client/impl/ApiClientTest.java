package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.ConfigApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.network.NetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigFindDnsByClassIdResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponse;
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
    public void canSerializeAaaLoginToXml() {
        String xml = "<aaaLogin inName=\"pippo\" inPassword=\"pluto\"/>";
        Assert.assertEquals(xml,UcsXmlApiRequest.getLoginRequest("pippo","pluto"));
    }

    @Test
    public void canSerializeConfigFindDnsByClassIdToXml() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String xml="<configFindDnsByClassId cookie=\"1713476816/da9ab72a-49e4-49ed-9a5a-c0e951d00b2f\" " +
                "response=\"yes\" classId=\"computeItem\"> " +
                "<outDns> " +
                "<dn value=\"sys/chassis-3/blade-3\"/>" +
                "<dn value=\"sys/chassis-4/blade-2\"/> " +
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
        Assert.assertNotNull(response.dns);
        LOG.info(response.toString());
        Assert.assertEquals(14, response.dns.size());
        LOG.info(xml);
        LOG.info(mapper.writeValueAsString(response));
    }

    @Test
    public void canDeSerializeXmlToEquipmentChassisBase() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String xml =
                "<equipmentChassis ackProgressIndicator=\"ack-not-in-progress\" adminState=\"acknowledged\" assetTag=\"\" assignedToDn=\"\" " +
                "association=\"none\" availability=\"unavailable\" configState=\"ok\" connPath=\"A,B\" connStatus=\"A,B\" discovery=\"undiscovered\" " +
                "discoveryStatus=\"\" dn=\"sys/chassis-3\" fabricEpDn=\"fabric/server/chassis-3\" fanSpeedConfigState=\"Balanced\" " +
                "fltAggr=\"1407379178520579\" fsmDescr=\"\" fsmFlags=\"\" fsmPrev=\"PowerCapSuccess\" fsmProgr=\"100\" " +
                "fsmRmtInvErrCode=\"none\" fsmRmtInvErrDescr=\"\" fsmRmtInvRslt=\"\" fsmStageDescr=\"\" fsmStamp=\"2024-04-19T00:26:16.095\" " +
                "fsmStatus=\"nop\" fsmTry=\"0\" id=\"3\" lcTs=\"1970-01-01T01:00:00.000\" licGP=\"0\" licState=\"license-ok\" " +
                "managingInst=\"A\" mfgTime=\"not-applicable\" model=\"UCSB-5108-AC2\" operQualifier=\"\" operQualifierReason=\"N/A\" " +
                "operState=\"operable\" operability=\"operable\" partNumber=\"68-5091-02\" power=\"ok\" presence=\"unknown\" " +
                "revision=\"0\" seepromOperState=\"operable\" serial=\"CH42\" serviceState=\"in-service\" thermal=\"ok\" " +
                "thermalStateQualifier=\"\" usrLbl=\"\" vendor=\"Cisco Systems Inc\" versionHolder=\"yes\" vid=\"\"/> "
                ;
        EquipmentChassis response = mapper.readValue(xml, EquipmentChassis.class);
        LOG.info(response.toString());
        Assert.assertNotNull(response.model);
    }

    @Test
    public void canDeSerializeXmlToEquipmentChassis() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String xml = "<configResolveDn dn=\"sys/chassis-3\" cookie=\"1713476816/da9ab72a-49e4-49ed-9a5a-c0e951d00b2f\" response=\"yes\"> " +
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
        ConfigResolveDnResponse<EquipmentChassis> response =
                mapper.readValue(xml, new TypeReference<ConfigResolveDnResponse<EquipmentChassis>>() {});
        LOG.info(response.toString());
        Assert.assertNotNull(response.outconfig.ucsElement.model);
        Assert.assertEquals(response.dn, response.outconfig.ucsElement.dn);
    }

    @Test
    public void canDeSerializeXmlToComputeBlade() throws JsonProcessingException {

        String xml =" <configResolveDn dn=\"sys/chassis-3/blade-3\" cookie=\"1713990581/4161b9d8-463e-4f7e-8810-141c75521867\" response=\"yes\"> " +
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

        XmlMapper mapper = new XmlMapper();
        ConfigResolveDnResponse<ComputeBlade> response = mapper.readValue(xml, mapper.getTypeFactory().constructParametricType(ConfigResolveDnResponse.class, ComputeBlade.class));
        Assert.assertNotNull(response.outconfig.ucsElement.model);
        Assert.assertEquals(response.dn, response.outconfig.ucsElement.dn);

    }

    @Test
    public void testAaaLoginApi() {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
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
        AaaApi loginApi = new AaaApi(credentials,apiClient);
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
        AaaApi loginApi = new AaaApi(credentials,apiClient);
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
    public void testConfigApiResolveClassNetworkElement() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        String token = loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<NetworkElement> elements = configApi.getUcsElementsByClassId(token,NetworkElement.class);
        Assert.assertFalse(elements.isEmpty());
        loginApi.logout(token);
    }

    @Test
    public void testConfigApiResolveClassEquipmentFex() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        String token = loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<EquipmentFex> elements = configApi.getUcsElementsByClassId(token,EquipmentFex.class);
        Assert.assertFalse(elements.isEmpty());
        loginApi.logout(token);
    }

    @Test
    public void testConfigApiResolveClassEquipmentChassis() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        String token = loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<EquipmentChassis> elements = configApi.getUcsElementsByClassId(token,EquipmentChassis.class);
        Assert.assertFalse(elements.isEmpty());
        loginApi.logout(token);
    }

    @Test
    public void testConfigApiResolveClassEquipmentRackEnclosure() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        String token = loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<EquipmentRackEnclosure> elements = configApi.getUcsElementsByClassId(token,EquipmentRackEnclosure.class);
        Assert.assertFalse(elements.isEmpty());
        loginApi.logout(token);
    }

    @Test
    public void testConfigApiResolveClassComputeBlade() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        String token = loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<ComputeBlade> elements = configApi.getUcsElementsByClassId(token,ComputeBlade.class);
        Assert.assertFalse(elements.isEmpty());
        loginApi.logout(token);
    }

    @Test
    public void testConfigApiResolveClassComputeRackUnit() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        String token = loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<ComputeRackUnit> elements = configApi.getUcsElementsByClassId(token, ComputeRackUnit.class);
        Assert.assertFalse(elements.isEmpty());
        loginApi.logout(token);
    }


    @Test
    public void testApiClientApiEquipment() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        String token = loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        List<String> dns = api.getDnByClassId(token, ConfigApi.ClassItem.equipmentItem);
        for (String dn : dns) {
            LOG.info("equipmentItem: {}",dn);
        }
        loginApi.logout(token);
    }

    @Test
    public void testApiClientCompute() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        String token = loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        List<String> dns = api.getDnByClassId(token, ConfigApi.ClassItem.computeItem);
        for (String dn : dns) {
            LOG.info("computeItem: {}",dn);
        }
        loginApi.logout(token);
    }

    @Test
    public void testApiClientNetwork() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        String token = loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        List<String> dns = api.getDnByClassId(token, ConfigApi.ClassItem.networkItem);
        for (String dn : dns) {
            LOG.info("networkItem: {}",dn);
        }
        loginApi.logout(token);
    }

}