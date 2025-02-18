// 13. Get 2 numbers. Have the third number as second number + 40. Using while loop, display the multiples of first number from second number to third number.

let firstNumber = 7;
let secondNumber = 20;
let thirdNumber = secondNumber + 40;

let currentNumber = secondNumber;

while (currentNumber <= thirdNumber) {
  if (currentNumber % firstNumber === 0) {
    console.log(currentNumber);
  }
  currentNumber++;
}