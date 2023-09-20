package OOP_J2.aufgabe4;
import java.util.Scanner;
import static OOP_J2.aufgabe4.ausfürungen.*;
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
}