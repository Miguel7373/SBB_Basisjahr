package labs_J1;

public class aufgabe6 {
    public static StringBuilder flip(String word){
        StringBuilder fliptWord = new StringBuilder(word);
        fliptWord.reverse();
        return fliptWord;
    }
    public static int zaehleWoerter(String text) {
        String[] woerter = text.split(" ");
        return woerter.length;
    }
    public static void main(String[] args) {
        System.out.println(zaehleWoerter("Hallo welt"));
        System.out.println(flip("Hallo"));

    }
}
