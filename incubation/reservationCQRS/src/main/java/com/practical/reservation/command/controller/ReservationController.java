package com.practical.reservation.command.controller;

import com.practical.reservation.command.service.ReservationService;
import com.practical.reservation.common.dto.ReserveHotelRequest;
import com.practical.reservation.common.dto.ReserveHotelResponse;
import com.practical.reservation.exception.ReservationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class ReservationController implements ReservationOperations{

    @Autowired
    private ReservationService reservationService;

    public CompletableFuture<String> reserveHotel(ReserveHotelRequest reserveHotelRequest) throws ReservationException {

        return reservationService.reserveHotel(reserveHotelRequest);
    }

}
