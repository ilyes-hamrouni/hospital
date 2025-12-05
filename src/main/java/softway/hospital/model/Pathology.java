package softway.hospital.model;

public enum Pathology {
    CARDIOLOGY("Cardiologie"),
    TRAUMATOLOGY("Traumatologie");

    private final String label;

    Pathology(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}