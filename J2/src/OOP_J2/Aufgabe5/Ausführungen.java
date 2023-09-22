package OOP_J2.Aufgabe5;
import static OOP_J2.Aufgabe5.Water.*;

public class Ausführungen {
    public static void GleicheMengen() {
        int umrechnenOut = 0;
        int umrechnenIn = 0;


        for (int l = 0; l < WatherMass().size(); l++) {
            if (WatherMass().get(l).richtung == false) {
                    if (WatherMass().get(l).einheit.equals("ml/s")) {
                        umrechnenOut = WatherMass().get(l).menge / 1000;


                    } else if (WatherMass().get(l).einheit.equals("dl/s")) {
                        umrechnenOut = WatherMass().get(l).menge / 10;

                    } else if (WatherMass().get(l).einheit.equals("cl/s")) {
                        umrechnenOut = WatherMass().get(l).menge / 100;

                    } else if (WatherMass().get(l).einheit.equals("hl/s")) {
                        umrechnenOut = WatherMass().get(l).menge * 100;

                    }else {
                    umrechnenIn = WatherMass().get(l).menge;

                }

            } else if (WatherMass().get(l).richtung == true) {
                    if (WatherMass().get(l).einheit.equals("ml/s")) {
                        umrechnenIn = WatherMass().get(l).menge / 1000;


                    } else if (WatherMass().get(l).einheit.equals("dl/s")) {
                        umrechnenIn = WatherMass().get(l).menge / 10;

                    } else if (WatherMass().get(l).einheit.equals("cl/s")) {
                        umrechnenIn = WatherMass().get(l).menge / 100;

                    } else if (WatherMass().get(l).einheit.equals("hl/s")) {
                        umrechnenIn = WatherMass().get(l).menge * 100;
                        {

                        }
                    }else {
                        umrechnenIn = WatherMass().get(l).menge;

                    }
            }
        }
            int totalOut = 0;
            int totalIn = 0;
            for (int i = 0; i < WatherMass().size(); i++) {
                if (!WatherMass().get(i).richtung) {
                    totalOut = totalOut + umrechnenOut;
                } else if (WatherMass().get(i).richtung) {
                    totalIn = totalIn + umrechnenIn;
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

}
