package com.practical.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String buildingName;

    private String streetAddress;

    private String area;

    private String city;

    private String state;

    private String zipCode;
}
