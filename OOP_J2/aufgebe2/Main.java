package OOP_J2.aufgebe2;
import javax.naming.Name;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Adressbuch> kontaktList = new ArrayList<>();
        Adressbuch john = new Adressbuch("john", "john@stud.com", "079 555 89 69");
        kontaktList.add(john);
        Adressbuch nevio = new Adressbuch("nevio", "nevio@stud.com", "079 666 34 69");
        kontaktList.add(nevio);
        Adressbuch marc = new Adressbuch("marc", "marc@stud.com", "079 777 98 69");
        kontaktList.add(marc);
        Adressbuch loris = new Adressbuch("loris", "loris@stud.com", "079 222 45 69");
        kontaktList.add(loris);
        while (true) {


            Scanner scanner = new Scanner(System.in);
            System.out.println("1 Anzahl der Kontakte im Adressbuch");
            System.out.println("2 Kontakt hinzufügen");
            System.out.println("3 Kontakt suchen mit namen");
            System.out.println("4 Kontakt Löschen");
            String auswahl = scanner.nextLine();


            if (auswahl.equals("1")) {
                System.out.println(kontaktList.size());
            } else if (auswahl.equals("2")) {
                System.out.println("gib einen neuen kontakt ein ()");
                String input2 = scanner.nextLine();
                String[] parts = input2.split(" ");
                Adressbuch nevio2 = new Adressbuch(parts[0], parts[1], parts[2]);
                kontaktList.add(nevio2);


            } else if (auswahl.equals("3")) {
                System.out.println("Name");
                String input3 = scanner.nextLine();
                for (int i = 0; i < kontaktList.size(); i++) {

                    if (input3.equals(kontaktList.get(i).getName())) {
                        System.out.println(kontaktList.get(i).getAll());
                    }

                }

            } else if (auswahl.equals("4")) {
                System.out.println("Name");
                String input4 = scanner.nextLine();
                for (int j = 0; j < kontaktList.size(); j++) {
                    if (input4.equals(kontaktList.get(j).getName()))
                    kontaktList.remove(j);
                }


            } else if (auswahl.contains("exit")){
                break;
            }
        }
    }
}
