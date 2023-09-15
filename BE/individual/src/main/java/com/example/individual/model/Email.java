package com.example.individual.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "emails")
public class Email {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "send_time", nullable = false)
    private LocalDateTime sendTime;

    @Column(name = "email_to", nullable = false)
    private String emailTo;

    @Column(name = "description", nullable = false)
    private String description;

    public Email(){}

    public Email(LocalDateTime sendTime, String emailTo, String description) {
        this.sendTime = sendTime;
        this.emailTo = emailTo;
this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }


    public Long getId() {
        return id;
    }


}
