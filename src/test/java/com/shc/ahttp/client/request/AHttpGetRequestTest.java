package com.shc.ahttp.client.request;

import com.shc.ahttp.client.exception.AHttpClientCallException;
import com.shc.ahttp.client.request.AHttpGetRequest;
import com.shc.ahttp.client.response.AHttpClientResponse;

import junit.framework.TestCase;

/**
 * The class <code>AHttpGetRequestTest</code> contains tests for the class
 * {@link <code>AHttpGetRequest</code>}
 *
 * @pattern JUnit Test Case
 *
 * @author vishalk2
 *
 * @version $Revision$
 */
public class AHttpGetRequestTest extends TestCase {

    private AHttpGetRequest  aHttpGetRequest;
    /**
     * Construct new test instance
     *
     * @param name the test name
     */
    public AHttpGetRequestTest(String name) {
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
        aHttpGetRequest = new AHttpGetRequest();
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
        aHttpGetRequest = null;
    }
    
    /**
     * This method tests {@link AHttpGetRequest} without basic authentication
     * @throws AHttpClientCallException
     */
    public void testExecuteGetWithoutBasicAuthentication() throws AHttpClientCallException {
        String url = "https://httpbin.org/get";
        AHttpClientResponse aHttpClientResponse = aHttpGetRequest.executeGet(url);
        assertTrue(aHttpClientResponse.isBodyPresent());
        assertEquals(200, aHttpClientResponse.getStatusCode());
        assertEquals("OK", aHttpClientResponse.getReasonPhrase());
        assertNotNull(aHttpClientResponse.getResponseBody());
    }
    /**
     * THis method tests {@link AHttpGetRequest} with basic authentication. 
     * @throws AHttpClientCallException
     */
    public void testExecuteGetBasicAuthentication() throws AHttpClientCallException {
        String url = "http://httpbin.org/basic-auth/";
        String username = "testuser";
        String password = "testpassword";
        
        AHttpClientResponse aHttpClientResponse = aHttpGetRequest.executeGet(url+username+"/"+password,username, password);
        assertTrue(aHttpClientResponse.isBodyPresent());
        assertEquals(200, aHttpClientResponse.getStatusCode());
        assertEquals("OK", aHttpClientResponse.getReasonPhrase());
        assertNotNull(aHttpClientResponse.getResponseBody());
    }
}

