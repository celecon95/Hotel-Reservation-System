package com.practical.hotel.common;

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

    public static com.practical.hotel.entity.Hotel buildHotelEntity(Hotel hotel){
        return modelMapper.map(hotel, com.practical.hotel.entity.Hotel.class);
    }
}
