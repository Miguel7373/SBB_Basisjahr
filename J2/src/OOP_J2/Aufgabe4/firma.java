package OOP_J2.Aufgabe4;
import java.util.ArrayList;
public class firma {
    String address;
    String name;
    int immobilien;

    public firma(String address, String name, int immobilien) {
        this.address = address;
        this.name = name;
        this.immobilien = immobilien;

    }



    public static ArrayList<firma> firmData() {
        ArrayList<firma> firmaList = new ArrayList<>();
        firma londonMill = new firma("bakerStreet ", " londonMill",2);
        firmaList.add(londonMill);
        return firmaList;
    }
}