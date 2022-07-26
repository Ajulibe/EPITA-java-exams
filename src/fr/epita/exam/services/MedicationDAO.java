package fr.epita.exam.services;

import fr.epita.exam.datamodel.Medication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicationDAO {
    public void create(Medication medication) throws SQLException {
        Connection connection = getConnection();

        //create the database
        String createTableQuery = "CREATE TABLE IF NOT EXISTS MEDICATIONS(id SERIAL, medication_code varchar(255), medication_name varchar(255), medication_comment varchar(255))";
        connection.prepareStatement(createTableQuery).execute();

        //insert
        String insertQuery = "INSERT INTO MEDICATIONS(medication_code, medication_name, medication_comment) values (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(insertQuery);
        ps.setString(1, medication.getMedication_code());
        ps.setString(2, medication.getMedication_name());
        ps.setString(3, medication.getMedication_comment());
        ps.execute();
        connection.close();
    }


    public List<Medication> readAllMedications() throws SQLException {
        Connection connection = getConnection();
        String sqlQuery = "select * from MEDICATIONS";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        List<Medication> medications = getQueryResults(preparedStatement);
        connection.close();

        return medications;
    }


    public void deleteAMedication(Medication medication) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MEDICATIONS WHERE MEDICATIONS.medication_name = ?");
        preparedStatement.setString(1, medication.getMedication_name());
        preparedStatement.execute();
        connection.close();
    }

    public Medication searchForAMedication(Medication medication) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MEDICATIONS WHERE MEDICATIONS.medication_name = ? or MEDICATIONS.medication_comment = ?");
        preparedStatement.setString(1, medication.getMedication_name());
        preparedStatement.setString(2, medication.getMedication_code());
        List<Medication> medications = getQueryResults(preparedStatement);
        connection.close();

        return medications.get(0);


    }

    private List<Medication> getQueryResults(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Medication> medications = new ArrayList<>();
        while (resultSet.next()) {
            String medication_code = resultSet.getString("medication_code");
            String medication_name = resultSet.getString("medication_name");
            String medication_comment = resultSet.getString("medication_comment");

            medications.add(new Medication(medication_code, medication_name, medication_comment));
        }
        return medications;
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/exam-practice", "postgres", "postgres");
    }
}
