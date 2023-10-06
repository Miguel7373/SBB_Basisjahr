package OOP_J2.Aufgabe4;
import static OOP_J2.Aufgabe4.Mieter.mieter;

import java.util.ArrayList;

public class Wohnung {
    String mieter;
    String vertrag;
    String stockwerk;
    String wohnungsnummer;
    String beschreibung;
    String name;


    public Wohnung(String mieter, String stockwerk, String wohnungsnummer, String beschreibung, String name) {
        this.name = name;
        this.mieter = mieter;
        this.stockwerk = stockwerk;
        this.wohnungsnummer = wohnungsnummer;
        this.beschreibung = beschreibung;
    }
    public static ArrayList<Wohnung> wohnung() {
        ArrayList<Wohnung> wohnungsList = new ArrayList<>();
        Wohnung bigben_1235 = new Wohnung(mieter().get(0).name,"12","35","Wohnung ohne gutem ausblick","Bigben_1235");
        Wohnung bigben_1236 = new Wohnung(mieter().get(1).name,"12","36","Wohnung mit gutem ausblick","Bigben_1236");
        Wohnung doubletower_2 = new Wohnung(mieter().get(2).name,"2","4","Manchmal fast so laut wie ein flugzeug das startet","doubletower_2");
        Wohnung doubletower_1 = new Wohnung(" ","1","2","es kracht of in der wohnung oben dran","doubletower_1");
        Wohnung bigmanswohnung = new Wohnung(mieter().get(0).name,"2","4","beste","doubletowerBigmansWohnung");
        wohnungsList.add(bigben_1235);
        wohnungsList.add(bigben_1236);
        wohnungsList.add(doubletower_2);
        wohnungsList.add(bigmanswohnung);
        wohnungsList.add(doubletower_1);

        return wohnungsList;
    }

    public String getName() {
        return name;
    }

    public String getAllWohnung() {
        return  name + stockwerk +  wohnungsnummer + beschreibung;
    }
}