package com.practical.hotel.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteHotelRequestDomain {

    private String name;

    private String area;
}
