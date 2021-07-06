package com.practical.guest.exception;

import com.practical.guest.controller.GuestController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class GuestExceptionHandlerTests {

    @InjectMocks
    private GuestExceptionHandler guestExceptionHandler;

    @Test
    public void checkExceptionInResponse() throws Exception {
        ResponseEntity<Error> expected = new ResponseEntity<Error>(new Error(100, "Exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        ResponseEntity<Error> actual = guestExceptionHandler.handleGenericException(new Exception("Exception occurred"));

        Assert.assertEquals(expected.getBody(), actual.getBody());
    }

    @Test
    public void checkGuestExceptionInResponse() throws Exception {

        ResponseEntity<Error> expected = new ResponseEntity<Error>(new Error(101, "Exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        ResponseEntity<Error> actual = guestExceptionHandler.handleGuestException(new GuestException(101, "Exception occurred"));

        Assert.assertEquals(expected.getBody(), actual.getBody());
    }

    @Test
    public void checkRunTimeExceptionInResponse() throws Exception {

        ResponseEntity<Error> expected = new ResponseEntity<Error>(new Error(101, "Exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        ResponseEntity<Error> actual = guestExceptionHandler.handleRunTimeException(new RuntimeException("Exception occurred"));

        Assert.assertEquals(expected.getBody(), actual.getBody());
    }
}
