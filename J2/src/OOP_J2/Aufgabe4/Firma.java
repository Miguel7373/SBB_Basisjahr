package OOP_J2.Aufgabe4;
import java.util.ArrayList;
public class Firma {
    String address;
    String name;
    int immobilien;

    public Firma(String address, String name, int immobilien) {
        this.address = address;
        this.name = name;
        this.immobilien = immobilien;

    }



    public static ArrayList<Firma> firmData() {
        ArrayList<Firma> firmaList = new ArrayList<>();
        Firma londonMill = new Firma("bakerStreet ", " londonMill",2);
        firmaList.add(londonMill);
        return firmaList;
    }
}