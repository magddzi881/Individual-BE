package com.example.individual.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tutor_username", nullable = false)
    private String tutorUsername;

    @Column(name = "points", nullable = false)
    private int points;

    @Column(name = "question_count", nullable = false)
    private int questionCount;

    @Column(name = "study_material_id", nullable = false)
    private int studyMaterialId;
    public Quiz() {
        // Default constructor
    }

    public Quiz(int id, String tutorUsername, int points, int questionCount, int studyMaterialId) {
        this.id = id;
        this.tutorUsername = tutorUsername;
        this.points = points;
        this.questionCount = questionCount;
        this.studyMaterialId = studyMaterialId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTutorUsername() {
        return tutorUsername;
    }

    public void setTutorUsername(String tutorUsername) {
        this.tutorUsername = tutorUsername;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
    public int getstudyMaterialId() {
        return studyMaterialId;
    }

    public void setstudyMaterialId(int studyMaterialId) {
        this.studyMaterialId = studyMaterialId;
    }



}
