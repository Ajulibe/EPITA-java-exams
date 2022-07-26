package test;

import fr.epita.exam.datamodel.Medication;
import fr.epita.exam.datamodel.Prescription;
import fr.epita.exam.services.MedicationReader;
import fr.epita.exam.services.PrescriptionsBLService;
import fr.epita.exam.services.PrescriptionsReader;


import java.io.IOException;
import java.util.List;

public class TestBLI1 {
    public static void main(String[] args) throws IOException {
        //load list of medications
        MedicationReader medicationdao = new MedicationReader();

        List<Medication> medications = medicationdao.readAll();
        System.out.println(medications);


        PrescriptionsReader prescriptiondao = new PrescriptionsReader();


        List<Prescription> prescription = prescriptiondao.readAll();
        prescription.remove(0);

        Integer getMostFrequentMedicationId = PrescriptionsBLService.getMostFrequentMedicationId(prescription);
        System.out.println("getMostFrequentMedicationId:" + " " + getMostFrequentMedicationId);


    }
}
