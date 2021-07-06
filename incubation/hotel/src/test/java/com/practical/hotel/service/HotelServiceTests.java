package com.practical.hotel.service;

import com.practical.hotel.dao.HotelDAO;
import com.practical.hotel.domain.DeleteHotelResponseDomain;
import com.practical.hotel.domain.RegisterHotelResponseDomain;
import com.practical.hotel.domain.SearchHotelResponseDomain;
import com.practical.hotel.entity.Hotel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.practical.hotel.common.CommonTestData.*;
import static com.practical.hotel.common.CommonTestData.createSearchRequestDomain;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTests {

    @Mock
    private HotelDAO hotelDAO;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Test
    public void createHotel_ValidResponse() throws Exception {
        Mockito.when(hotelDAO.saveHotel(Mockito.any(Hotel.class))).thenReturn(createHotelEntity());
        RegisterHotelResponseDomain actualResponse = hotelService.registerHotel(createRegisterHotelRequestDomain());
        Assert.assertEquals("Hotel registered successfully", actualResponse.getMessage());
    }

    @Test
    public void createHotel_Exception() {
        try {
            hotelService.registerHotel(createRegisterHotelRequestDomain());
        } catch (Exception e) {
            Assert.assertEquals("Hotel registration failed", e.getMessage());
        }
    }

    @Test
    public void fetchHotels_ValidResponse() throws Exception {
        SearchHotelResponseDomain expectedResponse = createSearchResponseDomain();
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(createHotelEntity());
        Mockito.when(hotelDAO.fetchHotel("Hotel Prince", "R P Nagar")).thenReturn(hotels);
        SearchHotelResponseDomain actualResponse = hotelService.searchHotels(createSearchRequestDomain());
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void fetchHotels_Exception() {
        try {
            hotelService.searchHotels(createSearchRequestDomain());
        } catch (Exception e) {
            Assert.assertEquals("No hotels found", e.getMessage());
        }
    }

    @Test
    public void deleteHotels_ValidResponse() throws Exception {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(createHotelEntity());
        Mockito.when(hotelDAO.deleteHotel("Hotel Prince", "R P Nagar")).thenReturn(true);
        DeleteHotelResponseDomain actualResponse = hotelService.deleteHotel(createDeleteRequestDomain());
        Assert.assertEquals("Hotel deleted successfully", actualResponse.getMessage());
    }

    @Test
    public void deleteHotels_Response() throws Exception {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(createHotelEntity());
        Mockito.when(hotelDAO.deleteHotel("Hotel Prince", "R P Nagar")).thenReturn(false);
        DeleteHotelResponseDomain actualResponse = hotelService.deleteHotel(createDeleteRequestDomain());
        Assert.assertEquals("Hotel deletion failed", actualResponse.getMessage());
    }

    @Test
    public void deleteHotels_throwsException() {
        try {
            hotelService.deleteHotel(createDeleteRequestDomain());
        } catch (Exception e) {
            Assert.assertEquals("Hotel deletion failed", e.getMessage());
        }

    }
}
