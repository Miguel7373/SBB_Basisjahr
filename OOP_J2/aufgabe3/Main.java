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
        Perosn nevio = new Perosn("nevio", " nevio.digennaro@gmail.com ", " 69696969 ", " year");
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
                        System.out.println("1. set a view");
                        System.out.println("2. edit creditCard");
                        System.out.println("switch pay method");
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


                        } else if (inputForPerson.equals("2")) {
                            System.out.println("Enter new credit card number:");
                            personenList.get(i).setCreditcard(scanner.nextLine());
                            System.out.println("Credit card number updated successfully.");

                        } else if (inputForPerson.equals("3")) {
                            System.out.println("zahlungmethode ändern");
                            String paymethod = scanner.nextLine();
                            if (paymethod.equals("year")) {
                                personenList.get(i).setAboArt("year");

                            } else if (paymethod.equals("month")) {
                                personenList.get(i).setAboArt("month");

                            }


                        }

                    }
                }
            } else if (auswahl.equals("2")) {
                System.out.println("1. count of Abos");
                System.out.println("2. Register");
                System.out.println("3. delete account");
                System.out.println("4. search film by name");
                System.out.println("5. search film by genre");
                System.out.println("6. Count of Views");
                System.out.println("7. credit card of monthly supporters");
                String streamingServiceSelection = scanner.nextLine();
                if (streamingServiceSelection.equals("1")) {
                    System.out.println("Anzahl Personen mit abo " + personenList.size());
                } else if (streamingServiceSelection.equals("2")) {
                    System.out.println("gib einen neuen kontakt ein (Name/Email/creditcardnumber/pay Method)");
                    String input2 = scanner.nextLine();
                    String[] parts = input2.split("/");
                    Perosn nevio2 = new Perosn(parts[0], parts[1], parts[2], parts[3]);
                    personenList.add(nevio2);
                } else if (streamingServiceSelection.equals("3")) {
                    System.out.println("Name");
                    String deletacc = scanner.nextLine();
                    for (int u = 0; u < personenList.size(); u++) {
                        if (deletacc.equals(personenList.get(u).getName())) {
                            personenList.remove(personenList.get(u));
                        }
                    }
                } else if (streamingServiceSelection.equals("4")) {
                    System.out.println("name");
                    String searchName = scanner.nextLine();
                    for (int i = 0; i < filmList.size(); i++) {
                        if (searchName.equals(filmList.get(i).getFilmName())) {
                            System.out.println(filmList.get(i).getAllFilm());
                        }
                    }
                } else if (streamingServiceSelection.equals("5")) {
                    System.out.println("genre");
                    String searchGenre = scanner.nextLine();
                    for (int o = 0; o < filmList.size(); o++){
                        if (searchGenre.equals(filmList.get(o).getGenre())){
                            System.out.println(filmList.get(o).getAllFilm());
                        }
                    }

                } else if (streamingServiceSelection.equals("6")) {
                    System.out.println(viewList.size());

                } else if (streamingServiceSelection.equals("7")) {
                    for (int g = 0; g < personenList.size(); g++){
                        if (personenList.get(g).getAboArt().equals("month"))
                        System.out.println(personenList.get(g).getCreditcard());

                    }

                }
            }
        }
    }
}