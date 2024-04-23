package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.ApiClientCredentials;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class ApiClientTest {

    /**
     * Verifies that the object is serialized to JSON as expected.
     */
    @Test
    public void canSerializeToXml() throws ExecutionException, InterruptedException {
        ApiClientCredentials apiClientCredentials = ApiClientCredentials.builder()
                .withUrl("https://10.172.192.15/nuova")
                .withUsername("ucspe")
                .withPassword("ucspe")
                .withIgnoreSslCertificateValidation(true).build();

        ApiClient apiClient = new ApiClient(apiClientCredentials);

        apiClient.aaaLogin().get();
    }
}
