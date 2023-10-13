package OOP_J2.Aufgabe5;
public class main {
    public static void main(String[] args) {
        Dam dam = new Dam();

        Water inflow1 = new Water(260, "ml/s", false);
        Water inflow2 = new Water(1, "l/s", true);
        Water outflow1 = new Water(250, "l/s", false);
        Water outflow2 = new Water(1, "l/s", false);

        dam.getWaterMasses().add(inflow1);
        dam.getWaterMasses().add(inflow2);
        dam.getWaterMasses().add(outflow1);
        dam.getWaterMasses().add(outflow2);

        dam.checkDamStatus();

    }
}