package com.practical.guest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservationsRequestDomain {

    private String name;

    private String phoneNummer;

    private String reservationNumber;
}
