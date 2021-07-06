package com.practical.hotel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "SearchHotelRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchHotelRequest {

    @ApiModelProperty(value = "name", example = "Hotel Prince")
    private String name;

    @ApiModelProperty(value = "area", example = "R P Nagar")
    private String area;
    
}
