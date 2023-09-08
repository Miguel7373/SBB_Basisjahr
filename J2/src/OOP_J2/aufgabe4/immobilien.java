package OOP_J2.aufgabe4;

import java.util.ArrayList;

public class immobilien {
    String wohnung;
    String address;
    String hausmeister;
    String verwalter;

    public immobilien(String wohnung, String address, String hausmeister, String verwalter) {
        this.wohnung = wohnung;
        this.address = address;
        this.hausmeister = hausmeister;
        this.verwalter = verwalter;
    }
    public static ArrayList immobilien() {
        ArrayList<immobilien> immobilienList = new ArrayList<>();
        immobilien bigben = new immobilien(" ", " ", " ", " ");
        immobilienList.add(bigben);
        return immobilienList;
    }
}