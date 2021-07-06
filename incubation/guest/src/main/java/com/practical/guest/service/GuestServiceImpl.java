package com.practical.guest.service;

import com.practical.guest.dao.GuestDAO;
import com.practical.guest.domain.*;
import com.practical.guest.exception.GuestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.Set;

import static com.practical.guest.common.EntityMapper.buildGuestEntity;

@Service
public class GuestServiceImpl implements GuestService{

    private static final Logger LOGGER = LoggerFactory.getLogger(GuestServiceImpl.class);

    @Autowired
    private GuestDAO guestDAO;

    public RegisterGuestResponseDomain createGuest(RegisterGuestRequestDomain registerGuestRequestDomain) throws GuestException {

        LOGGER.info("Creating guest");
        if(Objects.nonNull(guestDAO.saveGuest(buildGuestEntity(registerGuestRequestDomain)))){
            LOGGER.info("Guest created");
           return new RegisterGuestResponseDomain("Guest created successfully");
        }
        else {
            throw new GuestException(101, "Guest creation failed");
        }
    }

    public GuestReservationsResponseDomain fetchReservations(GuestReservationsRequestDomain guestReservationsRequestDomain) throws GuestException {
        Set<String> reservations = guestDAO.fetchReservations(guestReservationsRequestDomain.getName(), guestReservationsRequestDomain.getPhonenumber());

        if(CollectionUtils.isEmpty(reservations)){
            throw new GuestException(102, "Reservations not found");
        }
        else{
            LOGGER.info("Reservations fetched successfully");
            GuestReservationsResponseDomain guestReservationsResponseDomain = new GuestReservationsResponseDomain();
            guestReservationsResponseDomain.setReservations(reservations);
            return guestReservationsResponseDomain;
        }
    }

    public UpdateReservationsResponseDomain updateReservations(UpdateReservationsRequestDomain updateReservationsRequestDomain) throws GuestException {
        Set<String> reservations = guestDAO.updateReservations(updateReservationsRequestDomain.getName(), updateReservationsRequestDomain.getPhoneNummer(),
                updateReservationsRequestDomain.getReservationNumber());
        if(CollectionUtils.isEmpty(reservations)){
            throw new GuestException(102, "Reservations not found");
        }
        else if(!reservations.contains(updateReservationsRequestDomain.getReservationNumber())){
            throw new GuestException(103, "Cannot update the reservations");
        }
        else{
            LOGGER.info("Updated reservations");
            UpdateReservationsResponseDomain updateReservationsResponseDomain = new UpdateReservationsResponseDomain();
            updateReservationsResponseDomain.setMessage("Reservation number updated successfully");
            return updateReservationsResponseDomain;
        }

    }

}
