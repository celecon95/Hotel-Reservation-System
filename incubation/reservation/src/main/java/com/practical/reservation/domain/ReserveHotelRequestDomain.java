package com.practical.reservation.domain;


import com.practical.reservation.common.GuestDetails;
import com.practical.reservation.common.HotelDetails;
import com.practical.reservation.common.PaymentDetails;
import com.practical.reservation.common.ReservationDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveHotelRequestDomain {

    private HotelDetails hotelDetails;

    private GuestDetails guestDetails;

    private ReservationDate reservationDate;

    private PaymentDetails paymentDetails;
}
