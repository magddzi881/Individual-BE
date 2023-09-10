package com.example.individual.repository;

import com.example.individual.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Offer entities.
 */
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    /**
     * Retrieves a list of offers containing a keyword in their title or description, case-insensitive.
     *
     * @param keyword The keyword to search for in offers' titles or descriptions.
     * @return A list of offers matching the keyword search.
     */
    @Query("SELECT o FROM Offer o WHERE LOWER(o.title) LIKE LOWER(CONCAT('%', LOWER(:keyword), '%')) OR LOWER(o.description) LIKE LOWER(CONCAT('%', LOWER(:keyword), '%'))")
    List<Offer> findOffersByKeyword(@Param("keyword") String keyword);

    /**
     * Retrieves a list of offers by category.
     *
     * @param category The category of offers to retrieve.
     * @return A list of offers belonging to the specified category.
     */
    List<Offer> findByCategory(String category);

    /**
     * Retrieves a list of offers by tutor username.
     *
     * @param tutorUsername The username of the tutor.
     * @return A list of offers posted by the specified tutor.
     */
    List<Offer> findByTutorUsername(String tutorUsername);
}
