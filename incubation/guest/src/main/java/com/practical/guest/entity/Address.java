package com.practical.guest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String doorNo;

    private String streetAddress;

    private String city;

    private String state;

    private String zipCode;
}
