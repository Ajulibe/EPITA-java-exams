package fr.epita.exam.datamodel;

public class Insurance {
    private String insurance_id;
    private String insurance_name;

    public Insurance(String insurance_id, String insurance_name) {
        this.insurance_id = insurance_id;
        this.insurance_name = insurance_name;
    }

    public String getInsurance_id() {
        return insurance_id;
    }

    public String getInsurance_name() {
        return insurance_name;
    }

    public void setInsurance_id(String insurance_id) {
        this.insurance_id = insurance_id;
    }

    public void setInsurance_name(String insurance_name) {
        this.insurance_name = insurance_name;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "insurance_id=" + insurance_id +
                ", insurance_name='" + insurance_name + '\'' +
                '}';
    }
}
