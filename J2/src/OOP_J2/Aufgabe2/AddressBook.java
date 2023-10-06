package OOP_J2.Aufgabe2;


import java.util.ArrayList;

public class AddressBook {
    private String name;
    private String email;
    private String phoneNumber;

    public AddressBook(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    private ArrayList<AddressBook> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public int getNumberOfContacts() {
        return contacts.size();
    }

    public void addNewContact(AddressBook person) {
        contacts.add(person);
    }

    public AddressBook findContactByName(String name) {
        for (AddressBook contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void removeContactByEmail(String email) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getEmail().equalsIgnoreCase(email)) {
                contacts.remove(i);
                System.out.println("Contact with email address " + email + " has been removed.");
                return;
            }
        }
        System.out.println("No contact found with email address " + email + ".");
    }
    public AddressBook getContactAtIndex(int index) {
        if (index >= 0 && index < contacts.size()) {
            return contacts.get(index);
        }
        return null;
    }
}

