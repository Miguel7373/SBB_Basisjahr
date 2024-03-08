const a = 10;
console.log(a);

function myFunction(a = 20) {
  console.log(a);

  if (true) {
    const a = 21;
    console.log(a);

    for (let a = 30; a < 33; a++) {
      console.log(a);
      for (let a = 40; a < 44; a++) {
        console.log(a);
      }
    }
    console.log(a);
  }
  console.log(a);
}

myFunction();

console.log(a)  ;
const  a = 11;
console.log(a);
