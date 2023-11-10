package Aufgabe_3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ParseInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = true;
        while (validInput) {
            try {

                System.out.print("Geben Sie die erste Zahl ein: ");

                double num1 = scanner.nextDouble();


                System.out.print("Geben Sie die zweite Zahl ein: ");
                double num2 = scanner.nextDouble();

                char operator = getOperator(scanner);

                double result = calculateResult(num1, num2, operator);
                System.out.println("Ergebnis: " + result);
                validInput = false;
            } catch (InputMismatchException e) {

                System.err.println("Fehler: Bitte geben Sie gültige Zahlen ein.");
                System.out.println();
                scanner.next();
            }
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
}
