package OOP_J2.Aufgabe3;

import java.util.ArrayList;
import java.util.List;

import static OOP_J2.Aufgabe3.Film.*;


public class StreamingService {
    private List<Person> subscribers;
    private static List<Film> films;

    public StreamingService() {
        subscribers = new ArrayList<>();
        films = new ArrayList<>();
    }

    public int getNumberOfSubscribers() {
        return subscribers.size();
    }
    public void registerPerson(Person person) {
        if (!isEmailUnique(person.getEmail())) {
            System.out.println("Error: Email address already registered.");
        } else {
            subscribers.add(person);
            System.out.println("Person registered successfully.");
        }
    }
    public void removePerson(String email) {
        for (Person person : subscribers) {
            if (person.getEmail().equalsIgnoreCase(email)) {
                subscribers.remove(person);
                System.out.println("Person removed successfully.");
                return;
            }
        }
        System.out.println("Error: Person with email not found.");
    }
    public String findFilmByName(String name) {
        for (int i = 0; i < filmData().size(); i++) {
            Film film = filmData().get(i);
            if (film.getName().equals(name)) {
                return filmData().get(i).getAllString(); // Return the entire Film object
            }
        }
        return null; // Film not found
    }
    public ArrayList<String> findFilmsByGenre(String genre) {
        ArrayList<String> filmByGenre = new ArrayList<>();
        for (int l = 0; l < filmData().size() ; l++) {
            if (filmData().get(l).getGenre().equals(genre)) ;
            filmByGenre.add(filmData().get(l).getAllString());
        }
        return filmByGenre;
    }

    public Film findFilmByNameForView(String name) {
        for (Film film : films) {
            if (film.getName().equalsIgnoreCase(name)) {
                return film; // Return the entire Film object
            }
        }
        return null; // Film not found
    }

    public int getViewsForFilm(String filmName) {
        Film film = findFilmByNameForView(filmName);
        if (film != null) {
            return film.getViews();
        }
        return 0; // Film not found
    }

    public void displayMonthlyCreditCards() {
        System.out.println("\nMonthly Subscribers' Credit Cards:");
        for (Person person : subscribers) {
            if (person.getSubscriptionType() == SubscriptionType.MONTHLY_SUBSCRIBER) {
                System.out.println("Name: " + person.getName());
                System.out.println("Credit Card: " + person.getCreditCard());
                System.out.println();
            }
        }
    }

    private boolean isEmailUnique(String email) {
        for (Person person : subscribers) {
            if (person.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFilmNameUnique(String name) {
        for (Film film : films) {
            if (film.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }
    public static void addFilm(Film film) {
        if (isFilmNameUnique(film.getName())) {
            films.add(film);
        }
    }

}

