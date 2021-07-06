package com.practical.reservation.controller;

import com.practical.reservation.common.DomainAssembler;
import com.practical.reservation.common.DtoAssembler;
import com.practical.reservation.dto.ReserveHotelRequest;
import com.practical.reservation.dto.ReserveHotelResponse;
import com.practical.reservation.dto.SearchReservationRequest;
import com.practical.reservation.dto.SearchReservationResponse;
import com.practical.reservation.exception.ReservationException;
import com.practical.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController implements ReservationOperations{

    @Autowired
    private ReservationService reservationService;

    public ResponseEntity<ReserveHotelResponse> reserveHotel(ReserveHotelRequest reserveHotelRequest) throws ReservationException {

        var reserveHotelResponseDomain = reservationService.reserveHotel(DomainAssembler.buildReserveHotelRequestDomain(reserveHotelRequest));
        return ResponseEntity.ok(DtoAssembler.buildReserveHotelResponseDto(reserveHotelResponseDomain));
    }

    public ResponseEntity<SearchReservationResponse> searchReservation(SearchReservationRequest searchReservationRequest) throws ReservationException {
        var searchReservationResponseDomain = reservationService.searchReservation(DomainAssembler.buildSearchReservationRequestDomain(searchReservationRequest));
        return ResponseEntity.ok(DtoAssembler.buildSearchReservationResponseDto(searchReservationResponseDomain));
    }
}
