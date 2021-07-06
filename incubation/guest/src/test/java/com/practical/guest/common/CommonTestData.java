package com.practical.guest.common;

import com.practical.guest.domain.*;
import com.practical.guest.dto.*;
import com.practical.guest.entity.Guest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonTestData {

    public static RegisterGuestRequest createRegisterGuestRequest(){
        RegisterGuestRequest registerGuestRequest = new RegisterGuestRequest();
        registerGuestRequest.setName("Jack");
        registerGuestRequest.setPhoneNumber("9129232331");
        registerGuestRequest.setAddress(createAddressDto());
        return registerGuestRequest;
    }

    public static RegisterGuestRequestDomain createRegisterGuestRequestDomain(){
        RegisterGuestRequestDomain signUpRequest = new RegisterGuestRequestDomain();
        signUpRequest.setName("Jack");
        signUpRequest.setPhoneNumber("9129232331");
        signUpRequest.setAddress(createAddressDomain());
        return signUpRequest;
    }

    public static com.practical.guest.dto.Address createAddressDto(){
        com.practical.guest.dto.Address address = new com.practical.guest.dto.Address();
        address.setDoorNo("123");
        address.setStreetAddress("2nd cross, HighPark Colony");
        address.setCity("Mumbai");
        address.setState("Maharashtra");
        address.setZipCode("1638246");
        return address;
    }

    public static com.practical.guest.domain.Address createAddressDomain(){
        com.practical.guest.domain.Address address = new com.practical.guest.domain.Address();
        address.setDoorNo("123");
        address.setStreetAddress("2nd cross, HighPark Colony");
        address.setCity("Mumbai");
        address.setState("Maharashtra");
        address.setZipCode("1638246");
        return address;
    }

    public static RegisterGuestResponse createSignUpResponse(){
        RegisterGuestResponse registerGuestResponse = new RegisterGuestResponse();
        registerGuestResponse.setMessage("Guest registered successfully");
        return registerGuestResponse;
    }

    public static RegisterGuestResponseDomain createSignUpResponseDomain(){
        RegisterGuestResponseDomain signUpResponse = new RegisterGuestResponseDomain();
        signUpResponse.setMessage("Guest registered successfully");
        return signUpResponse;
    }

    public static Guest createGuest(){
        return createGuestEntity(createRegisterGuestRequestDomain());
    }

    private static com.practical.guest.entity.Address createAddress(com.practical.guest.domain.Address address) {
        com.practical.guest.entity.Address addressEntity = new com.practical.guest.entity.Address();
        addressEntity.setDoorNo(address.getDoorNo());
        addressEntity.setStreetAddress(address.getStreetAddress());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setZipCode(address.getZipCode());
        return addressEntity;
    }

    private static Guest createGuestEntity(RegisterGuestRequestDomain registerGuestRequest) {
        Guest guest = new Guest();
        guest.setName(registerGuestRequest.getName());
        guest.setPhoneNumber(registerGuestRequest.getPhoneNumber());
        guest.setAddress(createAddress(registerGuestRequest.getAddress()));
        return guest;
    }

    public static GuestReservationsRequestDomain createGuestReservationsRequestDomain(){
        return new GuestReservationsRequestDomain("Jack", "9129232331");
    }

    public static UpdateReservationsRequestDomain createUpdateReservationsRequestDomain(){
        return new UpdateReservationsRequestDomain("Jacks", "9129232331", "769576905");
    }

    public static Set<String> createReservations(){
        return new HashSet<String>(Arrays.asList("68965396584", "769576905"));
    }

    public static GuestReservationsResponseDomain createGuestReservationsResponseDomain(){
       return new GuestReservationsResponseDomain(createReservations());
    }

    public static UpdateReservationsResponseDomain createUpdateReservationsResponseDomain(){
        return new UpdateReservationsResponseDomain("Reservations updated successfully");
    }

    public static GuestReservationsRequest createGuestReservationsRequest(){
        return new GuestReservationsRequest("Jack", "9129232331");
    }

    public static UpdateReservationsRequest createUpdateReservationsRequest(){
        return new UpdateReservationsRequest("Jacks", "9129232331", "769576905");
    }

    public static GuestReservationsResponse createGuestReservationsResponse(){
        return new GuestReservationsResponse(createReservations());
    }

    public static UpdateReservationsResponse createUpdateReservationsResponse(){
        return new UpdateReservationsResponse("Reservations updated successfully");
    }
}
