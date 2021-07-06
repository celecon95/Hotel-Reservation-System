package com.practical.guest.controller;

import com.practical.guest.common.DomainAssembler;
import com.practical.guest.common.DtoAssembler;
import com.practical.guest.dto.*;
import com.practical.guest.exception.GuestException;
import com.practical.guest.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequiredArgsConstructor
public class GuestController implements GuestOperations{

    private static final Logger LOGGER = LoggerFactory.getLogger(GuestController.class);

    @Autowired
    private GuestService guestService;

    /**
     * This endpoint is used to register's the guest
     * @param registerGuestRequest
     * @return RegisterGuestResponse
     * @throws GuestException
     */
    public ResponseEntity<RegisterGuestResponse> registerGuest(RegisterGuestRequest registerGuestRequest) throws GuestException {

        LOGGER.info("Executing register guest");

        var registerGuestResponseDomain = guestService.createGuest(DomainAssembler.buildRegisterGuestRequest(registerGuestRequest));
        return ResponseEntity.ok(DtoAssembler.buildRegisterGuestResponseDto(registerGuestResponseDomain));
    }

    /**
     * This endpoint is used to fetch reservations based on the given request
     * @param guestReservationsRequest
     * @return GuestReservationsResponse
     * @throws GuestException
     */
    public ResponseEntity<GuestReservationsResponse> fetchReservations(GuestReservationsRequest guestReservationsRequest) throws GuestException {

        LOGGER.info("Executing fetch reservations");

        var guestReservationsResponseDomain = guestService.fetchReservations(DomainAssembler.buildGuestReservationsRequestDomain(guestReservationsRequest));
        return ResponseEntity.ok(DtoAssembler.buildGuestReservationsResponseDto(guestReservationsResponseDomain));
    }

    /**
     * This endpoint is used to update the reservations for the given request
     * @param updateReservationsRequest
     * @return UpdateReservationsResponse
     * @throws GuestException
     */
    public ResponseEntity<UpdateReservationsResponse> updateReservations(UpdateReservationsRequest updateReservationsRequest) throws GuestException {

        LOGGER.info("Executing update reservations");

        var updateReservationsResponseDomain = guestService.updateReservations(DomainAssembler.buildUpdateReservationsRequestDomain(updateReservationsRequest));
        return ResponseEntity.ok(DtoAssembler.buildUpdateReservationsResponseDto(updateReservationsResponseDomain));
    }
}
