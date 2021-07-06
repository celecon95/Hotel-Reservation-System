package com.practical.hotel.controller;

import com.practical.hotel.domain.DeleteHotelResponseDomain;
import com.practical.hotel.domain.RegisterHotelResponseDomain;
import com.practical.hotel.domain.SearchHotelResponseDomain;
import com.practical.hotel.dto.DeleteHotelResponse;
import com.practical.hotel.dto.RegisterHotelResponse;
import com.practical.hotel.dto.SearchHotelResponse;
import com.practical.hotel.entity.Hotel;
import com.practical.hotel.exception.HotelException;
import com.practical.hotel.service.HotelService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.practical.hotel.common.CommonTestData.*;

@RunWith(MockitoJUnitRunner.class)
public class HotelControllerTests {

    @Mock
    private HotelService hotelService;

    @InjectMocks
    private HotelController hotelController;

    @Test
    public void createHotel_ValidResponse() throws Exception {
        Mockito.when(hotelService.registerHotel(createRegisterHotelRequestDomain())).thenReturn(new RegisterHotelResponseDomain("Hotel registered successfully"));
        ResponseEntity<RegisterHotelResponse> actualResponse = hotelController.registerHotel(createRegisterHotelRequest());
        Assert.assertEquals("Hotel registered successfully", actualResponse.getBody().getMessage());
    }

    @Test
    public void createHotel_Exception() throws IOException, HotelException {
        Mockito.doThrow(new HotelException(101, "Hotel registration failed")).when(hotelService).registerHotel(createRegisterHotelRequestDomain());
        try {
            hotelController.registerHotel(createRegisterHotelRequest());
        } catch (HotelException e) {
            Assert.assertEquals("Hotel registration failed", e.getMessage());
        }
    }

    @Test
    public void fetchHotels_ValidResponse() throws Exception {
        SearchHotelResponse expectedResponse = createSearchResponse();
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(createHotelEntity());
        Mockito.when(hotelService.searchHotels(Mockito.any())).thenReturn(createSearchResponseDomain());
        ResponseEntity<SearchHotelResponse> actualResponse = hotelController.searchHotel(createSearchRequest());
        Assert.assertEquals(expectedResponse, actualResponse.getBody());
    }

    @Test
    public void fetchHotels_Exception() throws IOException, HotelException {
        Mockito.doThrow(new HotelException(101, "No hotels found")).when(hotelService).searchHotels(createSearchRequestDomain());
        try {
            hotelController.searchHotel(createSearchRequest());
        } catch (HotelException e) {
            Assert.assertEquals("No hotels found", e.getMessage());
        }
    }

    @Test
    public void deleteHotels_ValidResponse() throws Exception {
        Mockito.when(hotelService.deleteHotel(Mockito.any())).thenReturn(new DeleteHotelResponseDomain("Hotel deleted successfully"));
        ResponseEntity<DeleteHotelResponse> actualResponse = hotelController.deleteHotel(createDeleteRequest());
        Assert.assertEquals("Hotel deleted successfully", actualResponse.getBody().getMessage());
    }

    @Test
    public void deleteHotels_Exception() throws IOException, HotelException {
        Mockito.doThrow(new HotelException(101, "No hotels found")).when(hotelService).deleteHotel(createDeleteRequestDomain());
        try {
            hotelController.deleteHotel(createDeleteRequest());
        } catch (HotelException e) {
            Assert.assertEquals("No hotels found", e.getMessage());
        }
    }
}
