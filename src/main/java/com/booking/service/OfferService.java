package com.booking.service;

import com.booking.entities.Offer;

import java.util.List;

public interface OfferService {
    Offer createOffer(Offer offer);
    void deleteOffer(Long offerId);
    Offer updateOffer(Offer offer);
    Offer getOfferById(Long offerId);
    List<Offer> getAllOffers();
}
