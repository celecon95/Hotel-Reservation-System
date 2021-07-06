package com.practical.hotel.service;

import com.practical.hotel.common.DomainAssembler;
import com.practical.hotel.common.EntityMapper;
import com.practical.hotel.dao.HotelDAO;
import com.practical.hotel.domain.*;
import com.practical.hotel.entity.Hotel;
import com.practical.hotel.exception.HotelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HotelServiceImpl implements HotelService{

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Autowired
    private HotelDAO hotelDAO;

    public RegisterHotelResponseDomain registerHotel(RegisterHotelRequestDomain registerHotelRequestDomain) throws HotelException {
        RegisterHotelResponseDomain registerHotelResponseDomain = new RegisterHotelResponseDomain();
        if(Objects.nonNull(hotelDAO.saveHotel(EntityMapper.buildHotelEntity(registerHotelRequestDomain.getHotel())))){
            registerHotelResponseDomain.setMessage("Hotel registered successfully");
            return registerHotelResponseDomain;
        }
        else {
            throw new HotelException(101, "Hotel registration failed");
        }
    }

    public SearchHotelResponseDomain searchHotels(SearchHotelRequestDomain searchHotelRequestDomain) throws HotelException {
        List<Hotel> hotels = hotelDAO.fetchHotel(searchHotelRequestDomain.getName(), searchHotelRequestDomain.getArea());
        if(CollectionUtils.isEmpty(hotels)){
            throw new HotelException(101, "No hotels found");
        }
        else {
            SearchHotelResponseDomain searchHotelResponseDomain = new SearchHotelResponseDomain();
            List<com.practical.hotel.common.Hotel> hotelList = new ArrayList<>();
            for (Hotel hotel : hotels) {
                hotelList.add(DomainAssembler.buildHotel(hotel));
            }
            searchHotelResponseDomain.setHotels(hotelList);
            return searchHotelResponseDomain;
        }
    }

    public DeleteHotelResponseDomain deleteHotel(DeleteHotelRequestDomain deleteHotelRequestDomain) throws HotelException {
        DeleteHotelResponseDomain deleteHotelResponseDomain = new DeleteHotelResponseDomain();
        if(hotelDAO.deleteHotel(deleteHotelRequestDomain.getName(), deleteHotelRequestDomain.getArea())){
            deleteHotelResponseDomain.setMessage("Hotel deleted successfully");
        }
        else {
            deleteHotelResponseDomain.setMessage("Hotel deletion failed");
        }
        return deleteHotelResponseDomain;
    }
}
