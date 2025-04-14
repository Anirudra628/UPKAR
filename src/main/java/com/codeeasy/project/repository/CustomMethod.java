package com.codeeasy.project.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

@Repository
public interface CustomMethod {

    List<List<String>> getappointmentId(String email); // Integer is the primary key datatype
    List<List<String>> search_doctors(String location, String specialization, String clinic_type,String day);
    Integer save_appointment(String email,String relation, String doctor_id, String location_id, String slot_id,String confirm);

    Integer add_patient(String email, String p_fname, String p_lname, String dob, String sex, String relation);
    
    
}
