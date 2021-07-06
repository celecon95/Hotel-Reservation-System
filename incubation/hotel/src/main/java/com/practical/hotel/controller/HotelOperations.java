package com.practical.hotel.controller;

import com.practical.hotel.domain.SearchHotelResponseDomain;
import com.practical.hotel.dto.*;
import com.practical.hotel.exception.Error;
import com.practical.hotel.exception.HotelException;
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

@RequestMapping("/hotel")
public interface HotelOperations {

    @ApiOperation(
            value = "Registers hotel and returns the response",
            response = RegisterHotelResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = RegisterHotelRequest.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = Error.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = Error.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = Error.class)
    })
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RegisterHotelResponse> registerHotel(@Valid @ApiParam @RequestBody RegisterHotelRequest registerGuestRequest) throws HotelException;

    @ApiOperation(
            value = "Searches hotel and returns the response",
            response = SearchHotelResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = SearchHotelResponseDomain.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = Error.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = Error.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = Error.class)
    })
    @PostMapping(
            value = "/search",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SearchHotelResponse> searchHotel(@Valid @ApiParam @RequestBody SearchHotelRequest searchHotelRequest) throws HotelException;

    @ApiOperation(
            value = "Deletes hotel and returns the response",
            response = DeleteHotelResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = DeleteHotelResponse.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = Error.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = Error.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = Error.class)
    })
    @PostMapping(
            value = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DeleteHotelResponse> deleteHotel(@Valid @ApiParam @RequestBody DeleteHotelRequest deleteHotelRequest) throws HotelException;



}
