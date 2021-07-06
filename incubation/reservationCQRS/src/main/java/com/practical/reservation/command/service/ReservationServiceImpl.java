package com.practical.reservation.command.service;


import com.practical.reservation.command.command.ReserveHotelCommand;
import com.practical.reservation.common.dto.ReserveHotelRequest;
import com.practical.reservation.exception.ReservationException;
import org.apache.commons.lang3.RandomStringUtils;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ReservationServiceImpl implements ReservationService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    private final CommandGateway commandGateway;

    public ReservationServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> reserveHotel(ReserveHotelRequest reserveHotelRequest) throws ReservationException {
        return commandGateway.send(new ReserveHotelCommand(RandomStringUtils.randomAlphanumeric(16).toUpperCase(),
                reserveHotelRequest.getHotelDetails(), reserveHotelRequest.getGuestDetails(),
                reserveHotelRequest.getReservationDate(), reserveHotelRequest.getPaymentDetails(), "reserved"));
    }


}
