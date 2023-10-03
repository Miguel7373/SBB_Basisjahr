package Bibliothek;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        execution();
    }

    public static void execution() {
        Scanner scanner = new Scanner(System.in);
        Library<Media> medienBibliothek = new Library<>();

        medienBibliothek.addItem("Das Buch 1", new Book("","Autor 1", "Genre 1"));
        medienBibliothek.addItem("Das Buch 2", new Book("","Autor 2","Genre 2"));
        medienBibliothek.addItem("CD 1", new CD("", "hehe",10));
        medienBibliothek.addItem("CD 2", new CD("", "big man",12));
        medienBibliothek.addItem("Zeitschrift 1", new Zeitschrift("","12.2.2023", "Peter"));
        medienBibliothek.addItem("Zeitschrift 2", new Zeitschrift("","12.2.2023", "Josef"));
        medienBibliothek.addItem("DVD 1", new DVD("","Action", "John"));
        medienBibliothek.addItem("DVD 2", new DVD("","Romance", "Kuga"));

        while (true) {
            System.out.println("Wähle aus:\n1: Inventar anzeigen\n2: Ausleihe\n3: Rückgabe");
            String auswahl = scanner.nextLine();
            switch (auswahl) {
                case "1":
                    medienBibliothek.listInventory();
                    break;
                case "2":
                    System.out.println("Wähle ein Medium aus (Name): ");
                    String mediumName = scanner.nextLine();
                    LibraryItem<Media> medium = medienBibliothek.getItem(mediumName);
                    if (medium != null) {
                        if (!medium.isCheckedOut()) {
                            System.out.println("Möchtest du das Medium ausleihen (ja/nein): ");
                            String ausleihStatus = scanner.nextLine();
                            if (ausleihStatus.equals("ja")) {
                                medium.checkOut();
                                System.out.println("Das Medium wurde ausgeliehen.");
                            } else {
                                System.out.println("Die Ausleihe wurde abgebrochen.");
                            }
                        } else {
                            System.out.println("Das Medium ist bereits ausgeliehen.");
                        }
                    } else {
                        System.out.println("Das Medium wurde nicht gefunden.");
                    }
                    break;
                case "3":
                    System.out.println("Gib den Namen des zurückzugebenden Mediums ein: ");
                    String mediumName2 = scanner.nextLine();
                    LibraryItem<Media> medium2 = medienBibliothek.getItem(mediumName2);
                    if (medium2 != null) {
                        if (medium2.isCheckedOut()) {
                            medium2.returnItem();
                            System.out.println("Das Medium wurde zurückgegeben.");
                        } else {
                            System.out.println("Das Medium ist nicht ausgeliehen und kann nicht zurückgegeben werden.");
                        }
                    } else {
                        System.out.println("Das Medium wurde nicht gefunden.");
                    }
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte wähle erneut.");
                    break;
            }
        }
    }
}