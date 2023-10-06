package OOP_J2.Aufgabe4;
import static OOP_J2.Aufgabe4.Wohnung.*;
import static OOP_J2.Aufgabe4.Mieter.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Vertrag {
    String specificApartment;
    String startDate;
    LocalDate endDate;
    int monthlyCosts;
    String besitzer;
    public Vertrag(String specificApartment, String startDate, LocalDate endDate, int monthlyCosts, String besitzer) {
        this.specificApartment = specificApartment;
        this.besitzer = besitzer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyCosts = monthlyCosts;


    }
    public static ArrayList<Vertrag> vertrag() {
        LocalDate enddatejohn = LocalDate.of(2023, Month.OCTOBER, 10);
        LocalDate enddateloris = LocalDate.of(2024, Month.APRIL, 4);
        LocalDate enddateRaphaël = LocalDate.of(2024, Month.SEPTEMBER,30);
        LocalDate enddateBigman = LocalDate.of(2024, Month.SEPTEMBER,30);
        ArrayList<Vertrag> vertragsList = new ArrayList<>();
        Vertrag johnsvertrag = new Vertrag(wohnung().get(0).name,"1.9.2020",enddatejohn,1200 ,mieter().get(0).name);
        Vertrag lorisesvertrag = new Vertrag(wohnung().get(1).name,"15.1.2023",enddateloris,1000,mieter().get(1).name);
        Vertrag raphaëlsvertrag = new Vertrag(wohnung().get(2).name,"19.6.1998",enddateRaphaël,1600,mieter().get(2).name);
        Vertrag bigmansvertrag = new Vertrag(wohnung().get(4).name,"fdas",enddateBigman,100,mieter().get(0).name);
        vertragsList.add(johnsvertrag);
        vertragsList.add(lorisesvertrag);
        vertragsList.add(raphaëlsvertrag);
        vertragsList.add(bigmansvertrag);
        return vertragsList;
    }
    public String getAll(){
        return specificApartment + besitzer + startDate + endDate + monthlyCosts;
    }
}