package com.practical.reservation.controller;

import com.practical.reservation.dto.ReserveHotelRequest;
import com.practical.reservation.dto.ReserveHotelResponse;
import com.practical.reservation.dto.SearchReservationRequest;
import com.practical.reservation.dto.SearchReservationResponse;
import com.practical.reservation.exception.ReservationException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/reservation")
public interface ReservationOperations {

    @ApiOperation(
            value = "Reserves hotel",
            response = ReserveHotelResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = ReserveHotelResponse.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = Error.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = Error.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = Error.class)
    })
    @PostMapping(
            value = "/reserveHotel",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReserveHotelResponse> reserveHotel(@Valid @ApiParam @RequestBody ReserveHotelRequest reserveHotelRequest) throws ReservationException;

    @ApiOperation(
            value = "Fetches the reservation",
            response = SearchReservationResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = SearchReservationResponse.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = Error.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = Error.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = Error.class)
    })
    @PostMapping(
            value = "/searchReservation",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SearchReservationResponse> searchReservation(@Valid @ApiParam @RequestBody SearchReservationRequest searchReservationRequest) throws ReservationException;
}
