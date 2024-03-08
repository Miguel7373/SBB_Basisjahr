"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function calculateAverage(array) {
    if (!Array.isArray(array)) {
        throw new Error('Du hund ja');
    }
    if (array.length === 0) {
        return NaN;
    }
    var summe = 0;
    for (var i = 0; i < array.length; i++) {
        if (typeof array[i] !== 'number') {
            throw new Error('Nur zahlen du hund');
        }
        summe += array[i];
    }
    return summe / array.length;
}
var numberArray = [1, 2, 3, 4];
console.log(calculateAverage(numberArray));
