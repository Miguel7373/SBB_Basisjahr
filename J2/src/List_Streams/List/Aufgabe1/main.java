package List_Streams.List.Aufgabe1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        PosInList();
    }
    public static void PosInList() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> myList = new ArrayList<Integer>();
        System.out.println("Gib Werte ein (oder 'q' zum Beenden):");
        while (true) {
            String input = scanner.next();
            if (input.equals("q")) {
                break;
            }
            if (isValidInput(input)) {
                int value = Integer.parseInt(input);
                myList.add(value);
            } else {
                System.out.println("Ungültige Eingabe. Bitte gib eine ganze Zahl oder 'q' ein.");
            }
        }
        System.out.println("Die Liste enthält folgende Werte: " + myList);
        while (true) {
            System.out.println("Welche Position möchtest du ausgeben?");
            String posInput = scanner.next();
            if (isValidInput(posInput)) {
                int inputPos = Integer.parseInt(posInput);
                if (inputPos >= 0 && inputPos < myList.size()) {
                    System.out.println(myList.get(inputPos));
                    break;
                } else {
                    System.out.println("ERROR! Die Position " + inputPos + " existiert nicht.");
                }
            } else {
                System.out.println("ERROR! Ungültige Position. Versuche es erneut.");
            }
        }
    }

    public static boolean isValidInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}