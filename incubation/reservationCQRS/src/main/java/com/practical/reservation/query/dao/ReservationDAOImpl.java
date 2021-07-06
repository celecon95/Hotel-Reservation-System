package com.practical.reservation.query.dao;

import com.practical.reservation.common.ReservationDate;
import com.practical.reservation.query.entity.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationDAOImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public Reservation saveReservation(Reservation reservation) {
      return mongoTemplate.save(reservation);
    }

    public Reservation fetchReservation(String reservationNumber) {

        Optional<Reservation> reservation = Optional.ofNullable(mongoTemplate.findOne(getQueryOnReservationNumber(reservationNumber), Reservation.class));
        return reservation.orElse(null);
    }

    public Reservation fetchReservation(String hotelName, String roomType, ReservationDate reservationDate) {
        Optional<Reservation> reservation = Optional.ofNullable(mongoTemplate.findOne(getQueryForMultipleParam(hotelName, roomType, reservationDate), Reservation.class));
        return reservation.orElse(null);
    }


    //Builds query
    private Query getQueryOnReservationNumber(String reservationNumber) {
        LOGGER.info("Building query based on reservation number");
        var query = new Query();
        var criteria = Criteria.where("reservationNumber").is(reservationNumber);
        query.addCriteria(criteria);
        return query;
    }

    private Query getQueryForMultipleParam(String hotelName, String roomType, ReservationDate reservationDate) {
        LOGGER.info("Building query based on hotel name, room type and reservation date");
        var query = new Query();
        var criteria = Criteria.where("hotelDetails.hotelName").is(hotelName);
        criteria.and("hotelDetails.roomType").is(roomType);
        criteria.and("reservationDate.reservationFrom").gt(reservationDate.getReservationFrom().minusDays(1)).lt(reservationDate.getReservationTo().plusDays(1));
        criteria.and("reservationDate.reservationTo").gt(reservationDate.getReservationFrom().minusDays(1)).lt(reservationDate.getReservationTo().plusDays(1));
        query.addCriteria(criteria);
        return query;
    }
}
