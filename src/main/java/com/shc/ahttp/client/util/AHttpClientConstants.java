package com.shc.ahttp.client.util;

import org.apache.http.Consts;
import org.apache.http.entity.ContentType;

/**
 * THis class contains the constants and default values for various options used
 * through out the code.
 *
 * @author vishalk2
 * @version $Revision: 1.0 $
 */
public class AHttpClientConstants {

    /**
     * The Constant DEFAULT_CONNECT_TIMEOUT for specifying the default
     * Connection timeout in milliseconds to be used
     */
    public static final int DEFAULT_CONNECT_TIMEOUT = 30000;

    /**
     * The Constant DEFAULT_CONTENT_TYPE for specifying the default Content-Type
     * to be used if none is found
     */
    public static final String DEFAULT_CONTENT_TYPE = ContentType.APPLICATION_JSON
            .toString();
    
    /**
     * The Constant DEFAULT_CONTENT_TYPE object for specifying the default Content-Type
     * to be used if none is found
     */
    public static final ContentType DEFAULT_CONTENT_TYPE_OBJ = ContentType.APPLICATION_JSON;
    

    /**
     * The Constant DEFAULT_CONTENT_ENCODING for specifying the default encoding
     * to be used if none is found
     */
    public static final String DEFAULT_CONTENT_ENCODING = Consts.UTF_8
            .toString();

    /**
     * The Constant DEFAULT_NO_CONTENT_MESSAGEfor specifying the default message
     * to be used if no content is found in response body
     */
    public static final String DEFAULT_NO_CONTENT_MESSAGE = "NoContent";

    /**
     * The Constant UNKWON_SERVER_CLIENT_ERROR for specifying the default error
     * string to be used if an unexpected Server/CLient error occrus
     */
    public static final String UNKWON_SERVER_CLIENT_ERROR = "The http request returned ";

    /**
     * The Constant DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS for specifying if the
     * repose headers should be including in the response object by default
     */
    public static final boolean DEFAULT_INCLUDE_HTTP_RESPONSE_HEADERS = false;

}
