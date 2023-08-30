package labs_J1;
import java.util.Scanner;
public class aufgabe4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masse eingeben");
        String masse = scanner.nextLine();
        String parts [] = masse.split(" ");
        double zahl1 = Double.parseDouble(parts[0]);
        double zahl2 = Double.parseDouble(parts[1]);
        double zahl3 = zahl1 * zahl2;
        System.out.println("Fläche Rechteck");
        System.out.println(zahl3);
        System.out.println("Umfang Rechteck");
        System.out.println(zahl2 + zahl2 + zahl1 + zahl1 );
        System.out.println("Fläche Kreis");
        System.out.println(zahl3 * 3.14159265358979323846);

        System.out.println("seitenlänge und höhe");
        String userinput = scanner.nextLine();
        String part [] = userinput.split(" ");
        double zahl4 = Double.parseDouble(part[0]);
        double zahl5 = Double.parseDouble(part[1]);
        double zahl6 = zahl4 * zahl4;
        System.out.println(zahl6 * zahl5 / 3);
        System.out.println("Geburtsdatum in DD.MM.YYYY");
        String masse3 = scanner.nextLine();
        String parts3 [] = masse3.split("\\.");
        double zahl9 = Double.parseDouble(parts3[0]);
        double zahl7 = Double.parseDouble(parts3[1]);
        double zahl8 = Double.parseDouble(parts3[2]);
        double day = 17 - zahl9;
        double month = 8 - zahl7;
        double year = 2023 - zahl8;
        double days = year * 365 + month * 30 + day;
        System.out.println("Tage"+" "+ days);
        System.out.println("Monate"+" "+ days / 30);
        System.out.println("jahre"+" "+ days / 365);
        System.out.println("zahl eingeben");
        String userinput2 = scanner.nextLine();
        double zahl11 = Double.parseDouble(userinput2);
        double zahl21 = 3 * zahl11;
        double zahl31 = 5 * zahl11;
        System.out.println(zahl21 + zahl31);
    }
}
