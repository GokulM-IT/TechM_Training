package Task_04;
import java.io.File;
import java.util.Scanner;

/*
Write a Java program that reads a list of numbers from a file and throws an exception if any of the numbers are positive.
*/

public class ReadNumbersAndThrowException {
    public static void main(String[] args) {
        try {
            readNumbersFromFile("numbers.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readNumbersFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number > 0) {
                throw new Exception("Positive number encountered: " + number);
            }
        }
        scanner.close();
    }
}
