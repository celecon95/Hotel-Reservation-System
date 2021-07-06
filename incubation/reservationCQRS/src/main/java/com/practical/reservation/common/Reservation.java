package com.practical.reservation.common;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @ApiModelProperty(
            value = "reservationNumber",
            dataType = "String",
            example = "HSKT4657TUIT")
    private String reservationNumber;

    @ApiModelProperty(value = "hotelDetails")
    private HotelDetails hotelDetails;

    @ApiModelProperty(value = "guestDetails")
    private GuestDetails guestDetails;

    @ApiModelProperty(value = "reservationDate")
    private ReservationDate reservationDate;

    @ApiModelProperty(value = "paymentDetails")
    private PaymentDetails paymentDetails;

    @ApiModelProperty(
            value = "reservationStatus",
            dataType = "String",
            example = "Reserved")
    private String reservationStatus;
}
