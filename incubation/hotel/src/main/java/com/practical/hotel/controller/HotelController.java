package com.practical.hotel.controller;

import com.practical.hotel.common.DomainAssembler;
import com.practical.hotel.common.DtoAssembler;
import com.practical.hotel.dto.*;
import com.practical.hotel.exception.HotelException;
import com.practical.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HotelController implements HotelOperations {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelService hotelService;

    public ResponseEntity<RegisterHotelResponse> registerHotel(RegisterHotelRequest registerHotelRequest) throws HotelException {
        LOGGER.info("Executing register hotel");

        var registerHotelResponseDomain = hotelService.registerHotel(DomainAssembler.buildRegisterHotelRequestDomain(registerHotelRequest));
        return ResponseEntity.ok(DtoAssembler.buildRegisterHotelResponseDto(registerHotelResponseDomain));
    }

    public ResponseEntity<SearchHotelResponse> searchHotel(SearchHotelRequest searchHotelRequest) throws HotelException {
        LOGGER.info("Executing fetch hotel");

        var searchHotelResponseDomain = hotelService.searchHotels(DomainAssembler.buildSearchHotelRequestDomain(searchHotelRequest));
        return ResponseEntity.ok(DtoAssembler.buildSearchHotelResponseDto(searchHotelResponseDomain));
    }

    public ResponseEntity<DeleteHotelResponse> deleteHotel(DeleteHotelRequest deleteHotelRequest) throws HotelException {
        LOGGER.info("Executing delete hotel");
        var deleteHotelResponseDomain = hotelService.deleteHotel(DomainAssembler.buildDeleteHotelRequestDomain(deleteHotelRequest));
        return ResponseEntity.ok(DtoAssembler.buildDeleteHotelResponseDto(deleteHotelResponseDomain));
    }
}
