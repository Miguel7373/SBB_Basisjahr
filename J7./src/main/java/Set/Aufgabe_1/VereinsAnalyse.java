package Set.Aufgabe_1;

import java.util.HashSet;
import java.util.Set;

public class VereinsAnalyse {
    public static void main(String[] args) {
        OutputValidation OutputValidation = new OutputValidation();
        // Vereinsmitglieder
        Set<String> fussballVerein = Set.of("Emil", "Hans", "Felix", "Fritz", "Patrick", "Hanne", "Anja", "Paula", "Petra", "Anna");

        Set<String> schwimmVerein = Set.of("Emil", "Klaus", "Paul", "Fritz", "Patrick", "Hanne", "Anina", "Nicole", "Petra", "Gerda");

        Set<String> musikVerein = Set.of("Kari", "Hans", "Max", "Karin", "Petra", "Anna");

        Set<String> tanzVerein = Set.of("Emil", "Hans", "Paul", "Felix", "Max", "Lara", "Anja", "Sabine", "Anna");

        Set<String> atLeastInOneClub = new HashSet<>();
        atLeastInOneClub.addAll(fussballVerein);
        atLeastInOneClub.addAll(schwimmVerein);
        atLeastInOneClub.addAll(musikVerein);
        atLeastInOneClub.addAll(tanzVerein);

        Set<String> membersWithMinMembers = new HashSet<>();

        for (Set<String> club : Set.of(fussballVerein, schwimmVerein, musikVerein, tanzVerein)) {
            membersWithMinMembers.addAll(club);

        }
        String appelsaft = membersWithMinMembers.stream().sorted().toList().toString().replaceAll(" ", "");


        OutputValidation.logAndPrint("- Wie viele Personen machen min. in einem Verein mit: " + membersWithMinMembers.size() + ": " + appelsaft.substring(1, appelsaft.length() - 1));

        Set<String> inFussballAndTanz = new HashSet<>(fussballVerein);
        inFussballAndTanz.retainAll(tanzVerein);

        String nevioHund = inFussballAndTanz.stream().sorted().toList().toString().replaceAll(" ", "");


        OutputValidation.logAndPrint("- Alle Personen, welche im Fussball und Tanz Verein sind: " + inFussballAndTanz.size() + ": " + nevioHund.substring(1, nevioHund.length()-1));

        Set<String> inFussballNotInTanzOrSchwimm = new HashSet<>(fussballVerein);
        inFussballNotInTanzOrSchwimm.removeAll(tanzVerein);
        inFussballNotInTanzOrSchwimm.removeAll(schwimmVerein);

        String kaugumi = inFussballNotInTanzOrSchwimm.stream().sorted().toList().toString().replaceAll(" ", "");


        OutputValidation.logAndPrint("- Alle Personen, welche im Fussball sind und nicht im Tanz oder Schwimm Verein: "+ + inFussballNotInTanzOrSchwimm.size() + ": " + kaugumi.substring(1, kaugumi.length() -1));

        OutputValidation.printControlHash();
        OutputValidation.verifyControlHash(-1421274666);
    }
}