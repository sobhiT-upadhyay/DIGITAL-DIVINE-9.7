package com.booking.service;

import com.booking.entities.BusOperator;

public interface BusOperatorService {
    BusOperator createBusOperator(BusOperator busOperator);
    void deleteBusOperator(Long id);
    BusOperator modifyBusOperator(Long id, BusOperator modifiedBusOperator);
}
