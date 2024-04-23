package it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import okhttp3.*;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.CompletableFuture;

public class ApiClient {

    private static final MediaType XML = MediaType.parse("application/soap+xml");

    private OkHttpClient client = new OkHttpClient();
    private final XmlMapper mapper = new XmlMapper();
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

    public ApiClient() {
    }

    public OkHttpClient getClient() {
        return client;
    }
    public void setClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public CompletableFuture<ResponseBody> doPost(String url, Object requestBodyPayload) {
        RequestBody body;
        try {
            body = RequestBody.create(XML, mapper.writeValueAsString(requestBodyPayload));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "*/*")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", ApiClient.class.getCanonicalName())
                .post(body)
                .build();

        CompletableFuture<ResponseBody> future = new CompletableFuture<>();
        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        future.completeExceptionally(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) {
                        try (response) {
                            if (!response.isSuccessful()) {
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
                                future.complete(response.body());
                            }
                        }
                    }
                });
        return future;
    }

}
