package OOP_J2.Aufgabe3;

public class perosn {
    String name;
    String email;
    String creditcard;
    String aboArt;

    public perosn(String name, String email, String creditcard, String aboArt) {
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