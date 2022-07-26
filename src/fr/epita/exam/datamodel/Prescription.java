package fr.epita.exam.datamodel;

public class Prescription {
    private String presc_id;
    private String presc_ref_pat;
    private String presc_code;
    private String presc_days;

    public Prescription(String presc_id, String presc_ref_pat, String presc_code, String presc_days) {
        this.presc_id = presc_id;
        this.presc_ref_pat = presc_ref_pat;
        this.presc_code = presc_code;
        this.presc_days = presc_days;
    }

    public String getPresc_id() {
        return presc_id;
    }

    public void setPresc_id(String presc_id) {
        this.presc_id = presc_id;
    }

    public String getPresc_ref_pat() {
        return presc_ref_pat;
    }

    public void setPresc_ref_pat(String presc_ref_pat) {
        this.presc_ref_pat = presc_ref_pat;
    }

    public String getPresc_code() {
        return presc_code;
    }

    public void setPresc_code(String presc_code) {
        this.presc_code = presc_code;
    }

    public String getPresc_days() {
        return presc_days;
    }

    public void setPresc_days(String presc_days) {
        this.presc_days = presc_days;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "presc_id=" + presc_id +
                "presc_ref_pat=" + presc_ref_pat +
                "presc_code=" + presc_code +
                ", presc_days='" + presc_days + '\'' +
                '}';
    }
}
