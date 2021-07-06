package com.practical.hotel.domain;

import com.practical.hotel.common.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchHotelResponseDomain {

    private List<Hotel> hotels;
}
