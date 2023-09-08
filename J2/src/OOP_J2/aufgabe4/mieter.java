package OOP_J2.aufgabe4;

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
    public static ArrayList mieter() {
        ArrayList<mieter> mieterList = new ArrayList<>();
        mieter john = new mieter(" "," "," "," "," ");
        mieterList.add(john);
        return mieterList;
    }
}