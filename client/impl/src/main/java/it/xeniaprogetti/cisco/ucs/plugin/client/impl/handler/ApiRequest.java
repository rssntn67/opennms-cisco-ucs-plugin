package it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler;

import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class ApiRequest {
    private final String requestBody;
    private ResponseBody responseBody;

    public ApiRequest(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setResponse(Response response) throws IOException {
        this.responseBody = response.body();
    }

    public ResponseBody getResponseBody() {
        return this.responseBody;
    }
}
