package OOP_J2.Aufgabe5;
import static OOP_J2.Aufgabe5.Water.*;

public class Ausführungen {
    public static void GleicheMengen(){
        int totalOut = 0;
        int totalIn = 0;
        for (int i = 0; i < WatherMass().size() ; i++) {
            if (WatherMass().get(i).richtung == false) {
                totalOut = totalOut + WatherMass().get(i).menge;
            } else if (WatherMass().get(i).richtung == true) {
                totalIn = totalIn + WatherMass().get(i).menge;
            }
        }
        if (totalIn== totalOut){
            System.out.println("Gleich");
        } else if (totalIn > totalOut) {
            System.out.println("Damm offen");
        } else {
            System.out.println("Damm geschlossen");
        }
    }
}
