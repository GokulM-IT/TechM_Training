// 8. Get the price of 1 kg tomato from Monday to Sunday, find its average. If the average is greater than Rs.50, then display, tomato has given good profit. If not, display "No profit from tomato".

let weekPrices = [233, 322, 401, 50, 20, 19, 55];
let sum = weekPrices.reduce((prev, curr) => prev + curr, 0);

let average = sum / weekPrices.length;

let isProfit = (average > 50) ? "Tomato has given good profit" : "No profit from Tomato";

console.log(isProfit)
