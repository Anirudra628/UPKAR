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
    public List<List<String>> getappointmentId(String email) {

        List<List<String>> appointment_history = new ArrayList<>();
        String url = "jdbc:oracle:thin:@localhost:1521:ORCL"; // Replace with your Oracle database details
        String username = "SYSTEM";
        String password = "Vihaan1234*#";
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
                if (doctor_first_name != null) {
                    inner_list.add(doctor_first_name);
                }
                if (appointment_date == null || !appointment_date.isEmpty()) {
                    inner_list.add(appointment_date);
                }
                if (appointment_id != null) {
                    inner_list.add(appointment_id);
                }

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
    public List<List<String>> get_particular_appointment(String email, String appointment_id) {

        List<List<String>> appointment_history = new ArrayList<>();
        String url = "jdbc:oracle:thin:@localhost:1521:ORCL"; // Replace with your Oracle database details
        String username = "SYSTEM";
        String password = "Vihaan1234*#";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

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
                String first_name = rs.getString(1);
                String last_name = rs.getString(2);
                String appointment_date = rs.getString(3);
                // String appointment_id = rs.getString(4);

                List<String> inner_list = new ArrayList<>();

                if (first_name != null) {
                    inner_list.add(first_name);
                }
                if (last_name != null) {
                    inner_list.add(last_name);
                }
                if (appointment_date == null || !appointment_date.isEmpty()) {
                    inner_list.add(appointment_date);
                }
                if (appointment_id != null) {
                    inner_list.add(appointment_id);
                }

                appointment_history.add(inner_list);

            }
            rs.close();
            callableStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return appointment_history;
    }

}

