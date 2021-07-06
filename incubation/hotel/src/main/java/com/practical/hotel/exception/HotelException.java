package com.practical.hotel.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "GuestException")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelException extends Exception{

    @ApiModelProperty(value = "errorCode", example = "101")
    private int errorCode;

    @ApiModelProperty(value = "message", example = "Not found")
    private String message;

}
