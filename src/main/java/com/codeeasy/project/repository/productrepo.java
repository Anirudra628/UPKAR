package com.codeeasy.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeeasy.project.Entity.t_users;

@Repository
public interface productrepo  extends JpaRepository<t_users,Integer> { // Integer is the primary key datatype
    
}
