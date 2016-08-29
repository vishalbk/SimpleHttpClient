package com.shc.ahttp.client;

import java.io.UnsupportedEncodingException;

import junit.framework.TestCase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shc.ahttp.client.SPostClient;
import com.shc.ahttp.client.exception.SClientException;
import com.shc.ahttp.client.response.SClientResponse;
import com.shc.ahttp.client.testpojo.HttpBinPostRequest;
import com.shc.ahttp.client.testpojo.HttpBinPostResponse;

/**
 * The class <code>SPostClientTest</code> contains tests for the class {@link <code>SPostClient</code>}
 * 
 * The class also shows how to use the SPostClient API along with a compatible
 * {@link ObjectMapper} POJO to directly to do a POST call to any URL
 *
 * @pattern JUnit Test Case
 *
 * @author vishalk2
 *
 * @version $Revision$
 */
public class SPostClientTest extends TestCase {

    private SPostClient<HttpBinPostRequest, HttpBinPostResponse> sPostClient;

    /**
     * This test class makes a POST call to the url : https://httpbin.org/POST
     * which returns any query params and request body sent to it in response in
     * the form of a JSON. 
     * 
     * To Send a POST request instantiate an instance of {@link SPostClient} with
     * the request & response type of the objects you want in response. Then call the
     * {@link SPostClient#postRequest()} to execute the POST against the passed in
     * URL.
     * 
     * In case you need to perform Basic Authentication just pass the username
     * and password when instantiating the {@link SPostClient}
     * 
     * @throws SClientException
     * @throws UnsupportedEncodingException
     */
    public void testSPostClientTest() throws SClientException,
            UnsupportedEncodingException {
        String url = "https://httpbin.org/post";
        
        HttpBinPostRequest postRequest = new HttpBinPostRequest("SASL",
                "122321", "United States");
        
        sPostClient = new SPostClient<HttpBinPostRequest, HttpBinPostResponse>(
                url, postRequest, HttpBinPostResponse.class);
        
        SClientResponse<HttpBinPostResponse> response = sPostClient
                .postRequest();
        
        System.out.println(response.getResponse());
        assertTrue(response.isBodyPresent());
        assertEquals(200, response.getStatusCode());
        assertEquals("OK", response.getReasonPhrase());
        assertNotNull(response.getResponseBody());
        assertNotNull(response.getResponse());
        
        assertEquals(postRequest.getBodID(), response.getResponse().getJson().get("bodID"));
        assertEquals(postRequest.getReferenceID(), response.getResponse().getJson().get("referenceID"));
        assertEquals(postRequest.getCountry(), response.getResponse().getJson().get("country"));

    }
}