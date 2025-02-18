// 4.  Create a arrow function without parameters, to choose the operation among add, subtract, multiply and divide, using switch statement.
// On choosing the operation, it has to invoke the corresponding method (as expression) with parameters and display the results accordingly, like, sum for add, difference for subtract, product for multiply, quotient and reminder for divide

const performOperation = () => {
    let operation = "multiply";
    let num1 = 10;
    let num2 = 5;

    const add = (a, b) => a + b;
    const subtract = (a, b) => a - b;
    const multiply = (a, b) => a * b;
    const remainder = (a, b) => a % b;
    const quotient = (a, b) => a / b;
    
    switch (operation) {
        case "add":
            console.log(`Sum: ${add(num1, num2)}`);
            break;
        case "subtract":
            console.log(`Difference: ${subtract(num1, num2)}`);
            break;
        case "multiply":
            console.log(`Product: ${multiply(num1, num2)}`);
            break;
        case "divide":
            console.log(`Quotient: ${quotient(num1, num2)}`);
            console.log(`Remainder: ${remainder(num1, num2)}`);
            break;
        default:
            console.log("Invalid operation");
            break;
    }
};

performOperation();