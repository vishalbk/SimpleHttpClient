package com.shc.ahttp.client;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shc.ahttp.client.SGetClient;
import com.shc.ahttp.client.exception.SClientException;
import com.shc.ahttp.client.response.SClientResponse;
import com.shc.ahttp.client.testpojo.HttpBinGetResponse;
import com.shc.ahttp.client.util.AHttpClientConstants;

/**
 * The class <code>SGetClientTest</code> contains tests for the class {@link <code>SGetClient</code>}
 * 
 * The class also shows how to use the SGetClient API along with a compatible
 * {@link ObjectMapper} POJO to directly to do a GET call to any URL
 *
 * @pattern JUnit Test Case
 *
 * @author vishalk2
 *
 * @version $Revision$
 */
public class SGetClientTest extends TestCase {

    private SGetClient<HttpBinGetResponse> sGetClient;

    /**
     * This test class makes a get call to the url : https://httpbin.org/get
     * which returns any query params in response in the form of a JSON The
     * below test classes uses the {@link URLEncodedUtils} to append the query
     * params and send the request
     * 
     * To Send a GET request instantiate an instance of {@link SGetClient} with
     * the response type object you want in response. then call the
     * {@link SGetClient#getRequest()} to execute the GET agains the passed in
     * URL.
     * 
     * In case you need to perform Basic Authentication just pass the username
     * and password when instantiating the {@link SGetClient}
     * 
     * @throws SClientException
     * @throws UnsupportedEncodingException
     */
    public void testSGetClientTest() throws SClientException,
            UnsupportedEncodingException {
        String url = "https://httpbin.org/get";

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("testQueryParam1", "Simple@vishal"));
        nvps.add(new BasicNameValuePair("testQueryParam2", "Http"));
        nvps.add(new BasicNameValuePair("testQueryParam3", "Get"));
        nvps.add(new BasicNameValuePair("testQueryParam4", "Client"));

        url = url
                + "?"
                + URLEncodedUtils.format(nvps,
                        AHttpClientConstants.DEFAULT_CONTENT_ENCODING);

        sGetClient = new SGetClient<HttpBinGetResponse>(url,
                HttpBinGetResponse.class);
        SClientResponse<HttpBinGetResponse> response = sGetClient.getRequest();

        System.out.println(response);
        assertTrue(response.isBodyPresent());
        assertEquals(200, response.getStatusCode());
        assertEquals("OK", response.getReasonPhrase());
        assertNotNull(response.getResponseBody());
        assertNotNull(response.getResponse());

        assertTrue(response.getResponse().getArgs().get("testQueryParam1")
                .equalsIgnoreCase("Simple@vishal"));
        assertTrue(response.getResponse().getArgs().get("testQueryParam2")
                .equalsIgnoreCase("Http"));
        assertTrue(response.getResponse().getArgs().get("testQueryParam3")
                .equalsIgnoreCase("Get"));
        assertTrue(response.getResponse().getArgs().get("testQueryParam4")
                .equalsIgnoreCase("Client"));

    }
}