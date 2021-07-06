package com.practical.reservation.common.event;

import com.practical.reservation.common.GuestDetails;
import com.practical.reservation.common.HotelDetails;
import com.practical.reservation.common.PaymentDetails;
import com.practical.reservation.common.ReservationDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class HotelReservedEvent {

    @TargetAggregateIdentifier
    private final String reservationNumber;

    private final HotelDetails hotelDetails;

    private final GuestDetails guestDetails;

    private final ReservationDate reservationDate;

    private final PaymentDetails paymentDetails;

    private final String reservationStatus;
}
