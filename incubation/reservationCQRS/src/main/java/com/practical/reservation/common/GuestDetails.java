package com.practical.reservation.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "GuestDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDetails {

    @ApiModelProperty(
            value = "guestName",
            dataType = "String",
            example = "Jack")
    private String guestName;

    @ApiModelProperty(
            value = "guestNumber",
            dataType = "String",
            example = "2846934947")
    private String guestNumber;
}
