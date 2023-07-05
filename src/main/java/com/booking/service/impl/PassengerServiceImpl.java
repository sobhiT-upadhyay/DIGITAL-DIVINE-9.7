package com.booking.service.impl;

import com.booking.payload.PassengerDTO;
import com.booking.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final Map<Long, PassengerDTO> passengers = new HashMap<>();

    @Override
    public PassengerDTO createPassenger(PassengerDTO passengerDTO) {
        Long id = generateId();
        passengerDTO.setId(id);
        passengers.put(id, passengerDTO);
        return passengerDTO;
    }

    @Override
    public void deletePassenger(Long id) {
        passengers.remove(id);
    }

    @Override
    public PassengerDTO modifyPassenger(Long id, PassengerDTO modifiedPassengerDTO) {
        PassengerDTO passenger = passengers.get(id);
        if (passenger != null) {
            modifiedPassengerDTO.setId(id);
            passengers.put(id, modifiedPassengerDTO);
            return modifiedPassengerDTO;
        } else {
            return null;
        }
    }

    private Long generateId() {
        return System.currentTimeMillis();
    }
}
