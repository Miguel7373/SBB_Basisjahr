package Bibliothek;

public class Zeitschrift {
    private String datum;
    private String herausgeber;

    public Zeitschrift(String datum, String herausgeber) {
        this.datum = datum;
        this.herausgeber = herausgeber;
    }
    public String toString(){
        return "Zeitschrift: Datum=" + datum + ",Herausgeber=" + herausgeber;
    }
}
