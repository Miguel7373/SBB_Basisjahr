package Aufgebe_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class File_Reader implements File_ReaderRules {
    public static void main(String[] args) {
        String filePath = "/home/mlehmann/Downloads/words.txt";
        File_ReaderRules wordProcessor = new File_Reader();
        try {
            List<String> wordList = readWordsFromFile(filePath);
            System.out.println("Gesamtanzahl der Wörter: " + wordProcessor.countAllWords(wordList));
            System.out.println("Anzahl der Wörter mit 'Q': " + wordProcessor.countWordsWithQ(wordList));
            System.out.println("Eindeutige Sonderzeichen: " + wordProcessor.getUniqueSpecialCharacters(wordList));
            System.out.println("Anzahl Wörter mit 'mi: '" + wordProcessor.countWordsWithMi(wordList));
            System.out.println("Alle Benuzten Buchstaben: " + wordProcessor.getAllCeracters(wordList));
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }

    private static List<String> readWordsFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new IOException("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }

    @Override
    public int countAllWords(List<String> wordList) {
        return wordList.size();
    }

    @Override
    public int countWordsWithQ(List<String> wordList) {
        return (int) wordList.stream().filter(word -> word.toLowerCase().contains("q")).count();
    }
    @Override
    public Set<Character> getUniqueSpecialCharacters(List<String> wordList) {
        return wordList.stream()
                .flatMapToInt(String::chars)
                .filter(i -> !Character.isLetterOrDigit(i))
                .mapToObj(l -> (char) l)
                .collect(Collectors.toSet());
    }
    @Override
    public int countWordsWithMi(List<String> wordList) {
        return (int) wordList.stream().filter(word -> word.toLowerCase().contains("mi")).count();
    }

    @Override
    public Set<Character> getAllCeracters(List<String> wordList) {
        return wordList.stream()
                .flatMapToInt(String::chars)
                .filter(Character::isLetter)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }
}