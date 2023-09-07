package OOP_J2.aufgabe3;

public class Perosn {
    String name;
    String email;
    String creditcard;
    String aboArt;

    public Perosn(String name, String email, String creditcard, String aboArt) {
        this.aboArt = aboArt;
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
        return name + email + creditcard + aboArt;
    }

    public String getAboArt() {
        return aboArt;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;

    }

    public void setAboArt(String aboArt) {
        this.aboArt = aboArt;
    }
}