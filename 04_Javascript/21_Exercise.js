// 21. Without passing parameters, display the multiplication table with two variables , one variable for the number , and other for the limit.

function displayMultiplicationTable() {
    let number = 5;
    let limit = 10;

    for (let i = 1; i <= limit; i++) {
        console.log(`${number} x ${i} = ${number * i}`);
    }
}

displayMultiplicationTable(); 