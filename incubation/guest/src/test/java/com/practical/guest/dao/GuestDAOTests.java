package com.practical.guest.dao;

import com.practical.guest.entity.Guest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Set;

import static com.practical.guest.common.CommonTestData.*;

@RunWith(MockitoJUnitRunner.class)
public class GuestDAOTests {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private GuestDAOImpl guestDAO;

    @Test
    public void saveGuest_ValidResponse(){
        Mockito.when(mongoTemplate.save(createGuest())).thenReturn(createGuest());
        Guest response = guestDAO.saveGuest(createGuest());
        Assert.assertNotNull(response);
    }

    @Test
    public void saveGuest_Valid_Response(){
        Mockito.when(mongoTemplate.findOne(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(createGuest());
        Guest response = guestDAO.saveGuest(createGuest());
        Assert.assertNotNull(response);
    }

    @Test
    public void saveGuest_InValidResponse(){
        Mockito.when(mongoTemplate.findOne(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(null);
        Guest response = guestDAO.saveGuest(createGuest());
        Assert.assertNull(response);
    }

    @Test
    public void fetchReservations_ValidResponse(){
        Guest guest = createGuest();
        guest.setReservations(createReservations());
        Mockito.when(mongoTemplate.findOne(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(guest);
        Set<String> response = guestDAO.fetchReservations("Jack", "8648648236");
        Assert.assertNotNull(response);
    }

    @Test
    public void fetchReservations_EmptyResponse(){
        Mockito.when(mongoTemplate.findOne(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(createGuest());
        Set<String> response = guestDAO.fetchReservations("Jack", "8648648236");
        Assert.assertNull(response);
    }

    @Test
    public void updateReservations_ValidResponse(){
        Guest guest = createGuest();
        guest.setReservations(createReservations());
        Mockito.when(mongoTemplate.findOne(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(guest);
        Set<String> response = guestDAO.updateReservations("Jack", "8648648236", "6438568o56");
        Assert.assertNotNull(response);
    }

    @Test
    public void updateReservations_InValidResponse(){
        Mockito.when(mongoTemplate.findOne(Mockito.any(Query.class), Mockito.any(Class.class))).thenReturn(createGuest());
        Set<String> response = guestDAO.updateReservations("Jack", "8648648236", "65956495643");
        Assert.assertNotNull(response);
    }
}
