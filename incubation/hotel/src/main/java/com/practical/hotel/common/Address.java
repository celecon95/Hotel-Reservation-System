package com.practical.hotel.common;

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

    @ApiModelProperty(value = "buildingName", example = "Hotel Prince")
    private String buildingName;

    @ApiModelProperty(value = "streetAddress", example = "2nd cross")
    private String streetAddress;

    @ApiModelProperty(value = "area", example = "R P Nagar")
    private String area;

    @ApiModelProperty(value = "city", example = "Bangalore")
    private String city;

    @ApiModelProperty(value = "state", example = "Karnataka")
    private String state;

    @ApiModelProperty(value = "zipCode", example = "123456")
    private String zipCode;
}
