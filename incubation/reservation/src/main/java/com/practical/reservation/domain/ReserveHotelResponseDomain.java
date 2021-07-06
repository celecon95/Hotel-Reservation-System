package com.practical.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveHotelResponseDomain {

    private String reservationNumber;

    private String modeOfPayment;

    private String reservationStatus;
}
