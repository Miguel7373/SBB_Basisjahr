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
            while (true) {
                System.out.println("Grösse eingeben");
                String inputHeight = scanner.nextLine();
                if (inputHeight.matches("\\d")) {
                    System.out.println("ERROR 404 invalid Number");
                }
                if (!inputHeight.matches("\\D")) {
                    height = Double.parseDouble(inputHeight);
                    break;
                }
            }
            return height;
        }
        public static double checkUpTemparatur() {
            Scanner scanner = new Scanner(System.in);
            double temparatur = 0;
            while (true) {
                System.out.println("Temparatur eingeben");
                String inputTemp = scanner.nextLine();
                if (inputTemp.matches("\\D")) {
                    System.out.println("ERROR 404 invalid Number");
                }
                if (!inputTemp.matches("\\d")) {
                    temparatur = Double.parseDouble(inputTemp);
                    break;
                }
            }
            return temparatur;
        }
        public static String checkUpGeimpft(){
            Scanner sc = new Scanner(System.in);
            String geimpft = null;
            while (true) {
                System.out.println("Geimpf yes = y no = n");
                String inputImpfung = sc.nextLine();
                if (inputImpfung.equals("y") || inputImpfung.equals("n")) {
                    geimpft = inputImpfung;
                    break;
                }else {
                    System.out.println("Invalid");
                }
            }
            return geimpft;
        }
        public static double checkUpWeight() {
            Scanner scanner = new Scanner(System.in);
            double weight = 0;
            while (true) {
                System.out.println("Gewicht eingeben");
                String inputWeight = scanner.nextLine();
                if (inputWeight.matches("\\D")) {
                    System.out.println("ERROR 404 invalid Number");
                }
                if (!inputWeight.matches("\\d")) {
                    weight = Double.parseDouble(inputWeight);
                    break;
                }
            }
            return weight;
        }
        public static String outPrint(){
            return outPrint();
        }
    }

