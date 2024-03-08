function calculateAverage(array: number[]): number {
    if (!Array.isArray(array)) {
        throw new Error('Not an array')
    }
    if (array.length === 0) {
        return NaN;
    }
    let sum = 0;
    for (let i = 0; i < array.length; i++) {
        if (typeof array[i] !== 'number') {
            throw new Error('Not a number')
        }
        sum += array[i];
    }
    return sum / array.length
}

const numberArray: number[] = [1, 2, 3, 4]
console.log(calculateAverage(numberArray))