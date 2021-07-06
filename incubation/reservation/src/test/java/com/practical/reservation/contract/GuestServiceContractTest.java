package com.practical.reservation.contract;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.practical:Guest:+:stubs:13186")
public class GuestServiceContractTest {

    public final String baseUrl = "http://127.0.0.1:13186";

    public HttpHeaders httpHeaders = new HttpHeaders();
    {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void Contract_updateReservations_Happy(){

        HttpEntity<String> entity = new HttpEntity<>("{\"name\":\"Jacks\",\"phoneNummer\":9129232331,\"reservationNumber\":769576905}", httpHeaders);

        String url = baseUrl+"/guest/updateReservations";

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }


}
