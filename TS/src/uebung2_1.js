var Person = /** @class */ (function () {
    function Person(name) {
        this.name = name;
    }
    Person.prototype.introduceSelfB = function () {
        console.log("Hallo, mein name ist " + this.name);
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
var personB = new Person("Peter");
var friendA = new Friend(5);
personB.introduceSelfB();
friendA.timeKnown();
