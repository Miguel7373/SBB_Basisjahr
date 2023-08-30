package labs_J1;
import java.util.Scanner;
public class aufgabe6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("String eingabe");
        String userinput = scanner.nextLine();
        StringBuilder builder = new StringBuilder(userinput);
        builder.reverse();
        System.out.println(builder);
        int shu = userinput.indexOf(".");
        System.out.println(shu + " Zeichen lang.");

    }
}
