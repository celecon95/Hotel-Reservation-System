package com.practical.reservation.common;

import com.practical.reservation.common.event.HotelReservedEvent;
import com.practical.reservation.query.entity.Reservation;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;

public class EntityMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    private EntityMapper(){}

    static {
        modelMapper
                .getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }

    public static Reservation buildReservationEntity(HotelReservedEvent hotelReservedEvent){
        return modelMapper.map(hotelReservedEvent, Reservation.class);
    }
}
