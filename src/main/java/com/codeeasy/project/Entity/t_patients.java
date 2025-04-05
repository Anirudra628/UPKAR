package com.codeeasy.project.Entity;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Column;
import java.util.Date;

@Component
@Entity
public class t_patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    @Column(nullable = false, length = 50)
    private String first_name;

    @Column(nullable = false, length = 50)
    private String last_name;

    @Column(nullable = false, length = 10)
    private String gender;

    @Column(nullable = false)
    private Date birth_date;

    @Lob
    private byte[] medical_history;

    @Column(nullable = false, length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'Active'")
    private String status;

    // Default constructor
    public t_patients() {}

    // Parameterized constructor
    public t_patients(String first_name, String last_name, String gender, Date birth_date, byte[] medical_history, String status) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.medical_history = medical_history;
        this.status = status;
    }

    // Getters and Setters
    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public byte[] getMedical_history() {
        return medical_history;
    }

    public void setMedical_history(byte[] medical_history) {
        this.medical_history = medical_history;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}