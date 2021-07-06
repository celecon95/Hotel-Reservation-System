package com.practical.hotel.dao;

import com.mongodb.client.result.DeleteResult;
import com.practical.hotel.entity.Hotel;
import com.practical.hotel.exception.HotelException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.practical.hotel.common.CommonTestData.createHotelEntity;

@RunWith(MockitoJUnitRunner.class)
public class HotelDAOTests {

    @Mock
    private MongoTemplate mongoTemplate;

    @Mock
    private DeleteResult deleteResult;

    @InjectMocks
    private HotelDAOImpl hotelDAO;

    @Test
    public void saveHotel_ValidResponse() throws IOException {
        Mockito.when(mongoTemplate.save(createHotelEntity())).thenReturn(createHotelEntity());
        Hotel response = hotelDAO.saveHotel(createHotelEntity());
        Assert.assertNotNull(response);
    }

    @Test
    public void saveGuest_InValidResponse() throws IOException {
        Mockito.when(mongoTemplate.save(createHotelEntity())).thenReturn(null);
        Hotel response = hotelDAO.saveHotel(createHotelEntity());
        Assert.assertNull(response);
    }

    @Test
    public void fetchHotels_ValidResponse() throws IOException {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(createHotelEntity());
        Mockito.when(mongoTemplate.find(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(hotels);
        List<Hotel> response = hotelDAO.fetchHotel("Hotel Prince", "R P Nagar");
        Assert.assertNotNull(response);
    }

    @Test
    public void fetchHotels_EmptyResponse(){
        Mockito.when(mongoTemplate.find(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(null);
        List<Hotel> response = hotelDAO.fetchHotel("Hotel Prince", "R S Nagar");
        Assert.assertNull(response);
    }

    @Test
    public void DeleteHotel_ValidResponse() throws IOException, HotelException {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(createHotelEntity());
        Mockito.when(mongoTemplate.find(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(hotels);
        Mockito.when(deleteResult.wasAcknowledged()).thenReturn(true);
        Mockito.when(mongoTemplate.remove(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(deleteResult);

        boolean response = hotelDAO.deleteHotel("Hotel Prince", "R S Nagar");
    }

    @Test
    public void DeleteHotel_ThrowException() {
        Mockito.when(mongoTemplate.find(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(null);

        try {
            hotelDAO.deleteHotel("Hotel Prince", "R S Nagar");
        } catch (HotelException e) {
            Assert.assertEquals("No hotels found", e.getMessage());
        }
    }
}
