package com.practical.hotel.dao;

import com.practical.hotel.entity.Hotel;
import com.practical.hotel.exception.HotelException;

import java.util.List;

public interface HotelDAO {

   public Hotel saveHotel(Hotel hotel);

   public List<Hotel> fetchHotel(String name, String area);

   public boolean deleteHotel(String name, String area) throws HotelException;
}
