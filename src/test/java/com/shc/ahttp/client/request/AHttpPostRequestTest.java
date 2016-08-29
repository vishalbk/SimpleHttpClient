package com.shc.ahttp.client.request;

import com.shc.ahttp.client.exception.AHttpClientCallException;
import com.shc.ahttp.client.request.AHttpPostRequest;
import com.shc.ahttp.client.response.AHttpClientResponse;

import junit.framework.TestCase;

/**
 * The class <code>AHttpPostRequestTest</code> contains tests for the class
 * {@link <code>AHttpPostRequest</code>}
 *
 * @pattern JUnit Test Case
 *
 * @author vishalk2
 *
 * @version $Revision$
 */
public class AHttpPostRequestTest extends TestCase {
    
    private AHttpPostRequest aHttpPostRequest;

    /**
     * Construct new test instance
     *
     * @param name the test name
     */
    public AHttpPostRequestTest(String name) {
        super(name);
    }

    /**
     * Perform pre-test initialization
     *
     * @throws Exception
     *
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        aHttpPostRequest = new AHttpPostRequest();
    }
    /**
     * This test demos how to post a request string to a url, without basic auth creds
     * To make the same with basic auth just include the username, password
     * @throws AHttpClientCallException
     */
    public void testExecutePostWithoutBasicAuth() throws AHttpClientCallException {
        String url = "https://httpbin.org/post";
        String request = "{\"referenceID\":\"SASL\",\"bodID\":123456789,\"country\":\"US\"}";
        AHttpClientResponse aHttpClientResponse = aHttpPostRequest.executePost(url, request);
        assertTrue(aHttpClientResponse.isBodyPresent());
        assertEquals(200, aHttpClientResponse.getStatusCode());
        assertEquals("OK", aHttpClientResponse.getReasonPhrase());
        assertNotNull(aHttpClientResponse.getResponseBody());
    }

    /**
     * Perform post-test clean up
     *
     * @throws Exception
     *
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        aHttpPostRequest = null;
    }
}