// 15. Get 2 numbers with interval 50. Display the values from the first number to the second number, but skip displaying the multiples of 5.

let startNum = 10;
let endNum = 60;

for (let i = startNum; i <= endNum; i++) {
  if (i % 5 === 0) {
    continue;
  }
  console.log(i);
}