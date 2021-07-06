package com.practical.hotel.domain;

import com.practical.hotel.common.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterHotelRequestDomain {

    private Hotel hotel;
}
