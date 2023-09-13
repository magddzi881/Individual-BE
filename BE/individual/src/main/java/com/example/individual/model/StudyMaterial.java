package com.example.individual.model;

import jakarta.persistence.*;

@Entity
@Table(name = "study_materials")
public class StudyMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "tutor_username", nullable = false)
    private String tutorUsername;

    @Column(name = "category", nullable = false)
    private String category;



    public StudyMaterial() {
        // Default constructor
    }

    public StudyMaterial(int id, String text, String tutorUsername, String category) {
        this.id = id;
        this.text = text;
        this.tutorUsername = tutorUsername;
        this.category = category;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTutorUsername() {
        return tutorUsername;
    }

    public void setTutorUsername(String tutorUsername) {
        this.tutorUsername = tutorUsername;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
