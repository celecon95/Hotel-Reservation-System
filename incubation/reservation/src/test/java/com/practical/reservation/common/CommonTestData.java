package com.practical.reservation.common;


import au.com.dius.pact.consumer.dsl.DslPart;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practical.reservation.domain.ReserveHotelRequestDomain;
import com.practical.reservation.domain.ReserveHotelResponseDomain;
import com.practical.reservation.domain.SearchReservationRequestDomain;
import com.practical.reservation.domain.SearchReservationResponseDomain;
import com.practical.reservation.dto.ReserveHotelRequest;
import com.practical.reservation.dto.ReserveHotelResponse;
import com.practical.reservation.dto.SearchReservationRequest;
import com.practical.reservation.dto.SearchReservationResponse;
import com.practical.reservation.entity.Reservation;
import com.practical.reservation.payload.UpdateReservationsRequest;
import com.practical.reservation.payload.UpdateReservationsResponse;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CommonTestData {

    private static ObjectMapper objectMapper = new TestObjectMapper().getObjectMapper();

    private final static String RESERVE_HOTEL = "classpath:json/reserveHotel.json";
    private final static String RESERVE_HOTEL_RESPONSE = "classpath:json/reserveHotelResponse.json";
    private final static String SEARCH_RESERVATION_REQUEST = "classpath:json/searchReservation.json";
    private final static String SEARCH_RESERVATION_RESPONSE = "classpath:json/searchReservationResponse.json";
    private final static String RESERVATION = "classpath:json/reservation.json";

    public static DslPart createUpdateReservationsRequest(){
        return LambdaDsl.newJsonBody((body) -> {
            body.stringValue("name", "Jack");
            body.stringValue("phoneNummer", "9129232331");
            body.stringValue("reservationNumber", "769576905");
        }).build();
    }

    public static DslPart createUpdateReservationsResponse(){
        return LambdaDsl.newJsonBody((body) -> {
            body.stringValue("message", "Reservations updated successfully");
        }).build();
    }

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

    public static ReserveHotelRequest createReserveHotelDto() throws IOException {
        return loadJsonFromResourceFolder(RESERVE_HOTEL, ReserveHotelRequest.class);
    }

    public static ReserveHotelRequestDomain createReserveHotelDomain() throws IOException {
        return loadJsonFromResourceFolder(RESERVE_HOTEL, ReserveHotelRequestDomain.class);
    }

    public static ReserveHotelResponse createReserveHotelResponseDto() throws IOException {
        return loadJsonFromResourceFolder(RESERVE_HOTEL_RESPONSE, ReserveHotelResponse.class);
    }

    public static ReserveHotelResponseDomain createReserveHotelResponseDomain() throws IOException {
        return loadJsonFromResourceFolder(RESERVE_HOTEL_RESPONSE, ReserveHotelResponseDomain.class);
    }

    public static SearchReservationRequest createSearchReservationRequest() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_RESERVATION_REQUEST, SearchReservationRequest.class);
    }

    public static SearchReservationRequestDomain createSearchReservationRequestDomain() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_RESERVATION_REQUEST, SearchReservationRequestDomain.class);
    }

    public static SearchReservationResponse createSearchReservationResponse() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_RESERVATION_RESPONSE, SearchReservationResponse.class);
    }

    public static SearchReservationResponseDomain createSearchReservationResponseDomain() throws IOException {
        return loadJsonFromResourceFolder(SEARCH_RESERVATION_RESPONSE, SearchReservationResponseDomain.class);
    }

    public static Reservation createReservationEntity() throws IOException {
        return loadJsonFromResourceFolder(RESERVATION, Reservation.class);
    }

    public static UpdateReservationsRequest createUpdateReservationsRequestPayload(){
        return new UpdateReservationsRequest("Jack", "2846934947", "HSKT4657TUIT");
    }

    public static UpdateReservationsResponse createUpdateReservationsResponsePayload(){
        return new UpdateReservationsResponse("Reservations updated successfully");
    }
}
