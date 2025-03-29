// Creating objects in single line
const employee = {
  firstName: "John",
  lastName: "Doe",
  age: 50,
  eyeColor: "blue"
};

console.log(employee)

// Creating objects in multiple line
// Create an Object
const person = {};

// Add Properties
person.firstName = "John";
person.lastName = "Doe";
person.age = 50;
person.eyeColor = "blue";
console.log(person)

// Accessing the members of the objects
let age = person.age;
console.log(person.firstName + " is " + person.age + " years old.");

// let age = person["age"];
// console.log(person["firstName"] + " is " + person["age"] + " years old.");

let x = "firstName";
let y = "age";
console.log(person[x] + " is " + person[y] + " years old.");

// Adding property to the object
person.nationality = "English";
console.log(person);

// Removing property from the object
delete person.age;
console.log(person);