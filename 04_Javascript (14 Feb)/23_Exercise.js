// 23. Pass a number, and find if the sum of their digits is an even or odd number

function sumOfDigitsEvenOrOdd(number) {
    let sum = 0;
    while (number > 0) {
        sum += number % 10;
        number = Math.floor(number / 10);
    }

    if (sum % 2 === 0) {
        console.log(`The sum of digits is ${sum}, which is even.`);
    } else {
        console.log(`The sum of digits is ${sum}, which is odd.`);
    }
}

const numForSum = 123;
sumOfDigitsEvenOrOdd(numForSum);