package Bibliothek;

public class CD {
        private String artist;
        private int numberOfSongs;

        public CD(String artist, int numberOfSongs) {
            this.artist = artist;
            this.numberOfSongs = numberOfSongs;
        }

        public String toString() {
            return "CD: Interpret=" + artist + ", Anzahl der Songs=" + numberOfSongs;
        }
}
