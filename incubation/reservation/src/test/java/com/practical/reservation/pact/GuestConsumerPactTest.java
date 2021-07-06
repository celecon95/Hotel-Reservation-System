package com.practical.reservation.pact;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.practical.reservation.payload.UpdateReservationsResponse;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.practical.reservation.common.CommonTestData.createUpdateReservationsRequest;
import static com.practical.reservation.common.CommonTestData.createUpdateReservationsResponse;
import static org.springframework.cloud.contract.spec.internal.MediaTypes.APPLICATION_JSON;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class GuestConsumerPactTest {

    @ClassRule
    public static RandomPortRule randomPort = new RandomPortRule();

    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("guestservice", "localhost", randomPort.getPort(), this);

    public HttpHeaders httpHeaders = new HttpHeaders();
    {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }


    @Pact(provider = "guestservice", consumer = "reservationservice")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put(CONTENT_TYPE, APPLICATION_JSON);
         return builder.given("updateReservations")
                 .uponReceiving("POST_REQUEST")
                 .headers(requestHeaders)
                 .body(createUpdateReservationsRequest().toString())
                 .path("/guest/updateReservations")
                 .willRespondWith()
                 .status(HttpStatus.OK.value())
                 .body(createUpdateReservationsResponse())
                 .toPact();
    }

    @Test
    @PactVerification("guestservice")
    public void test() throws IOException {
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(createUpdateReservationsRequest().toString(), httpHeaders);

        ResponseEntity<UpdateReservationsResponse> responseEntity = restTemplate.exchange(provider.getConfig().url() + "/guest/updateReservations", HttpMethod.POST, entity, UpdateReservationsResponse.class);
        UpdateReservationsResponse response = responseEntity.getBody();
        Assert.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode().value());
        Assert.assertNotNull(response);
    }
}
