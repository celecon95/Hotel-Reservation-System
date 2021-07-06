package com.practical.guest.query.controller;

import com.practical.guest.command.dto.GuestReservationsRequest;
import com.practical.guest.command.dto.GuestReservationsResponse;
import com.practical.guest.exception.Error;
import com.practical.guest.exception.GuestException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/guestQuery")
public interface GuestQueryOperations {

    @ApiOperation(
            value = "Fetches reservations and returns the response",
            response = GuestReservationsResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GuestReservationsResponse.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = Error.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = Error.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = Error.class)
    })
    @PostMapping(
            value = "/reservations",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GuestReservationsResponse> fetchReservations(@ApiParam @RequestBody GuestReservationsRequest guestReservationsRequest) throws GuestException;

}
