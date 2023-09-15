package OOP_J2.aufgabe4;
import static OOP_J2.aufgabe4.mieter.mieter;

import java.util.ArrayList;

public class wohnung {
    String mieter;
    String vertrag;
    String stockwerk;
    String wohnungsnummer;
    String beschreibung;
    String name;


    public wohnung(String mieter, String stockwerk, String wohnungsnummer, String beschreibung, String name) {
        this.name = name;
        this.mieter = mieter;
        this.stockwerk = stockwerk;
        this.wohnungsnummer = wohnungsnummer;
        this.beschreibung = beschreibung;
    }
    public static ArrayList<wohnung> wohnung() {
        ArrayList<wohnung> wohnungsList = new ArrayList<>();
        wohnung bigben_1235 = new wohnung(mieter().get(0).name,"12","35","Wohnung ohne gutem ausblick","Bigben_1235");
        wohnung bigben_1236 = new wohnung(mieter().get(1).name,"12","36","Wohnung mit gutem ausblick","Bigben_1236");
        wohnung doubletower_2 = new wohnung(mieter().get(2).name,"2","4","Manchmal fast so laut wie ein flugzeug das startet","doubletower_2");
        wohnung doubletower_1 = new wohnung(" ","1","2","es kracht of in der wohnung oben dran","doubletower_1");
        wohnung bigmanswohnung = new wohnung(mieter().get(0).name,"2","4","beste","doubletowerBigmansWohnung");
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