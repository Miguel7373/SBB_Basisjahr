package Bibliothek;

public class Book extends Media {
    private String author;
    private String genre;

    public Book(String title, String author, String genre) {
        super(title);
        this.author = author;
        this.genre = genre;
    }


    public String getItemDetails() {
        return "Autor: " + author + ", Genre: " + genre;
    }
}