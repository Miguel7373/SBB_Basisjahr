package OOP_J2.Aufgabe1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie den Namen des Patienten ein:");
        String patientenName = scanner.nextLine();

        Patient patient = new Patient(patientenName);
        patient.durchfuehreCheckup();

        System.out.println("\nPatientenname: " + patient.name);
        System.out.println("Größe: " + patient.getGroesse() + " cm");
        System.out.println("Gewicht: " + patient.getGewicht() + " kg");
        System.out.println("Temperatur: " + patient.getTemperatur() + " °C");

        if (patient.istGeimpft()) {
            System.out.println("Der Patient ist geimpft.");
        } else {
            System.out.println("Der Patient ist nicht geimpft.");
        }

        scanner.close();
    }
}