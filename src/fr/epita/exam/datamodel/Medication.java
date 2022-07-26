package fr.epita.exam.datamodel;

public class Medication {

    private String medication_code;
    private String medication_name;
    private String medication_comment;

    public Medication(String medication_code, String medication_name, String medication_comment) {
        this.medication_code = medication_code;
        this.medication_name = medication_name;
        this.medication_comment = medication_comment;
    }

    public String getMedication_code() {
        return medication_code;
    }

    public void setMedication_code(String medication_code) {
        this.medication_code = medication_code;
    }

    public String getMedication_name() {
        return medication_name;
    }

    public void setMedication_name(String medication_name) {
        this.medication_name = medication_name;
    }

    public String getMedication_comment() {
        return medication_comment;
    }

    public void setMedication_comment(String medication_comment) {
        this.medication_comment = medication_comment;
    }


    @Override
    public String toString() {
        return "Medication{" +
                "medication_code=" + medication_code +
                "medication_name=" + medication_name +
                ", medication_comment='" + medication_comment + '\'' +
                '}';
    }
}
