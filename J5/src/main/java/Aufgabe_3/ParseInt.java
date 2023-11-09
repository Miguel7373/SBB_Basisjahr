package Aufgabe_3;

import Aufgebe_1.File_ReaderRules;

import java.util.*;
import java.util.stream.Collectors;

public class ParseInt implements File_ReaderRules {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Geben Sie die erste Zahl ein: ");
            double num1 = scanner.nextDouble();

            System.out.print("Geben Sie die zweite Zahl ein: ");
            double num2 = scanner.nextDouble();

            char operator = getOperator(scanner);

            double result = calculateResult(num1, num2, operator);
            System.out.println("Ergebnis: " + result);

        } catch (InputMismatchException e) {
            System.err.println("Fehler: Bitte geben Sie gültige Zahlen ein.");
        } finally {
            scanner.close();
        }
    }

    private static char getOperator(Scanner scanner) {
        System.out.print("Wählen Sie die Rechenoperation (+, -, *, /) oder geben Sie 'z' für Zufall ein: ");
        char operator = scanner.next().charAt(0);

        if (operator == 'z') {
            Random random = new Random();
            char[] operators = {'+', '-', '*', '/'};
            operator = operators[random.nextInt(operators.length)];
            System.out.println("Zufällig ausgewählte Operation: " + operator);
        }

        return operator;
    }

    private static double calculateResult(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.err.println("Fehler: Division durch Null ist nicht erlaubt.");
                    System.exit(1);
                }
            default:
                System.err.println("Ungültige Rechenoperation.");
                System.exit(1);
                return 0;
        }
    }

    @Override
    public int countAllWords(List<String> wordList) {
        return wordList.size();
    }

    @Override
    public int countWordsWithQ(List<String> wordList) {
        return (int) wordList.stream().filter(word -> word.toLowerCase().contains("q")).count();
    }

    @Override
    public Set<Character> getUniqueSpecialCharacters(List<String> wordList) {
        return wordList.stream()
                .flatMapToInt(String::chars)
                .filter(c -> !Character.isLetterOrDigit(c))
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }

    @Override
    public int countWordsWithMi(List<String> wordList) {
        return (int) wordList.stream().filter(word -> word.toLowerCase().contains("mi")).count();
    }

    @Override
    public Set<Character> getAllCeracters(List<String> wordList) {
        return wordList.stream()
                .flatMapToInt(String::chars)
                .filter(Character::isLetter)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }

    public void hallo(){

    }

}
