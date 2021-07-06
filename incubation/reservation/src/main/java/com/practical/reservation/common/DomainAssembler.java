package com.practical.reservation.common;


import com.practical.reservation.domain.ReserveHotelRequestDomain;
import com.practical.reservation.domain.SearchReservationRequestDomain;
import com.practical.reservation.dto.ReserveHotelRequest;
import com.practical.reservation.dto.SearchReservationRequest;
import com.practical.reservation.entity.Reservation;
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

    public static ReserveHotelRequestDomain buildReserveHotelRequestDomain(ReserveHotelRequest reserveHotelRequest){
        return modelMapper.map(reserveHotelRequest, ReserveHotelRequestDomain.class);
    }

    public static SearchReservationRequestDomain buildSearchReservationRequestDomain(SearchReservationRequest searchReservationRequest){
        return modelMapper.map(searchReservationRequest, SearchReservationRequestDomain.class);
    }

    public static com.practical.reservation.common.Reservation buildReservation(Reservation reservation){
        return modelMapper.map(reservation, com.practical.reservation.common.Reservation.class);
    }
}
