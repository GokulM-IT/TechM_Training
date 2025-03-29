// 14. Get 2 numbers with interval 30. Display the values from the first number to the second number, and stop displaying if any multiple of 7 comes.

let startNumber = 10;
let endNumber = 40;

for (let i = startNumber; i <= endNumber; i++) {
  if (i % 7 === 0) {
    break;
  }
  console.log(i);
}