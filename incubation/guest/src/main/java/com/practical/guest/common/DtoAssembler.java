package com.practical.guest.common;

import com.practical.guest.domain.GuestReservationsResponseDomain;
import com.practical.guest.domain.RegisterGuestResponseDomain;
import com.practical.guest.domain.UpdateReservationsResponseDomain;
import com.practical.guest.dto.GuestReservationsResponse;
import com.practical.guest.dto.RegisterGuestResponse;
import com.practical.guest.dto.UpdateReservationsResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;

public class DtoAssembler {

    private static final ModelMapper modelMapper = new ModelMapper();

    private DtoAssembler(){}

    static {
        modelMapper
                .getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }

    public static RegisterGuestResponse buildRegisterGuestResponseDto(RegisterGuestResponseDomain registerGuestResponseDomain){
        return modelMapper.map(registerGuestResponseDomain, RegisterGuestResponse.class);
    }

    public static GuestReservationsResponse buildGuestReservationsResponseDto(GuestReservationsResponseDomain guestReservationsResponseDomain){
        return modelMapper.map(guestReservationsResponseDomain, GuestReservationsResponse.class);
    }

    public static UpdateReservationsResponse buildUpdateReservationsResponseDto(UpdateReservationsResponseDomain updateReservationsResponseDomain){
        return modelMapper.map(updateReservationsResponseDomain, UpdateReservationsResponse.class);
    }

}
