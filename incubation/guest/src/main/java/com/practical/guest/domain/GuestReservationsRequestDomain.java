package com.practical.guest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestReservationsRequestDomain {

    private String name;

    private String phonenumber;
}
