package com.shc.ahttp.client.messageconverter;

import com.shc.ahttp.client.exception.SClientException;

/**
 * The message converter interface defines the contract for serializing and
 * deserializing objects to and from a message passed.
 * 
 * @author vishalk2
 *
 * @version $Revision: 1.0 $
 */
public interface MessageConverter {

    /**
     * Gets the message from the passed in <T> object
     *
    
     * @param message
     *            The message object from which the string message should be
     *            generated
    
    
     * @return the generated String message * @throws SClientException
     *             If any exception occurred during the serialization */
    <T> String getMessageFrom(T message) throws SClientException;

    /**
     * Gets the object from message.
     *
    
     * @param message
     *            The message string from which the Object should be constructed
     *            into
     * @param messageObjectClass
     *            the message object class
    
    
     * @return the constructed object from given String message * @throws SClientException
     *             If any exception occurred during the deserialization */
    <T> T getObjectFromMessage(String message, Class<T> messageObjectClass)
            throws SClientException;
}
