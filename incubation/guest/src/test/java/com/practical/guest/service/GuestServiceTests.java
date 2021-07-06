package com.practical.guest.service;

import com.practical.guest.dao.GuestDAO;
import com.practical.guest.domain.GuestReservationsResponseDomain;
import com.practical.guest.domain.RegisterGuestResponseDomain;
import com.practical.guest.domain.UpdateReservationsRequestDomain;
import com.practical.guest.domain.UpdateReservationsResponseDomain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.practical.guest.common.CommonTestData.*;

@RunWith(MockitoJUnitRunner.class)
public class GuestServiceTests {

    @Mock
    private GuestDAO guestDAO;

    @InjectMocks
    private GuestServiceImpl guestService;

    @Test
    public void createGuest_ValidResponse() throws Exception {
        Mockito.when(guestDAO.saveGuest(createGuest())).thenReturn(createGuest());
        RegisterGuestResponseDomain actualResponse = guestService.createGuest(createRegisterGuestRequestDomain());
        Assert.assertEquals("Guest created successfully", actualResponse.getMessage());
    }

    @Test
    public void createGuest_Exception() {
        try {
            guestService.createGuest(createRegisterGuestRequestDomain());
        } catch (Exception e) {
            Assert.assertEquals("Guest creation failed", e.getMessage());
        }

    }

    @Test
    public void fetchReservations_ValidResponse() throws Exception {
        GuestReservationsResponseDomain expectedResponse = createGuestReservationsResponseDomain();
        Mockito.when(guestDAO.fetchReservations("Jack", "9129232331")).thenReturn(createReservations());
        GuestReservationsResponseDomain actualResponse = guestService.fetchReservations(createGuestReservationsRequestDomain());
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void fetchReservations_Exception() {
        try {
            guestService.fetchReservations(createGuestReservationsRequestDomain());
        } catch (Exception e) {
            Assert.assertEquals("Reservations not found", e.getMessage());
        }

    }

    @Test
    public void updateReservations_ValidResponse() throws Exception {
        Mockito.when(guestDAO.updateReservations("Jacks", "9129232331", "769576905")).thenReturn(createReservations());
        UpdateReservationsResponseDomain actualResponse = guestService.updateReservations(createUpdateReservationsRequestDomain());
        Assert.assertEquals("Reservation number updated successfully", actualResponse.getMessage());
    }

    @Test
    public void updateReservations_InValidResponse() {
        Mockito.when(guestDAO.updateReservations("Jacks", "9129232331", "769576908")).thenReturn(createReservations());
        try {
            UpdateReservationsRequestDomain requestDomain = createUpdateReservationsRequestDomain();
            requestDomain.setReservationNumber("769576908");
            guestService.updateReservations(requestDomain);
        } catch (Exception e) {
            Assert.assertEquals("Cannot update the reservations", e.getMessage());
        }
    }

    @Test
    public void updateReservations_Exception() {
        try {
            guestService.updateReservations(createUpdateReservationsRequestDomain());
        } catch (Exception e) {
            Assert.assertEquals("Reservations not found", e.getMessage());
        }

    }

}
