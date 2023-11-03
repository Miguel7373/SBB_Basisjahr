package List_Streams.Streams.Aufgabe2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class main {
    public static void main(String[] args) {
        TimesTow();
    }
    public static void TimesTow(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int[] fd = new int[2];
        System.out.println("Geben Sie eine Reihe von Zahlen ein (mit Leerzeichen getrennt):");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        for (String str : inputArray) {
            try {
                int number = Integer.parseInt(str);
                list.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe: " + str + " wird ignoriert.");
            }
        }
        System.out.println("Unsortierte Liste: ");
        list.forEach(System.out::println);
        List<Integer> sortedNumbers = list.stream().sorted().toList();
        System.out.println("Sortierte Liste: ");
        sortedNumbers.forEach(System.out::println);
        System.out.println("Times Two");
        list.stream().map(number -> number * number).forEach(System.out::println);
        System.out.println("Sortierte Liste: ");
        list.stream().map(number -> number * number).sorted().toList().forEach(System.out::println);
    }
}