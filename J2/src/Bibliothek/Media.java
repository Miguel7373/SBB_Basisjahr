package Bibliothek;

public class Media {
    private String title;

    public Media(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getItemDetails() {
        return ""; // Implement details for each specific media type
    }
}