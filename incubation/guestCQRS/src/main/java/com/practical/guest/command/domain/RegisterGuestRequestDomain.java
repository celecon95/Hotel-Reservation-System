package com.practical.guest.command.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterGuestRequestDomain {

    private String name;

    private Address address;

    private String phoneNumber;

}
