package com.practical.guest.query.service;

import com.practical.guest.common.assembler.EntityMapper;
import com.practical.guest.common.event.GuestRegisteredEvent;
import com.practical.guest.common.event.ReservationsUpdatedEvent;
import com.practical.guest.query.dao.GuestDAO;
import com.practical.guest.query.entity.Guest;
import com.practical.guest.query.query.FindGuest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManageGuestService {

    @Autowired
    private GuestDAO guestDAO;

    @EventHandler
    public void on(GuestRegisteredEvent guestRegisteredEvent){
        log.info("Handling GuestRegisteredEvent");
        guestDAO.saveGuest(EntityMapper.buildGuestEntity(guestRegisteredEvent));
    }

    @EventHandler
    public void on(ReservationsUpdatedEvent reservationsUpdatedEvent){
        log.info("Handling reservationsUpdatedEvent");
        guestDAO.updateReservations(reservationsUpdatedEvent.getName(), reservationsUpdatedEvent.getPhoneNumber(), reservationsUpdatedEvent.getReservationNumber());
    }

    @QueryHandler
    public Guest handle(FindGuest findGuest){
        log.info("Handling findGuest");
        return guestDAO.findGuest(findGuest.getName(), findGuest.getPhoneNumber()).orElse(null);
    }


}
