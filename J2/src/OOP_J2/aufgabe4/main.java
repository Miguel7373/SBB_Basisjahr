package OOP_J2.aufgabe4;
import java.util.ArrayList;

public class main {
    public static void main(String args){
        ArrayList<mieter> mieterList = new ArrayList<>();
        mieter john = new mieter("78978934783789","Kampfhelikopter","12.12.1122","john","john@john.john");
        mieterList.add(john);
        ArrayList<wohnung> wohnungsList = new ArrayList<>();
        wohnung bigben_1235 = new wohnung(mieterList.get(0).name," "," 12"," 1235"," Eine grosse wohnung im bigben","bigben_1235");
        wohnungsList.add(bigben_1235);
        ArrayList<immobilien> immobilienList = new ArrayList<>();
        immobilien bigben = new immobilien(wohnungsList.get(0).name," johnstrasse 1", " fff", " fff");
    }
}