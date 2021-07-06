package com.practical.reservation.controller;

import com.practical.reservation.dto.ReserveHotelResponse;
import com.practical.reservation.dto.SearchReservationResponse;
import com.practical.reservation.exception.ReservationException;
import com.practical.reservation.service.ReservationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static com.practical.reservation.common.CommonTestData.*;

@RunWith(MockitoJUnitRunner.class)
public class ReservationControllerTests {

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;

    @Test
    public void reserveHotel_ValidResponse() throws Exception {
        Mockito.when(reservationService.reserveHotel(createReserveHotelDomain())).thenReturn(createReserveHotelResponseDomain());
        ResponseEntity<ReserveHotelResponse> expectedResponse = ResponseEntity.ok(createReserveHotelResponseDto());
        ResponseEntity<ReserveHotelResponse> actualResponse = reservationController.reserveHotel(createReserveHotelDto());
        Assert.assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        Assert.assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }

    @Test
    public void reserveHotel_InValidResponse() throws Exception {
        Mockito.doThrow(new ReservationException(101, "Exception occured while processing Reservation")).when(reservationService).reserveHotel(createReserveHotelDomain());
        try {
            reservationController.reserveHotel(createReserveHotelDto());
        }
        catch (Exception e) {
            Assert.assertNotNull(e.getMessage());
        }
    }

    @Test
    public void searchReservation_ValidResponse() throws Exception {
        Mockito.when(reservationService.searchReservation(createSearchReservationRequestDomain())).thenReturn(createSearchReservationResponseDomain());
        ResponseEntity<SearchReservationResponse> expectedResponse = ResponseEntity.ok(createSearchReservationResponse());
        ResponseEntity<SearchReservationResponse> actualResponse = reservationController.searchReservation(createSearchReservationRequest());

        Assert.assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        Assert.assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }

    @Test
    public void searchReservation_InValidResponse() throws Exception {
        ReservationException reservationException = new ReservationException();
        reservationException.setErrorCode(102);
        reservationException.setMessage("Exception occured while retrieving reservations");
        Mockito.doThrow(reservationException).when(reservationService).searchReservation(createSearchReservationRequestDomain());
        try {
            reservationController.searchReservation(createSearchReservationRequest());
        }
        catch (Exception e) {
            Assert.assertNotNull(e.getMessage());
        }
    }
}
