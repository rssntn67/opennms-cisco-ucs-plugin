package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEntity;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.ConfigApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.IpApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.Dn;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip.IpPoolAddr;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip.IpPoolUniverse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.network.NetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.IpPoolPool;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.IpPoolPooled;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.LsServer;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.VNicIpV4PooledAddr;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.*;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ApiClientTest {

    private final Logger LOG = LoggerFactory.getLogger(ApiClientTest.class);

    protected static ApiClientCredentials getCredentials() {
        return ApiClientCredentials.builder()
                .withUrl("https://10.172.192.15/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .withValidity(0)
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
        ConfigResolveDnResponseEquipmentChassis response =
                mapper.readValue(xml, ConfigResolveDnResponseEquipmentChassis.class);
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
        ConfigResolveDnResponseEquipmentFex response =
                mapper.readValue(xml, ConfigResolveDnResponseEquipmentFex.class);
        LOG.info(response.toString());
        Assert.assertNotNull(response.outconfig.equipmentFex.model);
        Assert.assertEquals(response.dn, response.outconfig.equipmentFex.dn);
    }

    @Test
    public void canDeSerializeXmlToEquipmentRackEnclosure() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String xml = " <configResolveDn dn=\"sys/rack-enclosure-1\" cookie=\"1714205640/a3f871aa-9028-447b-9770-14904ce96e96\" response=\"yes\"> " +
                "<outConfig> " +
                "<equipmentRackEnclosure assetTag=\"\" dn=\"sys/rack-enclosure-1\" fltAggr=\"0\" id=\"1\"" +
                " mfgTime=\"not-applicable\" model=\"UCSC-C4200-SFF\" " +
                "operQualifierReason=\"N/A\" operability=\"operable\" " +
                "partNumber=\"\" presence=\"equipped\" revision=\"0\" serial=\"ENCL15\" " +
                "vendor=\"Cisco Systems Inc\" vid=\"\"/>" +
                " </outConfig> " +
                "</configResolveDn>\n";
        ConfigResolveDnResponseEquipmentRackEnclosure response =
                mapper.readValue(xml, ConfigResolveDnResponseEquipmentRackEnclosure.class);
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
        ConfigResolveDnResponseComputeBlade response = mapper.readValue(xml, ConfigResolveDnResponseComputeBlade.class);
        LOG.info(response.toString());
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
        ConfigResolveDnResponseComputeRackUnit response = mapper.readValue(xml, ConfigResolveDnResponseComputeRackUnit.class);
        LOG.info(response.toString());
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
        ConfigResolveDnResponseNetworkElement response = mapper.readValue(xml, ConfigResolveDnResponseNetworkElement.class);
        Assert.assertNotNull(response.outconfig.networkElement.model);
        Assert.assertEquals(response.dn, response.outconfig.networkElement.dn);

    }

    @Test
    public void testCanDeserializeErrorXmlString() throws JsonProcessingException {
        String xml = "<error cookie=\"\" response=\"yes\" errorCode=\"ERR-xml-parse-error\" invocationResult=\"594\" errorDescr=\"XML PARSING ERROR: unknown attribute &apos;1714204607&apos; in element &apos;configResolveDn&apos;\"/>";
        XmlMapper mapper = new XmlMapper();
        ErrorResponse errorResponse = mapper.readValue(xml,ErrorResponse.class);
        Assert.assertEquals("ERR-xml-parse-error", errorResponse.errorCode);
        Assert.assertEquals(594, errorResponse.invocationResult);
    }

    @Test
    public void getComputerRackEnclosureXmlString() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi aaaApi = new AaaApi(credentials,apiClient);
        aaaApi.login();
        String xmlRequest = "<configResolveDn dn=\"sys/rack-enclosure-1\" cookie=\""+aaaApi.getToken()+"\" inHierarchical=\"false\"/>";
        Assert.assertEquals(xmlRequest,UcsXmlApiRequest.getConfigResolveDnRequest(aaaApi.getToken(),Dn.getDn("sys/rack-enclosure-1"), false));
        String xmlString = apiClient.doPost(UcsXmlApiRequest.getConfigResolveDnRequest(aaaApi.getToken(),Dn.getDn("sys/rack-enclosure-1"), false));
        System.out.println(xmlString);
        aaaApi.logout();
    }

    @Test
    public void dnClassTest() {
        String value = "sys/rack-enclosure-1";
        Dn dn = Dn.getDn(value);
        Assert.assertEquals(value, dn.value);
        Dn updn = Dn.getParentDn(dn);
        Assert.assertNotNull(updn);
        Assert.assertEquals("sys", updn.value);
        Assert.assertTrue(Dn.isRootDn(updn));
        Assert.assertNull(Dn.getParentDn(updn));
        String org = "org-root/ls-osi01-w01-prd01-lnx19/ipv4-pooled-addr";
        Dn orgDn =  Dn.getDn(org);
        Assert.assertFalse(Dn.isRootDn(orgDn));
        Dn ls = Dn.getParentDn(orgDn);
        Assert.assertNotNull(ls);
        Assert.assertEquals("org-root/ls-osi01-w01-prd01-lnx19", ls.value);
        Assert.assertFalse(Dn.isRootDn(ls));
        Dn rootDn = Dn.getParentDn(ls);
        Assert.assertNotNull(rootDn);
        Assert.assertEquals("org-root", rootDn.value);
        Assert.assertTrue(Dn.isRootDn(rootDn));
    }

    @Test
    public void testAaaLoginApi() throws InterruptedException, ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi aaaApi = new AaaApi(credentials,apiClient);
        Assert.assertFalse(aaaApi.isValidTokenAtLeastFor(0));

        LocalDateTime firstValidityTime = aaaApi.getValidityTime();
        aaaApi.login();
        LOG.info("login cookie: {}" ,aaaApi.getToken());
        LOG.info("login now     : {}", LocalDateTime.now());
        LOG.info("login validity: {}", aaaApi.getValidityTime());
        Assert.assertTrue(aaaApi.isValidTokenAtLeastFor(10));
        Assert.assertTrue(aaaApi.isValidTokenAtLeastFor(100));
        Assert.assertTrue(aaaApi.isValidTokenAtLeastFor(300));
        Assert.assertTrue(aaaApi.isValidTokenAtLeastFor(590));
        Assert.assertFalse(aaaApi.isValidTokenAtLeastFor(600));
        Assert.assertTrue(aaaApi.getValidityTime().isAfter(LocalDateTime.now()));
        Thread.sleep(1000);

        aaaApi.refresh();
        LOG.info("refresh cookie: {}" ,aaaApi.getToken());
        LOG.info("refresh now     : {}", LocalDateTime.now());
        LOG.info("refresh validity: {}", aaaApi.getValidityTime());
        Assert.assertTrue(aaaApi.isValidTokenAtLeastFor(30));
        Assert.assertTrue(aaaApi.getValidityTime().isAfter(firstValidityTime));
        Thread.sleep(1000);
        aaaApi.logout();
        Assert.assertFalse(aaaApi.isValidTokenAtLeastFor(0));

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
    public void testConfigApiResolveClassNetworkElement() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi aaaApi = new AaaApi(credentials,client);
        aaaApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<NetworkElement> elements = configApi.getUcsNetworkElementListByClassId(aaaApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        aaaApi.logout();
    }

    @Test
    public void testConfigApiResolveClassEquipmentFex() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<EquipmentFex> elements = configApi.getUcsEquipmentFexListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        loginApi.logout();
    }

    @Test
    public void testConfigApiResolveClassEquipmentChassis() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<EquipmentChassis> elements = configApi.getUcsEquipmentChassisListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        Assert.assertEquals(2, elements.size());
        loginApi.logout();
    }

    @Test
    public void testConfigApiResolveClassEquipmentRackEnclosure() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<EquipmentRackEnclosure> elements = configApi.getUcsEquipmentRackEnclosureListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        Assert.assertEquals(1, elements.size());
        loginApi.logout();
    }

    @Test
    public void testConfigApiResolveClassComputeBlade() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<ComputeBlade> elements = configApi.getUcsComputeBladeListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        Assert.assertEquals(5, elements.size());
        loginApi.logout();
    }

    @Test
    public void testConfigApiResolveClassComputeRackUnit() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient(credentials.url);
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client);
        List<ComputeRackUnit> elements = configApi.getUcsComputeRackUnitListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        Assert.assertEquals(9,elements.size());
        loginApi.logout();
    }


    @Test
    public void testApiClientApiEquipmentItem() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        List<String> dns = api.getDnByClassId(loginApi.getToken(), UcsEntity.ClassItem.equipmentItem);
        for (String dn : dns) {
            LOG.info("equipmentItem: {}",dn);
        }
        loginApi.logout();
    }

    @Test
    public void testApiClientComputeItem() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        List<String> dns = api.getDnByClassId(loginApi.getToken(), UcsEntity.ClassItem.computeItem);
        for (String dn : dns) {
            LOG.info("computeItem: {}",dn);
        }
        loginApi.logout();
    }

    @Test
    public void testInteger() {
        BigInteger b = BigInteger.valueOf(4295032833L);
        Assert.assertEquals(4295032833L, b.longValue());
    }

    @Test
    public void testIpApi() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        IpApi ipApi = new IpApi(apiClient);
        IpPoolUniverse ipPoolUniverse = ipApi.getIpPoolUniverse(loginApi.getToken());
        Set<String> pools = new HashSet<>();
        for (IpPoolAddr pool: ipPoolUniverse.ippoolAddr) {
            IpPoolPooled ipPoolPooled = ipApi.getIpPoolPooled(loginApi.getToken(), Dn.getDn(pool.ippoolPoolable.poolDn));
            String parentipoolpollable = Objects.requireNonNull(Dn.getParentDn(Dn.getDn(pool.ippoolPoolable.poolDn))).value;
            pools.add(parentipoolpollable);
            Assert.assertEquals(0, pool.globalAssignedCnt);
            Assert.assertEquals(0, pool.globalDefinedCnt);
            Assert.assertEquals("pool", pool.owner);
            if (pool.assignedToDn.isEmpty()) {
                System.out.println("---Not assignedToDn: " + pool.ippoolPoolable.poolDn);
                continue;
            }
            VNicIpV4PooledAddr vNicIpV4PooledAddr = ipApi.getVnicVNicIpV4PooledAddr(loginApi.getToken(), Dn.getDn(pool.assignedToDn));
            Assert.assertEquals(ipPoolPooled.defGw, vNicIpV4PooledAddr.defGw);
            Assert.assertEquals(ipPoolPooled.subnet, vNicIpV4PooledAddr.subnet);
            Assert.assertEquals(ipPoolPooled.id, vNicIpV4PooledAddr.addr);
            Assert.assertNotNull(ipPoolPooled.id);
            Assert.assertEquals(pool.id,vNicIpV4PooledAddr.addr);
            LsServer lsServer = ipApi.getLsServer(loginApi.getToken(), Dn.getParentDn(Dn.getDn(pool.assignedToDn)));
            if (!lsServer.pnDn.isEmpty()) {
                System.out.println("-----ip assigned-----");
                System.out.println("pool.assignedToDn:" + pool.assignedToDn);
                System.out.println("pool.ippoolPoolable.poolDn.parent:" + parentipoolpollable);
                System.out.println("pool.ippoolPoolable.poolDn:" + pool.ippoolPoolable.poolDn);
                System.out.println("lsServer.pnDn:" + lsServer.pnDn);
                System.out.println("pool.assigned:" + pool.assigned);
                System.out.println("pool.id:" + pool.id);
            }
        }
        for (String pool: pools) {
            IpPoolPool ipPoolPool = ipApi.getIpPoolPool(loginApi.getToken(), Dn.getDn(pool));
            System.out.println("---pool----");
            System.out.println(ipPoolPool.name);
            System.out.println("ipPoolPool.size:"+ipPoolPool.size);
            System.out.println("ipPoolPool.assigned:"+ipPoolPool.assigned);
            List<String> ipPool = ipPoolPool.ippoolPooled.stream().map(s -> s.id).collect(Collectors.toList());
            Set<String> subnets = ipPoolPool.ippoolPooled.stream().map(s -> s.subnet).collect(Collectors.toSet());
            Set<String> gateways = ipPoolPool.ippoolPooled.stream().map(s -> s.defGw).collect(Collectors.toSet());
            Collections.sort(ipPool);
            System.out.println(ipPool);
            System.out.println(subnets);
            System.out.println(gateways);
        }
        loginApi.logout();
    }

    @Test
    public void testApiClientComputeBlade1ByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(apiClient);
        IpApi ipApi = new IpApi(apiClient);
        ComputeBlade computeBlade =
                configApi.getUcsComputeBladeByResponse(
                        configApi.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/chassis-3/blade-1"), false)
                );
        Assert.assertEquals("sys/chassis-3/blade-1", computeBlade.dn);
        System.out.println(computeBlade.assignedToDn);
        Assert.assertEquals("org-root/ls-osi01-w01-prd01-lnx13", computeBlade.assignedToDn);
        LsServer lsServer = ipApi.getLsServer(loginApi.getToken(), Dn.getDn(computeBlade.assignedToDn));
        Assert.assertEquals(computeBlade.assignedToDn, lsServer.dn);
        Assert.assertEquals(computeBlade.dn, lsServer.pnDn);
        System.out.println(lsServer);
        IpPoolPool ipPoolPool = ipApi.getIpPoolPool(loginApi.getToken(), Dn.getDn(lsServer.operExtIPPoolName));
        Assert.assertFalse(ipPoolPool.ippoolPooled.isEmpty());
        ipPoolPool.ippoolPooled.forEach(System.out::println);

        loginApi.logout();
    }

    @Test
    public void testApiClientComputeBlade2ByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        ComputeBlade computeBlade =
                api.getUcsComputeBladeByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/chassis-3/blade-2"), false)
                );
        Assert.assertEquals("sys/chassis-3/blade-2", computeBlade.dn);
        System.out.println(computeBlade.assignedToDn);
        Assert.assertEquals("org-root/ls-osi01-w01-prd01-lnx15", computeBlade.assignedToDn);
        String assignedXml = api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn(computeBlade.assignedToDn), false);
        System.out.println(assignedXml);
        System.out.println(api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("org-root/ip-pool-BM-KVM-POOL"),false));
        System.out.println(api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn(computeBlade.assignedToDn+"/ipv4-pooled-addr"),false ));
        loginApi.logout();
    }

    @Test
    public void testApiClientComputeBlade3ByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        ComputeBlade computeBlade =
                api.getUcsComputeBladeByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/chassis-3/blade-3"), false)
                );
        Assert.assertEquals("sys/chassis-3/blade-3", computeBlade.dn);
        Assert.assertEquals("", computeBlade.assignedToDn);
        loginApi.logout();
    }


    @Test
    public void testApiClientComputeBlade3ByDnHierarchical() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        String computeBlade =
                        api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/chassis-3/blade-3"), true);
        System.out.println(computeBlade);
        loginApi.logout();
    }

    @Test
    public void testApiClientComputeBlade1ByDnHierarchical() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        String computeBlade =
                api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/chassis-3/blade-1"), true);
        System.out.println(computeBlade);
        loginApi.logout();
    }


    @Test
    public void testApiClientComputeBlade2ServiceProfileByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        String serviceProfile =
                api.getUcsEntityByDn(loginApi.getToken(),Dn.getDn("org-root/ls-osi01-w01-prd01-lnx15"), true);
        LOG.info("{}", serviceProfile);
        loginApi.logout();
    }

    @Test
    public void testApiClientComputeRackUnitByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        ComputeRackUnit computeRackUnit =
                api.getUcsComputeRackUnitByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/rack-unit-8"), false)
                );
        Assert.assertEquals("sys/rack-unit-8", computeRackUnit.dn);
        loginApi.logout();
    }

    @Test
    public void testApiEquipmentChassisByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        EquipmentChassis equipment =
                api.getUcsEquipmentChassisByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/chassis-4"), false)
                );
        Assert.assertEquals("sys/chassis-4", equipment.dn);
        loginApi.logout();
    }

    @Test
    public void testApiEquipmentFexByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        EquipmentFex equipment =
                api.getUcsEquipmentFexByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/fex-2"), false)
                );
        Assert.assertEquals("sys/fex-2", equipment.dn);
        loginApi.logout();
    }

    @Test
    public void testApiEquipmentRackEnclosureByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        EquipmentRackEnclosure equipment =
                api.getUcsEquipmentRackEnclosureByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/rack-enclosure-1"), false)
                );
        Assert.assertEquals("sys/rack-enclosure-1", equipment.dn);
        loginApi.logout();
    }

    @Test
    public void testApiNetworkElementByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        NetworkElement networkElement =
                api.getUcsNetworkElementByResponse(
                        api.getUcsEntityByDn(
                                loginApi.getToken(), Dn.getDn("sys/switch-A"), false)
                );
        Assert.assertEquals("sys/switch-A", networkElement.dn);
        LOG.info(networkElement.model);
        loginApi.logout();
    }

    @Test
    public void testApiNetworkElementNotExistByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient);
        String response = api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/switch-K"), false);
        LOG.info("{}", response);
        Assert.assertNull(api.getUcsNetworkElementByResponse(response));
        loginApi.logout();
    }

    @Test
    public void testApiExistDnButIsUnsupported() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient(credentials.url);
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        try {
            loginApi.login();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        ConfigApi api = new ConfigApi(apiClient);
        String response = api.getUcsEntityByDn(loginApi.getToken(), Dn.getDn("sys/chassis-4/psu-4"), false);
        LOG.info("{}", response);
        try {
            api.getUcsNetworkElementByResponse(response);
            Assert.fail();
        } catch (ApiException e) {
            LOG.error("ok: {}", e.getMessage(),e);
        }
        loginApi.logout();
    }

    /* Server
Overall Status	:	OK
Configuration Error	:	not-applicable
Admin State	:	In Service
Discovery State	:	Complete
Avail State	:	Unavailable
Assoc State	:	Failed
Power State	:	Off
Slot Status	:	Equipped
Check Point	:	Discovered

----
Overall Status	:	Discovery
Configuration Error	:	not-applicable
Admin State	:	In Service
Discovery State	:	In Progress
Avail State	:	Unavailable
Assoc State	:	None
Power State	:	Off
Slot Status	:	Equipped
Check Point	:	Deep Checkpoint
-----
Overall Status	:	Unassociated
Configuration Error	:	not-applicable
Admin State	:	In Service
Discovery State	:	Complete
Avail State	:	Available
Assoc State	:	None
Power State	:	Off
Slot Status	:	Equipped
Check Point	:	Discovered


FEX

Overall Status	:	Operable
Configuration Error	:	not-applicable
Power	:	N/A
Voltage	:	N/A
Thermal	:	N/A

Fabric Interconnect
Overall Status	:	Operable
Thermal	:	N/A
Ethernet Mode	:	End Host
FC Mode	:	End Host
Admin Evac Mode	:	Off
Oper Evac Mode	:	Off

Overall Status	:	Operable
Thermal	:	N/A
Ethernet Mode	:	End Host
FC Mode	:	End Host
Admin Evac Mode	:	Off
Oper Evac Mode	:	Off

--Enclosure
Overall Status	:	Operable

--Chassis
Overall Status	:	Operable

Configuration Error	:	not-applicable
Configuration State	:	OK
Operability	:	Operable
Power	:	OK
Thermal	:	OK


     */

}