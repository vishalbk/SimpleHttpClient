package com.shc.ahttp.client.request;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpGet;

import com.shc.ahttp.client.exception.AHttpClientCallException;
import com.shc.ahttp.client.response.AHttpClientResponse;
import com.shc.ahttp.client.util.AHttpClientConstants;

/**
 * The Apache HttpGetRequest class facilitates doing a get request to given url
 * and supports Basic Authentication. <br/>
 * <br/>
 * 
 * Simple usage :
 * 
 * <pre>
 * String url = &quot;https://httpbin.org/image/jpeg&quot;;
 * String username = &quot;username&quot;;
 * String password = &quot;password&quot;;
 * AHttpGetClient aHttpGetClient = new AHttpGetClient();
 * System.out.println(aHttpGetClient.executeGet(url, username, password));
 * </pre>
 * 
 * <br/>
 * <br/>
 * The class also provides overloaded methods to specify additional options such
 * as :
 * <ul>
 * <li>Custom Headers</li>
 * <li>Custom Encoding</li>
 * <li>Option to include response header in the returned response object</li>
 * <li>Specify connect timeout</li>
 * <li>Options to send request without basic authentications</li>
 * </ul>
 * @author vishalk2
 * @version $Revision: 1.0 $
 */
public class AHttpGetRequest extends ABasicAuthHttpRequestBase {

    /** The auth required. */
    private boolean authRequired = true;

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String username,
            String password) throws AHttpClientCallException {
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, username, password, connectTimeout,
                null, includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String username,
            String password, Map<String, String> headers)
            throws AHttpClientCallException {
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, username, password, connectTimeout,
                headers, includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * @param includeResponseHeaders
     *            whether to return the response headers also as part of the
     *            response object
    
    
     * @param request String
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String request,
            String username, String password, Map<String, String> headers,
            boolean includeResponseHeaders) throws AHttpClientCallException {
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        return executeGet(url, encoding, username, password, connectTimeout,
                headers, includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String encoding,
            String username, String password) throws AHttpClientCallException {
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, username, password, connectTimeout,
                null, includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String encoding,
            String username, String password, Map<String, String> headers)
            throws AHttpClientCallException {
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, username, password, connectTimeout,
                headers, includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String username,
            String password, int connectTimeout)
            throws AHttpClientCallException {
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, username, password, connectTimeout,
                null, includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String encoding,
            String username, String password, int connectTimeout)
            throws AHttpClientCallException {
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, username, password, connectTimeout,
                null, includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */

    public AHttpClientResponse executeGet(String url)
            throws AHttpClientCallException {
        authRequired = false;
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, null, null, connectTimeout, null,
                includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url,
            Map<String, String> headers) throws AHttpClientCallException {
        authRequired = false;
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, null, null, connectTimeout, headers,
                includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
    
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * @param includeResponseHeaders
     *            whether to return the response headers also as part of the
     *            response object
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url,
            Map<String, String> headers, boolean includeResponseHeaders)
            throws AHttpClientCallException {
        authRequired = false;
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        return executeGet(url, encoding, null, null, connectTimeout, headers,
                includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * @param includeResponseHeaders
     *            whether to return the response headers also as part of the
     *            response object
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String encoding,
            int connectTimeout, Map<String, String> headers,
            boolean includeResponseHeaders) throws AHttpClientCallException {
        authRequired = false;
        return executeGet(url, encoding, null, null, connectTimeout, headers,
                includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String encoding)
            throws AHttpClientCallException {
        authRequired = false;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, null, null, connectTimeout, null,
                includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
    
    
     * @param request String
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String request,
            Map<String, String> headers, String encoding)
            throws AHttpClientCallException {
        authRequired = false;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, null, null, connectTimeout, headers,
                includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, int connectTimeout)
            throws AHttpClientCallException {
        authRequired = false;
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, null, null, connectTimeout, null,
                includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String encoding,
            int connectTimeout) throws AHttpClientCallException {
        authRequired = false;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executeGet(url, encoding, null, null, connectTimeout, null,
                includeResponseHeaders);
    }

    /**
     * Execute the get request to the given url
     *
     * @param url
     *            The full url to the resource to which the get has to be done
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * @param includeResponseHeaders
     *            whether to return the response headers also as part of the
     *            response object
    
    
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws AHttpClientCallException
     *             if any exceptions occurs during the execution of the request */
    public AHttpClientResponse executeGet(String url, String encoding,
            String username, String password, int connectTimeout,
            Map<String, String> headers, boolean includeResponseHeaders)
            throws AHttpClientCallException {

        if (StringUtils.isEmpty(url))
            throw new AHttpClientCallException("Required Field: url " + url
                    + " cannot be null or empty");

        if (StringUtils.isEmpty(username) && authRequired)
            throw new AHttpClientCallException("Required Field: username"
                    + username + " cannot be null or empty");
        if (StringUtils.isEmpty(password) && authRequired)
            throw new AHttpClientCallException("Required Field: password"
                    + password + " cannot be null or empty");

        if (StringUtils.isEmpty(encoding))
            encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        if (connectTimeout < 1)
            connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;

        HttpGet httpGet = new HttpGet(url);

        if (authRequired)
            addBasicAuthHttpHeader(httpGet, username, password);

        addRequestHeaders(headers, httpGet);

        addRequestTimeoutConfig(connectTimeout, httpGet);

        AHttpClientResponse response = executeHttpRequest(httpGet, encoding,
                includeResponseHeaders);

        return response;
    }

}
