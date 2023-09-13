package OOP_J2.aufgabe4;
import java.util.ArrayList;
public class firma {
    String immobileienNames;
    String address;
    String name;
    String contract;
    String employee;

    public firma(String immobileienNames, String address, String name, String contract, String employee) {
        this.immobileienNames = immobileienNames;
        this.address = address;
        this.name = name;
        this.contract = contract;
        this.employee = employee;
    }
    public static ArrayList firmData() {
        ArrayList<firma> firmaList = new ArrayList<>();
        firma londonMill = new firma("sfdasfda", " dfafas", "fafdafds s", "fadas", " sfadfaf");
        firmaList.add(londonMill);
        return firmaList;
    }
}