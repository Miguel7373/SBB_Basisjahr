package OOP_J2.aufgabe3;

public class Film {
    String filmName;
    String dauer;
    String genre;
    String produzenten;

    public Film(String filmName, String dauer, String genre, String produzenten) {
        this.filmName = filmName;
        this.dauer = dauer;
        this.genre = genre;
        this.produzenten = produzenten;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getDauer() {
        return dauer;
    }

    public String getGenre() {
        return genre;
    }

    public String getProduzenten() {
        return produzenten;
    }
    public String getAllFilm(){
        return filmName + dauer + genre + produzenten;
    }
}
