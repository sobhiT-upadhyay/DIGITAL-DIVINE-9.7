package com.booking.service.impl;

import com.booking.entities.Schedule;
import com.booking.repository.ScheduleRepository;
import com.booking.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Override
    public Schedule createSchedule(Schedule schedule) {
        schedule.setCreatedAt(new Date());
        schedule.setUpdatedAt(new Date());
        return scheduleRepository.save(schedule);

    }
    @Override
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Schedule modifySchedule(Long id, Schedule modifiedSchedule) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            schedule.setBus(modifiedSchedule.getBus());
            schedule.setRoute(modifiedSchedule.getRoute());
            schedule.setDepartureTime(modifiedSchedule.getDepartureTime());
            schedule.setArrivalTime(modifiedSchedule.getArrivalTime());
            schedule.setPrice(modifiedSchedule.getPrice());
            schedule.setUpdatedAt(new Date());
            return scheduleRepository.save(schedule);
        }
        return null; // or throw an exception if required
    }
}

