package labs_J1;
import java.util.Scanner;
public class aufgabe3 {
    public static int berechneFakultaet(int zahl) {
        int fakultaet = 1;
        for (int i = 1; i <= zahl; i++) {
            fakultaet *= i;
        }
        return fakultaet;
    }
    public static int summeDurchzahlTeilbar() {
        Integer zahl = 4;

        int summe = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % zahl == 0) {
                summe += i;
            }
        }
        return summe;
    }

    public static void main(String[] args) {
        System.out.println(berechneFakultaet(3));
        System.out.println(summeDurchzahlTeilbar());

    }


}
