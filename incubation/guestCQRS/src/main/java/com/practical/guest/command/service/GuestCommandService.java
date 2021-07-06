package com.practical.guest.command.service;

import com.practical.guest.command.domain.*;
import com.practical.guest.exception.GuestException;

import java.util.concurrent.CompletableFuture;


public interface GuestCommandService {
    CompletableFuture<String> createGuest(RegisterGuestRequestDomain registerGuestRequestDomain) throws GuestException;

    CompletableFuture<String> updateReservations(UpdateReservationsRequestDomain updateReservationsResponseDomain) throws GuestException;

}
