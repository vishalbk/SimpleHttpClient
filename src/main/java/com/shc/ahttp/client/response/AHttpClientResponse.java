package com.shc.ahttp.client.response;

import java.util.Map;

/**
 * This class provides all the fields required to represent the state and
 * content of the response returned from a successful HTTP client call.
 *
 * @author vishalk2
 * @version $Revision: 1.0 $
 */
public class AHttpClientResponse {

    /** The response body, if any, returned from the HTTP client call */
    private String responseBody;

    /** The reason phrase, if any, returned from the HTTP client call */
    private String reasonPhrase;

    /** The status code, if any, returned from the HTTP client call */
    private int statusCode;

    /**
     * Represents if the response returned from the HTTP client call had any
     * body or not.
     */
    private boolean isBodyPresent;

    /** The response headers, if any, returned from the HTTP client call */
    private Map<String, String> responseHeaders;

    /**
     * Instantiates a new HTTP client response object with the given fields
     *
     * @param responseBody
     *            the response body {@link #responseBody} to be set
     * @param reasonPhrase
     *            the reason phrase {@link #reasonPhrase} to be set
     * @param statusCode
     *            the status code {@link #statusCode} to be set
     */
    public AHttpClientResponse(String responseBody, String reasonPhrase,
            int statusCode) {
        super();
        this.responseBody = responseBody;
        this.reasonPhrase = reasonPhrase;
        this.statusCode = statusCode;
        if (this.responseBody != null)
            isBodyPresent = true;
    }

    /**
     * Instantiates a new a HTTP client response
     *
     * @param responseBody
     *            the response body {@link #responseBody} to be set
     * @param reasonPhrase
     *            the reason phrase {@link #reasonPhrase} to be set
     * @param statusCode
     *            the status code {@link #statusCode} to be set
     * @param responseHeaders
     *            the response headers {@link #responseHeaders} to be set
     */
    public AHttpClientResponse(String responseBody, String reasonPhrase,
            int statusCode, Map<String, String> responseHeaders) {
        this(responseBody, reasonPhrase, statusCode);
        this.responseHeaders = responseHeaders;
    }

    /**
     * Gets the response body as a {@link String}.
     *
    
     * @return the response body */
    public String getResponseBody() {
        return responseBody;
    }

    /**
     * Sets the response body.
     *
     * @param responseBody
     *            the new response body to be set as a {@link String}
     */
    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    /**
     * Gets the reason phrase as a {@link String}
     *
    
     * @return the reason phrase */
    public String getReasonPhrase() {
        return reasonPhrase;
    }

    /**
     * Sets the reason phrase.
     *
     * @param reasonPhrase
     *            the new reason phrase to be set as a {@link String}
     */
    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    /**
     * Gets the HTTP status code associated with this response as <code>int</code>
     *
    
     * @return the status code */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the status code.
     *
     * @param statusCode
     *            the new status code as an <code>int</code>
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets the response headers as a {@link Map} of {@link String} name value pairs
     *
    
     * @return the response headers */
    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * Sets the response headers.
     *
     * @param responseHeaders
     *            set the response headers using a {@link Map} of {@link String} name value pairs 
     */
    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    /**
     * Checks if there was any body content in the response represented by this {@link AHttpClientResponse}
     *
    
     * @return true, if there is any body content present. */
    public boolean isBodyPresent() {
        return isBodyPresent;
    }

    /**
     * 
    
    
     * @return {@link String} showing a summary of all of the fields of this {@link AHttpClientResponse} * @see java.lang.Object#toString() */
    @Override
    public String toString() {
        return "AHttpClientResponse [responseBody=" + responseBody
                + ", reasonPhrase=" + reasonPhrase + ", statusCode="
                + statusCode + ", isBodyPresent=" + isBodyPresent
                + ", responseHeaders=" + responseHeaders + "]";
    }
}
