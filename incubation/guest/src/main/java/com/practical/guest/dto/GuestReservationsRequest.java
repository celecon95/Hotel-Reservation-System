package com.practical.guest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "GuestReservationsRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestReservationsRequest {

    @ApiModelProperty(
            value = "name",
            dataType = "String",
            example = "Jack")
    private String name;

    @ApiModelProperty(
            value = "phonenumber",
            dataType = "String",
            example = "732278548926")
    private String phonenumber;
}
