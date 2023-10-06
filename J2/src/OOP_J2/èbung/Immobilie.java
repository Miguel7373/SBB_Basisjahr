package OOP_J2.èbung;
import java.util.ArrayList;
import java.util.List;


public class Immobilie {
    String adresse;
    Person abwart;
    Person verwalter;
    List<Wohnung> wohnungen = new ArrayList<>();

    public Immobilie(String adresse, Person abwart, Person verwalter) {
        this.adresse = adresse;
        this.abwart = abwart;
        this.verwalter = verwalter;

    }
    public void addWohnung(Wohnung wohnung) {
        wohnungen.add(wohnung);
    }
}


/*
Firma
Immobilein
Wohnungen
Mieter

 */

