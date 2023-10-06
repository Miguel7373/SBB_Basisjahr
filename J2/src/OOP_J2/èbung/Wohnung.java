package OOP_J2.èbung;

import java.util.ArrayList;

public class Wohnung {
    int stockwerk;
    String wohnungsnummer;
    String beschreibung;
    Immobilie immobilie;

    public Wohnung(int stockwerk, String wohnungsnummer, String beschreibung, Immobilie immobilie) {
        this.stockwerk = stockwerk;
        this.wohnungsnummer = wohnungsnummer;
        this.beschreibung = beschreibung;
        this.immobilie = immobilie;

    }
}