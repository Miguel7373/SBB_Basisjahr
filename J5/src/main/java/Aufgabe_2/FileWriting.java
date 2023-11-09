package Aufgabe_2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriting {
    private static final String LOG_FILE = "application.log";

    public static void log(String text) {
        try {
            writeToFile(text);

            System.out.println(text);
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben des Logs: " + e.getMessage());
        }
    }

    private static void writeToFile(String text) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(text);
        }
    }

    public static void main(String[] args) {
        log("Dies ist ein Beispiel-Logeintrag.");
    }
}

