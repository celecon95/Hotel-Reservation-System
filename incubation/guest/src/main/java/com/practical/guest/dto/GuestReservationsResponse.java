package com.practical.guest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@ApiModel(value = "GuestReservationsResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestReservationsResponse {

    @ApiModelProperty(
            value = "reservations")
    private Set<String> reservations;
}
