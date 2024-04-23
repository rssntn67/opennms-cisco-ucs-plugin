package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.ApiClientCredentials;

import com.fasterxml.jackson.core.JsonProcessingException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import javax.net.ssl.*;

public class ApiClient {

    private static final MediaType XML = MediaType.parse("application/xml");

    private final OkHttpClient client;
    private final XmlMapper mapper = new XmlMapper();
    private String url;
    private final aaaLogin aaaLogin;
    /*
     * This is very bad practice and should NOT be used in production.
     */
    private static final TrustManager[] trustAllCerts = new TrustManager[] {
            new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[]{};
                }
            }
    };
    private static final SSLContext trustAllSslContext;
    static {
        try {
            trustAllSslContext = SSLContext.getInstance("SSL");
            trustAllSslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
    }
    private static final SSLSocketFactory trustAllSslSocketFactory = trustAllSslContext.getSocketFactory();

    /*
     * This should not be used in production unless you really don't care
     * about the security. Use at your own risk.
     */
    public static OkHttpClient trustAllSslClient(OkHttpClient client) {
        OkHttpClient.Builder builder = client.newBuilder();
        builder.sslSocketFactory(trustAllSslSocketFactory, (X509TrustManager)trustAllCerts[0]);
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        return builder.build();
    }

    public ApiClient(ApiClientCredentials credentials) {
        Objects.requireNonNull(credentials);
        this.url = Objects.requireNonNull(credentials.url);
        System.out.println(this.url);
        this.aaaLogin = new aaaLogin();
        this.aaaLogin.inName = Objects.requireNonNull(credentials.username);
        this.aaaLogin.inPassword = Objects.requireNonNull(credentials.password);
        try {
            System.out.println(mapper.writeValueAsString(this.aaaLogin));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if (credentials.ignoreSslCertificateValidation) {
            this.client = trustAllSslClient(new OkHttpClient());
        } else {
            this.client = new OkHttpClient();
        }
    }

    public static class aaaLogin {
        @JacksonXmlProperty(isAttribute = true)
        public String inName;
        @JacksonXmlProperty(isAttribute = true)
        public String inPassword;
    }
    private static class ConfigResolveDn {
        public String dn;
        public String cookie;
        public boolean inHierarchical;
    }

    private static class ConfigFindDnsByClassId {
        public String classId;
        public String cookie;
    }

    public CompletableFuture<Void> aaaLogin() {
        return doPost(this.url, this.aaaLogin);
    }
    private CompletableFuture<Void> doPost(String url, Object requestBodyPayload) {
        RequestBody body;
        try {
            body = RequestBody.create(XML, mapper.writeValueAsString(requestBodyPayload));
            System.out.println("Request body: " + body.contentType());
            System.out.println("Request body: " + body.contentLength());
            System.out.println("Request body: " + body);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request request = new Request.Builder()
                .url(url)
//                .addHeader("Accept", "application/x-www-form-urlencoded")
//                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", ApiClient.class.getCanonicalName())
                .post(body)
                .build();

        CompletableFuture<Void> future = new CompletableFuture<>();
        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println("onFailure");
                        future.completeExceptionally(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) {
                        System.out.println("onResponse");
                        try {
                            if (!response.isSuccessful()) {
                                System.out.println("not successfull");
                                String bodyPayload = "(empty)";
                                ResponseBody body = response.body();
                                if (body != null) {
                                    try {
                                        bodyPayload = body.string();
                                    } catch (IOException e) {
                                        // pass
                                    }
                                    body.close();
                                }
                                future.completeExceptionally(new Exception("Request failed with response code: "
                                        + response.code() + " and body: " + bodyPayload));
                            } else {
                                System.out.println("successfull");
                                System.out.println(response.code());
                                System.out.println(response);
                                future.complete(null);
                            }
                        } finally {
                            response.close();
                        }
                    }
                });
        return future;
    }

}
