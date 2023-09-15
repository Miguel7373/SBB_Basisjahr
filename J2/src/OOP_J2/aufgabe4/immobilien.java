package OOP_J2.aufgabe4;
import java.util.ArrayList;
import static OOP_J2.aufgabe4.firma.*;
public class immobilien {
    String name;
    String address;
    String hausmeister;
    String verwalter;
    String firmaOwner;
    public immobilien( String address, String hausmeister, String verwalter, String name, String firmaOwner) {
        this.address = address;
        this.hausmeister = hausmeister;
        this.verwalter = verwalter;
        this.name = name;
        this.firmaOwner = firmaOwner;
    }
    public static ArrayList<immobilien> immobilenData() {
        ArrayList<immobilien> immobilienList = new ArrayList<>();
        immobilien bigben = new immobilien("bigben", " Levin ", "Nevio ", "Bigben",firmData().get(0).name);
        immobilien doubleTower = new immobilien("Wall Street"," Marc ","joel ","doubletower",firmData().get(0).name);
        immobilienList.add(bigben);
        immobilienList.add(doubleTower);
        return immobilienList;
    }
}