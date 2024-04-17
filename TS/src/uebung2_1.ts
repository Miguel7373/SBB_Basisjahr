class Person {

    private name: string;

    constructor(name: string) {
        this.name = name;
    }

    introduceSelf() {
        console.log('Hallo, mein name ist ' + this.name)
    }
}

class Friend extends Person{
    private years: any;


    constructor(name: string, years: any) {
        super(name);
        this.years = years;
    }

    timeKnown() {
        console.log(`Wir sind Freunde seit ${this.years} Jahren`)
    }
}

const person1 = new Person("Peter")
const friend = new Friend("Fridoline", 5)
friend.introduceSelf()
friend.timeKnown()

