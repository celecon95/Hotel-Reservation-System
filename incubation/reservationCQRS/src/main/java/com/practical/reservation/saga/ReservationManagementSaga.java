package com.practical.reservation.saga;

import com.practical.reservation.common.event.HotelReservedEvent;
import com.practical.reservation.common.event.ReservationsUpdatedEvent;
import commands.UpdateReservationsCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
@Slf4j
public class ReservationManagementSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "reservationNumber")
    public void handle(HotelReservedEvent hotelReservedEvent){
        log.info("Saga invoked");

        //associate Saga
        SagaLifecycle.associateWith("phoneNumber", hotelReservedEvent.getGuestDetails().getGuestNumber());

        log.info("reservationNumber : "+hotelReservedEvent.getReservationNumber());

        //send the commands
        commandGateway.send(new UpdateReservationsCommand(hotelReservedEvent.getGuestDetails().getGuestNumber(),
                hotelReservedEvent.getGuestDetails().getGuestName(), hotelReservedEvent.getReservationNumber()));
    }

    @SagaEventHandler(associationProperty = "phoneNumber")
    public void handle(ReservationsUpdatedEvent reservationsUpdatedEvent){

        System.out.println("Ending Saga cycle");
        SagaLifecycle.end();

        }


}
