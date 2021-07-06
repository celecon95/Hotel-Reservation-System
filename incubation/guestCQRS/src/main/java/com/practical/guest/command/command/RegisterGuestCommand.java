package com.practical.guest.command.command;


import com.practical.guest.command.domain.Address;
import lombok.Getter;

@Getter
public class RegisterGuestCommand extends BaseCommand{

    private final Address address;

    public RegisterGuestCommand(String phoneNumber, String name, Address address) {
        super(phoneNumber, name);
        this.address = address;
    }
}
