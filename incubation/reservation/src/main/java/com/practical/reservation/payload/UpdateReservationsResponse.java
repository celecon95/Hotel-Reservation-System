package com.practical.reservation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "UpdateReservationsResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservationsResponse {

    @ApiModelProperty(
            value = "message",
            dataType = "String",
            example = "Reservations updated successfully")
    private String message;
}
