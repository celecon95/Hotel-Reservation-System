package com.practical.jwt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(value = "TokenResponse")
@Data
@AllArgsConstructor
public class TokenResponse {

    @ApiModelProperty(value = "token")
    private final String token;

    @ApiModelProperty(value = "type")
    private String type = "Bearer";
}
