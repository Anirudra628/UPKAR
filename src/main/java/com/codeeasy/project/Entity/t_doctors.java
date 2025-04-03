package com.codeeasy.project.Entity;
//import java.util.*;
import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class t_doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer doctor_id;
    private String first_name;
    private String last_name;
    private String password;
    private String degree;
    private String phone;
    private String specialization;
    private String address;
    private String status;
    private Integer fees;
    private String registration_id;


    public t_doctors (String first_name,String last_name,String password, String degree, String phone, 
                     String specialization, String address, String status, Integer fees, String registration_id){
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.degree = degree;
        this.phone = phone;
        this.specialization = specialization;
        this.address = address;
        this.status = status;
        this.fees = fees;
        this.registration_id = registration_id;
       
    }

    public t_doctors() {}


    public void setdetails(String first_name,String last_name,String password, String degree, String phone, 
    String specialization, String address, String status, Integer fees, String registration_id){


        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.degree = degree;
        this.phone = phone;
        this.specialization = specialization;
        this.address = address;
        this.status = status;
        this.fees = fees;
        this.registration_id = registration_id;
       
            
    }

    public String getaddress(){
        return this.address;
    }

    public String getfirst_name(){
        return this.first_name;
    }

    public String getlast_name(){
        return this.last_name;
    }
    public String getpassword(){
        return this.password;
    }
    public String getdegree(){
        return this.degree;
    }
    public String getphone(){
        return this.phone;
    }
    public String getspecialization(){
        return this.specialization;
    }
    public String getstatus(){
        return this.status;
    }
    public Integer getfees(){
        return this.fees;
    }
    public String getregistration_id(){
        return this.registration_id;
    }

}
