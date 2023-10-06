package OOP_J2.Aufgabe4;
import java.util.ArrayList;
public class Mieter {
    String phoneNumber;
    String gender;
    String birthday;
    String name;
    String email;

    public Mieter(String phoneNumber, String gender, String birthday, String name, String email) {
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.name = name;
        this.email = email;
    }
    public static ArrayList<Mieter> mieter() {
        ArrayList<Mieter> mieterList = new ArrayList<>();
        Mieter john = new Mieter("1344254","F","05.05.1853 ","john ","john@john.john");
        Mieter loris = new Mieter("25438794","M","06.09.1969","Loris","Loris@weed.ch");
        Mieter raphaël = new Mieter("245897942","M","11.18.2021","Raphaël","bigman@big.ch");
        mieterList.add(john);
        mieterList.add(loris);
        mieterList.add(raphaël);
        return mieterList;
    }
}