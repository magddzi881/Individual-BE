package com.example.individual.repository;

import com.example.individual.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Rating entities.
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
