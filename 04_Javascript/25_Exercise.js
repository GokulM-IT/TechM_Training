// 25. Create a object called student with properties id, name, department, college and email.Write a function to access the properties and display them. Invoke the function to display the details
// Write another function to access the properties id, name and email and display them. Invoke the function to display the details
// Add a property called address, as another object, with properties as doorNo, street, area and pin_code
// Add a function to display the details of the student with address.
// Delete the property email and the function created to display id, name and email.

const student = {
    id: 101,
    name: "John Doe",
    department: "Computer Science",
    college: "XYZ University",
    email: "johndoe@example.com",
    address: {
        doorNo: "123",
        street: "Main St.",
        area: "Downtown",
        pin_code: "123456"
    }
};

function displayStudentDetails() {
    console.log("Student Details:");
    console.log(`ID: ${student.id}`);
    console.log(`Name: ${student.name}`);
    console.log(`Department: ${student.department}`);
    console.log(`College: ${student.college}`);
    console.log(`Email: ${student.email}`);
    console.log(`Address: ${student.address.doorNo}, ${student.address.street}, ${student.address.area}, pin_code: ${student.address.pin_code}`);
}

displayStudentDetails();

function displayBasicDetails() {
    console.log("Basic Details:");
    console.log(`ID: ${student.id}`);
    console.log(`Name: ${student.name}`);
    console.log(`Email: ${student.email}`);
}

displayBasicDetails();

function displayStudentWithAddress() {
    console.log("Student Details with Address:");
    console.log(`ID: ${student.id}`);
    console.log(`Name: ${student.name}`);
    console.log(`Address: ${student.address.doorNo}, ${student.address.street}, ${student.address.area}, pin_code: ${student.address.pin_code}`);
}

displayStudentWithAddress();

delete student.email;
delete displayBasicDetails;

console.log("After Deleting Email and Basic Details Function:");
console.log(student);
