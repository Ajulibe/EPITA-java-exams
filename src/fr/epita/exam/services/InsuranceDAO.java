package fr.epita.exam.services;

import fr.epita.exam.datamodel.Insurance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceDAO {
    public void create(Insurance insurance) throws SQLException {
        Connection connection = getConnection();

        //create the database
        String createTableQuery = "CREATE TABLE IF NOT EXISTS INSURANCES(id SERIAL, insurance_id varchar(255), insurance_name varchar(255))";
        connection.prepareStatement(createTableQuery).execute();

        //insert
        String insertQuery = "INSERT INTO INSURANCES(insurance_id, insurance_name) values (?, ?)";
        PreparedStatement ps = connection.prepareStatement(insertQuery);
        ps.setString(1, insurance.getInsurance_id());
        ps.setString(2, insurance.getInsurance_name());
        ps.execute();
        connection.close();
    }


    public List<Insurance> readAllInsurances() throws SQLException {
        Connection connection = getConnection();
        String sqlQuery = "select * from INSURANCES";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        List<Insurance> insurances = getQueryResults(preparedStatement);
        connection.close();

        return insurances;
    }


    public void deleteAInsurance(Insurance insurance) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM INSURANCES WHERE INSURANCES.insurance_id = ?");
        preparedStatement.setString(1, insurance.getInsurance_id());
        preparedStatement.execute();
        connection.close();
    }

    public Insurance searchForAInsurance(Insurance insurance) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM INSURANCES WHERE INSURANCES.insurance_id = ? or INSURANCES.insurance_name = ?");
        preparedStatement.setString(1, insurance.getInsurance_id());
        preparedStatement.setString(2, insurance.getInsurance_name());

        List<Insurance> insurances = getQueryResults(preparedStatement);
        connection.close();

        return insurances.get(0);


    }

    private List<Insurance> getQueryResults(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Insurance> insurances = new ArrayList<>();
        while (resultSet.next()) {
            String insurance_id = resultSet.getString("insurance_id");
            String insurance_name = resultSet.getString("insurance_name");

            insurances.add(new Insurance(insurance_id, insurance_name));
        }
        return insurances;
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/exam-practice", "postgres", "postgres");
    }
}
