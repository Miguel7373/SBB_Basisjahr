package OOP_J2.aufgabe4;

import java.util.ArrayList;

public class wohnung {
    String mieter;
    String vertrag;
    String stockwerk;
    String wohnungsnummer;
    String beschreibung;
    String name;


    public wohnung(String mieter, String vertrag, String stockwerk, String wohnungsnummer, String beschreibung, String name) {
        this.name = name;
        this.mieter = mieter;
        this.vertrag = vertrag;
        this.stockwerk = stockwerk;
        this.wohnungsnummer = wohnungsnummer;
        this.beschreibung = beschreibung;
    }
    public static ArrayList wohnung() {
        ArrayList<wohnung> wohnungsList = new ArrayList<>();
        wohnung bigben_1235 = new wohnung(" "," "," "," "," "," ");
        wohnungsList.add(bigben_1235);
        return wohnungsList;
    }
}