package List_Streams.List.Aufgabe2;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie einen Text ein:");
        String inputText = scanner.nextLine();
        ArrayList<String> wordList = splitText(inputText);
    }
    public static ArrayList<String> splitText(String text) {
        String[] words = text.split("\\s+");
        ArrayList<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word);
        }
        System.out.println(" Anzahl Wörter" + wordList.size());
        System.out.println("Die Wörter in der ArrayList sind:");
        for (String word : wordList) {
            System.out.println(word);
        }
        System.out.println("Alle Nomen");
        for (String word : words) {
            if (Character.isUpperCase(word.charAt(0))) {
                System.out.println(word);
            }
        }
        System.out.println("Gedreht");
        for (int i = wordList.size() - 1; i >= 0; i--) {
            System.out.println(wordList.get(i));
        }
        return wordList;
    }
}