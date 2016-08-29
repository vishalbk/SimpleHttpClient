package com.shc.ahttp.client.request;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;

import com.shc.ahttp.client.exception.AHttpClientCallException;
import com.shc.ahttp.client.response.AHttpClientResponse;
import com.shc.ahttp.client.util.AHttpClientConstants;

/**
 * This class facilitates posting a request to given url and supports Basic
 * Authentication. <br/>
 * <br/>
 * 
 * Simple usage :
 * 
 * <pre>
 * String request = &quot;{\&quot;referenceID\&quot;:\&quot;SASL\&quot;,\&quot;bodID\&quot;:123456789,\&quot;country\&quot;:\&quot;US\&quot;}&quot;;
 * String url = &quot;https://httpbin.org/post&quot;;
 * String username = &quot;username&quot;;
 * String password = &quot;password&quot;;
 * AHttpPostRequest aHttpPostRequest = new AHttpPostRequest();
 * System.out.println(aHttpPostRequest.executePost(url, request, username,
 *         password));
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
 * 
 * @author vishalk2
 * @version $Revision: 1.0 $
 */
public class AHttpPostRequest extends ABasicAuthHttpRequestBase {

    /** The auth required. */
    private boolean authRequired = true;

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String username, String password) throws AHttpClientCallException {
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, username, password,
                connectTimeout, null, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String username, String password, Map<String, String> headers)
            throws AHttpClientCallException {
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, username, password,
                connectTimeout, headers, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
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
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String username, String password, Map<String, String> headers,
            boolean includeResponseHeaders) throws AHttpClientCallException {
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        return executePost(url, request, encoding, username, password,
                connectTimeout, headers, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String encoding, String username, String password)
            throws AHttpClientCallException {
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, username, password,
                connectTimeout, null, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
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
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String encoding, String username, String password,
            Map<String, String> headers) throws AHttpClientCallException {
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, username, password,
                connectTimeout, headers, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String username, String password, int connectTimeout)
            throws AHttpClientCallException {
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, username, password,
                connectTimeout, null, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param username
     *            the username to be used for basic auth
     * @param password
     *            the password to be used for basic auth along with the password
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String encoding, String username, String password,
            int connectTimeout) throws AHttpClientCallException {
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, username, password,
                connectTimeout, null, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */

    public AHttpClientResponse executePost(String url, String request)
            throws AHttpClientCallException {
        authRequired = false;
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, null, null, connectTimeout,
                null, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            Map<String, String> headers) throws AHttpClientCallException {
        authRequired = false;
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, null, null, connectTimeout,
                headers, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * 
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * @param includeResponseHeaders
     *            whether to return the response headers also as part of the
     *            response object
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            Map<String, String> headers, boolean includeResponseHeaders)
            throws AHttpClientCallException {
        authRequired = false;
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        return executePost(url, request, encoding, null, null, connectTimeout,
                headers, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
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
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String encoding, int connectTimeout, Map<String, String> headers,
            boolean includeResponseHeaders) throws AHttpClientCallException {
        authRequired = false;
        return executePost(url, request, encoding, null, null, connectTimeout,
                headers, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String encoding) throws AHttpClientCallException {
        authRequired = false;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, null, null, connectTimeout,
                null, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            The request String to be sent as part of the post body
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param headers
     *            A {@link Map<String, String>} of headers to be included in the
     *            request
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String encoding, Map<String, String> headers)
            throws AHttpClientCallException {
        authRequired = false;
        int connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, null, null, connectTimeout,
                headers, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            Th request String to be sent as part of the post body
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            int connectTimeout) throws AHttpClientCallException {
        authRequired = false;
        String encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, null, null, connectTimeout,
                null, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            Th request String to be sent as part of the post body
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param connectTimeout
     *            the connect timeout in milliseconds to be used
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String encoding, int connectTimeout)
            throws AHttpClientCallException {
        authRequired = false;
        boolean includeResponseHeaders = AHttpClientConstants.DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS;
        return executePost(url, request, encoding, null, null, connectTimeout,
                null, includeResponseHeaders);
    }

    /**
     * Execute the post request to the given url
     *
     * @param url
     *            The full url to the resource to which the post has to be done
     * @param request
     *            Th request String to be sent as part of the post body
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
     * 
     * 
     * @return AHttpClientResponse the extracted response from the Http call
     *         made encapsulated in the {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exceptions occurs during the
     *         execution of the request
     */
    public AHttpClientResponse executePost(String url, String request,
            String encoding, String username, String password,
            int connectTimeout, Map<String, String> headers,
            boolean includeResponseHeaders) throws AHttpClientCallException {

        if (StringUtils.isEmpty(url)) {
            throw new AHttpClientCallException("Required Field: url " + url
                    + " cannot be null or empty");
        }
        if (StringUtils.isEmpty(username) && authRequired) {
            throw new AHttpClientCallException("Required Field: username"
                    + username + " cannot be null or empty");
        }
        if (StringUtils.isEmpty(password) && authRequired) {
            throw new AHttpClientCallException("Required Field: password"
                    + password + " cannot be null or empty");
        }

        if (StringUtils.isEmpty(encoding)) {
            encoding = AHttpClientConstants.DEFAULT_CONTENT_ENCODING;
        }
        if (connectTimeout < 1) {
            connectTimeout = AHttpClientConstants.DEFAULT_CONNECT_TIMEOUT;
        }

        HttpPost httpPost = new HttpPost(url);

        if (authRequired) {
            addBasicAuthHttpHeader(httpPost, username, password);
        }

        addRequestHeaders(headers, httpPost);

        addRequestTimeoutConfig(connectTimeout, httpPost);

        if (!StringUtils.isEmpty(request)) {
            String contentType = null;
            if (headers != null
                    && headers.get(HttpHeaders.CONTENT_TYPE) != null) {
                contentType = headers.get(HttpHeaders.CONTENT_TYPE);
            } else {
                contentType = AHttpClientConstants.DEFAULT_CONTENT_TYPE;
            }
            HttpEntity requestEntity = getHttpEntityFromRequest(request,
                    contentType);
            httpPost.setEntity(requestEntity);
        }

        AHttpClientResponse response = executeHttpRequest(httpPost, encoding,
                includeResponseHeaders);

        return response;
    }

}
