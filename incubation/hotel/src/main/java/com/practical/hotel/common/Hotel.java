package com.practical.hotel.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@ApiModel(value = "Hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @ApiModelProperty(value = "name", example = "Hotel Prince")
    private String name;

    @ApiModelProperty(value = "email", example = "hotelprince@gmail.com")
    private String email;

    @ApiModelProperty(value = "phoneNumber", example = "7392700832")
    private String phoneNumber;

    @ApiModelProperty(value = "rooms")
    private Set<Room> rooms;

    @ApiModelProperty(value = "address")
    private Address address;

}
