package com.example.individual.model;

import jakarta.persistence.*;

/**
 * Represents a User entity for storing user information.
 *
 * This class is an entity mapped to the "users" table in the database.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * The unique username of the user.
     */
    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    /**
     * The email address of the user.
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * The password associated with the user's account.
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * The first name of the user.
     */
    @Column(name = "name")
    private String name;

    /**
     * The last name of the user.
     */
    @Column(name = "surname")
    private String surname;

    /**
     * The year of birth of the user.
     */
    @Column(name = "year_of_birth")
    private String yearOfBirth;

    /**
     * The gender of the user.
     */
    @Column(name = "gender")
    private String gender;

    /**
     * The index of the user's avatar.
     */
    @Column(name = "avatar_index")
    private int avatarIndex;

    /**
     * The user's rating.
     */
    @Column(name = "rating")
    private double rating;

    /**
     * Default constructor for the User class.
     */
    public User() {
        // Default constructor
    }

    /**
     * Parameterized constructor for the User class.
     *
     * @param username    The unique username of the user.
     * @param email       The email address of the user.
     * @param password    The password associated with the user's account.
     * @param name        The first name of the user.
     * @param surname     The last name of the user.
     * @param yearOfBirth The year of birth of the user.
     * @param gender      The gender of the user.
     * @param avatarIndex The index of the user's avatar.
     * @param rating      The user's rating.
     */
    public User(String username, String email, String password, String name, String surname, String yearOfBirth, String gender, int avatarIndex, double rating) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.avatarIndex = avatarIndex;
        this.rating = rating;
    }

    // Getter and setter methods with documentation comments...
    /**
     * Gets the unique username of the user.
     *
     * @return The unique username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the unique username of the user.
     *
     * @param username The unique username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password associated with the user's account.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password associated with the user's account.
     *
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the first name of the user.
     *
     * @param name The first name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the last name of the user.
     *
     * @param surname The last name of the user.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the year of birth of the user.
     *
     * @return The year of birth of the user.
     */
    public String getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Sets the year of birth of the user.
     *
     * @param yearOfBirth The year of birth of the user.
     */
    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Gets the gender of the user.
     *
     * @return The gender of the user.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the user.
     *
     * @param gender The gender of the user.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the index of the user's avatar.
     *
     * @return The index of the user's avatar.
     */
    public int getAvatarIndex() {
        return avatarIndex;
    }

    /**
     * Sets the index of the user's avatar.
     *
     * @param avatarIndex The index of the user's avatar.
     */
    public void setAvatarIndex(int avatarIndex) {
        this.avatarIndex = avatarIndex;
    }

    /**
     * Gets the user's rating.
     *
     * @return The user's rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the user's rating.
     *
     * @param rating The user's rating.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
}

