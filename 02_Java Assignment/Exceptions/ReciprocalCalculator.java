package exception;

import java.util.Scanner;

public class ReciprocalCalculator {
    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");

        try {
            String userInput = scanner.nextLine();
            double number = Double.parseDouble(userInput);

            if (number == 0) {
                throw new ArithmeticException("Cannot calculate reciprocal of zero.");
            }

            double reciprocal = 1 / number;
            System.out.println("The reciprocal of " + number + " is " + reciprocal);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        processInput();
    }
}
