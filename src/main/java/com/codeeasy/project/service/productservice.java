package com.codeeasy.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeeasy.project.Entity.t_users;
import com.codeeasy.project.repository.productrepo;

@Service
public class productservice {

    @Autowired
    t_users prodinfo;

    @Autowired
    productrepo repo;

  //  @Autowired
    //t_users product;

    

    public void addproduct(t_users prodinfo){
          
       // prodinfo = new t_users();
       // prodinfo.setdetails( price, brand, name, available);
        repo.save(prodinfo);
       // return repo.findById(0).orElse(new t_users(0.0,null,null,false));
    }

    public t_users getproduct(int id){
      
      t_users prod = repo.findById(id).orElse(new t_users(0,"","","","",""));
      return prod;
    }

    public List<t_users> fetchallproducts(){

      
      List<t_users> prodinfo ;
      try{
      //prodinfo =  (List<t_users>) repo.findById(1).orElse(new t_users(0,"","","","",""));
        prodinfo = (List<t_users>) repo.findAll();
      System.out.println(prodinfo);

      //System.out.println(prodinfo.get(0).getname());
      }
      catch (Exception e){
        prodinfo = null;
        System.out.println(e.getMessage());      }
      finally{
        System.out.println("inside finally block");
      }
      return prodinfo;
    }

    

}
