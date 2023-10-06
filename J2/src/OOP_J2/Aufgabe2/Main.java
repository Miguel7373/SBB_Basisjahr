package OOP_J2.Aufgabe2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book Options");
            System.out.println("1. Add a contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Remove a contact by email");
            System.out.println("4. Show number of contacts");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email address: ");
                    String email = scanner.nextLine();
                    boolean emailExists = false;
                    for (int i = 0; i < addressBook.getNumberOfContacts(); i++) {
                        AddressBook existingPerson = addressBook.getContactAtIndex(i);
                        if (email.equals(existingPerson.getEmail())) {
                            emailExists = true;
                            break;
                        }
                    }
                    if (emailExists) {
                        System.out.println("Eine Person mit dieser E-Mail-Adresse existiert bereits im Adressbuch.");
                    } else {
                        System.out.print("Phone number: ");
                        String phoneNumber = scanner.nextLine();
                        AddressBook person = new AddressBook(name, email, phoneNumber);
                        addressBook.addNewContact(person);
                        System.out.println("Kontakt Added.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the name to search for a contact: ");
                    String searchName = scanner.nextLine();
                    AddressBook foundContact = addressBook.findContactByName(searchName);
                    if (foundContact != null) {
                        System.out.println("Contact found:");
                        System.out.println("Name: " + foundContact.getName());
                        System.out.println("Email: " + foundContact.getEmail());
                        System.out.println("Phone Number: " + foundContact.getPhoneNumber());
                    } else {
                        System.out.println("No contact found with this name.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the email address to remove a contact ");
                    String emailToRemove = scanner.nextLine();
                    addressBook.removeContactByEmail(emailToRemove);
                    break;
                case 4:
                    int numberOfContacts = addressBook.getNumberOfContacts();
                    System.out.println("Number of contacts in the address book " + numberOfContacts);
                    break;
                case 5:
                    System.out.println("Exiting the address book.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}