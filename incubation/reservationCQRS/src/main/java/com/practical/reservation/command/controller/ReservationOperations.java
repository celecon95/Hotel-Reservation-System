package com.practical.reservation.command.controller;

import com.practical.reservation.common.dto.ReserveHotelRequest;
import com.practical.reservation.exception.ReservationException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CompletableFuture;


@RequestMapping("/reservation")
public interface ReservationOperations {

    @ApiOperation(
            value = "Reserves hotel",
            response = String.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = String.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = Error.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = Error.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = Error.class)
    })
    @PostMapping(
            value = "/reserveHotel",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CompletableFuture<String> reserveHotel(@ApiParam @RequestBody ReserveHotelRequest reserveHotelRequest) throws ReservationException;

   }
