function calculateAverage(array) {
    if (!Array.isArray(array)) {
        throw new Error('Not an array');
    }
    if (array.length === 0) {
        return NaN;
    }
    var sum = 0;
    for (var i = 0; i < array.length; i++) {
        if (typeof array[i] !== 'number') {
            throw new Error('Not a number');
        }
        sum += array[i];
    }
    return sum / array.length;
}
var numberArray = [1, 2, 3, 4];
console.log(calculateAverage(numberArray));
