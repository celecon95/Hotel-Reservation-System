package com.practical.guest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@Configuration
class GuestServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void main_shouldStartCorrectly(){
		GuestServiceApplication.main(new String[]{"--server.port=0", "--spring.profiles.active=localtest"});
	}


}
