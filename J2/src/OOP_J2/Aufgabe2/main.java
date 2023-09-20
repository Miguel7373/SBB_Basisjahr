package OOP_J2.Aufgabe2;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        patientData();

    }
    public static String patientData() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<adressbuch> kontaktList = new ArrayList<>();
        adressbuch john = new adressbuch("john", "john@stud.com", "079 555 89 69");
        kontaktList.add(john);
        adressbuch nevio = new adressbuch("nevio", "nevio@stud.com", "079 666 34 69");
        kontaktList.add(nevio);
        adressbuch marc = new adressbuch("marc", "marc@stud.com", "079 777 98 69");
        kontaktList.add(marc);
        adressbuch loris = new adressbuch("loris", "loris@stud.com", "079 222 45 69");
        kontaktList.add(loris);
        while (true) {



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
                adressbuch nevio2 = new adressbuch(parts[0], parts[1], parts[2]);
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
        return patientData();
    }





}
