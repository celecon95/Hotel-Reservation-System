package com.practical.guest.common;

import com.practical.guest.domain.RegisterGuestRequestDomain;
import com.practical.guest.entity.Guest;
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

    public static Guest buildGuestEntity(RegisterGuestRequestDomain registerGuestRequestDomain){
        return modelMapper.map(registerGuestRequestDomain, Guest.class);
    }
}
