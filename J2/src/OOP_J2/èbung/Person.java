package OOP_J2.èbung;


enum Gender {
    Male, Female, Divers
}

public class Person {
    String name;
    String birthdate;
    Gender gender;

    public Person(String name, String birthdate, Gender gender) {
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
}
