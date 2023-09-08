package OOP_J2.aufgbe1;

public class main {
    public static void main(String[] args) {
        patient john = new patient(180, 90, 40,"true");
        System.out.println("Grösse " + john.grösse + " Gewicht " + john.gewicht + " Temperatur " + john.temperatur + " Geimpft " + john.geimpft);

    }
}
