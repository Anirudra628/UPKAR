package com.codeeasy.project.repository;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.sql.*;

public class productrepoImpl implements CustomMethod {

    @PersistenceContext
    private EntityManager entityManager;


@Override
public List<String> getappointmentId(String email) {

    List<String>appointment_history = new ArrayList<>();
    String url = "jdbc:oracle:thin:@localhost:1521:UpkarDB"; // Replace with your Oracle database details
    String username = "SYSTEM";
    String password = "Disha123*#";
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully!");

        System.out.println("Email: " + email);

        // Prepare the CallableStatement for the stored procedure
        CallableStatement callableStatement = connection.prepareCall("{call GETAPPOINTMENTDETAILS(?, ?)}");

        // Set the input/output parameter
        callableStatement.setString(1, email);
        callableStatement.registerOutParameter(2, java.sql.Types.REF_CURSOR);

        // Execute the stored procedure
        callableStatement.execute();
        ResultSet rs = (ResultSet) callableStatement.getObject(2); 
        
        while (rs.next()){
            String first_name = rs.getString(1);
            String last_name = rs.getString(2);
            String appointment_date = rs.getString(3);
            String appointment_id = rs.getString(4);

            if (first_name != null) {
                appointment_history.add(first_name);
            }
            if (last_name != null) {
                appointment_history.add(last_name);
            }
            if (appointment_date == null || !appointment_date.isEmpty()) {
                appointment_history.add(appointment_date);
            }
            if (appointment_id != null) {
                appointment_history.add(appointment_id);
            }

        }
            rs.close();
            callableStatement.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    return appointment_history;
    }



    @Override
public List<String> get_particular_appointment(String email, String appointment_id) {

    List<String>appointment_history = new ArrayList<>();
    String url = "jdbc:oracle:thin:@localhost:1521:UpkarDB"; // Replace with your Oracle database details
    String username = "SYSTEM";
    String password = "Disha123*#";
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully!");

        // Prepare the CallableStatement for the stored procedure
        CallableStatement callableStatement = connection.prepareCall("{call GETAPPOINTMENTDETAILS(?, ?)}");

        // Set the input/output parameter
        callableStatement.setString(1, email);
        callableStatement.registerOutParameter(2, java.sql.Types.REF_CURSOR);

        // Execute the stored procedure
        callableStatement.execute();
        ResultSet rs = (ResultSet) callableStatement.getObject(2); 
        
        while (rs.next()){
            String first_name = rs.getString(1);
            String last_name = rs.getString(2);
            String appointment_date = rs.getString(3);
            //String appointment_id = rs.getString(4);

            if (first_name != null) {
                appointment_history.add(first_name);
            }
            if (last_name != null) {
                appointment_history.add(last_name);
            }
            if (appointment_date == null || !appointment_date.isEmpty()) {
                appointment_history.add(appointment_date);
            }
            if (appointment_id != null) {
                appointment_history.add(appointment_id);
            }

        }
            rs.close();
            callableStatement.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    return appointment_history;
    }

}

