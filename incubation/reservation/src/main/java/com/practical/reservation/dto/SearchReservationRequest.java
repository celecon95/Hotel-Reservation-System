package com.practical.reservation.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "SearchReservationRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchReservationRequest {

    @ApiModelProperty(
            value = "reservationNumber",
            dataType = "String",
            example = "TTIUT474FF7")
    private String reservationNumber;
}
