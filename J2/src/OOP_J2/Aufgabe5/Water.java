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
        Water hinenfliessendeWassermenge = new Water(10,"ml/s",true);
        Water herausfliessendeWassermenge= new Water(500,"ml/s",false);
        Water hfdas = new Water(490,"ml/s",true);
        WaterMass.add(hfdas);
        WaterMass.add(hinenfliessendeWassermenge);
        WaterMass.add(herausfliessendeWassermenge);
        return WaterMass;
    }
}