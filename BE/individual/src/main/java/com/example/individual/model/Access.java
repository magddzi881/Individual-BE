package com.example.individual.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accesses")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "from_user", nullable = false)
    private String from;

    @Column(name = "to_user", nullable = false)
    private String to;

    @Column(name = "study_material_id", nullable = false)
    private int studyMaterialId;

    public Access() {
        // Default constructor
    }

    public Access(int id, String from, String to, int studyMaterialId) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.studyMaterialId = studyMaterialId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getStudyMaterialId() {
        return studyMaterialId;
    }

    public void setStudyMaterialId(int studyMaterialId) {
        this.studyMaterialId = studyMaterialId;
    }
}
