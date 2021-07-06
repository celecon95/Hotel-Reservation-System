package com.practical.guest.controller;


import com.practical.guest.dto.GuestReservationsResponse;
import com.practical.guest.dto.RegisterGuestResponse;
import com.practical.guest.dto.UpdateReservationsResponse;
import com.practical.guest.exception.GuestException;
import com.practical.guest.service.GuestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static com.practical.guest.common.CommonTestData.*;


@RunWith(MockitoJUnitRunner.class)
public class GuestControllerTests {

    @Mock
    private GuestService guestService;

    @InjectMocks
    private GuestController guestController;

    @Test
    public void registerGuest_ValidResponse() throws Exception {
        Mockito.when(guestService.createGuest(createRegisterGuestRequestDomain())).thenReturn(createSignUpResponseDomain());
        ResponseEntity<RegisterGuestResponse> expectedResponse = ResponseEntity.ok(createSignUpResponse());
        ResponseEntity<RegisterGuestResponse> actualResponse = guestController.registerGuest(createRegisterGuestRequest());
        Assert.assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        Assert.assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }

    @Test
    public void registerGuest_InValidResponse() throws Exception {
        Mockito.doThrow(new GuestException(101, "Exception occured while processing Guest")).when(guestService).createGuest(createRegisterGuestRequestDomain());
        try {
            guestController.registerGuest(createRegisterGuestRequest());
        }
        catch (Exception e) {
            Assert.assertNotNull(e.getMessage());
        }
    }

    @Test
    public void fetchReservations_ValidResponse() throws Exception {
        Mockito.when(guestService.fetchReservations(createGuestReservationsRequestDomain())).thenReturn(createGuestReservationsResponseDomain());
        ResponseEntity<GuestReservationsResponse> expectedResponse = ResponseEntity.ok(createGuestReservationsResponse());
        ResponseEntity<GuestReservationsResponse> actualResponse = guestController.fetchReservations(createGuestReservationsRequest());

        Assert.assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        Assert.assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }

    @Test
    public void fetchReservations_InValidResponse() throws Exception {
        GuestException guestException = new GuestException();
        guestException.setErrorCode(102);
        guestException.setMessage("Exception occured while retrieving reservations");
        Mockito.doThrow(guestException).when(guestService).fetchReservations(createGuestReservationsRequestDomain());
        try {
            guestController.fetchReservations(createGuestReservationsRequest());
        }
        catch (Exception e) {
            Assert.assertNotNull(e.getMessage());
        }
    }

    @Test
    public void updateReservations_ValidResponse() throws Exception {
        Mockito.when(guestService.updateReservations(createUpdateReservationsRequestDomain())).thenReturn(createUpdateReservationsResponseDomain());
        ResponseEntity<UpdateReservationsResponse> expectedResponse = ResponseEntity.ok(createUpdateReservationsResponse());
        ResponseEntity<UpdateReservationsResponse> actualResponse = guestController.updateReservations(createUpdateReservationsRequest());

        Assert.assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        Assert.assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }

    @Test
    public void updateReservations_InValidResponse() throws Exception {
        Mockito.doThrow(new GuestException(101, "Exception occured while updating reservations")).when(guestService).updateReservations(createUpdateReservationsRequestDomain());
        try {
            guestController.updateReservations(createUpdateReservationsRequest());
        }
        catch (Exception e) {
            Assert.assertNotNull(e.getMessage());
        }
    }

}
