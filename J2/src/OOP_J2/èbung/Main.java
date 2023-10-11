package OOP_J2.èbung;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static OOP_J2.èbung.Firma.*;
public class Main {
    public static List<Firma> firmen = new ArrayList<>();


    public static void main(String[] args) {
        Firma lost = new Firma("Lost Immobilien", "Li20 Straße 123");
        Firma gg = new Firma("GG Wohnungen", "FF Allee 45");
        Person rudi = new Person("Rudi", "01.01.1980", Gender.Male);
        lost.addAngestellter(rudi);
        Person alfred = new Person("Alfred", "02.02.1990", Gender.Male);
        lost.addAngestellter(alfred);
        Person suba = new Person("Suba", "03.03.1985", Gender.Female);
        lost.addAngestellter(suba);
        Person mika = new Person("Mika", "04.04.1995", Gender.Male);
        lost.addAngestellter(mika);

        Immobilie blau = new Immobilie("Li20 Straße 123", rudi, alfred);
        gg.addImmobilie(blau);

        Wohnung blau1 = new Wohnung(1, "1A", "2 Zimmer, 1 Bad", blau);
        blau.addWohnung(blau1);
        Wohnung blau2 = new Wohnung(2, "1B", "3 Zimmer, 2 Bäder", blau);
        blau.addWohnung(blau2);
        Mieter nevio = new Mieter("Nevio", "01.01.2000", Gender.Divers);
        Immobilie rot = new Immobilie("FF Allee 45", suba, mika);
        lost.addImmobilie(rot);

        Wohnung rot1 = new Wohnung(1, "2A", "2 Zimmer, 1 Bad", rot);
        rot.addWohnung(rot1);
        Mieter marc = new Mieter("Marc", "01.01.2001", Gender.Male);
        Wohnung rot2 = new Wohnung(2, "2B", "3 Zimmer, 2 Bäder", rot);
        rot.addWohnung(rot2);
        Mieter joel = new Mieter("Joel", "01.01.2002", Gender.Divers);

        Vertrag hehe = new Vertrag(LocalDate.of(2020, 11, 2), LocalDate.of(2023, 11, 2), 1000, joel, rot2);
        Vertrag hahe = new Vertrag(LocalDate.of(2020, 11, 2), LocalDate.of(2023, 11, 2), 900, marc, rot1);
        Vertrag heha = new Vertrag(LocalDate.of(2020, 11, 2), LocalDate.of(2024, 11, 2), 1100, nevio, blau2);
        blau2.addVertrag(heha);
        rot1.addVertrag(hahe);
        rot2.addVertrag(hehe);

        firmen.add(lost);
        firmen.add(gg);
        int anzahl = 0;
        for (Firma firma : firmen) {
            anzahl += firma.getAnzahlImmobilien();
        }
        System.out.println("Anzahl aller Immobilien " + anzahl);
        System.out.println(lost.searchForApartment());
        System.out.println(blau.verträgeProImmo());
        System.out.println(blau.freeWohnung());
        System.out.println(lost.ablaufendeFerträge());
        lost.sortedContracs();
        blau.earningsProImmo();
        lost.earnisgsProFirmaYearly();











    }
}

