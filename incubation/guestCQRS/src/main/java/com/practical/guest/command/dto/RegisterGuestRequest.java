package com.practical.guest.command.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel(value = "SignUpRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterGuestRequest {

    @ApiModelProperty(
            value = "name",
            dataType = "String",
            example = "Jack")
    private String name;

    @ApiModelProperty(
            value = "address")
    private Address address;

    @ApiModelProperty(
            value = "phoneNumber",
            dataType = "String",
            example = "1234567890")
    private String phoneNumber;

}
