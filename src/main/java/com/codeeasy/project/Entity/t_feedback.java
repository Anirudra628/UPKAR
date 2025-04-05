package com.codeeasy.project.Entity;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;

@Component
@Entity
public class t_feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedback_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private t_users user;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private t_doctors doctor;

    @Column(nullable = false)
    private Integer rating;

    @Column(length = 500)
    private String comments;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime feedback_date;

    // Default constructor
    public t_feedback() {}

    // Parameterized constructor
    public t_feedback(t_users user, t_doctors doctor, Integer rating, String comments, LocalDateTime feedback_date) {
        this.user = user;
        this.doctor = doctor;
        this.rating = rating;
        this.comments = comments;
        this.feedback_date = feedback_date;
    }

    // Getters and Setters
    public Long getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(Long feedback_id) {
        this.feedback_id = feedback_id;
    }

    public t_users getUser() {
        return user;
    }

    public void setUser(t_users user) {
        this.user = user;
    }

    public t_doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(t_doctors doctor) {
        this.doctor = doctor;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getFeedback_date() {
        return feedback_date;
    }

    public void setFeedback_date(LocalDateTime feedback_date) {
        this.feedback_date = feedback_date;
    }
}