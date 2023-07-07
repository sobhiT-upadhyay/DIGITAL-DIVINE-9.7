package com.booking.controller;

import com.booking.payload.UserPaymentMethodDTO;
import com.booking.service.UserPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user-payment-methods")
public class UserPaymentMethodController {

    private final UserPaymentMethodService userPaymentMethodService;

    @Autowired
    public UserPaymentMethodController(UserPaymentMethodService userPaymentMethodService) {
        this.userPaymentMethodService = userPaymentMethodService;
    }
    //localhost:8080/api/user-payment-methods/create
    @PostMapping("/create")
    public ResponseEntity<UserPaymentMethodDTO> createUserPaymentMethod(@Valid @RequestBody UserPaymentMethodDTO userPaymentMethodDTO) {
        UserPaymentMethodDTO createdUserPaymentMethod = userPaymentMethodService.createUserPaymentMethod(userPaymentMethodDTO);
        return new ResponseEntity<>(createdUserPaymentMethod, HttpStatus.CREATED);
    }
}
