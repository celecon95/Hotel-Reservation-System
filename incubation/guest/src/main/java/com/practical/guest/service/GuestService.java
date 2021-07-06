package com.practical.guest.service;

import com.practical.guest.domain.*;
import com.practical.guest.exception.GuestException;

public interface GuestService {

    RegisterGuestResponseDomain createGuest(RegisterGuestRequestDomain registerGuestRequestDomain) throws GuestException;

    GuestReservationsResponseDomain fetchReservations(GuestReservationsRequestDomain guestReservationsRequestDomain) throws GuestException;

    UpdateReservationsResponseDomain updateReservations(UpdateReservationsRequestDomain updateReservationsResponseDomain) throws GuestException;
}