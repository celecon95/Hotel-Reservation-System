package com.practical.guest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "guests")
public class Guest {

    @Id
    private String id;

    private String name;

    private Address address;

    private String phoneNumber;

    private Set<String> reservations;
}
