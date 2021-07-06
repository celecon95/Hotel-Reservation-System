package com.practical.hotel.service;

import com.practical.hotel.domain.*;
import com.practical.hotel.exception.HotelException;

public interface HotelService {

     RegisterHotelResponseDomain registerHotel(RegisterHotelRequestDomain registerHotelRequestDomain) throws HotelException;

     SearchHotelResponseDomain searchHotels(SearchHotelRequestDomain searchHotelRequestDomain) throws HotelException;

     DeleteHotelResponseDomain deleteHotel(DeleteHotelRequestDomain deleteHotelRequestDomain) throws HotelException;
}
