package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import org.junit.Assert;
import org.junit.Test;

import java.time.OffsetDateTime;

public class XmlApiClientTest {

    @Test
    public void testValidate() {
        ApiClientCredentials credentials = ApiClientTest.getCredentials();
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        Assert.assertTrue(clientProvider.validate(credentials));
    }

    @Test
    public void testXmlClientServiceCheckCredentials() throws ApiException, InterruptedException {
        XmlApiClientService service = new XmlApiClientService(ApiClientTest.getCredentials());
        //Should do login
        service.checkCredentials();
        Thread.sleep(300000);
        //Should do nothing
        service.checkCredentials();

        Thread.sleep(271000);
        //Should do refresh
        service.checkCredentials();

        Thread.sleep(610000);
        //Should do logout/login
        service.checkCredentials();

        service.disconnect();


        service.disconnect();

    }

    @Test
    public void testXmlClientService() throws ApiException {
        XmlApiClientService service = new XmlApiClientService(ApiClientTest.getCredentials());
        service.findDnByClassItem(UcsEnums.NamingClassId.computeItem).forEach(System.out::println);
        service.findUcsFaultsFromDate(OffsetDateTime.now().minusDays(3)).forEach(System.out::println);
        service.disconnect();
    }
}
