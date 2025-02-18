// 3. Create a variable as const, check if its a prime number or not, and display the result accordingly
const numberToCheck = 17;
let isPrime = true;

if (numberToCheck < 2) {
    isPrime = false;
} else {
    for (let i = 2; i < numberToCheck; i++) {
        if (numberToCheck % i === 0) {
            isPrime = false;
            break;
        }
    }
}

if (isPrime) {
    console.log(numberToCheck + " is a prime number.");
} else {
    console.log(numberToCheck + " is not a prime number.");
}
