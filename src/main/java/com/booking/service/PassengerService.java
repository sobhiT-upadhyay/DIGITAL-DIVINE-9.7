package com.booking.service;

import com.booking.payload.PassengerDTO;

public interface PassengerService {
    PassengerDTO createPassenger(PassengerDTO passengerDTO);
    void deletePassenger(Long id);
    PassengerDTO modifyPassenger(Long id, PassengerDTO modifiedPassengerDTO);
}
