package com.practical.reservation.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ReserveHotelResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveHotelResponse {

    @ApiModelProperty(
            value = "reservationNumber",
            dataType = "String",
            example = "TTIUT474FF7")
    private String reservationNumber;

    @ApiModelProperty(
            value = "modeOfPayment",
            dataType = "String",
            example = "Debit card")
    private String modeOfPayment;

    @ApiModelProperty(
            value = "reservationStatus",
            dataType = "String",
            example = "Reserved")
    private String reservationStatus;
}
