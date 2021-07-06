package com.practical.hotel.contract;

import com.practical.hotel.controller.HotelController;
import com.practical.hotel.domain.RegisterHotelResponseDomain;
import com.practical.hotel.exception.HotelException;
import com.practical.hotel.service.HotelServiceImpl;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static com.practical.hotel.common.CommonTestData.createRegisterHotelRequestDomain;

@SpringBootTest
@ActiveProfiles("localtest")
public class ContractVerifierBase {

    @Mock
    private HotelServiceImpl hotelService;

    @Autowired
    private HotelController hotelController;

    @BeforeEach
    public void setup() throws HotelException, IOException {
        Mockito.when(hotelService.registerHotel(createRegisterHotelRequestDomain())).thenReturn(new RegisterHotelResponseDomain("Hotel registered successfully"));

        RestAssuredMockMvc.standaloneSetup(hotelController);
    }
}
