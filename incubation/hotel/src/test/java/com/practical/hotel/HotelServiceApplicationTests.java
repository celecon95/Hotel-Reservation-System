package com.practical.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void main_shouldStartCorrectly(){
		HotelServiceApplication.main(new String[]{"--server.port=0", "--spring.profiles.active=localtest"});
	}

}
