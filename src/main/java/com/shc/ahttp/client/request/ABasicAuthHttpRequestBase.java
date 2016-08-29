package com.shc.ahttp.client.request;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import com.shc.ahttp.client.exception.AHttpClientCallException;
import com.shc.ahttp.client.response.AHttpClientResponse;
import com.shc.ahttp.client.util.AHttpClientConstants;

/**
 * The Apache Basic Authentication supporting HTTP Request Base class serves as
 * the base class for any HTTP requestMethods class and contains different
 * methods which utilizes the Apache HTTP client APIs to perform all common
 * tasks related to preparing, sending, HTTP requests as well as receiving and
 * reading HTTP response.
 * 
 * @author vishalk2
 * @version $Revision: 1.0 $
 */
public abstract class ABasicAuthHttpRequestBase {

    /**
     * Uses the <a href=
     * "http://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/HttpClientBuilder.html#create()"
     * >HttpClientBuilder</a> to get the default HttpClient object
     * 
     * 
     * 
     * @return the default <a href=
     *         "http://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/CloseableHttpClient.html"
     *         >HttpClient</a> * @see <a href=
     *         "http://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/HttpClientBuilder.html"
     *         >HttpClientBuilder</a>
     */
    protected HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }

    /**
     * Execute the HTTP request by calling the <a href=
     * "http://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/CloseableHttpClient.html"
     * >HttpClient</a> execute method
     * 
     * @param httpRequest
     *            the http request {@link HttpRequestBase}
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param includeResponseHeaders
     *            whether to include headers captured from response, which might
     *            add a few more milliseconds to the response processing
     * 
     * 
     * @return the extracted HTTP client response {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException If any exception occurs during the
     *         request execution, it is enclosed in an instance of
     *         {@link AHttpClientCallException}
     */
    protected AHttpClientResponse executeHttpRequest(
            HttpRequestBase httpRequest, String encoding,
            boolean includeResponseHeaders) throws AHttpClientCallException {
        HttpClient httpClient = getHttpClient();
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpRequest);
        } catch (IOException e) {
            throw new AHttpClientCallException(e.getMessage(), e);
        }

        AHttpClientResponse aHttpClientResponse = processHttpResponse(
                httpResponse, encoding, includeResponseHeaders);

        HttpClientUtils.closeQuietly(httpResponse);
        HttpClientUtils.closeQuietly(httpClient);

        return aHttpClientResponse;
    }

    /**
     * Process the HTTP Response received. The method will check if the response
     * is between 100 - 399 and it'll try to find if there is content in the
     * body received. If the response code doesn't fall in ths range then it'll
     * extract various response parameters such as returned status code, status
     * phrase, response body if any, add them to a new
     * {@link AHttpClientCallException} and throw it.
     * 
     * @param httpResponse
     *            {@link HttpResponse} the HTTP response object received from
     *            the client call
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * @param includeResponseHeaders
     *            whether to include headers captured from response, which might
     *            add a few more milliseconds to the response processing
     * 
     * 
     * @return the extracted HTTP client response {@link AHttpClientResponse} * @throws
     *         AHttpClientCallException if any exception or error status code is
     *         received then {@link AHttpClientCallException} is thrown
     */
    protected AHttpClientResponse processHttpResponse(
            HttpResponse httpResponse, String encoding,
            boolean includeResponseHeaders) throws AHttpClientCallException {
        int responseCode = httpResponse.getStatusLine().getStatusCode();
        String reasonPhrase = httpResponse.getStatusLine().getReasonPhrase();
        String responseBody = getStringFromEntity(httpResponse.getEntity(),
                encoding);
        AHttpClientResponse response = null;
        if (responseCode >= 100 && responseCode < 400) {
            if (includeResponseHeaders) {
                response = new AHttpClientResponse(responseBody, reasonPhrase,
                        responseCode, getHeaders(httpResponse));
            } else {
                response = new AHttpClientResponse(responseBody, reasonPhrase,
                        responseCode);
            }
        } else {
            Map<String, String> responseHeaderMap = getHeaders(httpResponse);
            throw new AHttpClientCallException(
                    AHttpClientConstants.UNKWON_SERVER_CLIENT_ERROR
                            + responseCode, responseCode, reasonPhrase,
                    responseBody, responseHeaderMap);
        }
        return response;
    }

    /**
     * Gets {@link HttpEntity} content as String
     * 
     * {@link EntityUtils#toString(HttpEntity, String)}
     * 
     * @param httpEntity
     *            the http entity {@link HttpEntity}
     * @param encoding
     *            the encoding of the request and the expected encoding of
     *            response for ex UTF-8
     * 
     * 
     * @return the {@link String} from entity content * @throws
     *         AHttpClientCallException If any exception occurred during the
     *         process, then encapsulate it in a
     *         {@link AHttpClientCallException} and throw it.
     */
    protected String getStringFromEntity(HttpEntity httpEntity, String encoding)
            throws AHttpClientCallException {

        String response = AHttpClientConstants.DEFAULT_NO_CONTENT_MESSAGE;
        try {
            if (httpEntity.getContent() != null) {

                response = EntityUtils.toString(httpEntity, encoding);
            }
        } catch (UnsupportedOperationException | IOException e) {
            throw new AHttpClientCallException(e.getMessage(), e);
        }
        return response;
    }

    /**
     * Extract headers from a {@link HttpMessage} and return as a map of
     * {@link String} Key value pairs
     * 
     * @param httpMessage
     *            the {@link HttpMessage}
     * 
     * @return the headers as {@link Map<String, String>}
     */
    protected Map<String, String> getHeaders(HttpMessage httpMessage) {
        HeaderIterator headerIterator = httpMessage.headerIterator();
        Map<String, String> headerMap = new HashMap<String, String>();
        while (headerIterator.hasNext()) {
            Header currentHeader = headerIterator.nextHeader();
            headerMap.put(currentHeader.getName(), currentHeader.getValue());
        }
        return headerMap;
    }

    /**
     * Gets the {@link HttpEntity} from a given request {@link String}. It uses
     * the {@link EntityBuilder}
     * 
     * @param request
     *            the request {@link String}.
     *
     * @param contentType
     *            The content type of the request to be sent ex. Content-Type: application/json;charset=UTF-8
     * 
     * @return the {@link HttpEntity} from request {@link String}.
     */
    protected HttpEntity getHttpEntityFromRequest(String request,
            String contentType) {
        EntityBuilder entityBuilder = EntityBuilder.create();

        entityBuilder.setContentType(ContentType.parse(contentType));

        HttpEntity requestEntity = entityBuilder.setText(request).build();
        return requestEntity;
    }

    /**
     * Adds the request headers to a given {@link HttpRequest}. <b>Note:</b>
     * <i>The method adds the default content type of
     * {@link AHttpClientConstants#DEFAULT_CONTENT_TYPE}</i> to the list of
     * headers if there is no {@link HttpHeaders#CONTENT_TYPE} set
     *
     * @param headersMap
     *            the headers map {@link Map<String, String>} to be added
     * @param httpRequest
     *            the {@link HttpRequest} to which the headers need to be added
     */
    protected void addRequestHeaders(Map<String, String> headersMap,
            HttpRequest httpRequest) {
        if (headersMap != null && !headersMap.isEmpty()) {
            Iterator<Map.Entry<String, String>> headerIterator = headersMap
                    .entrySet().iterator();
            while (headerIterator.hasNext()) {
                Map.Entry<String, String> currentHeader = headerIterator.next();
                httpRequest.addHeader(currentHeader.getKey(),
                        currentHeader.getValue());
            }
        }
        Header contentTypeHeader = httpRequest
                .getFirstHeader(HttpHeaders.CONTENT_TYPE);

        if (contentTypeHeader == null
                || StringUtils.isEmpty(contentTypeHeader.getName())) {
            httpRequest.setHeader(HttpHeaders.CONTENT_TYPE,
                    AHttpClientConstants.DEFAULT_CONTENT_TYPE);
        }

    }

    /**
     * Adds the request timeout to the given {@link HttpRequestBase} object by
     * creating a custom instance of {@link RequestConfig} and setting the
     * {@link Builder#setConnectionRequestTimeout(int)},
     * {@link Builder#setConnectionRequestTimeout(int)},
     * {@link Builder#setConnectionRequestTimeout(int)}
     * 
     * @param connectTimeout
     *            the connect timeout to be set in milliseconds
     * @param httpRequest
     *            the {@link HttpRequestBase} to which the timeout has to be set
     */
    protected void addRequestTimeoutConfig(int connectTimeout,
            HttpRequestBase httpRequest) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(connectTimeout).build();
        httpRequest.setConfig(requestConfig);
    }

    /**
     * Adds the BasicAuth Header to the given {@link HttpRequest}
     *
     * @param httpRequest
     *            the {@link HttpRequest} to which the auth header needs to be
     *            added
     * @param username
     *            the basic auth username
     * @param password
     *            the password the basic auth password
     * 
     * @return {@link HttpContext} using which the basic scheme generated the
     *         auth headers
     */
    protected HttpContext addBasicAuthHttpHeader(HttpRequest httpRequest,
            String username, String password) {
        HttpContext httpContext = HttpClientContext.create();
        httpRequest.addHeader(getBasicAuthHttpHeader(httpContext, httpRequest,
                username, password));
        return httpContext;
    }

    /**
     * Adds the BasicAuth Header to the given {@link HttpRequest}, by using
     * {@link BasicScheme#authenticate(org.apache.http.auth.Credentials, HttpRequest, HttpContext)}
     * to generate the authorization header
     * 
     * @param httpContext
     *            {@link HttpContext} using which the basic scheme generated the
     *            auth headers
     * @param httpRequest
     *            the {@link HttpRequest} to which the auth header needs to be
     *            added
     * @param username
     *            the basic auth username
     * @param password
     *            the password the basic auth password
     * 
     * @return the {@link Header} which contains the basic authorization string.
     */
    protected Header getBasicAuthHttpHeader(HttpContext httpContext,
            HttpRequest httpRequest, String username, String password) {
        UsernamePasswordCredentials basicCreds = new UsernamePasswordCredentials(
                username, password);
        Header authHeader = null;
        try {
            authHeader = new BasicScheme().authenticate(basicCreds,
                    httpRequest, httpContext);
        } catch (AuthenticationException ex) {
            authHeader = null;
        }
        return authHeader;
    }
}
