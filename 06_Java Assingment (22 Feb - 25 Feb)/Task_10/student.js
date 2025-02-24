let student = {
    name: "John",
    age: 20,
    grade: "A",
    introduce: function() {
        console.log("Hello, I am " + this.name + ", " + this.age + " years old, and my grade is " + this.grade);
    },
    address: {
        city: "New York",
        country: "USA",
        getAddress: function() {
            console.log("I live in " + this.city + ", " + this.country);
        }
    }
};

student.introduce();
student.address.getAddress();

student.address.getCountry = function() {
    console.log("I live in " + this.country);
};

delete student.age;
delete student.address.getAddress;

console.log(student);
student.introduce();
