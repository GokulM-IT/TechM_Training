package Task_03;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;

/*
Write a Java program to read a plain text file.
*/

public class ReadPlainTextFile {
    public static void main(String[] args) {
        File file = new File("your_file_path_here");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}
