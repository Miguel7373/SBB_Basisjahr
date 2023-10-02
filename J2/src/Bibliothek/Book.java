package Bibliothek;

public class Book {
    private String author;
    private String genre;

    public Book(String author, String genre) {
        this.author = author;
        this.genre = genre;
    }


    public String toString() {
        return "Buch: Autor=" + author + ", Genre=" + genre;
    }
}
