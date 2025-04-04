package com.codeeasy.project.Entity;
//import java.util.*;
import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class t_users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer user_id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String address;
    private String phone;
    private String email;


    public t_users (Integer age,String first_name,String last_name,String address, String phone, String email){
        this.age = age;
        this.address = address;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
       
    }

    public t_users() {}


    public void setdetails(Integer age,String first_name,String last_name,String address, String phone, String email){


        this.age = age;
        this.address = address;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
            
    }

    public String getaddress(){
        return this.address;
    }

    public Integer getage(){
        return this.age;
    }


    public String getfirst_name(){
        return this.first_name;
    }

    public String getlast_name(){
        return this.last_name;
    }

    public String getemail(){
        return this.email;
    }

    public String getphone(){
        return this.phone;
    
}
}
