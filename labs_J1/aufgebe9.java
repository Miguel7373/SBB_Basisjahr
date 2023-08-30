package labs_J1;
import java.util.Scanner;
public class aufgebe9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("zahl 1");
        String userinput = scanner.nextLine();
        System.out.println("zahl 2");
        String userinput2 = scanner.nextLine();
        double zahl1 = Double.parseDouble(userinput);
        double zahl2 = Double.parseDouble(userinput2);
        System.out.println(zahl1 + zahl2);
        System.out.println("name");
        String userinput3 = scanner.nextLine();
        System.out.println("Hello " + userinput3);
    }
}