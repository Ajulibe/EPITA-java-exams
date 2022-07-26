package fr.epita.exam.services;
import fr.epita.exam.datamodel.Prescription;
import java.util.*;


public class PrescriptionsBLService {


    public static Integer getMostFrequentMedicationId(List<Prescription> prescriptions) {
        HashMap<Integer, Integer> frequencyMap = getMedicationCount(prescriptions);
        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();

    }


    public static HashMap<Integer, Integer> computePrescriptionCountPerMedicationId(List<Prescription> prescriptions) {
        return getMedicationCount(prescriptions);
    }


    private static HashMap<Integer, Integer> getMedicationCount(List<Prescription> prescriptions) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();


        for (Prescription prescription : prescriptions) {
            String presc_code = prescription.getPresc_code();
            if (frequencyMap.containsKey(Integer.parseInt(presc_code))) {
                frequencyMap.put(Integer.parseInt(presc_code), frequencyMap.get(Integer.parseInt(presc_code)) + 1);
            } else {
                frequencyMap.put(Integer.parseInt(presc_code), 1);
            }
        }
        return frequencyMap;
    }


}
