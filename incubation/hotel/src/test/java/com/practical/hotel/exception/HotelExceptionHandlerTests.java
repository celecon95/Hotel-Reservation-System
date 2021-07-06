package com.practical.hotel.exception;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RunWith(MockitoJUnitRunner.class)
public class HotelExceptionHandlerTests {

    @InjectMocks
    private HotelExceptionHandler hotelExceptionHandler;

    @Test
    public void checkExceptionInResponse() throws Exception {
        ResponseEntity<Error> expected = new ResponseEntity<Error>(new Error(100, "Exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        ResponseEntity<Error> actual = hotelExceptionHandler.handleGenericException(new Exception("Exception occurred"));

        Assert.assertEquals(expected.getBody(), actual.getBody());
    }

    @Test
    public void checkHotelExceptionInResponse() throws Exception {

        ResponseEntity<Error> expected = new ResponseEntity<Error>(new Error(101, "Exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        ResponseEntity<Error> actual = hotelExceptionHandler.handleHotelException(new HotelException(101, "Exception occurred"));

        Assert.assertEquals(expected.getBody(), actual.getBody());
    }

    @Test
    public void checkRunTimeExceptionInResponse() throws Exception {

        ResponseEntity<Error> expected = new ResponseEntity<Error>(new Error(101, "Exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        ResponseEntity<Error> actual = hotelExceptionHandler.handleRunTimeException(new RuntimeException("Exception occurred"));

        Assert.assertEquals(expected.getBody(), actual.getBody());
    }
}
