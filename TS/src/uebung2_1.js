var Person = /** @class */ (function () {
    function Person(name) {
        this.name = name;
    }
    Person.prototype.introduceSelf = function () {
        console.log('Hallo, mein name ist ' + this.name);
    };
    return Person;
}());
var Friend = /** @class */ (function () {
    function Friend(years) {
        this.years = years;
    }
    Friend.prototype.timeKnown = function () {
        console.log("Wir sind Freunde seit ".concat(this.years, " Jahren"));
    };
    return Friend;
}());
var person1 = new Person("Peter");
var friend = new Friend(5);
person1.introduceSelf();
friend.timeKnown();
