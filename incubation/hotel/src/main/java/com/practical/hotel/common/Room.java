package com.practical.hotel.common;

import com.practical.hotel.common.RoomType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @ApiModelProperty(value = "roomNumber", example = "156")
    private String roomNumber;

    @ApiModelProperty(value = "roomType")
    private RoomType roomType;

    @ApiModelProperty(value = "beds")
    private Integer beds;

    @ApiModelProperty(value = "costPerDay")
    private Double costPerDay;

}
