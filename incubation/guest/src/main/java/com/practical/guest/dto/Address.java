package com.practical.guest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @ApiModelProperty(value = "doorNo", example = "No.123")
    private String doorNo;

    @ApiModelProperty(value = "streetAddress", example = "2nd cross, R P Nagar")
    private String streetAddress;

    @ApiModelProperty(value = "city", example = "Bangalore")
    private String city;

    @ApiModelProperty(value = "state", example = "Karnataka")
    private String state;

    @ApiModelProperty(value = "zipCode", example = "123456")
    private String zipCode;
}
