package com.practical.guest.common.assembler;


import com.practical.guest.command.domain.GuestReservationsRequestDomain;
import com.practical.guest.command.domain.RegisterGuestRequestDomain;
import com.practical.guest.command.domain.UpdateReservationsRequestDomain;
import com.practical.guest.command.dto.GuestReservationsRequest;
import com.practical.guest.command.dto.RegisterGuestRequest;
import com.practical.guest.command.dto.UpdateReservationsRequest;
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

    public static UpdateReservationsRequestDomain buildUpdateReservationsRequestDomain(UpdateReservationsRequest updateReservationsRequest){
        return modelMapper.map(updateReservationsRequest, UpdateReservationsRequestDomain.class);
    }
}
