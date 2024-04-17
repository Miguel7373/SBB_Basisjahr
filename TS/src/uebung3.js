"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var readline = require("readline");
var Person = /** @class */ (function () {
    function Person() {
        this.name = '';
    }
    Person.prototype.greetPerson = function () {
        var _this = this;
        var readLine = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });
        readLine.question(('Wie ist dein name?'), function (name) {
            _this.name = name;
            console.log("Hallo ".concat(_this.name));
            readLine.question('War diese Aufgabe lehrreich für dich= [j / n]', function (response) {
                if (response === 'j') {
                    console.log('super');
                }
                else {
                    console.log('Schade! :(');
                }
                readLine.close();
            });
        });
    };
    return Person;
}());
var person = new Person();
person.greetPerson();
