package com.practical.reservation.domain;

import com.practical.reservation.common.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchReservationResponseDomain {

    Reservation reservation;
}
