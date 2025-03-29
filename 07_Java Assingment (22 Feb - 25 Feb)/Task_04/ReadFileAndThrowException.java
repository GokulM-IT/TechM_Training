package Task_04;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Write a Java program to create a method that reads a file and throws an exception if the file is not found.
*/

public class ReadFileAndThrowException {
    public static void main(String[] args) {
        try {
            readFile("nonexistent_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
