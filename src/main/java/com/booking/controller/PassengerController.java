package com.booking.controller;

import com.booking.payload.PassengerDTO;
import com.booking.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }
    //localhost:8080/api/passengers
    @PostMapping
    public ResponseEntity<PassengerDTO> createPassenger(@Validated @RequestBody PassengerDTO passengerDTO) {
        PassengerDTO createdPassenger = passengerService.createPassenger(passengerDTO);
        return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerDTO> modifyPassenger(@PathVariable Long id, @Validated @RequestBody PassengerDTO modifiedPassengerDTO) {
        PassengerDTO updatedPassenger = passengerService.modifyPassenger(id, modifiedPassengerDTO);
        if (updatedPassenger != null) {
            return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
