package com.example.individual.model;

import jakarta.persistence.*;

/**
 * Represents a Rating entity for storing user ratings.
 *
 * This class is an entity mapped to the "ratings" table in the database.
 */
@Entity
@Table(name = "ratings")
public class Rating {

    /**
     * The unique identifier for a rating.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * The username of the user giving the rating.
     */
    @Column(name = "from_user", nullable = false)
    private String from;

    /**
     * The username of the user receiving the rating.
     */
    @Column(name = "to_user", nullable = false)
    private String to;

    /**
     * The numerical rating value given by the user.
     */
    @Column(name = "rating", nullable = false)
    private double rating;

    /**
     * Default constructor for the Rating class.
     */
    public Rating() {
        // Default constructor
    }

    /**
     * Parameterized constructor for the Rating class.
     *
     * @param from   The username of the user giving the rating.
     * @param to     The username of the user receiving the rating.
     * @param rating The numerical rating value given by the user.
     */
    public Rating(String from, String to, double rating) {
        this.from = from;
        this.to = to;
        this.rating = rating;
    }

    // Getter and setter methods with documentation comments...
    /**
     * Gets the unique identifier for the rating.
     *
     * @return The rating's unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the rating.
     *
     * @param id The rating's unique identifier.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the username of the user giving the rating.
     *
     * @return The username of the user giving the rating.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the username of the user giving the rating.
     *
     * @param from The username of the user giving the rating.
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets the username of the user receiving the rating.
     *
     * @return The username of the user receiving the rating.
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the username of the user receiving the rating.
     *
     * @param to The username of the user receiving the rating.
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets the numerical rating value given by the user.
     *
     * @return The numerical rating value given by the user.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the numerical rating value given by the user.
     *
     * @param rating The numerical rating value given by the user.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
}

