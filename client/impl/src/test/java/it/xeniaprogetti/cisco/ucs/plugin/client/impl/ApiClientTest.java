package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.ConfigApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.FaultApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.IpApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.CustomXmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.fault.FaultInst;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip.IpPoolAddr;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip.IpPoolUniverse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.network.NetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.IpPoolPool;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.IpPoolPooled;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.LsServer;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.VNicIpV4PooledAddr;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.AaaLoginResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.AaaLogoutResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.AaaRefreshResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigFindDnsByClassIdResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseFcStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseNetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ErrorResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.FcStats;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ApiClientTest {

    private final Logger LOG = LoggerFactory.getLogger(ApiClientTest.class);

    private static ApiClientCredentials getCredentials() {
        return ApiClientCredentials.builder()
                .withUrl("https://10.172.192.15/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .withValidity(30)
                .build();
    }

    @Test
    public void testGetIpAddressFromUrl() {
        ApiClientCredentials credentials = getCredentials();
        Assert.assertTrue(UcsUtils.validate(credentials));
        InetAddress ip;
        try {
            ip = UcsUtils.getIpAddressFromCredentials(credentials);
            LOG.info("{}", ip.getHostAddress());
        } catch (ApiException e) {
            Assert.fail();
        }

    }

    @Test
    public void testGetIpAddressFromExternal() {
        ApiClientCredentials credentials = ApiClientCredentials.builder()
                .withUrl("https://www.arsinfo.it/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .withValidity(30)
                .build();

        Assert.assertTrue(UcsUtils.validate(credentials));
        InetAddress ip;
        try {
            ip = UcsUtils.getIpAddressFromCredentials(credentials);
            LOG.info("{}", ip.getHostAddress());
        } catch (ApiException e) {
            Assert.fail();
        }

    }

    @Test
    public void testValidationUrlError() {
        ApiClientCredentials credentials = ApiClientCredentials.builder()
                .withUrl("httpqs://www.arsinfo.it/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .withValidity(30)
                .build();

        Assert.assertFalse(UcsUtils.validate(credentials));

    }

    /**
     * Verifies that the object is serialized to XML as expected.
     */
    @Test
    public void canSerializeAaaLoginToXml() {
        String xml = "<aaaLogin inName=\"pippo\" inPassword=\"pluto\"/>";
        Assert.assertEquals(xml, UcsXmlApiRequest.getLoginRequest("pippo","pluto"));
    }

    @Test
    public void canSerializeConfigFindDnsByClassIdToXml() throws JsonProcessingException {
        XmlMapper mapper = new CustomXmlMapper();
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
                "<dn value=\"sys/rack-unit-6\"/> " +
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
        XmlMapper mapper = new CustomXmlMapper();
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
        XmlMapper mapper = new CustomXmlMapper();
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
        XmlMapper mapper = new CustomXmlMapper();
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
        XmlMapper mapper = new CustomXmlMapper();
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

        XmlMapper mapper = new CustomXmlMapper();
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

        XmlMapper mapper = new CustomXmlMapper();
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

        XmlMapper mapper = new CustomXmlMapper();
        ConfigResolveDnResponseNetworkElement response = mapper.readValue(xml, ConfigResolveDnResponseNetworkElement.class);
        Assert.assertNotNull(response.outconfig.networkElement.model);
        Assert.assertEquals(response.dn, response.outconfig.networkElement.dn);

    }

    @Test
    public void testCanDeserializeErrorXmlString() throws JsonProcessingException {
        String xml = "<error cookie=\"\" response=\"yes\" errorCode=\"ERR-xml-parse-error\" invocationResult=\"594\" errorDescr=\"XML PARSING ERROR: unknown attribute &apos;1714204607&apos; in element &apos;configResolveDn&apos;\"/>";
        XmlMapper mapper = new CustomXmlMapper();
        ErrorResponse errorResponse = mapper.readValue(xml,ErrorResponse.class);
        Assert.assertEquals("ERR-xml-parse-error", errorResponse.errorCode);
        Assert.assertEquals(594, errorResponse.invocationResult);
    }

    @Test
    public void testCanDeserializeLoginErrorString() throws JsonProcessingException {
        String xml = "<aaaLogin cookie=\"\" response=\"yes\" errorCode=\"572\" invocationResult=\"unidentified-fail\" errorDescr=\"User reached maximum session limit\"> </aaaLogin>";
        XmlMapper mapper = new CustomXmlMapper();
        AaaLoginResponse response = mapper.readValue(xml,AaaLoginResponse.class);
        Assert.assertEquals(572, response.errorCode);
        Assert.assertEquals("yes", response.response);
        Assert.assertEquals("unidentified-fail", response.invocationResult);
        Assert.assertEquals("User reached maximum session limit", response.errorDescr);
    }

    @Test
    public void testCanDeserializeRefreshErrorString() throws JsonProcessingException {
        String xml = "<aaaRefresh cookie=\"\" response=\"yes\" errorCode=\"552\" invocationResult=\"unidentified-fail\" errorDescr=\"Authorization required\"/>";
        XmlMapper mapper = new CustomXmlMapper();
        AaaRefreshResponse response = mapper.readValue(xml,AaaRefreshResponse.class);
        Assert.assertEquals(552, response.errorCode);
        Assert.assertEquals("yes", response.response);
        Assert.assertEquals("unidentified-fail", response.invocationResult);
        Assert.assertEquals("Authorization required", response.errorDescr);
    }

    @Test
    public void testCanDeserializeLogoutErrorString() throws JsonProcessingException {
        String xml = " <aaaLogout cookie=\"\" response=\"yes\" errorCode=\"555\" invocationResult=\"unidentified-fail\" errorDescr=\"Session not found\"> </aaaLogout>";
        XmlMapper mapper = new CustomXmlMapper();
        AaaLogoutResponse response = mapper.readValue(xml,AaaLogoutResponse.class);
        Assert.assertEquals(555, response.errorCode);
        Assert.assertEquals("yes", response.response);
        Assert.assertEquals("unidentified-fail", response.invocationResult);
        Assert.assertEquals("Session not found", response.errorDescr);
    }

    @Test
    public void getComputerRackEnclosureXmlString() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi aaaApi = new AaaApi(credentials,apiClient);
        aaaApi.login();
        String xmlRequest = "<configResolveDn dn=\"sys/rack-enclosure-1\" cookie=\""+aaaApi.getToken()+"\" inHierarchical=\"false\"/>";
        Assert.assertEquals(xmlRequest, UcsXmlApiRequest.getConfigResolveDnRequest(aaaApi.getToken(),"sys/rack-enclosure-1", false));
        String xmlString = apiClient.doPost(UcsXmlApiRequest.getConfigResolveDnRequest(aaaApi.getToken(),"sys/rack-enclosure-1", false),credentials.url);
        System.out.println(xmlString);
        aaaApi.logout();
    }

    @Test
    public void dnClassTest() {
        String value = "sys/rack-enclosure-1";
        UcsDn dn = UcsDn.getDn(value);
        Assert.assertEquals(value, dn.value);
        UcsDn updn = UcsDn.getParentDn(dn);
        Assert.assertNotNull(updn);
        Assert.assertEquals("sys", updn.value);
        Assert.assertTrue(UcsDn.isRootDn(updn));
        Assert.assertNull(UcsDn.getParentDn(updn));
        String org = "org-root/ls-osi01-w01-prd01-lnx19/ipv4-pooled-addr";
        UcsDn orgDn =  UcsDn.getDn(org);
        Assert.assertFalse(UcsDn.isRootDn(orgDn));
        UcsDn ls = UcsDn.getParentDn(orgDn);
        Assert.assertNotNull(ls);
        Assert.assertEquals("org-root/ls-osi01-w01-prd01-lnx19", ls.value);
        Assert.assertFalse(UcsDn.isRootDn(ls));
        UcsDn rootDn = UcsDn.getParentDn(ls);
        Assert.assertNotNull(rootDn);
        Assert.assertEquals("org-root", rootDn.value);
        Assert.assertTrue(UcsDn.isRootDn(rootDn));
    }

    @Test
    public void testAaaLoginApi() throws InterruptedException, ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi aaaApi = new AaaApi(credentials,apiClient);
        Assert.assertFalse(aaaApi.isValid());

        aaaApi.login();
        LOG.info("login cookie: {}" ,aaaApi.getToken());
        LOG.info("login now     : {}", LocalDateTime.now());
        LOG.info("login validity: {}", aaaApi.getValidityTime());
        Assert.assertFalse(aaaApi.isValidTokenAtLeastFor(600));
        Assert.assertTrue(aaaApi.isValidTokenAtLeastFor(599));
        Thread.sleep(100000);
        Assert.assertFalse(aaaApi.isValidTokenAtLeastFor(500));
        Assert.assertTrue(aaaApi.isValidTokenAtLeastFor(499));

        aaaApi.refresh();
        Assert.assertTrue(aaaApi.isValidTokenAtLeastFor(599));
        LOG.info("refresh cookie: {}" ,aaaApi.getToken());
        LOG.info("refresh now     : {}", LocalDateTime.now());
        LOG.info("refresh validity: {}", aaaApi.getValidityTime());
        Thread.sleep(1000);
        aaaApi.logout();
        Assert.assertNull(aaaApi.getToken());

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
        ApiClient client = new ApiClient();
        client.setTrustAllCertsClient();
        AaaApi aaaApi = new AaaApi(credentials,client);
        aaaApi.login();
        ConfigApi configApi = new ConfigApi(client,credentials.url);
        List<NetworkElement> elements = configApi.getUcsNetworkElementListByClassId(aaaApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        aaaApi.logout();
    }

    @Test
    public void testConfigApiResolveClassEquipmentFex() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient();
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client,credentials.url);
        List<EquipmentFex> elements = configApi.getUcsEquipmentFexListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        loginApi.logout();
    }

    @Test
    public void testConfigApiResolveClassEquipmentChassis() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient();
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client, credentials.url);
        List<EquipmentChassis> elements = configApi.getUcsEquipmentChassisListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        Assert.assertEquals(2, elements.size());
        loginApi.logout();
    }

    @Test
    public void testConfigApiResolveClassEquipmentRackEnclosure() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient();
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client,credentials.url);
        List<EquipmentRackEnclosure> elements = configApi.getUcsEquipmentRackEnclosureListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        Assert.assertEquals(1, elements.size());
        loginApi.logout();
    }

    @Test
    public void testConfigApiResolveClassComputeBlade() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient();
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client,credentials.url);
        List<ComputeBlade> elements = configApi.getUcsComputeBladeListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        Assert.assertEquals(5, elements.size());
        loginApi.logout();
    }

    @Test
    public void testConfigApiResolveClassComputeRackUnit() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient client = new ApiClient();
        client.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,client);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(client,credentials.url);
        List<ComputeRackUnit> elements = configApi.getUcsComputeRackUnitListByClassId(loginApi.getToken());
        Assert.assertFalse(elements.isEmpty());
        Assert.assertEquals(9,elements.size());
        loginApi.logout();
    }


    @Test
    public void testApiClientApiEquipmentItem() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        List<String> dns = api.getDnByClassId(loginApi.getToken(), UcsEnums.NamingClassId.equipmentItem);
        for (String dn : dns) {
            LOG.info("equipmentItem: {}",dn);
        }
        loginApi.logout();
    }

    @Test
    public void testApiClientComputeItem() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        List<String> dns = api.getDnByClassId(loginApi.getToken(), UcsEnums.NamingClassId.computeItem);
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
    public void testConfigApiChassis3ComputeBlade3WithHierarchy() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        String computeBlade =
                api.getUcsEntityByDn(loginApi.getToken(), "sys/chassis-3/blade-3", true);
        System.out.println(computeBlade);
        loginApi.logout();
    }

    @Test
    public void testConfigApiChassis3ComputeBlade1WithHierarchy() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        String computeBlade =
                api.getUcsEntityByDn(loginApi.getToken(), "sys/chassis-3/blade-1", true);
        System.out.println(computeBlade);
        loginApi.logout();
    }

    @Test
    public void testIpApi() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        IpApi ipApi = new IpApi(apiClient,credentials.url);
        IpPoolUniverse ipPoolUniverse = ipApi.getIpPoolUniverse(loginApi.getToken());
        Set<String> pools = new HashSet<>();
        for (IpPoolAddr pool: ipPoolUniverse.ippoolAddr) {
            IpPoolPooled ipPoolPooled = ipApi.getIpPoolPooled(loginApi.getToken(), pool.ippoolPoolable.poolDn);
            String parentipoolpollable = Objects.requireNonNull(UcsDn.getParentDn(UcsDn.getDn(pool.ippoolPoolable.poolDn))).value;
            pools.add(parentipoolpollable);
            Assert.assertEquals(0, pool.globalAssignedCnt);
            Assert.assertEquals(0, pool.globalDefinedCnt);
            Assert.assertEquals("pool", pool.owner);
            if (pool.assignedToDn.isEmpty()) {
                System.out.println("---Not assignedToDn: " + pool.ippoolPoolable.poolDn);
                continue;
            }
            VNicIpV4PooledAddr vNicIpV4PooledAddr = ipApi.getVnicVNicIpV4PooledAddr(loginApi.getToken(), pool.assignedToDn);
            Assert.assertEquals(ipPoolPooled.defGw, vNicIpV4PooledAddr.defGw);
            Assert.assertEquals(ipPoolPooled.subnet, vNicIpV4PooledAddr.subnet);
            Assert.assertEquals(ipPoolPooled.id, vNicIpV4PooledAddr.addr);
            Assert.assertNotNull(ipPoolPooled.id);
            Assert.assertEquals(pool.id,vNicIpV4PooledAddr.addr);
            LsServer lsServer = ipApi.getLsServer(loginApi.getToken(), Objects.requireNonNull(UcsDn.getParentDn(UcsDn.getDn(pool.assignedToDn))).value);
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
            IpPoolPool ipPoolPool = ipApi.getIpPoolPool(loginApi.getToken(), pool);
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
    public void willProduceUcsIpPoolTest() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        IpApi ipApi = new IpApi(apiClient,credentials.url);
        IpPoolUniverse ipPoolUniverse = ipApi.getIpPoolUniverse(loginApi.getToken());
        for (IpPoolAddr pool: ipPoolUniverse.ippoolAddr) {
            if (!pool.assigned.equals("yes"))
                continue;
            UcsDn assignedToProfileDn = Objects.requireNonNull(UcsDn.getParentDn(UcsDn.getDn(pool.assignedToDn)));
            UcsDn poolDn = Objects.requireNonNull(UcsDn.getParentDn(UcsDn.getDn(pool.ippoolPoolable.poolDn)));
            LsServer lsServer = ipApi.getLsServer(loginApi.getToken(), assignedToProfileDn.value);
            if (lsServer.pnDn.isEmpty())
                continue;
            UcsDn assignedToDeviceDn = UcsDn.getDn(lsServer.pnDn);
            IpPoolPooled ipPoolPooled = ipApi.getIpPoolPooled(loginApi.getToken(), pool.ippoolPoolable.poolDn);


            System.out.println(ipPoolPooled.id);
            System.out.println(ipPoolPooled.defGw);
            System.out.println(ipPoolPooled.subnet);
            System.out.println(assignedToDeviceDn.value);
            System.out.println(assignedToProfileDn.value);
            System.out.println(poolDn.value);

        }

    }

    @Test
    public void testApiClientChasses3ComputeBlade1() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(apiClient,credentials.url);
        IpApi ipApi = new IpApi(apiClient,credentials.url);
        ComputeBlade computeBlade =
                configApi.getUcsComputeBladeByResponse(
                        configApi.getUcsEntityByDn(loginApi.getToken(), "sys/chassis-3/blade-1", false)
                );
        Assert.assertEquals("sys/chassis-3/blade-1", computeBlade.dn);
/*
        Overall Status	:	OK (Up) -> ok

        Configuration Error	:	not-applicable -> not-applicable
        Admin State	:	In Service (Up) -> in-service
        Discovery State	:	Complete (Up) -> complete
        Avail State	:	Available (Up) -> available
        Assoc State	:	Associated  (Up) -> associated
        Power State	:	On          (Up) -> on
        Slot Status	:	Equipped    (Up) -> equipped
        Check Point	:	Discovered       -> discovered
         */
        System.out.println(computeBlade);
        Assert.assertEquals("ok", computeBlade.operState); //Overall Status

        Assert.assertEquals("not-applicable", computeBlade.lowVoltageMemory); //Configuration Error
        Assert.assertEquals("not-applicable", computeBlade.memorySpeed); //Configuration Error
        Assert.assertEquals("not-applicable", computeBlade.mfgTime); //Configuration Error

        Assert.assertEquals("in-service", computeBlade.adminState); // Admin State
        Assert.assertEquals("complete", computeBlade.discovery); // Discovery State
        Assert.assertEquals("unavailable", computeBlade.availability); //Avail State
        Assert.assertEquals("associated", computeBlade.association); // Association State
        Assert.assertEquals("on", computeBlade.operPower); // Power State
        Assert.assertEquals("equipped", computeBlade.presence); //Slot Status
        Assert.assertEquals("discovered", computeBlade.checkPoint); //CheckPoint

        Assert.assertEquals("operable", computeBlade.operability);

        Assert.assertEquals("org-root/ls-osi01-w01-prd01-lnx13", computeBlade.assignedToDn);

        // This means both connections are available
        Assert.assertEquals(computeBlade.connPath, computeBlade.connStatus);

        LsServer lsServer = ipApi.getLsServer(loginApi.getToken(), computeBlade.assignedToDn);
        Assert.assertEquals(computeBlade.assignedToDn, lsServer.dn);
        Assert.assertEquals(computeBlade.dn, lsServer.pnDn);
        System.out.println(lsServer);
        IpPoolPool ipPoolPool = ipApi.getIpPoolPool(loginApi.getToken(), lsServer.operExtIPPoolName);
        Assert.assertFalse(ipPoolPool.ippoolPooled.isEmpty());
        ipPoolPool.ippoolPooled.forEach(System.out::println);

        loginApi.logout();
    }

    @Test
    public void testApiClientChassis3ComputeBlade2() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        ComputeBlade computeBlade =
                api.getUcsComputeBladeByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/chassis-3/blade-2", false)
                );
        System.out.println(computeBlade);
        Assert.assertEquals("ok", computeBlade.operState); //Overall Status

        Assert.assertEquals("not-applicable", computeBlade.lowVoltageMemory); //Configuration Error
        Assert.assertEquals("not-applicable", computeBlade.memorySpeed); //Configuration Error
        Assert.assertEquals("not-applicable", computeBlade.mfgTime); //Configuration Error

        Assert.assertEquals("in-service", computeBlade.adminState); // Admin State
        Assert.assertEquals("complete", computeBlade.discovery); // Discovery State
        Assert.assertEquals("unavailable", computeBlade.availability); //Avail State
        Assert.assertEquals("associated", computeBlade.association); // Association State
        Assert.assertEquals("on", computeBlade.operPower); // Power State
        Assert.assertEquals("equipped", computeBlade.presence); //Slot Status
        Assert.assertEquals("discovered", computeBlade.checkPoint); //CheckPoint

        Assert.assertEquals("operable", computeBlade.operability);

        Assert.assertEquals("sys/chassis-3/blade-2", computeBlade.dn);
        Assert.assertEquals("org-root/ls-osi01-w01-prd01-lnx15", computeBlade.assignedToDn);

        // This means both connections are available
        Assert.assertEquals(computeBlade.connPath, computeBlade.connStatus);

        loginApi.logout();
    }

    @Test
    public void testApiClientChassis3ComputeBlade3() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        ComputeBlade computeBlade =
                api.getUcsComputeBladeByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/chassis-3/blade-3", false)
                );
        System.out.println(computeBlade);

        Assert.assertEquals("sys/chassis-3/blade-3", computeBlade.dn);
        //Assert.assertEquals("discovery-failed", computeBlade.operState); //Overall Status

        Assert.assertEquals("not-applicable", computeBlade.lowVoltageMemory); //Configuration Error
        Assert.assertEquals("not-applicable", computeBlade.memorySpeed); //Configuration Error
        Assert.assertEquals("not-applicable", computeBlade.mfgTime); //Configuration Error

        Assert.assertEquals("in-service", computeBlade.adminState); // Admin State
        //Assert.assertEquals("failed", computeBlade.discovery); //Discovery State
        Assert.assertEquals("unavailable", computeBlade.availability); //Avail State
        Assert.assertEquals("none", computeBlade.association); // Association State
        Assert.assertEquals("off", computeBlade.operPower); // Power State
        Assert.assertEquals("equipped", computeBlade.presence); //Slot Status
        //Assert.assertEquals("deep-checkpoint", computeBlade.checkPoint); //CheckPoint

        Assert.assertEquals("operable", computeBlade.operability);

        // This means both connections are available
        Assert.assertEquals(computeBlade.connPath, computeBlade.connStatus);
        loginApi.logout();
    }

    @Test
    public void testConfigApiServiceProfileByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        String serviceProfile =
                api.getUcsEntityByDn(loginApi.getToken(),"org-root/ls-osi01-w01-prd01-lnx15", true);
        LOG.info("{}", serviceProfile);
        loginApi.logout();
    }

    @Test
    public void testApiClientComputeRackUnit1() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        ComputeRackUnit computeRackUnit =
                api.getUcsComputeRackUnitByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/rack-unit-1", false)
                );
        System.out.println(computeRackUnit);

        Assert.assertEquals("unassociated", computeRackUnit.operState); //Overall Status

        Assert.assertEquals("not-applicable", computeRackUnit.lowVoltageMemory); //Configuration Error
        Assert.assertEquals("not-applicable", computeRackUnit.memorySpeed); //Configuration Error
        Assert.assertEquals("not-applicable", computeRackUnit.mfgTime); //Configuration Error

        Assert.assertEquals("in-service", computeRackUnit.adminState); // Admin State
        Assert.assertEquals("complete", computeRackUnit.discovery); // Discovery State
        Assert.assertEquals("available", computeRackUnit.availability); //Avail State
        Assert.assertEquals("none", computeRackUnit.association); // Association State
        Assert.assertEquals("off", computeRackUnit.operPower); // Power State
        Assert.assertEquals("equipped", computeRackUnit.presence); //Slot Status
        Assert.assertEquals("discovered", computeRackUnit.checkPoint); //CheckPoint

        Assert.assertEquals("operable", computeRackUnit.operability);

        Assert.assertEquals("sys/rack-unit-1", computeRackUnit.dn);

        // This means both connections are available
        Assert.assertEquals(computeRackUnit.connPath, computeRackUnit.connStatus);

        loginApi.logout();
    }

    @Test
    public void testApiClientComputeRackUnit8() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        ComputeRackUnit computeRackUnit =
                api.getUcsComputeRackUnitByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/rack-unit-8", false)
                );
        System.out.println(computeRackUnit);

        Assert.assertEquals("unassociated", computeRackUnit.operState); //Overall Status

        Assert.assertEquals("not-applicable", computeRackUnit.lowVoltageMemory); //Configuration Error
        Assert.assertEquals("not-applicable", computeRackUnit.memorySpeed); //Configuration Error
        Assert.assertEquals("not-applicable", computeRackUnit.mfgTime); //Configuration Error

        Assert.assertEquals("in-service", computeRackUnit.adminState); // Admin State
        Assert.assertEquals("complete", computeRackUnit.discovery); // Discovery State
        Assert.assertEquals("available", computeRackUnit.availability); //Avail State
        Assert.assertEquals("none", computeRackUnit.association); // Association State
        Assert.assertEquals("off", computeRackUnit.operPower); // Power State
        Assert.assertEquals("equipped", computeRackUnit.presence); //Slot Status
        Assert.assertEquals("discovered", computeRackUnit.checkPoint); //CheckPoint

        Assert.assertEquals("operable", computeRackUnit.operability);

        Assert.assertEquals("sys/rack-unit-8", computeRackUnit.dn);

        // This means both connections are available
        Assert.assertEquals(computeRackUnit.connPath, computeRackUnit.connStatus);

        loginApi.logout();
    }

    @Test
    public void testApiClientComputeRackUnit9() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        ComputeRackUnit computeRackUnit =
                api.getUcsComputeRackUnitByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/rack-unit-9", false)
                );
        System.out.println(computeRackUnit);

        Assert.assertEquals("unassociated", computeRackUnit.operState); //Overall Status

        Assert.assertEquals("not-applicable", computeRackUnit.lowVoltageMemory); //Configuration Error
        Assert.assertEquals("not-applicable", computeRackUnit.memorySpeed); //Configuration Error
        Assert.assertEquals("not-applicable", computeRackUnit.mfgTime); //Configuration Error

        Assert.assertEquals("in-service", computeRackUnit.adminState); // Admin State
        Assert.assertEquals("complete", computeRackUnit.discovery); // Discovery State
        Assert.assertEquals("available", computeRackUnit.availability); //Avail State
        Assert.assertEquals("none", computeRackUnit.association); // Association State
        Assert.assertEquals("off", computeRackUnit.operPower); // Power State
        Assert.assertEquals("equipped", computeRackUnit.presence); //Slot Status
        Assert.assertEquals("discovered", computeRackUnit.checkPoint); //CheckPoint

        Assert.assertEquals("operable", computeRackUnit.operability);

        Assert.assertEquals("sys/rack-unit-9", computeRackUnit.dn);

        // This means both connections are available
        Assert.assertEquals(computeRackUnit.connPath, computeRackUnit.connStatus);

        loginApi.logout();
    }

    @Test
    public void testApiEquipmentChassis3() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        EquipmentChassis equipment =
                api.getUcsEquipmentChassisByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/chassis-3", false)
                );
        System.out.println(equipment);
        /*
        --Chassis
Overall Status	:	Operable

Configuration Error	:	not-applicable
Configuration State	:	OK
Operability	:	Operable
Power	:	OK
Thermal	:	OK
         */

        Assert.assertEquals("operable", equipment.operState); //Overall Status

        Assert.assertEquals("not-applicable", equipment.mfgTime); //Configuration Error
        Assert.assertEquals("ok", equipment.configState); //Configuration State
        Assert.assertEquals("operable", equipment.operability); //Operability
        Assert.assertEquals("ok", equipment.power); // Power
        Assert.assertEquals("ok", equipment.thermal); // Thermal


        Assert.assertEquals("acknowledged", equipment.adminState); // Admin State
        Assert.assertEquals("undiscovered", equipment.discovery); // Discovery State
        Assert.assertEquals("unavailable", equipment.availability); //Avail State
        Assert.assertEquals("none", equipment.association); // Association State
        Assert.assertEquals("unknown", equipment.presence); //Slot Status
        Assert.assertEquals("in-service",  equipment.serviceState); //CheckPoint



        Assert.assertEquals("sys/chassis-3", equipment.dn);

        // This means both connections are available
        Assert.assertEquals(equipment.connPath, equipment.connStatus);

        loginApi.logout();
    }

    @Test
    public void testApiEquipmentChassis4() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        EquipmentChassis equipment =
                api.getUcsEquipmentChassisByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/chassis-4", false)
                );
        System.out.println(equipment);
        /*
        --Chassis
Overall Status	:	Operable

Configuration Error	:	not-applicable
Configuration State	:	OK
Operability	:	Operable
Power	:	OK
Thermal	:	OK
         */

        Assert.assertEquals("operable", equipment.operState); //Overall Status

        Assert.assertEquals("not-applicable", equipment.mfgTime); //Configuration Error
        Assert.assertEquals("ok", equipment.configState); //Configuration State
        Assert.assertEquals("operable", equipment.operability); //Operability
        Assert.assertEquals("ok", equipment.power); // Power
        Assert.assertEquals("ok", equipment.thermal); // Thermal


        Assert.assertEquals("acknowledged", equipment.adminState); // Admin State
        Assert.assertEquals("undiscovered", equipment.discovery); // Discovery State
        Assert.assertEquals("unavailable", equipment.availability); //Avail State
        Assert.assertEquals("none", equipment.association); // Association State
        Assert.assertEquals("unknown", equipment.presence); //Slot Status
        Assert.assertEquals("in-service",  equipment.serviceState); //CheckPoint



        Assert.assertEquals("sys/chassis-4", equipment.dn);

        // This means both connections are available
        Assert.assertEquals(equipment.connPath, equipment.connStatus);

        loginApi.logout();
    }

    @Test
    public void testApiEquipmentFex1() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        EquipmentFex equipment =
                api.getUcsEquipmentFexByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/fex-1", false)
                );
        System.out.println(equipment);
        /*
Overall Status	:	Operable
Configuration Error	:	not-applicable
Power	:	N/A
Voltage	:	N/A
Thermal	:	N/A
         */
        Assert.assertEquals("operable", equipment.operState); //Overall Status

        Assert.assertEquals("unknown", equipment.power); // Power
        Assert.assertEquals("unknown", equipment.voltage); // Voltage
        Assert.assertEquals("unknown", equipment.thermal); // Thermal


        Assert.assertEquals("un-acknowledged", equipment.configState); //Configuration State
        Assert.assertEquals("acknowledged", equipment.adminState);
        Assert.assertEquals("unknown", equipment.presence);
        Assert.assertEquals("unknown", equipment.operability); //


        Assert.assertEquals("sys/fex-1", equipment.dn);
        Assert.assertEquals(1,equipment.id);
        Assert.assertEquals("A",equipment.switchId);
        loginApi.logout();
    }


    @Test
    public void testApiEquipmentFex2() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        EquipmentFex equipment =
                api.getUcsEquipmentFexByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/fex-2", false)
                );
        System.out.println(equipment);
        /*
Overall Status	:	Operable
Configuration Error	:	not-applicable
Power	:	N/A
Voltage	:	N/A
Thermal	:	N/A
         */
        Assert.assertEquals("operable", equipment.operState); //Overall Status

        Assert.assertEquals("unknown", equipment.power); // Power
        Assert.assertEquals("unknown", equipment.voltage); // Voltage
        Assert.assertEquals("unknown", equipment.thermal); // Thermal


        Assert.assertEquals("un-acknowledged", equipment.configState); //Configuration State
        Assert.assertEquals("acknowledged", equipment.adminState);
        Assert.assertEquals("unknown", equipment.presence);
        Assert.assertEquals("unknown", equipment.operability); //


        Assert.assertEquals("sys/fex-2", equipment.dn);
        Assert.assertEquals(2,equipment.id);
        Assert.assertEquals("B",equipment.switchId);
        loginApi.logout();
    }

    @Test
    public void testApiEquipmentRackEnclosure1() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        EquipmentRackEnclosure equipment =
                api.getUcsEquipmentRackEnclosureByResponse(
                        api.getUcsEntityByDn(loginApi.getToken(), "sys/rack-enclosure-1", false)
                );
        System.out.println(equipment);
        Assert.assertEquals("operable", equipment.operability); //Overall Status
        Assert.assertEquals("not-applicable", equipment.mfgTime);
        Assert.assertEquals("equipped", equipment.presence);

        Assert.assertEquals("sys/rack-enclosure-1", equipment.dn);
        loginApi.logout();
    }

    @Test
    public void testApiNetworkElementA() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        NetworkElement networkElement =
                api.getUcsNetworkElementByResponse(
                        api.getUcsEntityByDn(
                                loginApi.getToken(), "sys/switch-A", false)
                );
        /*
Overall Status	:	Operable
Thermal	:	N/A
Ethernet Mode	:	End Host
FC Mode	:	End Host
Admin Evac Mode	:	Off
Oper Evac Mode	:	Off
         */

        System.out.println(networkElement);
        Assert.assertEquals("operable", networkElement.operability); //Overall Status
        Assert.assertEquals("unknown", networkElement.thermal); // Thermal

        Assert.assertEquals("fill", networkElement.adminEvacState); // EVAC
        Assert.assertEquals("fill", networkElement.operEvacState); //  EVAC
        Assert.assertEquals("no", networkElement.forceEvac); //  EVAC

        Assert.assertEquals(0, networkElement.inbandIfVnet);
        Assert.assertEquals("0.0.0.0", networkElement.inbandIfGw);
        Assert.assertEquals("0.0.0.0", networkElement.inbandIfIp);
        Assert.assertEquals("0.0.0.0", networkElement.inbandIfMask);

        Assert.assertEquals("10.172.192.1", networkElement.oobIfGw);
        Assert.assertEquals("10.172.192.22", networkElement.oobIfIp);
        Assert.assertEquals("00:00:00:00:00:00", networkElement.oobIfMac);
        Assert.assertEquals("255.255.255.0", networkElement.oobIfMask);

        Assert.assertEquals("sys/switch-A", networkElement.dn);
        Assert.assertEquals("A", networkElement.id);
        loginApi.logout();
    }

    @Test
    public void testApiNetworkElementB() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        NetworkElement networkElement =
                api.getUcsNetworkElementByResponse(
                        api.getUcsEntityByDn(
                                loginApi.getToken(), "sys/switch-B", false)
                );
        /*
Overall Status	:	Operable
Thermal	:	N/A
Ethernet Mode	:	End Host
FC Mode	:	End Host
Admin Evac Mode	:	Off
Oper Evac Mode	:	Off
         */

        System.out.println(networkElement);
        Assert.assertEquals("operable", networkElement.operability); //Overall Status
        Assert.assertEquals("unknown", networkElement.thermal); // Thermal

        Assert.assertEquals("fill", networkElement.adminEvacState); // EVAC
        Assert.assertEquals("fill", networkElement.operEvacState); //  EVAC
        Assert.assertEquals("no", networkElement.forceEvac); //  EVAC


        Assert.assertEquals("sys/switch-B", networkElement.dn);
        Assert.assertEquals("B", networkElement.id);

        Assert.assertEquals(0, networkElement.inbandIfVnet);
        Assert.assertEquals("0.0.0.0", networkElement.inbandIfGw);
        Assert.assertEquals("0.0.0.0", networkElement.inbandIfIp);
        Assert.assertEquals("0.0.0.0", networkElement.inbandIfMask);

        Assert.assertEquals("10.172.192.1", networkElement.oobIfGw);
        Assert.assertEquals("10.172.192.21", networkElement.oobIfIp);
        Assert.assertEquals("00:00:00:00:00:00", networkElement.oobIfMac);
        Assert.assertEquals("255.255.255.0", networkElement.oobIfMask);

        loginApi.logout();
    }

    @Test
    public void testApiNetworkElementDnFullHierarchicalTrue() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        String response = api.getUcsEntityByDn(loginApi.getToken(), "sys/switch-A", true);
        LOG.info("{}", response);
        System.out.println(response);
        loginApi.logout();
    }

    @Test
    public void testApiNetworkElementNotExistByDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        String response = api.getUcsEntityByDn(loginApi.getToken(), "sys/switch-K", false);
        LOG.info("{}", response);
        Assert.assertNull(api.getUcsNetworkElementByResponse(response));
        loginApi.logout();
    }

    @Test
    public void testApiExistDnButIsUnsupported() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        try {
            loginApi.login();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        ConfigApi api = new ConfigApi(apiClient,credentials.url);
        String response = api.getUcsEntityByDn(loginApi.getToken(), "sys/chassis-4/psu-4", false);
        LOG.info("{}", response);
        try {
            api.getUcsNetworkElementByResponse(response);
            Assert.fail();
        } catch (ApiException e) {
            LOG.error("ok: {}", e.getMessage(),e);
        }
        loginApi.logout();
    }

    @Test
    public void testEventSubscriptionRequest() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        loginApi.keepAlive();
        try {
            apiClient.doPost(UcsXmlApiRequest.getEventSubscriptionRequest(loginApi.getToken()),credentials.url);
        } catch (ApiException e) {
            LOG.error("{}", e.getMessage());
        }
        loginApi.logout();
    }

    @Test
    public void testEventUnSubscriptionRequest() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        loginApi.login();
        try {
            apiClient.doPost(UcsXmlApiRequest.getEventUnsubscribeRequest(loginApi.getToken()),credentials.url);
        } catch (ApiException e) {
            LOG.error("{}", e.getMessage());
        }
        loginApi.logout();
    }

    @Test
    public void asyncDoPostTest() throws IOException, ApiException, InterruptedException {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                LOG.error("doAsyncPost: {}", e.getMessage(), e);
                throw new RuntimeException("doPost: " + e.getMessage(), e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                assert response.body() != null;
                LOG.debug("doAsyncPost: {}", response.body().string());
            }
        };
        XmlMapper mapper = new CustomXmlMapper();
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        String loginResponse = apiClient.doPost(UcsXmlApiRequest.getLoginRequest(credentials.username,credentials.password), credentials.url);
        AaaLoginResponse aaaLoginResponse =  mapper.readValue(loginResponse,AaaLoginResponse.class);
        String token = aaaLoginResponse.outCookie;
        apiClient.doAsyncPost(UcsXmlApiRequest.getConfigFindDnsByClassIdRequest(token, UcsEnums.NamingClassId.faultInst), credentials.url, callback);
        apiClient.doAsyncPost(UcsXmlApiRequest.getConfigFindDnsByClassIdRequest(token, UcsEnums.NamingClassId.fcErrStats), credentials.url, callback);
        apiClient.doAsyncPost(UcsXmlApiRequest.getConfigFindDnsByClassIdRequest(token, UcsEnums.NamingClassId.fcpoolAddr), credentials.url, callback);
        Thread.sleep(20000);

        apiClient.doPost(UcsXmlApiRequest.getLogoutRequest(token), credentials.url);
    }

    @Test
    public void inFilterTest() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials, apiClient);
        loginApi.login();
        UcsXmlApiRequest.InFilter eqFilter = UcsXmlApiRequest.getEqFilter(UcsEnums.NamingClassId.lsServer, "assocState", "associated");
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), eqFilter, UcsEnums.NamingClassId.lsServer ),credentials.url);
        UcsXmlApiRequest.InFilter neFilter = UcsXmlApiRequest.getNeFilter(UcsEnums.NamingClassId.lsServer, "assignState", "assigned");
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), neFilter, UcsEnums.NamingClassId.lsServer ), credentials.url);
        UcsXmlApiRequest.InFilter gtFilter = UcsXmlApiRequest.getGtFilter(UcsEnums.NamingClassId.memoryArray, "currCapacity", 1024);
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), gtFilter, UcsEnums.NamingClassId.memoryArray ),credentials.url);
        UcsXmlApiRequest.InFilter geFilter = UcsXmlApiRequest.getGeFilter(UcsEnums.NamingClassId.memoryArray, "currCapacity", 2048);
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), geFilter, UcsEnums.NamingClassId.memoryArray ),credentials.url);
        UcsXmlApiRequest.InFilter ltFilter = UcsXmlApiRequest.getLtFilter(UcsEnums.NamingClassId.memoryArray, "currCapacity", 1024);
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), ltFilter, UcsEnums.NamingClassId.memoryArray ),credentials.url);
        UcsXmlApiRequest.InFilter leFilter = UcsXmlApiRequest.getLeFilter(UcsEnums.NamingClassId.memoryArray, "currCapacity", 2048);
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), leFilter, UcsEnums.NamingClassId.memoryArray ),credentials.url);
        UcsXmlApiRequest.InFilter wCardFilter = UcsXmlApiRequest.getWCardFilter(UcsEnums.NamingClassId.adaptorUnit, "serial","QCI1.*");
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), wCardFilter, UcsEnums.NamingClassId.adaptorUnit ),credentials.url);
        UcsXmlApiRequest.InFilter anyBitFilter = UcsXmlApiRequest.getAnyBitFilter(UcsEnums.NamingClassId.computeItem, "connStatus","A,B");
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), anyBitFilter, UcsEnums.NamingClassId.computeItem ),credentials.url);
        UcsXmlApiRequest.InFilter allBitFilter = UcsXmlApiRequest.getAllBitFilter(UcsEnums.NamingClassId.lsServer, "configQualifier", "vnic-capacity,vhba-capacity");
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), allBitFilter, UcsEnums.NamingClassId.lsServer ),credentials.url);

        UcsXmlApiRequest.InFilter andEq1Filter = UcsXmlApiRequest.getEqFilter(UcsEnums.NamingClassId.uuidpoolAddr, "owner","pool");
        UcsXmlApiRequest.InFilter andEq2Filter = UcsXmlApiRequest.getEqFilter(UcsEnums.NamingClassId.uuidpoolAddr, "assigned","yes");
        UcsXmlApiRequest.InFilter andFilter = UcsXmlApiRequest.getAndFilter(new UcsXmlApiRequest.InFilter[] {andEq1Filter,andEq2Filter});
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), andFilter, UcsEnums.NamingClassId.uuidpoolAddr ),credentials.url);


        UcsXmlApiRequest.InFilter orEq1Filter = UcsXmlApiRequest.getEqFilter(UcsEnums.NamingClassId.computeItem, "slotId", "1");
        UcsXmlApiRequest.InFilter orEq2Filter = UcsXmlApiRequest.getEqFilter(UcsEnums.NamingClassId.computeItem, "slotId", "8");
        UcsXmlApiRequest.InFilter orFilter = UcsXmlApiRequest.getOrFilter(new UcsXmlApiRequest.InFilter[] {orEq1Filter,orEq2Filter});
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), orFilter, UcsEnums.NamingClassId.computeItem ),credentials.url);

        UcsXmlApiRequest.InFilter betweenFilter = UcsXmlApiRequest.getBetweenFilter(UcsEnums.NamingClassId.memoryArray, "populated", 1, 5);
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), betweenFilter, UcsEnums.NamingClassId.memoryArray ),credentials.url);

        UcsXmlApiRequest.InFilter notFilter = UcsXmlApiRequest.getNotFilter(UcsXmlApiRequest.getAnyBitFilter(UcsEnums.NamingClassId.computeItem,"connStatus","unknown"));
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), notFilter, UcsEnums.NamingClassId.computeItem ),credentials.url);

        UcsXmlApiRequest.InFilter compositeFilter = UcsXmlApiRequest
                .getAndFilter(new UcsXmlApiRequest.InFilter[] {orFilter,
                        UcsXmlApiRequest
                                .getNotFilter(UcsXmlApiRequest.getEqFilter(UcsEnums.NamingClassId.computeItem, "chassisId", "5"))});
        apiClient.doPost(UcsXmlApiRequest.getConfigResolveClassRequest(loginApi.getToken(), compositeFilter, UcsEnums.NamingClassId.computeItem ),credentials.url);

        loginApi.logout();

    }

    @Test
    public void testUcsQueryForFaultsWithFilter() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials, apiClient);
        FaultApi faultApi = new FaultApi(apiClient,credentials.url);
        loginApi.login();
        String filterMajorString = "<eq class=\"faultInst\" property=\"highestSeverity\" value=\"major\" />";
        UcsXmlApiRequest.InFilter filterMajor = UcsXmlApiRequest.getEqFilter(UcsEnums.NamingClassId.faultInst, "highestSeverity", "major");
        Assert.assertEquals(filterMajorString, filterMajor.xml);
        List<FaultInst> faults = faultApi.getUcsFaultsByFilter(loginApi.getToken(), filterMajor);
        System.out.println(faults.size());
        faults.forEach(f-> Assert.assertEquals("major", f.highestSeverity));

        String filterCriticalString = "<eq class=\"faultInst\" property=\"highestSeverity\" value=\"critical\" />";
        UcsXmlApiRequest.InFilter filterCritical = UcsXmlApiRequest.getEqFilter(UcsEnums.NamingClassId.faultInst, "highestSeverity", "critical");
        Assert.assertEquals(filterCriticalString, filterCritical.xml);
        faults = faultApi.getUcsFaultsByFilter(loginApi.getToken(), filterCritical);
        System.out.println(faults.size());
        faults.forEach(f-> Assert.assertEquals("critical", f.highestSeverity));

        String wCard1String = "<wcard class=\"faultInst\" property=\"lastTransition\" value=\"2024-05-07T.*\" />";
        UcsXmlApiRequest.InFilter wCard1 = UcsXmlApiRequest.getWCardFilter(UcsEnums.NamingClassId.faultInst, "lastTransition","2024-05-07T.*");
        Assert.assertEquals(wCard1String,wCard1.xml);

        String wCard2String = "<wcard class=\"faultInst\" property=\"lastTransition\" value=\"2024-05-06T.*\" />";
        UcsXmlApiRequest.InFilter wCard2 = UcsXmlApiRequest.getWCardFilter(UcsEnums.NamingClassId.faultInst, "lastTransition","2024-05-06T.*");
        Assert.assertEquals(wCard2String,wCard2.xml);

        String wCard3String = "<wcard class=\"faultInst\" property=\"lastTransition\" value=\"2024-05-05T.*\" />";
        UcsXmlApiRequest.InFilter wCard3 = UcsXmlApiRequest.getWCardFilter(UcsEnums.NamingClassId.faultInst, "lastTransition","2024-05-05T.*");
        Assert.assertEquals(wCard3String,wCard3.xml);

        String wCardOrFilterString =
                "<or>\n" + wCard1String +"\n" + wCard2String + "\n" + wCard3String + "\n</or>";
        UcsXmlApiRequest.InFilter wCardFilter = UcsXmlApiRequest.getOrFilter(new UcsXmlApiRequest.InFilter[]{wCard1,wCard2,wCard3});
        Assert.assertEquals(wCardOrFilterString, wCardFilter.xml);

        faults = faultApi.getUcsFaultsByFilter(loginApi.getToken(), wCardFilter);
        System.out.println(faults.size());
        faults.forEach(System.out::println);
        faults.forEach(f -> {
            LocalDateTime now = LocalDateTime.now();
            ZoneId zone = ZoneOffset.systemDefault();
            OffsetDateTime time = f.lastTransition.toInstant().atOffset(zone.getRules().getOffset(now));
            System.out.println(f.lastTransition);
            System.out.println(time);
            Assert.assertEquals(2024,time.getYear());
            Assert.assertEquals(5,time.getMonth().getValue());
            Assert.assertTrue(5 <= time.getDayOfMonth() && time.getDayOfMonth() <=7);
        });
        loginApi.logout();
    }

    @Test
    public void testUcsQueryForFaultsInstanceDn() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials, apiClient);
        loginApi.login();
        ConfigApi configApi = new ConfigApi(apiClient,credentials.url);
        List<String> faultsDn = configApi.getDnByClassId(loginApi.getToken(), UcsEnums.NamingClassId.faultInst);
        System.out.println(faultsDn.size());
        faultsDn.forEach(System.out::println);
        String faultDn = faultsDn.get(350);
        System.out.println(faultDn);
        String response = configApi.getUcsEntityByDn(loginApi.getToken(), faultDn, false);
        System.out.println(response);
        loginApi.logout();
    }

    @Test
    public void testUcsQueryForFaults() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        FaultApi faultApi = new FaultApi(apiClient,credentials.url);
        loginApi.login();
        final Set<String> codes = new HashSet<>();
        final Set<String> causes = new HashSet<>();
        final Set<String> rules = new HashSet<>();
        final Set<String> tags = new HashSet<>();
        final Set<String> types = new HashSet<>();
        final Set<String> severities = new HashSet<>();
        final Set<String> roots = new HashSet<>();

        faultApi.getUcsFaults(loginApi.getToken()).forEach(f -> {
            codes.add(f.code);
            severities.add(f.severity);
            tags.add(f.tags);
            rules.add(f.rule);
            causes.add(f.cause);
            types.add(f.type);
            UcsDn dn = UcsDn.getDn(f.dn);
            System.out.println(dn.value);
            while (UcsDn.getParentDn(dn) != null) {
                dn = UcsDn.getParentDn(dn);
                assert dn != null;
            }
            roots.add(dn.value);

        });
        loginApi.logout();
        System.out.println(severities);
        System.out.println(codes);
        System.out.println(causes);
        System.out.println(rules);
        System.out.println(tags);
        System.out.println(types);
        System.out.println(roots);
    }

    @Test
    public void testFabricHierarchy() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        ConfigApi configApi = new ConfigApi(apiClient,credentials.url);
        loginApi.login();
        System.out.println("->"+UcsEnums.NamingClassId.fabricEp);
        configApi.getDnByClassId(loginApi.getToken(), UcsEnums.NamingClassId.fabricEp).forEach(System.out::println);
        System.out.println("--------");
        System.out.println("->"+UcsEnums.NamingClassId.fabricSan);
        configApi.getDnByClassId(loginApi.getToken(), UcsEnums.NamingClassId.fabricSan).forEach(System.out::println);
        System.out.println("--------");
        System.out.println("->"+UcsEnums.NamingClassId.fabricFcSan);
        configApi.getDnByClassId(loginApi.getToken(), UcsEnums.NamingClassId.fabricFcSan).forEach(System.out::println);
        System.out.println("--------");
        System.out.println("->"+UcsEnums.NamingClassId.fabricLan);
        configApi.getDnByClassId(loginApi.getToken(), UcsEnums.NamingClassId.fabricLan).forEach(System.out::println);
        System.out.println("--------");
        System.out.println("->"+UcsEnums.NamingClassId.fabricEthLan);
        configApi.getDnByClassId(loginApi.getToken(), UcsEnums.NamingClassId.fabricEthLan).forEach(System.out::println);
        System.out.println("--------");
        System.out.println(configApi.getUcsEntityByDn(loginApi.getToken(), "fabric/san/A",true));
        System.out.println("--------");
        System.out.println(configApi.getUcsEntityByDn(loginApi.getToken(), "fabric/lan/A",true));
        System.out.println("--------");
        loginApi.logout();
    }

    @Test
    public void testUcsFabricSanB() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        ConfigApi configApi = new ConfigApi(apiClient,credentials.url);
        loginApi.login();
        System.out.println(configApi.getUcsEntityByDn(loginApi.getToken(), "fabric/san/B",false));
        loginApi.logout();
    }

    @Test
    public void testUcsFabricLanA() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        ConfigApi configApi = new ConfigApi(apiClient,credentials.url);
        loginApi.login();
        System.out.println(configApi.getUcsEntityByDn(loginApi.getToken(), "fabric/lan/A",false));
        loginApi.logout();
    }

    @Test
    public void testDateTimeFormatter() {
        final OffsetDateTime to = OffsetDateTime.now();
        final OffsetDateTime from = to.minusDays(3);
        System.out.println(from);
        System.out.println(to);
        OffsetDateTime cur = from;
        while (cur.isBefore(to)) {
            System.out.println(cur.toString().substring(0,cur.toString().indexOf("T")+1)+".*");
            cur = cur.plusDays(1);
        }
        System.out.println(to.toString().substring(0,to.toString().indexOf("T")+1)+".*");

    }

    @Test
    public void testSwitchSystat() throws ApiException {
        ApiClientCredentials credentials = getCredentials();
        ApiClient apiClient = new ApiClient();
        apiClient.setTrustAllCertsClient();
        AaaApi loginApi = new AaaApi(credentials,apiClient);
        ConfigApi configApi = new ConfigApi(apiClient,credentials.url);
        loginApi.login();
        System.out.println(configApi.getUcsEntityByDn(loginApi.getToken(), "sys/switch-A/sysstats",false));
        loginApi.logout();
    }

    @Test
    public void testConvertProperlyFcStats() throws ApiException {
        ApiClient apiClient = new ApiClient();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(
                "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        LocalDateTime date1 = LocalDateTime.parse("Wed May 29 08:50:12 CET 2024",dateFormat);
        String response1 = " <configResolveDn dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" cookie=\"1716965139/cbf0751f-d020-49fe-b150-7f1e9719c943\" response=\"yes\"> <outConfig> <fcStats bytesRx=\"11094931231960\" bytesRxDelta=\"603704\" bytesRxDeltaAvg=\"5190927\" bytesRxDeltaMax=\"33997280\" bytesRxDeltaMin=\"405272\" bytesTx=\"217019375872\" bytesTxDelta=\"10546524\" bytesTxDeltaAvg=\"14125307\" bytesTxDeltaMax=\"22938596\" bytesTxDeltaMin=\"8662964\" dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" intervals=\"58982460\" packetsRx=\"5379210322\" packetsRxDelta=\"2646\" packetsRxDeltaAvg=\"5572\" packetsRxDeltaMax=\"19375\" packetsRxDeltaMin=\"2642\" packetsTx=\"132559706\" packetsTxDelta=\"6367\" packetsTxDeltaAvg=\"8477\" packetsTxDeltaMax=\"13247\" packetsTxDeltaMin=\"5435\" suspect=\"no\" thresholded=\"\" timeCollected=\"2024-05-29T08:49:58.166\" update=\"65547\"/> </outConfig> </configResolveDn>";
        FcStats fcStats1 = apiClient.getUcsEntity(response1, ConfigResolveDnResponseFcStats.class).outconfig.fcStats;

        LocalDateTime date2 = LocalDateTime.parse("Wed May 29 08:51:12 CET 2024", dateFormat);
        String response2 = "<configResolveDn dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" cookie=\"1716965139/cbf0751f-d020-49fe-b150-7f1e9719c943\" response=\"yes\"> <outConfig> <fcStats bytesRx=\"11094934557624\" bytesRxDelta=\"3325664\" bytesRxDeltaAvg=\"5035488\" bytesRxDeltaMax=\"33997280\" bytesRxDeltaMin=\"405272\" bytesTx=\"217035185828\" bytesTxDelta=\"15809956\" bytesTxDeltaAvg=\"14265694\" bytesTxDeltaMax=\"22938596\" bytesTxDeltaMin=\"8662964\" dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" intervals=\"58982460\" packetsRx=\"5379215194\" packetsRxDelta=\"4872\" packetsRxDeltaAvg=\"5513\" packetsRxDeltaMax=\"19375\" packetsRxDeltaMin=\"2642\" packetsTx=\"132569169\" packetsTxDelta=\"9463\" packetsTxDeltaAvg=\"8559\" packetsTxDeltaMax=\"13247\" packetsTxDeltaMin=\"5435\" suspect=\"no\" thresholded=\"\" timeCollected=\"2024-05-29T08:50:58.166\" update=\"65548\"/> </outConfig> </configResolveDn>";
        FcStats fcStats2 = apiClient.getUcsEntity(response2, ConfigResolveDnResponseFcStats.class).outconfig.fcStats;

        LocalDateTime date3 = LocalDateTime.parse("Wed May 29 08:52:12 CET 2024", dateFormat);
        Assert.assertEquals(date3.minus(Duration.ofMinutes(1)),date2);
        String response3 = "<configResolveDn dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" cookie=\"1716965139/cbf0751f-d020-49fe-b150-7f1e9719c943\" response=\"yes\"> <outConfig> <fcStats bytesRx=\"11094935161472\" bytesRxDelta=\"603848\" bytesRxDeltaAvg=\"4694592\" bytesRxDeltaMax=\"33997280\" bytesRxDeltaMin=\"405272\" bytesTx=\"217044393056\" bytesTxDelta=\"9207228\" bytesTxDeltaAvg=\"13876581\" bytesTxDeltaMax=\"22938596\" bytesTxDeltaMin=\"8662964\" dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" intervals=\"58982460\" packetsRx=\"5379217734\" packetsRxDelta=\"2540\" packetsRxDeltaAvg=\"5284\" packetsRxDeltaMax=\"19375\" packetsRxDeltaMin=\"2540\" packetsTx=\"132574866\" packetsTxDelta=\"5697\" packetsTxDeltaAvg=\"8338\" packetsTxDeltaMax=\"13247\" packetsTxDeltaMin=\"5435\" suspect=\"no\" thresholded=\"\" timeCollected=\"2024-05-29T08:51:58.166\" update=\"65549\"/> </outConfig> </configResolveDn>";
        FcStats fcStats3 = apiClient.getUcsEntity(response3, ConfigResolveDnResponseFcStats.class).outconfig.fcStats;

        LocalDateTime date4 = LocalDateTime.parse("Wed May 29 08:53:12 CET 2024", dateFormat);
        String response4 = "<configResolveDn dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" cookie=\"1716965139/cbf0751f-d020-49fe-b150-7f1e9719c943\" response=\"yes\"> <outConfig> <fcStats bytesRx=\"11094937981760\" bytesRxDelta=\"2820288\" bytesRxDeltaAvg=\"4560713\" bytesRxDeltaMax=\"33997280\" bytesRxDeltaMin=\"405272\" bytesTx=\"217069806488\" bytesTxDelta=\"25413432\" bytesTxDeltaAvg=\"14700641\" bytesTxDeltaMax=\"25413432\" bytesTxDeltaMin=\"8662964\" dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" intervals=\"58982460\" packetsRx=\"5379223147\" packetsRxDelta=\"5413\" packetsRxDeltaAvg=\"5293\" packetsRxDeltaMax=\"19375\" packetsRxDeltaMin=\"2540\" packetsTx=\"132589206\" packetsTxDelta=\"14340\" packetsTxDeltaAvg=\"8766\" packetsTxDeltaMax=\"14340\" packetsTxDeltaMin=\"5435\" suspect=\"no\" thresholded=\"\" timeCollected=\"2024-05-29T08:52:58.166\" update=\"65550\"/> </outConfig> </configResolveDn>";
        FcStats fcStats4 = apiClient.getUcsEntity(response4, ConfigResolveDnResponseFcStats.class).outconfig.fcStats;

        LocalDateTime date5 = LocalDateTime.parse("Wed May 29 08:54:12 CET 2024", dateFormat);
        String response5 = " <configResolveDn dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" cookie=\"1716965139/cbf0751f-d020-49fe-b150-7f1e9719c943\" response=\"yes\"> <outConfig> <fcStats bytesRx=\"11094938674868\" bytesRxDelta=\"693108\" bytesRxDeltaAvg=\"4302872\" bytesRxDeltaMax=\"33997280\" bytesRxDeltaMin=\"405272\" bytesTx=\"217080137016\" bytesTxDelta=\"10330528\" bytesTxDeltaAvg=\"14409300\" bytesTxDeltaMax=\"25413432\" bytesTxDeltaMin=\"8662964\" dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" intervals=\"58982460\" packetsRx=\"5379225943\" packetsRxDelta=\"2796\" packetsRxDeltaAvg=\"5126\" packetsRxDeltaMax=\"19375\" packetsRxDeltaMin=\"2540\" packetsTx=\"132595608\" packetsTxDelta=\"6402\" packetsTxDeltaAvg=\"8608\" packetsTxDeltaMax=\"14340\" packetsTxDeltaMin=\"5435\" suspect=\"no\" thresholded=\"\" timeCollected=\"2024-05-29T08:53:58.166\" update=\"131072\"/> </outConfig> </configResolveDn>";
        FcStats fcStats5 = apiClient.getUcsEntity(response5, ConfigResolveDnResponseFcStats.class).outconfig.fcStats;

        LocalDateTime date6 = LocalDateTime.parse("Wed May 29 08:55:12 CET 2024", dateFormat);
        String response6 = "<configResolveDn dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" cookie=\"1716965139/cbf0751f-d020-49fe-b150-7f1e9719c943\" response=\"yes\"> <outConfig> <fcStats bytesRx=\"11094940570128\" bytesRxDelta=\"1895260\" bytesRxDeltaAvg=\"1895260\" bytesRxDeltaMax=\"1895260\" bytesRxDeltaMin=\"1895260\" bytesTx=\"217088341188\" bytesTxDelta=\"8204172\" bytesTxDeltaAvg=\"8204172\" bytesTxDeltaMax=\"8204172\" bytesTxDeltaMin=\"8204172\" dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" intervals=\"58982460\" packetsRx=\"5379229336\" packetsRxDelta=\"3393\" packetsRxDeltaAvg=\"3393\" packetsRxDeltaMax=\"3393\" packetsRxDeltaMin=\"3393\" packetsTx=\"132600821\" packetsTxDelta=\"5213\" packetsTxDeltaAvg=\"5213\" packetsTxDeltaMax=\"5213\" packetsTxDeltaMin=\"5213\" suspect=\"no\" thresholded=\"\" timeCollected=\"2024-05-29T08:54:58.166\" update=\"131073\"/> </outConfig> </configResolveDn>";
        FcStats fcStats6 = apiClient.getUcsEntity(response6, ConfigResolveDnResponseFcStats.class).outconfig.fcStats;

        LocalDateTime date7 = LocalDateTime.parse("Wed May 29 09:00:13 CET 2024", dateFormat);
        String response7 = " <configResolveDn dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" cookie=\"1716965139/cbf0751f-d020-49fe-b150-7f1e9719c943\" response=\"yes\"> <outConfig> <fcStats bytesRx=\"11095013052436\" bytesRxDelta=\"1905728\" bytesRxDeltaAvg=\"12396261\" bytesRxDeltaMax=\"64422124\" bytesRxDeltaMin=\"916700\" bytesTx=\"217202319092\" bytesTxDelta=\"17934896\" bytesTxDeltaAvg=\"20363679\" bytesTxDeltaMax=\"31086572\" bytesTxDeltaMin=\"8204172\" dn=\"sys/switch-A/slot-1/switch-fc/port-1/stats\" intervals=\"58982460\" packetsRx=\"5379284030\" packetsRxDelta=\"3903\" packetsRxDeltaAvg=\"9679\" packetsRxDeltaMax=\"37454\" packetsRxDeltaMin=\"3393\" packetsTx=\"132667049\" packetsTxDelta=\"10130\" packetsTxDeltaAvg=\"11905\" packetsTxDeltaMax=\"19125\" packetsTxDeltaMin=\"5213\" suspect=\"no\" thresholded=\"\" timeCollected=\"2024-05-29T08:59:58.166\" update=\"131078\"/> </outConfig> </configResolveDn>";
        FcStats fcStats7 = apiClient.getUcsEntity(response7, ConfigResolveDnResponseFcStats.class).outconfig.fcStats;


        System.out.println(date1);
        System.out.println(LocalDateTime.ofInstant(fcStats1.timeCollected.toInstant(), ZoneId.of("UTC")));
        System.out.println();

        System.out.println(date2);
        System.out.println(LocalDateTime.ofInstant(fcStats2.timeCollected.toInstant(), ZoneId.of("UTC")));
        System.out.println();

        System.out.println(date3);
        System.out.println(LocalDateTime.ofInstant(fcStats3.timeCollected.toInstant(), ZoneId.of("UTC")));
        System.out.println();

        System.out.println(date4);
        System.out.println(LocalDateTime.ofInstant(fcStats4.timeCollected.toInstant(), ZoneId.of("UTC")));
        System.out.println();

        System.out.println(date5);
        System.out.println(LocalDateTime.ofInstant(fcStats5.timeCollected.toInstant(), ZoneId.of("UTC")));
        System.out.println();

        System.out.println(date6);
        System.out.println(LocalDateTime.ofInstant(fcStats6.timeCollected.toInstant(), ZoneId.of("UTC")));
        System.out.println();

        System.out.println(date7);
        System.out.println(LocalDateTime.ofInstant(fcStats7.timeCollected.toInstant(), ZoneId.of("UTC")));
        System.out.println();

        Assert.assertEquals(date2.minus(Duration.ofMinutes(1)),date1);
        Assert.assertEquals(date3.minus(Duration.ofMinutes(1)),date2);
        Assert.assertEquals(date4.minus(Duration.ofMinutes(1)),date3);
        Assert.assertEquals(date5.minus(Duration.ofMinutes(1)),date4);
        Assert.assertEquals(date6.minus(Duration.ofMinutes(1)),date5);
        Assert.assertEquals(date7.minus(Duration.ofMinutes(5)),date6.plus(Duration.ofSeconds(1)));

        Assert.assertEquals(fcStats2.bytesRx-fcStats1.bytesRx,fcStats2.bytesRxDelta);
        Assert.assertEquals(fcStats3.bytesRx-fcStats2.bytesRx,fcStats3.bytesRxDelta);
        Assert.assertEquals(fcStats4.bytesRx-fcStats3.bytesRx,fcStats4.bytesRxDelta);
        Assert.assertEquals(fcStats5.bytesRx-fcStats4.bytesRx,fcStats5.bytesRxDelta);
        Assert.assertEquals(fcStats6.bytesRx-fcStats5.bytesRx,fcStats6.bytesRxDelta);
        Assert.assertNotEquals(fcStats7.bytesRx-fcStats6.bytesRx,fcStats7.bytesRxDelta);

        Assert.assertEquals(fcStats1.intervals, fcStats2.intervals);
        Assert.assertEquals(fcStats3.intervals, fcStats2.intervals);
        Assert.assertEquals(fcStats4.intervals, fcStats2.intervals);
        Assert.assertEquals(fcStats5.intervals, fcStats2.intervals);
        Assert.assertEquals(fcStats6.intervals, fcStats2.intervals);
        Assert.assertEquals(fcStats7.intervals, fcStats2.intervals);

        Assert.assertEquals(fcStats2.update, fcStats1.update+1);
        Assert.assertEquals(fcStats3.update, fcStats2.update+1);
        Assert.assertEquals(fcStats4.update, fcStats3.update+1);
        Assert.assertNotEquals(fcStats5.update, fcStats4.update+1);
        Assert.assertEquals(fcStats6.update, fcStats5.update+1);
        Assert.assertEquals(fcStats7.update, fcStats6.update+5);

    }

    @Test
    public void testConfigScopeRequest() {
        String request = UcsXmlApiRequest.getConfigScopeRequest("real_cookie", "sys/chassis-1/blade-1/board/cpu-2", UcsEnums.NamingClassId.processorEnvStats);
        Assert.assertEquals("<configScope cookie=\"real_cookie\" inHierarchical=\"false\" dn=\"sys/chassis-1/blade-1/board/cpu-2\" inClass=\"processorEnvStats\" />",request);
    }
}