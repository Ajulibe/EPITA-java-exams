package fr.epita.exam.services;

import fr.epita.exam.datamodel.Patient;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PatientCSVReaderDAO {
    private final File file = new File("./resources/patients.csv");

    //reads from the CSV file
    public List<Patient> readAll() throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        List<Patient> patients = new ArrayList<>();
        for (String line : lines) {
            String[] lineParts = line.split(";");
            Patient patient = new Patient(lineParts[0], lineParts[1], lineParts[2], lineParts[3], lineParts[4], lineParts[5], lineParts[6]);
            patients.add(patient);
        }
        return patients;

    }
}
