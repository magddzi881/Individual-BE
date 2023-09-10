package com.example.individual.controller;

import com.example.individual.model.Offer;
import com.example.individual.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing offers.
 */
@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;

    /**
     * Get all offers.
     *
     * @return List of all offers.
     */
    @GetMapping
    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    /**
     * Get offers by category.
     *
     * @param category The category of the offers.
     * @return List of offers in the specified category.
     */
    @GetMapping("/byCategory")
    public List<Offer> getOffersByCategory(@RequestParam("category") String category) {
        return offerRepository.findByCategory(category);
    }

    /**
     * Get an offer by its unique ID.
     *
     * @param id The unique ID of the offer.
     * @return ResponseEntity containing the offer if found, or a not-found response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") Long id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);
        return optionalOffer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new offer.
     *
     * @param offer The Offer object to be created.
     * @return ResponseEntity containing the created Offer object.
     */
    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        Offer createdOffer = offerRepository.save(offer);
        return ResponseEntity.ok(createdOffer);
    }

    /**
     * Get offers by a tutor's username.
     *
     * @param tutorUsername The username of the tutor.
     * @return List of offers posted by the tutor.
     */
    @GetMapping("/byTutor")
    public List<Offer> getOffersByTutor(@RequestParam("tutor_username") String tutorUsername) {
        return offerRepository.findByTutorUsername(tutorUsername);
    }

    /**
     * Search for offers by a keyword.
     *
     * @param keyword The keyword to search for in offer titles and descriptions.
     * @return ResponseEntity containing a list of offers matching the keyword if found, or a not-found response.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Offer>> searchOffersByKeyword(@RequestParam("keyword") String keyword) {
        List<Offer> offers = offerRepository.findOffersByKeyword(keyword);

        if (offers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(offers);
    }

    /**
     * Update an existing offer by ID.
     *
     * @param id           The unique ID of the offer to be updated.
     * @param updatedOffer The updated Offer object.
     * @return ResponseEntity containing the updated Offer object if found, or a not-found response.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable("id") Long id, @RequestBody Offer updatedOffer) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);
        if (optionalOffer.isPresent()) {
            Offer offer = optionalOffer.get();


            if (updatedOffer.getTitle() != null) {
                offer.setTitle(updatedOffer.getTitle());
            }
            if (updatedOffer.getDescription() != null) {
                offer.setDescription(updatedOffer.getDescription());
            }
            if (updatedOffer.getTutorUsername() != null) {
                offer.setTutorUsername(updatedOffer.getTutorUsername());
            }
            if (updatedOffer.getCategory() != null) {
                offer.setCategory(updatedOffer.getCategory());
            }
            if (updatedOffer.getPrice() != 0.0) {
                offer.setPrice(updatedOffer.getPrice());
            }
            if (updatedOffer.getCity() != null) {
                offer.setCity(updatedOffer.getCity());
            }
            if (updatedOffer.getCreationTime() != null) {
                offer.setCreationTime(updatedOffer.getCreationTime());
            }


            Offer updated = offerRepository.save(offer);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Delete an offer by its unique ID.
     *
     * @param id The unique ID of the offer to be deleted.
     * @return ResponseEntity containing a success message if the offer is deleted, or a not-found response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOffer(@PathVariable("id") Long id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);
        if (optionalOffer.isPresent()) {
            offerRepository.deleteById(id);
            return ResponseEntity.ok("Deleted."); // A success message
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
