package OOP_J2.aufgbe1;

public class Main {
    public static void main(String[] args) {
        Patient john = new Patient(180, 90, 40,"true");
        System.out.println("Grösse " + john.grösse + " Gewicht " + john.gewicht + " Temperatur " + john.temperatur + " Geimpft " + john.geimpft);
    }
}