package OOP_J2.èbung;


import java.util.*;
public class Firma {
    String name;
    String adresse;
    List<Immobilie> immobilien = new ArrayList<>();
    List<Person> angestellte = new ArrayList<>();

    public Firma(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    public void addImmobilie(Immobilie immobilie) {
        immobilien.add(immobilie);
    }

    public void addAngestellter(Person angestellter) {
        angestellte.add(angestellter);
    }

}