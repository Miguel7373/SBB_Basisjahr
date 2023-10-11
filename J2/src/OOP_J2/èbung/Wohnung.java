package OOP_J2.èbung;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Wohnung {
    int stockwerk;
    String wohnungsnummer;
    String beschreibung;
    Immobilie immobilie;
    List<Vertrag> verträge = new ArrayList<>();

    public Wohnung(int stockwerk, String wohnungsnummer, String beschreibung, Immobilie immobilie) {
        this.stockwerk = stockwerk;
        this.wohnungsnummer = wohnungsnummer;
        this.beschreibung = beschreibung;
        this.immobilie = immobilie;
    }

    public Person getAbwart() {
        return immobilie.abwart;
    }

    public void addVertrag(Vertrag vertrag) {
        verträge.add(vertrag);
    }

    public String getWohnungsnummer() {
        return wohnungsnummer;
    }

}