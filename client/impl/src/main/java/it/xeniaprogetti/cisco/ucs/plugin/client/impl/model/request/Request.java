package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request;

import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class Request {
    private final String requestBody;
    private ResponseBody responseBody;

    public Request(String requestBody) {
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
