package com.practical.reservation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.practical.reservation.common.Constants.EXCEPTION_MSG;


@ControllerAdvice
public class ReservationExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(Exception e){
        LOGGER.error(EXCEPTION_MSG, e);
        return new ResponseEntity<Error>(buildError(100, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> handleRunTimeException(RuntimeException e){
        LOGGER.error(EXCEPTION_MSG, e);
        return new ResponseEntity<Error>(buildError(101, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<Error> handleReservationException(ReservationException e){
        LOGGER.error(EXCEPTION_MSG, e);
        return new ResponseEntity<Error>(buildError(e.getErrorCode(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    private Error buildError(int code, String message){
        return new Error(code, message);
    }
}
