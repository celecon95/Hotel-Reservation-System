package com.practical.guest.consumer;

import com.practical.guest.common.DomainAssembler;
import com.practical.guest.dto.UpdateReservationsRequest;
import com.practical.guest.exception.GuestException;
import com.practical.guest.service.GuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateReservationConsumer {

    @Autowired
    private GuestService guestService;

    @StreamListener("input")
    public void updateReservations(UpdateReservationsRequest updateReservationsRequest) throws GuestException {

        var updateReservationsResponseDomain = guestService.updateReservations(DomainAssembler.buildUpdateReservationsRequestDomain(updateReservationsRequest));
        log.info(updateReservationsResponseDomain.getMessage());
    }
}
