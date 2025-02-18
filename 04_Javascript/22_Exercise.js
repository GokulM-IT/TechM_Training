// 22. Pass a parameter, and display the factors of that parameter in the function

function displayFactors(number) {
    console.log(`Factors of ${number}:`);
    for (let i = 1; i <= number; i++) {
        if (number % i === 0) {
            console.log(i);
        }
    }
}

const numForFactors = 12;
displayFactors(numForFactors);