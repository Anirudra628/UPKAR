package com.codeeasy.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeeasy.project.Entity.t_users;
import com.codeeasy.project.repository.productrepo;

@Service
public class productservice {

    @Autowired
    t_users userinfo;

    @Autowired
    productrepo repo;

  //  @Autowired
    //t_users product;

    

    public void addproduct(t_users userinfo){
        repo.save(userinfo);
  
    }

    public t_users getproduct(int id){
      
      t_users prod = repo.findById(id).orElse(new t_users(0,"","","","",""));
      return prod;
    }

    public List<t_users> fetchallproducts(){

      
      List<t_users> userinfo ;
      try{
      //userinfo =  (List<t_users>) repo.findById(1).orElse(new t_users(0,"","","","",""));
        userinfo = (List<t_users>) repo.findAll();
      System.out.println(userinfo);

      //System.out.println(userinfo.get(0).getname());
      }
      catch (Exception e){
        userinfo = null;
        System.out.println(e.getMessage());      }
      finally{
        System.out.println("inside finally block");
      }
      return userinfo;
    }

    public t_users getuser(String email){
        return repo.findByEmail(email).orElse(new t_users(0,"","","","",""));
    }

    public List<List<String>> getappointmentId(String email) {
      return repo.getappointmentId(email);
     
    }

    public List<List<String>> search_doctors(String location, String specialization, String clinic_type, String day)
    {
        
      return repo.search_doctors(location, specialization,clinic_type,day);
    }

    



}
