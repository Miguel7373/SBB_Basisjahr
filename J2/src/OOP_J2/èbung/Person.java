package OOP_J2.èbung;

import java.util.ArrayList;

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
        this.gender = Gender.Male;
    }
}
