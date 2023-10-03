package Bibliothek;

public class Zeitschrift extends Media {
    private String publicationDate;
    private String editor;

    public Zeitschrift(String title, String publicationDate, String editor) {
        super(title);
        this.publicationDate = publicationDate;
        this.editor = editor;
    }


    public String getItemDetails() {
        return "Erscheinungsdatum: " + publicationDate + ", Editor: " + editor;
    }
}