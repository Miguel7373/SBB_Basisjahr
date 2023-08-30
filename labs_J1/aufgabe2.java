package labs_J1;
import java.util.Scanner;
public class aufgabe2 {

    public static String Name(String Miguel) {
        if (Miguel.contains("Miguel")) {
            System.out.println("Hello Miguel");
            System.exit(0);
        }
        return Miguel ;
    }
    public static void main(String[] args) {
        if (Name().contains("Miguel")) {
            System.out.println("Hello Miguel");
            System.exit(0);
        }

        public static Integer Schaltjahr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib eine nummer ein");
        String str = sc.nextLine();
        double zahl = Double.parseDouble(str);
        if (zahl % 4 == 0) {
            System.out.println("das ist ein Schaltjahr");
        } else {
            System.out.println("das ist kein schaltjahr");
        }
          return (Schaltjahr());
    }

    public static Integer ungerade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib eine nummer ein");
        String str = sc.nextLine();
        double zahl = Double.parseDouble(str);
        if (zahl % 2 == 0) {
        } else {
            System.out.println("die zahl ist ungerade");
        }
        return ungerade();
    }

    public static Integer equals() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib eine nummer ein");
        String str = sc.nextLine();
        double zahl = Double.parseDouble(str);

        if (str.equals("0")) {
            System.out.println("equals 0 ");
        } else if (zahl > 0) {
            System.out.println("die zahl ist grösser als null");
        } else if (zahl < 0) {
            System.out.println("die zahl ist kleiner als null");
        }
        return equals();
    }
}
