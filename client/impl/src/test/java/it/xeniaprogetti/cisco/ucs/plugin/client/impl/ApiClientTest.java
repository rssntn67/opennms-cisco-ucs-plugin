package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.AaaLogin;
import okhttp3.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class ApiClientTest {

    /**
     * Verifies that the object is serialized to XML as expected.
     */
    @Test
    public void canSerializeAaaLoginToXml() throws JsonProcessingException {
        String xml = "<aaaLogin inName=\"ucspe\" inPassword=\"ucspe\"/>";
        XmlMapper mapper = new XmlMapper();
        AaaLogin aaaLogin = new AaaLogin();
        aaaLogin.setInName("ucspe");
        aaaLogin.setInPassword("ucspe");

        Assert.assertEquals(xml,mapper.writeValueAsString(aaaLogin));
    }

    @Test
    public void loginTest() throws Exception {

        ApiClient apiClient = new ApiClient();

        //apiClient.setClient(ApiClient.trustAllSslClient(apiClient.getClient()));

        AaaLogin aaaLogin = new AaaLogin();
        aaaLogin.setInName("ucspe");
        aaaLogin.setInPassword("ucspe");

        apiClient.doPost("https://10.172.192.15/nuova", aaaLogin).whenComplete((v,ex) -> {
            if (ex != null) {
                throw new RuntimeException(ex);
            } else {
                try {
                    System.out.println(v.string());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Test
    public void okHttpPostTest()  throws IOException {
          MediaType XML = MediaType.parse("text/xml");
        String xml = "<aaaLogin inName=\"ucspe\" inPassword=\"ucspe\"/>";

        RequestBody requestBody = RequestBody.create(XML,xml);

        Request request = new Request.Builder()
                    .url("https://10.172.192.15/nuova")
                    .post(requestBody)
                    .build();
        OkHttpClient client = new OkHttpClient();
        client = ApiClient.trustAllSslClient(client);
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    @Test
    public void okHttpPostTestWithXmlMapper()  throws IOException {
        MediaType XML = MediaType.parse("text/xml");
        XmlMapper mapper = new XmlMapper();
        AaaLogin aaaLogin = new AaaLogin();
        aaaLogin.setInName("ucspe");
        aaaLogin.setInPassword("ucspe");

        RequestBody requestBody = RequestBody.create(XML,mapper.writeValueAsString(aaaLogin));

        Request request = new Request.Builder()
                .url("https://10.172.192.15/nuova")
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        client = ApiClient.trustAllSslClient(client);
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

}
