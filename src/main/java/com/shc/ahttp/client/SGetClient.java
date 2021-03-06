package com.shc.ahttp.client;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.shc.ahttp.client.exception.AHttpClientCallException;
import com.shc.ahttp.client.exception.SClientException;
import com.shc.ahttp.client.messageconverter.JacksonMessageConverter;
import com.shc.ahttp.client.messageconverter.MessageConverter;
import com.shc.ahttp.client.request.AHttpGetRequest;
import com.shc.ahttp.client.response.AHttpClientResponse;
import com.shc.ahttp.client.response.SClientResponse;

/**
 * A Simple get client, which can be used to do a get request and receive
 * response, by passing in directly the url, the response of which can be
 * converted using a {@link MessageConverter}. The default message converter, if
 * not one is provided explicitly us {@link JacksonMessageConverter}.
 * 
 * The Simple get client uses {@link AHttpGetRequest} to make the post requests.
 * 
 * @see MessageConverter
 * @see JacksonMessageConverter
 * 
 * @param <RES>
 *            the response type
 * 
 * @author vishalk2
 */
public class SGetClient<RES> {

    /**
     * The DEFAULT_MESSAGE_CONVERTER_CLASS which will be used if no other
     * message converters are explicitly provided
     * 
     * @see JacksonMessageConverter
     */
    private static final Class<? extends MessageConverter> DEFAULT_MESSAGE_CONVERTER_CLASS = JacksonMessageConverter.class;

    /** The full url to the resource to which the request has to be sent. */
    private String url;

    /**
     * The response class which is compatible with the {@link MessageConverter}
     * being used and the {@link SGetClient} will try to generate response
     * object based on this class
     */
    private Class<RES> responseClass;

    /**
     * The response object which is compatible with the {@link MessageConverter}
     * being used and the incoming response will be constructed into this
     * object.
     */
    private RES response;

    /** The username to be used for basic auth */
    private String username;

    /** The password to be used for basic auth */
    private String password;

    /**
     * The expected encoding of response for ex UTF-8
     */
    private String encoding;

    /** A {@link Map<String, String>} of headers to be included in the request */
    private Map<String, String> headers;

    /** The connect timeout in milliseconds to be used */
    private int connectTimeout;

    /**
     * A boolean value indicating whether to return the response headers also as
     * part of the response object
     */
    private boolean includeResponseHeaders;

    /**
     * The message converter that will be used, if not set the
     * {@link SGetClient} will resort to using the
     * {@link #DEFAULT_MESSAGE_CONVERTER_CLASS}
     */
    private MessageConverter messageConverter;

    /**
     * If username, password are not used during the construction of
     * {@link SGetClient} object then this value will be set to false, there by
     * skipping basic auth for the request sent.
     */
    private boolean basicAuthRequired = true;

    /**
     * Instantiates a new {@link SGetClient} object with the provided parameters
     *
     * @param url
     *            The full url to the resource to which the request has to be
     *            sent.
     * @param responseClass
     *            the response class in which the returned response should be
     *            constructed into
     * @param username
     *            The username to be used for basic auth
     * @param password
     *            The password to be used for basic auth
     */
    public SGetClient(String url, Class<RES> responseClass, String username,
            String password) {
        super();
        this.url = url;
        this.responseClass = responseClass;
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new {@link SGetClient} object with the provided parameters
     *
     * @param url
     *            The full url to the resource to which the request has to be
     *            sent.
     * @param responseClass
     *            the response class in which the returned response should be
     *            constructed into
     * @param username
     *            The username to be used for basic auth
     * @param password
     *            The password to be used for basic auth
     * @param encoding
     *            The expected encoding of response for ex UTF-8
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     */
    public SGetClient(String url, Class<RES> responseClass, String username,
            String password, String encoding, Map<String, String> headers) {
        this(url, responseClass, username, password);
        this.encoding = encoding;
        this.headers = headers;
    }

    /**
     * Instantiates a new {@link SGetClient} object with the provided parameters
     *
     * @param url
     *            The full url to the resource to which the request has to be
     *            sent.
     * @param responseClass
     *            the response class in which the returned response should be
     *            constructed into
     * @param username
     *            The username to be used for basic auth
     * @param password
     *            The password to be used for basic auth
     * @param encoding
     *            The expected encoding of response for ex UTF-8
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * @param connectTimeout
     *            The connect timeout in milliseconds to be used
     * @param includeResponseHeaders
     *            boolean value indicating whether to return the response
     *            headers also as part of the response object
     */
    public SGetClient(String url, Class<RES> responseClass, String username,
            String password, String encoding, Map<String, String> headers,
            int connectTimeout, boolean includeResponseHeaders) {

        this(url, responseClass, username, password, encoding, headers);
        this.connectTimeout = connectTimeout;
        this.includeResponseHeaders = includeResponseHeaders;
    }

    /**
     * Instantiates a new {@link SGetClient} object with the provided parameters
     *
     * @param url
     *            The full url to the resource to which the request has to be
     *            sent.
     * @param responseClass
     *            the response class in which the returned response should be
     *            constructed into
     */
    public SGetClient(String url, Class<RES> responseClass) {
        super();
        this.url = url;
        this.responseClass = responseClass;
        basicAuthRequired = false;
    }

    /**
     * Instantiates a new {@link SGetClient} object with the provided parameters
     *
     * @param url
     *            The full url to the resource to which the request has to be
     *            sent.
     * @param responseClass
     *            the response class in which the returned response should be
     *            constructed into
     * @param encoding
     *            The expected encoding of response for ex UTF-8
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     */
    public SGetClient(String url, Class<RES> responseClass, String encoding,
            Map<String, String> headers) {
        this(url, responseClass);
        this.encoding = encoding;
        this.headers = headers;
    }

    /**
     * Instantiates a new {@link SGetClient} object with the provided parameters
     *
     * @param url
     *            The full url to the resource to which the request has to be
     *            sent.
     * @param responseClass
     *            the response class in which the returned response should be
     *            constructed into
     * @param encoding
     *            The expected encoding of response for ex UTF-8
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * @param connectTimeout
     *            The connect timeout in milliseconds to be used
     * @param includeResponseHeaders
     *            boolean value indicating whether to return the response
     *            headers also as part of the response object
     */
    public SGetClient(String url, Class<RES> responseClass, String encoding,
            Map<String, String> headers, int connectTimeout,
            boolean includeResponseHeaders) {

        this(url, responseClass, encoding, headers);
        this.connectTimeout = connectTimeout;
        this.includeResponseHeaders = includeResponseHeaders;
    }

    /**
     * This method takes in all the supplied parameters during object
     * construction and executes a get requirest to the specified url It then
     * parses the response and generates the {@link #responseClass} object and
     * passes them as part of the {@link SClientResponse} object
     * 
     * @return SClientResponse<RES>
     * @throws SClientException
     */
    public SClientResponse<RES> getRequest() throws SClientException {
        SClientResponse<RES> crRestClientResponse = null;
        AHttpClientResponse aHttpClientResponse = null;

        AHttpGetRequest aHttpGetRequest = new AHttpGetRequest();

        try {
            if (basicAuthRequired) {
                aHttpClientResponse = aHttpGetRequest.executeGet(url, encoding,
                        username, password, connectTimeout, headers,
                        includeResponseHeaders);
            } else {
                aHttpClientResponse = aHttpGetRequest.executeGet(url, encoding,
                        connectTimeout, headers, includeResponseHeaders);
            }
        } catch (AHttpClientCallException clientCallException) {
            throw new SClientException(clientCallException.toString(),
                    clientCallException);
        }
        if (aHttpClientResponse.isBodyPresent()) {
            response = getResponseObject(aHttpClientResponse.getResponseBody(),
                    responseClass);
        }
        crRestClientResponse = new SClientResponse<RES>(
                aHttpClientResponse.getResponseBody(),
                aHttpClientResponse.getReasonPhrase(),
                aHttpClientResponse.getStatusCode(),
                aHttpClientResponse.getResponseHeaders(), response);

        return crRestClientResponse;

    }

    /**
     * Generates the response object {@link #response} using the
     * {@link #messageConverter}
     *
     * @param responseString
     *            the response string received from the server
     * @param messageObjectClass
     *            the message object class to which the response string should
     *            be converted into
     * 
     * 
     * @return the parsed response object * @throws SClientException if any
     *         exception occurred during processing
     */
    private RES getResponseObject(String responseString,
            Class<RES> messageObjectClass) throws SClientException {
        return getMessageConverter().getObjectFromMessage(responseString,
                messageObjectClass);
    }

    /**
     * Gets the message converter.
     *
     * 
     * 
     * @return the message converter * @throws SClientException if any exception
     *         occurred during processing
     */
    private MessageConverter getMessageConverter() throws SClientException {
        if (messageConverter == null) {
            messageConverter = getDefaultMessageConverter();
        }
        return messageConverter;
    }

    /**
     * Gets the default message converter specified by
     * {@link #DEFAULT_MESSAGE_CONVERTER_CLASS} field and creating a new
     * instance of it.
     *
     * 
     * 
     * @return the default message converter * @throws SClientException if any
     *         exception occurred during creation of the
     *         {@link #DEFAULT_MESSAGE_CONVERTER_CLASS}
     */
    private MessageConverter getDefaultMessageConverter()
            throws SClientException {
        Constructor<? extends MessageConverter> constructor;
        MessageConverter defaultMessageConverter;
        try {
            constructor = DEFAULT_MESSAGE_CONVERTER_CLASS.getConstructor();
            defaultMessageConverter = constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException
                | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            throw new SClientException(e.getMessage(), e);
        }
        return defaultMessageConverter;
    }

    /**
     * Gets The full url to the resource to which the request has to be sent..
     *
     * 
     * @return The full url to the resource to which the request has to be sent.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets The full url to the resource to which the request has to be sent..
     *
     * @param url
     *            the new url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the response class in which the returned response should be
     * constructed into.
     *
     * 
     * @return the response class in which the returned response should be
     *         constructed into
     */
    public Class<RES> getResponseClass() {
        return responseClass;
    }

    /**
     * Sets the response class in which the returned response should be
     * constructed into.
     *
     * @param responseClass
     *            the new response class
     */
    public void setResponseClass(Class<RES> responseClass) {
        this.responseClass = responseClass;
    }

    /**
     * Gets the response.
     *
     * 
     * @return the response
     */
    public RES getResponse() {
        return response;
    }

    /**
     * Sets the response.
     *
     * @param response
     *            the new response
     */
    public void setResponse(RES response) {
        this.response = response;
    }

    /**
     * Gets The username to be used for basic auth.
     *
     * 
     * @return The username to be used for basic auth
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets The username to be used for basic auth.
     *
     * @param username
     *            the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets The password to be used for basic auth.
     *
     * 
     * @return The password to be used for basic auth
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets The password to be used for basic auth.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets The expected encoding of response for ex UTF-8.
     *
     * 
     * @return The expected encoding of response for ex UTF-8
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * Sets The expected encoding of response for ex UTF-8.
     *
     * @param encoding
     *            the new encoding
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * Gets the {@link Map<String, String>} of headers to be included in the
     * request.
     *
     * 
     * @return the {@link Map<String, String>} of headers to be included in the
     *         request
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Sets the {@link Map<String, String>} of headers to be included in the
     * request.
     *
     * @param headers
     *            the {@link Map<String, String>} of headers to be included in
     *            the request
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Gets The connect timeout in milliseconds to be used.
     *
     * 
     * @return The connect timeout in milliseconds to be used
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Sets The connect timeout in milliseconds to be used.
     *
     * @param connectTimeout
     *            the new connect timeout
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * Checks if is include response headers.
     *
     * 
     * @return true, if is include response headers
     */
    public boolean isIncludeResponseHeaders() {
        return includeResponseHeaders;
    }

    /**
     * Sets boolean value indicating whether to return the response headers also
     * as part of the response object.
     *
     * @param includeResponseHeaders
     *            the new include response headers
     */
    public void setIncludeResponseHeaders(boolean includeResponseHeaders) {
        this.includeResponseHeaders = includeResponseHeaders;
    }

}
