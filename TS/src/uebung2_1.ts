class Person {

    private name: string;

    constructor(name: string) {
        this.name = name;
    }

    introduceSelf() {
        console.log('Hallo, mein name ist ' + this.name)
    }


}

class Friend {
    private years: any;

    constructor(years: number) {
        this.years = years
    }

    timeKnown() {
        console.log(`Wir sind Freunde seit ${this.years} Jahren`)
    }
}

const person1 = new Person("Peter")
const friend = new Friend(5)
person1.introduceSelf()
friend.timeKnown()

