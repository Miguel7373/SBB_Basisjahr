package OOP_J2.Aufgabe4;
import java.util.ArrayList;
import static OOP_J2.Aufgabe4.Firma.*;
public class Immobilien {
    String name;
    String address;
    String hausmeister;
    String verwalter;
    String firmaOwner;
    public Immobilien(String address, String hausmeister, String verwalter, String name, String firmaOwner) {
        this.address = address;
        this.hausmeister = hausmeister;
        this.verwalter = verwalter;
        this.name = name;
        this.firmaOwner = firmaOwner;
    }
    public static ArrayList<Immobilien> immobilenData() {
        ArrayList<Immobilien> immobilienList = new ArrayList<>();
        Immobilien bigben = new Immobilien("bigben", " Levin ", "Nevio ", "Bigben",firmData().get(0).name);
        Immobilien doubleTower = new Immobilien("Wall Street"," Marc ","joel ","doubletower",firmData().get(0).name);
        immobilienList.add(bigben);
        immobilienList.add(doubleTower);
        return immobilienList;
    }
}