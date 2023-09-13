package com.example.individual.model;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quiz_id", nullable = false)
    private int quizId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "answer1", nullable = false)
    private String answer1;

    @Column(name = "answer2", nullable = false)
    private String answer2;

    @Column(name = "answer3", nullable = false)
    private String answer3;

    @Column(name = "answer4", nullable = false)
    private String answer4;

    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;

    public Question() {
        // Default constructor
    }

    public Question(int id, int quizId, String title, String answer1, String answer2, String answer3, String answer4, String correctAnswer) {
        this.id = id;
        this.quizId = quizId;
        this.title = title;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
