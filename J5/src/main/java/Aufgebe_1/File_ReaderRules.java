package Aufgebe_1;

import java.util.List;
import java.util.Set;


public interface File_ReaderRules {

    int countAllWords(List<String> wordList);

    int countWordsWithQ(List<String> wordList);

    Set<Character> getUniqueSpecialCharacters(List<String> wordList);

    int countWordsWithMi(List<String> wordList);

    Set<Character> getAllCeracters(List<String> wordList);
}
