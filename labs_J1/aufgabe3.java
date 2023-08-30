package labs_J1;
import java.util.Scanner;
public class aufgabe3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib eine nummer ein");
        String zahl = sc.nextLine();
        int zahl1 = Integer.parseInt(zahl);
        int fakultaet = 1;
        for (int i = 1;zahl1 >= i; i++) {
            fakultaet *= i;
            System.out.println(fakultaet);
        }
        int number = 0;
        int zahl2 = zahl1;
        for (int j = 1; j <= 100; j++) {
            if (j % zahl2 == 0) {
                number += j;
            }
        }
        System.out.println(number);
    }
}
