package com.practical.guest.common.event;

import com.practical.guest.command.domain.Address;
import lombok.Getter;

@Getter
public class GuestRegisteredEvent extends BaseEvent{

    private final Address address;

    public GuestRegisteredEvent(String phoneNumber, String name, Address address) {
        super(phoneNumber, name);
        this.address = address;
    }
}
