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

import com.codeeasy.project.Entity.t_patients;
import com.codeeasy.project.Entity.t_users;
import com.codeeasy.project.service.productservice;

@RestController
public class ProductController {

    @Autowired
        productservice prod;   

    
    @PostMapping("/register") 
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
    

    @PostMapping("/add-patient")
    public ResponseEntity<Object> add_patient( @RequestParam(value ="email",required = true) String email, 
                                               @RequestParam(value="relation",required = true) String relation,
                                               @RequestBody t_patients patientinfo
                                             )
    {

        System.out.println("inside add_patient method"); 
        int success_code = 0;
        String p_fname = patientinfo.getFirst_name();
        String p_lname = patientinfo.getLast_name();
        String dob = patientinfo.getBirth_date().toString();
        String gender = patientinfo.getGender();
        System.out.println("Patient first name is: "+p_fname);
        System.out.println("Patient last name is: "+p_lname);
        System.out.println("Patient dob is: "+dob);
        System.out.println(gender);
        try{
            success_code = prod.add_patient(email, p_fname,p_lname,dob,gender,relation);
            if (success_code != 0) {
                return new ResponseEntity<Object>(success_code,HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<Object>("Added successfully", HttpStatus.OK);
        }  

        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }


    @GetMapping("/search")
    public ResponseEntity<Object> search(
        @RequestParam(value ="location",required = false) String location,
        @RequestParam(value ="specialization",required = true) String specialization,
        @RequestParam(value ="clinic_type",required = false) String clinic_type,
        @RequestParam(value ="day",required = false) String day)
    
    {
       List<List<String>> doctor_list = null;
       System.out.println("inside search method");
       doctor_list = prod.search_doctors(location, specialization, clinic_type, day);

       System.out.println(doctor_list);

       if (doctor_list == null || doctor_list.isEmpty()) {
            return new ResponseEntity<Object>("No doctors found",HttpStatus.NOT_FOUND);
        }        

       return new ResponseEntity<Object>(doctor_list,HttpStatus.OK);

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
    

    @PostMapping("/book-appointment")
    public ResponseEntity<Object> book_appointment(
        @RequestParam(value ="email",required = true) String email,
        @RequestParam(value ="doctor_id",required = true) String doctor_id,
        @RequestParam(value ="location_id",required = true) String location_id,
        @RequestParam(value ="slot_id",required = true) String slot_id,
        @RequestParam(value ="relation",required = true) String relation,
        @RequestParam(value = "confirm-booking",required = false) String confirm_booking
        )
    {
        Integer success_code = 0;
        System.out.println("inside book_appointment method");

        if(email == null || email.isEmpty()){
            return new ResponseEntity<Object>("Email cannot be blank or null",HttpStatus.BAD_REQUEST);
        }
        System.out.println("Relation is: "+relation);
        success_code = prod.save_appointment(email, relation, doctor_id, location_id, slot_id, confirm_booking);
        
        if (success_code == 0) {
            return new ResponseEntity<Object>("Appointment not booked successfully!",HttpStatus.INTERNAL_SERVER_ERROR);
        }        

        return new ResponseEntity<Object>(success_code,HttpStatus.OK);

    }
    @GetMapping("/appointment-history")
        public ResponseEntity<Object>get_Appointment_History(
            @RequestParam(value ="email",required = false) String email,
            @RequestParam(value ="appointment_id",required = false) String appointment_id)
            {
            
            List<List<String>>appointment_history_list = null;

            System.out.println("inside get_Appointment_History method");

            if(email == null || email.isEmpty()){
                return new ResponseEntity<Object>("Cannot find appointment  details having blank email",HttpStatus.BAD_REQUEST);
            }

            appointment_history_list = prod.getappointmentId(email);
            if (appointment_history_list == null || appointment_history_list.isEmpty()) {
                return new ResponseEntity<Object>("You have not booked any appointment yet!",HttpStatus.NOT_FOUND);
            }    

            return new ResponseEntity<Object>(appointment_history_list,HttpStatus.OK);
            
        }
    }

    
