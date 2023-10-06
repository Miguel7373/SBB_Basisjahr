package OOP_J2.èbung;
import java.time.LocalDate;


public class Vertrag {
    LocalDate startDatum;
    LocalDate endDatum;
    double monatlicherPreis;
    Mieter mieter;
    Wohnung wohnung;

    public Vertrag(LocalDate startDatum, LocalDate endDatum, double monatlicherPreis, Mieter mieter, Wohnung wohnung) {
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.monatlicherPreis = monatlicherPreis;
        this.mieter = mieter;
        this.wohnung = wohnung;
    }
}
