package com.codeeasy.project.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

@Repository
public interface CustomMethod {

    List<List<String>> getappointmentId(String email); // Integer is the primary key datatype
    List<List<String>> search_doctors(String location, String specialization, String clinic_type,String day);
    
    
}
