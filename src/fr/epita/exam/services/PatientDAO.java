package fr.epita.exam.services;

import fr.epita.exam.datamodel.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public void create(Patient patient) throws SQLException {
        Connection connection = getConnection();

        //create the database
        String createTableQuery = "CREATE TABLE IF NOT EXISTS PATIENTS(id SERIAL, pat_num_HC varchar(255), pat_lastname varchar(255), pat_firstname varchar(255), pat_address varchar(255), pat_tel varchar(255), pat_insurance_id varchar(255), pat_sub_date varchar(255))";
        connection.prepareStatement(createTableQuery).execute();

        //insert
        String insertQuery = "INSERT INTO PATIENTS(pat_num_HC, pat_lastname, pat_firstname, pat_address, pat_tel, pat_insurance_id, pat_sub_date) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(insertQuery);
        ps.setString(1, patient.getPat_num_HC());
        ps.setString(2, patient.getPat_lastname());
        ps.setString(3, patient.getPat_firstname());
        ps.setString(4, patient.getPat_address());
        ps.setString(5, patient.getPat_tel());
        ps.setString(6, patient.getPat_insurance_id());
        ps.setString(7, patient.getPat_sub_date());
        ps.execute();
        connection.close();
    }


    public List<Patient> readAllPatients() throws SQLException {
        Connection connection = getConnection();
        String sqlQuery = "select * from PATIENTS";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        List<Patient> patients = getQueryResults(preparedStatement);
        connection.close();

        return patients;
    }


    public void deleteAPatient(Patient patient) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PATIENTS WHERE PATIENTS.pat_firstname = ?");
        preparedStatement.setString(1, patient.getPat_firstname());
        preparedStatement.execute();
        connection.close();
    }

    public Patient searchForAPatient(Patient patient) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PATIENTS WHERE PATIENTS.pat_lastname = ? and PATIENTS.pat_firstname = ?");
        preparedStatement.setString(1, patient.getPat_lastname());
        preparedStatement.setString(2, patient.getPat_firstname());
        List<Patient> patients = getQueryResults(preparedStatement);
        connection.close();

        return patients.get(0);


    }

    private List<Patient> getQueryResults(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Patient> patients = new ArrayList<>();
        while (resultSet.next()) {
            String pat_num_HC = resultSet.getString("pat_num_HC");
            String pat_lastname = resultSet.getString("pat_lastname");
            String pat_firstname = resultSet.getString("pat_firstname");
            String pat_address = resultSet.getString("pat_address");
            String pat_tel = resultSet.getString("pat_tel");
            String pat_insurance_id = resultSet.getString("pat_insurance_id");
            String pat_sub_date = resultSet.getString("pat_sub_date");

            patients.add(new Patient(pat_num_HC, pat_lastname, pat_firstname, pat_address, pat_tel, pat_insurance_id, pat_sub_date));
        }
        return patients;
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/exam-practice", "postgres", "postgres");
    }
}
