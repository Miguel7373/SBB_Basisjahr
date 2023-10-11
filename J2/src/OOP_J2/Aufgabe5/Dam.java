package OOP_J2.Aufgabe5;
import java.util.ArrayList;
import java.util.List;
public class Dam {
    List<Water> waterMasses = new ArrayList<>();

    public void addWaterMass(Water waterMass) {
        waterMasses.add(waterMass);
    }
    public void checkDamStatus() {
        int totalOut = 0;
        int totalIn = 0;
        for (Water waterMass : waterMasses) {
            if (!waterMass.flussrichtung) {
                int umrechnenOut = umrechnenMenge(waterMass);
                totalOut += umrechnenOut;
            } else {
                int umrechnenIn = umrechnenMenge(waterMass);
                totalIn += umrechnenIn;
            }
        }
        if (totalIn == totalOut) {
            System.out.println("Gleich");
        } else if (totalIn > totalOut) {
            System.out.println("Damm offen");
        } else {
            System.out.println("Damm geschlossen");
        }
    }
    private int umrechnenMenge(Water waterMass) {
        int umrechnen = switch (waterMass.einheit) {
            case "ml/s"-> waterMass.menge / 1000;
            case "dl/s" -> waterMass.menge / 10;
            case "cl/s"-> waterMass.menge / 100;
            case "hl/s"-> waterMass.menge * 100;
            default-> waterMass.menge;
        };
        return umrechnen;
    }
}