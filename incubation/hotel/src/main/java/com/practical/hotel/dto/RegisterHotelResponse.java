package com.practical.hotel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "RegisterHotelResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterHotelResponse {

    @ApiModelProperty(value = "message", example = "Hotel registered successfully")
    private String message;
}
