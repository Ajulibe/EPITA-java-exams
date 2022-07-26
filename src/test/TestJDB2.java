package test;

import fr.epita.exam.datamodel.Medication;
import fr.epita.exam.services.MedicationDAO;
import fr.epita.exam.services.MedicationReader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestJDB2 {
    public static void main(String[] args) throws IOException, SQLException {
        //1
        MedicationReader medicationReader = new MedicationReader();
        List<Medication> medications = medicationReader.readAll();


        //2
        MedicationDAO dao = new MedicationDAO();

        medications.remove(0);
//        get the MEDICATION from CSV
        //create
        for (Medication medication : medications) {
            String medication_code = medication.getMedication_code();
            String medication_name = medication.getMedication_name();
            String medication_comment = medication.getMedication_comment();

            Medication referenceMedication = new Medication(medication_code, medication_name, medication_comment);

            dao.create(referenceMedication);
        }

        //search for MEDICATION by firstname and lastname
        Medication searchResult = dao.searchForAMedication(medications.get(1));

        System.out.println(searchResult);

        //delete the MEDICATION from the database
        dao.deleteAMedication(searchResult);

    }
}
