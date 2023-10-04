package OOP_J2.Aufgabe2;
public class adressbuch {
        String name;
        String emailAdresse;
        String telefonnummer;
    public adressbuch(String name, String emailAdresse, String telefonnummer) {
        this.name = name;
        this.emailAdresse = emailAdresse;
        this.telefonnummer = telefonnummer;
    }
    public String getName() {
        return name;
    }
    public String getAll() {
        return name + emailAdresse + telefonnummer;
    }
}