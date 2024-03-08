class Person1 {
    private name: string;

    constructor(name: string) {
        this.name = name;
    }

    introduceSelf() {
        console.log("Hallo, mein name ist " + this.name)
    }
}

let person = new Person1("Hansli");
person.introduceSelf();