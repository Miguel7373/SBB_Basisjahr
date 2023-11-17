package map.Aufgebe_1;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PLZProcessorTest {
    private PLZProcessor plzProcessor = new PLZProcessor();
    @Test
    void updateMinStrings() {
        int[] ints = new int[8];
        ints[1] = 1000000000;
        String[] strings = new String[8];
        plzProcessor.updateMinStrings("q", ints, strings);
        assertEquals("q", strings[1]);
    }

    @Test
    void updateMaxStrings() {
        int[] ints = new int[8];
        String[] strings = new String[8];
        plzProcessor.updateMaxStrings("test", ints, strings);
        assertEquals("test", strings[0]);
    }

    @Test
    void updateUniqueGemeinden10() {
        assertTrue(plzProcessor.updateUniqueGemeinden10("21111111111111111111112"));
    }


    @Test
    void updateUniqueGemeinden7() {
        assertTrue(plzProcessor.updateUniqueGemeinden7("Bahnhof"));
    }

    @Test
    void updateUniqueGemeindenEnt() {
        assertTrue(plzProcessor.updateUniqueGemeindenEnt("Ente"));
    }

    @Test
    void updateUniqueGemeinden3() {
        assertTrue(plzProcessor.updateUniqueGemeinden3("hey"));
    }

    @Test
    void updateBernMax() {
        int[] ints = new int[8];
        String[] strings = new String[8];
        plzProcessor.updateBernMax("123", "Bern", ints, strings);
        assertEquals("Bern", strings[7]);
    }

    @Test
    void updateBernMin() {
        int[] ints = new int[8];
        String[] strings = new String[8];
        plzProcessor.updateBernMin("123", "Bern", ints, strings);
        assertEquals("Bern", strings[6]);
    }

    @Test
    void sortAndJoinSet() {
        Set<String> set = Set.of("b", "a", "c");
        String result = plzProcessor.sortAndJoinSet(set);
        assertEquals("a, b, c", result);
    }
}
