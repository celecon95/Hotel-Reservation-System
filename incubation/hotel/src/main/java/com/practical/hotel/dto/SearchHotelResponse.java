package com.practical.hotel.dto;

import com.practical.hotel.common.Hotel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(value = "SearchHotelResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchHotelResponse {

    @ApiModelProperty(value = "hotels")
    private List<Hotel> hotels;
}
