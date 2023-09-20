package OOP_J2.Aufgabe4;
import java.util.ArrayList;
public class mieter {
    String phoneNumber;
    String gender;
    String birthday;
    String name;
    String email;

    public mieter(String phoneNumber, String gender, String birthday, String name, String email) {
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.name = name;
        this.email = email;
    }
    public static ArrayList<mieter> mieter() {
        ArrayList<mieter> mieterList = new ArrayList<>();
        mieter john = new mieter("1344254","F","05.05.1853 ","john ","john@john.john");
        mieter loris = new mieter("25438794","M","06.09.1969","Loris","Loris@weed.ch");
        mieter raphaël = new mieter("245897942","M","11.18.2021","Raphaël","bigman@big.ch");
        mieterList.add(john);
        mieterList.add(loris);
        mieterList.add(raphaël);
        return mieterList;
    }
}