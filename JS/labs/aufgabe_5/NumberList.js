let numbersArray = [];

function addNumbers() {
  numbersArray = document.getElementById('numberInput').value.trim().split(',').map(Number);
  console.log(numbersArray);
}
function biggestNumber(){
  console.log(Math.max.apply(Math, numbersArray))
}
function smallestNumber(){
  console.log(Math.min.apply(Math, numbersArray))
}

function calculateSumEven() {
  let sumEven = 0;
  for (let i = 0; i < numbersArray.length; i++) {
    if (numbersArray[i] % 2 === 0) {
      sumEven += numbersArray[i];
    }
  }
  console.log(sumEven);
}
function calculateSumOdd() {
  let sumOdd = 0;
  for (let i = 0; i < numbersArray.length; i++) {
    if (numbersArray[i] % 2 !== 0) {
      sumOdd += numbersArray[i];
    }
  }
  console.log(sumOdd);
}
function sorted(){
  console.log(numbersArray.sort((a, b) => a - b));
}
function calculateSum(){
  const sum = numbersArray.reduce(function(accumulator, currentValue) {
    return accumulator + currentValue;
  });

  console.log(sum);
}
function average(){
  const sum = numbersArray.reduce(function(accumulator, currentValue) {
    return accumulator + currentValue;
  });
  const average = sum / numbersArray.length;
  console.log(average)
}
