package labs_J1;
import java.util.Scanner;
public class aufgabe7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name");
        String userinput = scanner.nextLine();
        System.out.println("Alter");
        String userinput2 = scanner.nextLine();
        int zahl = Integer.parseInt(userinput2);
        zahl = zahl + 1;
        System.out.println("Hello " + userinput + " you are " + userinput2 + " years old. Next year, you will be " + zahl + " years old.");
        System.out.println(String.format("fd%saf",userinput2));
    }
}

