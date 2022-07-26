package fr.epita.exam.services;

import fr.epita.exam.datamodel.Prescription;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {
    public void create(Prescription prescription) throws SQLException {
        Connection connection = getConnection();

        //create the database
        String createTableQuery = "CREATE TABLE IF NOT EXISTS PRESCRIPTIONS(id SERIAL, presc_id varchar(255), presc_ref_pat varchar(255), presc_code varchar(255), presc_days varchar(255))";
        connection.prepareStatement(createTableQuery).execute();

        //insert
        String insertQuery = "INSERT INTO PRESCRIPTIONS(presc_id, presc_ref_pat, presc_code, presc_days) values (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(insertQuery);
        ps.setString(1, prescription.getPresc_id());
        ps.setString(2, prescription.getPresc_ref_pat());
        ps.setString(3, prescription.getPresc_code());
        ps.setString(4, prescription.getPresc_days());
        ps.execute();
        connection.close();
    }


    public List<Prescription> readAllPrescriptions() throws SQLException {
        Connection connection = getConnection();
        String sqlQuery = "select * from PRESCRIPTIONS";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        List<Prescription> prescriptions = getQueryResults(preparedStatement);
        connection.close();

        return prescriptions;
    }


    public void deleteAPrescription(Prescription prescription) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRESCRIPTIONS WHERE PRESCRIPTIONS.presc_ref_pat = ?");
        preparedStatement.setString(1, prescription.getPresc_ref_pat());
        preparedStatement.execute();
        connection.close();
    }

    public Prescription searchForAPrescription(Prescription prescription) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRESCRIPTIONS WHERE PRESCRIPTIONS.presc_id = ? or PRESCRIPTIONS.presc_ref_pat = ?");
        preparedStatement.setString(1, prescription.getPresc_id());
        preparedStatement.setString(2, prescription.getPresc_ref_pat());

        List<Prescription> prescriptions = getQueryResults(preparedStatement);
        connection.close();

        return prescriptions.get(0);


    }

    private List<Prescription> getQueryResults(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Prescription> prescriptions = new ArrayList<>();
        while (resultSet.next()) {
            String presc_id = resultSet.getString("presc_id");
            String presc_ref_pat = resultSet.getString("presc_ref_pat");
            String presc_code = resultSet.getString("presc_code");
            String presc_days = resultSet.getString("presc_days");

            prescriptions.add(new Prescription(presc_id, presc_ref_pat, presc_code, presc_days));
        }
        return prescriptions;
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/exam-practice", "postgres", "postgres");
    }
}
