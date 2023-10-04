package List_Streams.Streams.Aufgabe1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
    public class main {
        public static void main(String[] args) {
            sort();
        }
        public static void sort(){
            Scanner scanner = new Scanner(System.in);
            List<Integer> numbers = new ArrayList<>();
            System.out.println("Geben Sie eine Reihe von Zahlen ein (mit Leerzeichen getrennt):");
            String input = scanner.nextLine();
            scanner.close();
            String[] inputArray = input.split(" ");
            for (String str : inputArray) {
                try {
                    int number = Integer.parseInt(str);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Ungültige Eingabe: " + str + " wird ignoriert.");
                }
            }
            System.out.println("Unsortierte Liste: ");
            numbers.forEach(System.out::println);
            List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
            System.out.println("Sortierte Liste: ");
            sortedNumbers.forEach(System.out::println);
        }
    }