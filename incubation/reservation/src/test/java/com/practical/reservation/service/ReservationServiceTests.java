package com.practical.reservation.service;

import com.practical.reservation.client.GuestServiceProxy;
import com.practical.reservation.dao.ReservationDAO;
import com.practical.reservation.domain.ReserveHotelResponseDomain;
import com.practical.reservation.exception.ReservationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static com.practical.reservation.common.CommonTestData.*;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTests {

    @Mock
    private ReservationDAO reservationDAO;

    @Mock
    private GuestServiceProxy guestServiceProxy;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Test
    public void reserveHotel_ValidResponse() throws Exception {
        Mockito.when(reservationDAO.saveReservation(Mockito.any())).thenReturn(createReservationEntity());
        Mockito.when(guestServiceProxy.updateReservation(createUpdateReservationsRequestPayload()))
                .thenReturn(ResponseEntity.ok(createUpdateReservationsResponsePayload()));
        ReserveHotelResponseDomain actualResponse = reservationService.reserveHotel(createReserveHotelDomain());
        Assert.assertNotNull(actualResponse);
    }

    @Test
    public void reserveHotel_throwsException() throws IOException {
        Mockito.when(reservationDAO.fetchReservation(Mockito.anyString(), Mockito.anyString(), Mockito.any())).thenReturn(createReservationEntity());

        ReserveHotelResponseDomain actualResponse = null;
        try {
            actualResponse = reservationService.reserveHotel(createReserveHotelDomain());
        } catch (ReservationException e) {
            Assert.assertEquals("The room is not available for the given request", e.getMessage());
        }
    }
}
