package Bibliothek;
public class DVD extends Media {
    private String genre;
    private String director;

    public DVD(String title, String genre, String director) {
        super(title);
        this.genre = genre;
        this.director = director;
    }


    public String getItemDetails() {
        return "Genre: " + genre + ", Regisseur: " + director;
    }
}
