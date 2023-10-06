package OOP_J2.Aufgabe1;

import java.util.Scanner;

public class Patient {
        String name;
        private double groesse;
        private double gewicht;
        private double temperatur;
        private boolean geimpft;

        public Patient(String name) {
            this.name = name;
        }

        public void durchfuehreCheckup() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Bitte geben Sie die Größe des Patienten (in cm) ein:");
            groesse = scanner.nextDouble();

            System.out.println("Bitte geben Sie das Gewicht des Patienten (in kg) ein:");
            gewicht = scanner.nextDouble();

            System.out.println("Bitte geben Sie die Temperatur des Patienten (in °C) ein:");
            temperatur = scanner.nextDouble();

            System.out.println("Ist der Patient geimpft? (Ja/Nein):");
            String impfStatus = scanner.next();
            geimpft = impfStatus.equalsIgnoreCase("Ja");

            scanner.close();
        }

        public double getGroesse() {
            return groesse;
        }

        public double getGewicht() {
            return gewicht;
        }

        public double getTemperatur() {
            return temperatur;
        }

        public boolean istGeimpft() {
            return geimpft;
        }
    }