package com.booking.controller;

import com.booking.entities.Bus;
import com.booking.entities.BusOperator;
import com.booking.entities.Route;
import com.booking.entities.Schedule;
import com.booking.service.BusOperatorService;
import com.booking.service.BusService;
import com.booking.service.RouteService;
import com.booking.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {
    private BusService busService;

    private BusOperatorService busOperatorService;

    private RouteService routeService;

    private ScheduleService scheduleService;
    public BookingController(BusService busService, BusOperatorService
            busOperatorService, RouteService routeService, ScheduleService
                                     scheduleService) {
        this.busService = busService;
        this.busOperatorService = busOperatorService;
        this.routeService = routeService;
        this.scheduleService = scheduleService;
    }


    // Create Bus Operator
    //localhost:8080/api/bus-operators
    @PostMapping("/bus-operators")
    public ResponseEntity<BusOperator> createBusOperator(@RequestBody BusOperator busOperator) {
        BusOperator createdBusOperator = busOperatorService.createBusOperator(busOperator);
        return new ResponseEntity<>(createdBusOperator, HttpStatus.CREATED);
    }

    // Delete Bus Operator
    //localhost:8080/api/bus-operators/2
    @DeleteMapping("/bus-operators/{id}")
    public ResponseEntity<String> deleteBusOperator(@PathVariable Long id) {
        busOperatorService.deleteBusOperator(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }


    // Modify Bus Operator
    //localhost:8080/api/bus-operators/1
    @PutMapping("/bus-operators/{id}")
    public ResponseEntity<BusOperator> modifyBusOperator(@PathVariable Long id,
                                                         @RequestBody BusOperator modifiedBusOperator) {
        BusOperator updatedBusOperator = busOperatorService.modifyBusOperator(id, modifiedBusOperator);
        if (updatedBusOperator != null) {
            return new ResponseEntity<>(updatedBusOperator, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create Bus
    @PostMapping("/buses")
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus createdBus = busService.createBus(bus);
        return new ResponseEntity<>(createdBus, HttpStatus.CREATED);
    }

    // Delete Bus
    @DeleteMapping("/buses/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    // Modify Bus
    @PutMapping("/buses/{id}")
    public ResponseEntity<Bus> modifyBus(@PathVariable Long id, @RequestBody Bus modifiedBus) {
        Bus updatedBus = busService.modifyBus(id, modifiedBus);
        if (updatedBus != null) {
            return new ResponseEntity<>(updatedBus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create Route
    @PostMapping("/routes")
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        Route createdRoute = routeService.createRoute(route);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    // Delete Route
    @DeleteMapping("/routes/{id}")
    public ResponseEntity<String> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    // Modify Route
    @PutMapping("/routes/{id}")
    public ResponseEntity<Route> modifyRoute(@PathVariable Long id, @RequestBody Route modifiedRoute) {
        Route updatedRoute = routeService.modifyRoute(id, modifiedRoute);
        if (updatedRoute != null) {
            return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create Schedule
    @PostMapping("/schedules")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule createdSchedule = scheduleService.createSchedule(schedule);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }

    // Delete Schedule
    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    // Modify Schedule
    @PutMapping("/schedules/{id}")
    public ResponseEntity<Schedule> modifySchedule(@PathVariable Long id,
                                                   @RequestBody Schedule modifiedSchedule) {
        Schedule updatedSchedule = scheduleService.modifySchedule(id, modifiedSchedule);
        if (updatedSchedule != null) {
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
