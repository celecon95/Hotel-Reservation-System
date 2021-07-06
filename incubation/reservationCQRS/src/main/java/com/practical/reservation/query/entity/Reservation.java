package com.practical.reservation.query.entity;

import com.practical.reservation.common.GuestDetails;
import com.practical.reservation.common.HotelDetails;
import com.practical.reservation.common.PaymentDetails;
import com.practical.reservation.common.ReservationDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reservations")
public class Reservation {

    @Id
    private String id;

    private String reservationNumber;

    private HotelDetails hotelDetails;

    private GuestDetails guestDetails;

    private ReservationDate reservationDate;

    private PaymentDetails paymentDetails;

    private String reservationStatus;
}
