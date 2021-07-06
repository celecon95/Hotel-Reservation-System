package com.practical.reservation.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "HotelDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDetails {

    @ApiModelProperty(
            value = "hotelName",
            dataType = "String",
            example = "Hotel Prince")
    private String hotelName;

    @ApiModelProperty(
            value = "roomNumber",
            dataType = "String",
            example = "133")
    private String roomNumber;

    @ApiModelProperty(
            value = "roomType",
            dataType = "String",
            example = "Single")
    private String roomType;

    @ApiModelProperty(
            value = "hotelNumber",
            dataType = "String",
            example = "4687093505")
    private String hotelNumber;

}
