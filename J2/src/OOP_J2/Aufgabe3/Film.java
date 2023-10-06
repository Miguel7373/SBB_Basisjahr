package OOP_J2.Aufgabe3;

import java.util.ArrayList;

public class Film {
        private String name;
        private int duration;
        private String genre;
        private String producer;
        private int views;

        public Film(String name, int duration, String genre, String producer) {
            this.name = name;
            this.duration = duration;
            this.genre = genre;
            this.producer = producer;
            this.views = 0;
        }

        public String getName() {
            return name;
        }

        public int getDuration() {
            return duration;
        }

        public String getGenre() {
            return genre;
        }

        public String getProducer() {
            return producer;
        }

        public int getViews() {
            return views;
        }
        public String getAllString(){
            return name + producer + genre;
        }

        public void markAsViewed() {
            views++;
        }
    public static ArrayList<Film> filmData() {
        ArrayList<Film> filmlist = new ArrayList<>();
        Film hehe = new Film("HEHE", 100, "Action", "Miguel");
        Film gg = new Film("GG", 120, "Action", "Miguel");
        filmlist.add(hehe);
        StreamingService.addFilm(hehe);

        filmlist.add(gg);
        return filmlist;
    }



}
