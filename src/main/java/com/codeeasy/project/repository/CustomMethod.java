package com.codeeasy.project.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

@Repository
public interface CustomMethod {

    List<List<String>> getappointmentId(String email); // Integer is the primary key datatype

    List<List<String>> get_particular_appointment(String email, String appointment_id); // Integer is the primary key datatype
    
}
