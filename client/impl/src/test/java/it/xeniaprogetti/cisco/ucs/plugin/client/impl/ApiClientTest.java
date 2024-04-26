package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.*;
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
        ConfigResolveEquipmentChassisDnResponse response =
                mapper.readValue(xml, ConfigResolveEquipmentChassisDnResponse.class);
        LOG.info(response.toString());
        Assert.assertNotNull(response.outconfig.equipmentChassis.model);
        Assert.assertEquals(response.dn, response.outconfig.equipmentChassis.dn);
    }

    @Test
    public void canDeSerializeXmlToEquipmentFex() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String xml = "<configResolveDn dn=\"sys/fex-2\" cookie=\"1714168516/c91b06a0-2ca4-4094-a1d6-098ee701b21c\" response=\"yes\"> " +
                "<outConfig> <equipmentFex adminPowerState=\"policy\" adminState=\"acknowledged\" configState=\"un-acknowledged\" dn=\"sys/fex-2\" fltAggr=\"0\" fsmDescr=\"\" fsmPrev=\"nop\" fsmProgr=\"100\" fsmRmtInvErrCode=\"none\" fsmRmtInvErrDescr=\"\" fsmRmtInvRslt=\"\" fsmStageDescr=\"\" fsmStamp=\"never\" fsmStatus=\"nop\" fsmTry=\"0\" id=\"2\" licGP=\"0\" licState=\"license-ok\" model=\"N2K-C2232TM-E-10GE\" operQualifier=\"\" operQualifierReason=\"N/A\" operState=\"operable\" operability=\"unknown\" power=\"unknown\" presence=\"unknown\" revision=\"0\" serial=\"FX22\" switchId=\"B\" thermal=\"unknown\" usrLbl=\"\" vendor=\"Cisco Systems\" voltage=\"unknown\"/> " +
                "</outConfig> </configResolveDn>";
        ConfigResolveEquipmentFexDnResponse response =
                mapper.readValue(xml, ConfigResolveEquipmentFexDnResponse.class);
        LOG.info(response.toString());
        Assert.assertNotNull(response.outconfig.equipmentFex.model);
        Assert.assertEquals(response.dn, response.outconfig.equipmentFex.dn);
    }

    @Test
    public void canDeSerializeXmlToEquipmentRackEnclosure() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String xml = "<configResolveDn dn=\"sys/rack-enclosure-1\" cookie=\"1713476816/da9ab72a-49e4-49ed-9a5a-c0e951d00b2f\" response=\"yes\"> " +
                "<outConfig> <equipmentRackEnclosure assetTag=\"\" childAction=\"deleteNonPresent\" dn=\"sys/rack-enclosure-1\" " +
                "fltAggr=\"0\" id=\"1\" mfgTime=\"not-applicable\" model=\"UCSC-C4200-SFF\" operQualifierReason=\"N/A\" " +
                "operability=\"operable\" partNumber=\"\" presence=\"equipped\" revision=\"0\" serial=\"ENCL15\" " +
                "vendor=\"Cisco Systems Inc\" vid=\"\"> <equipmentSlotEp childAction=\"deleteNonPresent\" " +
                "enclosureId=\"1\" fltAggr=\"0\" id=\"4\" model=\"\" operQualifierReason=\"N/A\" operability=\"unknown\" " +
                "presence=\"empty\" refDn=\"\" revision=\"0\" rn=\"slot-ep-4\" serial=\"\" type=\"unknown\" vendor=\"\"/> " +
                "<equipmentSlotEp childAction=\"deleteNonPresent\" enclosureId=\"1\" fltAggr=\"0\" id=\"3\" model=\"\" operQualifierReason=\"N/A\" operability=\"unknown\" presence=\"empty\" refDn=\"\" revision=\"0\" rn=\"slot-ep-3\" serial=\"\" type=\"unknown\" vendor=\"\"/> " +
                "<equipmentSlotEp childAction=\"deleteNonPresent\" enclosureId=\"1\" fltAggr=\"0\" id=\"2\" model=\"\" operQualifierReason=\"N/A\" operability=\"unknown\" presence=\"equipped\" refDn=\"sys/rack-unit-2\" revision=\"0\" rn=\"slot-ep-2\" serial=\"\" type=\"compute\" vendor=\"\"/> " +
                "<equipmentSlotEp childAction=\"deleteNonPresent\" enclosureId=\"1\" fltAggr=\"0\" id=\"1\" model=\"\" operQualifierReason=\"N/A\" operability=\"unknown\" presence=\"equipped\" refDn=\"sys/rack-unit-1\" revision=\"0\" rn=\"slot-ep-1\" serial=\"\" type=\"compute\" vendor=\"\"/> " +
                "<equipmentPsu Type=\"ac\" assetTag=\"\" childAction=\"deleteNonPresent\" fltAggr=\"0\" fsmDescr=\"\" fsmFlags=\"\" fsmPrev=\"nop\" fsmProgr=\"100\" fsmRmtInvErrCode=\"none\" fsmRmtInvErrDescr=\"\" fsmRmtInvRslt=\"\" fsmStageDescr=\"\" fsmStamp=\"never\" " +
                "fsmStatus=\"nop\" fsmTry=\"0\" id=\"0\" model=\"\" operQualifierReason=\"N/A\" operState=\"unknown\" operability=\"unknown\" partNumber=\"\" perf=\"unknown\" power=\"unknown\" powerStateQualifier=\"unknown\" presence=\"unknown\" psuFirmwareVersion=\"\" psuInputSrc=\"N/A\" psuType=\"N/A\" psuWattage=\"0\" revision=\"0\" rn=\"psu-0\" serial=\"\" thermal=\"unknown\" vendor=\"\" vid=\"\" voltage=\"unknown\"> " +
                "<equipmentPsuFsm childAction=\"deleteNonPresent\" completionTime=\"\" currentFsm=\"nop\" descr=\"\" fsmStatus=\"nop\" instanceId=\"0\" progress=\"100\" rmtErrCode=\"none\" rmtErrDescr=\"\" rmtRslt=\"\" rn=\"fsm\"/> " +
                "</equipmentPsu> " +
                "</equipmentRackEnclosure> </outConfig> </configResolveDn>";
        ConfigResolveEquipmentRackEnclosureDnResponse response =
                mapper.readValue(xml, ConfigResolveEquipmentRackEnclosureDnResponse.class);
        LOG.info(response.toString());
        Assert.assertNotNull(response.outconfig.equipmentRackEnclosure.model);
        Assert.assertEquals(response.dn, response.outconfig.equipmentRackEnclosure.dn);
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
        ConfigResolveComputeBladeDnResponse response = mapper.readValue(xml, ConfigResolveComputeBladeDnResponse.class);
        Assert.assertNotNull(response.outconfig.computeBlade.model);
        Assert.assertEquals(response.dn, response.outconfig.computeBlade.dn);

    }

    @Test
    public void canDeSerializeXmlToComputeRackUnit() throws JsonProcessingException {

        String xml ="<configResolveDn dn=\"sys/rack-unit-8\" cookie=\"1714168516/c91b06a0-2ca4-4094-a1d6-098ee701b21c\" response=\"yes\"> " +
                "<outConfig> " +
                "<computeRackUnit adminPower=\"policy\" adminState=\"in-service\" assetTag=\"\" " +
                "assignedToDn=\"\" association=\"none\" availability=\"available\" availableMemory=\"49152\" " +
                "checkPoint=\"discovered\" connPath=\"A,B\" connStatus=\"A,B\" descr=\"\" discovery=\"complete\" " +
                "discoveryStatus=\"\" dn=\"sys/rack-unit-8\" enclosureId=\"0\" fanSpeedConfigStatus=\"\" " +
                "fanSpeedPolicyFault=\"no\" fltAggr=\"2\" fsmDescr=\"\" fsmFlags=\"\" fsmPrev=\"DiscoverSuccess\" " +
                "fsmProgr=\"100\" fsmRmtInvErrCode=\"none\" fsmRmtInvErrDescr=\"\" fsmRmtInvRslt=\"\" " +
                "fsmStageDescr=\"\" fsmStamp=\"2024-04-24T02:44:55.707\" fsmStatus=\"nop\" " +
                "fsmTry=\"0\" id=\"8\" intId=\"80305\" kmipFault=\"no\" kmipFaultDescription=\"\" " +
                "lc=\"discovered\" lcTs=\"1970-01-01T01:00:00.000\" localId=\"\" " +
                "lowVoltageMemory=\"not-applicable\" managingInst=\"A\" memorySpeed=\"not-applicable\" " +
                "mfgTime=\"not-applicable\" model=\"UCSC-C240-M6N\" name=\"\" " +
                "numOf40GAdaptorsWithOldFw=\"0\" numOf40GAdaptorsWithUnknownFw=\"0\" " +
                "numOfAdaptors=\"2\" numOfCores=\"4\" numOfCoresEnabled=\"4\" numOfCpus=\"2\" " +
                "numOfEthHostIfs=\"0\" numOfFcHostIfs=\"0\" numOfThreads=\"16\" operPower=\"off\" " +
                "operPwrTransSrc=\"unknown\" operQualifier=\"\" operQualifierReason=\"N/A\" " +
                "operState=\"unassociated\" operability=\"operable\" " +
                "originalUuid=\"1b4e28ba-2fa1-11d2-e008-b9a761bde3fb\" partNumber=\"\" " +
                "physicalSecurity=\"chassis-open\" policyLevel=\"0\" policyOwner=\"local\" " +
                "presence=\"equipped\" revision=\"0\" serial=\"RK87\" serverId=\"8\" slotId=\"0\" " +
                "storageOperQualifier=\"unknown\" totalMemory=\"49152\" usrLbl=\"\" " +
                "uuid=\"1b4e28ba-2fa1-11d2-e008-b9a761bde3fb\" vendor=\"Cisco Systems Inc\" " +
                "versionHolder=\"no\" vethStatus=\"\" vid=\"0\"/>" +
                " </outConfig> " +
                "</configResolveDn>";

        XmlMapper mapper = new XmlMapper();
        ConfigResolveComputeRackUnitDnResponse response = mapper.readValue(xml, ConfigResolveComputeRackUnitDnResponse.class);
        Assert.assertNotNull(response.outconfig.computeRackUnit.model);
        Assert.assertEquals(response.dn, response.outconfig.computeRackUnit.dn);

    }

    @Test
    public void canDeSerializeXmlToNetworkElement() throws JsonProcessingException {

        String xml ="<configResolveDn dn=\"sys/switch-A\" cookie=\"1713476816/da9ab72a-49e4-49ed-9a5a-c0e951d00b2f\" response=\"yes\"> " +
                "<outConfig> " +
                "<networkElement adminEvacState=\"fill\" adminInbandIfState=\"disable\" diffMemory=\"1\" " +
                "dn=\"sys/switch-A\" expectedMemory=\"32500\" fltAggr=\"12884901888\" forceEvac=\"no\" id=\"A\" " +
                "inbandIfGw=\"0.0.0.0\" inbandIfIp=\"0.0.0.0\" inbandIfMask=\"0.0.0.0\" inbandIfVnet=\"0\" " +
                "inventoryStatus=\"\" minActiveFan=\"2\" model=\"UCS-FI-64108\" oobIfGw=\"10.172.192.1\" " +
                "oobIfIp=\"10.172.192.22\" oobIfMac=\"00:00:00:00:00:00\" oobIfMask=\"255.255.255.0\" " +
                "operEvacState=\"fill\" operability=\"operable\" revision=\"0\" serial=\"FDO231307E9\" " +
                "shutdownFanRemoveal=\"no\" thermal=\"unknown\" totalMemory=\"32870\" vendor=\"Cisco Systems, Inc.\"/>" +
                " </outConfig> </configResolveDn>";

        XmlMapper mapper = new XmlMapper();
        ConfigResolveNetworkElementDnResponse response = mapper.readValue(xml, ConfigResolveNetworkElementDnResponse.class);
        Assert.assertNotNull(response.outconfig.networkElement.model);
        Assert.assertEquals(response.dn, response.outconfig.networkElement.dn);

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