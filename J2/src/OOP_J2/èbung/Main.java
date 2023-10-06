package OOP_J2.èbung;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Firma lost = new Firma("lost", "li 20");
            Person rudi = new Person("Rudi", "01.01.1980", Gender.Male);
            lost.addAngestellter(rudi);
            Person alfred = new Person("Alfred", "02.02.1990", Gender.Male);
            lost.addAngestellter(alfred);
            Person suba = new Person("Suba", "01.01.1980", Gender.Male);
            lost.addAngestellter(suba);
            Person mika = new Person("Mika", "02.02.1990", Gender.Male);
            lost.addAngestellter(mika);


            Immobilie blau = new Immobilie("li 20",rudi,alfred);
            lost.addImmobilie(blau);

                Wohnung blau1 = new Wohnung(1, "1A", "qw",blau);
                blau.addWohnung(blau1);
                Wohnung blau2 = new Wohnung(1, "1B", "qw",blau);
                blau.addWohnung(blau2);
                    Mieter nevio = new Mieter("Joel", "01.01.2000", Gender.Divers);
            Immobilie rot = new Immobilie("fd 23",suba,mika);
            lost.addImmobilie(rot);

                Wohnung rot1 = new Wohnung(1, "1A", "qw",rot);
                rot.addWohnung(rot1);
                    Mieter marc = new Mieter("marc", "01.01.2000", Gender.Divers);

                Wohnung rot2 = new Wohnung(1, "1B", "qw",rot);
                rot.addWohnung(rot2);

                    Mieter joel = new Mieter("Joel", "01.01.2000", Gender.Divers);


                    Vertrag hehe = new Vertrag(LocalDate.of(2020, 11, 2), LocalDate.of(2023, 11, 2), 100, joel, rot2);
                    Vertrag hahe = new Vertrag(LocalDate.of(2020, 11, 2), LocalDate.of(2023, 11, 2), 100, marc, rot1);
                    Vertrag heha = new Vertrag(LocalDate.of(2020, 11, 2), LocalDate.of(2023, 11, 2), 100, nevio, blau2);



            }
        }

        /*

        blau.assignAbwart(abwart);
        lost.addAngestellter(abwart);
        blau.assignVerwalter(verwalter);
        lost.addAngestellter(verwalter);


         */



