package test;


import fr.epita.exam.datamodel.Prescription;
import fr.epita.exam.services.PrescriptionsBLService;
import fr.epita.exam.services.PrescriptionsReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TestBLI2 {
    public static void main(String[] args) throws IOException {
        PrescriptionsReader prescriptiondao = new PrescriptionsReader();

        List<Prescription> prescription = prescriptiondao.readAll();
        prescription.remove(0);


        HashMap<Integer, Integer> count = PrescriptionsBLService.computePrescriptionCountPerMedicationId(prescription);
        System.out.println("count:" + " " + count);

    }
}
