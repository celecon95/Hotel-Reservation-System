package com.practical.reservation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "UpdateReservationsRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservationsRequest {

    @ApiModelProperty(
            value = "name",
            dataType = "String",
            example = "Jack")
    private String name;

    @ApiModelProperty(
            value = "phoneNumber",
            dataType = "String",
            example = "1234567890")
    private String phoneNummer;

    @ApiModelProperty(
            value = "reservationNumber",
            dataType = "String",
            example = "1234567890")
    private String reservationNumber;
}
