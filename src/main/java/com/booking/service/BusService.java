package com.booking.service;

import com.booking.entities.Bus;

public interface BusService {

    Bus createBus(Bus bus);
    void deleteBus(Long id);
    Bus modifyBus(Long id, Bus modifiedBus);
}
