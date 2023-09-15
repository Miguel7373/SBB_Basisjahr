package OOP_J2.aufgabe4;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import static OOP_J2.aufgabe4.wohnung.*;
import static OOP_J2.aufgabe4.immobilien.*;
import static OOP_J2.aufgabe4.mieter.*;
import static OOP_J2.aufgabe4.vertrag.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wähle aus" + "\n" + "1. alle wohnungen" + "\n" + "2. Zuständiger abwart" + "\n" + "3. Verträge zu immobilien" + "\n" + "4. Leere Wohungen in bestimmter immo" + "\n" + "5. Ablaufende mieten in einem monat " + "\n" + "6. Verträge nach Person" + "\n" + "7. monathliches einkommen immo" + "\n" + "8. Einkommen Firma");
        String auswahl = scanner.nextLine();
        switch (auswahl) {
            case "1" -> System.out.println(anzahlwohnungen());
            case "2" -> abwart();
            case "3" -> bestimmteVerträge();
            case "4" -> leereWohnungen();
            case "5" -> ablaufendeVerträge();
            case "6" -> verträgeProPerson();
            case "7" -> einkommenProImmo();
            case "8" -> einkommenFirma();
        }
    }
    public static String anzahlwohnungen() {
        String big = String.valueOf(wohnung().size());
        return (big + " wohnungen existieren");
    }
    public static void abwart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wohnung");
        String input1 = scanner.nextLine();
        for (int i = 0; i < wohnung().size(); i++) {
            if (input1.equals(wohnung().get(i).name)) {
                for (int j = 0; j < immobilenData().size(); j++) {
                    if (input1.contains(immobilenData().get(j).name)) {
                        System.out.println(immobilenData().get(j).hausmeister);
                    }
                }
                break;
            }
        }
    }
    public static void bestimmteVerträge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("immmo");
        String immo = scanner.nextLine();
        for (int i = 0; i < immobilenData().size(); i++) {
            if (immo.equals(immobilenData().get(i).name)) {
                for (int r = 0; r < wohnung().size(); r++) {
                    if (wohnung().get(r).getName().contains(immo)) {
                        for (int e = 0; e < vertrag().size(); e++) {
                            if (vertrag().get(e).specificApartment.equals(wohnung().get(r).name)) {
                                System.out.println(vertrag().get(e).getAll());
                            }
                        }

                    }
                }
            }
        }
    }
    public static void leereWohnungen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("in welcher immo willst du nach lehren wohnungen suchen");
        String immo2 = scanner.nextLine();
        for (int i = 0; i < immobilenData().size(); i++) {
            if (immo2.equals(immobilenData().get(i).name)) {
                for (int v = 0; v < wohnung().size() ; v++) {
                    if (wohnung().get(v).name.contains(immobilenData().get(i).name) && wohnung().get(v).mieter.equals(" ")){
                        System.out.println(wohnung().get(v).getAllWohnung());
                    }
                }
            }
        }
    }
    public static void ablaufendeVerträge(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ablaufende verträge");
        LocalDate date = LocalDate.now();
        LocalDate month = date.plusMonths(1);
        for (int i = 0; i < vertrag().size(); i++) {
            if (vertrag().get(i).endDate.isAfter(date) && vertrag().get(i).endDate.isBefore(month)) {
                System.out.println(vertrag().get(i).besitzer);
            }
        }
    }
    public static void verträgeProPerson(){
        for (int g = 0; g < mieter().size() ; g++) {
            for (int p = 0; p < vertrag().size() ; p++) {
                if (mieter().get(g).name.equals(vertrag().get(p).besitzer)){
                    System.out.println(mieter().get(g).name + vertrag().get(p).getAll());
                }
            }
        }
    }
    public static void einkommenProImmo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("in welcher immo willst du nach lehren wohnungen suchen");
        String imput = scanner.nextLine();
        int result = 0;
        for (int p = 0; p < immobilenData().size() ; p++) {
            if (imput.equals(immobilenData().get(p).name)){
                for (int u = 0; u < vertrag().size(); u++) {
                    if (vertrag().get(u).specificApartment.contains(immobilenData().get(p).name)) {
                        result = vertrag().get(u).monthlyCosts + result;
                    }
                }
            }
        }
        System.out.println(result + "CHF");
    }
    public static void einkommenFirma(){
        int fimaEinnhamen  = 0;
        LocalDate Jahr = LocalDate.of(2024, Month.JANUARY , 1);
        for (int k = 0; k < vertrag().size() ; k++) {
            if (vertrag().get(k).endDate.isBefore(Jahr)){



            }else{
                 fimaEinnhamen = vertrag().get(k).monthlyCosts * 12;
                System.out.println(fimaEinnhamen);
            }


        }
    }
}