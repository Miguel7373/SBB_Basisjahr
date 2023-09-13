package OOP_J2.aufgabe4;

import java.util.ArrayList;

public class vertrag {
    String specificApartment;
    String startDate;
    String endDate;
    String monthlyCosts;

    public vertrag(String specificApartment, String startDate, String endDate, String monthlyCosts) {
        this.specificApartment = specificApartment;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyCosts = monthlyCosts;
    }
    public static ArrayList<vertrag> vertrag() {
        ArrayList<vertrag> vertragsList = new ArrayList<>();
        vertrag johnsvertrag = new vertrag(" "," "," "," ");
        vertragsList.add(johnsvertrag);
        return vertragsList;
    }
}