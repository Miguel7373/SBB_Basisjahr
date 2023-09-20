package OOP_J2.Aufgabe5;

import java.util.ArrayList;
public class Water {
    int menge;
    String einheit;
    boolean richtung;

    public Water(int menge, String einheit, boolean richtung) {
        this.menge = menge;
        this.einheit = einheit;
        this.richtung = richtung;
    }

    public static ArrayList<Water> WatherMass() {
        ArrayList<Water> WaterMass = new ArrayList<>();
        Water hinenfliessendeWassermenge = new Water(50,"l/s",true);
        Water herausfliessendeWassermenge= new Water(50,"l/s",false);
        Water jkld= new Water(0,"l/s",false);
        WaterMass.add(jkld);

        WaterMass.add(hinenfliessendeWassermenge);
        WaterMass.add(herausfliessendeWassermenge);
        return WaterMass;
    }
}
