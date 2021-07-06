package com.practical.hotel.entity;

import com.practical.hotel.common.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private String roomNumber;

    private RoomType roomType;

    private Integer beds;

    private Double costPerDay;
}
