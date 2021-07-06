package com.practical.reservation.command.service;

import com.practical.reservation.common.dto.ReserveHotelRequest;
import com.practical.reservation.exception.ReservationException;

import java.util.concurrent.CompletableFuture;

public interface ReservationService {

    CompletableFuture<String> reserveHotel(ReserveHotelRequest reserveHotelRequest) throws ReservationException;

}
