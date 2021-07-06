package com.practical.hotel.dao;

import com.practical.hotel.entity.Hotel;
import com.practical.hotel.exception.HotelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Repository
public class HotelDAOImpl implements HotelDAO{

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelDAOImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public Hotel saveHotel(Hotel hotel) {
        LOGGER.info("Saving hotel details to the DB");
        return mongoTemplate.save(hotel);
    }

    public List<Hotel> fetchHotel(String name, String area) {
        LOGGER.info("Fetching hotels from the DB");
        Optional<List<Hotel>> hotels = findHotels(name, area);
        return hotels.orElse(null);
    }

    public boolean deleteHotel(String name, String area) throws HotelException {
        LOGGER.info("Deleting hotels from the DB");
        if(CollectionUtils.isEmpty(fetchHotel(name, area))){
            throw new HotelException(101, "No hotels found");
        }
        else{
            return mongoTemplate.remove(getQuery(name, area), Hotel.class).wasAcknowledged();
        }
    }

    //fetches guest from the database
    private Optional<List<Hotel>> findHotels(String name, String area){
        return Optional.ofNullable(mongoTemplate.find(getQuery(name, area), Hotel.class));
    }

    //Builds query
    private Query getQuery(String name, String area) {
        LOGGER.info("Building query");
        var query = new Query();
        var criteria = Criteria.where("name").is(name);

        if(StringUtils.hasLength(area)) {
            criteria.and("address.area").is(area);
        }
        query.addCriteria(criteria);
        return query;
    }
}
