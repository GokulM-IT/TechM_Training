// 11. Get the day of a week and perform the following using switch statement. If it's Monday, display "Start of the week!" If it's Tuesday, Wednesday or Thursday, display "Mid of the week!" If it's Friday, display "Last working day of the week!" If it's Saturday, display "WeekEnd - Saturday!" If it's Sunday, display "WeekEnd - Sunday!" If the input is not a day of the week, display "Invalid input!".

let dayOfWeek = "Tuesday";

switch (dayOfWeek) {
  case "Monday":
    console.log("Start of the week!");
    break;
  case "Tuesday":
  case "Wednesday":
  case "Thursday":
    console.log("Mid of the week!");
    break;
  case "Friday":
    console.log("Last working day of the week!");
    break;
  case "Saturday":
    console.log("WeekEnd - Saturday!");
    break;
  case "Sunday":
    console.log("WeekEnd - Sunday!");
    break;
  default:
    console.log("Invalid input!");
}
