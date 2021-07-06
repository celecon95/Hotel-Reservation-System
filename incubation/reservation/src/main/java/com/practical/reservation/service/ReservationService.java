package com.practical.reservation.service;

import com.practical.reservation.domain.ReserveHotelRequestDomain;
import com.practical.reservation.domain.ReserveHotelResponseDomain;
import com.practical.reservation.domain.SearchReservationRequestDomain;
import com.practical.reservation.domain.SearchReservationResponseDomain;
import com.practical.reservation.exception.ReservationException;

public interface ReservationService {

    ReserveHotelResponseDomain reserveHotel(ReserveHotelRequestDomain reserveHotelRequestDomain) throws ReservationException;

    SearchReservationResponseDomain searchReservation(SearchReservationRequestDomain searchReservationRequestDomain) throws ReservationException;

}
