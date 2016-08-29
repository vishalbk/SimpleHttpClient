package com.shc.ahttp.client.exception;

import java.util.Map;

/**
 * Any exception which facilitates capturing the various response parameters of
 * an http client call.
 * 
 * @author vishalk2
 *
 * @version $Revision: 1.0 $
 */
public class AHttpClientCallException extends Exception {

    private static final long serialVersionUID = -9172131783821171520L;

    /**
     * Exception Message to be stored
     */
    private String message;

    /**
     * Status code of the http call causing this exception
     */
    private int statusCode;

    /**
     * Status text of the corresponding
     * {@link AHttpClientCallException#statusCode}
     */
    private String statusText;

    /**
     * The response body, if any, returned as part of response
     */
    private String responseBody;

    /**
     * A map of all the headers returned from the response.
     */
    private Map<String, String> responseHeaders;

    /**
     * Create a default instance of {@link AHttpClientCallException}
     */
    public AHttpClientCallException() {
        super();
    }

    /**
     * Create an instance of {@link AHttpClientCallException} by passing a
     * 
     * @param message
     *            to be stored as part of this exception
     */
    public AHttpClientCallException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * Create an instance of {@link AHttpClientCallException} by passing
     * 
     * @param message
     *            to be stored as part of this exception
     * @param cause
     *            the underlying exception which actually resulted in this
     *            exception
     */
    public AHttpClientCallException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    /**
     * Create an instance of {@link AHttpClientCallException} by passing
     * 
     * @param cause
     *            the underlying exception which actually resulted in this
     *            exception
     */
    public AHttpClientCallException(Throwable cause) {
        super(cause);
    }

    /**
     * Create an instance of {@link AHttpClientCallException} by passing
     * 
     * @param message
     *            to be stored as part of this exception
     * @param statusCode
     *            of the response
     * @param statusText
     *            of the response
     * @param responseBody
     *            from the response
     * @param responseHeaders
     *            from the response headers
     * @param cause
     *            the underlying exception which actually resulted in this
     *            exception
     */
    public AHttpClientCallException(String message, int statusCode,
            String statusText, String responseBody,
            Map<String, String> responseHeaders, Throwable cause) {
        super(cause);
        this.message = message;
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.responseBody = responseBody;
        this.responseHeaders = responseHeaders;
    }

    /**
     * Create an instance of {@link AHttpClientCallException} by passing
     * 
     * @param message
     *            to be stored as part of this exception
     * @param statusCode
     *            of the response
     * @param statusText
     *            of the response
     * @param responseBody
     *            from the response
     * @param responseHeaders
     *            from the response headers
     */
    public AHttpClientCallException(String message, int statusCode,
            String statusText, String responseBody,
            Map<String, String> responseHeaders) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.responseBody = responseBody;
        this.responseHeaders = responseHeaders;
    }

    /**
    
     * @return {@link String} the exception message associated with this
     *   exception */
    public String getMessage() {
        return message;
    }

    /**
     * 
    
     * @return the HTTP status code associated with this exception */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * 
    
     * @return {@link String} Status text associated with this exception */
    public String getStatusText() {
        return statusText;
    }

    /**
     * 
    
     * @return {@link String} Response body associated with this exception */
    public String getResponseBody() {
        return responseBody;
    }

    /**
    
     * @return {@link String} A summary string of all fields associated with this exception */
    @Override
    public String toString() {
        return "AHttpClientException [message=" + message + ", statusCode="
                + statusCode + ", statusText=" + statusText + ", responseBody="
                + responseBody + ", responseHeaders=" + responseHeaders
                + ", toString()=" + super.toString() + "]";
    }
}
