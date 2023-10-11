package OOP_J2.Aufgabe5;
public class main {
    public static void main(String[] args) {
        Dam dam = new Dam();
        Dam dam1 = new Dam();

        Water inflow1 = new Water(260, "ml/s", true);
        Water inflow2 = new Water(1, "l/s", true);
        Water outflow1 = new Water(250, "l/s", false);
        Water outflow2 = new Water(1, "l/s", false);

        dam1.addWaterMass(inflow1);
        dam.addWaterMass(inflow2);
        dam1.addWaterMass(outflow1);
        dam.addWaterMass(outflow2);

        dam.checkDamStatus();
        dam1.checkDamStatus();
    }
}