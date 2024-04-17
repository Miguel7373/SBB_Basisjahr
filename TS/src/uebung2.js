var Person1 = /** @class */ (function () {
    function Person1(name) {
        this.name = name;
    }
    Person1.prototype.introduceSelf = function () {
        console.log("Hallo, mein name ist " + this.name);
    };
    return Person1;
}());
var person = new Person1("Hansli");
person.introduceSelf();
