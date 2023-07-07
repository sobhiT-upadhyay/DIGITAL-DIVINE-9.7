package com.booking.service.impl;

import com.booking.entities.UserPaymentMethod;
import com.booking.payload.UserPaymentMethodDTO;
import com.booking.repository.UserPaymentMethodRepository;
import com.booking.service.UserPaymentMethodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentMethodServiceImpl implements UserPaymentMethodService {

    private final UserPaymentMethodRepository userPaymentMethodRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserPaymentMethodServiceImpl(UserPaymentMethodRepository userPaymentMethodRepository, ModelMapper modelMapper) {
        this.userPaymentMethodRepository = userPaymentMethodRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserPaymentMethodDTO createUserPaymentMethod(UserPaymentMethodDTO userPaymentMethodDTO) {
        UserPaymentMethod userPaymentMethod = modelMapper.map(userPaymentMethodDTO, UserPaymentMethod.class);
        UserPaymentMethod savedUserPaymentMethod = userPaymentMethodRepository.save(userPaymentMethod);
        return modelMapper.map(savedUserPaymentMethod, UserPaymentMethodDTO.class);
    }
}
