package OOP_J2.èbung;
import java.time.LocalDate;
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

    public int getAnzahlImmobilien() {
        return immobilien.size();
    }

    public List<Immobilie> getImmobilien() {
        return immobilien;
    }

    public String getName() {
        return name;
    }

    public String searchForApartment() {
        Wohnung gesuchteWohnung = null;
        for (Firma firma : Main.firmen) {
            for (Immobilie immobilie : firma.getImmobilien()) {
                for (Wohnung wohnung : immobilie.getWohnungen()) {
                    if (wohnung.getWohnungsnummer().equals("2B")) {
                        gesuchteWohnung = wohnung;
                        break;
                    }
                }
                if (gesuchteWohnung != null) {
                    break;
                }
            }
        }

        if (gesuchteWohnung != null) {
            return ("Abwart für Wohnung 2B " + gesuchteWohnung.getAbwart().getName());
        } else {
            return ("Die gesuchte Wohnung wurde nicht gefunden.");
        }
    }

    public String ablaufendeFerträge() {
        LocalDate naechsterMonat = LocalDate.now().plusMonths(1);
        List<Vertrag> vertraegeImNaechstenMonat = new ArrayList<>();
        for (Firma firma : Main.firmen) {
            for (Immobilie immobilie : firma.immobilien) {
                for (Wohnung wohnung : immobilie.wohnungen) {
                    for (Vertrag vertrag : wohnung.verträge) {
                        if (vertrag.endDatum.getMonth() == naechsterMonat.getMonth()
                                && vertrag.endDatum.getYear() == naechsterMonat.getYear()) {
                            vertraegeImNaechstenMonat.add(vertrag);
                        }
                    }
                }
            }
        }

        for (Vertrag vertrag : vertraegeImNaechstenMonat) {
            return ("Verträge, die im nächsten Monat ablaufen:\n" + vertrag.mieter.name + " - " + vertrag.startDatum + " bis " + vertrag.endDatum);
        }
        return null;
    }

    public void sortedContracs() {
        List<Vertrag> alleVertraegeSortiert = new ArrayList<>();
        for (Firma firma : Main.firmen) {
            for (Immobilie immobilie : firma.immobilien) {
                for (Wohnung wohnung : immobilie.wohnungen) {
                    alleVertraegeSortiert.addAll(wohnung.verträge);
                }
            }
        }
        alleVertraegeSortiert.sort(Comparator.comparing(vertrag -> vertrag.mieter.name));
        System.out.println("\nAlle Verträge sortiert nach Personen:");
        for (Vertrag vertrag : alleVertraegeSortiert) {
            System.out.println(vertrag.mieter.name + " - " + vertrag.startDatum + " bis " + vertrag.endDatum);
        }
    }

    public String earnisgsProFirmaYearly() {
        int aktuellesJahr = LocalDate.now().getYear();
        double jaehrlichesEinkommen = 0;
        String gewuenschteFirma = "GG Wohnungen";
        for (Firma firma : Main.firmen) {
            if (firma.getName().equals(gewuenschteFirma)) {
                for (Immobilie immobilie : firma.immobilien) {
                    for (Wohnung wohnung : immobilie.wohnungen) {
                        for (Vertrag vertrag : wohnung.verträge) {
                            int vertragsEndJahr = vertrag.endDatum.getYear();

                            if (vertragsEndJahr == aktuellesJahr) {
                                int startMonat = vertrag.startDatum.getMonthValue();
                                int endMonat = vertrag.endDatum.getMonthValue();
                                int monateLaufzeit = endMonat - startMonat + 1;
                                jaehrlichesEinkommen += (vertrag.monatlicherPreis * monateLaufzeit);
                            } else if (vertragsEndJahr > 2023) {
                                jaehrlichesEinkommen += (vertrag.monatlicherPreis * 12);
                            }
                        }
                    }
                }
            }
        }
        return ("\nJährliches Einkommen der Firma " + gewuenschteFirma + " " + jaehrlichesEinkommen + " CHF");
    }
}