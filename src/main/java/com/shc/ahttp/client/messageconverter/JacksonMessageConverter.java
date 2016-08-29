package com.shc.ahttp.client.messageconverter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shc.ahttp.client.exception.SClientException;

/**
 * A Jackson based message converter which utilizes the {@link ObjectMapper} API
 * to deserialize and serialize objects to and from JSON strings
 * 
 * @author vishalk2
 * @version $Revision: 1.0 $
 */
public class JacksonMessageConverter implements MessageConverter {

    /** The object mapper. */
    private ObjectMapper objectMapper;

    /**
     * Instantiates a new jackson message converter
     */
    public JacksonMessageConverter() {
        objectMapper = new ObjectMapper();
    }

    /**
     * Instantiates a new jackson message converter, by passing in a custom
     * {@link ObjectMapper} object
     *
     * @param objectMapper
     *            the custom {@link ObjectMapper} object
     */
    public JacksonMessageConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
    
     * @param message
     *            The message object from which the JSON String should be
     *            generated
    
    
     * 
    
     * @return the generated JSON String * @throws SClientException
     *             If any exception occurred during the serialization  
     * @see
     * com.shc.ahttp.client.messageconverter.MessageConverter#getMessageFrom
     * (java.lang.Object) */
    @Override
    public <T> String getMessageFrom(T message) throws SClientException {
        try {
            return objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new SClientException(e.getMessage(), e);
        }
    }

    /**
     * Gets the deserialized object from a given JSON String
     *
    
     * @param message
     *            The JSON string from which the Object should be constructed
     *            into
     * @param messageObjectClass
     *            the message object class
    
    

    
     * @return the constructed object from given JSON String * @throws SClientException
     *             If any exception occurred during the deserialization * @see com.shc.ahttp.client.messageconverter.MessageConverter#
     * getObjectFromMessage(java.lang.String, java.lang.Class) */
    @Override
    public <T> T getObjectFromMessage(String message,
            Class<T> messageObjectClass) throws SClientException {
        try {
            return objectMapper.readValue(message, messageObjectClass);
        } catch (IOException e) {
            throw new SClientException(e.getMessage(), e);
        }
    }

}
