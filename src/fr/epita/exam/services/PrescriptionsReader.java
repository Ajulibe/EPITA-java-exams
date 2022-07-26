package fr.epita.exam.services;


import fr.epita.exam.datamodel.Prescription;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionsReader {

    private final File file = new File("./resources/prescriptions.csv");

    //reads from the CSV file
    public List<Prescription> readAll() throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        List<Prescription> prescriptions = new ArrayList<>();
        for (String line : lines) {
            String[] lineParts = line.split(";");
            Prescription prescription = new Prescription(lineParts[0], lineParts[1],  lineParts[2],  lineParts[3]);
            prescriptions.add(prescription);
        }
        return prescriptions;
    }
}
