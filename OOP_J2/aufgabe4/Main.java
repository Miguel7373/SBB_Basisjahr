package OOP_J2.aufgabe4;

import OOP_J2.aufgabe3.Perosn;
import java.util.ArrayList;

public class Main {
    public static void main(String args){
        ArrayList<Mieter> mieterList = new ArrayList<>();
        Mieter john = new Mieter("78978934783789","Kampfhelikopter","12.12.1122","john","john@john.john");
        mieterList.add(john);
        ArrayList<Wohnung> wohnungsList = new ArrayList<>();
        Wohnung bigben_1235 = new Wohnung(mieterList.get(0).name,"","12","1235","Eine grosse wohnung im bigben","bigben_1235");
        wohnungsList.add(bigben_1235);
        ArrayList<Immobilien> immobilienList = new ArrayList<>();
        Immobilien bigben = new Immobilien(wohnungsList.get(0).name," johnstrasse 1", " fff", " fff");

    }
}