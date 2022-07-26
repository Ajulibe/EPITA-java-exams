package fr.epita.exam.services;

import fr.epita.exam.datamodel.Insurance;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class InsuranceCSVReaderDAO {

    private final File file = new File("./resources/insurances.csv");

    //reads from the CSV file
    public void readAll() throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        List<Insurance> insurances = new ArrayList<>();
        for (String line : lines) {
            String[] lineParts = line.split(";");
            Insurance insurance = new Insurance(lineParts[0], lineParts[1]);
            System.out.println(insurance);
            insurances.add(insurance);
        }
        System.out.println(insurances);
    }
}
