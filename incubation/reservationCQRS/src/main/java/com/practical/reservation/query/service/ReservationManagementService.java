package com.practical.reservation.query.service;

import com.practical.reservation.common.EntityMapper;
import com.practical.reservation.common.event.HotelReservedEvent;
import com.practical.reservation.query.dao.ReservationDAO;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReservationManagementService {

    @Autowired
    private ReservationDAO reservationDAO;

    @EventHandler
    public void on(HotelReservedEvent hotelReservedEvent){
        log.info("Handling HotelReservedEvent");
        reservationDAO.saveReservation(EntityMapper.buildReservationEntity(hotelReservedEvent));
    }
}
