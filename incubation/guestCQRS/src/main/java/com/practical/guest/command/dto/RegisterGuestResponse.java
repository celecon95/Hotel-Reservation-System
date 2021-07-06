package com.practical.guest.command.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "SignUpResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterGuestResponse {

    @ApiModelProperty(
            value = "message",
            dataType = "String",
            example = "Guest registered successfully")
    private String message;

}
