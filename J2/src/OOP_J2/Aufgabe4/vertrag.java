package OOP_J2.Aufgabe4;
import static OOP_J2.Aufgabe4.wohnung.*;
import static OOP_J2.Aufgabe4.mieter.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class vertrag {
    String specificApartment;
    String startDate;
    LocalDate endDate;
    int monthlyCosts;
    String besitzer;
    public vertrag(String specificApartment, String startDate, LocalDate endDate, int monthlyCosts, String besitzer) {
        this.specificApartment = specificApartment;
        this.besitzer = besitzer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyCosts = monthlyCosts;


    }
    public static ArrayList<vertrag> vertrag() {
        LocalDate enddatejohn = LocalDate.of(2023, Month.OCTOBER, 1);
        LocalDate enddateloris = LocalDate.of(2024, Month.APRIL, 4);
        LocalDate enddateRaphaël = LocalDate.of(2024, Month.SEPTEMBER,30);
        LocalDate enddateBigman = LocalDate.of(2024, Month.SEPTEMBER,30);
        ArrayList<vertrag> vertragsList = new ArrayList<>();
        vertrag johnsvertrag = new vertrag(wohnung().get(0).name,"1.9.2020",enddatejohn,1200 ,mieter().get(0).name);
        vertrag lorisesvertrag = new vertrag(wohnung().get(1).name,"15.1.2023",enddateloris,1000,mieter().get(1).name);
        vertrag raphaëlsvertrag = new vertrag(wohnung().get(2).name,"19.6.1998",enddateRaphaël,1600,mieter().get(2).name);
        vertrag bigmansvertrag = new vertrag(wohnung().get(4).name,"fdas",enddateBigman,100,mieter().get(0).name);
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