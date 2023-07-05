package com.booking.service;

import com.booking.entities.Schedule;

public interface ScheduleService {
    Schedule createSchedule(Schedule schedule);

    void deleteSchedule(Long id);

    Schedule modifySchedule(Long id, Schedule modifiedSchedule);

}
