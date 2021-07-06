package com.practical.reservation.service;


import com.practical.reservation.client.GuestServiceProxy;
import com.practical.reservation.common.DomainAssembler;
import com.practical.reservation.common.EntityMapper;
import com.practical.reservation.dao.ReservationDAO;
import com.practical.reservation.domain.ReserveHotelRequestDomain;
import com.practical.reservation.domain.ReserveHotelResponseDomain;
import com.practical.reservation.domain.SearchReservationRequestDomain;
import com.practical.reservation.domain.SearchReservationResponseDomain;
import com.practical.reservation.entity.Reservation;
import com.practical.reservation.exception.ReservationException;
import com.practical.reservation.payload.UpdateReservationsRequest;
import com.practical.reservation.payload.UpdateReservationsResponse;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReservationServiceImpl implements ReservationService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservationDAO reservationDAO;

    /*@Autowired
    private GuestServiceProxy guestServiceProxy;*/

    @Autowired
    private MessageChannel output;

    public ReserveHotelResponseDomain reserveHotel(ReserveHotelRequestDomain reserveHotelRequestDomain) throws ReservationException {

        if(validateReservation(reserveHotelRequestDomain)){
            Reservation reservation = EntityMapper.buildReservationEntity(reserveHotelRequestDomain);
            reservation.setReservationNumber(RandomStringUtils.randomAlphanumeric(16).toUpperCase());
            reservation.setReservationStatus("Reserved");
            reservation = reservationDAO.saveReservation(reservation);

            updateReservation(reservation);

            ReserveHotelResponseDomain reserveHotelResponseDomain = new ReserveHotelResponseDomain();
            reserveHotelResponseDomain.setReservationNumber(reservation.getReservationNumber());
            reserveHotelResponseDomain.setReservationStatus(reservation.getReservationStatus());
            reserveHotelResponseDomain.setModeOfPayment(reservation.getPaymentDetails().getModeOfPayment());
            return reserveHotelResponseDomain;
        }
        else{
            throw new ReservationException(102, "The room is not available for the given request");
        }
    }

    /*private void updateReservation(Reservation reservation) {
        ResponseEntity<UpdateReservationsResponse> updateReservationsResponse = guestServiceProxy.updateReservation(new UpdateReservationsRequest(reservation.getGuestDetails().getGuestName(),
                reservation.getGuestDetails().getGuestNumber(), reservation.getReservationNumber()));

        LOGGER.info((Objects.nonNull(updateReservationsResponse) && Objects.nonNull(updateReservationsResponse.getBody()))?updateReservationsResponse.getBody().getMessage():"updateReservations response is null");
    }*/

    private void updateReservation(Reservation reservation) {
        /*ResponseEntity<UpdateReservationsResponse> updateReservationsResponse = guestServiceProxy.updateReservation(new UpdateReservationsRequest(reservation.getGuestDetails().getGuestName(),
                reservation.getGuestDetails().getGuestNumber(), reservation.getReservationNumber()));
*/
        Boolean messagePublished = output.send(MessageBuilder.withPayload(new UpdateReservationsRequest(reservation.getGuestDetails().getGuestName(),
                reservation.getGuestDetails().getGuestNumber(), reservation.getReservationNumber())).build());
        LOGGER.info("Updated Reservations : "+ messagePublished);
    }

    private Boolean validateReservation(ReserveHotelRequestDomain reserveHotelRequestDomain) {
        Reservation reservation = reservationDAO.fetchReservation(reserveHotelRequestDomain.getHotelDetails().getHotelName(),
                reserveHotelRequestDomain.getHotelDetails().getRoomType(), reserveHotelRequestDomain.getReservationDate());

        if(Objects.nonNull(reservation)){
            return Boolean.FALSE;
        }
        else{
            return Boolean.TRUE;
        }
    }


    public SearchReservationResponseDomain searchReservation(SearchReservationRequestDomain searchReservationRequestDomain) throws ReservationException {
        Reservation reservation = reservationDAO.fetchReservation(searchReservationRequestDomain.getReservationNumber());
        if(Objects.nonNull(reservation)){
            SearchReservationResponseDomain searchReservationResponseDomain = new SearchReservationResponseDomain();
            searchReservationResponseDomain.setReservation(DomainAssembler.buildReservation(reservation));
            return searchReservationResponseDomain;
        }
        throw new ReservationException(101, "Reservation not found");
    }
}
