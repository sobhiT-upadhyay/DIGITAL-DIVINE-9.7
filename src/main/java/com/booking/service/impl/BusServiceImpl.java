package com.booking.service.impl;

import com.booking.entities.Bus;
import com.booking.repository.BusRepository;
import com.booking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;
    @Override
    public Bus createBus(Bus bus) {
        bus.setCreatedAt(new Date());
        bus.setUpdatedAt(new Date());

        return busRepository.save(bus);
    }

    @Override
    public void deleteBus(Long id) {
        busRepository.deleteById(id);

    }

    @Override
    public Bus modifyBus(Long id, Bus modifiedBus) {
        Optional<Bus> optionalBus = busRepository.findById(id);
        if (optionalBus.isPresent()) {
            Bus bus = optionalBus.get();
            bus.setBusType(modifiedBus.getBusType());
            bus.setTotalSeats(modifiedBus.getTotalSeats());
            bus.setAmenities(modifiedBus.getAmenities());
            bus.setUpdatedAt(new Date());
            return busRepository.save(bus);
        }
        return null;

    }
}
