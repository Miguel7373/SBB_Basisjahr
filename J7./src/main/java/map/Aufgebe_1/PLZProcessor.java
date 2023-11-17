package map.Aufgebe_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class PLZProcessor {
    private static Set<String> uniqueGemeinden10 = new HashSet<>();
    private static Set<String> uniqueGemeinden7 = new HashSet<>();
    private static Set<String> uniqueGemeindenEnt = new HashSet<>();
    private static Set<String> uniqueGemeinden3 = new HashSet<>();

    public static void main(String[] args) {

        PLZProcessor plzProcessor = new PLZProcessor();
        OutputValidation outputValidation = new OutputValidation();
        try {
            Map<String, String> plzData = readPLZData("/home/mlehmann/Downloads/Postleitzahlen_ISO-8859-1.csv");
              plzProcessor.processPLZData(plzData, outputValidation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  void processPLZData(Map<String, String> plzData, OutputValidation outputValidation) {
        int[] ints = new int[8];
        String[] strings = new String[8];
        ints[1] = 1000000000;
        ints[6] = 100000000;



        plzData.forEach((s, s2) -> {
            updateMaxStrings(s2, ints, strings);
            updateMinStrings(s2, ints, strings);
            updateUniqueGemeinden3(s2);
            updateUniqueGemeinden7(s2);
            updateUniqueGemeinden10(s2);
            updateUniqueGemeindenEnt(s2);
            updateBernMax(s, s2, ints, strings);
            updateBernMin(s, s2, ints, strings);
        });

        String sortedUniqueGemeinden3 = sortAndJoinSet(uniqueGemeinden3);
        printResults(plzData.size(), ints, strings, uniqueGemeinden10.size(), uniqueGemeinden7.size(),
                uniqueGemeindenEnt.size(), sortedUniqueGemeinden3, outputValidation);
    }

    public void updateMinStrings(String s2, int[] ints, String[] strings) {
        if (ints[1] > s2.length()) {
            ints[1] = s2.length();
            strings[1] = s2;
        } else if (ints[1] == s2.length() && s2.compareTo(strings[1]) < 0) {
            strings[1] = s2;
        }
    }

    public void updateMaxStrings(String s2, int[] ints, String[] strings) {
        if (ints[0] < s2.length()) {
            ints[0] = s2.length();
            strings[0] = s2;
        } else if (ints[0] == s2.length() && s2.compareTo(strings[0]) > 0) {
            strings[0] = s2;
        }
    }


    public boolean updateUniqueGemeinden10(String s2) {
        if (s2.length() > 10) {
            uniqueGemeinden10.add(s2);
        return true;
        }
        return false;
    }
    public boolean updateUniqueGemeinden7(String s2) {
        if (s2.length() == 7) {
            uniqueGemeinden7.add(s2);
            return true;
        }
        return false;
    }
    public boolean updateUniqueGemeindenEnt(String s2) {
        if (s2.contains("ent")|| s2.contains("Ent")) {
            uniqueGemeindenEnt.add(s2);
            return true;
        }
        return false;
    }
    public boolean updateUniqueGemeinden3(String s2) {
        if (s2.length() == 3) {
            uniqueGemeinden3.add(s2);
            return true;
        }
        return false;
    }

    public void updateBernMax(String s, String s2, int[] ints, String[] strings) {
        if (s2.equals("Bern")) {
            int plz = Integer.parseInt(s);
            if (plz > ints[7]) {
                ints[7] = plz;
                strings[7] = s2;
            }
        }
    }
// || s2.contains(" Bern")|| s2.contains("Bern ")
    public void updateBernMin(String s, String s2, int[] ints, String[] strings) {
        if ((s2.equals("Bern"))) {
            int plz = Integer.parseInt(s);
            if (plz < ints[6] || ints[6] == 0) {
                ints[6] = plz;
                strings[6] = s2;
            }
        }
    }
    public String sortAndJoinSet(Set<String> set) {
        return set.stream()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    private static void printResults(int size, int[] ints, String[] strings, int uniqueGemeinden10Size,
                                     int uniqueGemeinden7Size, int uniqueGemeindenEntSize, String sortedUniqueGemeinden3,
                                     OutputValidation outputValidation) {
        outputValidation.logAndPrint("- Anzahl PLZ: " + size);
        outputValidation.logAndPrint("- Kleinste PLZ der Gemeinde Bern: " + ints[6] + " " + strings[6]);
        outputValidation.logAndPrint("- Grösste PLZ der Gemeinde Bern: " + ints[7] + " " + strings[7]);
        outputValidation.logAndPrint("- Anzahl Gemeinden mit mehr als 10 Buchstaben: " + uniqueGemeinden10Size);
        outputValidation.logAndPrint("- Anzahl Gemeinden mit 7 Buchstaben: " + uniqueGemeinden7Size);
        outputValidation.logAndPrint("- Anzahl Gemeinden mit der Buchstabenfolge 'ent': " + uniqueGemeindenEntSize);
        outputValidation.logAndPrint("- Gemeinden mit 3 Buchstaben: " + sortedUniqueGemeinden3);
        outputValidation.logAndPrint("- Anzahl Buchstaben der kleinsten Gemeinden: " + ints[1]);
        outputValidation.logAndPrint("- Kleinsten Gemeinden: " + strings[1]);
        outputValidation.logAndPrint("- Anzahl Buchstaben der grössten Gemeinden: " + ints[0]);
        outputValidation.logAndPrint("- Grössten Gemeinden: " + strings[0]);

        outputValidation.verifyControlHash(1768988137);
        outputValidation.printControlHash();
    }

    static Map<String, String> readPLZData(String filePath) throws IOException {
        Map<String, String> plzData = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            String[] lost;
            while ((line = br.readLine()) != null) {
                line = processLine(line);
                String[] parts = line.split("%");
                if (!parts[1].substring(0, 1).equals(",")) {
                    lost = parts[1].split(", ");
                } else {
                    lost = new String[]{parts[1]};
                }
                if (parts.length >= 2) {
                    plzData.put(parts[0], lost[0]);
                }
            }
        }
        return plzData;
    }

    static String processLine(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        stringBuilder.deleteCharAt(4);
        stringBuilder.replace(4, 4, "%");
        line = String.valueOf(stringBuilder);
        line = line.replaceAll("\"", "");
        return line;
    }
}