package com.practical.guest.query.dao;


import com.practical.guest.query.entity.Guest;

import java.util.Optional;
import java.util.Set;

public interface GuestDAO {

    public Guest saveGuest(Guest guest);

    public Set<String> fetchReservations(String name, String phoneNumber);

    public Optional<Guest> findGuest(String name, String phoneNumber);

    public Set<String> updateReservations(String name, String phoneNumber, String registrationNumber);
}
