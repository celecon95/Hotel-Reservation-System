package com.practical.guest.query.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindGuest {

    private String phoneNumber;

    private String name;
}
