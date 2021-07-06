package com.practical.reservation.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class ReservationsUpdatedEvent{

    @TargetAggregateIdentifier
    private final String phoneNumber;

    private final String name;

    private final String reservationNumber;

}
