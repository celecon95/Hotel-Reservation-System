package com.practical.reservation.query.dao;

import com.practical.reservation.common.ReservationDate;
import com.practical.reservation.query.entity.Reservation;

public interface ReservationDAO {

      public Reservation saveReservation(Reservation reservation);

      public Reservation fetchReservation(String reservationNumber);

      public Reservation fetchReservation(String hotelName, String roomType, ReservationDate reservationDate);

}
