package com.codeeasy.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeeasy.project.Entity.t_users;
import com.codeeasy.project.service.productservice;

@RestController
public class ProductController {

    @Autowired
        productservice prod;   
    
    @PostMapping
    //adding a particular user
    public ResponseEntity<String> setproduct(@RequestBody t_users userinfo){

        System.out.println("I am here"); 
       // prod = null;
        try{
            this.prod.addproduct(userinfo);
            return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
        }  

        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        

    }

    // for testing purpose only
    @GetMapping("/getallusers")
    public ResponseEntity<List<t_users>> getallproducts(){
        System.out.println("inside controller");
        return new ResponseEntity<List<t_users>>(prod.fetchallproducts(),HttpStatus.OK);
    }

    @GetMapping("/getparticularuser")
    
    ///remember to pass email from localhost while development of frontend
    /// Profile screen --> upon clicking on profile icon 
        public ResponseEntity<Object> getuser(@RequestParam(value ="email",required = false) String email){

            System.out.println("inside getparticularuser method");
            System.out.println(email);
            try{
                if(email == null || email.isEmpty()){
                    return new ResponseEntity<Object>("Email cannot be blank or null",HttpStatus.BAD_REQUEST);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            return new ResponseEntity<Object>(prod.getuser(email),HttpStatus.OK);
        }
    

    @GetMapping("/appointment-history")
        public ResponseEntity<Object>get_Appointment_History(
            @RequestParam(value ="email",required = false) String email,
            @RequestParam(value ="appointment_id",required = false) String appointment_id)
            {
            
            List<String>appointment_history_list = null;
            List<String> appointment_particular = null;

            System.out.println("inside get_Appointment_History method");

            if(email == null || email.isEmpty()){
                return new ResponseEntity<Object>("Cannot find appointment  details having blank email",HttpStatus.BAD_REQUEST);
            }
           /*  if(appointment_id == null || appointment_id.isEmpty()){
                return new ResponseEntity<Object>("Cannot find appointment  details having blank appointment id",HttpStatus.BAD_REQUEST);
            } */

            if(appointment_id != null && !appointment_id.isEmpty() && email != null && !email.isEmpty()){
                try{
                    appointment_particular = prod.get_particular_appointment(email, appointment_id);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                if(appointment_particular == null || appointment_particular.isEmpty()){
                    return new ResponseEntity<Object>("Either record has been deleted or corrupted",HttpStatus.NOT_FOUND);
                }
            }
            else if(email != null && !email.isEmpty()){
                try{
                    appointment_history_list = prod.getappointmentId(email);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                if(appointment_history_list == null || appointment_history_list.isEmpty()){
                    return new ResponseEntity<Object>("No appointment history found",HttpStatus.NOT_FOUND);
                }
            }
            
            if (appointment_history_list != null && !appointment_history_list.isEmpty()) {
                return new ResponseEntity<Object>(appointment_history_list,HttpStatus.OK);
            } else if (appointment_particular != null && !appointment_particular.isEmpty()) {
                return new ResponseEntity<Object>(appointment_particular,HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>("You didn't have any appointemnt yet!",HttpStatus.NOT_FOUND);
            }
            
        }
    }

