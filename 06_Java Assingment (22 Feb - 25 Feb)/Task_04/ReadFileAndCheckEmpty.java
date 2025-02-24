package Task_04;
import java.io.File;
import java.util.Scanner;

/*
Write a Java program that reads a file and throws an exception if the file is empty.
*/

public class ReadFileAndCheckEmpty {
    public static void main(String[] args) {
        try {
            readFile("your_file_path_here.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile(String fileName) throws Exception {
        File file = new File(fileName);
        if (file.length() == 0) {
            throw new Exception("The file is empty.");
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
