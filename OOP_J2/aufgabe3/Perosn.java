package OOP_J2.aufgabe3;

public class Perosn {
    String name;
    String email;
    String creditcard;

    public Perosn(String name, String email, String creditcard) {
        this.name = name;
        this.email = email;
        this.creditcard = creditcard;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditcard() {
        return creditcard;
    }
    public String getAllPerson(){
        return name + email + creditcard;
    }
}
