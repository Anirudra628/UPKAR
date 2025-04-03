package com.codeeasy.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeeasy.project.Entity.t_users;
import com.codeeasy.project.service.productservice;

@RestController
public class ProductController {

    @Autowired
        productservice prod;   
    
    @PostMapping
    public ResponseEntity<String> setproduct(@RequestBody t_users prodinfo){

        System.out.println("I am here"); 
       // prod = null;
        try{
            this.prod.addproduct(prodinfo);
            return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
        }  

        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        

    }

    @GetMapping("/get")
    public ResponseEntity<List<t_users>> getallproducts(){
        System.out.println("inside controller");
        return new ResponseEntity<List<t_users>>(prod.fetchallproducts(),HttpStatus.OK);
    }



}
