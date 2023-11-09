package J4.dictionary_Test;

import J4.mockito.Dictionary;
import J4.mockito.DictionaryRepository;
import J4.mockito.DictionaryStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Dictionary_Test {

    @Mock
    DictionaryRepository repository;
    @InjectMocks
    Dictionary dictionary;

    @Test
    public void testAddWordNotInDatabase() {
        Mockito.when(repository.getDefinition("blau")).thenReturn(null);
        DictionaryStatus status = dictionary.addOrUpdateWord("blau", "Farbe");
        verify(repository,times(1)).add("blau", "Farbe");
        assertEquals(DictionaryStatus.ADDED, status);

    }

    @Test
    public void testUpdateWordInDatabase() {
        Mockito.when(repository.getDefinition("existingWord")).thenReturn("Alte Definition");
        DictionaryStatus status = dictionary.addOrUpdateWord("existingWord", "Neue Definition");
        verify(repository).update("existingWord", "Neue Definition");
        verify(repository,times(0)).add(any(), any());
        assertEquals(DictionaryStatus.UPDATED, status);
    }

    @Test
    public void testEmptyWord() {
        DictionaryStatus status = dictionary.addOrUpdateWord("", "Definition");
        assertEquals(DictionaryStatus.INVALID, status);
        verify(repository,times(0)).add("blau", "Farbe");
    }

    @Test
    public void testWordWithNumbers() {
        DictionaryStatus status = dictionary.addOrUpdateWord("wort123", "Definition");
        assertEquals(DictionaryStatus.INVALID, status);
        verify(repository,times(0)).add("blau", "Farbe");
    }

    @Test
    public void testGetDefinitionWordInDatabase() {
        Mockito.when(repository.getDefinition("existingWord")).thenReturn("Definition");
        String definition = dictionary.getDefinition("existingWord");
        verify(repository).getDefinition("existingWord");
        verify(repository,times(0)).add(any(), any());
        assertEquals("Definition", definition);
    }

    @Test
    public void testGetDefinitionWordNotInDatabase() {
        Mockito.when(repository.getDefinition("blau")).thenReturn(null);
        String definition = dictionary.getDefinition("blau");
        verify(repository).getDefinition("blau");
        verify(repository,times(0)).add(any(), any());
        assertEquals("Das Wort blau konnte im Wörterbuch nicht gefunden werden", definition);
    }

    @Test
    public void testGetDefinitionEmptyWord() {
        String definition = dictionary.getDefinition("");
        verify(repository, never()).getDefinition(anyString());
        verify(repository,times(0)).add(any(), any());
        assertEquals("Das Wort  konnte im Wörterbuch nicht gefunden werden", definition);
    }

    @Test
    public void testGetDefinitionWordWithNumbers() {
        String definition = dictionary.getDefinition("wort123");
        verify(repository, never()).getDefinition(anyString());
        verify(repository,times(0)).add(any(), any());
        assertEquals("Das Wort wort123 konnte im Wörterbuch nicht gefunden werden", definition);
    }
}
