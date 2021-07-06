package com.practical.hotel.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TestObjectMapper {

    private ObjectMapper objectMapper;

    public TestObjectMapper(){
        objectMapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public ObjectMapper getObjectMapper(){
        return objectMapper;
    }
}
