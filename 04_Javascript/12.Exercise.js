// 12. Get 2 numbers. Display the multiplication table of the first number till second number. For example, if the numbers are 5 and 7, then the table should display from 5*1=5 to 5*7=35.
let firstNumber = 5;
let secondNumber = 7;

for (let i = 1; i <= secondNumber; i++) {
  console.log(firstNumber + " * " + i + " = " + (firstNumber * i));
}