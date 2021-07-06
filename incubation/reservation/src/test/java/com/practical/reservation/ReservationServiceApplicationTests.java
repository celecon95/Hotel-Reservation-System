package com.practical.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservationServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void main_shouldStartCorrectly(){
		ReservationServiceApplication.main(new String[]{"--server.port=0", "--spring.profiles.active=localtest"});
	}
}
