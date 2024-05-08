package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsFault;
import org.junit.Assert;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.util.List;

public class XmlApiClientTest {

    @Test
    public void testValidate() throws ApiException {
        ApiClientCredentials credentials = ApiClientTest.getCredentials();
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        Assert.assertTrue(clientProvider.validate(credentials));
    }

    @Test
    public void testXmlClientService() throws ApiException {
        XmlApiClientService service = new XmlApiClientService(ApiClientTest.getCredentials());
        List<String> dns = service.findDnByClassItem(UcsEnums.NamingClassId.computeItem);
        System.out.println(dns);
        List<UcsFault> ucsFaults = service.findUcsFaultsFromDate(OffsetDateTime.now().minusDays(3));
    }
}
