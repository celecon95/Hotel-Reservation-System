package com.practical.reservation.exception;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RunWith(MockitoJUnitRunner.class)
public class ReservationExceptionHandlerTests {

    @InjectMocks
    private ReservationExceptionHandler reservationExceptionHandler;

    @Test
    public void checkExceptionInResponse() throws Exception {
        ResponseEntity<Error> expected = new ResponseEntity<Error>(new Error(100, "Exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        ResponseEntity<Error> actual = reservationExceptionHandler.handleGenericException(new Exception("Exception occurred"));

        Assert.assertEquals(expected.getBody(), actual.getBody());
    }

    @Test
    public void checkReservationExceptionInResponse() throws Exception {

        ResponseEntity<Error> expected = new ResponseEntity<Error>(new Error(101, "Exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        ResponseEntity<Error> actual = reservationExceptionHandler.handleReservationException(new ReservationException(101, "Exception occurred"));

        Assert.assertEquals(expected.getBody(), actual.getBody());
    }

    @Test
    public void checkRunTimeExceptionInResponse() throws Exception {

        ResponseEntity<Error> expected = new ResponseEntity<Error>(new Error(101, "Exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        ResponseEntity<Error> actual = reservationExceptionHandler.handleRunTimeException(new RuntimeException("Exception occurred"));

        Assert.assertEquals(expected.getBody(), actual.getBody());
    }
}
