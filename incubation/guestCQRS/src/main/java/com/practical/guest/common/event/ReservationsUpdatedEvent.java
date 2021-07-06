package com.practical.guest.common.event;

import lombok.Getter;

@Getter
public class ReservationsUpdatedEvent extends BaseEvent{

    private final String reservationNumber;

    public ReservationsUpdatedEvent(String phoneNumber, String name, String reservationNumber) {
        super(phoneNumber, name);
        this.reservationNumber = reservationNumber;
    }
}
