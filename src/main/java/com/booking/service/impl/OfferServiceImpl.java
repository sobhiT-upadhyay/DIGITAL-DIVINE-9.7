package com.booking.service.impl;

import com.booking.entities.Offer;
import com.booking.repository.OfferRepository;
import com.booking.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Offer createOffer(Offer offer) {
        offer.setCreatedAt(new Date());
        return offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(Long offerId) {
        offerRepository.deleteById(offerId);
    }

    @Override
    public Offer updateOffer(Offer offer) {
        offer.setUpdatedAt(new Date());
        return offerRepository.save(offer);
    }

    @Override
    public Offer getOfferById(Long offerId) {
        return offerRepository.findById(offerId).orElse(null);
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
}
