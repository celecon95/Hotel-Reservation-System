package com.practical.reservation.client;

import com.practical.reservation.payload.UpdateReservationsRequest;
import com.practical.reservation.payload.UpdateReservationsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "guestservice", url = "localhost:8082")
public interface GuestServiceProxy {

    @PostMapping("/guest/updateReservations")
    ResponseEntity<UpdateReservationsResponse> updateReservation(@RequestBody UpdateReservationsRequest updateReservationsRequest);
}
