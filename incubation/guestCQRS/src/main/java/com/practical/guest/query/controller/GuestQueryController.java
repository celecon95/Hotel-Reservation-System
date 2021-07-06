package com.practical.guest.query.controller;

import com.practical.guest.command.dto.GuestReservationsRequest;
import com.practical.guest.command.dto.GuestReservationsResponse;
import com.practical.guest.exception.GuestException;
import com.practical.guest.query.entity.Guest;
import com.practical.guest.query.query.FindGuest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@RestController
public class GuestQueryController implements GuestQueryOperations{

    private final QueryGateway queryGateway;

    public GuestQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public ResponseEntity<GuestReservationsResponse> fetchReservations(GuestReservationsRequest guestReservationsRequest) throws GuestException {
        Guest guest = queryGateway.query(new FindGuest(guestReservationsRequest.getPhonenumber(),
                guestReservationsRequest.getName()), Guest.class).join();

        if(Objects.isNull(guest) || CollectionUtils.isEmpty(guest.getReservations())){
            throw new GuestException(102, "Reservations not found");
        }

        return ResponseEntity.ok(new GuestReservationsResponse(guest.getReservations()));
    }
}
