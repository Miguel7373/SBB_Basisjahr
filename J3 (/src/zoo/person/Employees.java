package zoo.person;

import zoo.enclosures.Aquarium;
import zoo.enclosures.Enclosure;

public class Employees extends People {
    private int lohn;
    private Enclosure departmentArea;
    private String beschreibung;
    public Employees() {
        super();
    }


    public Employees(String telefonnummer, int lohn, String beschreibung, Enclosure departmentArea) {
        super(telefonnummer);
        this.lohn = lohn;
        this.beschreibung = beschreibung;
        this.departmentArea = departmentArea;
    }
}
