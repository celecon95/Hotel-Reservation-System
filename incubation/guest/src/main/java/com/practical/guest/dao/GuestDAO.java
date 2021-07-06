package com.practical.guest.dao;

import com.practical.guest.entity.Guest;

import java.util.Set;

public interface GuestDAO {

    public Guest saveGuest(Guest guest);

    public Set<String> fetchReservations(String name, String phoneNumber);

    public Set<String> updateReservations(String name, String phoneNumber, String registrationNumber);
}
