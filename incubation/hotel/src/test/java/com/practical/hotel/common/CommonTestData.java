package com.practical.hotel.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practical.hotel.domain.DeleteHotelRequestDomain;
import com.practical.hotel.domain.RegisterHotelRequestDomain;
import com.practical.hotel.domain.SearchHotelRequestDomain;
import com.practical.hotel.domain.SearchHotelResponseDomain;
import com.practical.hotel.dto.DeleteHotelRequest;
import com.practical.hotel.dto.RegisterHotelRequest;
import com.practical.hotel.dto.SearchHotelRequest;
import com.practical.hotel.dto.SearchHotelResponse;
import com.practical.hotel.entity.Hotel;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CommonTestData {

    private static ObjectMapper objectMapper = new TestObjectMapper().getObjectMapper();

    private final static String HOTEL = "classpath:json/hotel.json";
    private final static String REGISTER_HOTEL_REQUEST = "classpath:json/registerHotelRequest.json";
    private final static String SEARCH_HOTEL_RESPONSE = "classpath:json/searchHotelResponse.json";
    private final static String SEARCH_HOTEL_REQUEST = "classpath:json/searchHotelRequest.json";


    public static <T> T loadJsonFromResourceFolder(String filepath, Class<T> clazz) throws IOException {
        File file;
        try {
            file = ResourceUtils.getFile(filepath);
            return objectMapper.readValue(file, clazz);
        }
        catch (FileNotFoundException e){
            throw e;
        }
    }

    public static Hotel createHotelEntity() throws IOException {
        return loadJsonFromResourceFolder(HOTEL, Hotel.class);
    }

    public static RegisterHotelRequestDomain createRegisterHotelRequestDomain() throws IOException {
        return loadJsonFromResourceFolder(REGISTER_HOTEL_REQUEST, RegisterHotelRequestDomain.class);
    }

    public static RegisterHotelRequest createRegisterHotelRequest() throws IOException {
        return loadJsonFromResourceFolder(REGISTER_HOTEL_REQUEST, RegisterHotelRequest.class);
    }

    public static SearchHotelResponseDomain createSearchResponseDomain() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_HOTEL_RESPONSE, SearchHotelResponseDomain.class);
    }

    public static SearchHotelResponse createSearchResponse() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_HOTEL_RESPONSE, SearchHotelResponse.class);
    }

    public static SearchHotelRequestDomain createSearchRequestDomain() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_HOTEL_REQUEST, SearchHotelRequestDomain.class);
    }

    public static SearchHotelRequest createSearchRequest() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_HOTEL_REQUEST, SearchHotelRequest.class);
    }

    public static DeleteHotelRequestDomain createDeleteRequestDomain() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_HOTEL_REQUEST, DeleteHotelRequestDomain.class);
    }

    public static DeleteHotelRequest createDeleteRequest() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_HOTEL_REQUEST, DeleteHotelRequest.class);
    }

}
