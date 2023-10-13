package OOP_J2.Aufgabe5;
import java.util.ArrayList;
import java.util.List;
public class Dam {
    List<Water> waterMasses = new ArrayList<>();
    private Water currentWaterMass;

    public List<Water> getWaterMasses() {
        return waterMasses;
    }
    public void checkDamStatus() {
        int totalOut = 0;
        int totalIn = 0;

        for (Water waterMass : waterMasses) {
            currentWaterMass = waterMass;

            if (!waterMass.flussrichtung) {
                int umrechnenOut = umrechnenMenge();
                totalOut += umrechnenOut;
            } else {
                int umrechnenIn = umrechnenMenge();
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

    private int umrechnenMenge() {
        return switch (currentWaterMass.einheit) {
            case "ml/s" -> currentWaterMass.menge / 1000;
            case "dl/s" -> currentWaterMass.menge / 10;
            case "cl/s" -> currentWaterMass.menge / 100;
            case "hl/s" -> currentWaterMass.menge * 100;
            default -> currentWaterMass.menge;
        };
    }
}