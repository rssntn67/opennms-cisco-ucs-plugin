package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;

public class XmlApiClientTest {

    private final static Logger LOG = LoggerFactory.getLogger(XmlApiClientTest.class);

    private static ApiClientCredentials getCredentials(int validity) {
        return ApiClientCredentials.builder()
                .withUrl("https://10.172.192.15/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .withValidity(validity)
                .build();
    }

    @Test
    public void testValidate() {
        ApiClientCredentials credentials = getCredentials(30);
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        Assert.assertTrue(clientProvider.validate(credentials));
    }

    @Test
    public void testXmlClientServiceCheckCredentials() throws ApiException, InterruptedException {
        XmlApiClientService service = new XmlApiClientService(getCredentials(550));
        //Should do login
        service.checkCredentials();
        LOG.info("sleeping 30sec {}", OffsetDateTime.now());
        Thread.sleep(30000);
        LOG.info("waked up {}", OffsetDateTime.now());
        //Should do nothing
        service.checkCredentials();

        LOG.info("sleeping 30sec {}", OffsetDateTime.now());
        Thread.sleep(30000);
        LOG.info("waked up {}", OffsetDateTime.now());
        //Should do refresh
        service.checkCredentials();

        LOG.info("sleeping 60sec {}", OffsetDateTime.now());
        Thread.sleep(60000);
        LOG.info("waked up {}", OffsetDateTime.now());

        //Should do logout/login
        service.checkCredentials();

        service.disconnect();

    }

    @Test
    public void testXmlClientService() throws ApiException {
        XmlApiClientService service = new XmlApiClientService(getCredentials(30));
        service.getUcsXmlFromDn("fabric/san/A", false);
        service.findDnByClassItem(UcsEnums.NamingClassId.equipmentRackEnclosure).forEach(System.out::println);

        service.findUcsIpPoolPooled().forEach(System.out::println);

        service.getUcsEquipmentChassisList().forEach(System.out::println);
        service.getUcsComputeBladeList().forEach(System.out::println);
        service.getUcsEquipmentRackEnclosureList().forEach(System.out::println);
        service.getUcsComputeRackUnitList().forEach(System.out::println);
        service.getUcsNetworkElementList().forEach(System.out::println);
        service.getUcsEquipmentFexList().forEach(System.out::println);
        LOG.info("findUcsFaultsFromDate: {}", OffsetDateTime.now());
        service.findUcsFaultsFromDate(OffsetDateTime.now().minusDays(3)).forEach(System.out::println);
        LOG.info("findAllUcsFaults: {}", OffsetDateTime.now());
        service.findAllUcsFaults().forEach(System.out::println);
        service.disconnect();
    }
}
