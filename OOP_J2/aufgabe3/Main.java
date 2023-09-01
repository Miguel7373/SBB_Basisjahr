package OOP_J2.aufgabe3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Perosn> personenList = new ArrayList<>();
        Perosn john = new Perosn("john ", "john4@gmail.com ", "111222333");
        Perosn nevio = new Perosn("nevio ", "navio,digennaro@gmail.com", "69696969");
        Perosn marc = new Perosn("Marc", "marc@nutzlos.com", "12345678");

        ArrayList<Film> filmList = new ArrayList<>();
        Film barbie = new Film("Barbie", "1h 54", "fantasy comedy", "Margot Robbie");
        Film oppenheimer = new Film("Oppenheimer", "3h", "thriller", "Christopher Nolan");
        Film elemental = new Film("Elemental", "1h 49m", "Animation", "Denise Ream");

            System.out.println("Login");
            String name = scanner.nextLine();
            for (int i = 0; i < personenList.size(); i++) {
                if (name.equals(personenList.get(i).getName())) {
                    System.out.println(personenList.get(i).getAllPerson());

                }


                }
            }
    }
