package com.practical.reservation.common;

import com.practical.reservation.domain.ReserveHotelResponseDomain;
import com.practical.reservation.domain.SearchReservationResponseDomain;
import com.practical.reservation.dto.ReserveHotelResponse;
import com.practical.reservation.dto.SearchReservationResponse;
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

    public static ReserveHotelResponse buildReserveHotelResponseDto(ReserveHotelResponseDomain registerGuestResponseDomain){
        return modelMapper.map(registerGuestResponseDomain, ReserveHotelResponse.class);
    }

    public static SearchReservationResponse buildSearchReservationResponseDto(SearchReservationResponseDomain searchReservationResponseDomain){
        return modelMapper.map(searchReservationResponseDomain, SearchReservationResponse.class);
    }
}
