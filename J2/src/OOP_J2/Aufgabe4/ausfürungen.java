package OOP_J2.Aufgabe4;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import static OOP_J2.Aufgabe4.wohnung.*;
import static OOP_J2.Aufgabe4.immobilien.*;
import static OOP_J2.Aufgabe4.mieter.*;
import static OOP_J2.Aufgabe4.vertrag.*;

public class ausfürungen {
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
        int resultFirmaEinnamen = 0;
        LocalDate Jahr = LocalDate.of(2023, Month.DECEMBER , 31);
        for (int k = 0; k < vertrag().size() ; k++) {
            if (vertrag().get(k).endDate.isBefore(Jahr)){
                int monthsUntilEndOfYear = (int) ChronoUnit.MONTHS.between(vertrag().get(k).endDate, Jahr);
                int monthlycostoveryear = 12 - monthsUntilEndOfYear;
                int montlycost = vertrag().get(k).monthlyCosts * monthlycostoveryear;
                resultFirmaEinnamen = montlycost + resultFirmaEinnamen;

            }else{
                int fimaEinnhamen = vertrag().get(k).monthlyCosts;
                int endEinNameProWohnung = fimaEinnhamen * 12;
                resultFirmaEinnamen = endEinNameProWohnung + resultFirmaEinnamen;
            }



        }
        System.out.println(resultFirmaEinnamen);
    }
}


