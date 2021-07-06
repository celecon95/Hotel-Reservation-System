package com.practical.hotel.common;


import com.practical.hotel.domain.DeleteHotelRequestDomain;
import com.practical.hotel.domain.RegisterHotelRequestDomain;
import com.practical.hotel.domain.SearchHotelRequestDomain;
import com.practical.hotel.dto.DeleteHotelRequest;
import com.practical.hotel.dto.RegisterHotelRequest;
import com.practical.hotel.dto.SearchHotelRequest;
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

    public static RegisterHotelRequestDomain buildRegisterHotelRequestDomain(RegisterHotelRequest registerHotelRequest){
        return modelMapper.map(registerHotelRequest, RegisterHotelRequestDomain.class);
    }

    public static SearchHotelRequestDomain buildSearchHotelRequestDomain(SearchHotelRequest searchHotelRequest){
        return modelMapper.map(searchHotelRequest, SearchHotelRequestDomain.class);
    }

    public static DeleteHotelRequestDomain buildDeleteHotelRequestDomain(DeleteHotelRequest deleteHotelRequest){
        return modelMapper.map(deleteHotelRequest, DeleteHotelRequestDomain.class);
    }

    public static Hotel buildHotel(com.practical.hotel.entity.Hotel hotel){
        return modelMapper.map(hotel, Hotel.class);
    }
}
