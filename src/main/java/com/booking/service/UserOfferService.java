package com.booking.service;

import com.booking.entities.UserOffer;
import com.booking.util.UserOfferId;

public interface UserOfferService {
    UserOffer createUserOffer(UserOffer userOffer);

    void deleteUserOffer(UserOfferId userOfferId);

    UserOffer updateUserOffer(UserOffer userOffer);

    UserOffer getUserOffer(UserOfferId userOfferId);
}
