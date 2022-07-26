package test;

import fr.epita.exam.datamodel.Medication;
import fr.epita.exam.datamodel.Patient;
import fr.epita.exam.datamodel.Prescription;
import fr.epita.exam.services.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestJDB4 {
    public static void main(String[] args) throws SQLException, IOException {
        PatientDAO patient = new PatientDAO();
        List<Patient> patients = patient.readAllPatients();
        System.out.println(patients);

        getPrescriptionInformation();

        MedicationDAO medication = new MedicationDAO();
        List<Medication> medications = medication.readAllMedications();
        System.out.println(medications);
    }

    private static void getPrescriptionInformation() throws SQLException, IOException {
        PrescriptionDAO prescription = new PrescriptionDAO();


        //populate the prescription table
        PrescriptionsReader prescriptionsReader_ = new PrescriptionsReader();
        List<Prescription> prescriptionList = prescriptionsReader_.readAll();


        prescriptionList.remove(0);
        //create
        for (Prescription pres : prescriptionList) {
            String presc_id = pres.getPresc_id();
            String presc_ref_pat = pres.getPresc_ref_pat();
            String presc_code = pres.getPresc_code();
            String presc_days = pres.getPresc_days();

            Prescription referencePrescription = new Prescription(presc_id, presc_ref_pat, presc_code, presc_days);

            prescription.create(referencePrescription);
        }

        List<Prescription> prescriptions = prescription.readAllPrescriptions();
        System.out.println(prescriptions);
    }

}
