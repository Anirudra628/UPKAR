package com.codeeasy.project.repository;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.sql.*;

public class productrepoImpl implements CustomMethod {

    @PersistenceContext
    private EntityManager entityManager;

    String url = "jdbc:oracle:thin:@localhost:1521:UpkarDB"; // Replace with your Oracle database details
    String username = "SYSTEM";
    String password = "Disha123*#";


    @Override
    public List<List<String>> getappointmentId(String email) {

        List<List<String>> appointment_history = new ArrayList<>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            System.out.println("Email: " + email);

            // Prepare the CallableStatement for the stored procedure
            CallableStatement callableStatement = connection.prepareCall("{call GETAPPOINTMENTDETAILS(?, ?)}");

            // Set the input parameter
            callableStatement.setString(1, email);
            // Register the output parameter
            callableStatement.registerOutParameter(2, java.sql.Types.REF_CURSOR);
            // Execute the stored procedure
            callableStatement.execute();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);

            while (rs.next()) {

                System.out.println("Inside while loop");
                String first_name = rs.getString(1);
                String relationship = rs.getString(2);
                String doctor_first_name = rs.getString(3);
                String appointment_date = rs.getString(4);
                String appointment_id = rs.getString(5);
                String clinic_name = rs.getString(6);
                String clinic_type = rs.getString(7);
                String address = rs.getString(8);
                String start_time = rs.getString(9);
                String end_time = rs.getString(10);

                List<String> inner_list = new ArrayList<>();

                if (first_name != null) {
                    inner_list.add(first_name);
                }
                inner_list.add(relationship);
                if (doctor_first_name != null) {
                    inner_list.add(doctor_first_name);
                }
                if (appointment_date == null || !appointment_date.isEmpty()) {
                    inner_list.add(appointment_date);
                }
                if (appointment_id != null) {
                    inner_list.add(appointment_id);
                }

                inner_list.add(clinic_name);
                inner_list.add(clinic_type);
                inner_list.add(address);
                inner_list.add(start_time);
                inner_list.add(end_time);

                appointment_history.add(inner_list);

            }
            rs.close();
            callableStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return appointment_history;
    }

    @Override
    public List<List<String>> search_doctors(String location, String specialization, String clinic_type,String day)
    {
        List<List<String>> doctor_list = new ArrayList<>();

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            CallableStatement cstmt = conn.prepareCall("{call SEARCH_DOCTORS(?,?,?,?,?)}");
            cstmt.setString(1, location);
            cstmt.setString(2, specialization);
            cstmt.setString(3, clinic_type);
            cstmt.setString(4, day);
            cstmt.registerOutParameter(5, java.sql.Types.REF_CURSOR);

            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(5);
            System.out.println("ResultSet obtained successfully!");

            while(rs.next()){
                String doctor_first_name = rs.getString(1);
                String doctor_last_name = rs.getString(2);
                String clinic_name = rs.getString(3);
                String degree = rs.getString(4);
                String doctor_id = rs.getString(5);
                String slot = rs.getString(6);
                String location_id = rs.getString(7);
                String date = rs.getString(8);
                String timing_start = rs.getString(9);
                String timing_end = rs.getString(10);
                String fees = rs.getString(11);

                List<String> inner_list = new ArrayList<>();
                inner_list.add(doctor_first_name);
                inner_list.add(doctor_last_name);
                inner_list.add(clinic_name);
                inner_list.add(degree);
                inner_list.add(doctor_id);
                inner_list.add(slot);
                inner_list.add(location_id);
                inner_list.add(date);
                inner_list.add(timing_start);
                inner_list.add(timing_end);
                inner_list.add(fees);

                doctor_list.add(inner_list);
            }
            rs.close();
            cstmt.close();
            
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return doctor_list;
    }
   
    @Override
    public Integer save_appointment(String email,String relation, String doctor_id, String location_id, String slot_id, String confirm)
    {
        int successcode= 0;

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            CallableStatement cstmt = conn.prepareCall("{call SAVE_APPOINTMENT(?,?,?,?,?,?,?)}");
            cstmt.setString(1, email);
            cstmt.setString(2, relation);
            cstmt.setString(3, doctor_id);
            cstmt.setString(4, location_id);
            cstmt.setString(5, slot_id);
            cstmt.setString(6, confirm);
            cstmt.registerOutParameter(7, java.sql.Types.NUMERIC);

            cstmt.execute();
            successcode = cstmt.getInt(7);
            System.out.println("ResultSet obtained successfully!");

           /*  while(rs.next()){
                 successcode = rs.getInt(1);

            }*/
           // rs.close();
            cstmt.close();
            
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

       
        return successcode;
    }

    @Override
    public Integer add_patient(String email, String p_fname, String p_lname, String dob, String sex, String relation) {
        int successCode = 0;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            CallableStatement cstmt = conn.prepareCall("{call ADDPATIENT(?,?,?,?,?,?,?)}");
            cstmt.setString(1, email);
            cstmt.setString(2, p_fname);
            cstmt.setString(3, p_lname);
            cstmt.setString(4, dob);
            cstmt.setString(5, sex);
            cstmt.setString(6, relation);
            cstmt.registerOutParameter(7, java.sql.Types.NUMERIC);

            cstmt.execute();
            successCode = cstmt.getInt(7);

            if (successCode == 0)
                System.out.println("Patient added successfully!");

            cstmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return successCode;
    }

}


