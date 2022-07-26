package test;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;

public class TestJDB3 {

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exam-practice", "postgres", "postgres");


        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(connection);

        Reader createPrescriptionsTable = new BufferedReader(new FileReader("./resources/create-prescriptions.sql"));
        sr.runScript(createPrescriptionsTable);


        //Creating a reader object and running file
        Reader createInsuranceTable = new BufferedReader(new FileReader("./resources/create-insurances.sql"));
        sr.runScript(createInsuranceTable);


        Reader createMedicationsTable = new BufferedReader(new FileReader("./resources/create-medications.sql"));
        sr.runScript(createMedicationsTable);


        Reader createPatientsTable = new BufferedReader(new FileReader("./resources/create-patients.sql"));
        sr.runScript(createPatientsTable);

    }


}
