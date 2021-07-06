package com.practical.reservation.common;

import com.practical.reservation.domain.ReserveHotelRequestDomain;
import com.practical.reservation.entity.Reservation;
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

    public static Reservation buildReservationEntity(ReserveHotelRequestDomain reserveHotelRequestDomain){
        return modelMapper.map(reserveHotelRequestDomain, Reservation.class);
    }
}
