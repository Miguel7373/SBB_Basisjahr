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

    public List<Wohnung> getWohnungen() {
        return wohnungen;
    }

    public String verträgeProImmo() {
        for (Firma firma : Main.firmen) {
            for (Immobilie immobilie : firma.getImmobilien()) {
                if (immobilie.adresse.equals("Li20 Straße 123")) {
                    Immobilie gesuchteImmobilie = immobilie;
                    List<Vertrag> vertraegeFuerImmobilie = new ArrayList<>();
                    for (Wohnung wohnung : gesuchteImmobilie.wohnungen) {
                        vertraegeFuerImmobilie.addAll(wohnung.verträge);
                    }
                    for (Vertrag vertrag : vertraegeFuerImmobilie) {
                        return ("verträge in der Strasse Li20 Straße 123 " + vertrag.mieter.name + " - " + vertrag.startDatum + " bis " + vertrag.endDatum);
                    }
                }
            }
        }
        return null;
    }
    public String freeWohnung(){
        for (Firma firma : Main.firmen) {
            for (Immobilie immobilie : firma.getImmobilien()) {
                if (immobilie.adresse.equals("Li20 Straße 123")) {
                    Immobilie gesuchteImmobilie = immobilie;
                    List<Wohnung> leereWohnungen = new ArrayList<>();
                    for (Wohnung wohnung : gesuchteImmobilie.wohnungen) {
                        if (wohnung.verträge.isEmpty()) {
                            leereWohnungen.add(wohnung);
                        }
                    }
                    for (Wohnung wohnung : leereWohnungen) {
                        System.out.println("Leere Wohnungen in der Immobilie " + gesuchteImmobilie.adresse + " \n" + wohnung.wohnungsnummer);
                    }
                }
            }
        }
        return null;
    }
    public void earningsProImmo(){
        System.out.println("\nMonatliches Einkommen pro Immobilie:");
        for (Firma firma : Main.firmen) {
            for (Immobilie immobilie : firma.immobilien) {
                double gesamteinnahmen = 0;
                for (Wohnung wohnung : immobilie.wohnungen) {
                    for (Vertrag vertrag : wohnung.verträge) {
                        gesamteinnahmen += vertrag.monatlicherPreis;
                    }
                }
                System.out.println(immobilie.adresse + " " + gesamteinnahmen + " CHF");
            }
        }
    }
}

