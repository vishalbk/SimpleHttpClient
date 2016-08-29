package com.shc.ahttp.client.testpojo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "args", "headers", "json", "origin", "url" })
public class HttpBinPostResponse {

    @JsonProperty("args")
    private Map<String, String> args;

    @JsonProperty("headers")
    private Map<String, String> headers;

    @JsonProperty("json")
    private Map<String, String> json;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("url")
    private String url;

    public Map<String, String> getArgs() {
        return args;
    }

    @JsonProperty("args")
    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getJson() {
        return json;
    }

    @JsonProperty("json")
    public void setJson(Map<String, String> json) {
        this.json = json;
    }

    public String getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HttpBinPostResponse [args=" + args + ", headers=" + headers
                + ", json=" + json + ", origin=" + origin + ", url=" + url
                + "]";
    }

}
