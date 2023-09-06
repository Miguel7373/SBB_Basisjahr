package OOP_J2.aufgabe3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> viewList = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);
            ArrayList<Perosn> personenList = new ArrayList<>();
            Perosn john = new Perosn("john", " john4@gmail.com ", " 111222333 ", " year");
            personenList.add(john);
            Perosn nevio = new Perosn("nevio", " nevio.digennaro@gmail.com ", " 69696969 "," year" );
            personenList.add(nevio);
            Perosn marc = new Perosn("marc", " marc@nutzlos.com ", " 12345678 ", "year ");
            personenList.add(marc);

            ArrayList<Film> filmList = new ArrayList<>();
            Film barbie = new Film("Barbie", " 1h 54 ", " fantasy comedy ", " Margot Robbie ");
            filmList.add(barbie);
            Film oppenheimer = new Film("Oppenheimer", " 3h ", "thriller", " Christopher Nolan ");
            filmList.add(oppenheimer);
            Film elemental = new Film("Elemental", " 1h 49m ", " Animation ", " Denise Ream ");
            filmList.add(elemental);
        while (true) {

            System.out.println("1 User");
            System.out.println("2 streaming platform");
            String auswahl = scanner.nextLine();
            if (auswahl.equals("1")) {
                System.out.println("username");
                String input1 = scanner.nextLine();
                for (int i = 0; i < personenList.size(); i++) {
                    if (input1.equals(personenList.get(i).getName())) {
                        System.out.println(personenList.get(i).getAllPerson());
                        System.out.println("1 set a view");
                        System.out.println("2 edit creditCard");
                        String inputForPerson = scanner.nextLine();
                        if (inputForPerson.equals("1")) {
                            System.out.println("choose Film");
                            String inputFilm = scanner.nextLine();
                            for (int j = 0; j < personenList.size(); j++) {
                                if (inputFilm.equals(filmList.get(j).getFilmName())) {
                                    System.out.println(filmList.get(j).getAllFilm());
                                    String gg = filmList.get(j).getFilmName();
                                    viewList.add(gg);
                                    System.out.println(input1 + " " + viewList);
                                }
                            }


                        }else if (inputForPerson.equals("2")) {
                            System.out.println("Enter new credit card number:");
                            personenList.get(i).setCreditcard(scanner.nextLine());
                            System.out.println("Credit card number updated successfully.");

                        } else if (inputForPerson.equals("3")) {
                            System.out.println("zahlungmethode ändern");
                            String paymethed = scanner.nextLine();
                            if (paymethed.equals("year")){
                                personenList.get(i).setAboArt("year");
                                
                            } else if (paymethed.equals("month")) {
                                personenList.get(i).setAboArt("month");
                                
                            }


                        }
                    }
                }
            }
        }
    }
}