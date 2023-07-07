package com.booking.controller;

import com.booking.entities.UserOffer;
import com.booking.service.UserOfferService;
import com.booking.util.UserOfferId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-offers")
public class UserOfferController {

    @Autowired
    private UserOfferService userOfferService;
    //localhost:8080/api/user-offers/create
    @PostMapping("/create")
    public ResponseEntity<UserOffer> createUserOffer(@RequestBody UserOffer userOffer) {
        UserOffer createdUserOffer = userOfferService.createUserOffer(userOffer);
        return ResponseEntity.ok(createdUserOffer);
    }

    @DeleteMapping("/{userId}/{offerId}")
    public ResponseEntity<String> deleteUserOffer(@PathVariable Long userId, @PathVariable Long offerId) {
        UserOfferId userOfferId = new UserOfferId(userId, offerId);
        userOfferService.deleteUserOffer(userOfferId);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping
    public ResponseEntity<UserOffer> updateUserOffer(@RequestBody UserOffer userOffer) {
        UserOffer updatedUserOffer = userOfferService.updateUserOffer(userOffer);
        return ResponseEntity.ok(updatedUserOffer);
    }

    @GetMapping("/{userId}/{offerId}")
    public ResponseEntity<UserOffer> getUserOffer(@PathVariable Long userId, @PathVariable Long offerId) {
        UserOfferId userOfferId = new UserOfferId(userId, offerId);
        UserOffer userOffer = userOfferService.getUserOffer(userOfferId);
        if (userOffer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userOffer);
    }
}
