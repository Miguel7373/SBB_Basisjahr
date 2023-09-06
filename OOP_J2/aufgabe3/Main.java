package OOP_J2.aufgabe3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Perosn> personenList = new ArrayList<>();
        Perosn john = new Perosn("john ", "john4@gmail.com ", "111222333");
        personenList.add(john);
        Perosn nevio = new Perosn("nevio ", "nevio.digennaro@gmail.com", "69696969");
        personenList.add(nevio);
        Perosn marc = new Perosn("Marc", "marc@nutzlos.com", "12345678");
        personenList.add(marc);

        ArrayList<Film> filmList = new ArrayList<>();
        Film barbie = new Film("Barbie", "1h 54", "fantasy comedy", "Margot Robbie");
        filmList.add(barbie);
        Film oppenheimer = new Film("Oppenheimer", "3h", "thriller", "Christopher Nolan");
        filmList.add(oppenheimer);
        Film elemental = new Film("Elemental", "1h 49m", "Animation", "Denise Ream");
        filmList.add(elemental);


        System.out.println("1 Nutzer");
        System.out.println("2 streaming dienst");
        String auswahl = scanner.nextLine();
        if (auswahl.equals("1")) {
            System.out.println("username");
            String input1 = scanner.nextLine();
            for (int i = 0; i < personenList.size(); i++){
                if (input1.equals(personenList.get(i).getName()))
                    System.out.println(personenList.get(i).getAllPerson());
            }
        }
    }
}