package com.practical.hotel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "DeleteHotelResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteHotelResponse {

    @ApiModelProperty(value = "message", example = "Hotel deleted successfully")
    private String message;
}
