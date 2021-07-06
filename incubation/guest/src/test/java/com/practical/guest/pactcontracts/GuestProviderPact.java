package com.practical.guest.pactcontracts;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import com.practical.guest.controller.GuestController;
import com.practical.guest.exception.GuestException;
import com.practical.guest.service.GuestService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static com.practical.guest.common.CommonTestData.createUpdateReservationsRequestDomain;
import static com.practical.guest.common.CommonTestData.createUpdateReservationsResponseDomain;

@RunWith(RestPactRunner.class)
@Provider("guestservice")
@PactFolder("pacts")
public class GuestProviderPact {

    @InjectMocks
    private GuestController guestController;

    @Mock
    private GuestService guestService;

    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    @Before
    public void setUp(){
        target.setControllers(guestController);
    }

    @State("updateReservations")
    public void statePactUpdateReservations() throws GuestException {
        Mockito.when(guestService.updateReservations(createUpdateReservationsRequestDomain()))
                .thenReturn(createUpdateReservationsResponseDomain());
    }

}
