package com.bernardo.bookstoremanager.utils;

import com.bernardo.bookstoremanager.dto.AuthorDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonConverterUtils {

    public static String asJsonString(AuthorDTO expectedCreatedAuthorDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(expectedCreatedAuthorDTO);
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
