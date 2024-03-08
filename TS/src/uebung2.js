var Person = /** @class */ (function () {
    function Person(name) {
        this.name = name;
    }
    Person.prototype.introduceSelf = function () {
        console.log("Hallo, mein name ist" + this.name);
    };
    return Person;
}());
var personA = new Person("Hansli");
personA.introduceSelf();
