package com.practical.guest.common;

import com.practical.guest.domain.GuestReservationsRequestDomain;
import com.practical.guest.domain.RegisterGuestRequestDomain;
import com.practical.guest.domain.UpdateReservationsRequestDomain;
import com.practical.guest.dto.GuestReservationsRequest;
import com.practical.guest.dto.RegisterGuestRequest;
import com.practical.guest.dto.UpdateReservationsRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;

public class DomainAssembler {

    private static final ModelMapper modelMapper = new ModelMapper();

    private DomainAssembler(){}

    static {
        modelMapper
                .getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }

    public static RegisterGuestRequestDomain buildRegisterGuestRequest(RegisterGuestRequest registerGuestRequest){
        return modelMapper.map(registerGuestRequest, RegisterGuestRequestDomain.class);
    }

    public static GuestReservationsRequestDomain buildGuestReservationsRequestDomain(GuestReservationsRequest guestReservationsRequest){
        return modelMapper.map(guestReservationsRequest, GuestReservationsRequestDomain.class);
    }

    public static UpdateReservationsRequestDomain buildUpdateReservationsRequestDomain(UpdateReservationsRequest updateReservationsRequest){
        return modelMapper.map(updateReservationsRequest, UpdateReservationsRequestDomain.class);
    }
}
