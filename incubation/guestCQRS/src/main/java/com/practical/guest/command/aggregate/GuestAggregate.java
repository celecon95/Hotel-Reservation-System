package com.practical.guest.command.aggregate;

import com.practical.guest.command.command.RegisterGuestCommand;
import com.practical.guest.command.domain.Address;
import com.practical.guest.common.event.GuestRegisteredEvent;
import com.practical.guest.common.event.ReservationsUpdatedEvent;
import commands.UpdateReservationsCommand;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

@Aggregate
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class GuestAggregate {

    private String name;

    private Address address;

    @AggregateIdentifier
    private String phoneNumber;

    private Set<String> reservations;

    @CommandHandler
    public GuestAggregate(RegisterGuestCommand registerGuestCommand){
        log.info("RegisterGuestCommand received..");
        AggregateLifecycle.apply(new GuestRegisteredEvent(registerGuestCommand.getPhoneNumber(),
                registerGuestCommand.getName(), registerGuestCommand.getAddress()));
    }

    @EventSourcingHandler
    public void on(GuestRegisteredEvent guestRegisteredEvent){
        log.info("GuestRegisteredEvent occured..");
        this.phoneNumber = guestRegisteredEvent.getPhoneNumber();
        this.name = guestRegisteredEvent.getName();
        this.address = guestRegisteredEvent.getAddress();
    }

    @CommandHandler
    public void on(UpdateReservationsCommand updateReservationsCommand){
        log.info("UpdateReservationsCommand received..");
        AggregateLifecycle.apply(new ReservationsUpdatedEvent(updateReservationsCommand.getPhoneNumber(),
                updateReservationsCommand.getName(), updateReservationsCommand.getReservationNumber()));
    }

    @EventSourcingHandler
    public void on(ReservationsUpdatedEvent reservationsUpdatedEvent){
        log.info("ReservationsUpdatedEvent occured..");
        this.phoneNumber = reservationsUpdatedEvent.getPhoneNumber();
        this.name = reservationsUpdatedEvent.getName();
        if(CollectionUtils.isEmpty(this.reservations)) {
            this.reservations = new HashSet<>();
        }
        this.reservations.add(reservationsUpdatedEvent.getReservationNumber());
    }
}
