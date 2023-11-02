package zoo.person;

public abstract class People {
    private String telefonnummer;

    public People(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
    public People() {
        this.telefonnummer = "Unbekannt";
    }
}