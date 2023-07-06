package com.booking.controller;

import com.booking.entities.Offer;
import com.booking.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;
    //localhost:8080/api/offers
    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        Offer createdOffer = offerService.createOffer(offer);
        return ResponseEntity.ok(createdOffer);
    }
    //localhost:8080/api/offers/1
    @DeleteMapping("/{offerId}")
    public ResponseEntity<String> deleteOffer(@PathVariable Long offerId) {
        offerService.deleteOffer(offerId);
        return ResponseEntity.ok("Deleted successfully");
    }


    @PutMapping("/{offerId}")
    public ResponseEntity<Offer> updateOffer(@PathVariable Long offerId, @RequestBody Offer offer) {
        Offer updatedOffer = offerService.getOfferById(offerId);
        if (updatedOffer == null) {
            return ResponseEntity.notFound().build();
        }
        offer.setId(offerId);
        updatedOffer = offerService.updateOffer(offer);
        return ResponseEntity.ok(updatedOffer);
    }

    @GetMapping("/{offerId}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long offerId) {
        Offer offer = offerService.getOfferById(offerId);
        if (offer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(offer);
    }

    @GetMapping
    public ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offers = offerService.getAllOffers();
        return ResponseEntity.ok(offers);
    }
}
