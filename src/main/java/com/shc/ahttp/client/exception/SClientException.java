package com.shc.ahttp.client.exception;

/**
 * A Generic Exception, which encapsulates all exceptions that will be thrown
 * from the HTTP Client call
 * 
 * @author vishalk2
 *
 * @version $Revision: 1.0 $
 */
public class SClientException extends Exception {

    private static final long serialVersionUID = -6931262033976175132L;

    /**
     * Create a default instance of {@link SClientException}
     */
    public SClientException() {
        super();
    }

    /**
     * Create an instance of {@link SClientException} by passing a
     * 
     * @param message
     *            to be stored as part of this exception
     */
    public SClientException(String message) {
        super(message);
    }

    /**
     * Create an instance of {@link SClientException} by passing
     * 
     * @param message
     *            to be stored as part of this exception
     * @param cause
     *            the underlying exception which actually resulted in this
     *            exception
     */
    public SClientException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Create an instance of {@link SClientException} by passing
     * 
     * @param cause
     *            the underlying exception which actually resulted in this
     *            exception
     */
    public SClientException(Throwable cause) {
        super(cause);
    }

    /**
    
     * @return {@link String} A summary string of all fields associated with
     *         this exception */
    @Override
    public String toString() {
        return "SClientException [toString()=" + super.toString() + "]";
    }

}
