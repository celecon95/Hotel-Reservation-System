package com.practical.hotel.common;

import com.practical.hotel.domain.DeleteHotelResponseDomain;
import com.practical.hotel.domain.RegisterHotelResponseDomain;
import com.practical.hotel.domain.SearchHotelResponseDomain;
import com.practical.hotel.dto.DeleteHotelResponse;
import com.practical.hotel.dto.RegisterHotelResponse;
import com.practical.hotel.dto.SearchHotelResponse;
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

    public static RegisterHotelResponse buildRegisterHotelResponseDto(RegisterHotelResponseDomain registerGuestResponseDomain){
        return modelMapper.map(registerGuestResponseDomain, RegisterHotelResponse.class);
    }

    public static SearchHotelResponse buildSearchHotelResponseDto(SearchHotelResponseDomain searchHotelResponseDomain){
        return modelMapper.map(searchHotelResponseDomain, SearchHotelResponse.class);
    }

    public static DeleteHotelResponse buildDeleteHotelResponseDto(DeleteHotelResponseDomain deleteHotelResponseDomain){
        return modelMapper.map(deleteHotelResponseDomain, DeleteHotelResponse.class);
    }
}
