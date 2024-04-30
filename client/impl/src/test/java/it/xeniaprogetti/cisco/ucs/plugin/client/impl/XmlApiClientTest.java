package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import org.junit.Assert;
import org.junit.Test;

public class XmlApiClientTest {

    @Test
    public void testValidate() throws ApiException {
        ApiClientCredentials credentials = ApiClientTest.getCredentials();
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        Assert.assertTrue(clientProvider.validate(credentials));
    }
}
