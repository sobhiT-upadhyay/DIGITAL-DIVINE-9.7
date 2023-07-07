package com.booking.service.impl;

import com.booking.entities.UserOffer;
import com.booking.repository.UserOfferRepository;
import com.booking.service.UserOfferService;
import com.booking.util.UserOfferId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOfferServiceImpl implements UserOfferService {

    @Autowired
    private UserOfferRepository userOfferRepository;

    @Override
    public UserOffer createUserOffer(UserOffer userOffer) {
        return userOfferRepository.save(userOffer);
    }

    @Override
    public void deleteUserOffer(UserOfferId userOfferId) {
        userOfferRepository.deleteById(userOfferId);
    }

    @Override
    public UserOffer updateUserOffer(UserOffer userOffer) {
        return userOfferRepository.save(userOffer);
    }

    @Override
    public UserOffer getUserOffer(UserOfferId userOfferId) {
        return userOfferRepository.findById(userOfferId).orElse(null);
    }
}
