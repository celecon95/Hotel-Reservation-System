package com.practical.hotel.dto;

import com.practical.hotel.common.Hotel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "RegisterHotelRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterHotelRequest {

    @ApiModelProperty(value = "hotel")
    private Hotel hotel;
}
