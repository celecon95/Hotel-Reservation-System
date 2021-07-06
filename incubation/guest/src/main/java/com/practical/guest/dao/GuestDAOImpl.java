package com.practical.guest.dao;

import com.practical.guest.entity.Guest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class GuestDAOImpl implements GuestDAO{

    private static final Logger LOGGER = LoggerFactory.getLogger(GuestDAOImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public Guest saveGuest(Guest guest) {
        LOGGER.info("Saving guest details to the DB");
        if(findGuest(guest.getName(), guest.getPhoneNumber()).isPresent()){
            return guest;
        }
        return mongoTemplate.save(guest);
    }

    public Set<String> fetchReservations(String name, String phoneNumber){
        LOGGER.info("Fetching reservations from the DB");
        Optional<Guest> guest = findGuest(name, phoneNumber);
        return guest.map(Guest::getReservations).orElse(null);
    }

    public Set<String> updateReservations(String name, String phoneNumber, String registrationNumber) {
        LOGGER.info("Updating the reservations in the DB");
        Optional<Guest> guestOptional = findGuest(name, phoneNumber);

        if(guestOptional.isPresent()) {
            var guest = guestOptional.get();
            Set<String> reservations = guest.getReservations();

            if(CollectionUtils.isEmpty(reservations)) {
                reservations = new HashSet<>();
            }
            reservations.add(registrationNumber);
            guest.setReservations(reservations);
            mongoTemplate.save(guest);
        }
        return fetchReservations(name, phoneNumber);
    }

    //fetches guest from the database
    private Optional<Guest> findGuest(String name, String phoneNumber){
        return Optional.ofNullable(mongoTemplate.findOne(getQuery(name, phoneNumber), Guest.class));
    }

    //Builds query
    private Query getQuery(String name, String phoneNumber) {
        LOGGER.info("Building query");
        var query = new Query();
        var criteria = Criteria.where("name").is(name);
        criteria.and("phoneNumber").is(phoneNumber);
        query.addCriteria(criteria);
        return query;
    }
}
