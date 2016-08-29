package com.shc.ahttp.client.response;

import java.util.Map;

/**
 * This class provides an extra field for storing the parsed response object
 * along with all the fields from {@link AHttpClientResponse} to represent the
 * state and content of the response returned from a successful HTTP client
 * call.
 *
 * @author vishalk2
 * @version $Revision: 1.0 $
 */
public class SClientResponse<RES> extends AHttpClientResponse {
    private RES response;

    /**
     * Constructor for SClientResponse.
     * 
     * @param responseBody
     *            String
     * @param reasonPhrase
     *            String
     * @param statusCode
     *            int
     * @param response
     *            RES
     */
    public SClientResponse(String responseBody, String reasonPhrase,
            int statusCode, RES response) {
        super(responseBody, reasonPhrase, statusCode);
        this.response = response;
    }

    /**
     * Constructor for SClientResponse.
     * 
     * @param responseBody
     *            String
     * @param reasonPhrase
     *            String
     * @param statusCode
     *            int
     * @param responseHeaders
     *            Map<String,String>
     * @param response
     *            RES
     */
    public SClientResponse(String responseBody, String reasonPhrase,
            int statusCode, Map<String, String> responseHeaders, RES response) {
        super(responseBody, reasonPhrase, statusCode, responseHeaders);
        this.response = response;
    }

    /**
     * Method getResponse.
     * 
     * @return RES
     */
    public RES getResponse() {
        return response;
    }

    /**
     * Method setResponse.
     * 
     * @param response
     *            RES
     */
    public void setResponse(RES response) {
        this.response = response;
    }

    /**
     * Method isResponsePresent.
     * 
     * @return boolean
     */
    public boolean isResponsePresent() {
        return response != null;
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "SRestClientResponse [response=" + response + ", toString()="
                + super.toString() + "]";
    }

}
