// 10. Get the Maths score of a student. If the mark is 100, display "Phenomenal!" . Else if the mark is greater than 85, display "Excellent!". Else, if the mark is between 71 to 85, display "Good work!". Else, if the mark is between 51 to 70, display "Practice well!". Else, display "Hard work is needed

let mark = 49;

if (mark > 100) {
    console.log("Provide valid mark. Mark should be less than 100!");
}

if (mark == 100) {
    console.log("Phenomenal!");
} else if (mark > 85) {
    console.log("Excellent!");
} else if (mark >= 71 & mark <= 85) {
    console.log("Good work!");
} else if (mark >= 51 & mark <= 70) {
    console.log("Practice well!")
} else {
    console.log("Hard work is needed");
}

