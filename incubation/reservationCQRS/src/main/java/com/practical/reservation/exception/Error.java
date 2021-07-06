package com.practical.reservation.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Error")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    @ApiModelProperty(value = "errorCode", example = "101")
    private int errorCode;

    @ApiModelProperty(value = "message", example = "Not found")
    private String message;
}
