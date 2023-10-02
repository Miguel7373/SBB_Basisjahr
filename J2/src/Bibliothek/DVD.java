package Bibliothek;
public class DVD {
    private String Genre;
    private String Regisseur;

    public DVD(String genre, String regisseur) {
        Genre = genre;
        Regisseur = regisseur;
    }
    public String toString(){
        return "DVD: Genre=" + Genre + ",Regisseur=" + Regisseur;
    }
}