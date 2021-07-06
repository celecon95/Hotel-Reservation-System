package com.practical.guest.common.assembler;

import com.practical.guest.common.event.GuestRegisteredEvent;
import com.practical.guest.query.entity.Guest;
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

    public static Guest buildGuestEntity(GuestRegisteredEvent guestRegisteredEvent){
        return modelMapper.map(guestRegisteredEvent, Guest.class);
    }
}
