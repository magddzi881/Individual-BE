package com.example.individual.controller;

import com.example.individual.model.Rating;
import com.example.individual.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * REST controller for managing ratings.
 */
@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    /**
     * Get all ratings.
     *
     * @return List of all ratings.
     */
    @GetMapping
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    /**
     * Get a rating by its unique ID.
     *
     * @param id The unique ID of the rating.
     * @return ResponseEntity containing the rating if found, or a not-found response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable("id") int id) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        return optionalRating.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new rating.
     *
     * @param rating The Rating object to be created.
     * @return ResponseEntity containing the created Rating object.
     */
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating createdRating = ratingRepository.save(rating);
        return ResponseEntity.ok(createdRating);
    }

    /**
     * Update an existing rating by ID.
     *
     * @param id           The unique ID of the rating to be updated.
     * @param updatedRating The updated Rating object.
     * @return ResponseEntity containing the updated Rating object if found, or a not-found response.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable("id") int id, @RequestBody Rating updatedRating) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) {
            Rating rating = optionalRating.get();


            if (updatedRating.getFrom() != null) {
                rating.setFrom(updatedRating.getFrom());
            }
            if (updatedRating.getTo() != null) {
                rating.setTo(updatedRating.getTo());
            }
            if (updatedRating.getRating() != 0) {
                rating.setRating(updatedRating.getRating());
            }

            Rating updated = ratingRepository.save(rating);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Delete a rating by its unique ID.
     *
     * @param id The unique ID of the rating to be deleted.
     * @return ResponseEntity containing a success message if the rating is deleted, or a not-found response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable("id") int id) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) {
            ratingRepository.deleteById(id);
            return ResponseEntity.ok("Deleted."); // A success message
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
