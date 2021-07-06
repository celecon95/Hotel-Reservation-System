package com.practical.reservation.command.aggregate;

import com.practical.reservation.command.command.ReserveHotelCommand;
import com.practical.reservation.common.GuestDetails;
import com.practical.reservation.common.HotelDetails;
import com.practical.reservation.common.PaymentDetails;
import com.practical.reservation.common.ReservationDate;
import com.practical.reservation.common.event.HotelReservedEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ReservationAggregate {

    @AggregateIdentifier
    private String reservationNumber;

    private HotelDetails hotelDetails;

    private GuestDetails guestDetails;

    private ReservationDate reservationDate;

    private PaymentDetails paymentDetails;

    private String reservationStatus;

    @CommandHandler
    public ReservationAggregate(ReserveHotelCommand reserveHotelCommand){
        log.info("ReserveHotelCommand received..");
        AggregateLifecycle.apply(new HotelReservedEvent(reserveHotelCommand.getReservationNumber(),
                reserveHotelCommand.getHotelDetails(), reserveHotelCommand.getGuestDetails(), reserveHotelCommand.getReservationDate(),
                reserveHotelCommand.getPaymentDetails(), reserveHotelCommand.getReservationStatus()));
    }

    @EventSourcingHandler
    protected void on(HotelReservedEvent hotelReservedEvent){
        log.info("HotelReservedEvent occurred..");
        this.reservationNumber = hotelReservedEvent.getReservationNumber();
        this.hotelDetails = hotelReservedEvent.getHotelDetails();
        this.guestDetails = hotelReservedEvent.getGuestDetails();
        this.reservationDate = hotelReservedEvent.getReservationDate();
        this.paymentDetails = hotelReservedEvent.getPaymentDetails();
        this.reservationStatus = hotelReservedEvent.getReservationStatus();
    }
}
