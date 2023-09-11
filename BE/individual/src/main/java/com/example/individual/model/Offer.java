package com.example.individual.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;

/**
 * Represents an Offer entity for storing information about offers.
 *
 * This class is an entity mapped to the "offers" table in the database.
 */
@Entity
@Table(name = "offers")
public class Offer {

    /**
     * The unique identifier for an offer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The title of the offer.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * The description of the offer.
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * The username of the tutor associated with the offer.
     */

    @Column(name = "tutor_username", nullable = false)
    private String tutorUsername;

    /**
     * The category of the offer.
     */
    @Column(name = "category", nullable = false)
    private String category;

    /**
     * The price of the offer.
     */
    @Column(name = "price", nullable = false)
    private double price;

    /**
     * The city where the offer is available.
     */
    @Column(name = "city", nullable = false)
    private String city;

    /**
     * The date and time when the offer was created.
     */
    @Column(name = "creation_time", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creationTime;

    /**
     * Default constructor for the Offer class.
     */
    public Offer() {
        // Default constructor
    }

    /**
     * Parameterized constructor for the Offer class.
     *
     * @param title         The title of the offer.
     * @param description   The description of the offer.
     * @param tutorUsername The username of the tutor associated with the offer.
     * @param category      The category of the offer.
     * @param price         The price of the offer.
     * @param city          The city where the offer is available.
     * @param creationTime  The date and time when the offer was created.
     */
    public Offer(String title, String description, String tutorUsername, String category, double price, String city, Date creationTime) {
        this.title = title;
        this.description = description;
        this.tutorUsername = tutorUsername;
        this.category = category;
        this.price = price;
        this.city = city;
        this.creationTime = creationTime;
    }

    // Getter and setter methods with documentation comments...
    /**
     * Gets the unique identifier for the offer.
     *
     * @return The offer's unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the offer.
     *
     * @param id The offer's unique identifier.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the title of the offer.
     *
     * @return The title of the offer.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the offer.
     *
     * @param title The title of the offer.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the offer.
     *
     * @return The description of the offer.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the offer.
     *
     * @param description The description of the offer.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the username of the tutor associated with the offer.
     *
     * @return The username of the tutor.
     */
    public String getTutorUsername() {
        return tutorUsername;
    }

    /**
     * Sets the username of the tutor associated with the offer.
     *
     * @param tutorUsername The username of the tutor.
     */
    public void setTutorUsername(String tutorUsername) {
        this.tutorUsername = tutorUsername;
    }

    /**
     * Gets the category of the offer.
     *
     * @return The category of the offer.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the offer.
     *
     * @param category The category of the offer.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the price of the offer.
     *
     * @return The price of the offer.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the offer.
     *
     * @param price The price of the offer.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the city where the offer is available.
     *
     * @return The city where the offer is available.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the offer is available.
     *
     * @param city The city where the offer is available.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the date and time when the offer was created.
     *
     * @return The date and time of creation.
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the date and time when the offer was created.
     *
     * @param creationTime The date and time of creation.
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}

