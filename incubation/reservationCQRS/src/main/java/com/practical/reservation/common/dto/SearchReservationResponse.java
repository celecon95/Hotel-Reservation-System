package com.practical.reservation.common.dto;

import com.practical.reservation.common.Reservation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "SearchReservationResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchReservationResponse {

    @ApiModelProperty(value = "reservation")
    Reservation reservation;
}
