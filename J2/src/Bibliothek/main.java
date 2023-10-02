package Bibliothek;
import java.util.Scanner;
import static Bibliothek.Library.*;
public class main {
    public static void main(String[] args) {
        ausführung();
    }

    public static void ausführung() {
        Scanner scanner = new Scanner(System.in);
        Library<Book> bibliothek = new Library<>();

        bibliothek.addItem("Das Buch 1", new Book("Autor 1", "Genre 1"));
        bibliothek.addItem("Das Buch 2", new Book("Autor 2", "Genre 2"));

        Library<CD> cdBibliothek = new Library<>();

        cdBibliothek.addItem("CD 1", new CD("Interpret 1", 10));
        cdBibliothek.addItem("CD 2", new CD("Interpret 2", 12));

        Library<Zeitschrift> zeitschriftBibliotek = new Library<>();

        zeitschriftBibliotek.addItem("Zeitschrift 1", new Zeitschrift("12.2.2023", "Peter"));
        zeitschriftBibliotek.addItem("Zeitschrift 2", new Zeitschrift("12.2.2023", "Josef"));

        Library<DVD> DVDBibliotek = new Library<>();

        DVDBibliotek.addItem("DVD 1", new DVD("Action", "John"));
        DVDBibliotek.addItem("DVD 2", new DVD("Romance", "Kuga"));


        bibliothek.checkOutItem("Das Buch 1");
        cdBibliothek.checkOutItem("CD 2");
        zeitschriftBibliotek.checkOutItem("Zeitschrift 2");
        DVDBibliotek.checkOutItem("DVD 2");
        DVDBibliotek.returnItem("DVD 2");
        while (true) {


            System.out.println("wähle aus \n1: Inventar");
            String auswahl = scanner.nextLine();

            switch (auswahl) {
                case "1" -> {
                    bibliothek.listInventory();
                    zeitschriftBibliotek.listInventory();
                    cdBibliothek.listInventory();
                    DVDBibliotek.listInventory();
                }
                case "2" -> {
                    System.out.println("Wähle ein Buch aus (Name): ");
                    String buchName = scanner.nextLine();
                    LibraryItem<Book> buch = checkOutItem.item.getTitel;


                    if (buch != null) {
                        System.out.println("willst du das bich reservieren (ja/nein): ");
                        String reservierungsStatus = scanner.nextLine();

                        if (reservierungsStatus.equals("ja")) {
                            buch.isCheckedOut();
                            System.out.println("Das Buch wurde reserviert.");
                        } else {
                            System.out.println("Die Buchreservierung wurde aufgehoben.");
                        }
                    } else {
                        System.out.println("Das Buch wurde nicht gefunden.");
                    }
                }
            }
        }
    }
}