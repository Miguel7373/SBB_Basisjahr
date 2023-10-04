package Bibliothek;

public class CD extends Media {
    private String artist;
    private int numberOfTracks;
    public CD(String title, String artist, int numberOfTracks) {
        super(title);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }
    public String getItemDetails() {
        return "Interpret: " + artist + ", Anzahl der Tracks: " + numberOfTracks;
    }
}