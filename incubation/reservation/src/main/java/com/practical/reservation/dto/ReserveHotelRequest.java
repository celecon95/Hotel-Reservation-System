package com.practical.reservation.dto;


import com.practical.reservation.common.GuestDetails;
import com.practical.reservation.common.HotelDetails;
import com.practical.reservation.common.PaymentDetails;
import com.practical.reservation.common.ReservationDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ReserveHotelRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveHotelRequest {

    @ApiModelProperty(value = "hotelDetails")
    private HotelDetails hotelDetails;

    @ApiModelProperty(value = "guestDetails")
    private GuestDetails guestDetails;

    @ApiModelProperty(value = "reservationDate")
    private ReservationDate reservationDate;

    @ApiModelProperty(value = "paymentDetails")
    private PaymentDetails paymentDetails;
}
