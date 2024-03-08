"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var readline = require("readline");
var Person = /** @class */ (function () {
    function Person() {
        this.name = '';
    }
    Person.prototype.greetPerson = function () {
        var _this = this;
        var rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });
        rl.question(('Wie ist dein name?'), function (name) {
            _this.name = name;
            console.log("Hallo ".concat(_this.name));
            rl.question('War diese Aufgabe lehrreich für dich= [j / n]', function (response) {
                if (response === 'j') {
                    console.log('super');
                }
                else {
                    console.log('Schade! :(');
                }
                rl.close();
            });
        });
    };
    return Person;
}());
var personA = new Person();
personA.greetPerson();
// readline interface
// handle inputs
