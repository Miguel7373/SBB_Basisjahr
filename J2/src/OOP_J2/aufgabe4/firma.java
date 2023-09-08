package OOP_J2.aufgabe4;
import java.util.ArrayList;

public class firma {
    String immobileien;
    String address;
    String name;
    String contract;
    String employee;

    public firma(String immobileien, String address, String name, String contract, String employee) {
        this.immobileien = immobileien;
        this.address = address;
        this.name = name;
        this.contract = contract;
        this.employee = employee;
    }
    public static ArrayList firma() {
        ArrayList<firma> firmaList = new ArrayList<>();
        firma londonMill = new firma(" "," "," ",""," ");
        return firmaList;

    }
}