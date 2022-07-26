package test;

import java.sql.*;

public class TestJDB1 {
    public static void main(String[] args) throws SQLException {
        test();
    }

    public static void test() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exam-practice", "postgres", "postgres");

        String createTableQuery = "CREATE TABLE IF NOT EXISTS MEDICATIONS(id SERIAL, medication_code varchar(255), medication_name varchar(255), medication_comment varchar(255))";
        connection.prepareStatement(createTableQuery).execute();
    }
}
