package com.practical.guest.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "UpdateReservationsResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservationsResponseDomain {

    @ApiModelProperty(
            value = "message",
            dataType = "String",
            example = "Registrations updated successfully")
    private String message;
}
