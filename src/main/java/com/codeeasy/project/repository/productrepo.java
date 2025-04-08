package com.codeeasy.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeeasy.project.Entity.t_users;

@Repository
public interface productrepo  extends JpaRepository<t_users,Integer>, CustomMethod {

    Optional<t_users> findByEmail(String email); // Integer is the primary key datatype

    
}
