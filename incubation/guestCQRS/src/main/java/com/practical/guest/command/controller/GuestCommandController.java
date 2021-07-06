package com.practical.guest.command.controller;

import com.practical.guest.command.dto.*;
import com.practical.guest.command.service.GuestCommandService;
import com.practical.guest.common.assembler.DomainAssembler;
import com.practical.guest.exception.GuestException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RefreshScope
@RestController
@RequiredArgsConstructor
public class GuestCommandController implements GuestCommandOperations {

    private static final Logger LOGGER = LoggerFactory.getLogger(GuestCommandController.class);

    @Autowired
    private GuestCommandService guestCommandService;

    /**
     * This endpoint is used to register's the guest
     * @param registerGuestRequest
     * @return RegisterGuestResponse
     * @throws GuestException
     */
    public ResponseEntity<RegisterGuestResponse> registerGuest(RegisterGuestRequest registerGuestRequest) throws GuestException, ExecutionException, InterruptedException {

        LOGGER.info("Executing register guest");

        var response = guestCommandService.createGuest(DomainAssembler.buildRegisterGuestRequest(registerGuestRequest));
        return ResponseEntity.ok(new RegisterGuestResponse("Guest registered successfully"));
    }


    /**
     * This endpoint is used to update the reservations for the given request
     * @param updateReservationsRequest
     * @return UpdateReservationsResponse
     * @throws GuestException
     */
    public ResponseEntity<UpdateReservationsResponse> updateReservations(UpdateReservationsRequest updateReservationsRequest) throws GuestException, ExecutionException, InterruptedException {

        LOGGER.info("Executing update reservations");

        var response = guestCommandService.updateReservations(DomainAssembler.buildUpdateReservationsRequestDomain(updateReservationsRequest));
        return ResponseEntity.ok(new UpdateReservationsResponse("Reservation updated successfully"));
    }
}
