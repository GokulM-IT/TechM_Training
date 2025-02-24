package Task_02;
import java.util.Scanner;

/*
Create a class named Employee with the following details:
* empId :: int
* empName :: String
* sal :: double
Methods
getEmployeeDetails()
setEmployeeDetails()
getLoanEligibility()
check if the employee is eligible to get loan. The conditions are:
* an employee should have worked for greater than 5 years.
* If his /her annual salary is 6 lakhs then 2 lakhs of loan is granted.
* If his/her annual salary is >=10 lakhs then 5 lakhs of loan is granted.
* If his/her annual salary is >=15 lakhs then 7 lakhs of loan is granted.
*/

public class Employee {
    private int empId;
    private String empName;
    private double sal;
    private int yearsWorked;

    public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    public void getEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Salary: " + sal);
        System.out.println("Years Worked: " + yearsWorked);
    }

    public void getLoanEligibility() {
        if (yearsWorked > 5) {
            if (sal >= 15_00_000) {
                System.out.println("Eligible for a loan of 7 Lakhs");
            } else if (sal >= 10_00_000) {
                System.out.println("Eligible for a loan of 5 Lakhs");
            } else if (sal >= 6_00_000) {
                System.out.println("Eligible for a loan of 2 Lakhs");
            } else {
                System.out.println("Not eligible for a loan");
            }
        } else {
            System.out.println("Not eligible for a loan, must have worked for more than 5 years.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee employee = new Employee();

        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double sal = scanner.nextDouble();

        System.out.print("Enter Years Worked: ");
        int yearsWorked = scanner.nextInt();

        employee.setEmployeeDetails(empId, empName, sal, yearsWorked);

        System.out.println("\nEmployee Details:");
        employee.getEmployeeDetails();

        System.out.println("\nLoan Eligibility:");
        employee.getLoanEligibility();
    }
}
