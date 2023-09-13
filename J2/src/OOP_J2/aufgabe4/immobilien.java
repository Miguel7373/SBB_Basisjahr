package OOP_J2.aufgabe4;

import java.util.ArrayList;
import static OOP_J2.aufgabe4.firma.firmData;

public class immobilien {
    String name;
    String wohnung;
    String address;
    String hausmeister;
    String verwalter;
    String firmaOwner;

    public immobilien(String wohnung, String address, String hausmeister, String verwalter, String name, String firmaOwner) {
        this.wohnung = wohnung;
        this.address = address;
        this.hausmeister = hausmeister;
        this.verwalter = verwalter;
        this.name = name;
        this.firmaOwner = firmaOwner;
    }



    public static ArrayList immobilenData() {
        ArrayList<immobilien> immobilienList = new ArrayList<>();
        immobilien bigben = new immobilien("bigben", " ", " ", " ","nevio","firmData().get(0).immobileienNames");
        immobilienList.add(bigben);
        return immobilienList;

    }

}