// Nested Objects
myObj = {
  name: "John",
  age: 30,
  myCars: {
    car1: "Ford",
    car2: "BMW",
    car3: "Fiat"
  }
}

//var car = myObj.myCars.car3;
//console.log(car)

//console.log(myObj.myCars["car2"]);

//console.log(myObj["myCars"]["car2"]);

//let p1 = "myCars";
//let p2 = "car2";
//console.log(myObj[p1][p2]);

const person = {
  firstName: "John",
  lastName: "Doe",
  id: 5566,
  fullName: function () {
    return this.firstName + " " + this.lastName;
  }
};

//name = person.fullName();
//console.log("Full name: "+person.fullName())
console.log("fullName function definition: " + person.fullName);

// Adding functions to objects
person.name1 = function () {
  return this.firstName + " " + this.lastName;
};

person.name2 = function () {
  return (this.firstName + " " + this.lastName).toUpperCase();
};

//console.log(person.name1())
//console.log(person.name2())
console.log("name1 function definition: " + person.name1);
console.log("name2 function definition: " + person.name2);

/*
document.getElementById("demo").innerHTML = person;
 
document.getElementById("demo").innerHTML =
person.name + "," + person.age + "," + person.city;
*/

// Removing function from the object
delete person.name1;
