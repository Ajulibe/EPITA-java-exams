package test;


import fr.epita.exam.datamodel.Medication;
import fr.epita.exam.datamodel.Prescription;
import fr.epita.exam.services.MedicationReader;
import fr.epita.exam.services.PrescriptionsReader;


import java.io.IOException;
import java.util.List;


public class TestOOP2 {
    public static void main(String[] args) throws IOException {
        testMedication();
        testPrescription();
    }

    private static void testMedication() throws IOException {
        MedicationReader dao = new MedicationReader();
        List<Medication> medications = dao.readAll();
        System.out.println(medications);
    }

    private static void testPrescription() throws IOException {
        PrescriptionsReader dao = new PrescriptionsReader();
        List<Prescription> prescriptions = dao.readAll();

        System.out.println(prescriptions);
    }
}
