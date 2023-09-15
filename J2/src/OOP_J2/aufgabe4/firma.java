package OOP_J2.aufgabe4;
import java.util.ArrayList;
import static OOP_J2.aufgabe4.immobilien.*;
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
        firma londonMill = new firma("bakerStreet ", " londonMill", immobilenData().size());
        firmaList.add(londonMill);
        return firmaList;
    }
}