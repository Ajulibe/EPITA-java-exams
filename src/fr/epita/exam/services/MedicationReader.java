package fr.epita.exam.services;

import fr.epita.exam.datamodel.Medication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MedicationReader {

    private final File file = new File("./resources/medications.csv");

    //reads from the CSV file
    public List<Medication> readAll() throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        List<Medication> medications = new ArrayList<>();
        for (String line : lines) {
            String[] lineParts = line.split(";");
            Medication medication = new Medication(lineParts[0], lineParts[1], lineParts[2]);
            medications.add(medication);
        }

        return medications;
    }
}
