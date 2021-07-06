package com.practical.guest.contract;

import com.practical.guest.controller.GuestController;
import com.practical.guest.exception.GuestException;
import com.practical.guest.service.GuestServiceImpl;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.practical.guest.common.CommonTestData.*;

@SpringBootTest
@ActiveProfiles("localtest")
public class ContractVerifierBase {

    @Mock
    private GuestServiceImpl guestService;

    @InjectMocks
    private GuestController guestController;

    @BeforeEach
    public void setup() throws GuestException {
        Mockito.when(guestService.createGuest(createRegisterGuestRequestDomain())).thenReturn(createSignUpResponseDomain());

        Mockito.when(guestService.updateReservations(createUpdateReservationsRequestDomain())).thenReturn(createUpdateReservationsResponseDomain());

        RestAssuredMockMvc.standaloneSetup(guestController);
    }

}
