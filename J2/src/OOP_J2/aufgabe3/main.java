package OOP_J2.aufgabe3;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<String> viewList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        ArrayList<perosn> personenList = new ArrayList<>();
        perosn john = new perosn("john", " john4@gmail.com ", " 111222333 ", " year");
        personenList.add(john);
        perosn nevio = new perosn("nevio", " nevio.digennaro@gmail.com ", " 69696969 ", " year");
        personenList.add(nevio);
        perosn marc = new perosn("marc", " marc@nutzlos.com ", " 12345678 ", "year ");
        personenList.add(marc);

        ArrayList<film> filmList = new ArrayList<>();
        film barbie = new film("Barbie", " 1h 54 ", " fantasy comedy ", " Margot Robbie ");
        filmList.add(barbie);
        film oppenheimer = new film("Oppenheimer", " 3h ", "thriller", " Christopher Nolan ");
        filmList.add(oppenheimer);
        film elemental = new film("Elemental", " 1h 49m ", " Animation ", " Denise Ream ");
        filmList.add(elemental);
        label:
        while (true) {
            System.out.println("1 User");
            System.out.println("2 streaming platform");
            String auswahl = scanner.nextLine();
            switch (auswahl) {
                case "1":
                    System.out.println("username");
                    String input1 = scanner.nextLine();
                    for (int i = 0; i < personenList.size(); i++) {
                        if (input1.equals(personenList.get(i).getName())) {
                            System.out.println(personenList.get(i).getAllPerson());
                            System.out.println("1. set a view");
                            System.out.println("2. edit creditCard");
                            System.out.println("3. switch pay method");
                            String inputForPerson = scanner.nextLine();
                            switch (inputForPerson) {
                                case "1" -> {
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
                                }
                                case "2" -> {
                                    System.out.println("Enter new credit card number:");
                                    personenList.get(i).setCreditcard(scanner.nextLine());
                                    System.out.println("Credit card number updated successfully.");
                                }
                                case "3" -> {
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
                    }
                    break;
                case "2":
                    System.out.println("1. count of Abos");
                    System.out.println("2. Register");
                    System.out.println("3. delete account");
                    System.out.println("4. search film by name");
                    System.out.println("5. search film by genre");
                    System.out.println("6. Count of Views");
                    System.out.println("7. credit card of monthly supporters");
                    String streamingServiceSelection = scanner.nextLine();
                    switch (streamingServiceSelection) {
                        case "1" -> System.out.println("Anzahl Personen mit abo " + personenList.size());
                        case "2" -> {
                            System.out.println("gib einen neuen kontakt ein (Name/Email/creditcardnumber/pay Method)");
                            String input2 = scanner.nextLine();
                            String[] parts = input2.split("/");
                            perosn nevio2 = new perosn(parts[0], parts[1], parts[2], parts[3]);
                            personenList.add(nevio2);
                        }
                        case "3" -> {
                            System.out.println("Name");
                            String deleteAcc = scanner.nextLine();
                            for (int u = 0; u < personenList.size(); u++) {
                                if (deleteAcc.equals(personenList.get(u).getName())) {
                                    personenList.remove(personenList.get(u));
                                }
                            }
                        }
                        case "4" -> {
                            System.out.println("name");
                            String searchName = scanner.nextLine();
                            for (OOP_J2.aufgabe3.film film : filmList) {
                                if (searchName.equals(film.getFilmName())) {
                                    System.out.println(film.getAllFilm());
                                }
                            }
                        }
                        case "5" -> {
                            System.out.println("genre");
                            String searchGenre = scanner.nextLine();
                            for (OOP_J2.aufgabe3.film film : filmList) {
                                if (searchGenre.equals(film.getGenre())) {
                                    System.out.println(film.getAllFilm());
                                }
                            }
                        }
                        case "6" -> System.out.println(viewList.size());
                        case "7" -> {
                            for (OOP_J2.aufgabe3.perosn perosn : personenList) {
                                if (perosn.getAboArt().equals("month")) {
                                    System.out.println(perosn.getCreditcard());
                                }
                            }
                        }
                    }
                    break;
                case "exit":
                    break label;

            }
        }
    }
}