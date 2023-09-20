package OOP_J2.Aufgabe1;

import java.util.Scanner;

public class patient {
        String name;
        public patient(String name) {
            this.name = name;
        }
        public static patient john(){
            patient john = new patient ("john");
            return john;
        }
        public static double checkUpHeight() {
            Scanner scanner = new Scanner(System.in);
            double height = 0;
            boolean running = true;
            while (running) {
                System.out.println("Grösse eingeben");
                String proof = scanner.nextLine();
                if (proof.matches("\\d")) {
                    System.out.println("ERROR 404 invalid Number");
                }
                if (!proof.matches("\\D")) {
                    height = Double.parseDouble(proof);
                    break;
                }
            }
            return height;
        }
        public static double checkUpTemparatur() {
            Scanner scanner = new Scanner(System.in);
            double temparatur = 0;
            boolean running = true;
            while (running == true) {
                System.out.println("Temparatur eingeben");
                String proof = scanner.nextLine();
                if (proof.matches("\\D")) {
                    System.out.println("ERROR 404 invalid Number");
                }
                if (!proof.matches("\\d")) {
                    temparatur = Double.parseDouble(proof);
                    running = false;
                }
            }
            return temparatur;
        }
        public static String checkUpGeimpft(){
            Scanner sc = new Scanner(System.in);
            boolean running = true;
            String geimpft = null;
            while (running) {
                System.out.println("Geimpf yes = y no = n");
                String proof = sc.nextLine();
                if (proof.equals("y") || proof.equals("n")) {
                    geimpft = proof;
                    running = false;
                }else {
                    System.out.println("Invalid");
                }
            }
            return geimpft;
        }
        public static double checkUpWeight() {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            double weight = 0;
            while (running) {
                System.out.println("Gewicht eingeben");
                String proof = scanner.nextLine();
                if (proof.matches("\\D")) {
                    System.out.println("ERROR 404 invalid Number");
                }
                if (!proof.matches("\\d")) {
                    weight = Double.parseDouble(proof);
                    running = false;
                }
            }
            return weight;
        }
        public static String outPrint(){
            return outPrint();
        }
    }

