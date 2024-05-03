package it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ErrorResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.UcsXmlApiResponse;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class ApiClient {

    private static final Logger LOG = LoggerFactory.getLogger(ApiClient.class);
    private static final MediaType XML = MediaType.parse("text/xml");
    private final String url;

    private OkHttpClient client = new OkHttpClient();
    private final XmlMapper mapper = new XmlMapper();
    /*
     * This is very bad practice and should NOT be used in production.
     */
    private static final TrustManager[] trustAllCerts = new TrustManager[] {
            new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
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
        builder.hostnameVerifier((hostname, session) -> true);
        return builder.build();
    }

    public ApiClient(String url) {
        this.url = Objects.requireNonNull(url);
    }

    public void setTrustAllCertsClient() {
        this.client = trustAllSslClient(this.client);
    }

    public String doPost(String requestBody) throws ApiException {
        LOG.debug("doPost: url: {}, requestBody: {}", url, requestBody);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "*/*")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", ApiClient.class.getCanonicalName())
                .post(RequestBody.create(XML, requestBody))
                .build();

        try {
            try (Response response = client.newCall(request).execute()) {
                LOG.debug("doPost: {}", response);
                if (response.code() != 200) {
                    if (response.body() != null)
                        throw new ApiException("doPost Error: ", new RuntimeException("cannot execute command"), response.code(), response.headers().toMultimap(),response.body().string());
                    else
                        throw new ApiException("doPost Error: ", new RuntimeException("cannot execute command"), response.code(), response.headers().toMultimap(),"");
                }
                if (response.body() == null) {
                    LOG.error("doPost : response body is null");
                    throw new ApiException("doPost Error response body is null: ", new RuntimeException("cannot execute command"), response.code(), response.headers().toMultimap(),"");
                }
                String r = response.body().string();
                LOG.debug("doPost: Body:{}", r);

                return r;
            }
        } catch (IOException e) {
            LOG.error("doPost: {}", e.getMessage(), e);
            throw new ApiException("doPost: " + e.getMessage(), e);
        }
    }

    public String getUrl() {
        return url;
    }

    public <T extends UcsXmlApiResponse> T getUcsEntity(String response, Class<T> clazz) throws ApiException {
        try {
            T t = mapper.readValue(response, clazz);
            if (t.errorCode > 0) {
                LOG.error("getUcsEntity: failed: with error code: {}, {}", t.errorCode, response);
                throw new ApiException(
                        "getUcsEntity: server responded with error: " + t.errorCode
                        ,new RuntimeException("getUcsEntity error code: " + t.errorCode)
                        , t.errorCode
                        , response);
            }
            return t;
        } catch (JsonProcessingException e) {
            LOG.error("getUcsEntity: Error Processing request: {}", e.getMessage(), e);
            try {
                ErrorResponse error = mapper.readValue(response, ErrorResponse.class);
                throw new ApiException("getUcsEntity: server responded with error: " + error.invocationResult
                        ,new RuntimeException("getUcsEntity error: " + error.invocationResult)
                        , error.invocationResult
                        , error.toString());
            } catch (JsonProcessingException ex) {
                throw new ApiException("getUcsEntity: " + ex.getMessage(), ex);
            }
        }

    }

    public <T extends UcsXmlApiResponse> T getUcsXmlApiResponse(String requestBody, Class<T> clazz) throws ApiException {
        LOG.debug("getUcsXmlApiResponse: {} cast class: {} ",requestBody, clazz.getSimpleName());
        return getUcsEntity(doPost(requestBody), clazz);
    }

}
