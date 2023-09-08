package OOP_J2.aufgebe2;

public class Adressbuch {
        String name;
        String emailAdresse;
        String telefonnummer;

    public Adressbuch(String name, String emailAdresse, String telefonnummer) {
        this.name = name;
        this.emailAdresse = emailAdresse;
        this.telefonnummer = telefonnummer;


    }

    public String getName() {
        return name;
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }
    public String getAll() {
        return name + emailAdresse + telefonnummer;
    }

}

