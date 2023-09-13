package OOP_J2.aufgabe4;
import java.util.ArrayList;
public class firma {
    String address;
    String name;
    String contract;
    String employee;
    public firma(String address, String name, String contract, String employee) {
        this.address = address;
        this.name = name;
        this.contract = contract;
        this.employee = employee;
    }



    public static ArrayList<firma> firmData() {
        ArrayList<firma> firmaList = new ArrayList<>();
        firma londonMill = new firma("sfdasfda", " dfafas", "fafdafds s", "fadas",);
        firmaList.add(londonMill);
        return firmaList;
    }
}