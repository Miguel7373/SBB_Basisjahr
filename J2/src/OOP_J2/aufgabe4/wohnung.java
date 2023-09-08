package OOP_J2.aufgabe4;

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
}