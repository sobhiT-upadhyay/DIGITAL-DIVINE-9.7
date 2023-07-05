package com.booking.service.impl;

import com.booking.entities.BusOperator;
import com.booking.repository.BusOperatorRepository;
import com.booking.service.BusOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BusOperatorServiceImpl implements BusOperatorService {
    @Autowired
    private BusOperatorRepository busOperatorRepository;

    @Override
    public BusOperator createBusOperator(BusOperator busOperator) {
        busOperator.setCreatedAt(new Date());
        busOperator.setUpdatedAt(new Date());
        return busOperatorRepository.save(busOperator);
    }

    @Override
    public void deleteBusOperator(Long id) {
        busOperatorRepository.deleteById(id);
    }

    @Override
    public BusOperator modifyBusOperator(Long id, BusOperator modifiedBusOperator) {
        Optional<BusOperator> optionalBusOperator = busOperatorRepository.findById(id);
        if (optionalBusOperator.isPresent()) {
            BusOperator busOperator = optionalBusOperator.get();
            busOperator.setOperatorName(modifiedBusOperator.getOperatorName());
            busOperator.setContactEmail(modifiedBusOperator.getContactEmail());
            busOperator.setContactPhone(modifiedBusOperator.getContactPhone());
            busOperator.setLogoUrl(modifiedBusOperator.getLogoUrl());
            busOperator.setUpdatedAt(new Date());
            return busOperatorRepository.save(busOperator);
        }
        return null; // or throw an exception if required
    }
}
