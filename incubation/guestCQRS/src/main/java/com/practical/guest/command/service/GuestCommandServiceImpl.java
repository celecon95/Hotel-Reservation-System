package com.practical.guest.command.service;

import com.practical.guest.command.command.RegisterGuestCommand;
import com.practical.guest.command.domain.RegisterGuestRequestDomain;
import com.practical.guest.command.domain.UpdateReservationsRequestDomain;
import com.practical.guest.exception.GuestException;
import commands.UpdateReservationsCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class GuestCommandServiceImpl implements GuestCommandService{

    private static final Logger LOGGER = LoggerFactory.getLogger(GuestCommandServiceImpl.class);

    private final CommandGateway commandGateway;

    public GuestCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> createGuest(RegisterGuestRequestDomain registerGuestRequestDomain) throws GuestException {
        return commandGateway.send(new RegisterGuestCommand(registerGuestRequestDomain.getPhoneNumber(),
                registerGuestRequestDomain.getName(),
                registerGuestRequestDomain.getAddress()));
    }

    public CompletableFuture<String> updateReservations(UpdateReservationsRequestDomain updateReservationsRequestDomain) throws GuestException {
        return commandGateway.send(new UpdateReservationsCommand(updateReservationsRequestDomain.getPhoneNummer(),
                updateReservationsRequestDomain.getName(),
                updateReservationsRequestDomain.getReservationNumber()));

    }

}
